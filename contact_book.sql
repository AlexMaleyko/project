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
  `file_path` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `file_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `upload_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comment` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `contact_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`attachment_id`),
  KEY `fk_attachment_contact` (`contact_id`),
  CONSTRAINT `fk_attachment_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (2,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(3,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(4,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(5,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(6,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(7,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2),(8,'c:/Documents/MyDocuments/Folder','text.pdf','2017-03-27 16:53:45',NULL,NULL,2);
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
  `profile_picture_name` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (2,'Петя','Иванов','Егорович','1989-02-16','m','Республика Беларусь','холост','www.ivanovPetia.by','petr@gmail.com','Автослесарь','Беларусь','Минск','Пролетарская 24-16','154235',NULL,NULL),(3,'Федор','Емельянов','Афанасьевич','1948-11-14','м','Российская Федерация','разведен','','fedia1948@mail.ru','Пенсионер','Беларусь','Сморгонь','Ленина 12-31','223123','',NULL),(4,'Федор','Емельяненко',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(7,'Федор','Емельяненко',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Федор','Емельяненко',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(39,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(40,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(41,'Федор','Емельяненко',NULL,'1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(42,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(43,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(44,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(45,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(46,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(47,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(48,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(49,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(51,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(52,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(53,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(54,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(55,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(56,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(57,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(58,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(60,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(61,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(62,'Федор','Емельяненко',NULL,'1970-01-16',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(63,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL),(64,'Федор','Емельяненко','Васильевич','1998-12-03','м',NULL,NULL,NULL,NULL,NULL,NULL,'Ровно',NULL,NULL,NULL,NULL);
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
  `number` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comment` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deletion_date` timestamp NULL DEFAULT NULL,
  `contact_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`number_id`),
  KEY `fk_phone_number_contact` (`contact_id`),
  CONSTRAINT `fk_phone_number_contact` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
INSERT INTO `phone_number` VALUES (3,'+375','29','6609198','m','Hello',NULL,2),(5,'+375','29','6609198','m','Hello',NULL,2),(6,'+375','29','6609198','m','Hello',NULL,2),(7,'+375','29','6609198','m','Hello',NULL,2),(8,'+375','29','6609198','m','Hello',NULL,2),(9,'+375','29','6609198','m','Hello',NULL,2);
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

-- Dump completed on 2017-03-28 21:30:43
