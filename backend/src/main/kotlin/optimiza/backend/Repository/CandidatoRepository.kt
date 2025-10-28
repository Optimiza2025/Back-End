package optimiza.backend.Repository

import optimiza.backend.DTO.CandidatoResumoBusca
import optimiza.backend.Domain.Candidato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CandidatoRepository : JpaRepository<Candidato, Int> {
    @Query(
        value = """
        SELECT * FROM CANDIDATO c
        WHERE (:nome IS NULL OR LOWER(c.nome) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:nome), '%'))
          AND (:nivelFormacao IS NULL OR LOWER(c.nivel_formacao) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:nivelFormacao), '%'))
          AND (:curso IS NULL OR LOWER(c.curso) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:curso), '%'))
          AND (:status IS NULL OR LOWER(c.status) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:status), '%'))
    """,
        nativeQuery = true
    )
    fun filtrarCandidatos(
        @Param("nome") nome: String?,
        @Param("nivelFormacao") nivelFormacao: String?,
        @Param("curso") curso: String?,
        @Param("status") status: String?
    ): List<Candidato>


    @Query("SELECT NEW optimiza.backend.DTO.CandidatoResumoBusca(c.id, c.experiencia, c.cargo, c.instituicaoEnsino, c.curso, c.curriculo) FROM Candidato c")
    fun buscarCamposResumidos(): List<CandidatoResumoBusca>

}