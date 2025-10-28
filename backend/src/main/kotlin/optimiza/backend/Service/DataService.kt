package optimiza.backend.Service

import optimiza.backend.Repository.AvaliacaoRepository
import optimiza.backend.Repository.CandidaturaRepository
import optimiza.backend.Repository.UsuarioRepository
import optimiza.backend.Repository.VagaRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DataService(
    private val vagaRepository: VagaRepository,
    private val candidaturaRepository: CandidaturaRepository,
    private val avaliacaoRepository: AvaliacaoRepository,
    private val usuarioRepository: UsuarioRepository
) {
    fun getGestores(): List<String> {
        val usuarios = usuarioRepository.findAll()
        return usuarios.map { usuario ->
            "${usuario.nome ?: "Usuário sem nome"},${usuario.id}"
        }
    }

    /**
     * Volume de novas vagas ao longo do tempo.
     */
    fun getVolumeVagasPorMes(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val results = vagaRepository.findVolumeVagasPorMes(userId, inicio, fim)

        return results.map {
            mapOf(
                "Mes" to it.getAnoMes(),
                "Total" to it.getTotal()
            )
        }
    }

    /**
     * KPI de "Vagas fracassadas" (Stat/Big Number).
     */
    fun getVagasFracassadas(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val total = vagaRepository.countVagasFracassadas(userId, inicio, fim)

        return listOf(mapOf("Total" to total))
    }

    /**
     * Média de Compatibilidade (Matching) (Gauge/Stat).
     */
    fun getMediaMatching(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val media = candidaturaRepository.getMediaMatching(userId, inicio, fim) ?: 0.0

        return listOf(mapOf("MediaMatching" to media))
    }

    /**
     * Principais Motivos de Reprovação
     */
    fun getMediaReprovacao(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val result = avaliacaoRepository.getMediaReprovacao(userId, inicio, fim)

        if (result != null) {
            return listOf(
                mapOf(
                    "HardSkills" to (result.getAvgHardSkills() ?: 0.0),
                    "SoftSkills" to (result.getAvgSoftSkills() ?: 0.0),
                    "Experiencia" to (result.getAvgExperiencia() ?: 0.0),
                    "Cultura" to (result.getAvgCultura() ?: 0.0)
                )
            )
        }
        return emptyList() // Retorna lista vazia se não houver dados
    }
}