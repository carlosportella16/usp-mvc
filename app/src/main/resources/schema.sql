-- Tabela de experiências
CREATE TABLE IF NOT EXISTS tb_experiences (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(255) NOT NULL DEFAULT 'N/A',
    years_of_experience INT NOT NULL,
    primary_technology VARCHAR(255) NOT NULL,
    secondary_technology VARCHAR(255) NULL
);

-- Tabela de usuários
CREATE TABLE IF NOT EXISTS tb_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(15),
    linked_in_profile VARCHAR(255),
    experience_id BIGINT,
    FOREIGN KEY (experience_id) REFERENCES tb_experiences(id)
);
