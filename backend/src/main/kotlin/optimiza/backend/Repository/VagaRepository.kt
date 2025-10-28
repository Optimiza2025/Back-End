package optimiza.backend.Repository

import optimiza.backend.DTO.VagasPorMesView
import optimiza.backend.Domain.Vaga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate


@Repository
interface VagaRepository : JpaRepository<Vaga, Int>{
    fun findByAreaId(idArea: Int): List<Vaga>

    @Query(
        value = """
    SELECT * FROM VAGA v
    WHERE v.id_area = :idArea
      AND (:titulo IS NULL OR LOWER(v.titulo) COLLATE utf8mb4_unicode_ci LIKE CONCAT('%', LOWER(:titulo), '%'))
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
        @Param("idArea") idArea: Int,
        @Param("titulo") titulo: String?,
        @Param("cargo") cargo: String?,
        @Param("nivelFormacao") nivelFormacao: String?,
        @Param("idioma") idioma: String?
    ): List<Vaga>

    @Query(nativeQuery = true, value = """
        SELECT 
            DATE_FORMAT(v.data_abertura, '%Y-%m') AS anoMes, 
            COUNT(v.id_vaga) AS total
        FROM VAGA v
        JOIN USUARIO u ON v.id_area = u.id_area 
        WHERE u.id_usuario = :userId
          AND v.data_abertura BETWEEN :inicio AND :fim
        GROUP BY anoMes 
        ORDER BY anoMes ASC
    """)
    fun findVolumeVagasPorMes(userId: Int, inicio: LocalDate, fim: LocalDate): List<VagasPorMesView>

    @Query(nativeQuery = true, value = """
        SELECT COUNT(*)
        FROM VAGA v
        JOIN USUARIO u ON v.id_area = u.id_area 
        WHERE v.status = 'encerrada'
          AND u.id_usuario = :userId
          AND v.data_abertura >= :inicio
          AND v.data_fechamento <= :fim
    """)
    fun countVagasFracassadas(userId: Int, inicio: LocalDate, fim: LocalDate): Long


}