package optimiza.backend.Repository

import optimiza.backend.Domain.Candidato
import org.springframework.data.jpa.repository.JpaRepository

interface CandidatoRepository : JpaRepository<Candidato, Int>