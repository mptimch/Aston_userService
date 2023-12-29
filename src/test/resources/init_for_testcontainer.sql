
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

-- Добавление ролей 'COURIER' и 'CUSTOMER'
INSERT INTO role (title) VALUES ('COURIER');
INSERT INTO role (title) VALUES ('CUSTOMER');

-- Добавление 10 записей в таблицу 'users_tg' с присвоением каждой из них роли (предполагается произвольное распределение)
INSERT INTO users_tg (chat_id, nickname, user_role)
VALUES
    ('chat_id_1', 'user1', (SELECT id FROM role WHERE title = 'COURIER')),
    ('chat_id_2', 'user2', (SELECT id FROM role WHERE title = 'CUSTOMER')),
    ('chat_id_3', 'user3', (SELECT id FROM role WHERE title = 'COURIER')),
    ('chat_id_4', 'user4', (SELECT id FROM role WHERE title = 'CUSTOMER')),
    ('chat_id_5', 'user5', (SELECT id FROM role WHERE title = 'COURIER')),
    ('chat_id_6', 'user6', (SELECT id FROM role WHERE title = 'CUSTOMER')),
    ('chat_id_7', 'user7', (SELECT id FROM role WHERE title = 'COURIER')),
    ('chat_id_8', 'user8', (SELECT id FROM role WHERE title = 'CUSTOMER')),
    ('chat_id_9', 'user9', (SELECT id FROM role WHERE title = 'COURIER')),
    ('chat_id_10', 'user10', (SELECT id FROM role WHERE title = 'CUSTOMER'));
