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

SELECT * FROM candidato;