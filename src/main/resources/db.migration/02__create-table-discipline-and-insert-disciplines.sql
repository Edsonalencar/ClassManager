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
