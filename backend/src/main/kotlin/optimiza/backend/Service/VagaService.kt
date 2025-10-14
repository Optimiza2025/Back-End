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

        val response = VagaResponse(
            id = salvo.id,
            titulo = salvo.titulo,
            cargo = salvo.cargo,
            experiencia = salvo.experiencia,
            nivelFormacao = salvo.nivelFormacao?.name,
            instituicaoEnsino = salvo.instituicaoEnsino,
            curso = salvo.curso,
            idiomas = salvo.idiomas,
            palavrasChave = salvo.palavrasChave,
            dataAbertura = salvo.dataAbertura,
            dataUpdate = salvo.dataUpdate,
            etapaVaga = salvo.etapaVaga.name,
            status = salvo.status.name,
            idArea = salvo.area.id
        )

        return ResponseEntity.status(201).body(response)
    }

    fun listarVagasResumoPorArea(idArea: Int): ResponseEntity<Any> {
        val area = areaRepository.findById(idArea).orElse(null)
            ?: return ResponseEntity.badRequest().body(mapOf("error" to "Área não encontrada"))

        val lista = if (area.nome == "Recursos Humanos") {
            vagaRepository.findAll().map {
                VagaResumoResponse(
                    titulo = it.titulo ?: "",
                    cargo = it.cargo,
                    nivelFormacao = it.nivelFormacao,
                    idiomas = it.idiomas,
                    etapaVaga = it.etapaVaga,
                    nomeArea = it.area.nome
                )
            }
        } else {
            vagaRepository.findByAreaId(idArea).map {
                VagaResumoResponse(
                    titulo = it.titulo ?: "",
                    cargo = it.cargo,
                    nivelFormacao = it.nivelFormacao,
                    idiomas = it.idiomas,
                    etapaVaga = it.etapaVaga,
                    nomeArea = area.nome
                )
            }
        }

        return ResponseEntity.ok(lista)
    }

    fun encontrarVagaPorId(id: Int): Vaga? {
        return vagaRepository.findById(id).orElse(null)
    }

    fun buscarVagaPorId(id: Int): ResponseEntity<Any> {
        val vaga = encontrarVagaPorId(id)
        return if (vaga != null) {
            val response = VagaResponse(
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
            ResponseEntity.ok(response)
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
        val response = vagas.map {
            VagaResumoResponse(
                titulo = it.titulo ?: "",
                cargo = it.cargo,
                nivelFormacao = it.nivelFormacao,
                idiomas = it.idiomas,
                etapaVaga = it.etapaVaga,
                nomeArea = it.area.nome
            )
        }
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
        vagaRepository.save(vagaAtualizada)

        return ResponseEntity.ok(mapOf("message" to "Etapa atualizada para ${novaEtapa.name} e Match com Candaditos Realizado"))
    }
}