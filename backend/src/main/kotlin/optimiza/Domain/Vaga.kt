package optimiza.Domain

import jakarta.persistence.*

@Entity
@Table(name = "VAGA")
data class Vaga(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    val id: Int,

    @Column(nullable = false, length = 150)
    val titulo: String,

    val cargo: String? = null,
    val experiencia: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_formacao")
    val nivelFormacao: NivelFormacao? = null,

    @Column(name = "instituicao_ensino", length = 150)
    val instituicaoEnsino: String? = null,

    @Column(length = 150)
    val curso: String? = null,

    @Column(columnDefinition = "json")
    val idiomas: String? = null,

    @Column(columnDefinition = "json")
    val palavrasChave: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "etapa_vaga", nullable = false)
    val etapaVaga: EtapaVaga,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: StatusVaga,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", nullable = false)
    val area: Area
)