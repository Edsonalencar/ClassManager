CREATE TABLE teacher (
     id SERIAL PRIMARY KEY,
     name VARCHAR(255),
     cpf VARCHAR(255),
     address_id INT REFERENCES address(id)
);
