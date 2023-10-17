CREATE TABLE student_class (
   student_id INT REFERENCES student(id),
   class_id INT REFERENCES class(id),
   PRIMARY KEY (student_id, class_id)
);
