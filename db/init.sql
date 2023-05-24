-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: inventoryzut
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
-- Table structure for table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `attribute_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `attribute_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute`
--

LOCK TABLES `attribute` WRITE;
/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` VALUES (1,'Powierzchnia [m²]',1),(2,'Data przydatności do spożycia',2),(3,'Długość [cm]',1),(4,'Szerokość [cm]',1),(5,'Wysokość',1),(6,'Czy żrące?',3),(7,'Czy można myć w zmywarce?',3),(8,'Tytuł',4),(9,'Autor',4),(10,'Kolor',5),(11,'Czy można prać w pralce?',3),(12,'Co ile podlewać',6),(13,'Nazwa',4);
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_in_tag`
--

DROP TABLE IF EXISTS `attribute_in_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute_in_tag` (
  `attribute_id` int NOT NULL,
  `tag_id` int NOT NULL,
  KEY `attribute_id` (`attribute_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `attribute_in_tag_ibfk_1` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`),
  CONSTRAINT `attribute_in_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_in_tag`
--

LOCK TABLES `attribute_in_tag` WRITE;
/*!40000 ALTER TABLE `attribute_in_tag` DISABLE KEYS */;
INSERT INTO `attribute_in_tag` VALUES (1,1),(2,3),(3,4),(4,4),(5,4),(6,6),(7,9),(8,10),(9,10),(10,11),(11,11),(12,12),(13,12);
/*!40000 ALTER TABLE `attribute_in_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_type`
--

DROP TABLE IF EXISTS `attribute_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_type`
--

LOCK TABLES `attribute_type` WRITE;
/*!40000 ALTER TABLE `attribute_type` DISABLE KEYS */;
INSERT INTO `attribute_type` VALUES (1,'double'),(2,'date'),(3,'bool'),(4,'string'),(5,'color'),(6,'int');
/*!40000 ALTER TABLE `attribute_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribute_value`
--

DROP TABLE IF EXISTS `attribute_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attribute_value` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(64) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `inventory_entry_id` int NOT NULL,
  `attribute_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inventory_entry_id` (`inventory_entry_id`),
  KEY `attribute_id` (`attribute_id`),
  CONSTRAINT `attribute_value_ibfk_2` FOREIGN KEY (`inventory_entry_id`) REFERENCES `inventory_entry` (`id`),
  CONSTRAINT `attribute_value_ibfk_3` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribute_value`
--

LOCK TABLES `attribute_value` WRITE;
/*!40000 ALTER TABLE `attribute_value` DISABLE KEYS */;
INSERT INTO `attribute_value` VALUES (1,'60',1,1),(2,'20',2,1),(3,'10',3,1),(4,'15',4,1),(5,'15',5,1),(6,'2022-12-23',7,2),(7,'2023-01-15',8,2),(8,'2022-12-04',9,2),(9,'100',10,3),(10,'60',10,4),(11,'74',10,5),(12,'82',13,3),(13,'49',13,4),(14,'72',13,5),(15,'1',14,6),(16,'0',15,6),(17,'206',18,3),(18,'144',18,4),(19,'40',18,5),(20,'40',19,3),(21,'48',19,4),(22,'55',19,5),(23,'127.5',22,3),(24,'67.5',22,4),(25,'88.0',22,5),(26,'1',24,7),(27,'1',25,7),(28,'1',26,7),(29,'1',27,7),(30,'0',28,6),(31,'Księgi Jakubowe',29,8),(32,'Olga Tokarczuk',29,9),(33,'Kasacja',30,8),(34,'Remigiusz Mróz',30,9),(35,'Zaginięcie',31,8),(36,'Remigiusz Mróz',31,9),(37,'117',32,3),(38,'55',32,4),(39,'176',32,5),(40,'#000000',33,10),(41,'1',33,11),(42,'#00e600',34,10),(43,'1',34,11),(44,'#e60000',35,10),(45,'0',35,11),(46,'#0033cc',36,10),(47,'1',36,11),(48,'#ffffff',37,10),(49,'0',37,11),(50,'#000000',38,10),(51,'0',38,11),(52,'#000000',39,10),(53,'1',39,11),(54,'#ffffff',40,10),(55,'1',40,11),(56,'14',41,12),(57,'Monstera',41,13),(58,'10',42,12),(59,'Dracena',42,13),(60,'20',43,12),(61,'Paprotka',43,13),(62,'10',44,12),(63,'Epipremnum',44,13),(64,'199',45,3),(65,'134',45,4),(66,'76.5',45,5),(67,'82',46,3),(68,'96',46,4),(69,'101',46,5),(70,'2023-02-01',49,2),(71,'2022-12-30',50,2);
/*!40000 ALTER TABLE `attribute_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_entry`
--

DROP TABLE IF EXISTS `inventory_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory_entry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int NOT NULL,
  `parent_id` int DEFAULT NULL,
  `added_at` datetime NOT NULL,
  `quantity` float DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `inventory_entry_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `inventory_entry_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `inventory_entry` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_entry`
--

LOCK TABLES `inventory_entry` WRITE;
/*!40000 ALTER TABLE `inventory_entry` DISABLE KEYS */;
INSERT INTO `inventory_entry` VALUES (1,1,NULL,'2022-12-13 21:25:05',1,1),(2,2,1,'2022-12-13 21:25:05',1,1),(3,3,1,'2022-12-13 21:25:05',1,1),(4,4,1,'2022-12-13 21:25:05',1,1),(5,5,1,'2022-12-13 21:25:05',1,1),(6,6,4,'2022-12-13 21:25:05',1,1),(7,7,6,'2022-12-13 21:25:05',0.75,1),(8,8,6,'2022-12-13 21:25:05',1,1),(9,9,6,'2022-12-13 21:25:05',0.5,1),(10,10,3,'2022-12-13 21:25:05',1,1),(11,11,2,'2022-12-13 21:25:05',1,1),(12,12,5,'2022-12-13 21:25:05',1,1),(13,13,5,'2022-12-13 21:25:05',1,1),(14,14,13,'2022-12-13 21:25:05',1,1),(15,15,13,'2022-12-13 21:25:05',0.5,1),(16,16,13,'2022-12-13 21:25:05',1,1),(17,17,4,'2022-12-13 21:25:05',0.24,1),(18,18,3,'2022-12-13 21:25:05',1,1),(19,19,3,'2022-12-13 21:25:05',1,1),(20,20,19,'2022-12-13 21:25:05',1,1),(21,21,2,'2022-12-13 21:25:05',1,1),(22,13,4,'2022-12-13 21:25:05',1,1),(23,22,22,'2022-12-13 21:25:05',1,1),(24,23,22,'2022-12-13 21:25:05',12,1),(25,24,22,'2022-12-13 21:25:05',11,1),(26,25,22,'2022-12-13 21:25:05',12,1),(27,26,22,'2022-12-13 21:25:05',6,1),(28,27,4,'2022-12-13 21:25:05',0.98,1),(29,28,19,'2022-12-13 21:25:05',1,1),(30,28,19,'2022-12-13 21:25:05',1,1),(31,28,19,'2022-12-13 21:25:05',1,1),(32,29,3,'2022-12-13 21:25:05',1,1),(33,30,32,'2022-12-13 21:25:05',1,1),(34,30,32,'2022-12-13 21:25:05',1,1),(35,30,32,'2022-12-13 21:25:05',1,1),(36,31,32,'2022-12-13 21:25:05',1,1),(37,31,32,'2022-12-13 21:25:05',1,1),(38,32,32,'2022-12-13 21:25:05',1,1),(39,33,32,'2022-12-13 21:25:05',1,1),(40,33,32,'2022-12-13 21:25:05',1,1),(41,34,2,'2022-12-13 21:25:05',1,1),(42,34,2,'2022-12-13 21:25:05',1,1),(43,34,4,'2022-12-13 21:25:05',1,1),(44,34,3,'2022-12-13 21:25:05',1,1),(45,35,2,'2022-12-13 21:25:05',1,1),(46,36,2,'2022-12-13 21:25:05',2,1),(47,37,4,'2022-12-13 21:25:05',1,1),(48,38,4,'2022-12-13 21:25:05',1,1),(49,39,6,'2022-12-13 21:25:05',2,1),(50,40,6,'2022-12-13 21:25:05',12,1);
/*!40000 ALTER TABLE `inventory_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_polish_ci NOT NULL,
  `fillable` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `description` text COLLATE utf8mb4_polish_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Mieszkanie',1,'2022-12-13 21:25:05',''),(2,'Salon',1,'2022-12-13 21:25:05',''),(3,'Sypialnia',1,'2022-12-13 21:25:05',''),(4,'Kuchnia',1,'2022-12-13 21:25:05',''),(5,'Łazienka',1,'2022-12-13 21:25:05',''),(6,'Lodówka',1,'2022-12-13 21:25:05',''),(7,'Masło',0,'2022-12-13 21:25:05','Mleczna dolina, 200g'),(8,'Ser Gouda',0,'2022-12-13 21:25:05','Mleczna dolina, 300g'),(9,'Sok Pomarańczowy',0,'2022-12-13 21:25:05','Tymbark, 1l'),(10,'Stół',0,'2022-12-13 21:25:05',''),(11,'Telewizor',0,'2022-12-13 21:25:05','Samsung 50 cali'),(12,'Pralka',0,'2022-12-13 21:25:05',''),(13,'Szafka',1,'2022-12-13 21:25:05',''),(14,'Płyn do WC',0,'2022-12-13 21:25:05','Domestos, 750ml'),(15,'Płyn do szyb',0,'2022-12-13 21:25:05','Clin, 500ml'),(16,'Mydło do rąk w płynie',0,'2022-12-13 21:25:05','Luksja, 200ml'),(17,'Żel pod prysznic',0,'2022-12-13 21:25:05','Yope, 400ml'),(18,'Łóżko',0,'2022-12-13 21:25:05',''),(19,'Szafka nocna',1,'2022-12-13 21:25:05',''),(20,'Lampka nocna',0,'2022-12-13 21:25:05',''),(21,'Lampa podłogowa',0,'2022-12-13 21:25:05',''),(22,'Czajnik elektryczny',0,'2022-12-13 21:25:05',''),(23,'Łyżka stołowa',0,'2022-12-13 21:25:05',''),(24,'Widelec',0,'2022-12-13 21:25:05',''),(25,'Nóż',0,'2022-12-13 21:25:05',''),(26,'Łyżeczka',0,'2022-12-13 21:25:05',''),(27,'Płyn do naczyń',0,'2022-12-13 21:25:05','Fairy, 500ml'),(28,'Książka',0,'2022-12-13 21:25:05',''),(29,'Szafa na ubrania',1,'2022-12-13 21:25:05',''),(30,'Koszula',0,'2022-12-13 21:25:05',''),(31,'Koszulka',0,'2022-12-13 21:25:05',''),(32,'Spodnie',0,'2022-12-13 21:25:05',''),(33,'Bluza z kapturem',0,'2022-12-13 21:25:05',''),(34,'Roślina doniczkowa',0,'2022-12-13 21:25:05',''),(35,'Sofa',0,'2022-12-13 21:25:05',''),(36,'Fotel',0,'2022-12-13 21:25:05',''),(37,'Piekarnik',0,'2022-12-13 21:25:05',''),(38,'Mikrofala',0,'2022-12-13 21:25:05','Samsung'),(39,'Mleko',0,'2022-12-13 21:25:05','Łaciate, 1l'),(40,'Jajko',0,'2022-12-13 21:25:05','');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Pomieszczenie'),(2,'AGD'),(3,'Żywność'),(4,'Mebel'),(5,'RTV'),(6,'Środek czystości'),(7,'Mycie i kąpiel'),(8,'Oświetlenie'),(9,'Sztuciec'),(10,'Książka'),(11,'Ubranie'),(12,'Roślina');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_in_item`
--

DROP TABLE IF EXISTS `tag_in_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_in_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tag_id` int NOT NULL,
  `item_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tag_id` (`tag_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `tag_in_item_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`),
  CONSTRAINT `tag_in_item_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_in_item`
--

LOCK TABLES `tag_in_item` WRITE;
/*!40000 ALTER TABLE `tag_in_item` DISABLE KEYS */;
INSERT INTO `tag_in_item` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,2,6),(7,3,7),(8,3,8),(9,3,9),(10,4,10),(11,5,11),(12,2,12),(13,4,13),(14,6,14),(15,6,15),(16,7,16),(17,7,17),(18,4,18),(19,4,19),(20,8,20),(21,8,21),(22,2,22),(23,9,23),(24,9,24),(25,9,25),(26,9,26),(27,6,27),(28,10,28),(29,4,29),(30,11,30),(31,11,31),(32,11,32),(33,11,33),(34,12,34),(35,4,35),(36,4,36),(37,2,37),(38,2,38),(39,3,39),(40,3,40);
/*!40000 ALTER TABLE `tag_in_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `password` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `email` varchar(320) COLLATE utf8mb4_polish_ci NOT NULL,
  `verified` tinyint(1) NOT NULL DEFAULT '0',
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'jan','123','jan@jan.pl',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_in_workspace`
--

DROP TABLE IF EXISTS `user_in_workspace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_in_workspace` (
  `user_id` int NOT NULL,
  `workspace_id` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `workspace_id` (`workspace_id`),
  CONSTRAINT `user_in_workspace_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_in_workspace_ibfk_2` FOREIGN KEY (`workspace_id`) REFERENCES `workspace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_in_workspace`
--

LOCK TABLES `user_in_workspace` WRITE;
/*!40000 ALTER TABLE `user_in_workspace` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_in_workspace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_in_workspace_authority`
--

DROP TABLE IF EXISTS `user_in_workspace_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_in_workspace_authority` (
  `user_in_workspace_id` int NOT NULL,
  `authority_id` int NOT NULL,
  KEY `user_in_workspace_id` (`user_in_workspace_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `user_in_workspace_authority_ibfk_1` FOREIGN KEY (`user_in_workspace_id`) REFERENCES `user_in_workspace` (`id`),
  CONSTRAINT `user_in_workspace_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `workspace_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_in_workspace_authority`
--

LOCK TABLES `user_in_workspace_authority` WRITE;
/*!40000 ALTER TABLE `user_in_workspace_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_in_workspace_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `user_id` int NOT NULL,
  `created_at` datetime NOT NULL,
  `expires_at` datetime NOT NULL,
  `confirmed_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `verification_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workspace`
--

DROP TABLE IF EXISTS `workspace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workspace` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  `photo` varchar(256) COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `inventory_entry_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inventory_entry_id` (`inventory_entry_id`),
  CONSTRAINT `workspace_ibfk_1` FOREIGN KEY (`inventory_entry_id`) REFERENCES `inventory_entry` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workspace`
--

LOCK TABLES `workspace` WRITE;
/*!40000 ALTER TABLE `workspace` DISABLE KEYS */;
/*!40000 ALTER TABLE `workspace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workspace_authority`
--

DROP TABLE IF EXISTS `workspace_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workspace_authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8mb4_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workspace_authority`
--

LOCK TABLES `workspace_authority` WRITE;
/*!40000 ALTER TABLE `workspace_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `workspace_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 16:56:16