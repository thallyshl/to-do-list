-- V1: Cria a tabela inicial 'tasks' para armazenar as tarefas,

CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) NOT NULL CHECK (status IN
    ('PENDING', 'IN_PROGRESS', 'COMPLETED', 'CANCELLED', 'ON_HOLD')),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

COMMENT ON COLUMN tasks.id IS 'Identificador único da tarefa (gerado por sequência)';
COMMENT ON COLUMN tasks.title IS 'Título principal da tarefa';
COMMENT ON COLUMN tasks.description IS 'Descrição detalhada opcional da tarefa';
COMMENT ON COLUMN tasks.status IS 'Status atual da tarefa (ex: PENDING, IN_PROGRESS, COMPLETED, CANCELLED, ON_HOLD)';
COMMENT ON COLUMN tasks.created_at IS 'Timestamp de quando a tarefa foi criada';
COMMENT ON COLUMN tasks.updated_at IS 'Timestamp da última atualização da tarefa';