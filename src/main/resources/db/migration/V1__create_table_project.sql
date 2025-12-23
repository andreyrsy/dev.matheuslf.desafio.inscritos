CREATE TABLE tb_project(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    start_date DATE NOT NULL DEFAULT CURRENT_DATE,
    end_date DATE NOT NULL
);