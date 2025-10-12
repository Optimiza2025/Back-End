package optimiza.backend.Controller

import optimiza.backend.Repository.CandidaturaRepository
import optimiza.backend.Service.CandidaturaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/candidaturas")
class CandidaturaController(
    private val candidaturaService: CandidaturaService
) {

    @GetMapping("/vaga")
    fun listarPorVaga(@RequestParam idVaga: Int): ResponseEntity<Any> {
        return candidaturaService.listarPorVaga(idVaga)
    }
}