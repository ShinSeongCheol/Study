CREATE TABLE worker (
    num INT NOT NULL AUTO_INCREMENT,
    id CHAR(20) NOT NULL,
    name CHAR(10) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT,
    department CHAR(20) NOT NULL,
    phone CHAR(20) NOT NULL,
    address CHAR(100),
    PRIMARY KEY(num)
);

INSERT INTO worker(id, name, gender, age, department, phone, address) VALUES('chkim', '김창훈', 'M', 28, '총무부', '010-3838-8577', '경기도 용인시');

DESC worker;

SELECT * FROM worker;