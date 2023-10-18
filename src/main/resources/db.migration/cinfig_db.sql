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
    code VARCHAR(255) UNIQUE,
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

CREATE TABLE usuario(
    id SERIAL PRIMARY KEY ,
    login VARCHAR(30),
    senha VARCHAR(30)
);
INSERT INTO usuario (login, senha) VALUES
    ('Diretor', '123'),
    ('0000','321'),
    ('1111','000');

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    usuario_id SERIAL REFERENCES usuario(id),
    name VARCHAR(255),
    code VARCHAR(255) UNIQUE,
    address_id SERIAL REFERENCES address(id) ON UPDATE CASCADE
);

CREATE TABLE teacher (
    id SERIAL PRIMARY KEY,
    usuario_id SERIAL REFERENCES usuario(id),
    name VARCHAR(255),
    cpf VARCHAR(255),
    address_id SERIAL REFERENCES address(id) ON UPDATE CASCADE
);

CREATE TABLE class (
   id SERIAL PRIMARY KEY,
   discipline_id SERIAL REFERENCES discipline(id) ON DELETE CASCADE,
   timetable_id SERIAL REFERENCES timetable(id) ON UPDATE CASCADE,
   teacher_id SERIAL REFERENCES teacher(id) ON UPDATE CASCADE,
   local VARCHAR(255),
   semester VARCHAR(255),
   status VARCHAR(255)
);

CREATE TABLE student_class (
   student_id SERIAL REFERENCES student(id) ON DELETE CASCADE,
   class_id SERIAL REFERENCES class(id) ON DELETE CASCADE,
   PRIMARY KEY (student_id, class_id)
);

CREATE TABLE frequency (
    id SERIAL PRIMARY KEY,
    day DATE,
    present BOOLEAN,
    student_id SERIAL REFERENCES address(id) ON DELETE CASCADE,
    class_id SERIAL REFERENCES class(id) ON DELETE CASCADE
);

CREATE TABLE school_grade (
    id SERIAL PRIMARY KEY,
    period VARCHAR(255),
    grade INT,
    student_id SERIAL REFERENCES address(id) ON DELETE CASCADE,
    class_id SERIAL REFERENCES class(id)
);



CREATE VIEW disciplinaAtiva AS
    (SELECT c.id, d.name, t.start_time, t.end_time FROM class AS c, discipline AS d,timetable AS t
    WHERE c.discipline_id = d.id AND c.timetable_id = t.id);

