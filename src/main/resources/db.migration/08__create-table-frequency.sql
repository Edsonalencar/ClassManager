CREATE TABLE frequency (
   id SERIAL PRIMARY KEY,
   day DATE,
   present BOOLEAN,
   student_id SERIAL REFERENCES address(id),
   class_id SERIAL REFERENCES class(id)
);
