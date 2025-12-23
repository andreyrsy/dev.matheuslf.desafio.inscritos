CREATE TABLE tb_task(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT,
    status VARCHAR(20) DEFAULT 'TODO',
    priority VARCHAR(20) DEFAULT 'LOW',
    due_date DATE,
    project_id BIGINT NOT NULL,
    CONSTRAINT fk_task_project FOREIGN KEY (project_id) REFERENCES tb_project(id)
);