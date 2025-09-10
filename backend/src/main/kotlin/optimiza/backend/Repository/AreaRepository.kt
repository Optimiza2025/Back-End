package optimiza.backend.Repository

import optimiza.backend.Domain.Area
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AreaRepository : JpaRepository<Area, Int>