package optimiza.backend.Controller

import optimiza.backend.DTO.VagaRequest
import optimiza.backend.Service.VagaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vagas")
class VagaController(private val vagaService: VagaService) {

    @PostMapping
    fun cadastrarVaga(@RequestBody request: VagaRequest): ResponseEntity<Any> =
        vagaService.cadastrarVaga(request)

    @GetMapping
    fun listarVagasResumo(): ResponseEntity<Any> =
        vagaService.listarVagasResumo()

    @GetMapping("/{idVagas}")
    fun buscarVagaPorId(@PathVariable idVagas: Int): ResponseEntity<Any> =
        vagaService.buscarVagaPorId(idVagas)
}