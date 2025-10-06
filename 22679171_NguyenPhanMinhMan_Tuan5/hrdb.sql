--  database
CREATE DATABASE IF NOT EXISTS hrsource;
USE hrsource;

-- department
CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    deptName VARCHAR(100) NOT NULL
);

--  employee
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES department(dept_id)
);

-- insert departments
INSERT INTO department (deptName) VALUES
('HR'),
('IT'),
('Finance'),
('Marketing');

-- insert employees
INSERT INTO employee (name, salary, department_id) VALUES
('Nguyen Van A', 1200.00, 1),
('Tran Thi B', 1500.00, 2),
('Le Van C', 1800.00, 3),
('Pham Thi D', 1400.00, 1),
('Hoang Van E', 1600.00, 2);

SELECT e.id, e.name, e.salary, d.deptName
FROM employee e
LEFT JOIN department d ON e.department_id = d.dept_id

