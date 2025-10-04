package optimiza.backend.Domain

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "CANDIDATO")
data class Candidato(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    val id: Int = 0,

    @Column(length = 100)
    val nome: String? = null,

    @Column(columnDefinition = "TEXT")
    val experiencia: String? = null,

    @Column(length = 100)
    val cargo: String? = null,

    @Column(name = "nivel_formacao")
    @Enumerated(EnumType.STRING)
    val nivelFormacao: NivelFormacao? = null,

    @Column(name = "instituicao_ensino", length = 150)
    val instituicaoEnsino: String? = null,

    @Column(length = 150)
    val curso: String? = null,

    @Column(columnDefinition = "json")
    val idiomas: String? = null,

    @Enumerated(EnumType.STRING)
    val status: StatusCandidato = StatusCandidato.Banco_de_talentos,

    @Column(unique = true, length = 150)
    val email: String? = null,

    @Lob
    @Column(columnDefinition = "TEXT")
    val curriculo: String? = null,

    @Column(name = "data_update")
    val dataUpdate: LocalDate? = null
)