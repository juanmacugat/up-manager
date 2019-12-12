-- Adminer 4.7.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE DATABASE `students` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `students`;

DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `teacher` varchar(255) NOT NULL,
  `major` varchar(255) NOT NULL,
  `pass_condition` decimal(19,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Course` (`id`, `name`, `teacher`, `major`, `pass_condition`) VALUES
('3733e160-46f3-4348-9f59-89641751cc1b',	'Laboratorio I',	'Guido Chiesa',	'Facultad de Ingenieria',	6.00),
('0c6dddb6-c665-4f7d-b1e2-e5344d61a9c8',	'Administracion de Proyectos',	'Mercedes Blanco',	'Facultad de Ingenieria',	4.00),
('17fbe75d-e8be-444d-bace-3f8fc8817601',	'Laboratorio II',	'Alejandro Schvartz',	'Facultad de Ingenieria',	6.00),
('20920856-6f66-456c-943f-7a37cb075144',	'Sistemas Operativos',	'Guillermo Puyau',	'Facultad de Ingenieria',	6.00),
('acaf9c56-ecf7-4c29-81bf-cc8ae197edda',	'Fundamentos de Blockchain',	'Alejo Gariglio',	'Facultad de Ingenieria',	6.00),
('5417a03d-8e51-4365-ade1-020098519b47',	'Analisis de Sistemas',	'Luciano Pacheco',	'Facultad de Ingenieria',	6.00),
('32941cdf-14f4-4bd6-b1dd-4b873d858cbb',	'Psicologia',	'Alejandro Cosentino',	'Facultad de Ingenieria',	6.00),
('9fedf771-e4af-4f90-8223-bd3cdfb6e791',	'Computacion Aplicada',	'Rodrigo Duran',	'Facultad de Ingenieria',	6.00),
('3b058672-5118-4f7a-8ec5-8dff7b2bb3f8',	'Introduccion a la Ingenieria de Software',	'Gabriel Taboada',	'Facultad de Ingenieria',	4.00),
('46906625-f31a-49ab-89ca-aed4216de38d',	'Higiense, Seguridad y Ecologia',	'Enrique Fazzio',	'Facultad de Ingenieria',	4.00),
('a0150120-ca3e-4761-b570-b6759e9c882e',	'Auditoria de Sistemas',	'Marcela Pallero',	'Facultad de Ingenieria',	4.00),
('ec370ab9-831b-4f52-84c2-dbf74d78d643',	'Inteligencia Artificial',	'Gabriel Barrera',	'Facultad de Ingenieria',	6.00),
('fbca472a-25a3-4e0c-bfcc-35fccfe80d4a',	'Analisis Matematico II',	'Paula Cerasulo',	'Facultad de Ingenieria',	4.00);

DROP TABLE IF EXISTS `Enrollment`;
CREATE TABLE `Enrollment` (
  `id` varchar(255) NOT NULL,
  `course_id` varchar(255) NOT NULL,
  `student_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Enrollment` (`id`, `course_id`, `student_id`) VALUES
('00a35215-98c8-4250-9830-8eb446d26e3b',	'32941cdf-14f4-4bd6-b1dd-4b873d858cbb',	'bfc4109f-dfe7-422d-bdbb-7d08fcaaf414'),
('00ee8163-32f1-41f5-9403-647864611891',	'3733e160-46f3-4348-9f59-89641751cc1b',	'f2ec5b7d-e56a-421b-b7f9-42700b280625'),
('04701332-3cc6-4a90-9583-425de175de53',	'32941cdf-14f4-4bd6-b1dd-4b873d858cbb',	'f2ec5b7d-e56a-421b-b7f9-42700b280625'),
('22497640-47d2-4775-9676-53a050ccfc09',	'20920856-6f66-456c-943f-7a37cb075144',	'f2ec5b7d-e56a-421b-b7f9-42700b280625'),
('2520533c-1b6b-4d7b-8001-43e6d5a7240a',	'0c6dddb6-c665-4f7d-b1e2-e5344d61a9c8',	'f2ec5b7d-e56a-421b-b7f9-42700b280625'),
('29522cb6-a5a5-4412-8edb-26e7455147f7',	'3733e160-46f3-4348-9f59-89641751cc1b',	'8ef94a14-f69e-4ed8-a01e-b7765c13a71f'),
('336b93ec-4fdf-451e-88ef-46769c50ad1e',	'3733e160-46f3-4348-9f59-89641751cc1b',	'64f39fef-f99c-42bb-a27d-760c10c176f5'),
('61c59f95-355c-440d-8c5f-b48fb06692c2',	'acaf9c56-ecf7-4c29-81bf-cc8ae197edda',	'f2ec5b7d-e56a-421b-b7f9-42700b280625'),
('7eba49aa-d8c6-45d7-8eb7-c1684382e71a',	'ec370ab9-831b-4f52-84c2-dbf74d78d643',	'04051eda-caf3-46cf-9f1c-54572f1dd4e1'),
('9294053b-d22e-4f8f-ae7b-04b14aedf9ed',	'9fedf771-e4af-4f90-8223-bd3cdfb6e791',	'04051eda-caf3-46cf-9f1c-54572f1dd4e1');

DROP TABLE IF EXISTS `Grade`;
CREATE TABLE `Grade` (
  `id` varchar(255) NOT NULL,
  `student_id` varchar(255) NOT NULL,
  `course_id` varchar(255) NOT NULL,
  `grade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Grade` (`id`, `student_id`, `course_id`, `grade`) VALUES
('38f1d659-e5e2-4e02-99e9-f836a96978fc',	'f2ec5b7d-e56a-421b-b7f9-42700b280625',	'3733e160-46f3-4348-9f59-89641751cc1b',	10),
('e8e7a516-b24e-4f55-9527-cd42dcf4c0ec',	'bfc4109f-dfe7-422d-bdbb-7d08fcaaf414',	'32941cdf-14f4-4bd6-b1dd-4b873d858cbb',	3),
('bc40842b-335a-493c-b7cc-330be1d5186c',	'f2ec5b7d-e56a-421b-b7f9-42700b280625',	'32941cdf-14f4-4bd6-b1dd-4b873d858cbb',	6),
('f2726f5a-d33a-4b00-844b-594054fef582',	'f2ec5b7d-e56a-421b-b7f9-42700b280625',	'20920856-6f66-456c-943f-7a37cb075144',	8),
('2d985b0f-d3e3-43d0-91a5-a6067218f6e7',	'8ef94a14-f69e-4ed8-a01e-b7765c13a71f',	'3733e160-46f3-4348-9f59-89641751cc1b',	4);

DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `birthdate` datetime NOT NULL,
  `creationDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `Student` (`id`, `name`, `surname`, `email`, `birthdate`, `creationDate`) VALUES
('f2ec5b7d-e56a-421b-b7f9-42700b280625',	'Juan Manuel',	'Cugat',	'jcugat@palermo.edu',	'1991-04-25 00:00:00',	'2019-12-11 00:00:00'),
('bfc4109f-dfe7-422d-bdbb-7d08fcaaf414',	'Jose',	'Canseco',	'jcanseco@palermo.edu',	'1980-02-25 00:00:00',	'2019-12-12 00:00:00'),
('04051eda-caf3-46cf-9f1c-54572f1dd4e1',	'Gustavo',	'Jerez',	'gjerez@palermo.edu',	'1995-03-21 00:00:00',	'2019-12-12 00:00:00'),
('8ef94a14-f69e-4ed8-a01e-b7765c13a71f',	'Romina',	'Gaetan',	'rgaetan@palermo.edu',	'1993-07-11 00:00:00',	'2019-12-12 00:00:00'),
('64f39fef-f99c-42bb-a27d-760c10c176f5',	'Susana',	'Corrales',	'scorrales@palermo.edu',	'1989-12-01 00:00:00',	'2019-12-12 00:00:00');

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `User` (`id`, `username`, `password`) VALUES
('f9f14527-a9f1-4106-bebd-275d7445dce8',	'admin',	'$2a$10$kSXijolQZaXTuUy00HONF.aymO2HL7DTo6ZbV1sQWyIQTZ898U6q6');

-- 2019-12-12 18:36:51