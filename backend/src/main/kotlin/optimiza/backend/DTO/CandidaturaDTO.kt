package optimiza.backend.DTO

import java.math.BigDecimal

data class CandidaturaResponseDTO(
    val idCandidatura: Int,
    val idVaga: Int,
    val idCandidato: Int,
    val nomeCandidato: String?,
    val cargoCandidato: String?,
    val status: String,
    val matching: BigDecimal?,
    val matches: Map<String, String>?
)