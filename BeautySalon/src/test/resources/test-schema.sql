CREATE TABLE discount_card (card_id int PRIMARY KEY, discount INT, registration_date BIGINT);
CREATE TABLE customer (customer_id int PRIMARY KEY, gender CHAR, last_name VARCHAR(40),
  first_name VARCHAR(40), middle_name VARCHAR(40), card_id INT,
   phone_number VARCHAR(11), birth_date BIGINT, token VARCHAR(100) UNIQUE, hashpassword VARCHAR(255));
CREATE TABLE specialization (specialization_id INT PRIMARY KEY, type VARCHAR(20));
CREATE TABLE employee (employee_id INT PRIMARY KEY, last_name VARCHAR(40),
  first_name VARCHAR(40), middle_name VARCHAR(40), specialization_id INT, phone VARCHAR(20));
CREATE TABLE work_time (time_id INT, employee_id INT, weekday INT, start_time BIGINT, end_time BIGINT);
CREATE TABLE salary (employee_id INT , salary_size INT);
CREATE TABLE service (service_id int PRIMARY KEY, type VARCHAR(50), specialization_id INT,
  price INT NOT NULL);
CREATE TABLE record (record_id INT PRIMARY KEY, customer_id INT,
  employee_id INT, service_id INT, start_time BIGINT, end_time BIGINT);