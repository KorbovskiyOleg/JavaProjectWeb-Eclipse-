SELECT * FROM car; -- запрос всех данных из таблицы
SELECT * FROM owner;
SELECT *from app_users;
DELETE FROM note WHERE note_id = 4;-- удаление по ID
DELETE FROM note; -- удаление всех данных из таблицы
INSERT INTO note (content_note, name_note) VALUES ('Название заметки', 'Текст заметки');
CREATE SCHEMA IF NOT EXISTS ml_data AUTHORIZATION postgres; -- создание новой схемы ml_data

