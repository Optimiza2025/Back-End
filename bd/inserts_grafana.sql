USE OPTIMIZA;

-- ------------------------------------------------------------------
-- Tabela: USUARIO
-- (Usuários 1, 2, 3 originais + Usuário 4 para 'Financeiro')
-- ------------------------------------------------------------------
INSERT INTO USUARIO (id_usuario, nome, email, senha, telefone, cpf, id_area) VALUES
(1, 'Eduardo', 'edu@gmail.com', '$2a$10$BYYKpZRyOcZ1OQd0wmub2.V14abBZq3oLWcsGynWIYE/2Pt5CpeCi', '119887643627', '43212398712', 3),
(2, 'Fabiano', 'gs901867@gmail.com', '$2a$10$8/bv7VdPwlpa.1bhyvT2F.dXIuSXwxCkAOl.k71ew0OlehU1iRbXK', '119887643625', '67387276576', 2),
(3, 'Guilherme', 'gui@ti.com', '$2a$10$1i0lputJY1fgC6HRfpophe/XUW1Lip6OmlmcFTtrUbxcdWho.NGPq', '11975847598', '57643567872', 3),
(4, 'Carlos Silva', 'carlos@financeiro.com', '$2a$10$8/bv7VdPwlpa.1bhyvT2F.dXIuSXwxCkAOl.k71ew0OlehU1iRbXK', '11988887777', '12345678900', 1),
(5, 'Maria Marketing', 'maria@marketing.com', '$2a$10$8/bv7VdPwlpa.1bhyvT2F.dXIuSXwxCkAOl.k71ew0OlehU1iRbXK', '11900004444', '44444444444', 4),
(6, 'Joao Operacoes', 'joao@operacoes.com', '$2a$10$8/bv7VdPwlpa.1bhyvT2F.dXIuSXwxCkAOl.k71ew0OlehU1iRbXK', '11900005555', '55555555555', 5);

-- ------------------------------------------------------------------
-- Tabela: VAGA
-- (Vagas 1-7 dos scripts anteriores + Vaga 8 para 'Financeiro')
-- ------------------------------------------------------------------
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino, 
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento, 
    etapa_vaga, status, id_area
) VALUES 
(1,
 'Analista de Sistemas Pleno',
 'Analista',
 '3+ anos',
 'Ensino_superior_completo',
 'FGV',
 'Sistemas de Informação, Ciência da Computação ou Engenharia de Software',
 '{"Inglês": "B2", "Português": "C2"}',
 '["Modelagem de Sistemas", "Levantamento de Requisitos", "SQL", "APIs REST", "Documentação Técnica", "UML", "Scrum"]',
 '2025-02-15',
 '2025-04-10',
 '2025-04-10',
 'Admissao_concluida',
 'concluida',
 1
),
(2, 'Analista Financeiro Pleno', 'Analista', '3+ anos', 'Ensino_superior_completo', 'FGV', 'Administração, Economia ou Contabilidade', '{"Inglês": "B2", "Português": "C2"}', '["Fluxo de Caixa", "Contas a Pagar", "Excel", "Power BI", "ERP"]', '2025-02-15', '2025-04-10', '2025-04-10', 'Admissao_concluida', 'concluida', 1),
(3, 'Analista de RH Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'Anhembi Morumbi', 'Psicologia, Administração ou Gestão de RH', '{"Inglês": "B1", "Português": "C2"}', '["Recrutamento", "Seleção", "Onboarding", "Folha de Pagamento"]', '2025-03-01', '2025-05-15', '2025-05-15', 'Negada_rh', 'encerrada', 2),
(4, 'Business Partner', 'Coordenador', '5+ anos', 'Pos_graduacao', 'Insper', 'Gestão de Pessoas, Psicologia Organizacional ou Administração', '{"Inglês": "C1", "Português": "C2"}', '["Business Partner", "Gestão de Clima", "Desenvolvimento", "Liderança"]', '2025-04-05', '2025-04-05', NULL, 'Aguardando_aprovacao_rh', 'ativa', 2),
(5, 'Especialista em SEO', 'Especialista', '5+ anos', 'Pos_graduacao', 'ESPM', 'Marketing, Publicidade ou Comunicação', '{"Inglês": "C1", "Português": "C2"}', '["SEO", "SEM", "Google Analytics", "Keyword Research", "Link Building"]', '2025-06-01', '2025-06-01', NULL, 'Entrevista_candidatos', 'ativa', 4),
(6, 'Desenvolvedor Backend Sr.', 'analista-sr', '5+ anos', 'Ensino_superior_completo', 'FIAP', 'Engenharia de Software, Ciência da Computação ou correlatas', '{"Inglês": "B2", "Português": "C2"}', '["Java", "Spring Boot", "Microsserviços", "Kafka", "Docker", "PostgreSQL"]', '2025-01-20', '2025-03-01', '2025-03-01', 'Admissao_concluida', 'concluida', 3),
(7, 'Analista de Logística', 'Analista', '3+ anos', 'Ensino_superior_completo', 'Fatec', 'Logística, Engenharia de Produção ou Administração', '{"Inglês": "B1", "Português": "C2"}', '["Cadeia de Suprimentos", "WMS", "TMS", "Gestão de Frota", "Inventário"]', '2025-02-01', '2025-03-10', '2025-03-10', 'Negada_rh', 'encerrada', 5),
(8, 'Estagiário de Controladoria', 'estagiario', '1+ ano', 'Ensino_superior_cursando', 'Mackenzie', 'Ciências Contábeis ou Economia', '{"Inglês": "A2", "Português": "C2"}', '["Controladoria", "Orçamento", "Forecast", "Excel", "Contabilidade"]', '2025-09-01', '2025-09-10', NULL, 'Entrevista_candidatos', 'ativa', 1);

-- ------------------------------------------------------------------
-- Tabela: CANDIDATURA
-- (Candidaturas 1-33 dos scripts anteriores + 34-35 para Vaga 8)
-- ------------------------------------------------------------------
INSERT INTO CANDIDATURA (id_candidatura, id_vaga, id_candidato, status, matching, matches) VALUES
-- Vaga 1 (TI)
(1, 1, 1, 'em_analise', 0.32, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(2, 1, 3, 'em_analise', 0.32, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(3, 1, 5, 'em_analise', 0.18, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(4, 1, 6, 'em_analise', 0.36, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.5", "instituicao_ensino": "0.0"}'),
(5, 1, 14, 'em_analise', 0.32, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(6, 1, 20, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(7, 1, 23, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(8, 1, 24, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(9, 1, 26, 'em_analise', 0.32, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(10, 1, 27, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(11, 1, 29, 'em_analise', 0.18, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(12, 1, 30, 'em_analise', 0.32, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(13, 1, 34, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(14, 1, 39, 'em_analise', 0.32, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(15, 1, 42, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(16, 1, 58, 'aprovado', 0.50, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.5", "instituicao_ensino": "0.0"}'),
(17, 1, 59, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(18, 1, 60, 'em_analise', 0.32, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(19, 1, 67, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(20, 1, 69, 'em_analise', 0.32, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(21, 1, 71, 'em_analise', 0.32, '{"cargo": "0.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(22, 1, 73, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(23, 1, 75, 'em_analise', 0.32, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "0.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),
(24, 1, 80, 'em_analise', 0.46, '{"cargo": "1.0", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}');


INSERT INTO CANDIDATURA (id_candidatura, id_vaga, id_candidato, status, matching, matches) VALUES
-- Vaga 2 (Financeiro)
(25, 2, 101, 'aprovado', 0.85, '{"cargo": "1.0", "curso": "1.0", "idiomas": "0.5", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "1.0", "instituicao_ensino": "0.5"}'),
(26, 2, 104, 'reprovado', 0.40, '{"cargo": "0.5", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),

-- Vaga 3 (RH)
(27, 3, 116, 'reprovado', 0.70, '{"cargo": "1.0", "curso": "1.0", "idiomas": "0.5", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.5", "instituicao_ensino": "0.0"}'),
(28, 3, 123, 'reprovado', 0.50, '{"cargo": "1.0", "curso": "0.5", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.0", "instituicao_ensino": "0.0"}'),
(33, 3, 118, 'reprovado', 0.40, '{"cargo": "0.5", "curso": "0.0", "idiomas": "0.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),

-- Vaga 5 (Marketing)
(29, 5, 127, 'em_analise', 0.90, '{"cargo": "1.0", "curso": "1.0", "idiomas": "1.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "1.0", "instituicao_ensino": "0.25"}'),

-- Vaga 6 (TI)
(30, 6, 67, 'aprovado', 0.95, '{"cargo": "1.0", "curso": "1.0", "idiomas": "1.0", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "1.0", "instituicao_ensino": "0.5"}'),
(31, 6, 34, 'reprovado', 0.60, '{"cargo": "1.0", "curso": "0.5", "idiomas": "0.5", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.25", "instituicao_ensino": "0.0"}'),

-- Vaga 7 (Operações)
(32, 7, 136, 'reprovado', 0.55, '{"cargo": "1.0", "curso": "0.5", "idiomas": "0.25", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.0", "instituicao_ensino": "0.0"}'),

-- Vaga 8 (Financeiro) - NOVAS
(34, 8, 111, 'reprovado', 0.65, '{"cargo": "1.0", "curso": "0.5", "idiomas": "0.5", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.5", "instituicao_ensino": "0.0"}'),
(35, 8, 107, 'em_analise', 0.70, '{"cargo": "1.0", "curso": "1.0", "idiomas": "0.5", "formacao": "1.0", "experiencia": "1.0", "palavras_chave": "0.5", "instituicao_ensino": "0.0"}');

-- ------------------------------------------------------------------
-- Tabela: AVALIACAO
-- (Avaliações 1-6 dos scripts anteriores + Avaliação 7 para Vaga 8)
-- ------------------------------------------------------------------
INSERT INTO AVALIACAO (
    id_avaliacao, id_candidatura, id_usuario_avaliador, 
    hard_skills, soft_skills, experiencia, cultura, 
    comentario, data_avaliacao
) VALUES 
(1, 16, 1, 4.00, 2.00, 3.00, 2.00, 'Muito bom técnicamente, porém falta tato na conversa', '2025-10-25'),
(2, 26, 2, 3.0, 2.0, 2.0, 1.0, 'Falta senioridade para a vaga', '2025-04-01'),
(3, 27, 1, 4.0, 3.0, 3.0, 2.0, 'Bom perfil, mas fora do budget', '2025-05-10'),
(4, 31, 3, 4.0, 3.0, 2.0, 3.0, 'Boa técnica, mas experiência não focada em microsserviços', '2025-02-25'),
(5, 32, 1, 3.0, 3.0, 3.0, 1.0, 'Não demonstrou fit cultural com a empresa.', '2025-03-05'),
(6, 33, 2, 2.0, 4.0, 2.0, 4.0, 'Excelente fit cultural, mas pouca experiência técnica na vaga.', '2025-05-12'),
(7, 34, 4, 2.0, 4.0, 1.0, 4.0, 'Ótimo fit, mas falta conhecimento técnico em Excel.', '2025-09-15');