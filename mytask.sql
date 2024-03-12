-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mytask
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `addtask`
--

DROP TABLE IF EXISTS `addtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addtask` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `task` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addtask`
--

LOCK TABLES `addtask` WRITE;
/*!40000 ALTER TABLE `addtask` DISABLE KEYS */;
INSERT INTO `addtask` VALUES (1,'name','task',''),(15,'name','task',''),(16,'name','task',''),(17,'name','task',''),(18,'names','task',''),(19,'name','task',''),(20,'name','task',''),(21,'name','task',''),(22,'name','task',''),(23,'name','task','2024-02-13');
/*!40000 ALTER TABLE `addtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `completed`
--

DROP TABLE IF EXISTS `completed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `completed` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `task` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `deadline` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `timestamp` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `completed`
--

LOCK TABLES `completed` WRITE;
/*!40000 ALTER TABLE `completed` DISABLE KEYS */;
INSERT INTO `completed` VALUES (1,'','walking','19-02-2024','19-02-2024','01:01 PM',''),(2,'','walk','19-02-2024','19-02-2024','01:00 PM',''),(3,'','walk','19-02-2024','19-02-2024','01:00 PM',''),(4,'','run','19-02-2024','19-02-2024','02:56 PM',''),(95,'830184','kiki','12-03-2024','12-03-2024','05:07 PM',''),(96,'830184','lool','12-03-2024','12-03-2024','05:19 PM',''),(97,'830184','running','12-03-2024','12-03-2024','08:49 PM','2024-03-12 20:51:37.528');
/*!40000 ALTER TABLE `completed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deadlinedata`
--

DROP TABLE IF EXISTS `deadlinedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deadlinedata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `task` varchar(45) NOT NULL,
  `deadline` varchar(45) NOT NULL,
  `timestamp` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=285 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deadlinedata`
--

LOCK TABLES `deadlinedata` WRITE;
/*!40000 ALTER TABLE `deadlinedata` DISABLE KEYS */;
INSERT INTO `deadlinedata` VALUES (1,'','run','2024-02-19',''),(2,'','walk','2024-02-19',''),(3,'','bbbb','2024-03-02',''),(283,'830184','hihi','2024-03-12','');
/*!40000 ALTER TABLE `deadlinedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `task` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `deadline` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `timestamp` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
INSERT INTO `todo` VALUES (1,'','run','19-02-2024','19-02-2024','02:56 PM',''),(2,'','walk','19-02-2024','19-02-2024','01:00 PM',''),(150,'830184','hihi','12-03-2024','12-03-2024','08:41 PM','2024-03-12 20:41:54.232');
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `passWord` varchar(200) DEFAULT NULL,
  `timestamp` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (1,'065774','veve','6515b427740a3324c4186385769f2e6c36afa97b78f2ccbd0d1e7ee4fdd414da',''),(2,'916104','vea','39e3b208219aa70b194386db972dcdd9e762d844164916391f75b211016374c0',''),(3,'697384','bea','cb5892e70396e27fea65902232f8fa15a8cab64a3fbbfbb705f3faa634847ab6',''),(4,'295733','lea','3aeacfca903b6825f7df15c9554bedb30b6c76f14a797b7b6c23c64250c12132',''),(14,'326760','v','4c94485e0c21ae6c41ce1dfe7b6bfaceea5ab68e40a2476f50208e526f506080',''),(15,'845473','g','cd0aa9856147b6c5b4ff2b7dfee5da20aa38253099ef1b4a64aced233c9afe29',''),(16,'327742','nn','fab66aa01347d3f11a16468941378cea495937e5f482e18ea6472681e03d3936',''),(17,'830184','j','189f40034be7a199f1fa9891668ee3ab6049f82d38c68be70f596eab2e1857b7',''),(18,'707313','l','acac86c0e609ca906f632b0e2dacccb2b77d22b0621f20ebece1a4835b93f6f0','2024-03-12 20:56:26.068');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-12 21:19:55
