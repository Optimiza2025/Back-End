package optimiza.Domain

import jakarta.persistence.*

@Entity
@Table(name = "USUARIO")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    val id: Int,

    @Column(nullable = false, length = 150)
    val nome: String,

    @Column(nullable = false, unique = true, length = 150)
    val email: String,

    @Column(nullable = false, length = 200)
    val senha: String,

    @Column(length = 20)
    val telefone: String? = null,

    @Column(unique = true, length = 14)
    val cpf: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", nullable = false)
    val area: Area
)