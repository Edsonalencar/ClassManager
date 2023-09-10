CREATE TABLE historic (
      id SERIAL PRIMARY KEY,
      class_id INT REFERENCES class(id),
      student_id INT REFERENCES student(id),
      frequency_id INT REFERENCES frequency(id),
      school_grade_id INT REFERENCES school_grade(id)
);
