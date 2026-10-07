create database studentdb;
use studentdb;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    marks INT
);

INSERT INTO student (id, name, marks) VALUES
(1, 'Aditya', 85),
(2, 'Rahul', 78),
(3, 'Priya', 92),
(4, 'Aman', 75),
(5, 'Neha', 88);

SELECT * FROM student;
SHOW TABLES;