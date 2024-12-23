-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: gdou_library
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_info` (
  `operator_id` int NOT NULL AUTO_INCREMENT,
  `operator_name` varchar(205) DEFAULT NULL,
  `operator_pass` varchar(205) DEFAULT NULL,
  PRIMARY KEY (`operator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES (2,'root','63a9f0ea7bb98050796b649e85481845');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_his_info`
--

DROP TABLE IF EXISTS `book_his_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_his_info` (
  `hid` int NOT NULL AUTO_INCREMENT,
  `aid` int DEFAULT NULL,
  `bid` varchar(205) DEFAULT NULL,
  `card` varchar(205) DEFAULT NULL,
  `book_name` varchar(205) DEFAULT NULL,
  `admin_name` varchar(205) DEFAULT NULL,
  `username` varchar(205) DEFAULT NULL,
  `begin_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_his_info`
--

LOCK TABLES `book_his_info` WRITE;
/*!40000 ALTER TABLE `book_his_info` DISABLE KEYS */;
INSERT INTO `book_his_info` VALUES (12,4,'26','9787020058357','红楼梦','huxuanhao','胡轩浩','2024-02-22','2024-03-23',1),
                                   (13,4,'27','9787544253994','百年孤独','huxuanhao','胡轩浩','2024-02-22','2024-03-23',2);
/*!40000 ALTER TABLE `book_his_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_type_info`
--

DROP TABLE IF EXISTS `book_type_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_type_info` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `book_type_info_pk` (`name`),
  UNIQUE KEY `book_type_info_pk_2` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_type_info`
--

LOCK TABLES `book_type_info` WRITE;
/*!40000 ALTER TABLE `book_type_info` DISABLE KEYS */;
INSERT INTO `book_type_info` VALUES
                                 (69,'文学小说'),
                                 (70,'历史传记'),
                                 (87,'历史社科'),
                                 (86,'心理学'),
                                 (85,'计算机丛书');
/*!40000 ALTER TABLE `book_type_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_info`
--

DROP TABLE IF EXISTS `books_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_info` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(205) NOT NULL,
  `card` varchar(205) NOT NULL,
  `author` varchar(205) DEFAULT NULL,
  `num` int NOT NULL,
  `press` varchar(205) DEFAULT NULL,
  `type` varchar(205) DEFAULT NULL,
  `status` int DEFAULT '2',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_info`
--

LOCK TABLES `books_info` WRITE;
/*!40000 ALTER TABLE `books_info` DISABLE KEYS */;
INSERT INTO `books_info` VALUES
                             (26,'红楼梦','9787020058357','曹雪芹',1,'人民文学出版社','文学小说',1),
                             (27,'百年孤独','9787544253994','加西亚·马尔克斯',1,'南海出版公司','文学小说',1),
                             (28,'史记','9787101000584','司马迁',1,'中华书局','历史传记',1),
                             (29,'人类简史','9787508660752','尤瓦尔·赫拉利',1,'中信出版社','历史社科',1),
                             (30,'浪潮之巅','9787115405676','吴军',1,'电子工业出版社','计算机丛书',2),
                             (31,'深度学习','9787111462237','Ian Goodfellow',1,'机械工业出版社','计算机丛书',2),
                             (32,'Python编程：从入门到实践','9787115428028','Eric Matthes',1,'人民邮电出版社','计算机丛书',2),
                             (33,'经济学原理','9787300176745','格里高利·曼昆',1,'北京大学出版社','经济管理',3),
                             (34,'影响力','9787508639675','罗伯特·西奥迪尼',1,'中国人民大学出版社','心理学',3),
                             (35,'设计模式：可复用面向对象软件的基础','9787115112721','Erich Gamma',1,'机械工业出版社','计算机丛书',2);
/*!40000 ALTER TABLE `books_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int DEFAULT '1',
  `lend_num` int DEFAULT '30' COMMENT '可借阅天数',
  `max_num` int DEFAULT '15' COMMENT '可以借阅数量',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (4,'huxuanhao','胡轩浩','26eabd1bdbf09cc2db12fd26bc18005f','3447536171@qq.com','13543349718',1,30,15);
                               /*(5,'test','测试','e86fdc2283aff4717103f2d44d0610f7','123456789@qq.com','15977666222',1,30,15);*/
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-22 18:09:49
