CREATE TABLE IF NOT EXISTS department(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(250) NOT NULL, country VARCHAR(250));
CREATE TABLE IF NOT EXISTS employee(
    id INT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INT,
    department_id INT NOT NULL,
    FOREIGN KEY(department_id) REFERENCES department(id));