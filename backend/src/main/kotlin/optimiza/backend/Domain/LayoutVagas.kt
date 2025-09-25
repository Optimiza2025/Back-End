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

    @Column(name = "titulo")
    val titulo: String? = null,

    @Column(name = "cargo")
    val cargo: String? = null,

    @Column(name = "experiencia_esperada")
    val experienciaEsperada: String? = null,

    @Column(name = "nivel_formacao_esperada")
    val nivelFormacaoEsperada: String? = null,

    @Column(name = "curso_esperado")
    val cursoEsperado: String? = null,

    @Type(JsonType::class)
    @Column(name = "idiomas_esperados", columnDefinition = "json")
    val idiomasEsperados: Map<String, String>? = null,
)
