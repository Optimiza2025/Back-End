package optimiza.Service

import optimiza.DTO.Errologin
import optimiza.DTO.LoginRequest
import optimiza.DTO.LoginResponse
import optimiza.Repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun login(request: LoginRequest): ResponseEntity<Any> {
        val usuario = usuarioRepository.findByEmail(request.email)

        if (usuario.isEmpty) {
            val erro = Errologin(
                menssage = "Usuário ou senha inválidos",
                email = request.email
            )
            return ResponseEntity.badRequest().body(erro)
        }

        val user = usuario.get()
        if (!passwordEncoder.matches(request.senha, user.senha)) {
            val erro = Errologin(
                menssage = "Usuário ou senha inválidos",
                email = request.email
            )
            return ResponseEntity.badRequest().body(erro)
        }

        val response = LoginResponse(
            id = user.id,
            nome = user.nome,
            email = user.email
        )
        return ResponseEntity.ok(response)
    }
}