package optimiza.backend.Service

import optimiza.backend.DTO.LayoutVagaResumoResponse
import optimiza.backend.DTO.VagaRequest
import optimiza.backend.DTO.VagaResponse
import optimiza.backend.DTO.VagaResumoResponse
import optimiza.backend.Domain.EtapaVaga
import optimiza.backend.Domain.NivelFormacao
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
    private val layoutVagasRepository: LayoutVagasRepository
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
            etapaVaga = EtapaVaga.Aguardando_aprovacao_RH,
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

        val lista = vagaRepository.findByAreaId(idArea).map {
            VagaResumoResponse(
                titulo = it.titulo ?: "",
                cargo = it.cargo,
                nivelFormacao = it.nivelFormacao,
                idiomas = it.idiomas,
                etapaVaga = it.etapaVaga,
                nomeArea = area.nome
            )
        }
        return ResponseEntity.ok(lista)
    }


    fun buscarVagaPorId(id: Int): ResponseEntity<Any> {
        val vaga = vagaRepository.findById(id)
        return if (vaga.isPresent) {
            val it = vaga.get()
            val response = VagaResponse(
                id = it.id,
                titulo = it.titulo,
                cargo = it.cargo,
                experiencia = it.experiencia,
                nivelFormacao = it.nivelFormacao?.name,
                instituicaoEnsino = it.instituicaoEnsino,
                curso = it.curso,
                idiomas = it.idiomas,
                palavrasChave = it.palavrasChave,
                dataAbertura = it.dataAbertura,
                dataUpdate = it.dataUpdate,
                etapaVaga = it.etapaVaga.name,
                status = it.status.name,
                idArea = it.area.id
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
        titulo: String?,
        cargo: String?,
        nivelFormacao: String?,
        idioma: String?
    ): ResponseEntity<Any> {
        val vagas = vagaRepository.filtrarVagas(titulo, cargo, nivelFormacao, idioma)
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

}