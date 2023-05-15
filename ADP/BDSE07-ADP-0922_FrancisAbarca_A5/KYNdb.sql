DROP SCHEMA kyn;
CREATE SCHEMA kyn;
USE kyn;

CREATE TABLE role (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
);

CREATE TABLE store (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    localities VARCHAR(255),
    name VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    email VARCHAR(255),
    mobile VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    user_name VARCHAR(255)
);

CREATE TABLE user_role (
	user_id BIGINT PRIMARY KEY,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);

/*  

ONLY APPLY THIS IF YOU DONT USE BCrypt

INSERT INTO user (user_name, name, password) 
VALUES ("admin", "admin", "p@ssw0rd"), ("user", "user", "p@ssw0rd");

*/

INSERT INTO role (name, description)
VALUES ("Administrator", "admin"), ("Users", "User");

/*

IMPORTANT!!!!
role_id = 1 (ADMIN)
role_id = 2 (user)

INSERT INTO user_role (user_id, role_id)  
VALUES (1, 1), (2, 2);

TO MODIFY, 
UPDATE user_role
SET role_id = 1
WHERE user_id = 1; /* THIS SPECIFIES THE USER 

*/

SELECT * FROM kyn.user;