package optimiza.backend.Repository

import optimiza.backend.Domain.Vaga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface VagaRepository : JpaRepository<Vaga, Int>{
    fun findByAreaId(idArea: Int): List<Vaga>

    @Query(
        value = """
        SELECT * FROM vaga v
        WHERE (:titulo IS NULL OR LOWER(v.titulo) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:titulo), '%'))
          AND (:cargo IS NULL OR LOWER(v.cargo) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:cargo), '%'))
          AND (:nivelFormacao IS NULL OR v.nivel_formacao = :nivelFormacao)
          AND (
            :idioma IS NULL OR 
            JSON_SEARCH(
                LOWER(CONVERT(v.idiomas USING utf8mb4)), 
                'one', 
                CONCAT('%', LOWER(:idioma), '%')
            ) IS NOT NULL
          )
    """,
        nativeQuery = true
    )
    fun filtrarVagas(
        @Param("titulo") titulo: String?,
        @Param("cargo") cargo: String?,
        @Param("nivelFormacao") nivelFormacao: String?,
        @Param("idioma") idioma: String?
    ): List<Vaga>
}