CREATE TABLE states(
  code INT PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  acronym VARCHAR(2) NOT NULL,
  capital VARCHAR(20) NOT NULL,
  municipalities_number INT NOT NULL
);