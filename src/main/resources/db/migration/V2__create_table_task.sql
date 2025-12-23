CREATE TABLE tb_task(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description VARCHAR,
    status VARCHAR(20) DEFAULT 'TODO',
    priority VARCHAR(20) DEFAULT 'LOW',
    dueDate DATE,
    projectId BIGINT references tb_project(id) NOT NULL
);