package optimiza.backend.DTO

import optimiza.backend.Domain.Area

data class LoginRequest(
    val email: String,
    val senha: String
)

data class LoginResponse(
    val id: Int,
    val nome: String,
    val area: Area,
)

data class Errologin(
    val menssage: String,
    val email: String,
)