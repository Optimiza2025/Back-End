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
     * Health Check
     */
    @GetMapping
    fun healthCheck(): ResponseEntity<GrafanaHealthCheck> {
        val responseBody = GrafanaHealthCheck(message = mapOf("status" to "API Grafana OK"))
        return ResponseEntity.ok(responseBody)
    }

    // =========================================================================
    // ENDPOINTS GESTOR (FILTRADOS POR USER ID)
    // =========================================================================

    @GetMapping("/gestores")
    fun getGestores(): ResponseEntity<List<String>> {
        val data = dataService.getGestores()
        return ResponseEntity.ok(data)
    }

    @GetMapping("/vagas/volume-por-mes")
    fun getVolumeVagas(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVolumeVagasPorMes(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    @GetMapping("/vagas/fracassadas")
    fun getVagasFracassadas(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVagasFracassadas(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    @GetMapping("/candidaturas/media-matching")
    fun getMediaMatching(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getMediaMatching(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    @GetMapping("/avaliacoes/media-reprovacao")
    fun getMediaReprovacao(
        @RequestParam("userId") userId: Int,
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getMediaReprovacao(userId, dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    // =========================================================================
    // ENDPOINTS RH VISÃO GLOBAL
    // =========================================================================

    /**
     * Volume de Vagas Global (Mensal)
     */
    @GetMapping("/rh/vagas/volume-global")
    fun getVolumeVagasGlobal(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVolumeVagasGlobal(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Principais Motivos de Reprovação (Global)
     */
    @GetMapping("/rh/avaliacoes/media-reprovacao-global")
    fun getMediaReprovacaoGlobal(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getMediaReprovacaoGlobal(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Tempo Médio de Contratação (Time to Fill)
     */
    @GetMapping("/rh/kpi/tempo-medio-contratacao")
    fun getTempoMedioContratacao(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<Map<String, Any?>> {
        val data = dataService.getTempoMedioContratacao(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Volume de Vagas Fracassadas (Churn Global)
     */
    @GetMapping("/rh/vagas/fracassadas-global")
    fun getVagasFracassadasGlobal(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<Map<String, Any?>> {
        val data = dataService.getVagasFracassadasGlobal(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Total de Candidaturas (Mensal)
     */
    @GetMapping("/rh/candidaturas/volume-global")
    fun getVolumeCandidaturasGlobal(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getVolumeCandidaturasGlobal(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }

    /**
     * Recência do Banco de Talentos
     */
    @GetMapping("/rh/kpi/recencia-banco")
    fun getRecenciaBancoTalentos(): ResponseEntity<Map<String, Any?>> {
        val data = dataService.getRecenciaBancoTalentos()
        return ResponseEntity.ok(data)
    }

    /**
     * Perfil Acadêmico dos Inscritos
     */
    @GetMapping("/rh/candidatos/perfil-academico")
    fun getPerfilAcademicoGlobal(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataInicio: LocalDate,
        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) dataFim: LocalDate
    ): ResponseEntity<List<Map<String, Any?>>> {
        val data = dataService.getPerfilAcademicoGlobal(dataInicio, dataFim)
        return ResponseEntity.ok(data)
    }
}