package optimiza.backend.Repository

import optimiza.backend.Domain.Candidatura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CandidaturaRepository: JpaRepository<Candidatura, Int> {
    fun findByVagaIdAndCandidatoId(idVaga: Int, idCandidato: Int): Candidatura?

    @Query("SELECT c FROM Candidatura c WHERE c.vaga.id = :idVaga ORDER BY c.matching DESC")
    fun listarPorVagaOrdenado(@Param("idVaga") idVaga: Int): List<Candidatura>
}