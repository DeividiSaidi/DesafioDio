CREATE DATABASE IF NOT EXISTS notas_escolares;

USE notas_escolares;

CREATE TABLE IF NOT EXISTS aluno (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS nota (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  aluno_id BIGINT NOT NULL,
  disciplina VARCHAR(100) NOT NULL,
  nota DOUBLE NOT NULL,
  CONSTRAINT fk_nota_aluno FOREIGN KEY (aluno_id) REFERENCES aluno(id) ON DELETE CASCADE
);