CREATE DATABASE IF NOT EXISTS students;

USE students;

CREATE TABLE IF NOT EXISTS Student(
  id VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  birthday DATETIME NOT NULL,
  creation_date DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS User(
  id VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Course(
  id VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  teacher VARCHAR(255) NOT NULL,
  major VARCHAR(255) NOT NULL,
  pass_condition DECIMAL(19,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS Enrollment(
    id varchar(255) NOT NULL,
    course_id varchar(255) NOT NULL,
    student_id varchar(255) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS Grade(
  id VARCHAR(255) NOT NULL,
  student_id VARCHAR(255) NOT NULL,
  course_id VARCHAR(255) NOT NULL,
  grade INTEGER NOT NULL
);

INSERT INTO User (id, username,password)
VALUES ('f9f14527-a9f1-4106-bebd-275d7445dce8',
        'admin',
        '$2a$10$kSXijolQZaXTuUy00HONF.aymO2HL7DTo6ZbV1sQWyIQTZ898U6q6');