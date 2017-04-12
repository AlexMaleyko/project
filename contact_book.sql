-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: contact_book
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachment` (
  `attachment_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `file_path` varchar(260) COLLATE utf8mb4_unicode_ci NOT NULL,
  `file_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `upload_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comment` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `contact_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`attachment_id`),
  KEY `fk_attachment_contact` (`contact_id`),
  CONSTRAINT `fk_attachment_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (1,'C:\\contact book\\contact files\\204\\1.exe','asdfasdfsadf','2017-04-11 21:54:11','agergsdrgsdg','2017-04-11 21:54:11',204),(2,'C:\\contact book\\contact files\\188\\2.pdf','ba01-maleyko.pdf','2017-04-11 22:25:38','',NULL,188);
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contact_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `patronymic` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `gender` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `citizenship` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `marital_status` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `website` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `postal_code` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `profile_picture` varchar(260) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (186,'a','b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-04-11 20:08:25',NULL),(187,'Александр','Беляев','','2015-12-12','','','','','','','','','','',NULL,NULL),(188,'Александр','Вашина','Александрович',NULL,'','','','','','','','','','',NULL,'C:\\contact book\\profile pictures\\188\\188.jpg'),(189,'Александр','Македонский','',NULL,'','','','','','','','','','',NULL,NULL),(190,'Александр','Чергинец','',NULL,'','','','','','','','','','',NULL,NULL),(191,'Александр','Малышко','',NULL,'','','','','','','','','','','2017-04-11 21:37:17',NULL),(192,'Александр','Иванов','',NULL,'','','','','','','','','','','2017-04-11 21:37:17',NULL),(193,'Александр','Петров','',NULL,'','','','','','','','','','',NULL,NULL),(194,'Александр','Сидоров','',NULL,'','','','','','','','','','','2017-04-11 21:37:17',NULL),(195,'Александр','Пучеглазов','',NULL,'','','','','','','','','','',NULL,NULL),(196,'Александр','Мороз','',NULL,'','','','','','','','','','',NULL,NULL),(197,'Александр','Грозный','',NULL,'','','','','','','','','','',NULL,NULL),(198,'Александр','Тихий','',NULL,'','','','','','','','','','',NULL,NULL),(199,'Александр','Вертинский','','1995-03-12','m','','','','','','','','','',NULL,'C:\\contact book\\profile pictures\\199\\199.jpg'),(200,'Александр','Ибрагимов','',NULL,'','','','','','','','','','',NULL,NULL),(201,'Александр','Нагибин','',NULL,'','','','','','','','','','',NULL,NULL),(202,'Алексей','Малейко','',NULL,'','','','','','','','','','','2017-04-11 21:37:41',NULL),(203,'Александр','Малевич','Дмитриевич',NULL,'','','','','','','','','','',NULL,NULL),(204,'Александр','Зайцев','314rct234d','0009-07-03','m','1234c21','12c4c1','123c','','1243','1234','1243c12','1c234','12c4','2017-04-11 21:54:11',NULL),(205,'Пархейчук','Илья','Олегович',NULL,'','','','','','','','','','',NULL,NULL),(206,'12','12','12','0001-01-03','f','','','','','','','','','','2017-04-11 21:54:11',NULL),(207,'[[[[[[[[[[[[[[[[','Mal.....','...............',NULL,'','','','','','','','','','','2017-04-11 21:54:11',NULL),(208,'Мария','Чуприс','',NULL,'','','','','','','','','','',NULL,NULL);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number`
--

DROP TABLE IF EXISTS `phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_number` (
  `number_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `country_code` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `operator_code` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `number` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comment` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `contact_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`number_id`),
  KEY `fk_phone_number_contact` (`contact_id`),
  CONSTRAINT `fk_phone_number_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
INSERT INTO `phone_number` VALUES (2,'','','123421','','','2017-04-11 21:54:11',204);
/*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12 17:07:52
