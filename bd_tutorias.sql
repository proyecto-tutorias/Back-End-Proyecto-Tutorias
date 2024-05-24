CREATE DATABASE  IF NOT EXISTS `bd_tutorias` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_tutorias`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_tutorias
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamientotutoria`
--

DROP TABLE IF EXISTS `agendamientotutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamientotutoria` (
  `id_agendamiento` int NOT NULL AUTO_INCREMENT,
  `url_reunion` text,
  `fecha_agendamiento` varchar(200) DEFAULT NULL,
  `id_plataforma_reunion` int DEFAULT NULL,
  `activo` int DEFAULT NULL,
  `datos_adicionales` varchar(200) DEFAULT NULL,
  `hora_inicio` varchar(45) DEFAULT NULL,
  `hora_fin` varchar(45) DEFAULT NULL,
  `fecha_inicio` varchar(45) DEFAULT NULL,
  `fecha_fin` varchar(45) DEFAULT NULL,
  `hora_def` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_agendamiento`),
  KEY `agendamientotutoria_ibfk_2` (`id_plataforma_reunion`),
  CONSTRAINT `agendamientotutoria_ibfk_1` FOREIGN KEY (`id_agendamiento`) REFERENCES `notificaciones` (`id_notificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `agendamientotutoria_ibfk_2` FOREIGN KEY (`id_plataforma_reunion`) REFERENCES `plataformasreunion` (`id_plataforma_reunion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamientotutoria`
--

LOCK TABLES `agendamientotutoria` WRITE;
/*!40000 ALTER TABLE `agendamientotutoria` DISABLE KEYS */;
INSERT INTO `agendamientotutoria` VALUES (13,'www','2024-05-24',1,1,'lo mas pronto posible',NULL,NULL,NULL,NULL,NULL),(19,NULL,'2024-05-18',NULL,1,'dsds',NULL,NULL,NULL,NULL,NULL),(21,NULL,'2024-05-18',NULL,1,'fdfd',NULL,NULL,NULL,NULL,NULL),(30,'https://meet.google.com/qjf-ijtu-vqd','2024-05-31',2,0,'dsds',NULL,NULL,NULL,NULL,NULL),(32,'','2024-05-24',1,0,'fdf',NULL,NULL,NULL,NULL,NULL),(34,'https://meet.google.com/qjf-ijtu-vqd','2024-05-26',1,0,'pronto','05:06','21:06','2024-05-22','2024-05-27','07:16'),(35,'https://meet.google.com/qjf-ijtu-vqd','2024-05-28',3,0,'por meet porfa','09:59','22:59','2024-05-27','2024-05-29','11:59'),(36,'https://meet.google.com/qjf-ijtu-vqd','2024-05-31',1,0,'me gusta escuchar musica mientras','11:27','14:27','2024-05-30','2024-05-31','14:16');
/*!40000 ALTER TABLE `agendamientotutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'Matematica'),(2,'Sociales'),(3,'Ingles'),(4,'Ciencias naturales'),(5,'Informatica'),(6,'Fisica'),(7,'Quimica'),(8,'Castellano');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `id_calificacion` int NOT NULL AUTO_INCREMENT,
  `puntaje` double DEFAULT NULL,
  `comentario` text,
  PRIMARY KEY (`id_calificacion`),
  CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`id_calificacion`) REFERENCES `agendamientotutoria` (`id_agendamiento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
INSERT INTO `calificaciones` VALUES (13,3,'a'),(19,3,'dada'),(21,5,'holap'),(30,5,'bastante buena'),(35,2,'no tan mal'),(36,3,'muy mal la verdad');
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `id_carrera` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  `min_semestre` int DEFAULT NULL,
  `max_semestre` int DEFAULT NULL,
  PRIMARY KEY (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'Ingenieria civil',1,10),(2,'Gestion ambiental industrial',1,6),(3,'Tecnologia en desarrollo de software',1,6),(4,'Psicologia',1,10),(5,'Trabajo social',1,9);
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinatario`
--

DROP TABLE IF EXISTS `destinatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destinatario` (
  `id_destinatario` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_destinatario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatario`
--

LOCK TABLES `destinatario` WRITE;
/*!40000 ALTER TABLE `destinatario` DISABLE KEYS */;
INSERT INTO `destinatario` VALUES (1,'tutor'),(2,'estudiante');
/*!40000 ALTER TABLE `destinatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'En espera de tutor'),(2,'En espera de agendamiento de horario de atencion del tutor'),(3,'En espera de agendamiento del estudiante'),(4,'En espera de agendamiento del tutor'),(5,'Agendada'),(6,'Finalizada');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id_estudiante` int NOT NULL,
  PRIMARY KEY (`id_estudiante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (19),(22),(24),(25),(26);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notificaciones` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `descripcion` text,
  `id_tutor` int DEFAULT NULL,
  `id_tutoria` int DEFAULT NULL,
  `activo` int DEFAULT NULL,
  `id_tipo_notificacion` int DEFAULT NULL,
  `id_destinatario` int DEFAULT NULL,
  PRIMARY KEY (`id_notificacion`),
  KEY `id_tipo_notificacion` (`id_tipo_notificacion`),
  KEY `notificaciones_ibfk_1` (`id_tutor`),
  KEY `notificaciones_ibfk_2` (`id_tutoria`),
  KEY `id_destinatario` (`id_destinatario`),
  CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`id_tutor`) REFERENCES `tutor` (`id_tutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`id_tutoria`) REFERENCES `tutorias` (`id_tutoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `notificaciones_ibfk_3` FOREIGN KEY (`id_tipo_notificacion`) REFERENCES `tiponotificacion` (`id_tipo_notificacion`),
  CONSTRAINT `notificaciones_ibfk_4` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`id_destinatario`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificaciones`
--

LOCK TABLES `notificaciones` WRITE;
/*!40000 ALTER TABLE `notificaciones` DISABLE KEYS */;
INSERT INTO `notificaciones` VALUES (13,'Has recibido una respuesta al Biologia #1de parte del tutor Alejandro',19,10,0,1,2),(16,'El estudiante migue ha aceptado que seas su tutor en el la tutoria \'Biologia #1\'.',19,10,1,2,1),(17,'Has recibido una respuesta al Prueba 12 de parte del tutor Alejandro',19,11,0,1,2),(18,'Tu postulacion a la tutoria Prueba 12 ha sido rechazada',19,11,1,2,1),(19,'Has recibido una respuesta al Tutoria 1 de parte del tutor Alejandro',19,12,0,1,2),(20,'El estudiante jair ha aceptado que seas su tutor en el la tutoria \'Tutoria 1\'.',19,12,1,2,1),(21,'Has recibido una respuesta al Matematica51 de parte del tutor Alejandro',19,13,0,1,2),(22,'El estudiante migue ha aceptado que seas su tutor en el la tutoria \'Matematica51\'.',19,13,1,2,1),(23,'Has recibido una respuesta al Pala de parte del tutor Alejandro',19,14,1,1,2),(30,'Has recibido una respuesta al PRunbe de parte del tutor Alejandro',19,19,0,1,2),(31,'El estudiante camilo123 ha aceptado que seas su tutor en el la tutoria \'PRunbe\'.',19,19,1,2,1),(32,'Has recibido una respuesta al fdfdfdf de parte del tutor Alejandro',19,20,0,1,2),(33,'El estudiante camilo123 ha aceptado que seas su tutor en el la tutoria \'fdfdfdf\'.',19,20,1,2,1),(34,'Has recibido una respuesta al PRunbe de parte del tutor Alejandro',19,21,0,1,2),(35,'Has recibido una respuesta al Sentient de parte del tutor Alejandro',19,22,0,1,2),(36,'Has recibido una respuesta al fdsfd de parte del tutor Alejandro',19,23,0,1,2);
/*!40000 ALTER TABLE `notificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataformasreunion`
--

DROP TABLE IF EXISTS `plataformasreunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plataformasreunion` (
  `id_plataforma_reunion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_plataforma_reunion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataformasreunion`
--

LOCK TABLES `plataformasreunion` WRITE;
/*!40000 ALTER TABLE `plataformasreunion` DISABLE KEYS */;
INSERT INTO `plataformasreunion` VALUES (1,'Google meet'),(2,'Microsoft teams'),(3,'Zoom');
/*!40000 ALTER TABLE `plataformasreunion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rangos`
--

DROP TABLE IF EXISTS `rangos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rangos` (
  `id_rango` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_rango`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rangos`
--

LOCK TABLES `rangos` WRITE;
/*!40000 ALTER TABLE `rangos` DISABLE KEYS */;
INSERT INTO `rangos` VALUES (1,'Tutor'),(2,'Tutor-Matematica'),(3,'Tutor-Sociales'),(4,'Tutor-Ingles'),(5,'Tutor-Ciencias naturales'),(6,'Tutor-Informatica'),(7,'Tutor-Fisica'),(8,'Tutor-Quimica'),(9,'Tutor-Castellano');
/*!40000 ALTER TABLE `rangos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiponotificacion`
--

DROP TABLE IF EXISTS `tiponotificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tiponotificacion` (
  `id_tipo_notificacion` int NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_notificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiponotificacion`
--

LOCK TABLES `tiponotificacion` WRITE;
/*!40000 ALTER TABLE `tiponotificacion` DISABLE KEYS */;
INSERT INTO `tiponotificacion` VALUES (1,'aprobacion'),(2,'informacion');
/*!40000 ALTER TABLE `tiponotificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `id_tutor` int NOT NULL,
  `prom_puntaje` double DEFAULT NULL,
  `id_rango` int DEFAULT NULL,
  `activo` int DEFAULT NULL,
  PRIMARY KEY (`id_tutor`),
  KEY `tutor_ibfk_2` (`id_rango`),
  CONSTRAINT `tutor_ibfk_2` FOREIGN KEY (`id_rango`) REFERENCES `rangos` (`id_rango`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (19,3.5,5,1);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutorias`
--

DROP TABLE IF EXISTS `tutorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutorias` (
  `id_tutoria` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_limite` varchar(200) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `id_estado` int DEFAULT NULL,
  `id_estudiante` int DEFAULT NULL,
  `id_area` int DEFAULT NULL,
  `activo` int DEFAULT NULL,
  `id_carrera` int DEFAULT NULL,
  PRIMARY KEY (`id_tutoria`),
  KEY `tutorias_ibfk_1` (`id_estado`),
  KEY `tutorias_ibfk_2` (`id_estudiante`),
  KEY `tutorias_ibfk_3` (`id_area`),
  KEY `id_carrera` (`id_carrera`),
  CONSTRAINT `tutorias_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutorias_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id_estudiante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutorias_ibfk_3` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tutorias_ibfk_4` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id_carrera`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutorias`
--

LOCK TABLES `tutorias` WRITE;
/*!40000 ALTER TABLE `tutorias` DISABLE KEYS */;
INSERT INTO `tutorias` VALUES (5,'prueba','cosa prueba','2020-08-10',1000,2,19,1,0,1),(8,'Matematica','Matematica','2024-05-29',5000,1,19,1,0,1),(9,'Ingles','Ingles','2024-05-27',4000,1,19,3,3,4),(10,'Biologia #1','Biologia #1','2024-05-15',5000,4,22,4,0,4),(11,'Prueba 12','ha','2024-05-31',220,1,22,4,0,3),(12,'Tutoria 45','dfgdgf','2024-05-30',500,4,24,3,1,2),(13,'Matematica51','fsfdsf','2024-05-31',4000,4,22,1,1,2),(14,'Pala2','dsdsd','2024-05-31',313,1,22,4,1,4),(15,'DQDF','ewewe','2024-05-29',56666,1,22,6,1,3),(19,'PRunbe','dsdsd','2024-05-31',500,4,26,3,1,3),(20,'fdfdfdf','dfdf','2024-05-31',313,3,26,1,0,5),(21,'PRunbe','dsds','2024-05-31',56666,6,26,3,1,5),(22,'Sentient','ddsd1334','2024-05-30',666,6,26,3,1,3),(23,'fdsfd','fdfdf','2024-05-31',56666,6,26,1,1,1),(24,'chonguizzzzzzzzzzzzzz','zdsds','2024-05-25',22424,1,26,3,0,5);
/*!40000 ALTER TABLE `tutorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `tipo_usuario` varchar(200) DEFAULT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `apellido` varchar(200) DEFAULT NULL,
  `codigo_estudiante` int DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `login` varchar(200) DEFAULT NULL,
  `id_carrera` int DEFAULT NULL,
  `activo` int DEFAULT NULL,
  `semestre` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `usuario_ibfk_1` (`id_carrera`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id_carrera`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (19,'usuario','Alejandro','Gonzalez',12,'1234','alejo',3,1,1),(21,'admin','leonardo','vergara',5854,'leon','leon',1,1,1),(22,'usuario','Miguel','Fernandez',121515,'123','migue',4,1,1),(24,'usuario','Jair','Fernandez',565,'123','jair',1,0,3),(26,'usuario','camilo','suarez',52369,'hola','camilo123',4,1,4);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23 23:00:08
