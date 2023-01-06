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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` varchar(36) NOT NULL,
  `job_id` varchar(36) NOT NULL,
  `job_seeker_id` varchar(36) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Application_Job_idx` (`job_id`),
  KEY `FK_JobSeeker_Job_idx` (`job_seeker_id`),
  CONSTRAINT `FK_Application_Job` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FK_JobSeeker_Job` FOREIGN KEY (`job_seeker_id`) REFERENCES `job_seeker` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES ('08452755-bb74-40f0-911f-2807ecd26ed4','78860f3c-a14c-44e0-9176-acdbb62d58a8','f6f3bd8d-a32b-4c89-bf5d-176903578fe3','2023-01-05 00:13:59',NULL),('35cdf609-d7db-46bf-bc56-fbae4056723f','bb473452-7e6a-4644-982d-848dcff9e703','60f5508d-b6db-4f44-b3ef-1c33679e2c51','2023-01-04 21:56:45',NULL),('736492ec-fb16-4265-a1d2-095750b8567d','78860f3c-a14c-44e0-9176-acdbb62d58a8','7f4dccf2-3702-476a-872d-af1b6a1e508b','2023-01-05 00:32:19',NULL),('91a74f09-f217-4a71-b251-643fb1e6a9db','bb473452-7e6a-4644-982d-848dcff9e703','469086e1-fe84-438a-997d-05eff6f48ecf','2023-01-04 21:58:45',NULL),('fde62722-0113-4136-92b2-942e8dc51b4c','06fe99e7-4f64-4ad3-a1dd-6e185cff9edb','60f5508d-b6db-4f44-b3ef-1c33679e2c51','2023-01-05 00:44:36',NULL);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
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
