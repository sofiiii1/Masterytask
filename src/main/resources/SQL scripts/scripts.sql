create database employeedb;
CREATE TABLE IF NOT EXISTS employee
(
    employee_id serial primary key NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    department varchar(50) NOT NULL,
    job_title varchar(50) NOT NULL,
    date_of_birth date NOT NULL,
    gender varchar(50) NOT NULL
);

INSERT INTO employee (employee_id, first_name, last_name, department, job_title, date_of_birth, gender)
	VALUES (1,'Maria', 'Adamovich', 'Human Resources', 'Recruter', '1990-05-06', 'female');
	VALUES (2,'Anton', 'Petrov', 'IT', 'Programmer', '1996-12-19', 'male');
	VALUES (3,'Ivan', 'Ivanov', 'Management', 'Manager', '1994-10-07', 'male');
	VALUES (4,'Igor', 'Novikov', 'Finance', 'Finance manager', '1997-03-11', 'male');
	VALUES (5,'Anna', 'Smirnova', 'Marketing', 'Marketing specialist', '1999-07-05', 'female');

