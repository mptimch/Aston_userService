
--- Создание таблицы "role"
CREATE TABLE IF NOT EXISTS role
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255)
);

-- Создание таблицы "users_tg" с внешним ключом на "role"
CREATE TABLE IF NOT EXISTS users_tg
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    chat_id VARCHAR(255),
    nickname VARCHAR(255),
    user_role UUID REFERENCES role(id)
);