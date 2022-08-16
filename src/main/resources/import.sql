/* Adicionando usuarios */
INSERT INTO tb_user (email, name, password) VALUES ('sergio@gmail.com', 'sergio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES ('isaac@gmail.com', 'isaac', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES ('afranio.cet@gmail.com', 'afranio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (email, name, password) VALUES ('dacio@gmail.com', 'dacio', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

/* Adicionando regras */
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');

/* Definindo as regras para os usuários */
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

/* Adicionando measurementUnit */ 
INSERT INTO tb_measurement (symbol, description) VALUES ('ºC', 'Celsius');
INSERT INTO tb_measurement (symbol, description) VALUES ('mg/m³', 'Megagram per cubic metre');
INSERT INTO tb_measurement (symbol, description) VALUES ('hPA', 'Hectopascal');
INSERT INTO tb_measurement (symbol, description) VALUES ('lux', 'Lux');
INSERT INTO tb_measurement (symbol, description) VALUES ('%', 'Percent');

/* Adicionando device*/
INSERT INTO tb_sensor_device (label, description, user_id) VALUES ('Kitchen''s freezer sensor (Arduino)', 'Kitchen''s freezer sensor (Arduino)', 1);
INSERT INTO tb_sensor_device (label, description, user_id) VALUES ('humidity sensor (Arduino)', 'humidity sensor (Arduino)', 1);

/* Adicionando stream*/
INSERT INTO tb_data_stream (label, unit_id, device_id, enabled) VALUES ('temperature', 1, 1, false);
INSERT INTO tb_data_stream (label, unit_id, device_id, enabled) VALUES ('humidity', 5, 1, false);

/* Adicionando dados às streams */
    // Dados adicionados a stream 1
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-14 02:05:13.359', 22.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-15 02:05:13.359', 29.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-14 02:05:13.359', 22.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-15 02:05:13.359', 29.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-14 02:05:13.359', 22.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-15 02:05:13.359', 29.5, 1, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 1, 1);

    // Dados adicionados a stream 2
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 2, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 2, 1);
INSERT INTO tb_sensor_data (instant, value_sensor, data_stream_id, unit_id) VALUES ('2022-08-13 02:05:13.359', 30.5, 2, 1);


