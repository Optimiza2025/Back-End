package optimiza.Controller

import optimiza.DTO.LoginRequest
import optimiza.Service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/optimiza/usuarios")
class UsuarioController(
    private val usuarioService: UsuarioService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        return  usuarioService.login(request)
    }
}