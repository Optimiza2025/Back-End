package optimiza.backend.Service

import optimiza.backend.Repository.*
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.math.roundToInt

@Service
class DataService(
    private val vagaRepository: VagaRepository,
    private val candidaturaRepository: CandidaturaRepository,
    private val avaliacaoRepository: AvaliacaoRepository,
    private val usuarioRepository: UsuarioRepository,
    private val candidatoRepository: CandidatoRepository
) {
    // --- MÉTODOS GESTOR ---
    fun getGestores(): List<String> {
        val usuarios = usuarioRepository.findAll()
        return usuarios.map { usuario -> "${usuario.nome ?: "Usuário sem nome"},${usuario.id}" }
    }

    fun getVolumeVagasPorMes(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val results = vagaRepository.findVolumeVagasPorMes(userId, inicio, fim)
        return results.map { mapOf("Mes" to it.getAnoMes(), "Total" to it.getTotal()) }
    }

    fun getVagasFracassadas(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val total = vagaRepository.countVagasFracassadas(userId, inicio, fim)
        return listOf(mapOf("Total" to total))
    }

    fun getMediaMatching(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val media = candidaturaRepository.getMediaMatching(userId, inicio, fim) ?: 0.0
        return listOf(mapOf("MediaMatching" to media))
    }

    fun getMediaReprovacao(userId: Int, inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val result = avaliacaoRepository.getMediaReprovacao(userId, inicio, fim)
        if (result != null) {
            return listOf(mapOf(
                "HardSkills" to (result.getAvgHardSkills() ?: 0.0),
                "SoftSkills" to (result.getAvgSoftSkills() ?: 0.0),
                "Experiencia" to (result.getAvgExperiencia() ?: 0.0),
                "Cultura" to (result.getAvgCultura() ?: 0.0)
            ))
        }
        return emptyList()
    }

    // --- MÉTODOS VISÃO GLOBAL RH ---

    /**
     * Volume de Vagas Global (Mensal / Área / Status)
     */
    fun getVolumeVagasGlobal(inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val results = vagaRepository.findVolumeVagasGlobal(inicio, fim)
        return results.map {
            mapOf(
                "Mes" to it.getMesReferencia(),
                "Area" to it.getNomeArea(),
                "Status" to it.getStatus(),
                "Total" to it.getNumVagas()
            )
        }
    }

    /**
     * Principais Motivos de Reprovação (Global)
     */
    fun getMediaReprovacaoGlobal(inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val result = avaliacaoRepository.getMediaReprovacaoGlobal(inicio, fim)
        if (result != null) {
            return listOf(mapOf(
                "HardSkills" to (result.getAvgHardSkills() ?: 0.0),
                "SoftSkills" to (result.getAvgSoftSkills() ?: 0.0),
                "Experiencia" to (result.getAvgExperiencia() ?: 0.0),
                "Cultura" to (result.getAvgCultura() ?: 0.0)
            ))
        }
        return listOf(mapOf(
            "HardSkills" to 0.0, "SoftSkills" to 0.0, "Experiencia" to 0.0, "Cultura" to 0.0
        ))
    }

    /**
     * Tempo Médio de Contratação (Time to Fill)
     */
    fun getTempoMedioContratacao(inicio: LocalDate, fim: LocalDate): Map<String, Any?> {
        val mediaDias = vagaRepository.getTempoMedioContratacao(inicio, fim) ?: 0.0
        // Arredondando para 1 casa decimal para ficar mais limpo no front
        val formatted = (mediaDias * 10.0).roundToInt() / 10.0
        return mapOf("MediaDias" to formatted)
    }

    /**
     * Volume de Vagas Fracassadas (Churn Global)
     */
    fun getVagasFracassadasGlobal(inicio: LocalDate, fim: LocalDate): Map<String, Any?> {
        val total = vagaRepository.countVagasFracassadasGlobal(inicio, fim)
        return mapOf("TotalFracassadas" to total)
    }

    /**
     * Total de Candidaturas (Visão Mensal)
     */
    fun getVolumeCandidaturasGlobal(inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val results = candidaturaRepository.getVolumeCandidaturasGlobal(inicio, fim)
        return results.map {
            mapOf(
                "Mes" to it.getMesReferencia(),
                "Total" to it.getTotalCandidaturas()
            )
        }
    }

    /**
     * Recência do Banco de Talentos
     */
    fun getRecenciaBancoTalentos(): Map<String, Any?> {
        val kpi = candidatoRepository.getKpiRecenciaCompleto()

        val mediaDiasRaw = kpi?.getMediaDias() ?: 0.0
        val diasDesdeUltima = kpi?.getDiasDesdeUltima() ?: 0
        val ultimoNome = kpi?.getUltimoCandidato() ?: ""

        val mediaFormatada = (mediaDiasRaw * 10.0).roundToInt() / 10.0

        return mapOf(
            "mediaDias" to mediaFormatada,
            "diasDesdeUltimaAtividade" to diasDesdeUltima,
            "nomeUltimoCandidato" to ultimoNome
        )
    }

    /**
     * Perfil Acadêmico dos Inscritos
     */
    fun getPerfilAcademicoGlobal(inicio: LocalDate, fim: LocalDate): List<Map<String, Any?>> {
        val results = candidatoRepository.getPerfilAcademicoGlobal(inicio, fim)
        return results.map {
            mapOf(
                "NivelFormacao" to (it.getNivelFormacao() ?: "Não informado"),
                "Total" to it.getTotal()
            )
        }
    }
}