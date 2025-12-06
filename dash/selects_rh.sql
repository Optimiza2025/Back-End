SET @ID_USUARIO_LOGADO = 1;
SET @DATA_INICIO = '2020-01-01';
SET @DATA_FIM = '2025-12-31';

-- -----------------------------------------------------------------------------
-- 1. Volume de Vagas (COM VISÃO MENSAL)
-- -----------------------------------------------------------------------------
-- Objetivo: Mostrar a evolução da demanda do RH mês a mês.
SELECT 
    DATE_FORMAT(vaga.data_abertura, '%Y-%m') as mes_referencia,
    area.nome_area, 
    vaga.status, 
    COUNT(*) as num_vagas 
FROM vaga 
JOIN area ON vaga.id_area = area.id_area 
WHERE vaga.data_abertura BETWEEN @DATA_INICIO AND @DATA_FIM
GROUP BY mes_referencia, area.nome_area, vaga.status
ORDER BY mes_referencia ASC, area.nome_area ASC;


-- -----------------------------------------------------------------------------
-- 2. Principais Motivos de Reprovação (Visão Global)
-- -----------------------------------------------------------------------------
-- Objetivo: Entender onde os candidatos falham.
SELECT 
    AVG(av.hard_skills) as "Hard Skills", 
    AVG(av.soft_skills) as "Soft Skills", 
    AVG(av.experiencia) as "Experiencia",
    AVG(av.cultura) as "Cultura" 
FROM optimiza.avaliacao av
JOIN optimiza.candidatura c ON av.id_candidatura = c.id_candidatura
JOIN optimiza.vaga v ON c.id_vaga = v.id_vaga 
WHERE c.status = 'reprovado' 
  AND v.data_abertura >= @DATA_INICIO 
  AND (v.data_fechamento <= @DATA_FIM OR v.data_fechamento IS NULL);

-- -----------------------------------------------------------------------------
-- 3. Tempo Médio de Contratação (Time to Fill)
-- -----------------------------------------------------------------------------
-- Objetivo: Eficiência do processo.
SELECT 
    AVG(DATEDIFF(v.data_fechamento, v.data_abertura)) as media_dias_contratacao 
FROM optimiza.vaga v
WHERE v.etapa_vaga = 'Admissao_concluida' 
  AND v.status = 'concluida'
  AND v.data_fechamento BETWEEN @DATA_INICIO AND @DATA_FIM;

-- -----------------------------------------------------------------------------
-- 4. Volume de Vagas "Fracassadas" (Churn)
-- -----------------------------------------------------------------------------
-- Objetivo: Desperdício operacional.
SELECT 
    COUNT(*) as total_vagas_canceladas 
FROM optimiza.vaga v
WHERE v.status = 'encerrada' 
  AND v.etapa_vaga != 'Admissao_concluida' 
  AND v.data_fechamento BETWEEN @DATA_INICIO AND @DATA_FIM;

-- -----------------------------------------------------------------------------
-- 5. Total de Candidaturas (COM VISÃO MENSAL)
-- -----------------------------------------------------------------------------
-- Objetivo: Atratividade da marca empregadora ao longo do tempo.
SELECT 
    DATE_FORMAT(v.data_abertura, '%Y-%m') as mes_referencia,
    COUNT(*) as total_candidaturas 
FROM optimiza.candidatura c
JOIN optimiza.vaga v ON c.id_vaga = v.id_vaga
WHERE v.data_abertura BETWEEN @DATA_INICIO AND @DATA_FIM
GROUP BY mes_referencia
ORDER BY mes_referencia ASC;

-- -----------------------------------------------------------------------------
-- 6. Recência do Banco de Talentos
-- -----------------------------------------------------------------------------
-- Objetivo: "Saúde" do banco de dados hoje.
SELECT 
    AVG(DATEDIFF(CURDATE(), c.data_update)) as media_dias_sem_atualizar
FROM optimiza.candidato c
WHERE c.status = 'Banco_de_talentos';

-- -----------------------------------------------------------------------------
-- 7. Perfil Acadêmico dos Inscritos
-- -----------------------------------------------------------------------------
-- Objetivo: Qualificação do público alvo.
SELECT 
    c.nivel_formacao, 
    COUNT(*) as total
FROM optimiza.candidato c 
JOIN optimiza.candidatura cand ON cand.id_candidato = c.id_candidato
JOIN optimiza.vaga v ON cand.id_vaga = v.id_vaga 
WHERE v.data_abertura >= @DATA_INICIO 
  AND (v.data_fechamento <= @DATA_FIM OR v.data_fechamento IS NULL)
GROUP BY c.nivel_formacao 
ORDER BY c.nivel_formacao ASC;