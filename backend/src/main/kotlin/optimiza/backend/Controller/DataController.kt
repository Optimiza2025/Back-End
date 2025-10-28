package optimiza.backend.Controller

import optimiza.backend.DTO.GrafanaHealthCheck
import optimiza.backend.Service.DataService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/data")
class DataController(
    private val dataService: DataService
) {

    /**
     * Health Check - Agora retorna um JSON
     */
    @GetMapping
    fun healthCheck(): ResponseEntity<GrafanaHealthCheck> {
        // Você precisa criar e retornar a instância do DTO
        val responseBody = GrafanaHealthCheck(message = mapOf("status" to "API Grafana OK"))
        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/gestores")
    fun getGestores(): ResponseEntity<List<String>> {
        val data = dataService.getGestores()
        return ResponseEntity.ok(data)
    }

    /**
     * Rota para buscar o volume de vagas por mês.
     */
    @GetMapping("/vagas/volume-por-mes")
    fun getVolumeVagas(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVolumeVagasPorMes(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Rota para buscar o total de vagas fracassadas.
     */
    @GetMapping("/vagas/fracassadas")
    fun getVagasFracassadas(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVagasFracassadas(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Rota para buscar a média de matching.
     */
    @GetMapping("/candidaturas/media-matching")
    fun getMediaMatching(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getMediaMatching(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Rota para buscar as médias de reprovação.
     */
    @GetMapping("/avaliacoes/media-reprovacao")
    fun getMediaReprovacao(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getMediaReprovacao(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }
}