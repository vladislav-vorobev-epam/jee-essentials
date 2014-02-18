-- You can use this file to load seed data into the database using SQL statements

INSERT INTO users (id, login, password) VALUES (1, 'webdizz@gmail.com', '123456');

INSERT INTO tasks (id, name, due_datetime) VALUES (1, 'Sample quite urgent task to do!', CURRENT_TIMESTAMP + 2);
