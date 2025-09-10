package optimiza.backend.DTO

data class UsuarioRequest(
    val nome: String,
    val email: String,
    val senha: String,
    val telefone: String?,
    val cpf: String?,
    val idArea: Int
)

data class UsuarioResponse(
    val id: Int,
    val nome: String,
    val email: String,
    val telefone: String?,
    val cpf: String?,
    val idArea: Int
)

data class ErrorResponse(
    val message: String,
    val field: String? = null
)