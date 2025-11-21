package optimiza.backend.Repository

import optimiza.backend.DTO.CandidaturasPorMesView
import optimiza.backend.Domain.Candidatura
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface CandidaturaRepository: JpaRepository<Candidatura, Int> {
    fun findByVagaIdAndCandidatoId(idVaga: Int, idCandidato: Int): Candidatura?

    @Query(nativeQuery = true, value = """
            SELECT *
            FROM CANDIDATURA
            WHERE id_vaga = :idVaga
            ORDER BY matching DESC
        """)
    fun listarPorVagaOrdenado(@Param("idVaga") idVaga: Int): List<Candidatura>

    @Query(nativeQuery = true, value = """
        SELECT AVG(c.matching)
        FROM CANDIDATURA c
        JOIN VAGA v ON c.id_vaga = v.id_vaga 
        JOIN USUARIO u ON v.id_area = u.id_area 
        WHERE u.id_usuario = :userId
          AND v.data_abertura BETWEEN :inicio AND :fim
    """)
    fun getMediaMatching(userId: Int, inicio: LocalDate, fim: LocalDate): Double?

    // --- DASHBOARD RH ---

    // Total de Candidaturas Global (Visão Mensal)
    @Query(nativeQuery = true, value = """
        SELECT DATE_FORMAT(v.data_abertura, '%Y-%m') as mesReferencia, COUNT(*) as totalCandidaturas 
        FROM CANDIDATURA c
        JOIN VAGA v ON c.id_vaga = v.id_vaga
        WHERE v.data_abertura BETWEEN :inicio AND :fim
        GROUP BY mesReferencia
        ORDER BY mesReferencia ASC
    """)
    fun getVolumeCandidaturasGlobal(inicio: LocalDate, fim: LocalDate): List<CandidaturasPorMesView>

}