-- Dữ liệu Departments
INSERT INTO departments (dept_id, dept_name)
VALUES 
('D001', 'IT'),
('D002', 'HR'),
('D003', 'Develop');

-- Dữ liệu Employees
INSERT INTO employees (emp_id, emp_name, email, age, salary, dept_id)
VALUES
('E001', 'Alice Packer', 'alicepaker@gmail.com', 20, 1000, 'D002'),
('E002', 'Bob', 'bob@example.com', 30, 1200, 'D001'),
('E003', 'Charlie', 'charlie@example.com', 28, 1400, 'D001'),
('E004', 'Nguyen Van Dat', 'nguyenvandat@gmail.com', 25, 1600, 'D001'),
('E005', 'Peter Packer', 'peter@gmail.com', 26, 1800, 'D002'),
('E011', 'Tom Cruise', 'tom@gmail.com', 50, 2000, 'D002'),
('E012', 'Mai Lan Phuong', 'mlphuong@gmail.com', 22, 3000, 'D002'),
('E013', 'Pham Hoang Phong', 'phong@gmail.com', 22, 3000, 'D002');