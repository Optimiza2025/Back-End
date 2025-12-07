USE OPTIMIZA;

-- VAGAS JANEIRO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
(9, 'Analista de Dados Pleno', 'Analista', '3+ anos', 'Ensino_superior_completo', 'USP',
 'Estatística, Ciência de Dados ou Sistemas de Informação',
 '{"Inglês": "B2", "Português": "C2"}',
 '["SQL", "Python", "Power BI", "ETL", "Modelagem de Dados"]',
 '2025-01-03', '2025-01-20', '2025-01-20', 'Admissao_concluida', 'concluida', 3),

(10, 'Assistente Financeiro', 'Assistente', '1+ anos', 'Ensino_medio_completo', 'Senac',
 'Administração',
 '{"Português": "C2"}',
 '["Contas a Receber", "Contas a Pagar", "ERP", "Excel"]',
 '2025-01-05', '2025-01-22', '2025-01-22', 'Admissao_concluida', 'concluida', 1),

(11, 'Analista de RH Generalista', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos, Administração ou Psicologia',
 '{"Português": "C2"}',
 '["Recrutamento", "Admissão", "Folha de Pagamento", "Treinamento"]',
 '2025-01-07', '2025-01-25', '2025-01-25', 'Admissao_concluida', 'concluida', 2),

(12, 'Desenvolvedor Backend Pleno', 'Desenvolvedor', '3+ anos', 'Ensino_superior_completo', 'UNESP',
 'Ciência da Computação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["APIs REST", "Java", "Spring", "SQL", "Microservices"]',
 '2025-01-10', '2025-01-27', '2025-01-27', 'Admissao_concluida', 'concluida', 3),

(13, 'Coordenador de Marketing Digital', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'ESPM',
 'Marketing ou Publicidade',
 '{"Inglês": "B2", "Português": "C2"}',
 '["SEO", "Gestão de Campanhas", "Google Ads", "Redes Sociais"]',
 '2025-01-08', '2025-01-26', '2025-01-26', 'Admissao_concluida', 'concluida', 4),

(14, 'Assistente de Operações', 'Assistente', '1 ano', 'Ensino_medio_completo', 'ETEC',
 'Logística',
 '{"Português": "C2"}',
 '["Rotinas Operacionais", "Controle de Estoque", "ERP"]',
 '2025-01-12', '2025-01-30', '2025-01-30', 'Admissao_concluida', 'concluida', 5),

(15, 'Product Owner Jr', 'Analista', '1-2 anos', 'Ensino_superior_completo', 'FGV',
 'Administração ou Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Scrum", "User Stories", "Backlog", "Mapeamento de Processos"]',
 '2025-01-14', '2025-01-31', '2025-01-31', 'Admissao_concluida', 'concluida', 3),

(16, 'Analista de Compliance', 'Analista', '2+ anos', 'Ensino_superior_completo', 'USP',
 'Direito ou Administração',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Compliance", "Riscos", "Controles Internos", "Políticas Corporativas"]',
 '2025-01-09', '2025-01-29', '2025-01-29', 'Negada_rh', 'concluida', 1);

-- VAGAS FEVEREIRO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
(17, 'Analista de Suporte Técnico', 'Analista', '2+ anos', 'Ensino_superior_completo', 'FATEC',
 'Sistemas de Informação ou áreas correlatas',
 '{"Inglês": "A2", "Português": "C2"}',
 '["Atendimento N1/N2", "Windows Server", "Redes", "ITIL"]',
 '2025-02-03', '2025-02-18', '2025-02-18', 'Admissao_concluida', 'concluida', 3),

(18, 'Assistente Administrativo', 'Assistente', '1 ano', 'Ensino_medio_completo', 'ETEC',
 'Administração',
 '{"Português": "C2"}',
 '["Organização de Documentos", "Atendimento", "ERP"]',
 '2025-02-06', '2025-02-20', '2025-02-20', 'Admissao_concluida', 'concluida', 2),

(19, 'Coordenador Financeiro', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'FGV',
 'Administração, Economia ou Contabilidade',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Controles Internos", "Gestão Financeira", "Budget", "Excel"]',
 '2025-02-07', '2025-02-24', '2025-02-24', 'Negada_rh', 'concluida', 1),

(20, 'Designer Gráfico', 'Designer', '2+ anos', 'Ensino_superior_completo', 'Belas Artes',
 'Design Gráfico',
 '{"Português": "C2"}',
 '["Photoshop", "Illustrator", "Criação Visual", "Branding"]',
 '2025-02-10', '2025-02-27', '2025-02-27', 'Admissao_concluida', 'concluida', 4),

(21, 'Analista de Logística', 'Analista', '2+ anos', 'Ensino_superior_completo', 'UFABC',
 'Logística ou Administração',
 '{"Português": "C2"}',
 '["Gestão de Estoque", "ERP", "Processos Logísticos"]',
 '2025-02-11', '2025-02-28', '2025-02-28', 'Admissao_concluida', 'concluida', 5),

(22, 'Consultor de Segurança da Informação', 'Consultor', '3+ anos', 'Ensino_superior_completo', 'USP',
 'Computação ou áreas correlatas',
 '{"Inglês": "B2", "Português": "C2"}',
 '["ISO 27001", "Análise de Vulnerabilidades", "Segurança Cloud", "Pentest"]',
 '2025-02-04', '2025-02-21', '2025-02-21', 'Admissao_concluida', 'concluida', 3),

(23, 'Analista de Treinamento e Desenvolvimento', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Psicologia ou Recursos Humanos',
 '{"Português": "C2"}',
 '["Treinamentos", "PDI", "Onboarding", "Endomarketing"]',
 '2025-02-13', '2025-02-28', '2025-02-28', 'Admissao_concluida', 'concluida', 2);
 
 -- VAGAS MARÇO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
(24, 'Analista de Controladoria', 'Analista', '3+ anos', 'Ensino_superior_completo', 'FGV',
 'Administração, Economia ou Contabilidade',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Fechamento Mensal", "Excel", "Forecast", "Orçamento"]',
 '2025-03-03', '2025-03-20', '2025-03-20', 'Negada_rh', 'concluida', 1),

(25, 'Recrutador Tech', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Psicologia ou Recursos Humanos',
 '{"Português": "C2"}',
 '["Recrutamento TI", "Entrevistas", "Hunting", "ATS"]',
 '2025-03-05', '2025-03-22', '2025-03-22', 'Admissao_concluida', 'concluida', 2),

(26, 'Desenvolvedor Frontend Pleno', 'Desenvolvedor', '3+ anos', 'Ensino_superior_completo', 'UNIP',
 'Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["JavaScript", "React", "APIs", "HTML/CSS"]',
 '2025-03-04', '2025-03-23', '2025-03-23', 'Admissao_concluida', 'concluida', 3),

(27, 'Analista de Mídias Sociais', 'Analista', '2+ anos', 'Ensino_superior_completo', 'ESPM',
 'Publicidade e Propaganda',
 '{"Português": "C2"}',
 '["Redes Sociais", "Copywriting", "Métricas", "Planejamento de Conteúdo"]',
 '2025-03-06', '2025-03-25', '2025-03-25', 'Admissao_concluida', 'concluida', 4),

(28, 'Analista de Planejamento Operacional', 'Analista', '2+ anos', 'Ensino_superior_completo', 'UFABC',
 'Logística ou Administração',
 '{"Português": "C2"}',
 '["Gestão de Demandas", "KPIs", "Processos", "ERP"]',
 '2025-03-08', '2025-03-27', '2025-03-27', 'Admissao_concluida', 'concluida', 5),

(29, 'Analista de Segurança da Informação SOC', 'Analista', '2+ anos', 'Ensino_superior_completo', 'USP',
 'Ciência da Computação ou correlatos',
 '{"Inglês": "B1", "Português": "C2"}',
 '["SIEM", "Monitoramento", "Incident Response", "Linux"]',
 '2025-03-10', '2025-03-29', '2025-03-29', 'Admissao_concluida', 'concluida', 3),

(30, 'Designer de UX/UI', 'Designer', '2+ anos', 'Ensino_superior_completo', 'Belas Artes',
 'Design Digital',
 '{"Português": "C2"}',
 '["Figma", "UX Research", "Wireframes", "Design System"]',
 '2025-03-11', '2025-03-28', '2025-03-28', 'Admissao_concluida', 'concluida', 4),

(31, 'Assistente de Departamento Pessoal', 'Assistente', '1 ano', 'Ensino_medio_completo', 'Senac',
 'Administração',
 '{"Português": "C2"}',
 '["Folha de Pagamento", "Admissão", "Rescisão", "Ponto"]',
 '2025-03-12', '2025-03-30', '2025-03-30', 'Admissao_concluida', 'concluida', 2),

(32, 'Analista de Custos', 'Analista', '2+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Economia, Administração ou Engenharia',
 '{"Português": "C2"}',
 '["Análise de Custos", "Orçamentos", "ERP", "Relatórios Financeiros"]',
 '2025-03-13', '2025-03-31', '2025-03-31', 'Admissao_concluida', 'concluida', 1),

(33, 'Coordenador de Operações', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'FGV',
 'Administração ou Engenharia de Produção',
 '{"Português": "C2"}',
 '["Gestão de Processos", "KPIs", "Liderança", "Logística"]',
 '2025-03-07', '2025-03-26', '2025-03-26', 'Admissao_concluida', 'concluida', 5);
 
 -- VAGAS EM ABRIL
 INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
(34, 'Assistente de Compras', 'Assistente', '1 ano', 'Ensino_medio_completo', 'ETEC',
 'Administração',
 '{"Português": "C2"}',
 '["Cotação", "Negociação", "ERP", "Fornecedores"]',
 '2025-04-02', '2025-04-18', '2025-04-18', 'Negada_rh', 'concluida', 5),

(35, 'Analista de Folha de Pagamento', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos ou Administração',
 '{"Português": "C2"}',
 '["Folha", "eSocial", "Encargos", "Ponto"]',
 '2025-04-03', '2025-04-20', '2025-04-20', 'Admissao_concluida', 'concluida', 2),

(36, 'Engenheiro de Software Pleno', 'Engenheiro', '3+ anos', 'Ensino_superior_completo', 'USP',
 'Engenharia de Software',
 '{"Inglês": "B2", "Português": "C2"}',
 '["Java", "Microserviços", "DevOps", "APIs"]',
 '2025-04-05', '2025-04-23', '2025-04-23', 'Negada_rh', 'concluida', 3),

(37, 'Especialista em Branding', 'Especialista', '4+ anos', 'Ensino_superior_completo', 'ESPM',
 'Marketing',
 '{"Português": "C2"}',
 '["Branding", "Identidade Visual", "Campanhas", "Posicionamento"]',
 '2025-04-04', '2025-04-24', '2025-04-24', 'Admissao_concluida', 'concluida', 4),

(38, 'Analista de Auditoria Interna', 'Analista', '2+ anos', 'Ensino_superior_completo', 'FGV',
 'Contabilidade ou Administração',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Auditoria", "Controles Internos", "Compliance"]',
 '2025-04-06', '2025-04-25', '2025-04-25', 'Admissao_concluida', 'concluida', 1),

(39, 'Analista de Infraestrutura', 'Analista', '3+ anos', 'Ensino_superior_completo', 'FATEC',
 'Redes de Computadores ou correlatos',
 '{"Inglês": "A2", "Português": "C2"}',
 '["Servidores", "Cloud", "Virtualização", "Redes"]',
 '2025-04-08', '2025-04-27', '2025-04-27', 'Admissao_concluida', 'concluida', 3),

(40, 'Coordenador de RH', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos',
 '{"Português": "C2"}',
 '["Liderança", "KPIs de RH", "Desenvolvimento Organizacional"]',
 '2025-04-09', '2025-04-28', '2025-04-28', 'Admissao_concluida', 'concluida', 2),

(41, 'Analista de Operações Logísticas', 'Analista', '2+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Logística ou Engenharia de Produção',
 '{"Português": "C2"}',
 '["Distribuição", "Roteirização", "Processos Logísticos"]',
 '2025-04-10', '2025-04-29', '2025-04-29', 'Admissao_concluida', 'concluida', 5);

-- VAGAS EM MAIO 
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(42, 'Analista Financeiro Pleno', 'Analista', '3+ anos', 'Ensino_superior_completo', 'FGV',
 'Finanças ou Administração',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Fluxo de Caixa", "Contas a Pagar", "ERP", "Conciliação"]',
 '2025-05-02', '2025-05-18', '2025-05-18', 'Admissao_concluida', 'concluida', 1),

-- RH
(43, 'Business Partner Jr', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos ou Psicologia',
 '{"Português": "C2"}',
 '["BP", "Clima Organizacional", "Acompanhamento de Gestores"]',
 '2025-05-03', '2025-05-20', '2025-05-20', 'Admissao_concluida', 'concluida', 2),

-- TI
(44, 'Desenvolvedor Backend Node.js', 'Desenvolvedor', '2+ anos', 'Ensino_superior_completo', 'FATEC',
 'Sistemas de Informação ou correlatos',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Node.js", "API REST", "SQL", "Docker"]',
 '2025-05-05', '2025-05-23', '2025-05-23', 'Negada_rh', 'concluida', 3),

-- MARKETING
(45, 'Analista de Mídias Sociais', 'Analista', '2+ anos', 'Ensino_superior_completo', 'ESPM',
 'Marketing ou Publicidade',
 '{"Português": "C2"}',
 '["Social Media", "Métricas", "Conteúdo", "Gestão de Crises"]',
 '2025-05-07', '2025-05-25', '2025-05-25', 'Admissao_concluida', 'concluida', 4),

-- OPERAÇÕES
(46, 'Coordenador de Operações', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Administração ou Logística',
 '{"Português": "C2"}',
 '["Gestão de Equipes", "KPIs", "Processos"]',
 '2025-05-08', '2025-05-27', '2025-05-27', 'Negada_rh', 'concluida', 5),

-- TI 2 (para dar volume ao mês)
(47, 'Analista de QA', 'Analista', '2+ anos', 'Ensino_superior_completo', 'USP',
 'Ciência da Computação ou correlatos',
 '{"Inglês": "A2", "Português": "C2"}',
 '["Testes Manuais", "Automação", "Selenium", "Bugs"]',
 '2025-05-10', '2025-05-28', '2025-05-28', 'Admissao_concluida', 'concluida', 3),

-- RH 2 (para fechar 7 vagas no mês)
(48, 'Analista de Treinamento e Desenvolvimento', 'Analista', '1+ ano', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos ou Pedagogia',
 '{"Português": "C2"}',
 '["Trilhas de Aprendizagem", "Onboarding", "Indicadores de Treinamento"]',
 '2025-05-12', '2025-05-30', '2025-05-30', 'Admissao_concluida', 'concluida', 2);
 
 -- VAGAS EM JUNHO 
 INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(49, 'Coordenador Financeiro', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'FEA-USP',
 'Administração, Contabilidade ou Economia',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Controles Internos", "Gestão Financeira", "Orçamento"]',
 '2025-06-03', '2025-06-28', '2025-06-28', 'Admissao_concluida', 'concluida', 1),

-- RH
(50, 'Analista de Recrutamento e Seleção Sr', 'Analista', '3+ anos', 'Ensino_superior_completo', 'PUC',
 'Psicologia ou Recursos Humanos',
 '{"Português": "C2"}',
 '["R&S", "Entrevistas", "ATS", "Alinhamento com Gestores"]',
 '2025-06-04', '2025-06-29', '2025-06-29', 'Admissao_concluida', 'concluida', 2),

-- TI
(51, 'Desenvolvedor Full Stack Pleno', 'Desenvolvedor', '3+ anos', 'Ensino_superior_completo', 'FATEC',
 'Sistemas de Informação ou correlatos',
 '{"Inglês": "B1", "Português": "C2"}',
 '["React", "Node.js", "APIs", "SQL"]',
 '2025-06-05', '2025-07-01', '2025-07-01', 'Admissao_concluida', 'concluida', 3),

-- MARKETING
(52, 'Especialista em Performance Digital', 'Especialista', '4+ anos', 'Ensino_superior_completo', 'ESPM',
 'Marketing, Publicidade ou correlatos',
 '{"Português": "C2"}',
 '["Google Ads", "Meta Ads", "ROI", "Growth"]',
 '2025-06-06', '2025-07-02', '2025-07-02', 'Admissao_concluida', 'concluida', 4),

-- OPERAÇÕES
(53, 'Supervisor de Logística', 'Supervisor', '3+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Logística ou Administração',
 '{"Português": "C2"}',
 '["WMS", "Distribuição", "Gestão de Equipes"]',
 '2025-06-07', '2025-07-03', '2025-07-03', 'Negada_rh', 'concluida', 5),

-- TI 2
(54, 'Analista de Suporte Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'FATEC',
 'Redes ou TI correlata',
 '{"Português": "C2"}',
 '["Suporte N2", "Infraestrutura", "Tickets", "Atendimento"]',
 '2025-06-10', '2025-07-05', '2025-07-05', 'Admissao_concluida', 'concluida', 3),

-- FINANCEIRO 2
(55, 'Analista Contábil Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'FGV',
 'Contabilidade',
 '{"Português": "C2"}',
 '["SPED", "Classificação Contábil", "Conciliação"]',
 '2025-06-12', '2025-07-08', '2025-07-08', 'Admissao_concluida', 'concluida', 1);


-- VAGAS EM JULHO = 0

-- VAGAS EM AGOSTO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(56, 'Analista de Controladoria Pleno', 'Analista', '3+ anos', 'Ensino_superior_completo', 'FGV',
 'Administração ou Contabilidade',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Orçamento", "Forecast", "DRE", "Planejamento Financeiro"]',
 '2025-08-04', '2025-08-28', '2025-08-28', 'Negada_rh', 'concluida', 1),

-- RH
(57, 'Business Partner de RH Jr', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos',
 '{"Português": "C2"}',
 '["BP", "Clima Organizacional", "Rituais de Gestão"]',
 '2025-08-05', '2025-08-29', '2025-08-29', 'Admissao_concluida', 'concluida', 2),

-- TI
(58, 'Desenvolvedor Backend Node.js', 'Desenvolvedor', '2+ anos', 'Ensino_superior_completo', 'FATEC',
 'Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Node.js", "SQL", "APIs REST", "Docker"]',
 '2025-08-06', '2025-08-31', '2025-08-31', 'Admissao_concluida', 'concluida', 3),

-- MARKETING
(59, 'Analista de Social Media Sr', 'Analista', '3+ anos', 'Ensino_superior_completo', 'ESPM',
 'Publicidade e Propaganda',
 '{"Português": "C2"}',
 '["Mídias Sociais", "Engajamento", "Roteiro", "Conteúdo"]',
 '2025-08-07', '2025-09-01', '2025-09-01', 'Negada_rh', 'concluida', 4),

-- OPERAÇÕES
(60, 'Coordenador de Operações', 'Coordenador', '4+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Logística ou Engenharia de Produção',
 '{"Português": "C2"}',
 '["Gestão Operacional", "Processos", "KPIs"]',
 '2025-08-08', '2025-09-02', '2025-09-02', 'Negada_rh', 'concluida', 5),

-- TI 2
(61, 'Analista de Segurança da Informação Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'FIAP',
 'Segurança da Informação',
 '{"Inglês": "A2", "Português": "C2"}',
 '["Pentest Básico", "Vulnerabilidades", "Ferramentas SIEM"]',
 '2025-08-11', '2025-09-04', '2025-09-04', 'Negada_rh', 'concluida', 3),

-- FINANCEIRO 2
(62, 'Assistente Contábil', 'Assistente', '1 ano', 'Ensino_medio_completo', 'ETEC',
 'Contabilidade',
 '{"Português": "C2"}',
 '["Conciliação", "Lançamentos", "Classificação"]',
 '2025-08-12', '2025-09-05', '2025-09-05', 'Admissao_concluida', 'concluida', 1);

-- VAGAS EM SETEMBRO 
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(63, 'Analista Financeiro Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'Mackenzie',
 'Administração ou Contabilidade',
 '{"Português": "C2"}',
 '["Contas a Pagar", "Contas a Receber", "ERP"]',
 '2025-09-02', '2025-09-27', '2025-09-27', 'Admissao_concluida', 'concluida', 1),

-- RH
(64, 'Analista de Treinamento & Desenvolvimento Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos',
 '{"Português": "C2"}',
 '["T&D", "Onboarding", "Mapeamento de Competências"]',
 '2025-09-03', '2025-09-28', '2025-09-28', 'Admissao_concluida', 'concluida', 2),

-- TI
(65, 'Desenvolvedor Front-End React', 'Desenvolvedor', '2+ anos', 'Ensino_superior_completo', 'FATEC',
 'Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["React", "JavaScript", "APIs", "UI/UX"]',
 '2025-09-04', '2025-09-29', '2025-09-29', 'Admissao_concluida', 'concluida', 3),

-- MARKETING
(66, 'Analista de SEO', 'Analista', '2+ anos', 'Ensino_superior_completo', 'ESPM',
 'Marketing ou Publicidade',
 '{"Português": "C2"}',
 '["SEO", "Tráfego Orgânico", "Otimização de Conteúdo"]',
 '2025-09-05', '2025-09-30', '2025-09-30', 'Admissao_concluida', 'concluida', 4),

-- OPERAÇÕES
(67, 'Analista de Planejamento Logístico', 'Analista', '2+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Engenharia de Produção ou Logística',
 '{"Português": "C2"}',
 '["Planejamento", "Processos", "KPIs"]',
 '2025-09-08', '2025-10-02', '2025-09-28', 'Negada_rh', 'concluida', 5),

-- TI 2
(68, 'Administrador de Banco de Dados (DBA)', 'Administrador', '3+ anos', 'Ensino_superior_completo', 'USP',
 'Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["SQL Server", "Backup", "Tuning", "Segurança de Dados"]',
 '2025-09-09', '2025-10-04', '2025-09-30', 'Admissao_concluida', 'concluida', 3),

-- FINANCEIRO 2
(69, 'Assistente Financeiro', 'Assistente', '1 ano', 'Ensino_medio_completo', 'ETEC',
 'Administração',
 '{"Português": "C2"}',
 '["Faturamento", "Lançamentos", "Conciliações"]',
 '2025-09-10', '2025-10-05', '2025-09-29', 'Admissao_concluida', 'concluida', 1);

-- VAGAS OUTUBRO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(70, 'Analista de Custos Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'FGV',
 'Contabilidade ou Administração',
 '{"Português": "C2"}',
 '["Custos", "CMV", "Orçamento"]',
 '2025-10-02', '2025-10-21', '2025-10-21', 'Admissao_concluida', 'concluida', 1),

-- RH
(71, 'Analista de Benefícios Sr', 'Analista', '3+ anos', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos',
 '{"Português": "C2"}',
 '["Benefícios", "Gestão de Planos", "Relacionamento com Fornecedores"]',
 '2025-10-03', '2025-10-22', '2025-10-22', 'Admissao_concluida', 'concluida', 2),

-- TI
(72, 'Engenheiro de Software Backend', 'Engenheiro', '3+ anos', 'Ensino_superior_completo', 'USP',
 'Ciência da Computação ou correlatos',
 '{"Inglês": "B1", "Português": "C2"}',
 '["Java", "Spring", "APIs", "SQL"]',
 '2025-10-06', '2025-10-25', '2025-10-25', 'Negada_rh', 'concluida', 3),

-- MARKETING
(73, 'Designer Gráfico Pleno', 'Designer', '2+ anos', 'Ensino_superior_completo', 'ESPM',
 'Design ou Publicidade',
 '{"Português": "C2"}',
 '["Adobe Suite", "Branding", "Materiais Gráficos"]',
 '2025-10-07', '2025-10-26', '2025-10-26', 'Admissao_concluida', 'concluida', 4),

-- OPERAÇÕES
(74, 'Analista de Supply Chain', 'Analista', '2+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Logística ou Engenharia de Produção',
 '{"Português": "C2"}',
 '["Supply Chain", "Fluxos", "Indicadores"]',
 '2025-10-08', '2025-10-27', '2025-10-27', 'Admissao_concluida', 'concluida', 5),

-- TI 2
(75, 'Analista DevOps Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'FIAP',
 'Sistemas de Informação',
 '{"Inglês": "A2", "Português": "C2"}',
 '["CI/CD", "Containers", "Pipelines"]',
 '2025-10-09', '2025-10-28', '2025-10-28', 'Admissao_concluida', 'concluida', 3),

-- FINANCEIRO 2
(76, 'Assistente Fiscal', 'Assistente', '1+ ano', 'Ensino_medio_completo', 'ETEC',
 'Administração',
 '{"Português": "C2"}',
 '["Notas Fiscais", "Tributos", "Lançamentos"]',
 '2025-10-10', '2025-10-29', '2025-10-29', 'Admissao_concluida', 'concluida', 1);

-- VAGAS EM NOVEMBRO = 0

-- VAGAS EM DEZEMBRO
INSERT INTO VAGA (
    id_vaga, titulo, cargo, experiencia, nivel_formacao, instituicao_ensino,
    curso, idiomas, palavras_chave, data_abertura, data_update, data_fechamento,
    etapa_vaga, status, id_area
) VALUES
-- FINANCEIRO
(77, 'Analista Financeiro Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'USP',
 'Administração ou Economia',
 '{"Português": "C2"}',
 '["Fluxo de Caixa", "Contas a Pagar", "Budget"]',
 '2025-11-12', '2025-12-06', '2025-12-06', 'Aguardando_aprovacao_rh', 'concluida', 1),

-- RH
(78, 'Business Partner Jr', 'Analista', '1+ ano', 'Ensino_superior_completo', 'PUC',
 'Recursos Humanos',
 '{"Português": "C2"}',
 '["BP", "Clima Organizacional", "Acompanhamento de Equipes"]',
 '2025-11-11', '2025-12-05', '2025-12-05', 'Admissao_concluida', 'concluida', 2),

-- TI
(79, 'Desenvolvedor Fullstack Jr', 'Desenvolvedor', '1+ ano', 'Ensino_superior_completo', 'FIAP',
 'Sistemas de Informação',
 '{"Inglês": "B1", "Português": "C2"}',
 '["JavaScript", "React", "Node.js"]',
 '2025-11-10', '2025-12-04', '2025-12-04', 'Entrevista_candidatos', 'concluida', 3),

-- MARKETING
(80, 'Analista de Conteúdo Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'ESPM',
 'Publicidade e Propaganda',
 '{"Português": "C2"}',
 '["Copywriting", "SEO", "Planejamento de Conteúdo"]',
 '2025-11-09', '2025-12-03', '2025-12-03', 'Admissao_concluida', 'concluida', 4),

-- OPERAÇÕES
(81, 'Coordenador de Operações', 'Coordenador', '3+ anos', 'Ensino_superior_completo', 'Mackenzie',
 'Engenharia de Produção',
 '{"Português": "C2"}',
 '["KPIs", "Gestão de Equipes", "Processos Operacionais"]',
 '2025-11-08', '2025-12-02', '2025-12-02', 'Aguardando_aprovacao_rh', 'concluida', 5),

-- TI 2
(82, 'Analista de Redes Pleno', 'Analista', '2+ anos', 'Ensino_superior_completo', 'ETEC',
 'Redes de Computadores',
 '{"Inglês": "A2", "Português": "C2"}',
 '["Infraestrutura", "VPN", "Switches"]',
 '2025-11-07', '2025-12-01', '2025-12-01', 'Entrevista_candidatos', 'concluida', 3);


