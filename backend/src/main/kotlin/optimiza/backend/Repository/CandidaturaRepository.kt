package optimiza.backend.Repository

import optimiza.backend.Domain.Candidatura
import org.springframework.data.jpa.repository.JpaRepository

interface CandidaturaRepository: JpaRepository<Candidatura, Int> {
    fun findByVagaIdAndCandidatoId(idVaga: Int, idCandidato: Int): Candidatura?
}