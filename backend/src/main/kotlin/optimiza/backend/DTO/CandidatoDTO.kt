package optimiza.backend.DTO

import optimiza.backend.Domain.NivelFormacao
import optimiza.backend.Domain.StatusCandidato

data class CandidatoRequest(
    val nome: String?,
    val experiencia: String?,
    val cargo: String?,
    val nivelFormacao: NivelFormacao?,
    val instituicaoEnsino: String?,
    val curso: String?,
    val idiomas: Map<String, String>?,
    val status: StatusCandidato?,
    val email: String,
    val curriculo: String?,
    val dataUpdate: String?
)

data class CandidatoResponse(
    val id: Int,
    val nome: String?,
    val experiencia: String?,
    val cargo: String?,
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
    val nivelFormacao: NivelFormacao?,
    val curso: String?,
    val status: StatusCandidato?
)
