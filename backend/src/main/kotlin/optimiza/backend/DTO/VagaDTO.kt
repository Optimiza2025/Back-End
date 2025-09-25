package optimiza.backend.DTO

import optimiza.backend.Domain.EtapaVaga
import optimiza.backend.Domain.NivelFormacao
import optimiza.backend.Domain.StatusVaga
import java.time.LocalDate

data class VagaRequest(
    val titulo: String?,
    val cargo: String?,
    val experiencia: String?,
    val nivelFormacao: NivelFormacao?,
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
    val cargo: String?,
    val nivelFormacao: NivelFormacao?,
    val idiomas: List<String>?,
    val etapaVaga: EtapaVaga?,
    val nomeArea: String?
)


data class LayoutVagaResumoResponse(
    val id: Int,
    val titulo: String
)