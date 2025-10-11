package optimiza.backend.Service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import optimiza.backend.DTO.CandidatoRequest
import optimiza.backend.DTO.CandidatoResponse
import optimiza.backend.DTO.CandidatoResumo
import optimiza.backend.DTO.ErrorResponse
import optimiza.backend.Domain.Candidato
import optimiza.backend.Domain.StatusCandidato
import optimiza.backend.Repository.CandidatoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CandidatoService(private val candidatoRepository: CandidatoRepository) {

    private val objectMapper = jacksonObjectMapper()

    fun cadastrarCandidato(request: CandidatoRequest): ResponseEntity<Any> {
        return try {
            val idiomasJson = request.idiomas?.let { objectMapper.writeValueAsString(it) }

            val candidato = Candidato(
                nome = request.nome,
                experiencia = request.experiencia,
                cargo = request.cargo,
                nivelFormacao = request.nivelFormacao,
                instituicaoEnsino = request.instituicaoEnsino,
                curso = request.curso,
                idiomas = idiomasJson,
                status = StatusCandidato.Banco_de_talentos,
                email = request.email,
                curriculo = request.curriculo,
                dataUpdate = request.dataUpdate?.let { LocalDate.parse(it) }
            )

            val salvo = candidatoRepository.save(candidato)
            ResponseEntity.ok(
                CandidatoResponse(
                    id = salvo.id,
                    nome = salvo.nome,
                    experiencia = salvo.experiencia,
                    cargo = salvo.cargo,
                    nivelFormacao = salvo.nivelFormacao!!.name,
                    instituicaoEnsino = salvo.instituicaoEnsino,
                    curso = salvo.curso,
                    idiomas = salvo.idiomas?.let { objectMapper.readValue<Map<String, String>>(it) },
                    status = salvo.status.name,
                    email = salvo.email ?: "",
                    curriculo = salvo.curriculo,
                    dataUpdate = salvo.dataUpdate?.toString()
                )
            )
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ErrorResponse("Erro ao cadastrar candidato: ${e.message}"))
        }
    }

    fun encontrarCandidatoPorId(id: Int): Candidato? {
        return candidatoRepository.findById(id).orElse(null)
    }

    fun buscarCandidatoPorId(id: Int): ResponseEntity<Any> {
        val candidato = encontrarCandidatoPorId(id)
        return if (candidato != null) {
            ResponseEntity.ok(
                CandidatoResponse(
                    id = candidato.id,
                    nome = candidato.nome,
                    experiencia = candidato.experiencia,
                    cargo = candidato.cargo,
                    nivelFormacao = candidato.nivelFormacao?.name ?: "",
                    instituicaoEnsino = candidato.instituicaoEnsino,
                    curso = candidato.curso,
                    idiomas = candidato.idiomas?.let { objectMapper.readValue<Map<String, String>>(it) },
                    status = candidato.status.name,
                    email = candidato.email ?: "",
                    curriculo = candidato.curriculo,
                    dataUpdate = candidato.dataUpdate?.toString()
                )
            )
        } else {
            ResponseEntity.status(404).body(ErrorResponse("Candidato não encontrado"))
        }
    }

    fun listarCandidatosResumo(): ResponseEntity<Any> {
        val lista = candidatoRepository.findAll().map {
            CandidatoResumo(
                id = it.id,
                nome = it.nome ?: "",
                nivelFormacao = it.nivelFormacao,
                curso = it.curso,
                status = it.status
            )
        }
        return ResponseEntity.ok(lista)
    }

    fun filtrarCandidatos(
        nome: String?,
        nivelFormacao: String?,
        curso: String?,
        status: String?
    ): ResponseEntity<Any> {
        return try {
            val lista = candidatoRepository.filtrarCandidatos(nome, nivelFormacao, curso, status)
                .map {
                    CandidatoResumo(
                        id = it.id,
                        nome = it.nome ?: "",
                        nivelFormacao = it.nivelFormacao,
                        curso = it.curso,
                        status = it.status
                    )
                }
            ResponseEntity.ok(lista)
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ErrorResponse("Erro ao filtrar candidatos: ${e.message}"))
        }
    }

    fun buscarCandidatosPorPalavrasChave(palavrasChave: List<String>): List<Candidato> {
        val palavrasLower = palavrasChave.map { it.lowercase() }

        val candidatosResumidos = candidatoRepository.buscarCamposResumidos()

        val idsFiltrados = candidatosResumidos.filter { candidato ->
            listOf(
                candidato.experiencia,
                candidato.cargo,
                candidato.instituicaoEnsino,
                candidato.curso,
                candidato.curriculo
            ).filterNotNull().any { campo ->
                palavrasLower.any { palavra -> campo.lowercase().contains(palavra) }
            }
        }.map { it.id }

        println(idsFiltrados)
        return candidatoRepository.findAllById(idsFiltrados)
    }

}