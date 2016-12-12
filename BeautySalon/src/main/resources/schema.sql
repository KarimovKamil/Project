DROP TABLE IF EXISTS discount_card CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS specialization CASCADE;
DROP TABLE IF EXISTS work_time CASCADE;
DROP TABLE IF EXISTS salary CASCADE;
DROP TABLE IF EXISTS svc CASCADE;
DROP TABLE IF EXISTS record CASCADE;

CREATE TABLE discount_card (card_id SERIAL PRIMARY KEY, discount INT, registration_date BIGINT);
CREATE TABLE customer (customer_id SERIAL PRIMARY KEY, gender CHAR, last_name VARCHAR(40),
  first_name VARCHAR(40), middle_name VARCHAR(40), card_id INT REFERENCES discount_card (card_id),
   phone_number VARCHAR(11) UNIQUE , birth_date BIGINT, token VARCHAR(100) UNIQUE, password VARCHAR(255));
CREATE TABLE specialization (specialization_id SERIAL PRIMARY KEY, type VARCHAR(20));
CREATE TABLE employee (employee_id SERIAL PRIMARY KEY, last_name VARCHAR(40),
  first_name VARCHAR(40), middle_name VARCHAR(40), specialization_id INT REFERENCES specialization (specialization_id), phone VARCHAR(20));
CREATE TABLE work_time (time_id SERIAL, employee_id INT REFERENCES employee (employee_id), weekday INT, start_time TIME, end_time TIME);
CREATE TABLE salary (employee_id INT REFERENCES employee (employee_id) UNIQUE, salary_size INT);
CREATE TABLE svc (service_id SERIAL PRIMARY KEY, type VARCHAR(50), specialization_id INT REFERENCES specialization (specialization_id),
  price INT NOT NULL);
CREATE TABLE record (record_id SERIAL PRIMARY KEY, customer_id int REFERENCES customer (customer_id),
  employee_id INT REFERENCES employee (employee_id), service_id int REFERENCES svc (service_id), start_time TIME, end_time TIME);