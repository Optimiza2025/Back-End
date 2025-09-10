package optimiza.backend.Service

import optimiza.backend.DTO.*
import optimiza.backend.Domain.Area
import optimiza.backend.Repository.AreaRepository
import optimiza.backend.Repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val areaRepository: AreaRepository
) {
    fun cadastrarUsuario(request: UsuarioRequest): ResponseEntity<Any> {
        if (usuarioRepository.findByEmail(request.email) != null) {
            return ResponseEntity.badRequest().body(ErrorResponse("Email já cadastrado", "email"))
        }
        if (request.cpf != null && usuarioRepository.findAll().any { it.cpf == request.cpf }) {
            return ResponseEntity.badRequest().body(ErrorResponse("CPF já cadastrado", "cpf"))
        }
        if (request.telefone != null && usuarioRepository.findAll().any { it.telefone == request.telefone }) {
            return ResponseEntity.badRequest().body(ErrorResponse("Telefone já cadastrado", "telefone"))
        }
        val area = areaRepository.findById(request.idArea)
        if (area.isEmpty) {
            return ResponseEntity.badRequest().body(ErrorResponse("Área não encontrada", "idArea"))
        }

        val usuario = optimiza.backend.Domain.Usuario(
            nome = request.nome,
            email = request.email,
            senha = passwordEncoder.encode(request.senha),
            telefone = request.telefone,
            cpf = request.cpf,
            area = area.get()
        )

        val salvo = usuarioRepository.save(usuario)

        val response = UsuarioResponse(
            id = salvo.id,
            nome = salvo.nome,
            email = salvo.email,
            telefone = salvo.telefone,
            cpf = salvo.cpf,
            idArea = salvo.area.id
        )

        return ResponseEntity.status(201).body(response)
    }


    fun login(request: LoginRequest): ResponseEntity<Any> {
        val usuario = usuarioRepository.findByEmail(request.email)

        if (usuario == null || !passwordEncoder.matches(request.senha, usuario.senha)) {
            val erro = Errologin(
                menssage = "Usuário ou senha inválidos",
                email = request.email
            )
            return ResponseEntity.status(401).body(erro)
        }

        val response = LoginResponse(
            id = usuario.id,
            nome = usuario.nome,
            area = usuario.area
        )
        return ResponseEntity.ok(response)
    }

    fun listarAreas(): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(areaRepository.findAll().map { Area(it.id, it.nome) })
    }

}