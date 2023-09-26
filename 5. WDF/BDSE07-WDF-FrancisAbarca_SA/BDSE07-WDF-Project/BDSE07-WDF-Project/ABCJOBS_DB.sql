-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: communityportal
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `bulk_email`
--

DROP TABLE IF EXISTS `bulk_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bulk_email` (
  `bulk_id` int NOT NULL AUTO_INCREMENT,
  `send_by` int DEFAULT NULL,
  `email_subject` varchar(255) NOT NULL,
  `email_body` text NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`bulk_id`),
  KEY `send_by` (`send_by`),
  CONSTRAINT `bulk_email_ibfk_1` FOREIGN KEY (`send_by`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulk_email`
--

LOCK TABLES `bulk_email` WRITE;
/*!40000 ALTER TABLE `bulk_email` DISABLE KEYS */;
INSERT INTO `bulk_email` VALUES (1,1,'[70% off] Early Black Friday access','Inj unsp musc/fasc/tend at thigh level, left thigh, init','2022-04-12 00:00:00'),(2,1,'How about 40% off this Black Friday?','Toxic effect of mycotoxin food contamnt, undetermined, subs	','2022-02-02 00:00:00'),(3,1,'Welcome! (Important info inside)','Strain extensor musc/fasc/tend r rng fngr at forarm lv, subs','2022-02-22 00:00:00');
/*!40000 ALTER TABLE `bulk_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(52) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Job'),(2,'General'),(3,'IT'),(4,'Personal'),(5,'Advanced'),(6,'Commerce'),(7,'Crypto'),(8,'Cloud'),(9,'Cyber Security'),(10,'Community');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(62) NOT NULL,
  `country_id` int DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`country_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Jakarta',1),(2,'Kuala Lumpur',2),(3,'Singapore',3),(4,'Manila',4),(5,'Naypyidaw',5),(6,'China',6),(7,'Canberra',7),(8,'New Delhi',8),(9,'Colombo',9),(10,'Bangkok',10);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(52) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `location` varchar(52) NOT NULL,
  `salary_range` double NOT NULL,
  `job_type` varchar(52) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Thoughtsphere','2022-02-13','2022-01-12','Anilao',4.69,'Full-time'),(2,'Agivu','2022-02-03','2022-05-18','Meaux',5.23,'Full-time'),(3,'Mynte','2021-11-24','2022-06-13','Gunungkencana',2.49,'Intern'),(4,'Avaveo','2022-02-11','2022-10-15','Bergen',4.73,'Full-time'),(5,'Devcast','2022-06-08','2022-01-30','Marmande',3.61,'Full-time'),(6,'Livefish','2022-06-10','2022-02-27','Araguari',0.99,'Intern'),(7,'Gabvine','2022-06-12','2022-06-15','Štitar',0.64,'Full-time'),(8,'Voonte','2022-07-23','2022-11-30','Bảo Lộc',5.7,'Part-time'),(9,'Divape','2022-03-16','2022-10-01','Ganggawang',7.56,'Intern'),(10,'Vidoo','2022-01-13','2022-07-16','Xamtay',2.11,'Intern');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversations`
--

DROP TABLE IF EXISTS `conversations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversations` (
  `conversation_id` int NOT NULL AUTO_INCREMENT,
  `created_by` int DEFAULT NULL,
  `public_key` varchar(255) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`conversation_id`),
  UNIQUE KEY `public_key` (`public_key`),
  KEY `created_by` (`created_by`),
  CONSTRAINT `conversations_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversations`
--

LOCK TABLES `conversations` WRITE;
/*!40000 ALTER TABLE `conversations` DISABLE KEYS */;
INSERT INTO `conversations` VALUES (1,NULL,'hhwwee','2022-12-27'),(2,1,'hhjjii','2022-12-27');
/*!40000 ALTER TABLE `conversations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `country_id` int NOT NULL AUTO_INCREMENT,
  `country_name` varchar(62) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Indonesia'),(2,'Malaysia'),(3,'Singapore'),(4,'philippine'),(5,'Myanmar'),(6,'China'),(7,'Australia'),(8,'India'),(9,'Sri Lanka'),(10,'Thailand');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educations`
--

DROP TABLE IF EXISTS `educations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educations` (
  `education_id` int NOT NULL AUTO_INCREMENT,
  `user_details_id` int NOT NULL,
  `intitution_name` varchar(52) NOT NULL,
  `education_name` varchar(52) NOT NULL DEFAULT 'Education',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`education_id`),
  KEY `user_details_id` (`user_details_id`),
  CONSTRAINT `educations_ibfk_1` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`user_details_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
INSERT INTO `educations` VALUES (1,1,'California State University, Northridge','Education','2010-11-17','2014-07-01');
/*!40000 ALTER TABLE `educations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiences`
--

DROP TABLE IF EXISTS `experiences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiences` (
  `experience_id` int NOT NULL AUTO_INCREMENT,
  `user_details_id` int NOT NULL,
  `company_name` varchar(52) NOT NULL,
  `position` varchar(52) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`experience_id`),
  KEY `user_details_id` (`user_details_id`),
  CONSTRAINT `experiences_ibfk_1` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`user_details_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiences`
--

LOCK TABLES `experiences` WRITE;
/*!40000 ALTER TABLE `experiences` DISABLE KEYS */;
/*!40000 ALTER TABLE `experiences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `company_id` int DEFAULT NULL,
  `user_details_id` int DEFAULT NULL,
  `user_interested` int NOT NULL,
  `user_apply` int NOT NULL,
  PRIMARY KEY (`job_id`),
  KEY `post_id` (`post_id`),
  KEY `user_details_id` (`user_details_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `jobs_ibfk_2` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`user_details_id`) ON DELETE SET NULL,
  CONSTRAINT `jobs_ibfk_3` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,4,5,1,0,0);
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `conversation_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `is_read` int NOT NULL,
  `message` text NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `conversation_id` (`conversation_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`conversation_id`) REFERENCES `conversations` (`conversation_id`) ON DELETE CASCADE,
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,1,NULL,1,'Hey r u there?','2022-12-27 00:00:00'),(2,1,1,1,'yes, y?','2022-12-27 00:00:00'),(3,1,NULL,1,'owh nvm','2022-12-27 00:00:00'),(4,2,1,1,'p','2022-12-27 00:00:00'),(5,2,NULL,1,'?','2022-12-27 00:00:00'),(6,2,1,1,':p','2022-12-27 00:00:00');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `created_by` int NOT NULL,
  `heading` varchar(52) NOT NULL,
  `body` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `created_by` (`created_by`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user_details` (`user_details_id`) ON DELETE CASCADE,
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,2,1,'Ooba','Conversion disorder','2022-07-25 00:00:00'),(2,2,1,'Realcube','Pathologic fracture of vertebrae','2022-04-24 00:00:00'),(4,2,1,'Eayo','Syndrome of \"infant of a diabetic mother\"','2021-10-21 00:00:00'),(10,2,1,'Zoomlounge','Myocarditis, unspecified','2022-09-12 00:00:00');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(52) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin'),(2,'User');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `threads`
--

DROP TABLE IF EXISTS `threads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `threads` (
  `thread_id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_details_id` int DEFAULT NULL,
  `reply_text` text NOT NULL,
  `reply_to_thread` int unsigned DEFAULT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`thread_id`),
  KEY `post_id` (`post_id`),
  KEY `user_details_id` (`user_details_id`),
  CONSTRAINT `threads_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE,
  CONSTRAINT `threads_ibfk_2` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`user_details_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threads`
--

LOCK TABLES `threads` WRITE;
/*!40000 ALTER TABLE `threads` DISABLE KEYS */;
INSERT INTO `threads` VALUES (3,2,NULL,'Asymptomatic human immunodeficiency virus [HIV] infection status',NULL,'2022-04-26 00:00:00'),(4,1,1,'Other persistent mental disorders due to conditions classified elsewhere',NULL,'2022-03-20 00:00:00'),(6,4,1,'Tuberculous oophoritis and salpingitis, tubercle bacilli not found (in sputum) by microscopy, but found by bacterial culture',6,'2022-05-26 00:00:00'),(10,2,1,'Chemical burn of eyelids and periocular area',5,'2021-11-04 00:00:00');
/*!40000 ALTER TABLE `threads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `user_details_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `city_id` int DEFAULT NULL,
  `first_name` varchar(52) NOT NULL,
  `last_name` varchar(52) NOT NULL,
  `title` varchar(52) DEFAULT NULL,
  `about` varchar(255) DEFAULT NULL,
  `company_name` varchar(52) DEFAULT NULL,
  `url` varchar(52) DEFAULT NULL,
  PRIMARY KEY (`user_details_id`),
  KEY `user_id` (`user_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `user_details_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `user_details_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,1,1,'Admin','Admin','Database Administrator I','Replacement of R Com Iliac Art with Synth Sub, Open Approach','Tagchat',NULL);
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT '2',
  `email` varchar(52) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email_verified_at` date DEFAULT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin@clouza.net','admin','2022-04-18','2022-04-18');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-22  8:00:40
