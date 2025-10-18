package optimiza.backend.Domain

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity
@Table(name = "USUARIO")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    val id: Int = 0,

    @field:NotBlank
    @field:Size(max = 150)
    val nome: String = "",

    @field:Email
    @field:NotBlank
    @field:Size(max = 150)
    val email: String = "",

    @field:NotBlank
    @field:Size(max = 200)
    val senha: String = "",

    @Column(length = 20)
    val telefone: String? = null,

    @Column(unique = true, length = 14)
    val cpf: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", nullable = false)
    val area: Area = Area()
){
    constructor() : this(0, "", "")
}
