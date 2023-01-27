DROP TABLE IF EXISTS `participation_in_development`;

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

LOCK TABLES `participation_in_development` WRITE;
INSERT INTO `participation_in_development` VALUES (1,1,1,'Agap','Market analysis','Java'),(2,1,1,'Agap','Competitor analysis','JAVA'),(3,2,2,'Maria','Creation of TF','Java_SQL_javascript'),(4,2,2,'Maria','Approval of TF','Java_SQL_javascript'),(5,3,3,'Maksimilyan','Developing','Java_SQL'),(6,3,4,'Nadezhda','Developing','Java_SQL'),(7,4,5,'Epistima','Developing','HTML_css_javascript'),(8,4,6,'Evmen','Developing','HTML_css_javascript'),(9,5,7,'Tatyana','Manual_testing','Java_SQL'),(10,5,8,'Pamfilij','QA','HTML_css_javascript'),(11,5,9,'Feofilakt','Manual_testing','Java_SQL'),(12,5,10,'Yakov','QA','HTML_css_javascript');
UNLOCK TABLES;

