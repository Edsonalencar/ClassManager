CREATE TABLE student (
     id SERIAL PRIMARY KEY,
     name VARCHAR(255),
     code VARCHAR(255) UNIQUE,
     address_id SERIAL REFERENCES address(id)
);
