/* Adicionando usuarios */
INSERT INTO tb_user (email, user_name) VALUES ('isaac@gmail.com', 'isaac');
INSERT INTO tb_user (email, user_name) VALUES ('afranio.cet@gmail.com', 'afranio');
INSERT INTO tb_user (email, user_name) VALUES ('dacio@gmail.com', 'dacio');
INSERT INTO tb_user (email, user_name) VALUES ('sergio@gmail.com', 'sergio');


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