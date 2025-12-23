CREATE TABLE tb_project(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    startDate DATE NOT NULL DEFAULT CURRENT_DATE,
    endDate DATE
);