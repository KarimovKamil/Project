INSERT INTO specialization (type) VALUES ('Hair cutter');
INSERT INTO specialization (type) VALUES ('Manicure maker');
INSERT INTO specialization (type) VALUES ('Makeup man');
INSERT INTO specialization (type) VALUES ('Beautician');
INSERT INTO specialization (type) VALUES ('Masseur');
INSERT INTO specialization (type) VALUES ('Pedicure maker');

INSERT INTO service (type, specialization_id, price) VALUES ('Hair cut', 1, 300);
INSERT INTO service (type, specialization_id, price) VALUES ('Manicure', 2, 400);
INSERT INTO service (type, specialization_id, price) VALUES ('Makeup', 3, 930);
INSERT INTO service (type, specialization_id, price) VALUES ('Cosmetology', 4, 1200);
INSERT INTO service (type, specialization_id, price) VALUES ('Massage', 5, 600);
INSERT INTO service (type, specialization_id, price) VALUES ('Pedicure', 6, 400);

INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Ivanov', 'Ivan', 'Ivanovich', 1, '88005553535');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Miheev', 'Ilshat', 'Ramilevich', 2, '89273762896');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Semenov', 'Kirill', 'Nikolaevich', 3, '89574858392');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Karpov', 'Mihail', 'Ivanovich', 4, '89082284732');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Kirilov', 'Boris', 'Egorovich', 5, '89457582098');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Nikitina', 'Anastasiya', 'Nikolaevna', 6, '89002872907');
	
INSERT INTO discount_card (discount, registration_date) VALUES (200, 1479820298036);
INSERT INTO discount_card (discount, registration_date) VALUES (500, 1879124128036);
INSERT INTO discount_card (discount, registration_date) VALUES (100, 2479841228036);
INSERT INTO discount_card (discount, registration_date) VALUES (250, 2591210342342);

INSERT INTO salary (employee_id, salary_size) VALUES (1, 20000);
INSERT INTO salary (employee_id, salary_size) VALUES (2, 21000);
INSERT INTO salary (employee_id, salary_size) VALUES (3, 25000);
INSERT INTO salary (employee_id, salary_size) VALUES (4, 30000);
INSERT INTO salary (employee_id, salary_size) VALUES (5, 36000);
INSERT INTO salary (employee_id, salary_size) VALUES (6, 21000);

INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (1, 1, '8:00', '16:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (2, 2, '10:00', '18:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (3, 3, '12:00', '20:00');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (4, 4, '9:30', '17:30');
INSERT INTO work_time (employee_id, weekday, start_time, end_time) VALUES (5, 4, '8:00', '16:00');

INSERT INTO customer (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date, token, hashpassword)
VALUES ('M', 'Ivanov', 'Ivan', 'Mihailovich', 2, '88005553535', '1995-06-25', 'megatoken', '$2a$10$PGdER5on4FA8vS7Pr./4ZuMa7ZgXF81J16p5bJJ40igaYBb.pRMJG');
INSERT INTO customer (gender, last_name, first_name, middle_name, card_id, phone_number, birth_date, token, hashpassword)
VALUES ('F', 'Koroleva', 'Ekaterina', 'Anatolievna', 4, '88235873233', '1998-02-11', 'supertoken', '$2a$10$PGdER5on4FA8vS7Pr./4ZuMa7ZgXF81J16p5bJJ40igaYBb.pRMJG');

INSERT INTO record (customer_id, employee_id, service_id, start_time, weekday)
VALUES (1, 2, 2, '11:00', 2);
INSERT INTO record (customer_id, employee_id, service_id, start_time, weekday)
VALUES (2, 4, 4, '10:00', 4);
INSERT INTO record (customer_id, employee_id, service_id, start_time, weekday)
VALUES (2, 5, 5, '14:00', 4);

