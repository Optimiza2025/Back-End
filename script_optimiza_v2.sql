CREATE DATABASE IF NOT EXISTS OPTIMIZA;
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
    experiencia VARCHAR(100),
    nivel_formacao ENUM(
        'Ensino Fundamental completo',
        'Ensino Medio incompleto',
        'Ensino Medio completo',
        'Ensino Superior cursando',
        'Ensino Superior completo',
        'Pos-graduacao',
        'Mestrado',
        'Doutorado'
    ),
    instituicao_ensino VARCHAR(150),
    curso VARCHAR(150),
    idiomas JSON,
    status ENUM('Banco de talentos','Contratado') NOT NULL,
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
        'Ensino Fundamental completo',
        'Ensino Medio incompleto',
        'Ensino Medio completo',
        'Ensino Superior cursando',
        'Ensino Superior completo',
        'Pos-graduacao',
        'Mestrado',
        'Doutorado'
    ),
    instituicao_ensino VARCHAR(150),
    curso VARCHAR(150),
    idiomas JSON,
    palavras_chave JSON,
    etapa_vaga ENUM('Vaga aberta', 'Aprovacao RH', 'Entrevista candidatos', 'Admissao concluida') NOT NULL,
    status ENUM('ativa','concluida','encerrada') NOT NULL,
    id_area INT NOT NULL,
    FOREIGN KEY (id_area) REFERENCES AREA(id_area) ON DELETE CASCADE
);

CREATE TABLE CANDIDATURA (
    id_candidatura INT AUTO_INCREMENT PRIMARY KEY,
    id_vaga INT NOT NULL,
    id_candidato INT NOT NULL,
    status ENUM('em analise','aprovado','reprovado') NOT NULL,
    matching DECIMAL(5,2),
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
