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
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `id` varchar(36) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text,
  `category_id` varchar(36) NOT NULL,
  `position_id` varchar(36) NOT NULL,
  `employer_id` varchar(36) NOT NULL,
  `city_id` varchar(36) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Position_JobSeeker_idx` (`position_id`),
  KEY `FK_Job_Employer_idx` (`employer_id`),
  KEY `FK_Job_City_idx` (`city_id`),
  KEY `FK_Job_Category_idx` (`category_id`),
  CONSTRAINT `FK_Job_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_Job_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_Job_Employer` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`),
  CONSTRAINT `FK_Job_Position` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('06fe99e7-4f64-4ad3-a1dd-6e185cff9edb','string','string','c82b99ef-2815-4fb2-8740-f3dd684a6a33','4acece61-4d1c-42e3-b8b1-e9a20b5f8e72','57ada3e4-ae33-4902-a91e-e10e21cdcea5','2ade0f09-e381-4be0-ac4c-ab4867e9e6ec','2023-01-04 22:25:55','2023-01-04 22:25:55','2023-01-04 21:56:45','2023-01-05 01:40:58'),('78860f3c-a14c-44e0-9176-acdbb62d58a8','string','string','5a71c4b9-be42-403a-b344-934b1c1eacc7','1a689fe4-abf1-4fcc-93d3-e9539b3e22dd','57ada3e4-ae33-4902-a91e-e10e21cdcea5','2b01fb97-a287-45f3-b9fd-836fd2b411c6','2023-01-04 23:24:35','2023-01-04 23:24:35','2023-01-04 21:19:40','2023-01-05 02:25:07'),('bb473452-7e6a-4644-982d-848dcff9e703','.Net Yazılım Uzmanı','ÜNLÜ & Co bünyesinde yer alan İstanbul Varlık Yönetimi için “.NET Yazılım Uzmanı” arıyoruz.','c82b99ef-2815-4fb2-8740-f3dd684a6a33','4acece61-4d1c-42e3-b8b1-e9a20b5f8e72','57ada3e4-ae33-4902-a91e-e10e21cdcea5','2ade0f09-e381-4be0-ac4c-ab4867e9e6ec','2023-02-08 22:10:40','2023-03-05 21:19:40','2023-01-04 21:24:40',NULL),('cc307209-e309-45cd-96f5-955c892a685e','string','string','c82b99ef-2815-4fb2-8740-f3dd684a6a33','4acece61-4d1c-42e3-b8b1-e9a20b5f8e72','57ada3e4-ae33-4902-a91e-e10e21cdcea5','2ade0f09-e381-4be0-ac4c-ab4867e9e6ec','2023-01-04 22:21:25','2023-01-05 22:21:25','2023-01-05 01:25:29',NULL);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
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
