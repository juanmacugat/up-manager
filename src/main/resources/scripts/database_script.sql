CREATE DATABASE IF NOT EXISTS students;

USE students;

CREATE TABLE Student(
  id VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  studentId VARCHAR(255) NOT NULL
);

CREATE TABLE User(
  id VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);