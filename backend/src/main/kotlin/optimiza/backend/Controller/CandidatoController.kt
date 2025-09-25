package optimiza.backend.Controller

import optimiza.backend.DTO.CandidatoRequest
import optimiza.backend.Service.CandidatoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/candidatos")
class CandidatoController(private val candidatoService: CandidatoService) {

    @PostMapping
    fun cadastrar(@RequestBody request: CandidatoRequest): ResponseEntity<Any> =
        candidatoService.cadastrarCandidato(request)

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): ResponseEntity<Any> =
        candidatoService.buscarCandidatoPorId(id)

    @GetMapping()
    fun listarResumo(): ResponseEntity<Any> =
        candidatoService.listarCandidatosResumo()

    @GetMapping("/filtro")
    fun filtrarCandidatos(
        @RequestParam(required = false) nome: String?,
        @RequestParam(required = false) nivelFormacao: String?,
        @RequestParam(required = false) curso: String?,
        @RequestParam(required = false) status: String?
    ): ResponseEntity<Any> {
        return candidatoService.filtrarCandidatos(nome, nivelFormacao, curso, status)
    }

}