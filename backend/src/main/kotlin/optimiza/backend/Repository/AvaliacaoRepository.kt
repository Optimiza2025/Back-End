package optimiza.backend.Repository

import optimiza.backend.DTO.MediaReprovacaoView
import optimiza.backend.Domain.Avaliacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface AvaliacaoRepository : JpaRepository<Avaliacao, Int> {
    fun findByCandidatura_IdAndAvaliador_Id(
        idCandidatura: Int,
        idAvaliador: Int
    ): Avaliacao?

    fun findByCandidatura_Candidato_Id(idCandidato: Int): List<Avaliacao>

    @Query(nativeQuery = true, value = """
        SELECT 
            AVG(a.hard_skills) AS avgHardSkills, 
            AVG(a.soft_skills) AS avgSoftSkills, 
            AVG(a.experiencia) AS avgExperiencia, 
            AVG(a.cultura) AS avgCultura
        FROM CANDIDATURA c
        JOIN AVALIACAO a ON c.id_candidatura = a.id_candidatura
        JOIN VAGA v ON c.id_vaga = v.id_vaga
        JOIN USUARIO u ON v.id_area = u.id_area  
        WHERE c.status = 'reprovado' 
          AND u.id_usuario = :userId
          AND v.data_abertura >= :inicio
          AND v.data_fechamento <= :fim
    """)
    fun getMediaReprovacao(userId: Int, inicio: LocalDate, fim: LocalDate): MediaReprovacaoView?
}