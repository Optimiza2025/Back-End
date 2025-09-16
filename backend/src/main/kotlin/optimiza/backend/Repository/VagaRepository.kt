package optimiza.backend.Repository

import optimiza.backend.Domain.Vaga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface VagaRepository : JpaRepository<Vaga, Int>{
    fun findByAreaId(idArea: Int): List<Vaga>
}