package optimiza.backend.Repository

import optimiza.backend.DTO.CandidatoResumoBusca
import optimiza.backend.DTO.PerfilAcademicoView
import optimiza.backend.Domain.Candidato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface RecenciaProjection {
    fun getMediaDias(): Double?
    fun getDiasDesdeUltima(): Int?
    fun getUltimoCandidato(): String?
}

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

    // Recência do Banco de Talentos
    @Query(nativeQuery = true, value = """
        SELECT AVG(DATEDIFF(CURDATE(), c.data_update)) 
        FROM CANDIDATO c
        WHERE c.status = 'Banco_de_talentos'
    """)
    fun getMediaRecenciaBancoTalentos(): Double?

    @Query(nativeQuery = true, value = """
        SELECT 
            AVG(DATEDIFF(CURDATE(), c.data_update)) as mediaDias,
            DATEDIFF(CURDATE(), MAX(c.data_update)) as diasDesdeUltima,
            (SELECT nome FROM OPTIMIZA.CANDIDATO 
             WHERE status = 'Banco_de_talentos' 
             ORDER BY data_update DESC LIMIT 1) as ultimoCandidato
        FROM OPTIMIZA.CANDIDATO c
        WHERE c.status = 'Banco_de_talentos'
    """)
    fun getKpiRecenciaCompleto(): RecenciaProjection?

    // Perfil Acadêmico dos Inscritos
    @Query(nativeQuery = true, value = """
        SELECT c.nivel_formacao as nivelFormacao, COUNT(*) as total
        FROM CANDIDATO c 
        JOIN CANDIDATURA cand ON cand.id_candidato = c.id_candidato
        JOIN VAGA v ON cand.id_vaga = v.id_vaga 
        WHERE v.data_abertura >= :inicio 
          AND (v.data_fechamento <= :fim OR v.data_fechamento IS NULL)
        GROUP BY c.nivel_formacao 
        ORDER BY c.nivel_formacao ASC
    """)
    fun getPerfilAcademicoGlobal(inicio: LocalDate, fim: LocalDate): List<PerfilAcademicoView>

}