INSERT INTO specialization (type) VALUES ('Hair cutter');
INSERT INTO employee (last_name, first_name, middle_name, specialization_id, phone)
    VALUES ('Ivanov', 'Ivan', 'Ivanovich', 1, '88005553535');

INSERT INTO service (type, specialization_id, price) VALUES ('Hair cut', 1, 229);
INSERT INTO service (type, specialization_id, price) VALUES ('Hair cut x2', 1, 1337);