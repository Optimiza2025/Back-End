package optimiza.Domain

import jakarta.persistence.*

@Entity
@Table(name = "AREA")
data class Area(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    val id: Int,

    @Column(name = "nome_area", nullable = false, length = 100)
    val nome: String
)