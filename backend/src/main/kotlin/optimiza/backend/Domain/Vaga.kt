package optimiza.backend.Domain

import com.vladmihalcea.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.time.LocalDate

@Entity
@Table(name = "VAGA")
data class Vaga(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    val id: Int = 0,

    @Column(nullable = false, length = 150)
    val titulo: String? = null,

    @Column(length = 100)
    val cargo: String? = null,

    @Column(length = 100)
    val experiencia: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_formacao")
    val nivelFormacao: NivelFormacao? = null,

    @Column(name = "instituicao_ensino", length = 150)
    val instituicaoEnsino: String? = null,

    @Column(length = 150)
    val curso: String? = null,

    @Type(value = JsonType::class)
    @Column(columnDefinition = "json")
    val idiomas: List<String>? = null,

    @Type(value = JsonType::class)
    @Column(name = "palavras_chave", columnDefinition = "json")
    val palavrasChave: List<String>? = null,

    @Column(name = "data_abertura")
    val dataAbertura: LocalDate? = null,

    @Column(name = "data_update")
    val dataUpdate: LocalDate? = null,

    @Column(name = "data_fechamento")
    val dataFechamento: LocalDate? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "etapa_vaga", nullable = false)
    val etapaVaga: EtapaVaga = EtapaVaga.Aguardando_aprovacao_RH,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: StatusVaga = StatusVaga.ativa,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", nullable = false)
    val area: Area = Area()
)