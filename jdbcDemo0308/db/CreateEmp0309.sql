CREATE TABLE emp(
                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    ename VARCHAR(20) DEFAULT NULL,
                    job_id INT DEFAULT 0,
                    mgr INT DEFAULT 0,
                    joindate DATE,
                    salary DECIMAL DEFAULT 0,
                    bounds DECIMAL DEFAULT 0,
                    dept_id INT DEFAULT 0
)

    INSERT INTO emp VALUES(NULL,'Tom',1,1,NOW(),1000,400,4)
