/* Adicionando usuarios */
INSERT INTO tb_user (email, user_name, password) VALUES ('sergio@gmail.com', 'sergio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, user_name, password) VALUES ('isaac@gmail.com', 'isaac', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, user_name, password) VALUES ('afranio.cet@gmail.com', 'afranio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, user_name, password) VALUES ('dacio@gmail.com', 'dacio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');


/* Adicionando regras */
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');

/* Definindo as regras para os usuários */
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

/* Adicionando sensorDevice */
INSERT INTO tb_sensor_device (label, description ) VALUES ('sensor 001', 'Isaac''s Room control');
INSERT INTO tb_sensor_device (label, description ) VALUES ('Kitchen''s freezer sensor (Arduino)', 'Kitchen''s freezer sensor (Arduino)');


/* Adicionando sensor_data */ 



/* Adicionando measurementUnit */ 
INSERT INTO tb_measurement (symbol, description) VALUES ('ºC', 'Celsius');
INSERT INTO tb_measurement (symbol, description) VALUES ('mg/m³', 'Megagram per cubic metre');
INSERT INTO tb_measurement (symbol, description) VALUES ('hPA', 'hectopasca"');
INSERT INTO tb_measurement (symbol, description) VALUES ('lux', 'Lux');
INSERT INTO tb_measurement (symbol, description) VALUES ('%', 'Percent');



/* Adicionando data_stream */ 
INSERT INTO tb_data_stream (label, unit_id) VALUES ('temperature', 1);







