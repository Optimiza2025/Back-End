package optimiza.backend.DTO

data class CandidatoRequest(
    val nome: String?,
    val experiencia: String?,
    val nivelFormacao: String,
    val instituicaoEnsino: String?,
    val curso: String?,
    val idiomas: Map<String, String>?,
    val status: String,
    val email: String,
    val curriculo: String?,
    val dataUpdate: String?
)

data class CandidatoResponse(
    val id: Int,
    val nome: String?,
    val experiencia: String?,
    val nivelFormacao: String,
    val instituicaoEnsino: String?,
    val curso: String?,
    val idiomas: Map<String, String>?,
    val status: String,
    val email: String,
    val curriculo: String?,
    val dataUpdate: String?
)

data class CandidatoResumo(
    val nome: String,
    val nivelFormacao: String,
    val curso: String?,
    val status: String
)
