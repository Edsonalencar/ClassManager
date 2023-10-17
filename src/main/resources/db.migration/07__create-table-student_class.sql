CREATE TABLE student_class (
   student_id SERIAL REFERENCES student(id),
   class_id SERIAL REFERENCES class(id),
   PRIMARY KEY (student_id, class_id)
);
