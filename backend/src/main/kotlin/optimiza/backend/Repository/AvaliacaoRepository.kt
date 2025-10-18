package optimiza.backend.Repository

import optimiza.backend.Domain.Avaliacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvaliacaoRepository : JpaRepository<Avaliacao, Int> {
    fun findByCandidatura_Id(idCandidatura: Int): Avaliacao?
    fun findByCandidatura_Candidato_Id(idCandidato: Int): List<Avaliacao>
}