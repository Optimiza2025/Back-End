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
    fun listarVagasResumo(@RequestParam idArea: Int): ResponseEntity<Any> {
        return vagaService.listarVagasResumoPorArea(idArea)
    }

    @GetMapping("/{idVagas}")
    fun buscarVagaPorId(@PathVariable idVagas: Int): ResponseEntity<Any> =
        vagaService.buscarVagaPorId(idVagas)

    @GetMapping("layout-vagas")
    fun listarResumido() = vagaService.listarResumido()

    @GetMapping("layout-vagas/{id}")
    fun buscarPorId(@PathVariable id: Int) = vagaService.buscarPorId(id)

    @GetMapping("/filtro")
    fun filtrarVagas(
        @RequestParam(required = false) titulo: String?,
        @RequestParam(required = false) cargo: String?,
        @RequestParam(required = false) nivelFormacao: String?,
        @RequestParam(required = false) idioma: String?
    ): ResponseEntity<Any> {
        return vagaService.filtrarVagas(titulo, cargo, nivelFormacao, idioma)
    }
}
