package optimiza.backend.Service

import optimiza.backend.DTO.AvaliacaoRequestDTO
import optimiza.backend.DTO.AvaliacaoResponseDTO
import optimiza.backend.Domain.Avaliacao
import optimiza.backend.Domain.StatusCandidatura
import optimiza.backend.Repository.AvaliacaoRepository
import optimiza.backend.Repository.CandidaturaRepository
import optimiza.backend.Repository.UsuarioRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AvaliacaoService(
    private val avaliacaoRepository: AvaliacaoRepository,
    private val candidaturaRepository: CandidaturaRepository,
    private val usuarioRepository: UsuarioRepository
) {

    fun avaliarCandidato(
        request: AvaliacaoRequestDTO,
        aprovado: Boolean
    ): ResponseEntity<Any> {

        val candidatura = candidaturaRepository.findById(request.idCandidatura)
            .orElse(null) ?: return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to "Candidatura não encontrada."))

        val avaliador = usuarioRepository.findById(request.idAvaliador)
            .orElse(null) ?: return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to "Usuário avaliador não encontrado."))

        val avaliacaoExistente = avaliacaoRepository
            .findByCandidatura_IdAndAvaliador_Id(candidatura.id, request.idAvaliador)

        val avaliacao: Avaliacao = if (avaliacaoExistente != null) {
            val atualizada = avaliacaoExistente.copy(
                hard_skills = request.hardSkills,
                soft_skills = request.softSkills,
                experiencia = request.experiencia,
                cultura = request.cultura,
                comentario = request.comentario,
                dataAvaliacao = LocalDate.now()
            )
            avaliacaoRepository.save(atualizada)
            atualizada
        } else {
            val nova = Avaliacao(
                id = 0,
                candidatura = candidatura,
                avaliador = avaliador,
                hard_skills = request.hardSkills,
                soft_skills = request.softSkills,
                experiencia = request.experiencia,
                cultura = request.cultura,
                comentario = request.comentario,
                dataAvaliacao = LocalDate.now()
            )
            avaliacaoRepository.save(nova)
            nova
        }

        candidatura.status = if (aprovado) StatusCandidatura.aprovado else StatusCandidatura.reprovado
        candidaturaRepository.save(candidatura)

        return ResponseEntity.ok(
            mapOf(
                "message" to if (avaliacaoExistente != null)
                    "Avaliação atualizada com sucesso."
                else
                    "Avaliação registrada com sucesso.",
                "statusCandidatura" to candidatura.status.name
            )
        )
    }

    fun listarAvaliacoesPorCandidato(idCandidato: Int): ResponseEntity<Any> {
        if (idCandidato <= 0) {
            return ResponseEntity.badRequest()
                .body(mapOf("error" to "ID do candidato inválido."))
        }

        val avaliacoes = avaliacaoRepository.findByCandidatura_Candidato_Id(idCandidato)
        if (avaliacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(mapOf("message" to "Nenhuma avaliação encontrada para este candidato."))
        }

        val resposta = avaliacoes.map {
            AvaliacaoResponseDTO(
                idAvaliacao = it.id,
                idCandidatura = it.candidatura.id,
                idVaga = it.candidatura.vaga?.id ?: 0, // evita NullPointer
                nomeAvaliador = it.avaliador.nome,
                hardSkills = it.hard_skills,
                softSkills = it.soft_skills,
                experiencia = it.experiencia,
                cultura = it.cultura,
                comentario = it.comentario,
                dataAvaliacao = it.dataAvaliacao
            )
        }

        return ResponseEntity.ok(resposta)
    }

}