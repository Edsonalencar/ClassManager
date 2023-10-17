CREATE TABLE class (
   id SERIAL PRIMARY KEY,
   discipline_id SERIAL REFERENCES discipline(id),
   timetable_id SERIAL REFERENCES timetable(id),
   teacher_id SERIAL REFERENCES teacher(id),
   local VARCHAR(255),
   semester VARCHAR(255),
   status VARCHAR(255)
);
