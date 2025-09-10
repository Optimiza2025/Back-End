package optimiza.backend.Controller

import optimiza.backend.DTO.LoginRequest
import optimiza.backend.DTO.UsuarioRequest
import optimiza.backend.Domain.Area
import optimiza.backend.Service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
) {
    @PostMapping("/cadastro")
    fun cadastrarUsuario(@RequestBody request: UsuarioRequest): ResponseEntity<Any> {
        return usuarioService.cadastrarUsuario(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        return  usuarioService.login(request)
    }

    @GetMapping("/areas")
    fun listarAreas(): ResponseEntity<Any> {
        return usuarioService.listarAreas()
    }

}