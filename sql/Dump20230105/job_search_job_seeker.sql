-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: job_search
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
-- Table structure for table `job_seeker`
--

DROP TABLE IF EXISTS `job_seeker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_seeker` (
  `id` varchar(36) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `summary_info` varchar(250) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `city_id` varchar(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_City_JobSeeker_idx` (`city_id`),
  CONSTRAINT `FK_JobSeeker_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_seeker`
--

LOCK TABLES `job_seeker` WRITE;
/*!40000 ALTER TABLE `job_seeker` DISABLE KEYS */;
INSERT INTO `job_seeker` VALUES ('195ce22f-3e40-42fb-8109-e2ff35a674da','Deneme1','Deneme2','Deneme3','enesucar1@gmail.com','14dfca13-cbf3-47f2-8c84-9001e462032e','2023-01-04 01:51:49','2023-01-04 18:53:24'),('469086e1-fe84-438a-997d-05eff6f48ecf','Servet','Akaş','Lorem Ipsum is simply dummy text of the printing and typesetting industry.','enesucar14@gmail.com','d1cd934b-2608-41f6-be90-c2a28c2a5ac6','2023-01-04 01:59:56',NULL),('60f5508d-b6db-4f44-b3ef-1c33679e2c51','Erica','Summer','There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.','enesucar22@gmail.com','a389b6d2-de70-4073-b082-03cff0f369ca','2023-01-04 03:38:02',NULL),('7f4dccf2-3702-476a-872d-af1b6a1e508b','Enes','Uçar','Summary info test','enes@gmail.com','1d17dd6e-217d-4b9e-9b0f-2fc927e0b1e8','2023-01-04 04:13:44',NULL),('899eee8f-8e26-4235-8eaf-5f7ece89f36b','Enes','Uçar','asdasd','asdasds@111.com','2b01fb97-a287-45f3-b9fd-836fd2b411c6','2023-01-05 03:27:54',NULL),('9cb09b81-ea17-4f1a-9d62-294af882002e','Enes','Uçar','Denemedeneme','enesucar24@gmail.com','d1cd934b-2608-41f6-be90-c2a28c2a5ac6','2023-01-04 03:21:09',NULL),('a28a5aa4-fa35-491b-acd0-40d5b6a9e325','Enes','Uçar','Merhaba, ben bir yazılımcıyım.','deneme@gmail.com','2ade0f09-e381-4be0-ac4c-ab4867e9e6ec','2023-01-05 02:51:33',NULL),('addcc7b0-5470-4bee-abad-ec275d2dd58b','Enes','Uçar','asdasd','asdasd@gggmail.com','2b01fb97-a287-45f3-b9fd-836fd2b411c6','2023-01-05 03:11:41',NULL),('d46ff774-3ac7-4a02-bba0-c6d65e81d88d','Erica','Summers','There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.','enesucar3@gmail.com','a389b6d2-de70-4073-b082-03cff0f369ca','2023-01-04 03:35:21',NULL),('d616a6f8-3e23-4a42-9cc8-5e50ae51ca76','Enes','Uçar','Summary info test','enes12@gmail.com','1d17dd6e-217d-4b9e-9b0f-2fc927e0b1e8','2023-01-04 04:17:12',NULL),('f6f3bd8d-a32b-4c89-bf5d-176903578fe3','Enes','Uçar','Summary info test','enes13@gmail.com','1d17dd6e-217d-4b9e-9b0f-2fc927e0b1e8','2023-01-04 04:18:06',NULL);
/*!40000 ALTER TABLE `job_seeker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-05  3:37:57
