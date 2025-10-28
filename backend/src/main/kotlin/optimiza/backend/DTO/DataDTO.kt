package optimiza.backend.DTO

// --- DTOs Genéricos para o formato de Tabela ---

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