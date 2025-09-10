package optimiza.backend.DTO

import java.time.LocalDate

data class VagaRequest(
    val titulo: String?,
    val cargo: String?,
    val experiencia: String?,
    val nivelFormacao: String?,
    val instituicaoEnsino: String?,
    val curso: String?,
    val idiomas: List<String>?,
    val palavrasChave: List<String>?,
    val idArea: Int
)

data class VagaResponse(
    val id: Int,
    val titulo: String?,
    val cargo: String?,
    val experiencia: String?,
    val nivelFormacao: String?,
    val instituicaoEnsino: String?,
    val curso: String?,
    val idiomas: List<String>?,
    val palavrasChave: List<String>?,
    val dataAbertura: LocalDate? = null,
    val dataUpdate: LocalDate? = null,
    val etapaVaga: String,
    val status: String,
    val idArea: Int
)

data class VagaResumoResponse(
    val titulo: String,
    val cargo: String?
)