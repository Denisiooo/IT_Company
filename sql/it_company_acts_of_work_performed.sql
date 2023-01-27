DROP TABLE IF EXISTS `acts_of_work_performed`;
CREATE TABLE `acts_of_work_performed` (
  `Act_ID` int NOT NULL AUTO_INCREMENT,
  `Act_date` date DEFAULT NULL,
  `ID_Number_of_contract` int NOT NULL,
  PRIMARY KEY (`Act_ID`),
  KEY `index2` (`ID_Number_of_contract`),
  CONSTRAINT `ke` FOREIGN KEY (`ID_Number_of_contract`) REFERENCES `contract` (`ID_Number_of_contract`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `acts_of_work_performed` WRITE;
INSERT INTO `acts_of_work_performed` VALUES (1,'2022-10-10',1),(2,'2022-11-01',2),(3,'2023-07-12',3),(4,'2023-01-05',4),(5,'2023-01-12',5);
UNLOCK TABLES;
