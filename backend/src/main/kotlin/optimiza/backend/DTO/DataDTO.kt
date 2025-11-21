package optimiza.backend.DTO

// --- DTOs para o retorno de QUERIES  ---

data class GrafanaHealthCheck(
    val message: Map<String, String>
)

interface VagasPorMesView {
    fun getAnoMes(): String
    fun getTotal(): Long
}

interface MediaReprovacaoView {
    fun getAvgHardSkills(): Double?
    fun getAvgSoftSkills(): Double?
    fun getAvgExperiencia(): Double?
    fun getAvgCultura(): Double?
}

/**
 * Projeção para o Volume de Vagas Global
 */
interface VagasGlobalView {
    fun getMesReferencia(): String
    fun getNomeArea(): String
    fun getStatus(): String
    fun getNumVagas(): Long
}

/**
 * Projeção para o Perfil Acadêmico
 */
interface PerfilAcademicoView {
    fun getNivelFormacao(): String?
    fun getTotal(): Long
}

/**
 * Projeção para o Total de Candidaturas por Mês
 */
interface CandidaturasPorMesView {
    fun getMesReferencia(): String
    fun getTotalCandidaturas(): Long
}