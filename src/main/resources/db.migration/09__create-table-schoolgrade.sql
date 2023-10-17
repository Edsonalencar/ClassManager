CREATE TABLE school_grade (
  id SERIAL PRIMARY KEY,
  period VARCHAR(255),
  grade INT,
  student_id INT REFERENCES address(id),
  class_id INT REFERENCES class(id)
);
