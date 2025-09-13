package optimiza.backend.Domain

import com.vladmihalcea.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Type


@Entity
@Table(name = "LAYOUT_VAGAS")
data class LayoutVagas(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val titulo: String? = null,
    val cargo: String? = null,
    val experienciaEsperada: String? = null,
    val nivelFormacaoEsperada: String? = null,
    val cursoEsperado: String? = null,

    @Type(value = JsonType::class)
    @Column(columnDefinition = "json")
    val idiomasEsperados: Map<String, String>? = null,
)