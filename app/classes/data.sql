-- CLIENTE
CREATE TABLE cliente (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  email VARCHAR(150) NOT NULL,
  documento VARCHAR(30) NOT NULL,
  UNIQUE (email)
);

-- PRODUTO
CREATE TABLE produto (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(120) NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  categoria VARCHAR(60),
  descricao TEXT,
  ativo BOOLEAN NOT NULL DEFAULT TRUE
);

-- SEEDS
INSERT INTO cliente (nome, email, documento) VALUES ('Ana Silva', 'ana@email.com', '123');
INSERT INTO cliente (nome, email, documento) VALUES ('Carlos Souza', 'carlos@email.com', '456');
INSERT INTO produto (nome, preco, categoria, descricao, ativo) VALUES ('Notebook', 3500.00, 'Informática', 'Básico', TRUE);
INSERT INTO produto (nome, preco, categoria, descricao, ativo) VALUES ('Mouse', 120.00, 'Acessórios', 'USB', TRUE);