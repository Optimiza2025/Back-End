package optimiza.backend.DTO

import java.math.BigDecimal
import java.time.LocalDate

data class AvaliacaoRequestDTO(
    val idCandidatura: Int,
    val idAvaliador: Int,
    val hardSkills: BigDecimal?,
    val softSkills: BigDecimal?,
    val experiencia: BigDecimal?,
    val cultura: BigDecimal?,
    val comentario: String?
)

data class AvaliacaoResponseDTO(
    val idAvaliacao: Int,
    val idCandidatura: Int,
    val idVaga: Int,
    val nomeAvaliador: String,
    val hardSkills: BigDecimal?,
    val softSkills: BigDecimal?,
    val experiencia: BigDecimal?,
    val cultura: BigDecimal?,
    val comentario: String?,
    val dataAvaliacao: LocalDate?
)