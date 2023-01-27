DROP TABLE IF EXISTS `investors`;
SET character_set_client = utf8mb4 */;
CREATE TABLE `investors` (
  `Investor_ID` int NOT NULL AUTO_INCREMENT,
  `Investor_name` varchar(40) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Pnone_number` int DEFAULT NULL,
  PRIMARY KEY (`Investor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `investors` WRITE;

INSERT INTO `investors` VALUES (1,'InvestCO','Brazil',15468922),(2,'HelpInvest','Sweden',145236528),(3,'Investition','USA',75012027),(4,'MoneyPlus','Canada',2532519);
UNLOCK TABLES;
