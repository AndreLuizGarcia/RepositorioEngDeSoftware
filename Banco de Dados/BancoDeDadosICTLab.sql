-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: ict
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeDepartamento` varchar(20) DEFAULT NULL,
  `descrição` varchar(500) DEFAULT NULL,
  `idResponsavel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`),
  KEY `idResponsavel` (`idResponsavel`),
  CONSTRAINT `departamento_ibfk_1` FOREIGN KEY (`idResponsavel`) REFERENCES `pesquisador` (`idPesquisador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (2,'a','a',2);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `idEquipamento` int(11) NOT NULL AUTO_INCREMENT,
  `nomeEquipamento` varchar(20) DEFAULT NULL,
  `descricao` varchar(20) DEFAULT NULL,
  `tombo` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idEquipamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamento`
--

LOCK TABLES `equipamento` WRITE;
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estalogado`
--

DROP TABLE IF EXISTS `estalogado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estalogado` (
  `idEstaLogado` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstaLogado`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estalogado`
--

LOCK TABLES `estalogado` WRITE;
/*!40000 ALTER TABLE `estalogado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estalogado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `dataEvento` varchar(10) DEFAULT NULL,
  `localEvento` varchar(50) DEFAULT NULL,
  `idResponsavel` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `idResponsavel` (`idResponsavel`),
  CONSTRAINT `eventos_ibfk_1` FOREIGN KEY (`idResponsavel`) REFERENCES `pesquisador` (`idPesquisador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (2,'a','1','a',2),(3,'aa','2','a',2);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginuser`
--

DROP TABLE IF EXISTS `loginuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginuser` (
  `idLogin` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginuser`
--

LOCK TABLES `loginuser` WRITE;
/*!40000 ALTER TABLE `loginuser` DISABLE KEYS */;
INSERT INTO `loginuser` VALUES (12,'a','a');
/*!40000 ALTER TABLE `loginuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesquisador`
--

DROP TABLE IF EXISTS `pesquisador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesquisador` (
  `idPesquisador` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `biografia` varchar(500) NOT NULL,
  `lattes` varchar(100) NOT NULL,
  `linkedin` varchar(100) NOT NULL,
  `idLogin` int(11) NOT NULL,
  PRIMARY KEY (`idPesquisador`),
  KEY `idLogin` (`idLogin`),
  CONSTRAINT `pesquisador_ibfk_1` FOREIGN KEY (`idLogin`) REFERENCES `loginuser` (`idLogin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesquisador`
--

LOCK TABLES `pesquisador` WRITE;
/*!40000 ALTER TABLE `pesquisador` DISABLE KEYS */;
INSERT INTO `pesquisador` VALUES (2,'a','a','a','a','a',12);
/*!40000 ALTER TABLE `pesquisador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesquisadorhasprojeto`
--

DROP TABLE IF EXISTS `pesquisadorhasprojeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesquisadorhasprojeto` (
  `idPesquisadorHasProjeto` int(11) NOT NULL AUTO_INCREMENT,
  `projeto` int(11) DEFAULT NULL,
  `pesquisador` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPesquisadorHasProjeto`),
  KEY `projeto` (`projeto`),
  KEY `pesquisador` (`pesquisador`),
  CONSTRAINT `pesquisadorhasprojeto_ibfk_1` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`idProjeto`),
  CONSTRAINT `pesquisadorhasprojeto_ibfk_2` FOREIGN KEY (`pesquisador`) REFERENCES `pesquisador` (`idPesquisador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesquisadorhasprojeto`
--

LOCK TABLES `pesquisadorhasprojeto` WRITE;
/*!40000 ALTER TABLE `pesquisadorhasprojeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pesquisadorhasprojeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projeto` (
  `idProjeto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  `statusDoProjeto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idProjeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ict'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-10 22:04:19
