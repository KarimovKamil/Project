INSERT INTO specialization (type) VALUES ('Hair cutter');
INSERT INTO specialization (type) VALUES ('Manicure maker');
INSERT INTO specialization (type) VALUES ('Makeup man');
INSERT INTO specialization (type) VALUES ('Beautician');

INSERT INTO service (type, specialization_id, price) VALUES ('Hair cut', 1, 500);
INSERT INTO service (type, specialization_id, price) VALUES ('Manicure', 2, 400);
INSERT INTO service (type, specialization_id, price) VALUES ('Makeup', 3, 900);
INSERT INTO service (type, specialization_id, price) VALUES ('Cosmetology', 4, 1200);

INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Ivanov', 'Ivan', 'Ivanovich', 1, '88005553535');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Miheev', 'Ilshat', 'Ramilevich', 2, '89273762896');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Semenov', 'Kirill', 'Nikolaevich', 3, '89574858392');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Karpov', 'Mihail', 'Ivanovich', 4, '89082284732');
	
INSERT INTO discount_card (discount, registration_date) VALUES (20, 1479820298036);
INSERT INTO discount_card (discount, registration_date) VALUES (50, 1879124128036);
INSERT INTO discount_card (discount, registration_date) VALUES (10, 2479841228036);
INSERT INTO discount_card (discount, registration_date) VALUES (25, 2591210342342);

INSERT INTO salary (employee_id, salary_size) VALUES (1, 20000);
INSERT INTO salary (employee_id, salary_size) VALUES (2, 21000);
INSERT INTO salary (employee_id, salary_size) VALUES (3, 25000);
INSERT INTO salary (employee_id, salary_size) VALUES (4, 00000);

INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (1, 1, '8:00', '16:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (1, 2, '8:00', '16:00');
INSERT INTO work_time (employee_id, weekday) VALUES (1, 3);
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (1, 4, '8:00', '16:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (1, 5, '8:00', '16:00');
INSERT INTO work_time (employee_id, weekday) VALUES (1, 6);
INSERT INTO work_time (employee_id, weekday) VALUES (1, 7);

INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (2, 1, '10:00', '18:00');
INSERT INTO work_time (employee_id, weekday) VALUES (2, 2);
INSERT INTO work_time (employee_id, weekday) VALUES (2, 3);
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (2, 4, '10:00', '18:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (2, 5, '10:00', '18:00');
INSERT INTO work_time (employee_id, weekday) VALUES (2, 6);
INSERT INTO work_time (employee_id, weekday) VALUES (2, 7);

INSERT INTO work_time (employee_id, weekday) VALUES (3, 1);
INSERT INTO work_time (employee_id, weekday) VALUES (3, 2);
INSERT INTO work_time (employee_id, weekday) VALUES (3, 3);
INSERT INTO work_time (employee_id, weekday) VALUES (3, 4);
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (3, 5, '12:00', '20:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (3, 6, '12:00', '20:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (3, 7, '12:00', '20:00');

INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (4, 1, '9:00', '17:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (4, 2, '9:00', '17:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (4, 3, '9:00', '17:00');
INSERT INTO work_time (employee_id, weekday) VALUES (4, 4);
INSERT INTO work_time (employee_id, weekday) VALUES (4, 5);
INSERT INTO work_time (employee_id, weekday) VALUES (4, 6);
INSERT INTO work_time (employee_id, weekday) VALUES (4, 7);

INSERT INTO customer (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date, token, hashpassword)
VALUES ('M', 'Ivanov', 'Ivan', 'Mihailovich', 2, '88005553535', '1995-06-25', 'megatoken', '$2a$10$PGdER5on4FA8vS7Pr./4ZuMa7ZgXF81J16p5bJJ40igaYBb.pRMJG');
INSERT INTO customer (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date, token, hashpassword)
VALUES ('F', 'Koroleva', 'Ekaterina', 'Anatolievna', 4, '88235873233', '1998-02-11', 'supertoken', '$2a$10$PGdER5on4FA8vS7Pr./4ZuMa7ZgXF81J16p5bJJ40igaYBb.pRMJG');

INSERT INTO record (customer_id, employee_id, service_id, start_time, weekday)
VALUES (1, 2, 2, '11:00', 2);
INSERT INTO record (customer_id, employee_id, service_id, start_time, weekday)
VALUES (2, 4, 4, '10:00', 4);
