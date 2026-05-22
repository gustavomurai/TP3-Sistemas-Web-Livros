CREATE DATABASE IF NOT EXISTS tp3_livros
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE tp3_livros;

DROP TABLE IF EXISTS livro;

CREATE TABLE livro (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO livro (titulo, autor, preco) VALUES
('Dom Casmurro', 'Machado de Assis', 39.90),
('O Alienista', 'Machado de Assis', 29.90),
('Capitães da Areia', 'Jorge Amado', 44.90);