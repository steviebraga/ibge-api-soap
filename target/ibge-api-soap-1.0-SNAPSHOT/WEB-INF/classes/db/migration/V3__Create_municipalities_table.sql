CREATE TABLE municipalities(
  code INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  gentilic VARCHAR(50),
  state INT NOT NULL,
  FOREIGN KEY (state) REFERENCES states(code)
);