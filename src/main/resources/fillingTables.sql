-- Добавление ролей 'COURIER' и 'CUSTOMER'
INSERT INTO role (title)
VALUES ('COURIER');
INSERT INTO role (title)
VALUES ('CUSTOMER');

-- Добавление 10 записей в таблицу 'users_tg' с присвоением каждой из них роли
INSERT INTO users_tg (chat_id, nickname)
VALUES ('chat_id_1', 'user1'),
       ('chat_id_2', 'user2'),
       ('chat_id_3', 'user3'),
       ('chat_id_4', 'user4'),
       ('chat_id_5', 'user5'),
       ('chat_id_6', 'user6'),
       ('chat_id_7', 'user7'),
       ('chat_id_8', 'user8'),
       ('chat_id_9', 'user9'),
       ('chat_id_10', 'user10');

-- Присвоение ролей 'COURIER' и 'CUSTOMER' пользователям (предполагается произвольное распределение)
INSERT INTO users_role (user_id, role_id)
VALUES ((SELECT id FROM users_tg WHERE nickname = 'user1'), (SELECT id FROM role WHERE title = 'COURIER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user2'), (SELECT id FROM role WHERE title = 'CUSTOMER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user3'), (SELECT id FROM role WHERE title = 'COURIER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user4'), (SELECT id FROM role WHERE title = 'CUSTOMER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user5'), (SELECT id FROM role WHERE title = 'COURIER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user6'), (SELECT id FROM role WHERE title = 'CUSTOMER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user7'), (SELECT id FROM role WHERE title = 'COURIER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user8'), (SELECT id FROM role WHERE title = 'CUSTOMER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user9'), (SELECT id FROM role WHERE title = 'COURIER')),
       ((SELECT id FROM users_tg WHERE nickname = 'user10'), (SELECT id FROM role WHERE title = 'CUSTOMER'));
