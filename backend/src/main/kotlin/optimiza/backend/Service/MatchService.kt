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
        println("Procurando pela Vaga...")
        val vaga = vagaService.encontrarVagaPorId(idVaga)
            ?: throw IllegalArgumentException("Vaga não encontrada para o ID $idVaga")

        println("Iniciando funil de busca de candidatos para a vaga ${vaga.id}")
        val candidatos = buscarCandidatosComFunil(vaga)

        if (candidatos.isEmpty()) {
            println("Nenhum candidato encontrado para a vaga ${vaga.id}, mesmo após o funil de busca.")
            return
        }

        println("Total de candidatos após o funil: ${candidatos.size}")
        println("Calculando score e salvando candidaturas...")

        candidatos.forEach { candidato ->
            val detalhes = calcularDetalhesMatch(vaga, candidato)
            val scoreFinal = detalhes.values.average().toBigDecimal()

            println("${candidato.nome} -> Score: ${(scoreFinal.multiply(BigDecimal(100))).toInt()}% | Detalhes: $detalhes")

            candidaturaService.salvarOuAtualizarCandidatura(
                vaga = vaga, candidato = candidato, matching = scoreFinal, matches = detalhes
            )
        }
    }

   private fun buscarCandidatosComFunil(vaga: Vaga): List<Candidato> {
        val palavrasChave = vaga.palavrasChave ?: emptyList()
        var candidatos = candidatoService.buscarCandidatosPorPalavrasChave(palavrasChave).toMutableList()

        println("Etapa 1: ${candidatos.size} candidatos encontrados por palavras-chave.")
        if (candidatos.size >= 10) return candidatos

        // Etapa 2: Buscar por curso e formação
        val candidatosPorCursoFormacao = candidatoService.buscarPorCursoEFormacao(vaga.curso, vaga.nivelFormacao)
        println("Etapa 2: ${candidatosPorCursoFormacao.size} candidatos encontrados por curso/formação.")
        candidatos.addAll(candidatosPorCursoFormacao)
        candidatos = candidatos.distinctBy { it.id }.toMutableList()
        if (candidatos.size >= 10) return candidatos

        // Etapa 3: Buscar por cargos semelhantes (sinônimos)
        val grupoVaga = encontrarGrupoDeSinonimos("${vaga.titulo ?: ""} ${vaga.cargo ?: ""}")
        if (grupoVaga != null) {
            val candidatosPorCargo = candidatoService.buscarPorCargosSemelhantes(grupoVaga)
            println("Etapa 3: ${candidatosPorCargo.size} candidatos encontrados por cargos semelhantes.")
            candidatos.addAll(candidatosPorCargo)
            candidatos = candidatos.distinctBy { it.id }.toMutableList()
        }
        if (candidatos.size >= 10) return candidatos

        // Etapa 4: Fallback — garantir pelo menos 10 candidatos
        val restantes = 10 - candidatos.size
        val adicionais = candidatoService.buscarCandidatosAleatorios(limit = restantes)
        println("Etapa 4: Adicionados ${adicionais.size} candidatos aleatórios para completar o funil.")
        candidatos.addAll(adicionais)

        return candidatos.distinctBy { it.id }
    }

    fun calcularDetalhesMatch(vaga: Vaga, candidato: Candidato): Map<String, Double> {
        val detalhes = mutableMapOf<String, Double>()

        detalhes["cargo"] = compararCargoFlexivel(vaga, candidato)
        detalhes["formacao"] = compararFormacao(vaga.nivelFormacao, candidato.nivelFormacao)
        detalhes["experiencia"] = compararExperiencia(vaga.experiencia, candidato.experiencia)
        detalhes["idiomas"] = compararIdiomas(vaga.idiomas, parseIdiomasJson(candidato.idiomas))
        detalhes["palavras_chave"] = compararPalavrasChave(vaga.palavrasChave ?: emptyList(), candidato)
        detalhes["curso"] =
            if (vaga.curso != null && candidato.curso?.contains(vaga.curso!!, true) == true) 1.0 else 0.0
        detalhes["instituicao_ensino"] = compararInstituicaoEnsino(vaga.instituicaoEnsino, candidato.instituicaoEnsino)

        return detalhes
    }

    private fun compararCargoFlexivel(vaga: Vaga, candidato: Candidato): Double {
        val textoVaga = ("${vaga.titulo ?: ""} ${vaga.cargo ?: ""}").trim().replace("\\s+".toRegex(), " ")
        val cargoCandidato = candidato.cargo?.trim()?.replace("\\s+".toRegex(), " ")

        if (textoVaga.isBlank() || cargoCandidato.isNullOrBlank()) return 0.0

        val grupoVaga = encontrarGrupoDeSinonimos(textoVaga)
        val grupoCandidato = encontrarGrupoDeSinonimos(cargoCandidato)

        if (grupoVaga != null && grupoVaga == grupoCandidato) return 1.0

        val textoVagaLower = textoVaga.lowercase()
        val cargoCandidatoLower = cargoCandidato.lowercase()

        return if (textoVagaLower.contains(cargoCandidatoLower) || cargoCandidatoLower.contains(textoVagaLower)) 1.0 else 0.0
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
        if (vagaInstituicoes.isNullOrBlank() || candInstituicao.isNullOrBlank()) return 0.0

        val listaVaga = vagaInstituicoes.split(",").map { it.trim().lowercase() }
        val instituicaoCandidatoLower = candInstituicao.lowercase()
        return if (listaVaga.any { instituicaoCandidatoLower.contains(it) }) 1.0 else 0.0
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
            candidato.experiencia, candidato.cargo, candidato.curso, candidato.curriculo
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
        return dicionarioSinonimos.find { grupo -> grupo.any { textoLower.contains(it) } }
    }

    // DICIONÁRIO DE SINÔNIMOS DE CARGOS
    private val dicionarioSinonimos: List<Set<String>> = listOf(
        setOf(
            "desenvolvedor backend",
            "engenheiro de software",
            "analista de sistemas",
            "programador",
            "desenvolvedor",
            "developer",
            "dev"
        ),
        setOf("desenvolvedor frontend", "frontend developer"),
        setOf("cientista de dados", "analista de dados", "data scientist", "data analyst"),
        setOf("qa engineer", "analista de qa", "quality assurance", "tester", "testador"),
        setOf("analista de infraestrutura", "devops engineer", "sysadmin", "administrador de sistemas"),
        setOf("ui/ux designer", "designer de interface", "designer de experiência do usuário", "product designer"),
        setOf("product manager", "gerente de produto", "pm"),
        setOf("suporte técnico", "analista de suporte", "help desk")
    )
}
