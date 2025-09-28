USE OPTIMIZA;

-- SELECT * FROM LAYOUT_VAGAS WHERE id = 1;
-- SELECT * FROM VAGA;

INSERT INTO AREA (nome_area) VALUES ('Financeiro');
INSERT INTO AREA (nome_area) VALUES ('Recursos Humanos');
INSERT INTO AREA (nome_area) VALUES ('TI');
INSERT INTO AREA (nome_area) VALUES ('Marketing');
INSERT INTO AREA (nome_area) VALUES ('Operacoes');

INSERT INTO CANDIDATO (
    nome, experiencia, cargo, nivel_formacao, instituicao_ensino, curso, idiomas, status, email, curriculo, data_update
) VALUES
(
	'Ana Santos',
    'Gerente de Projetos com 10 anos de experiência em TI, liderança de equipes multidisciplinares e gestão de orçamentos.',
    'Gerente de Projetos',
    'Pos_graduacao',
    'Universidade de São Paulo',
    'Gestão de Projetos e Negócios',
    '{"ingles": "C1", "espanhol": "B1"}',
    'Banco_de_talentos',
    'ana.santos@email.com',
    'Currículo completo disponível para análise. Especialista em metodologias ágeis como Scrum e Kanban.',
    '2025-09-10'
),
(
	'Joao Silva',
    'Desenvolvedor Web Front-End com 3 anos de experiência em React, Angular e Node.js. Foco em interfaces responsivas e usabilidade.',
    'Desenvolvedor Pleno',
    'Ensino_superior_completo',
    'Instituto Federal de Tecnologia',
    'Sistemas para Internet',
    '{"ingles": "B1"}',
    'Banco_de_talentos',
    'joao.silva@email.com',
    'Jovem profissional com portfólio de projetos disponíveis no GitHub. Paixão por criar soluções inovadoras.',
    '2025-09-10'
),
(
	'Maria Rodrigues Pereira',
    'Coordenador de Vendas com 7 anos de experiência no setor varejista. Responsável por treinamento de equipe, prospecção de clientes e metas de vendas.',
    'Coordenador de Vendas',
    'Ensino_superior_completo',
    'Universidade Federal do Rio de Janeiro',
    'Administração',
    '{"ingles": "A1"}',
    'Banco_de_talentos',
    'maria.rodrigues@email.com',
    'Profissional proativa e orientada a resultados, com histórico comprovado de aumento de receita e satisfação do cliente.',
    '2025-09-10'
),
(
	'Pedro Almeida',
    'Estagiário de Marketing Digital com conhecimento em SEO, Google Analytics e criação de conteúdo para mídias sociais.',
    'Estagiário em Marketing',
    'Ensino_superior_cursando',
    'Pontifícia Universidade Católica',
    'Publicidade e Propaganda',
    '{"ingles": "C1"}',
    'Banco_de_talentos',
    'pedro.almeida@email.com',
    'Bolsista de iniciação científica e participação em projetos de extensão universitária. Buscando primeira oportunidade.',
    '2025-09-10'
),
(
	'Carla Fernandes',
    'Assistente Administrativo com 2 anos de experiência em rotinas de escritório, controle de documentos e suporte a equipes.',
    'Assistente Administrativo',
    'Ensino_medio_completo',
    'Colégio Estadual Tiradentes',
    'Ensino Médio',
    '{"espanhol": "A1"}',
    'Banco_de_talentos',
    'carla.fernandes@email.com',
    'Organizada, atenta a detalhes e com excelentes habilidades de comunicação. Disponibilidade para início imediato.',
    '2025-09-10'
),
(
	'Carlos Pereira',
    '15 anos de experiência em gestão de operações, com foco em otimização de processos, logística e redução de custos. Liderança de equipes grandes e multifuncionais.',
    'Gerente de Operações',
    'Pos_graduacao',
    'Fundação Getúlio Vargas',
    'Gestão Empresarial',
    '{"ingles": "C1", "frances": "A1"}',
    'Banco_de_talentos',
    'carlos.pereira@email.com',
    'Histórico comprovado de melhoria de eficiência e produtividade. Experiência em multinacionais.',
    '2025-08-14'
),
(
	'Laura Alves',
    'Analista de Marketing Digital com 4 anos de experiência em campanhas de performance, gerenciamento de mídias pagas (Google Ads, Meta Ads) e análise de métricas.',
    'Analista de Marketing Digital',
    'Ensino_superior_completo',
    'Escola Superior de Propaganda e Marketing',
    'Comunicação Social - Publicidade e Propaganda',
    '{"ingles": "B1"}',
    'Banco_de_talentos',
    'laura.alves@email.com',
    'Certificado em Google Analytics e Google Ads. Habilidade com ferramentas de automação de marketing.',
    '2025-07-13'
),
(
	'Rafael Souza Santos',
    'Estagiário em Recursos Humanos com conhecimento em recrutamento e seleção, treinamento e desenvolvimento, e rotinas de departamento pessoal.',
    'Estagiário de RH',
    'Ensino_superior_cursando',
    'Universidade Federal de Minas Gerais',
    'Psicologia',
    '{"espanhol": "B1"}',
    'Banco_de_talentos',
    'rafael.souza@email.com',
    'Proativo, com vontade de aprender e contribuir para o ambiente de trabalho. Participação em projetos voluntários.',
    '2025-09-01'
),
(
	'Sofia Ribeiro Almeida Santos',
    'Enfermeiro com 8 anos de experiência em ambiente hospitalar, atuando em UTI e pronto-socorro. Foco em cuidados intensivos e atendimento de emergência.',
    'Enfermeiro',
    'Ensino_superior_completo',
    'Universidade Estadual de Campinas',
    'Enfermagem',
    '{"ingles": "C1"}',
    'Banco_de_talentos',
    'sofia.ribeiro@email.com',
    'Especialização em Terapia Intensiva. Dedicada e com alta capacidade de trabalho sob pressão.',
    '2025-07-03'
),
(
	'Bruno Gomes Fernandes',
    'Assistente Financeiro com 3 anos de experiência em contas a pagar e receber, conciliação bancária e fluxo de caixa. Atuação em pequenas e médias empresas.',
    'Assistente Financeiro',
    'Ensino_medio_completo',
    'Escola Técnica de Comércio',
    'Técnico em Contabilidade',
    '{"ingles": "A1"}',
    'Banco_de_talentos',
    'bruno.gomes@email.com',
    'Responsável, organizado e com bom conhecimento de planilhas Excel. Em busca de crescimento profissional.',
    '2025-07-05'
);

-- ---------------------------------------------------------------LayoutVagas------------------------------------------------------------------------------- 

INSERT INTO LAYOUT_VAGAS (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
-- 1. Estagiário Desenvolvedor
('Estagiário Desenvolvedor', 'estagiario', 'none', 'Ensino_superior_cursando', 'Sistemas de Informação, Ciência da Computação, Engenharia de Software ou áreas correlatas', '{"Português": "C2", "Inglês": "A2"}'),
-- 2. Desenvolvedor Back - Júnior
('Desenvolvedor Back - Júnior', 'analista-jr', '1-3', 'Ensino_superior_cursando', 'Ciência da Computação, Sistemas de Informação, Engenharia ou bootcamp/curso técnico relevante', '{"Português": "C2", "Inglês": "A2"}'),
-- 3. Desenvolvedor Back - Pleno
('Desenvolvedor Back - Pleno', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Ciência da Computação, Sistemas de Informação, Engenharia, pós/curso em arquitetura/distribuição é diferencial', '{"Português": "C2", "Inglês": "B1"}'),
-- 4. Desenvolvedor Back - Sênior
('Desenvolvedor Back - Sênior', 'analista-sr', '3-5', 'Ensino_superior_completo', 'Ciência da Computação, Engenharia de Software, Sistemas de Informação', '{"Português": "C2", "Inglês": "B2"}'),
-- 5. Desenvolvedor Front - Júnior
('Desenvolvedor Front - Júnior', 'analista-jr', '1-3', 'Ensino_superior_cursando', 'Sistemas de Informação, Ciência da Computação, Design/UX (parcialmente) ou bootcamp front-end', '{"Português": "C2", "Inglês": "A2"}'),
-- 6. Desenvolvedor Front - Pleno
('Desenvolvedor Front - Pleno', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Sistemas de Informação, Ciência da Computação, Design UX/UI, bootcamps avançados', '{"Português": "C2", "Inglês": "B1"}'),
-- 7. Desenvolvedor Front - Sênior
('Desenvolvedor Front - Sênior', 'analista-sr', '3-5', 'Ensino_superior_completo', 'Ciência da Computação, Engenharia, Design/UX com especializações', '{"Português": "C2", "Inglês": "B2"}'),
-- 8. Estagiário em Dados
('Estagiário em Dados', 'estagiario', 'none', 'Ensino_superior_cursando', 'Ciência de Dados, Estatística, Engenharia, Análise de Dados; cursos de SQL/Python/R/Power BI são diferenciais', '{"Português": "C2", "Inglês": "A2"}'),
-- 9. Analista de Dados - Júnior
('Analista de Dados - Júnior', 'analista-jr', '1-3', 'Ensino_superior_cursando', 'Estatística, Ciência de Dados, Engenharia, Sistemas de Informação', '{"Português": "C2", "Inglês": "A2"}'),
-- 10. Analista de Dados - Pleno
('Analista de Dados - Pleno', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Ciência de Dados, Estatística, Engenharia, Sistemas de Informação', '{"Português": "C2", "Inglês": "B1"}'),
-- 11. Analista de Dados - Sênior
('Analista de Dados - Sênior', 'analista-sr', '3-5', 'Pos_graduacao', 'Ciência de Dados, Estatística, Engenharia, pós em Data Science/Analytics', '{"Português": "C2", "Inglês": "B2"}'),
-- 12. Estagiário em Marketing / Propaganda
('Estagiário em Marketing / Propaganda', 'estagiario', 'none', 'Ensino_superior_cursando', 'Marketing, Publicidade, Comunicação, Design (com foco digital)', '{"Português": "C2", "Inglês": "A1"}'),
-- 13. Analista de Marketing - Júnior
('Analista de Marketing - Júnior', 'analista-jr', '1-3', 'Ensino_superior_cursando', 'Marketing, Publicidade, Comunicação, cursos em Ads/SEO/Analytics', '{"Português": "C2", "Inglês": "A2"}'),
-- 14. Analista de Marketing - Pleno
('Analista de Marketing - Pleno', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Marketing, Publicidade, Comunicação, Pós em Marketing Digital/Analytics', '{"Português": "C2", "Inglês": "B1"}'),
-- 15. Analista de Marketing - Sênior
('Analista de Marketing - Sênior', 'analista-sr', '3-5', 'Pos_graduacao', 'Marketing, Administração, Comunicação; especializações em Digital/Analytics', '{"Português": "C2", "Inglês": "B2"}'),
-- 16. Analista de Contabilidade
('Analista de Contabilidade', 'analista-jr', '1-3', 'Ensino_superior_completo', 'Ciências Contábeis; cursos em SPED, legislação tributária e Excel/ERP (Totvs, SAP) são diferenciais', '{"Português": "C2", "Inglês": "A1"}'),
-- 17. Assistente Administrativo
('Assistente Administrativo', 'analista-jr', '1-3', 'Ensino_medio_completo', 'Administração, Gestão, cursos em Office (Excel) e rotinas administrativas', '{"Português": "C2"}'),
-- 18. Gestor de Projetos
('Gestor de Projetos', 'manager', '3-5', 'Ensino_superior_completo', 'Administração, Engenharia, Sistemas de Informação; cursos/certificações em gestão de projetos e Agile', '{"Português": "C2", "Inglês": "B1"}'),
-- 19. Estágio em Design Gráfico
('Estágio em Design Gráfico ', 'estagiario', 'none', 'Ensino_superior_cursando', 'Design, Design Gráfico, Comunicação Visual, Publicidade ou áreas afins', '{"Português": "C2"}'),
-- 20. Designer Gráfico – Pleno / Sênior
('Designer Gráfico – Pleno / Sênior', 'analista-pl', '3-5', 'Ensino_superior_completo', 'Design Gráfico, Comunicação Visual ou similar', '{"Português": "C2"}'),
-- 21. UX/UI Designer Pleno
('UX/UI Designer Pleno', 'analista-pl', '1-3', 'Ensino_superior_cursando', 'Design, Design Gráfico, Comunicação Visual ou áreas afins', '{"Português": "C2"}'),
-- 22. UI/UX Designer Sênior
('UI/UX Designer Sênior', 'analista-sr', '5plus', 'Ensino_superior_completo', 'Design, Design de Produto, Comunicação ou similar', '{"Português": "C2", "Inglês": "B1"}'),
-- 23. Mid Level Product Designer
('Mid Level Product Designer', 'analista-pl', '3-5', 'Ensino_superior_completo', 'Design, Design Digital, Comunicação Visual, Interação ou similar', '{"Português": "C2", "Inglês": "A2"}'),
-- 24. Product Owner
('Product Owner', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Administração, Engenharia de Produção, Sistemas de Informação ou áreas relacionadas', '{"Inglês": "B2"}'),
-- 25. Scrum Master
('Scrum Master', 'analista-pl', '1-3', 'Ensino_superior_completo', 'Administração, Sistemas de Informação, Engenharia de Software ou áreas afins', '{"Inglês": "B1"}');