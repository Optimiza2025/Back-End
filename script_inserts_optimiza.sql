USE OPTIMIZA;

INSERT INTO AREA (nome_area) VALUES ('Financeiro');
INSERT INTO AREA (nome_area) VALUES ('Recursos Humanos');
INSERT INTO AREA (nome_area) VALUES ('TI');
INSERT INTO AREA (nome_area) VALUES ('Marketing');
INSERT INTO AREA (nome_area) VALUES ('Operações');

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
    '{"ingles": "avancado", "espanhol": "intermediario"}',
    'Banco_de_talentos',
    'ana.santos@email.com',
    'Currículo completo disponível para análise. Especialista em metodologias ágeis como Scrum e Kanban.',
    '2025-09-10'
),
(
	'Joao Silva',
    'Desenvolvedor Web Front-End com 3 anos de experiência em React, Angular e Node.js. Foco em interfaces responsivas e usabilidade.',
    'Desenvolvedor Pleno',
    'Ensino_Superior_completo',
    'Instituto Federal de Tecnologia',
    'Sistemas para Internet',
    '{"ingles": "intermediario"}',
    'Banco_de_talentos',
    'joao.silva@email.com',
    'Jovem profissional com portfólio de projetos disponíveis no GitHub. Paixão por criar soluções inovadoras.',
    '2025-09-10'
),
(
	'Maria Rodrigues Pereira',
    'Coordenador de Vendas com 7 anos de experiência no setor varejista. Responsável por treinamento de equipe, prospecção de clientes e metas de vendas.',
    'Coordenador de Vendas',
    'Ensino_Superior_completo',
    'Universidade Federal do Rio de Janeiro',
    'Administração',
    '{"ingles": "basico"}',
    'Banco_de_talentos',
    'maria.rodrigues@email.com',
    'Profissional proativa e orientada a resultados, com histórico comprovado de aumento de receita e satisfação do cliente.',
    '2025-09-10'
),
(
	'Pedro Almeida',
    'Estagiário de Marketing Digital com conhecimento em SEO, Google Analytics e criação de conteúdo para mídias sociais.',
    'Estagiário em Marketing',
    'Ensino_Superior_cursando',
    'Pontifícia Universidade Católica',
    'Publicidade e Propaganda',
    '{"ingles": "avancado"}',
    'Banco_de_talentos',
    'pedro.almeida@email.com',
    'Bolsista de iniciação científica e participação em projetos de extensão universitária. Buscando primeira oportunidade.',
    '2025-09-10'
),
(
	'Carla Fernandes',
    'Assistente Administrativo com 2 anos de experiência em rotinas de escritório, controle de documentos e suporte a equipes.',
    'Assistente Administrativo',
    'Ensino_Medio_completo',
    'Colégio Estadual Tiradentes',
    'Ensino Médio',
    '{"espanhol": "basico"}',
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
    '{"ingles": "avancado", "frances": "basico"}',
    'Banco_de_talentos',
    'carlos.pereira@email.com',
    'Histórico comprovado de melhoria de eficiência e produtividade. Experiência em multinacionais.',
    '2025-08-14'
),
(
	'Laura Alves',
    'Analista de Marketing Digital com 4 anos de experiência em campanhas de performance, gerenciamento de mídias pagas (Google Ads, Meta Ads) e análise de métricas.',
    'Analista de Marketing Digital',
    'Ensino_Superior_completo',
    'Escola Superior de Propaganda e Marketing',
    'Comunicação Social - Publicidade e Propaganda',
    '{"ingles": "intermediario"}',
    'Banco_de_talentos',
    'laura.alves@email.com',
    'Certificado em Google Analytics e Google Ads. Habilidade com ferramentas de automação de marketing.',
    '2025-07-13'
),
(
	'Rafael Souza Santos',
    'Estagiário em Recursos Humanos com conhecimento em recrutamento e seleção, treinamento e desenvolvimento, e rotinas de departamento pessoal.',
    'Estagiário de RH',
    'Ensino_Superior_cursando',
    'Universidade Federal de Minas Gerais',
    'Psicologia',
    '{"espanhol": "intermediario"}',
    'Banco_de_talentos',
    'rafael.souza@email.com',
    'Proativo, com vontade de aprender e contribuir para o ambiente de trabalho. Participação em projetos voluntários.',
    '2025-09-01'
),
(
	'Sofia Ribeiro Almeida Santos',
    'Enfermeiro com 8 anos de experiência em ambiente hospitalar, atuando em UTI e pronto-socorro. Foco em cuidados intensivos e atendimento de emergência.',
    'Enfermeiro',
    'Ensino_Superior_completo',
    'Universidade Estadual de Campinas',
    'Enfermagem',
    '{"ingles": "avancado"}',
    'Banco_de_talentos',
    'sofia.ribeiro@email.com',
    'Especialização em Terapia Intensiva. Dedicada e com alta capacidade de trabalho sob pressão.',
    '2025-07-03'
),
(
	'Bruno Gomes Fernandes',
    'Assistente Financeiro com 3 anos de experiência em contas a pagar e receber, conciliação bancária e fluxo de caixa. Atuação em pequenas e médias empresas.',
    'Assistente Financeiro',
    'Ensino_Medio_completo',
    'Escola Técnica de Comércio',
    'Técnico em Contabilidade',
    '{"ingles": "basico"}',
    'Banco_de_talentos',
    'bruno.gomes@email.com',
    'Responsável, organizado e com bom conhecimento de planilhas Excel. Em busca de crescimento profissional.',
    '2025-07-05'
);

-- ---------------------------------------------------------------LayoutVagas------------------------------------------------------------------------------- 

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Estagiário Desenvolvedor', 'Estágio - Desenvolvimento (Back/Front/Fullstack)', 'Sem experiência profissional obrigatória; projetos/portfólio/estágios anteriores são diferenciais', 'Cursando Ensino Superior (preferência 1º ao 6º semestre)', 'Sistemas de Informação, Ciência da Computação, Engenharia de Software ou áreas correlatas', '{"Português": "nativo", "Inglês": "desejável"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Back - Júnior', 'Desenvolvedor Back-end (Júnior)', '0–2 anos (projetos acadêmicos/estágio/1ª experiência); conhecimento prático em ao menos 1 linguagem de backend', 'Cursando ou concluído Ensino Superior (preferencial)', 'Ciência da Computação, Sistemas de Informação, Engenharia ou bootcamp/curso técnico relevante', '{"Português": "nativo", "Inglês": "leitura de docs"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Back - Pleno', 'Desenvolvedor Back-end (Pleno)', '2–4 anos em desenvolvimento backend; domínio de APIs, bancos relacionais/NoSQL, controle de versão (Git)', 'Graduação completa em T.I. ou áreas correlatas (ou equivalente por experiência)', 'Ciência da Computação, Sistemas de Informação, Engenharia, pós/curso em arquitetura/distribuição é diferencial', '{"Português": "nativo", "Inglês": "técnico/intermediário"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Back - Sênior', 'Desenvolvedor Back-end (Sênior)', '4+ anos; liderança técnica em projetos, arquitetura (microserviços), segurança e melhores práticas', 'Graduação completa (muitas vagas exigem) e/ou pós-graduação desejável', 'Ciência da Computação, Engenharia de Software, Sistemas de Informação', '{"Português": "nativo", "Inglês": "intermediário/avançado"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Front - Júnior', 'Desenvolvedor Front-end (Júnior)', '0–2 anos; domínio básico de HTML/CSS/JS; experiência com algum framework (React/Vue/Angular) é diferencial', 'Cursando ou graduado em T.I. ou áreas afins; cursos e portfólio valorizados', 'Sistemas de Informação, Ciência da Computação, Design/UX (parcialmente) ou bootcamp front-end', '{"Português": "nativo", "Inglês": "técnico (leitura)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Front - Pleno', 'Desenvolvedor Front-end (Pleno)', '2–4 anos com desenvolvimento web, frameworks modernos, testes (unit/e2e) e acessibilidade', 'Graduação em T.I. ou experiência comprovada', 'Sistemas de Informação, Ciência da Computação, Design UX/UI, bootcamps avançados', '{"Português": "nativo", "Inglês": "técnico/intermediário"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Desenvolvedor Front - Sênior', 'Desenvolvedor Front-end (Sênior)', '4+ anos; liderança técnica, performance, arquitetura front-end, integração com APIs e boas práticas de UX', 'Graduação completa (preferível) e experiência sólida', 'Ciência da Computação, Engenharia, Design/UX com especializações', '{"Português": "nativo", "Inglês": "intermediário/avançado"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Estagiário em Dados', 'Estágio - Dados / Data Analyst Jr (estágio)', 'Sem experiência obrigatória; conhecimento básico em SQL, Excel e estatística/visualização é desejável', 'Cursando Estatística, Matemática, Ciência de Dados, Engenharia, Sistemas de Informação', 'Ciência de Dados, Estatística, Engenharia, Análise de Dados; cursos de SQL/Python/R/Power BI são diferenciais', '{"Português": "nativo", "Inglês": "técnico (desejável)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Dados - Júnior', 'Analista de Dados (Júnior)', '0–2 anos; experiência com SQL, Excel, ferramentas de visualização (Power BI/Tableau) e manipulação de dados', 'Graduação em andamento ou completa em áreas quantitativas', 'Estatística, Ciência de Dados, Engenharia, Sistemas de Informação', '{"Português": "nativo", "Inglês": "técnico (leitura)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Dados - Pleno', 'Analista de Dados (Pleno)', '2–4 anos; domínio de SQL, modelagem, pipelines (ETL), Python/R e ferramentas de BI', 'Graduação completa e/ou cursos especializados', 'Ciência de Dados, Estatística, Engenharia, Sistemas de Informação', '{"Português": "nativo", "Inglês": "técnico/intermediário"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Dados - Sênior', 'Analista de Dados (Sênior)', '4+ anos; experiência com arquitetura de dados, liderança técnica, ML básico é diferencial', 'Graduação completa (pós-graduação é diferencial)', 'Ciência de Dados, Estatística, Engenharia, pós em Data Science/Analytics', '{"Português": "nativo", "Inglês": "intermediário/avançado"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Estagiário em Marketing / Propaganda', 'Estágio - Marketing / Publicidade', 'Sem experiência obrigatória; apoio em campanhas, social media, criação de conteúdo; portfólio é diferencial', 'Cursando Marketing, Publicidade e Propaganda, Comunicação Social', 'Marketing, Publicidade, Comunicação, Design (com foco digital)', '{"Português": "nativo", "Inglês": "básico (desejável)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Marketing - Júnior', 'Analista de Marketing (Júnior)', '0–2 anos; conhecimento em redes sociais, Google Ads, Meta Ads, analytics e ferramentas de automação', 'Graduação em Marketing, Publicidade ou similar (em andamento ou completa)', 'Marketing, Publicidade, Comunicação, cursos em Ads/SEO/Analytics', '{"Português": "nativo", "Inglês": "técnico (leitura)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Marketing - Pleno', 'Analista de Marketing (Pleno)', '2–4 anos; execução e otimização de campanhas, análise de dados de marketing, estratégia de conteúdo', 'Graduação completa; especialização em Marketing Digital é diferencial', 'Marketing, Publicidade, Comunicação, Pós em Marketing Digital/Analytics', '{"Português": "nativo", "Inglês": "técnico/intermediário"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Marketing - Sênior', 'Analista/Gerente de Marketing (Sênior)', '4+ anos; planejamento estratégico, liderança de campanhas omnichannel, mensuração ROI', 'Graduação completa; pós-graduação/MBAs valorizados', 'Marketing, Administração, Comunicação; especializações em Digital/Analytics', '{"Português": "nativo", "Inglês": "intermediário/avançado"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Analista de Contabilidade', 'Analista de Contabilidade / Contábil', '1–4 anos (dependendo do nível); domínio da legislação fiscal, SPED, fechamento contábil, conciliações', 'Graduação em Ciências Contábeis; registro CRC para níveis plenos/sênior quando exercer responsabilidade técnica', 'Ciências Contábeis; cursos em SPED, legislação tributária e Excel/ERP (Totvs, SAP) são diferenciais', '{"Português": "nativo", "Inglês": "básico (desejável)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Assistente Administrativo', 'Assistente Administrativo', '0–2 anos; organização de rotinas administrativas, atendimento, suporte operacional', 'Ensino Médio completo; Ensino Superior cursando (diferencial)', 'Administração, Gestão, cursos em Office (Excel) e rotinas administrativas', '{"Português": "nativo"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Gestor de Projetos', 'Gerente/Gestor de Projetos', '3–6+ anos em gestão de projetos; experiência em metodologias ágeis (Scrum), PMBOK/PMP é diferencial', 'Graduação (Administração, Engenharias, T.I.); certificações (PMP, CSM) valorizadas', 'Administração, Engenharia, Sistemas de Informação; cursos/certificações em gestão de projetos e Agile', '{"Português": "nativo", "Inglês": "intermediário (comum em empresas tech)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Estágio em Design Gráfico ', 'Estagiário em Design Gráfico', 'Sem experiência obrigatória; conhecimento em Photoshop, Illustrator, InDesign; ser ágil, organizado e criativo', 'Cursando a partir do 2º semestre', 'Design, Design Gráfico, Comunicação Visual, Publicidade ou áreas afins', '{"Português": "nativo"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Designer Gráfico – Pleno / Sênior', 'Designer Gráfico', 'Experiência em design para embalagens, preparação de arquivos para produção gráfica; atualização com tendências AI e regulatórios', 'Graduação completa', 'Design Gráfico, Comunicação Visual ou similar', '{"Português": "nativo"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('UX/UI Designer Pleno', 'Designer UX/UI (Pleno)', 'Mínimo de 2 anos atuando com UX/UI; domínio do Pacote Adobe e Figma; bom relacionamento interpessoal e comprometimento com prazos', 'Ensino Superior (não necessariamente completo)', 'Design, Design Gráfico, Comunicação Visual ou áreas afins', '{"Português": "nativo"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('UI/UX Designer Sênior', 'UI/UX Designer Sênior / Product Designer Sênior', '5+ anos como UI/UX ou Product Designer; experiência com produtos digitais complexos; forte portfólio e técnicas de UX Researching', 'Ensino Superior (provavelmente completo)', 'Design, Design de Produto, Comunicação ou similar', '{"Português": "nativo", "Inglês": "técnico (leitura e possivelmente escrita)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Mid Level Product Designer', 'Product Designer (Pleno/Mid Level)', 'Experiência com interfaces visuais de alta qualidade, identidade de marca, design de interações e usabilidade', 'Ensino Superior completo ou equivalente prático', 'Design, Design Digital, Comunicação Visual, Interação ou similar', '{"Português": "nativo", "Inglês": "técnico (leitura)"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Product Owner', 'Gestão de Produto', 'Pleno a Sênior (2 a 5 anos de experiência em gestão de produtos ou áreas correlatas)', 'Superior completo', 'Administração, Engenharia de Produção, Sistemas de Informação ou áreas relacionadas', '{"Inglês": "intermediário ou avançado"}');

INSERT INTO Layout_Vagas (titulo, cargo, experiencia_esperada, nivel_formacao_esperada, curso_esperado, idiomas_esperados) VALUES
('Scrum Master', 'Agile / Gestão de Times', 'Pleno a Sênior (2 a 5 anos de experiência com metodologias ágeis)', 'Superior completo', 'Administração, Sistemas de Informação, Engenharia de Software ou áreas afins', '{"Inglês": "intermediário (desejável)"}');