package optimiza.backend.Domain

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "AVALIACAO")
data class Avaliacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    val id: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidatura", nullable = false)
    val candidatura: Candidatura,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_avaliador", nullable = false)
    val avaliador: Usuario,

    val hard_skills: BigDecimal? = null,
    val soft_skills: BigDecimal? = null,
    val experiencia: BigDecimal? = null,
    val cultura: BigDecimal? = null,

    @Column(length = 100)
    val comentario: String? = null,

    @Column(name = "data_avaliacao")
    val dataAvaliacao: LocalDate? = null
){
    constructor() : this(
        0,
        Candidatura(),
        Usuario(),
        null, null, null, null,
        null, null
    )
}