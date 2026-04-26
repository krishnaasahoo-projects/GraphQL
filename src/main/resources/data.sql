
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50),
    age INT,
    city VARCHAR(25)
);

insert into customer(name,age,city) values
('kk',23,'pune'),
('gk',20,'banglore'),
('gp',22,'guntur') ;