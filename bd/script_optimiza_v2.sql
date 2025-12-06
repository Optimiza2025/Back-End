CREATE DATABASE OPTIMIZA;
USE OPTIMIZA;

CREATE TABLE AREA (
    id_area INT AUTO_INCREMENT PRIMARY KEY,
    nome_area VARCHAR(100) NOT NULL
);

CREATE TABLE USUARIO (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(200) NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(14) UNIQUE,
    id_area INT NOT NULL,
    FOREIGN KEY (id_area) REFERENCES AREA(id_area) ON DELETE CASCADE
);


CREATE TABLE CANDIDATO (
    id_candidato INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    experiencia TEXT,
    cargo VARCHAR(100),
    nivel_formacao ENUM(
        'Ensino_fundamental_completo',
        'Ensino_medio_incompleto',
        'Ensino_medio_completo',
        'Ensino_superior_cursando',
        'Ensino_superior_completo',
        'Pos_graduacao',
        'Mestrado',
        'Doutorado'
    ),
    instituicao_ensino VARCHAR(150),
    curso VARCHAR(150),
    idiomas JSON,
    status ENUM('Banco_de_talentos','Contratado') NOT NULL,
    email VARCHAR(150) UNIQUE,
    curriculo TEXT,
    data_update DATE
);

CREATE TABLE VAGA (
    id_vaga INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    cargo VARCHAR(100),
    experiencia VARCHAR(100),
    nivel_formacao ENUM(
        'Ensino_fundamental_completo',
        'Ensino_medio_incompleto',
        'Ensino_medio_completo',
        'Ensino_superior_cursando',
        'Ensino_superior_completo',
        'Pos_graduacao',
        'Mestrado',
        'Doutorado'
    ),
    instituicao_ensino VARCHAR(150),
    curso VARCHAR(150),
    idiomas JSON,
    palavras_chave JSON,
    data_abertura DATE,
    data_update DATE, 
    data_fechamento DATE,
    etapa_vaga ENUM('Aguardando_aprovacao_rh', 'Entrevista_candidatos', 'Admissao_concluida', 'Negada_rh') NOT NULL,
    status ENUM('ativa','concluida','encerrada') NOT NULL,
    id_area INT NOT NULL,
    FOREIGN KEY (id_area) REFERENCES AREA(id_area) ON DELETE CASCADE
);

CREATE TABLE CANDIDATURA (
    id_candidatura INT AUTO_INCREMENT PRIMARY KEY,
    id_vaga INT NOT NULL,
    id_candidato INT NOT NULL,
    status ENUM('em_analise','aprovado','reprovado') NOT NULL,
    matching DECIMAL(5,2),
    matches JSON, 
    FOREIGN KEY (id_vaga) REFERENCES VAGA(id_vaga) ON DELETE CASCADE,
    FOREIGN KEY (id_candidato) REFERENCES CANDIDATO(id_candidato) ON DELETE CASCADE,
    UNIQUE (id_vaga, id_candidato)
);

CREATE TABLE AVALIACAO (
    id_avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    id_candidatura INT NOT NULL,
    id_usuario_avaliador INT NOT NULL,
    hard_skills DECIMAL(2,1),
    soft_skills DECIMAL(2,1),
    experiencia DECIMAL(2,1),
    cultura DECIMAL(2,1),
    comentario VARCHAR(100),
    data_avaliacao DATE,
    FOREIGN KEY (id_candidatura) REFERENCES CANDIDATURA(id_candidatura) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_avaliador) REFERENCES USUARIO(id_usuario) ON DELETE CASCADE
);

CREATE TABLE LAYOUT_VAGAS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    cargo VARCHAR(100),
    experiencia_esperada TEXT,
    nivel_formacao_esperada VARCHAR(150),
    curso_esperado VARCHAR(150),
    idiomas_esperados JSON
);