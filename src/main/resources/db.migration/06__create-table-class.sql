CREATE TABLE class (
   id SERIAL PRIMARY KEY,
   discipline_id INT REFERENCES discipline(id),
   timetable_id INT REFERENCES timetable(id),
   teacher_id INT REFERENCES teacher(id),
   local VARCHAR(255),
   semester VARCHAR(255),
   status VARCHAR(255)
);
