DROP TABLE IF EXISTS `products_type`;

CREATE TABLE `products_type` (
  `Type_ID` int NOT NULL AUTO_INCREMENT,
  `Product_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `products_type` WRITE;
INSERT INTO `products_type` VALUES (1,'Application software'),(2,'Application software'),(3,'Application software'),(4,'Application software'),(5,'Application software');
UNLOCK TABLES;
