SET @ID_USUARIO_LOGADO = 1;
SET @DATA_INICIO = '2020-01-01';
SET @DATA_FIM = '2025-12-31';

-- Mostrar o volume de novas vagas que o gestor abriu ao longo do tempo.
SELECT 
      DATE_FORMAT(v.data_abertura, '%Y-%m') AS ano_mes, 
      COUNT(v.id_vaga) AS total_vagas_abertas
    FROM optimiza.vaga v
    JOIN optimiza.usuario u ON v.id_area = u.id_area 
    WHERE u.id_usuario = @ID_USUARIO_LOGADO
      AND v.data_abertura BETWEEN @DATA_INICIO AND @DATA_FIM
    GROUP BY ano_mes 
    ORDER BY ano_mes ASC;
    
-- KPI de "vagas fracassadas". Quantas vagas da minha área foram fechadas sem um `status` de 'concluida'.    
    SELECT COUNT(*) AS total_encerradas
    FROM optimiza.vaga v
    JOIN optimiza.usuario u ON v.id_area = u.id_area 
    WHERE v.status = 'encerrada'
      AND u.id_usuario = @ID_USUARIO_LOGADO
      AND v.data_abertura >= @DATA_INICIO
      AND v.data_fechamento <= @DATA_FIM;
      
--  Média de Compatibilidade (Matching) dos Candidatos (da minha área), mostra se os candidatos que se aplicam às vagas da minha área são qualificados (matching alto) ou não.    
    SELECT AVG(c.matching) AS media_matching
    FROM optimiza.candidatura c
    JOIN optimiza.vaga v ON c.id_vaga = v.id_vaga 
    JOIN optimiza.usuario u ON v.id_area = u.id_area 
    WHERE u.id_usuario = @ID_USUARIO_LOGADO
      AND v.data_abertura BETWEEN @DATA_INICIO AND @DATA_FIM;  
      
--  Principais Motivos de Reprovação (na minha área), entender o motivo dos candidatos das minhas vagas estão sendo reprovados (pelas avaliações).      
	 SELECT 
      AVG(a.hard_skills) AS avg_hard_skills, 
      AVG(a.soft_skills) AS avg_soft_skills, 
      AVG(a.experiencia) AS avg_experiencia, 
      AVG(a.cultura) AS avg_cultura
    FROM optimiza.candidatura c
    JOIN optimiza.avaliacao a ON c.id_candidatura = a.id_candidatura
    JOIN optimiza.vaga v ON c.id_vaga = v.id_vaga
    JOIN optimiza.usuario u ON v.id_area = u.id_area  
    WHERE c.status = 'reprovado' 
      AND u.id_usuario = @ID_USUARIO_LOGADO
      AND v.data_abertura >= @DATA_INICIO
      AND v.data_fechamento <= @DATA_FIM;