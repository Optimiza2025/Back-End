package optimiza.backend.Domain

import com.vladmihalcea.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.math.BigDecimal

@Entity
@Table(name = "CANDIDATURA")
data class Candidatura(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidatura")
    val id: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vaga", nullable = false)
    val vaga: Vaga?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_candidato", nullable = false)
    val candidato: Candidato?,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: StatusCandidatura,

    val matching: BigDecimal? = null,

    @Type(value = JsonType::class)
    @Column(columnDefinition = "json")
    val matches: Map<String, String>? = null
){
    constructor() : this(0, null, null, StatusCandidatura.em_analise, null, null)
}