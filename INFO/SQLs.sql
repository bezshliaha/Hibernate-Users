CREATE DATABASE users_db;


CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO User (name, email) VALUES (:name, :email)

FROM User

UPDATE User SET email = :email WHERE id = :id

DELETE FROM User WHERE id = :id