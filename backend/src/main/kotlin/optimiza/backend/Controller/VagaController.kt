package optimiza.backend.Controller

import optimiza.backend.DTO.VagaRequest
import optimiza.backend.Service.MatchService
import optimiza.backend.Service.VagaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vagas")
class VagaController(private val vagaService: VagaService, private val matchService: MatchService) {

    @PostMapping
    fun cadastrarVaga(@RequestBody request: VagaRequest): ResponseEntity<Any> =
        vagaService.cadastrarVaga(request)

    @GetMapping
    fun listarOuFiltrarVagas(
        @RequestParam idArea: Int,
        @RequestParam(required = false) titulo: String?,
        @RequestParam(required = false) cargo: String?,
        @RequestParam(required = false) nivelFormacao: String?,
        @RequestParam(required = false) idioma: String?
    ): ResponseEntity<Any> {
        return if (titulo == null && cargo == null && nivelFormacao == null && idioma == null) {
            vagaService.listarVagasResumoPorArea(idArea)
        } else {
            vagaService.filtrarVagas(idArea, titulo, cargo, nivelFormacao, idioma)
        }
    }

    @GetMapping("/{idVagas}")
    fun buscarVagaPorId(@PathVariable idVagas: Int): ResponseEntity<Any> =
        vagaService.buscarVagaPorId(idVagas)

    @GetMapping("layout-vagas")
    fun layoutVagas(@RequestParam(required = false) idLayoutVaga: Int?): ResponseEntity<Any> {
        return if (idLayoutVaga != null) {
            vagaService.buscarPorId(idLayoutVaga)
        } else {
            ResponseEntity.ok(vagaService.listarResumido())
        }
    }

    @PutMapping("/aprovacao-rh/{idVaga}")
    fun aprovarOuReprovarRh(
        @PathVariable idVaga: Int,
        @RequestParam aprovado: Boolean
    ): ResponseEntity<Any> {
        val response = vagaService.aprovarOuReprovarRh(idVaga, aprovado)

        if (response.statusCode == HttpStatus.OK) {
            matchService.processarMatchParaVaga(idVaga)
        }

        return response
    }


    @GetMapping("/teste-match/{idVaga}")
    fun testeMatch(@PathVariable idVaga: Int) {
        matchService.processarMatchParaVaga(idVaga)
    }
}
