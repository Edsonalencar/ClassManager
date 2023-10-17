CREATE TABLE address (
     id SERIAL PRIMARY KEY,
     city VARCHAR(255),
     state VARCHAR(255),
     district VARCHAR(255),
     number INT
);

CREATE TABLE discipline (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(255),
    status VARCHAR(255)
);

INSERT INTO discipline (name, code, status) VALUES ('Português', '20231001', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Matematica', '20231002', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Algebra', '20231003', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Inglês', '20231004', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Historia', '20231005', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Filosofia', '20231006', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Sociologia', '20231007', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Espanhol', '20231008', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Biologia', '20231009', 'ACTIVE');
INSERT INTO discipline (name, code, status) VALUES ('Fisica', '20231010', 'ACTIVE');

CREATE TABLE timetable (
    id SERIAL PRIMARY KEY,
    start_time DATE,
    end_time DATE
);

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(255),
    address_id SERIAL REFERENCES address(id)
);

CREATE TABLE teacher (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    cpf VARCHAR(255),
    address_id SERIAL REFERENCES address(id)
);

CREATE TABLE class (
   id SERIAL PRIMARY KEY,
   discipline_id SERIAL REFERENCES discipline(id),
   timetable_id SERIAL REFERENCES timetable(id),
   teacher_id SERIAL REFERENCES teacher(id),
   local VARCHAR(255),
   semester VARCHAR(255),
   status VARCHAR(255)
);

CREATE TABLE student_class (
   student_id SERIAL REFERENCES student(id),
   class_id SERIAL REFERENCES class(id),
   PRIMARY KEY (student_id, class_id)
);

CREATE TABLE frequency (
    id SERIAL PRIMARY KEY,
    day DATE,
    present BOOLEAN,
    student_id SERIAL REFERENCES address(id),
    class_id SERIAL REFERENCES class(id)
);

CREATE TABLE school_grade (
    id SERIAL PRIMARY KEY,
    period VARCHAR(255),
    grade INT,
    student_id SERIAL REFERENCES address(id),
    class_id SERIAL REFERENCES class(id)
);

