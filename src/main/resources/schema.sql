DROP TABLE IF EXISTS content;

CREATE TABLE content (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_name VARCHAR(20) NOT NULL,
  item_type SMALLINT NOT NULL
  register_id INT NOT NULL,
  FOREIGN KEY (register_id) REFERENCES content(id)
);
DROP TABLE IF EXIST register;

CREATE TABLE register (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR (50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(21) DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
);

