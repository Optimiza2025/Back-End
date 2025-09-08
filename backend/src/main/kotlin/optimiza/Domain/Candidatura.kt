package optimiza.Domain

import jakarta.persistence.*

@Entity
@Table(name = "CANDIDATURA")
data class Candidatura(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidatura")
    val id: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaga", nullable = false)
    val vaga: Vaga,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato", nullable = false)
    val candidato: Candidato,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: StatusCandidatura,

    val matching: Double? = null
)