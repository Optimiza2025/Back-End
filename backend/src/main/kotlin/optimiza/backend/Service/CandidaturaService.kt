package optimiza.backend.Service

import optimiza.backend.Domain.Candidato
import optimiza.backend.Domain.Candidatura
import optimiza.backend.Domain.StatusCandidatura
import optimiza.backend.Domain.Vaga
import optimiza.backend.Repository.CandidaturaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class CandidaturaService(
    private val candidaturaRepository: CandidaturaRepository
) {

    fun salvarOuAtualizarCandidatura(
        vaga: Vaga,
        candidato: Candidato,
        matching: BigDecimal,
        matches: Map<String, Double>
    ) {
        try {
            // Verifica se já existe uma candidatura para essa vaga e candidato
            val existente = candidaturaRepository.findByVagaIdAndCandidatoId(vaga.id!!, candidato.id!!)

            if (existente != null) {
                // Atualiza os campos relevantes
                val atualizada = existente.copy(
                    matching = matching.setScale(2, RoundingMode.HALF_UP),
                    matches = matches.mapValues { it.value.toString() }
                )
                candidaturaRepository.save(atualizada)
                println("Candidatura atualizada: Vaga ${vaga.id} | Candidato ${candidato.id}")
            } else {
                // Cria uma nova candidatura
                val nova = Candidatura(
                    id = 0,
                    vaga = vaga,
                    candidato = candidato,
                    status = StatusCandidatura.em_analise,
                    matching = matching.setScale(2, RoundingMode.HALF_UP),
                    matches = matches.mapValues { it.value.toString() }
                )
                candidaturaRepository.save(nova)
                println("Nova candidatura criada: Vaga ${vaga.id} | Candidato ${candidato.id}")
            }
        } catch (ex: Exception) {
            throw IllegalArgumentException(
                "Erro ao salvar candidatura: verifique se já existe uma candidatura para essa vaga e candidato. " +
                        "Detalhes: ${ex.message}"
            )
        }
    }
}
