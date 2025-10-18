package optimiza.backend.Controller

import optimiza.backend.DTO.AvaliacaoRequestDTO
import optimiza.backend.Service.AvaliacaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/avaliacao")
class AvaliacaoController(
    private val avaliacaoService: AvaliacaoService
) {

    @PostMapping("/avaliar")
    fun avaliarCandidato(
        @RequestBody request: AvaliacaoRequestDTO,
        @RequestParam aprovado: Boolean
    ): ResponseEntity<Any> {
        return avaliacaoService.avaliarCandidato(request, aprovado)
    }


    @GetMapping("/historico")
    fun listarAvaliacoesPorCandidato(
        @RequestParam idCandidato: Int
    ): ResponseEntity<Any> {
        return avaliacaoService.listarAvaliacoesPorCandidato(idCandidato)
    }
}