-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: it_company
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `participation_in_development`
--

DROP TABLE IF EXISTS `participation_in_development`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participation_in_development` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Сalendar_plan_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
  `Employee` varchar(40) DEFAULT NULL,
  `Job_description` varchar(40) DEFAULT NULL,
  `Programming_language` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `participation_in_development` (`Employee_ID`),
  KEY `calendar` (`Сalendar_plan_ID`),
  CONSTRAINT `calendar` FOREIGN KEY (`Сalendar_plan_ID`) REFERENCES `сalendar_plan` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `participation_in_development` FOREIGN KEY (`Employee_ID`) REFERENCES `programmers` (`ID_Employee`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participation_in_development`
--

LOCK TABLES `participation_in_development` WRITE;
/*!40000 ALTER TABLE `participation_in_development` DISABLE KEYS */;
INSERT INTO `participation_in_development` VALUES (1,1,1,'Agap','Market analysis','Java'),(2,1,1,'Agap','Competitor analysis','JAVA'),(3,2,2,'Maria','Creation of TF','Java_SQL_javascript'),(4,2,2,'Maria','Approval of TF','Java_SQL_javascript'),(5,3,3,'Maksimilyan','Developing','Java_SQL'),(6,3,4,'Nadezhda','Developing','Java_SQL'),(7,4,5,'Epistima','Developing','HTML_css_javascript'),(8,4,6,'Evmen','Developing','HTML_css_javascript'),(9,5,7,'Tatyana','Manual_testing','Java_SQL'),(10,5,8,'Pamfilij','QA','HTML_css_javascript'),(11,5,9,'Feofilakt','Manual_testing','Java_SQL'),(12,5,10,'Yakov','QA','HTML_css_javascript');
/*!40000 ALTER TABLE `participation_in_development` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-27 14:27:22
