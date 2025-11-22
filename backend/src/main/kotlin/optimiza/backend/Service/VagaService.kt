package optimiza.backend.Service

import optimiza.backend.DTO.LayoutVagaResumoResponse
import optimiza.backend.DTO.VagaRequest
import optimiza.backend.DTO.VagaResponse
import optimiza.backend.DTO.VagaResumoResponse
import optimiza.backend.Domain.EtapaVaga
import optimiza.backend.Domain.StatusVaga
import optimiza.backend.Domain.Vaga
import optimiza.backend.Repository.AreaRepository
import optimiza.backend.Repository.LayoutVagasRepository
import optimiza.backend.Repository.VagaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class VagaService(
    private val vagaRepository: VagaRepository,
    private val areaRepository: AreaRepository,
    private val layoutVagasRepository: LayoutVagasRepository,
) {
    fun cadastrarVaga(request: VagaRequest): ResponseEntity<Any> {
        val area = areaRepository.findById(request.idArea).orElse(null)
            ?: return ResponseEntity.badRequest().body(mapOf("error" to "Área não encontrada"))

        val vaga = Vaga(
            titulo = request.titulo,
            cargo = request.cargo,
            experiencia = request.experiencia,
            nivelFormacao = request.nivelFormacao,
            instituicaoEnsino = request.instituicaoEnsino,
            curso = request.curso,
            idiomas = request.idiomas,
            palavrasChave = request.palavrasChave,
            dataAbertura = LocalDate.now(),
            dataUpdate = LocalDate.now(),
            dataFechamento = null,
            etapaVaga = EtapaVaga.Aguardando_aprovacao_rh,
            status = StatusVaga.ativa,
            area = area
        )

        val salvo = vagaRepository.save(vaga)
        return ResponseEntity.status(201).body(mapearParaResponse(salvo))
    }

    fun atualizarVaga(idVaga: Int, request: VagaRequest): ResponseEntity<Any> {
        val vagaOpt = vagaRepository.findById(idVaga)
        if (vagaOpt.isEmpty) return ResponseEntity.notFound().build()

        val area = areaRepository.findById(request.idArea).orElse(null)
            ?: return ResponseEntity.badRequest().body(mapOf("error" to "Área não encontrada"))

        val vagaExistente = vagaOpt.get()

        // Atualiza os campos mantendo o ID, datas originais e status atual
        val vagaAtualizada = vagaExistente.copy(
            titulo = request.titulo,
            cargo = request.cargo,
            experiencia = request.experiencia,
            nivelFormacao = request.nivelFormacao,
            instituicaoEnsino = request.instituicaoEnsino,
            curso = request.curso,
            idiomas = request.idiomas,
            palavrasChave = request.palavrasChave,
            area = area,
            dataUpdate = LocalDate.now()
        )

        val salvo = vagaRepository.save(vagaAtualizada)
        return ResponseEntity.ok(mapearParaResponse(salvo))
    }

    fun encerrarVaga(idVaga: Int): ResponseEntity<Any> {
        val vagaOpt = vagaRepository.findById(idVaga)
        if (vagaOpt.isEmpty) return ResponseEntity.notFound().build()

        val vaga = vagaOpt.get()

        val vagaEncerrada = vaga.copy(
            status = StatusVaga.encerrada,
            dataFechamento = LocalDate.now(),
            dataUpdate = LocalDate.now()
        )

        val salvo = vagaRepository.save(vagaEncerrada)
        return ResponseEntity.ok(mapearParaResponse(salvo))
    }

    fun concluirVaga(idVaga: Int): ResponseEntity<Any> {
        val vagaOpt = vagaRepository.findById(idVaga)
        if (vagaOpt.isEmpty) return ResponseEntity.notFound().build()

        val vaga = vagaOpt.get()

        val vagaConcluida = vaga.copy(
            status = StatusVaga.concluida,
            etapaVaga = EtapaVaga.Admissao_concluida,
            dataFechamento = LocalDate.now(),
            dataUpdate = LocalDate.now()
        )

        val salvo = vagaRepository.save(vagaConcluida)
        return ResponseEntity.ok(mapearParaResponse(salvo))
    }

    fun listarVagasResumoPorArea(idArea: Int): ResponseEntity<Any> {
        val area = areaRepository.findById(idArea).orElse(null)
            ?: return ResponseEntity.badRequest().body(mapOf("error" to "Área não encontrada"))

        val lista = if (area.nome == "Recursos Humanos") {
            vagaRepository.findAll().map { mapearParaResumo(it, it.area.nome!!) }
        } else {
            vagaRepository.findByAreaId(idArea).map { mapearParaResumo(it, area.nome!!) }
        }
        return ResponseEntity.ok(lista)
    }

    fun encontrarVagaPorId(id: Int): Vaga? {
        return vagaRepository.findById(id).orElse(null)
    }

    fun buscarVagaPorId(id: Int): ResponseEntity<Any> {
        val vaga = encontrarVagaPorId(id)
        return if (vaga != null) {
            ResponseEntity.ok(mapearParaResponse(vaga))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    fun listarResumido(): List<LayoutVagaResumoResponse> =
        layoutVagasRepository.findAll().map { LayoutVagaResumoResponse(it.id, it.titulo!!) }

    fun buscarPorId(id: Int): ResponseEntity<Any> {
        val layout = layoutVagasRepository.findById(id)
        return if (layout.isPresent) ResponseEntity.ok(layout.get())
        else ResponseEntity.notFound().build()
    }

    fun filtrarVagas(
        idArea: Int,
        titulo: String?,
        cargo: String?,
        nivelFormacao: String?,
        idioma: String?
    ): ResponseEntity<Any> {
        val vagas = vagaRepository.filtrarVagas(idArea, titulo, cargo, nivelFormacao, idioma)
        val response = vagas.map { mapearParaResumo(it, it.area.nome!!) }
        return ResponseEntity.ok(response)
    }

    fun aprovarOuReprovarRh(idVaga: Int, aprovado: Boolean): ResponseEntity<Any> {
        val vagaOpt = vagaRepository.findById(idVaga)
        if (!vagaOpt.isPresent) return ResponseEntity.notFound().build()

        val vaga = vagaOpt.get()

        if (vaga.etapaVaga != EtapaVaga.Aguardando_aprovacao_rh) {
            return ResponseEntity.badRequest().body(mapOf("error" to "Vaga não está aguardando aprovação do RH"))
        }

        val novaEtapa = if (aprovado) EtapaVaga.Entrevista_candidatos else EtapaVaga.Negada_rh
        val novoStatus = if (novaEtapa == EtapaVaga.Negada_rh) StatusVaga.encerrada else StatusVaga.ativa

        val vagaAtualizada = vaga.copy(etapaVaga = novaEtapa, status = novoStatus, dataUpdate = LocalDate.now())
        val salvo = vagaRepository.save(vagaAtualizada)

        return ResponseEntity.ok(mapearParaResponse(salvo))
    }

    // --- MÉTODOS AUXILIARES (Para evitar duplicação de código) ---
    private fun mapearParaResponse(vaga: Vaga): VagaResponse {
        return VagaResponse(
            id = vaga.id,
            titulo = vaga.titulo,
            cargo = vaga.cargo,
            experiencia = vaga.experiencia,
            nivelFormacao = vaga.nivelFormacao?.name,
            instituicaoEnsino = vaga.instituicaoEnsino,
            curso = vaga.curso,
            idiomas = vaga.idiomas,
            palavrasChave = vaga.palavrasChave,
            dataAbertura = vaga.dataAbertura,
            dataUpdate = vaga.dataUpdate,
            etapaVaga = vaga.etapaVaga.name,
            status = vaga.status.name,
            idArea = vaga.area.id
        )
    }

    private fun mapearParaResumo(vaga: Vaga, nomeArea: String): VagaResumoResponse {
        return VagaResumoResponse(
            idVaga = vaga.id,
            titulo = vaga.titulo ?: "",
            cargo = vaga.cargo,
            nivelFormacao = vaga.nivelFormacao,
            idiomas = vaga.idiomas,
            etapaVaga = vaga.etapaVaga,
            nomeArea = nomeArea
        )
    }
}