package optimiza.backend.Repository

import optimiza.backend.Domain.LayoutVagas
import org.springframework.data.jpa.repository.JpaRepository

interface LayoutVagasRepository : JpaRepository<LayoutVagas, Int>