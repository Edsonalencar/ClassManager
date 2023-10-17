CREATE TABLE frequency (
   id SERIAL PRIMARY KEY,
   day DATE,
   present BOOLEAN,
   student_id INT REFERENCES address(id),
   class_id INT REFERENCES class(id)
);
