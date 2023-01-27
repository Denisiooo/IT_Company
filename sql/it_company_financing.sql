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
-- Table structure for table `financing`
--

DROP TABLE IF EXISTS `financing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financing` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Software_ID` int NOT NULL,
  `Investor_ID` int NOT NULL,
  `Investor` varchar(40) DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `software_financ` (`Software_ID`),
  KEY `investor` (`Investor_ID`),
  CONSTRAINT `investor` FOREIGN KEY (`Investor_ID`) REFERENCES `investors` (`Investor_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `software_financ` FOREIGN KEY (`Software_ID`) REFERENCES `software` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financing`
--

LOCK TABLES `financing` WRITE;
/*!40000 ALTER TABLE `financing` DISABLE KEYS */;
INSERT INTO `financing` VALUES (1,1,1,'WWW',100),(2,1,2,'HelpInvest',100),(3,2,3,'Investition',300),(4,2,4,'MoneyPlus',300),(5,3,1,'InvestCO',100),(6,4,3,'Investition',300),(7,5,2,'HelpInvest',100);
/*!40000 ALTER TABLE `financing` ENABLE KEYS */;
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
