
-- Создание таблицы "role"
CREATE TABLE IF NOT EXISTS role
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255)
);

-- Создание таблицы "user"
CREATE TABLE IF NOT EXISTS users_tg
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    chat_id  VARCHAR(255),
    nickname VARCHAR(255)
);

-- Создание связующей таблицы "user_role"
CREATE TABLE IF NOT EXISTS users_role
(
    user_id UUID REFERENCES users_tg(id) ON DELETE CASCADE,
    role_id UUID REFERENCES role(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);


