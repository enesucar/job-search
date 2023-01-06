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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` varchar(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('071b1f6b-4a89-4963-865f-2b06e0244737','Kilis'),('14dfca13-cbf3-47f2-8c84-9001e462032e','Manisa'),('16207ea2-fa70-47f8-8071-1865bb9e11dd','Giresun'),('1d17dd6e-217d-4b9e-9b0f-2fc927e0b1e8','Tokat'),('2ade0f09-e381-4be0-ac4c-ab4867e9e6ec','Muğla'),('2b01fb97-a287-45f3-b9fd-836fd2b411c6','Tekirdağ'),('348349c7-5466-4139-b7c0-a71486e05083','Mersin'),('3730bd15-9e46-4bb2-86e4-a39270c612f4','Trabzon'),('392ab2c2-eec7-42bd-8324-424b37a2aa05','Sivas'),('3af31f40-f675-4f1e-b65b-df391af4a2a5','Erzincan'),('3c0734f6-4a79-43b1-8501-d15cfab29fc8','Afyonkarahisar'),('3dc83abf-d422-4be0-9d46-46b1ce778168','Bursa'),('3f45c4a4-4845-4c71-b94f-31fe845ac1e9','Ardahan'),('44a90223-c2e2-4a0d-8eff-e20eee4f69f2','Gümüşhane'),('48b71bbf-3601-4e95-8da3-1d9f9cc78002','Sakarya'),('4ecee479-1436-42f1-846a-7eefae7d2df0','Kars'),('506764e7-df2b-4953-a5fe-1858b193051e','Malatya'),('52eff8ce-b870-47ce-a179-bc5c3fd7334c','Balıkesir'),('5dba3a33-f05e-4966-bf46-9f5f28b13fc2','Adana'),('621e47f7-24e7-411d-8f23-8552acd7d86a','Bitlis'),('6330ea87-856b-444a-bbf2-ad270f9157c5','Uşak'),('6599ec13-46f6-4784-9e71-e62b94fe4a04','Çankırı'),('6e18ebfe-241a-43b9-8a65-3d1630c2620f','İzmir'),('6e91fed3-4c2b-413c-9901-21a9a02b8b9b','Bilecik'),('6ec04566-2a38-4106-8121-2f73a6e84dba','Kırklareli'),('74276200-61be-4615-9378-a98ccce27197','Adıyaman'),('773917d2-c85f-4b33-bea7-6dfd90040fe2','Sinop'),('7a2e4c59-7d09-4a91-9a16-752befd173ae','İstanbul'),('7e90f596-f2e6-4459-a94d-b0ee0a00b202','Mardin'),('7fe41c81-c3a4-4ff3-907a-f99687cfe78e','Kırıkkale'),('80267ab7-3901-48b8-a019-9ef76dc2000b','Kayseri'),('81d43ddf-2e60-4247-b487-64910cb9fa98','Bartın'),('83317f45-30e1-4c16-84a3-ff96d37cfdcc','Isparta'),('84415b83-d32c-44c7-9d69-fb81cac80f06','Nevşehir'),('854a2fb3-4fa9-43a8-bdd4-b8da9fb11ca9','Çorum'),('8717b701-1668-4942-820a-13e2ee564414','Yalova'),('8750bccb-f814-4f17-9c5e-bd3e1c6af6bd','Burdur'),('8a6bcc79-95cb-4c88-8d9c-1e8f4e7af416','Artvin'),('8cb0e1aa-15ee-49c8-98e6-6cf4c95f1fc6','Düzce'),('8d5bd29d-d946-470f-a70d-696b10711482','Kırşehir'),('905fb82d-f321-49ae-948d-49a2cd008cdc','Bayburt'),('93a4d847-73af-41c7-9f13-eb956c75aa6c','Ordu'),('9459797c-90ac-4b8a-a1dc-e23dd56e651b','Erzurum'),('97d71c87-63f9-430e-8ac4-7ede771ff12d','Gaziantep'),('9e49eb78-b7a3-457b-b567-51d86ff69b5b','Diyarbakır'),('9ef96331-b004-42c0-8632-c4007a67826a','Niğde'),('a0f537dc-a3ac-4026-b025-d04c5a7ef92f','Kastamonu'),('a389b6d2-de70-4073-b082-03cff0f369ca','Çanakkale'),('a538f78e-c8d5-4e5e-87ee-abc5df85f97f','Iğdır'),('a55dc479-09a6-4393-b840-41c23357ba6e','Siirt'),('a5fd168e-4a40-47b6-b52e-b592c5f6e4bc','Şırnak'),('a7c93ca7-5de0-4795-872a-1657a1af45d1','Denizli'),('aa7e3513-c673-4822-861a-27af1d4adb2a','Samsun'),('aa8e113e-ac32-4d76-bc33-97cd87943a9e','Aydın'),('abd69664-bf84-43b5-9a06-30fd35e8e978','Konya'),('b0e1a242-ef19-44b6-9041-74fc87bbf155','Ağrı'),('b61de466-9f08-4c7f-b176-0ddbb55c98b1','Van'),('bba3915f-cf17-400c-a8d3-9a6e9dbe8c03','Muş'),('bc591126-8953-48c5-8aab-780b20f842f3','Edirne'),('c3ede73c-1351-40e9-98fd-2deb73172124','Yozgat'),('c4fba8f5-6cbb-4a37-a996-7689a452da3b','Şanlıurfa'),('c6821902-c4a5-424e-8034-38f95b9e64e3','Karaman'),('c79c0dc8-dd06-4b93-b011-89216d5d6fb0','Batman'),('cb042206-ff11-4822-b186-89585e7da4b6','Kocaeli'),('cb720d7a-2977-4719-9c2b-86cbbe91ddff','Tunceli'),('cfe850cb-6deb-4aaa-b638-adc44d47ab1d','Hakkâri'),('d1cd934b-2608-41f6-be90-c2a28c2a5ac6','Zonguldak'),('d6474bfb-ea46-4010-825e-c9488abff4f1','Bolu'),('dca8083d-2308-4be0-bb89-a77f54b9b33b','Karabük'),('de32306f-1400-4996-b420-22df1c26511c','Kahramanmaraş'),('e0acb359-567d-4e16-ac13-275d7261c3dc','Bingöl'),('e1a34803-99ef-4ad3-80c8-0cb550a64f4e','Amasya'),('e2f233d5-5632-4dcd-ba1f-e59285cbeaff','Hatay'),('e4125e02-82c3-456f-83de-0d73d874a43c','Antalya'),('e63be6dc-3c45-4694-9e3a-5fe85af68ef1','Rize'),('e80e412e-9a7e-4608-bdf6-9a9f24f3a314','Osmaniye'),('ede3a183-6179-44b4-9913-56c200acabe0','Elâzığ'),('f0e001c9-ffc8-4841-89b7-449882a7cfef','Ankara'),('fc1b0e95-3fdf-4630-ae11-0a9d6c964e0a','Eskişehir'),('fd96263a-366d-40ab-841f-0bbe5ffd1175','Aksaray'),('fe33f7d0-d009-4f4e-9766-6ad13bd7887e','Kütahya');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
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
