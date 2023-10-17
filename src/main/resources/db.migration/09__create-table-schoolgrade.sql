CREATE TABLE school_grade (
  id SERIAL PRIMARY KEY,
  period VARCHAR(255),
  grade INT,
  student_id SERIAL REFERENCES address(id),
  class_id SERIAL REFERENCES class(id)
);
