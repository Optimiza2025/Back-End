package optimiza.backend.Service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import optimiza.backend.Domain.Candidato
import optimiza.backend.Domain.NivelFormacao
import optimiza.backend.Domain.Vaga
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class MatchService(
    private val candidatoService: CandidatoService,
    private val vagaService: VagaService,
    private val candidaturaService: CandidaturaService
) {

    fun processarMatchParaVaga(idVaga: Int) {
        println("Procurando pela Vaga")
        val vaga = vagaService.encontrarVagaPorId(idVaga)
            ?: throw IllegalArgumentException("Vaga não encontrada para o ID $idVaga")

        val palavrasChave = vaga.palavrasChave ?: emptyList()

        println("Procurando candidatos por Palavras Chaves")
        val candidatos = candidatoService.buscarCandidatosPorPalavrasChave(palavrasChave)

        if (candidatos.isEmpty()) {
            println("Nenhum candidato encontrado com as palavras-chave da vaga ${vaga.id}.")
            return
        }

        println("Antes do looping de marcar o score na Candidatura")
        candidatos.forEach { candidato ->
            val detalhes = calcularDetalhesMatch(vaga, candidato)
            val scoreFinal = detalhes.values.average().toBigDecimal()

            println("Candidato ${candidato.nome} -> Score: ${(scoreFinal.multiply(BigDecimal(100))).toInt()}% Detalhes: $detalhes")

            candidaturaService.salvarOuAtualizarCandidatura(
                vaga = vaga,
                candidato = candidato,
                matching = scoreFinal,
                matches = detalhes
            )
        }
    }

    fun calcularDetalhesMatch(vaga: Vaga, candidato: Candidato): Map<String, Double> {
        val detalhes = mutableMapOf<String, Double>()

        detalhes["cargo"] =  compararCargoFlexivel(vaga, candidato)
        detalhes["formacao"] = compararFormacao(vaga.nivelFormacao, candidato.nivelFormacao)
        detalhes["experiencia"] = compararExperiencia(vaga.experiencia, candidato.experiencia)
        detalhes["idiomas"] = compararIdiomas(vaga.idiomas, parseIdiomasJson(candidato.idiomas))
        detalhes["palavras_chave"] = compararPalavrasChave(vaga.palavrasChave ?: emptyList(), candidato)
        detalhes["curso"] =
            if (vaga.curso != null && candidato.curso?.contains(vaga.curso!!, true) == true) 1.0 else 0.0
        detalhes["instituicao_ensino"] = compararInstituicaoEnsino(vaga.instituicaoEnsino, candidato.instituicaoEnsino)

        detalhes["titulo"] =
            if (vaga.titulo != null && candidato.curriculo?.contains(vaga.titulo!!, true) == true) 1.0 else 0.0

        return detalhes
    }

    private fun compararCargoFlexivel(vaga: Vaga, candidato: Candidato): Double {
        val textoVaga = ("${vaga.titulo ?: ""} ${vaga.cargo ?: ""}").trim().replace("\\s+".toRegex(), " ")
        val cargoCandidato = candidato.cargo?.trim()?.replace("\\s+".toRegex(), " ")

        if (textoVaga.isBlank() || cargoCandidato.isNullOrBlank()) {
            return 0.0
        }

        //Tenta encontrar um grupo de sinônimos para a vaga e para o candidato
        val grupoVaga = encontrarGrupoDeSinonimos(textoVaga)
        val grupoCandidato = encontrarGrupoDeSinonimos(cargoCandidato)

        // Se ambos pertencem a um grupo, e o grupo é o MESMO, é um match semântico!
        if (grupoVaga != null && grupoVaga == grupoCandidato) {
            return 1.0
        }

        // Se não encontrou via sinônimos, usa a lógica original de contenção (fallback)
        val textoVagaLower = textoVaga.lowercase()
        val cargoCandidatoLower = cargoCandidato.lowercase()

        return if (textoVagaLower.contains(cargoCandidatoLower) || cargoCandidatoLower.contains(textoVagaLower)) {
            1.0
        } else {
            0.0
        }
    }

    private fun compararFormacao(vagaFormacao: NivelFormacao?, candFormacao: NivelFormacao?): Double {
        val niveis = listOf(
            NivelFormacao.Ensino_fundamental_completo,
            NivelFormacao.Ensino_medio_incompleto,
            NivelFormacao.Ensino_medio_completo,
            NivelFormacao.Ensino_superior_cursando,
            NivelFormacao.Ensino_superior_completo,
            NivelFormacao.Pos_graduacao,
            NivelFormacao.Mestrado,
            NivelFormacao.Doutorado
        )
        val vagaIndex = niveis.indexOf(vagaFormacao)
        val candIndex = niveis.indexOf(candFormacao)
        return if (vagaIndex == -1 || candIndex == -1) 0.0 else if (candIndex >= vagaIndex) 1.0 else 0.0
    }

    private fun compararInstituicaoEnsino(vagaInstituicoes: String?, candInstituicao: String?): Double {
        if (vagaInstituicoes.isNullOrBlank() || candInstituicao.isNullOrBlank()) {
            return 0.0
        }

        val listaVaga = vagaInstituicoes.split(",").map { it.trim().lowercase() }
        val instituicaoCandidatoLower = candInstituicao.lowercase()

        val match = listaVaga.any { instituicaoDaVaga -> instituicaoCandidatoLower.contains(instituicaoDaVaga) }

        return if (match) 1.0 else 0.0
    }

    private fun compararExperiencia(vagaExp: String?, candExp: String?): Double {
        val vagaNum = vagaExp?.filter { it.isDigit() }?.toIntOrNull() ?: 0
        val candNum = candExp?.filter { it.isDigit() }?.toIntOrNull() ?: 0
        return if (candNum >= vagaNum) 1.0 else 0.0
    }

    private fun compararIdiomas(vagaIdiomas: Map<String, String>?, candIdiomas: Map<String, String>?): Double {
        if (vagaIdiomas.isNullOrEmpty() || candIdiomas.isNullOrEmpty()) return 0.0
        var acertos = 0
        vagaIdiomas.forEach { (idioma, nivelExigido) ->
            val nivelCand = candIdiomas[idioma]
            if (nivelCand != null && nivelCand >= nivelExigido) acertos++
        }
        return acertos.toDouble() / vagaIdiomas.size
    }

    private fun compararPalavrasChave(palavrasVaga: List<String>, candidato: Candidato): Double {
        if (palavrasVaga.isEmpty()) return 0.0
        val textoCandidato = listOfNotNull(
            candidato.experiencia,
            candidato.cargo,
            candidato.curso,
            candidato.curriculo
        ).joinToString(" ").lowercase()

        val acertos = palavrasVaga.count { textoCandidato.contains(it.lowercase()) }
        return acertos.toDouble() / palavrasVaga.size
    }

    private fun parseIdiomasJson(json: String?): Map<String, String>? {
        if (json.isNullOrBlank()) return null
        return try {
            val mapper = jacksonObjectMapper()
            mapper.readValue<Map<String, String>>(json)
        } catch (ex: Exception) {
            println("Erro ao converter idiomas JSON: ${ex.message}")
            null
        }
    }

    private fun encontrarGrupoDeSinonimos(textoDoCargo: String): Set<String>? {
        val textoLower = textoDoCargo.lowercase()
        return dicionarioSinonimos.find { grupo ->
            grupo.any { sinonimo -> textoLower.contains(sinonimo) }
        }
    }

    // DICIONÁRIO DE SINÔNIMOS DE CARGOS
    private val dicionarioSinonimos: List<Set<String>> = listOf(
        // Grupo 1: Desenvolvimento de Software (Backend & Geral)
        setOf(
            "desenvolvedor backend",
            "engenheiro de software",
            "analista de sistemas",
            "programador",
            "desenvolvedor",
            "developer",
            "dev"
        ),

        // Grupo 2: Desenvolvimento de Software (Frontend)
        setOf(
            "desenvolvedor frontend",
            "frontend developer"
        ),

        // Grupo 3: Dados
        setOf(
            "cientista de dados",
            "analista de dados",
            "data scientist",
            "data analyst"
        ),

        // Grupo 4: Qualidade de Software (QA)
        setOf(
            "qa engineer",
            "analista de qa",
            "quality assurance",
            "tester",
            "testador"
        ),

        // Grupo 5: Infraestrutura & DevOps
        setOf(
            "analista de infraestrutura",
            "devops engineer",
            "sysadmin",
            "administrador de sistemas"
        ),

        // Grupo 6: Design de Produto
        setOf(
            "ui/ux designer",
            "designer de interface",
            "designer de experiência do usuário",
            "product designer"
        ),

        // Grupo 7: Gestão de Produto
        setOf(
            "product manager",
            "gerente de produto",
            "pm"
        ),

        // Grupo 8: Suporte Técnico
        setOf(
            "suporte técnico",
            "analista de suporte",
            "help desk"
        )
    )
}
