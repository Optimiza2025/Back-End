package optimiza.DTO

data class LoginRequest(
    val email: String,
    val senha: String
)

data class LoginResponse(
    val id: Int,
    val nome: String,
    val email: String,
)

data class Errologin(
    val menssage: String,
    val email: String,
)