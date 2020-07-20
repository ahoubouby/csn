-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           8.0.18 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour dashboard_csn_db
CREATE DATABASE IF NOT EXISTS `dashboard_csn_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dashboard_csn_db`;

-- Listage de la structure de la table dashboard_csn_db. dc
CREATE TABLE IF NOT EXISTS `dc` (
  `Id` text,
  `Description` text,
  `ParentId` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Listage des données de la table dashboard_csn_db.dc : 33 rows
/*!40000 ALTER TABLE `dc` DISABLE KEYS */;
INSERT INTO `dc` (`Id`, `Description`, `ParentId`) VALUES
	('1562', 'DC AL HOUCEIMA', '1557'),
	('1561', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1550'),
	('2487', 'DC AIN CHOCK EL FIDA', '1550'),
	('2479', 'DC BEN MSIK SIDI OTHMANE', '1550'),
	('2481', 'DC BENIMELLAL-AZILAL-KHOURIBGA', '1551'),
	('2482', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '1554'),
	('2488', 'DC EL JADIDA', '1551'),
	('2477', 'DC ANFA', '1550'),
	('2496', 'DC EL KELAA-AL HAOUZ', '1552'),
	('2518', 'DC OUJDA', '1554'),
	('2507', 'DC TAROUDANT-TATA-CHTOUKA', '1556'),
	('2500', 'DC ERRACHIDIA', '1553'),
	('2519', 'DC OUARZAZATE-ZAGORA', '1552'),
	('2520', 'DC NADOR', '1554'),
	('2523', 'DC MEKNES IFRAN-HAJEB-MISSOUR', '1553'),
	('2501', 'DC FES', '1553'),
	('2508', 'DC TANGER', '1557'),
	('2503', 'DC TETOUAN-CHEFCHAOUEN', '1557'),
	('2504', 'DC TEMARA', '1555'),
	('2505', 'DC TAZA', '1553'),
	('2510', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '1552'),
	('2513', 'DC SETTAT', '1551'),
	('2514', 'DC SALE', '1555'),
	('2516', 'DC RABAT', '1555'),
	('2490', 'DC MARRAKECH', '1552'),
	('2491', 'DC LARACHE', '1557'),
	('2492', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '1556'),
	('2493', 'DC KHENIFRA', '1553'),
	('2494', 'DC KHEMISSET', '1555'),
	('2495', 'DC KENITRA - SIDI KACEM', '1555'),
	('2486', 'DC AGADIR', '1556'),
	('2498', 'DC GUELMIM-ASSA ZAG-TAN TAN', '1556'),
	('1560', 'DC HAY HASSANI BOUSKOURA', '1550');
/*!40000 ALTER TABLE `dc` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. dr
CREATE TABLE IF NOT EXISTS `dr` (
  `Id` text,
  `Description` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Listage des données de la table dashboard_csn_db.dr : 8 rows
/*!40000 ALTER TABLE `dr` DISABLE KEYS */;
INSERT INTO `dr` (`Id`, `Description`) VALUES
	('1550', 'DRC'),
	('1556', 'DRA'),
	('1551', 'DRS'),
	('1552', 'DRM'),
	('1553', 'DRF'),
	('1554', 'DRO'),
	('1557', 'DRT'),
	('1555', 'DRR');
/*!40000 ALTER TABLE `dr` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. fournisseur
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `Id` text,
  `Description` text,
  `TypeEquipement` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Listage des données de la table dashboard_csn_db.fournisseur : 7 rows
/*!40000 ALTER TABLE `fournisseur` DISABLE KEYS */;
INSERT INTO `fournisseur` (`Id`, `Description`, `TypeEquipement`) VALUES
	('1522', 'ALCATEL', 'MSAN'),
	('1528', 'HUAWEI', 'MSAN'),
	('1528', 'HUAWEI', NULL),
	('1525', 'ERICSSON', NULL),
	('1535', 'NSN', 'MSAN'),
	('1525', 'NSN', NULL),
	('1542', 'ZTE', 'MSAN');
/*!40000 ALTER TABLE `fournisseur` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. parametrage
CREATE TABLE IF NOT EXISTS `parametrage` (
  `requete` text CHARACTER SET utf8 COLLATE utf8_bin,
  `frequence` text CHARACTER SET utf8 COLLATE utf8_bin,
  `execution` datetime DEFAULT NULL,
  `next_execution` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- Listage des données de la table dashboard_csn_db.parametrage : 16 rows
/*!40000 ALTER TABLE `parametrage` DISABLE KEYS */;
INSERT INTO `parametrage` (`requete`, `frequence`, `execution`, `next_execution`) VALUES
	('req1', '1', '2020-07-01 15:41:20', '2020-07-01 16:00:00'),
	('req2', '24', NULL, NULL),
	('req3', '24', '2020-07-01 12:42:18', '2020-07-02 00:00:00'),
	('req4', '24', NULL, NULL),
	('req5', '24', NULL, NULL),
	('req6', '24', NULL, NULL),
	('reqEquip', '24', '2020-07-01 12:39:50', '2020-07-02 00:00:00'),
	('reqEquip2g', '24', '2020-07-01 12:39:50', '2020-07-02 00:00:00'),
	('reqEquip3g', '24', '2020-07-01 12:39:50', '2020-07-02 00:00:00'),
	('reqEquip4g', '24', '2020-07-01 12:39:50', '2020-07-02 00:00:00'),
	('reqmsan', '24', '2020-07-01 12:39:51', '2020-07-02 00:00:00'),
	('dr', '24', '2020-07-01 12:39:51', '2020-07-02 00:00:00'),
	('dc', '24', '2020-07-01 12:39:52', '2020-07-02 00:00:00'),
	('fournisseur', '24', '2020-07-01 12:39:52', '2020-07-02 00:00:00'),
	('req_stat_mbts', '24', '2020-07-01 12:39:52', '2020-07-02 00:00:00'),
	('req_stat_msan', '24', '2020-07-01 12:39:52', '2020-07-02 00:00:00');
/*!40000 ALTER TABLE `parametrage` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req1
CREATE TABLE IF NOT EXISTS `req1` (
  `etat` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req1 : 2 rows
/*!40000 ALTER TABLE `req1` DISABLE KEYS */;
INSERT INTO `req1` (`etat`, `nombre`) VALUES
	('Fermé', '165'),
	('Ouvert', '85');
/*!40000 ALTER TABLE `req1` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req2
CREATE TABLE IF NOT EXISTS `req2` (
  `jour` datetime DEFAULT NULL,
  `etat` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req2 : 4 rows
/*!40000 ALTER TABLE `req2` DISABLE KEYS */;
INSERT INTO `req2` (`jour`, `etat`, `nombre`) VALUES
	('2020-06-24 00:00:00', 'ferme', '194'),
	('2020-06-24 00:00:00', 'ouvert', '209'),
	('2020-06-23 00:00:00', 'ferme', '194'),
	('2020-06-23 00:00:00', 'ouvert', '209');
/*!40000 ALTER TABLE `req2` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req3
CREATE TABLE IF NOT EXISTS `req3` (
  `jour` datetime DEFAULT NULL,
  `division` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req3 : 131 rows
/*!40000 ALTER TABLE `req3` DISABLE KEYS */;
INSERT INTO `req3` (`jour`, `division`, `nombre`) VALUES
	('2020-06-14 00:00:00', 'DIRECTION EXPLOITATION', '2'),
	('2020-06-14 00:00:00', 'DRA', '3'),
	('2020-06-14 00:00:00', 'DRC', '3'),
	('2020-06-14 00:00:00', 'DRF', '9'),
	('2020-06-14 00:00:00', 'DRM', '3'),
	('2020-06-14 00:00:00', 'DRR', '2'),
	('2020-06-14 00:00:00', 'DRS', '1'),
	('2020-06-15 00:00:00', 'DIRECTION EXPLOITATION', '3'),
	('2020-06-15 00:00:00', 'DRC', '1'),
	('2020-06-15 00:00:00', 'DRF', '2'),
	('2020-06-15 00:00:00', 'DRM', '7'),
	('2020-06-15 00:00:00', 'DRR', '3'),
	('2020-06-16 00:00:00', 'DIRECTION EXPLOITATION', '10'),
	('2020-06-16 00:00:00', 'DRA', '2'),
	('2020-06-16 00:00:00', 'DRC', '6'),
	('2020-06-16 00:00:00', 'DRF', '3'),
	('2020-06-16 00:00:00', 'DRM', '6'),
	('2020-06-16 00:00:00', 'DRR', '3'),
	('2020-06-16 00:00:00', 'DRS', '1'),
	('2020-06-17 00:00:00', 'DRA', '7'),
	('2020-06-17 00:00:00', 'DRC', '2'),
	('2020-06-17 00:00:00', 'DRF', '2'),
	('2020-06-17 00:00:00', 'DRM', '2'),
	('2020-06-17 00:00:00', 'DRO', '5'),
	('2020-06-17 00:00:00', 'DRR', '3'),
	('2020-06-17 00:00:00', 'DRS', '1'),
	('2020-06-17 00:00:00', 'DRT', '1'),
	('2020-06-18 00:00:00', 'DIRECTION EXPLOITATION', '6'),
	('2020-06-18 00:00:00', 'DRA', '13'),
	('2020-06-18 00:00:00', 'DRC', '2'),
	('2020-06-18 00:00:00', 'DRF', '4'),
	('2020-06-18 00:00:00', 'DRM', '4'),
	('2020-06-18 00:00:00', 'DRO', '1'),
	('2020-06-18 00:00:00', 'DRR', '5'),
	('2020-06-18 00:00:00', 'DRT', '3'),
	('2020-06-19 00:00:00', 'DIRECTION EXPLOITATION', '3'),
	('2020-06-19 00:00:00', 'DRA', '5'),
	('2020-06-19 00:00:00', 'DRF', '8'),
	('2020-06-19 00:00:00', 'DRM', '17'),
	('2020-06-19 00:00:00', 'DRO', '1'),
	('2020-06-19 00:00:00', 'DRR', '5'),
	('2020-06-19 00:00:00', 'DRS', '6'),
	('2020-06-19 00:00:00', 'DRT', '5'),
	('2020-06-20 00:00:00', 'DRT', '8'),
	('2020-06-20 00:00:00', 'DRS', '20'),
	('2020-06-20 00:00:00', 'DRR', '31'),
	('2020-06-20 00:00:00', 'DRO', '3'),
	('2020-06-20 00:00:00', 'DRM', '23'),
	('2020-06-20 00:00:00', 'DRF', '17'),
	('2020-06-20 00:00:00', 'DRC', '38'),
	('2020-06-20 00:00:00', 'DRA', '48'),
	('2020-06-20 00:00:00', 'DIRECTION EXPLOITATION', '5'),
	('2020-06-21 00:00:00', 'DRT', '8'),
	('2020-06-21 00:00:00', 'DRS', '20'),
	('2020-06-21 00:00:00', 'DRR', '31'),
	('2020-06-21 00:00:00', 'DRO', '3'),
	('2020-06-21 00:00:00', 'DRM', '23'),
	('2020-06-21 00:00:00', 'DRF', '17'),
	('2020-06-21 00:00:00', 'DRC', '38'),
	('2020-06-21 00:00:00', 'DRA', '48'),
	('2020-06-21 00:00:00', 'DIRECTION EXPLOITATION', '5'),
	('2020-06-22 00:00:00', 'DRA', '48'),
	('2020-06-22 00:00:00', 'DIRECTION EXPLOITATION', '5'),
	('2020-06-22 00:00:00', 'DRC', '38'),
	('2020-06-22 00:00:00', 'DRF', '17'),
	('2020-06-22 00:00:00', 'DRM', '23'),
	('2020-06-22 00:00:00', 'DRO', '3'),
	('2020-06-22 00:00:00', 'DRR', '31'),
	('2020-06-22 00:00:00', 'DRS', '20'),
	('2020-06-22 00:00:00', 'DRT', '8'),
	('2020-06-23 00:00:00', 'DIRECTION EXPLOITATION', '5'),
	('2020-06-23 00:00:00', 'DRA', '48'),
	('2020-06-23 00:00:00', 'DRC', '38'),
	('2020-06-23 00:00:00', 'DRF', '17'),
	('2020-06-23 00:00:00', 'DRM', '23'),
	('2020-06-23 00:00:00', 'DRO', '3'),
	('2020-06-23 00:00:00', 'DRR', '31'),
	('2020-06-23 00:00:00', 'DRS', '20'),
	('2020-06-23 00:00:00', 'DRT', '8'),
	('2020-06-24 00:00:00', 'DIRECTION EXPLOITATION', '2'),
	('2020-06-24 00:00:00', 'DRA', '3'),
	('2020-06-24 00:00:00', 'DRC', '3'),
	('2020-06-24 00:00:00', 'DRF', '9'),
	('2020-06-24 00:00:00', 'DRM', '3'),
	('2020-06-24 00:00:00', 'DRR', '2'),
	('2020-06-24 00:00:00', 'DRS', '1'),
	('2020-06-25 00:00:00', 'DIRECTION EXPLOITATION', '3'),
	('2020-06-25 00:00:00', 'DRC', '1'),
	('2020-06-25 00:00:00', 'DRF', '2'),
	('2020-06-25 00:00:00', 'DRM', '7'),
	('2020-06-25 00:00:00', 'DRR', '3'),
	('2020-06-26 00:00:00', 'DIRECTION EXPLOITATION', '10'),
	('2020-06-26 00:00:00', 'DRA', '2'),
	('2020-06-26 00:00:00', 'DRC', '6'),
	('2020-06-26 00:00:00', 'DRF', '3'),
	('2020-06-26 00:00:00', 'DRM', '6'),
	('2020-06-26 00:00:00', 'DRR', '3'),
	('2020-06-26 00:00:00', 'DRS', '1'),
	('2020-06-27 00:00:00', 'DRA', '7'),
	('2020-06-27 00:00:00', 'DRC', '2'),
	('2020-06-27 00:00:00', 'DRF', '2'),
	('2020-06-27 00:00:00', 'DRM', '2'),
	('2020-06-27 00:00:00', 'DRO', '5'),
	('2020-06-27 00:00:00', 'DRR', '3'),
	('2020-06-27 00:00:00', 'DRS', '1'),
	('2020-06-27 00:00:00', 'DRT', '1'),
	('2020-06-28 00:00:00', 'DIRECTION EXPLOITATION', '6'),
	('2020-06-28 00:00:00', 'DRA', '13'),
	('2020-06-28 00:00:00', 'DRC', '2'),
	('2020-06-28 00:00:00', 'DRF', '4'),
	('2020-06-28 00:00:00', 'DRM', '4'),
	('2020-06-28 00:00:00', 'DRO', '1'),
	('2020-06-28 00:00:00', 'DRR', '5'),
	('2020-06-28 00:00:00', 'DRT', '3'),
	('2020-06-29 00:00:00', 'DIRECTION EXPLOITATION', '3'),
	('2020-06-29 00:00:00', 'DRA', '5'),
	('2020-06-29 00:00:00', 'DRF', '8'),
	('2020-06-29 00:00:00', 'DRM', '17'),
	('2020-06-29 00:00:00', 'DRO', '1'),
	('2020-06-29 00:00:00', 'DRR', '5'),
	('2020-06-29 00:00:00', 'DRS', '6'),
	('2020-06-29 00:00:00', 'DRT', '5'),
	('2020-06-30 00:00:00', 'DIRECTION EXPLOITATION', '5'),
	('2020-06-30 00:00:00', 'DRA', '48'),
	('2020-06-30 00:00:00', 'DRC', '38'),
	('2020-06-30 00:00:00', 'DRF', '17'),
	('2020-06-30 00:00:00', 'DRM', '23'),
	('2020-06-30 00:00:00', 'DRO', '3'),
	('2020-06-30 00:00:00', 'DRR', '31'),
	('2020-06-30 00:00:00', 'DRS', '20'),
	('2020-06-30 00:00:00', 'DRT', '8');
/*!40000 ALTER TABLE `req3` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req4
CREATE TABLE IF NOT EXISTS `req4` (
  `jour` datetime DEFAULT NULL,
  `division` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req4 : 62 rows
/*!40000 ALTER TABLE `req4` DISABLE KEYS */;
INSERT INTO `req4` (`jour`, `division`, `nombre`) VALUES
	('2020-06-22 00:00:00', 'DRA', '75'),
	('2020-06-22 00:00:00', 'DRC', '11'),
	('2020-06-22 00:00:00', 'DRF', '53'),
	('2020-06-22 00:00:00', 'DRM', '87'),
	('2020-06-22 00:00:00', 'DRO', '13'),
	('2020-06-22 00:00:00', 'DRR', '28'),
	('2020-06-22 00:00:00', 'DRS', '27'),
	('2020-06-22 00:00:00', 'DRT', '28'),
	('2020-06-23 00:00:00', 'DIRECTION EXPLOITATION', '8'),
	('2020-06-23 00:00:00', 'DRA', '73'),
	('2020-06-23 00:00:00', 'DRC', '14'),
	('2020-06-23 00:00:00', 'DRF', '82'),
	('2020-06-23 00:00:00', 'DRM', '50'),
	('2020-06-23 00:00:00', 'DRO', '9'),
	('2020-06-23 00:00:00', 'DRR', '14'),
	('2020-06-23 00:00:00', 'DRS', '12'),
	('2020-06-23 00:00:00', 'DRT', '27'),
	('2020-06-24 00:00:00', 'DIRECTION EXPLOITATION', '10'),
	('2020-06-24 00:00:00', 'DRA', '71'),
	('2020-06-24 00:00:00', 'DRC', '41'),
	('2020-06-24 00:00:00', 'DRF', '47'),
	('2020-06-24 00:00:00', 'DRM', '123'),
	('2020-06-24 00:00:00', 'DRO', '17'),
	('2020-06-24 00:00:00', 'DRR', '25'),
	('2020-06-24 00:00:00', 'DRS', '26'),
	('2020-06-24 00:00:00', 'DRT', '39'),
	('2020-06-25 00:00:00', 'DIRECTION EXPLOITATION', '10'),
	('2020-06-25 00:00:00', 'DRA', '86'),
	('2020-06-25 00:00:00', 'DRC', '28'),
	('2020-06-25 00:00:00', 'DRF', '47'),
	('2020-06-25 00:00:00', 'DRM', '115'),
	('2020-06-25 00:00:00', 'DRO', '1'),
	('2020-06-25 00:00:00', 'DRR', '58'),
	('2020-06-25 00:00:00', 'DRS', '64'),
	('2020-06-25 00:00:00', 'DRT', '41'),
	('2020-06-26 00:00:00', 'DIRECTION EXPLOITATION', '6'),
	('2020-06-26 00:00:00', 'DRA', '97'),
	('2020-06-26 00:00:00', 'DRC', '39'),
	('2020-06-26 00:00:00', 'DRF', '38'),
	('2020-06-26 00:00:00', 'DRM', '102'),
	('2020-06-26 00:00:00', 'DRO', '12'),
	('2020-06-26 00:00:00', 'DRR', '60'),
	('2020-06-26 00:00:00', 'DRS', '30'),
	('2020-06-26 00:00:00', 'DRT', '18'),
	('2020-06-27 00:00:00', 'DIRECTION EXPLOITATION', '2'),
	('2020-06-27 00:00:00', 'DRA', '88'),
	('2020-06-27 00:00:00', 'DRC', '20'),
	('2020-06-27 00:00:00', 'DRF', '39'),
	('2020-06-27 00:00:00', 'DRM', '103'),
	('2020-06-27 00:00:00', 'DRO', '17'),
	('2020-06-27 00:00:00', 'DRR', '49'),
	('2020-06-27 00:00:00', 'DRS', '21'),
	('2020-06-27 00:00:00', 'DRT', '30'),
	('2020-06-28 00:00:00', 'DRT', '11'),
	('2020-06-28 00:00:00', 'DRS', '19'),
	('2020-06-28 00:00:00', 'DRR', '15'),
	('2020-06-28 00:00:00', 'DRO', '8'),
	('2020-06-28 00:00:00', 'DRM', '50'),
	('2020-06-28 00:00:00', 'DRF', '7'),
	('2020-06-28 00:00:00', 'DRC', '14'),
	('2020-06-28 00:00:00', 'DRA', '94'),
	('2020-06-28 00:00:00', 'DIRECTION EXPLOITATION', '4');
/*!40000 ALTER TABLE `req4` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req5
CREATE TABLE IF NOT EXISTS `req5` (
  `jour` datetime DEFAULT NULL,
  `equipe` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Commentaire` text COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req5 : 26 rows
/*!40000 ALTER TABLE `req5` DISABLE KEYS */;
INSERT INTO `req5` (`jour`, `equipe`, `nombre`, `Commentaire`) VALUES
	('2020-06-22 00:00:00', 'Commutation', '7', 'test commentaire 1'),
	('2020-06-22 00:00:00', 'Radio', '16', NULL),
	('2020-06-23 00:00:00', 'Commutation', '5', NULL),
	('2020-06-23 00:00:00', 'PFS', '1', NULL),
	('2020-06-23 00:00:00', 'Radio', '8', NULL),
	('2020-06-23 00:00:00', 'Transmission', '2', NULL),
	('2020-06-24 00:00:00', 'Commutation', '7', NULL),
	('2020-06-24 00:00:00', 'PFS', '10', NULL),
	('2020-06-24 00:00:00', 'Radio', '12', NULL),
	('2020-06-24 00:00:00', 'Transmission', '2', NULL),
	('2020-06-25 00:00:00', 'Commutation', '1', NULL),
	('2020-06-25 00:00:00', 'PFS', '2', NULL),
	('2020-06-25 00:00:00', 'Radio', '16', NULL),
	('2020-06-25 00:00:00', 'Transmission', '4', NULL),
	('2020-06-26 00:00:00', 'Commutation', '11', NULL),
	('2020-06-26 00:00:00', 'PFS', '1', NULL),
	('2020-06-26 00:00:00', 'Radio', '22', NULL),
	('2020-06-26 00:00:00', 'Transmission', '4', NULL),
	('2020-06-27 00:00:00', 'Commutation', '7', NULL),
	('2020-06-27 00:00:00', 'PFS', '3', 'c\'est super !'),
	('2020-06-27 00:00:00', 'Radio', '37', NULL),
	('2020-06-27 00:00:00', 'Transmission', '3', NULL),
	('2020-06-28 00:00:00', 'Radio', '133', NULL),
	('2020-06-28 00:00:00', 'PFS', '12', 'Ok c\'est bon !'),
	('2020-06-28 00:00:00', 'Transmission', '29', 'test 2 commentaire'),
	('2020-06-28 00:00:00', 'Commutation', '24', NULL);
/*!40000 ALTER TABLE `req5` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req6
CREATE TABLE IF NOT EXISTS `req6` (
  `jour` datetime DEFAULT NULL,
  `equipe` text CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req6 : 28 rows
/*!40000 ALTER TABLE `req6` DISABLE KEYS */;
INSERT INTO `req6` (`jour`, `equipe`, `nombre`) VALUES
	('2020-06-22 00:00:00', 'Commutation', '42'),
	('2020-06-22 00:00:00', 'PFS', '2'),
	('2020-06-22 00:00:00', 'Radio', '258'),
	('2020-06-22 00:00:00', 'Transmission', '20'),
	('2020-06-23 00:00:00', 'Commutation', '33'),
	('2020-06-23 00:00:00', 'PFS', '11'),
	('2020-06-23 00:00:00', 'Radio', '231'),
	('2020-06-23 00:00:00', 'Transmission', '15'),
	('2020-06-24 00:00:00', 'Commutation', '48'),
	('2020-06-24 00:00:00', 'PFS', '10'),
	('2020-06-24 00:00:00', 'Radio', '324'),
	('2020-06-24 00:00:00', 'Transmission', '17'),
	('2020-06-25 00:00:00', 'Commutation', '43'),
	('2020-06-25 00:00:00', 'PFS', '11'),
	('2020-06-25 00:00:00', 'Radio', '380'),
	('2020-06-25 00:00:00', 'Transmission', '16'),
	('2020-06-26 00:00:00', 'Commutation', '42'),
	('2020-06-26 00:00:00', 'PFS', '9'),
	('2020-06-26 00:00:00', 'Radio', '308'),
	('2020-06-26 00:00:00', 'Transmission', '43'),
	('2020-06-27 00:00:00', 'Commutation', '44'),
	('2020-06-27 00:00:00', 'PFS', '10'),
	('2020-06-27 00:00:00', 'Radio', '288'),
	('2020-06-27 00:00:00', 'Transmission', '27'),
	('2020-06-28 00:00:00', 'Radio', '177'),
	('2020-06-28 00:00:00', 'Transmission', '18'),
	('2020-06-28 00:00:00', 'Commutation', '21'),
	('2020-06-28 00:00:00', 'PFS', '6');
/*!40000 ALTER TABLE `req6` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. reqequip
CREATE TABLE IF NOT EXISTS `reqequip` (
  `Description` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Latitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Longitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `DateDebut` datetime DEFAULT NULL,
  `symptome` text CHARACTER SET utf8 COLLATE utf8_bin,
  `infra` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `categorie` text CHARACTER SET utf8 COLLATE utf8_bin,
  `fournisseur` text CHARACTER SET utf8 COLLATE utf8_bin,
  `idfournisseur` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.reqequip : 56 rows
/*!40000 ALTER TABLE `reqequip` DISABLE KEYS */;
INSERT INTO `reqequip` (`Description`, `Latitude`, `Longitude`, `DateDebut`, `symptome`, `infra`, `dr`, `iddr`, `dc`, `iddc`, `categorie`, `fournisseur`, `idfournisseur`) VALUES
	('CAS_ClubSportifZnata', '33,6234', '-7,526861111', '2019-11-10 16:23:32', 'CI HS par intermittence', 'SRAN-HW', 'DRC', '1550', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1561', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_ALMANAR', '33,59902778', '-7,651527778', '2018-10-10 16:26:27', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_CasaMouhit', '33,52572222', '-7,804916667', '2018-10-18 06:17:25', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_MEGAMIX', '33,5794', '-7,643311111', '2018-11-05 23:01:13', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Environnement', 'HUAWEI', '1528'),
	('DCBR_BOUFARTISS', '33,0215', '-2,351733333', '2019-06-26 01:49:45', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '2482', 'Défaut Equipement', 'NSN', '1535'),
	('CAS_CasaNassim', '33,51875', '-7,660416667', '2018-03-14 12:16:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_MohammadiaPlageMonica', '33,7154', '-7,351330556', '2018-08-25 12:32:43', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN SBAA BERNOUSSI MOHAMMADIA', '1561', 'Défaut Equipement', 'HUAWEI', '1528'),
	('Ouhakayne', '30,8644444444444', '-9,22113888888889', '2020-06-07 12:25:21', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Pc18bis', '24,974', '-12,364', '2020-06-08 01:22:20', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525'),
	('CAS_Plagejackbeach', '33,52902778', '-7,828388889', '2020-06-08 12:31:49', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('BNA_MARINE', '35,2598888888889', '-2,92972222222222', '2020-06-08 17:01:37', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC NADOR', '2520', 'Défaut Environnement', 'NSN', '1535'),
	('Capaawserd', '22,5640555555556', '-14,3100833333333', '2020-06-08 17:30:56', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525'),
	('DCFS_HAMMOUYAT', '34,4969388888889', '-4,49510277777778', '2020-06-08 19:58:17', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Environnement', 'NSN', '1535'),
	('Akermoud', '31,7659388888889', '-9,53158888888889', '2020-06-08 20:32:27', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Rbatichamraren', '31,16480556', '-9,182055556', '2020-06-08 20:32:27', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Tagout', '29,4044166666667', '-9,54711111111111', '2020-06-08 20:53:27', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC GUELMIM-ASSA ZAG-TAN TAN', '2498', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Mezindra', '32,2166916666667', '-8,40012222222222', '2020-06-08 22:22:30', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525'),
	('LAR_SoukTolba', '35,1210555555556', '-5,89975', '2020-06-09 01:10:59', 'CI HS', 'SRAN-HW', 'DRT', '1557', 'DC LARACHE', '2491', 'Défaut Transmission', 'HUAWEI', '1528'),
	('CAS_BouskouraCFCIM', '33,4209722222222', '-7,64519444444444', '2020-06-09 04:18:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('DCMK_TENDIT', '33,7025277777778', '-3,62061111111111', '2020-06-09 05:19:59', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC MEKNES IFRAN-HAJEB-MISSOUR', '2523', 'Défaut Equipement', 'NSN', '1535'),
	('Gueltatzemmour', '25,1482166666667', '-12,3691083333333', '2020-06-09 04:42:53', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Lbeir', '24,8523888888889', '-14,8420833333333', '2020-06-09 05:07:53', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Fotlag', '30,01819444', '-8,783166667', '2020-06-09 07:12:59', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525'),
	('ARG', '31,0213888888889', '-7,47822222222222', '2020-06-09 07:44:32', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525'),
	('DerbMgouna', '31,243', '-6,128', '2020-06-09 08:18:59', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Haddounizdar', '31,2315555555556', '-5,32455555555556', '2020-06-09 08:27:10', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Haddounoufella', '31,2573888888889', '-5,36806666666667', '2020-06-09 08:27:10', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525'),
	('CAS_MICAIRFRANCE', '33,59686111', '-7,615388889', '2019-11-26 12:04:43', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528'),
	('RAB_ALABDARI', '34,0205', '-6,84216944444444', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528'),
	('RAB_BMCE', '34,0218611111111', '-6,83693888888889', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528'),
	('RAB_MICMAMOUNIA', '34,0214388888889', '-6,83868888888889', '2020-06-09 08:51:34', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Transmission', 'HUAWEI', '1528'),
	('samanah', '31,50463889', '-8,061027778', '2020-06-09 09:11:59', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC EL KELAA-AL HAOUZ', '2496', 'Défaut Equipement', 'ERICSSON', '1525'),
	('DCKH_IZTATMINI', '32,9991111111111', '-4,79191666666667', '2020-06-09 08:52:24', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC KHENIFRA', '2493', 'Défaut Equipement', 'NSN', '1535'),
	('RAB_RESMYRACHID', '33,92503056', '-6,824430556', '2020-06-09 09:26:59', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528'),
	('DCBR_Ouled Ali', '34,0491638888889', '-2,04527777777778', '2020-06-09 09:10:29', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC BERKANE-TAOURIRT-JERRADA-BOUARFA', '2482', 'Défaut Equipement', 'NSN', '1535'),
	('DCTZ_BABMARZOUKA', '34,2109972222222', '-4,14447777777778', '2020-06-09 09:12:33', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC TAZA', '2505', 'Défaut Environnement', 'NSN', '1535'),
	('SKALA', '31,525', '-9,753', '2020-06-09 09:39:18', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Transmission', 'ERICSSON', '1525'),
	('DCTE_ADELDAL', '35,1394444444444', '-5,07997222222222', '2020-06-09 10:05:19', 'CI HS', 'SRAN-NSN', 'DRT', '1557', 'DC TETOUAN-CHEFCHAOUEN', '2503', 'Défaut Equipement', 'NSN', '1535'),
	('Ouidouran', '30,1370833333333', '-8,99977777777778', '2020-06-09 10:09:16', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525'),
	('DCND_SIDIBRAHIM', '35,0714722222222', '-2,50027777777778', '2020-06-09 10:42:11', 'CI HS', 'SRAN-NSN', 'DRO', '1554', 'DC NADOR', '2520', 'Défaut Equipement', 'NSN', '1535'),
	('CAS_CasaSofaca', '33,53616667', '-7,613555556', '2019-12-12 11:04:37', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN CHOCK EL FIDA', '2487', 'Défaut Equipement', 'HUAWEI', '1528'),
	('BTS_Mobile', '33,9593638888889', '-6,85320833333333', '2019-12-24 17:23:09', 'CI HS', 'SRAN-NSN', 'DRR', '1555', 'DC KENITRA - SIDI KACEM', '2495', 'Défaut Equipement', 'NSN', '1535'),
	('CAS_CasaChahbi', '33,5895', '-7,526061111', '2020-01-30 23:11:42', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC BEN MSIK SIDI OTHMANE', '2479', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_Pepsi', '33,44077778', '-7,641861111', '2020-02-27 15:26:00', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('RAB_PALAISRCHID', '33,93033611', '-6,82125', '2020-03-03 11:48:44', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528'),
	('AAU1_STADEMEDVENTREE', '33,5830277777778', '-7,64803888888889', '2020-03-21 19:10:20', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_MICTRIANON', '33,5890916666667', '-7,63110555555556', '2020-03-30 12:00:39', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528'),
	('FES_HotelBarceloMini', '34,0433', '-4,99719444444444', '2020-04-03 10:03:32', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535'),
	('RAB_MiniDarEsslam', '33,948675', '-6,83473056', '2020-05-15 19:09:29', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528'),
	('RAB_MICROCOMPLEXE', '33,9675', '-6,883219444', '2020-05-24 19:37:27', 'CI HS', 'SRAN-HW', 'DRR', '1555', 'DC RABAT', '2516', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_ELHANK', '33,60527778', '-7,657527778', '2020-05-29 14:18:06', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC ANFA', '2477', 'Défaut Equipement', 'HUAWEI', '1528'),
	('Talghijt', '28,950075', '-8,6501', '2020-06-02 06:44:59', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525'),
	('CAS_CasaMabsoute', '33,561997', '-7,595136', '2020-06-02 14:26:10', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC AIN CHOCK EL FIDA', '2487', 'Défaut Equipement', 'HUAWEI', '1528'),
	('CAS_CentralPark', '33,4790916666667', '-7,63519166666667', '2020-06-05 09:48:59', 'CI HS', 'SRAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('KTIFATE', '32,1066666666667', '-9,20655555555556', '2020-06-06 00:15:41', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC SAFI-ESSAOUIRA-CHICHAOUA', '2510', 'Défaut Equipement', 'ERICSSON', '1525'),
	('Aitouassif', '31,27096111', '-6,139097222', '2020-06-06 16:22:06', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Environnement', 'ERICSSON', '1525');
/*!40000 ALTER TABLE `reqequip` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. reqequip2g
CREATE TABLE IF NOT EXISTS `reqequip2g` (
  `Description` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Latitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Longitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `DateDebut` datetime DEFAULT NULL,
  `symptome` text CHARACTER SET utf8 COLLATE utf8_bin,
  `infra` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `categorie` text CHARACTER SET utf8 COLLATE utf8_bin,
  `fournisseur` text CHARACTER SET utf8 COLLATE utf8_bin,
  `idfournisseur` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.reqequip2g : 1 rows
/*!40000 ALTER TABLE `reqequip2g` DISABLE KEYS */;
INSERT INTO `reqequip2g` (`Description`, `Latitude`, `Longitude`, `DateDebut`, `symptome`, `infra`, `dr`, `iddr`, `dc`, `iddc`, `categorie`, `fournisseur`, `idfournisseur`) VALUES
	('2G_DCTE_IKHARRIMANE_191095', '35,3016666666667', '-5,05055555555556', '2020-06-07 19:50:15', 'CI HS', 'SRAN-NSN', 'DRT', '1557', 'DC TETOUAN-CHEFCHAOUEN', '2503', 'Défaut Equipement', 'NSN', '1535');
/*!40000 ALTER TABLE `reqequip2g` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. reqequip3g
CREATE TABLE IF NOT EXISTS `reqequip3g` (
  `Description` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Latitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Longitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `DateDebut` datetime DEFAULT NULL,
  `symptome` text CHARACTER SET utf8 COLLATE utf8_bin,
  `infra` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `categorie` text CHARACTER SET utf8 COLLATE utf8_bin,
  `fournisseur` text CHARACTER SET utf8 COLLATE utf8_bin,
  `idfournisseur` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.reqequip3g : 5 rows
/*!40000 ALTER TABLE `reqequip3g` DISABLE KEYS */;
INSERT INTO `reqequip3g` (`Description`, `Latitude`, `Longitude`, `DateDebut`, `symptome`, `infra`, `dr`, `iddr`, `dc`, `iddc`, `categorie`, `fournisseur`, `idfournisseur`) VALUES
	('S3GD_Amslane', '31,0720277777778', '-8,06527777777778', '2020-06-09 02:28:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC EL KELAA-AL HAOUZ', '2496', 'Défaut Equipement', 'ERICSSON', '1525'),
	('S3G_MarrakechEntreeMenara', '31,614', '-8,017', '2020-06-09 02:28:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Equipement', 'ERICSSON', '1525'),
	('S3GD_Bouizdadane', '30,6105833333333', '-7,97336111111111', '2020-06-09 02:48:07', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC TAROUDANT-TATA-CHTOUKA', '2507', 'Défaut Equipement', 'ERICSSON', '1525'),
	('S3G_ALMAHKAMA', '30,354', '-9,535', '2020-06-09 01:51:11', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525'),
	('S3GB_Mirleftamical', '29,588675', '-10,040645', '2020-06-09 01:18:56', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC GUELMIM-ASSA ZAG-TAN TAN', '2498', 'Défaut Equipement', 'ERICSSON', '1525');
/*!40000 ALTER TABLE `reqequip3g` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. reqequip4g
CREATE TABLE IF NOT EXISTS `reqequip4g` (
  `Description` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Latitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `Longitude` text CHARACTER SET utf8 COLLATE utf8_bin,
  `DateDebut` datetime DEFAULT NULL,
  `symptome` text CHARACTER SET utf8 COLLATE utf8_bin,
  `infra` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddr` text CHARACTER SET utf8 COLLATE utf8_bin,
  `dc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `iddc` text CHARACTER SET utf8 COLLATE utf8_bin,
  `categorie` text CHARACTER SET utf8 COLLATE utf8_bin,
  `fournisseur` text CHARACTER SET utf8 COLLATE utf8_bin,
  `idfournisseur` text CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.reqequip4g : 7 rows
/*!40000 ALTER TABLE `reqequip4g` DISABLE KEYS */;
INSERT INTO `reqequip4g` (`Description`, `Latitude`, `Longitude`, `DateDebut`, `symptome`, `infra`, `dr`, `iddr`, `dc`, `iddc`, `categorie`, `fournisseur`, `idfournisseur`) VALUES
	('4G_Asrir', '30,35363889', '-5,844888889', '2020-06-08 12:41:41', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Equipement', 'ERICSSON', '1525'),
	('4G_MarrakechBenohoud', '31,62578056', '-8,005944444', '2020-06-07 19:03:07', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Environnement', 'ERICSSON', '1525'),
	('4G_MarrakechAsoufit', '31,55828056', '-8,094527778', '2019-12-19 14:53:20', 'CI HS', 'SRAN-ERC', 'DRM', '1552', 'DC MARRAKECH', '2490', 'Défaut Equipement', 'ERICSSON', '1525'),
	('4G-Fes-Wahda2-43000269', '34,01761111', '-5,062888889', '2020-06-08 15:41:32', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535'),
	('4G-Fes-HayNouzha-43000507', '34,01507778', '-5,011705556', '2020-06-09 08:20:09', 'CI HS', 'SRAN-NSN', 'DRF', '1553', 'DC FES', '2501', 'Défaut Equipement', 'NSN', '1535'),
	('4GB_Awsserd', '22,55111667', '-14,33173333', '2020-06-05 04:45:18', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC LAAYOUNE-SAKIA LHAMRA-BOUJDOUR', '2492', 'Défaut Configuration', 'ERICSSON', '1525'),
	('4G_AgadirCibelMini', '30,44092222', '-9,650977778', '2020-06-08 21:15:03', 'CI HS', 'SRAN-ERC', 'DRA', '1556', 'DC AGADIR', '2486', 'Défaut Equipement', 'ERICSSON', '1525');
/*!40000 ALTER TABLE `reqequip4g` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. reqmsan
CREATE TABLE IF NOT EXISTS `reqmsan` (
  `Description` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `GpsLatitude` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `Observation` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `DateDebut` datetime DEFAULT NULL,
  `symptome` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `infra` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `dr` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `iddr` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `dc` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `iddc` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `categorie` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `fournisseur` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `idfournisseur` mediumtext CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.reqmsan : 8 rows
/*!40000 ALTER TABLE `reqmsan` DISABLE KEYS */;
INSERT INTO `reqmsan` (`Description`, `GpsLatitude`, `Observation`, `DateDebut`, `symptome`, `infra`, `dr`, `iddr`, `dc`, `iddc`, `categorie`, `fournisseur`, `idfournisseur`) VALUES
	('MHOu-Ta-MellousaDiar', '35,725744', '-5.632133', '2020-06-10 00:00:50', 'CI HS', 'MSAN-HW', 'DRT', '1557', 'DC TANGER', '2508', 'Défaut Environnement', 'HUAWEI', '1528'),
	('MHIM-NKOB1-1', '30,88225', '-5.868111', '2020-06-10 08:20:36', 'CI HS', 'MSAN-HW', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'HUAWEI', '1528'),
	('MHIM-OuladSlimane1-1', '30,58', '-6.148983', '2020-06-10 08:20:36', 'CI HS', 'MSAN-HW', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'HUAWEI', '1528'),
	('MZIn-Mar-Oua-Agdez', '30,69651', '-6.448588', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542'),
	('MZIn-Mar-Oua-Tamazmoute', '30,66763', '-6.144394', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542'),
	('MZIn-Mar-Oua-Tazarine', '30,78227', '-5.566678', '2020-06-10 08:20:36', 'CI HS', 'MSAN-ZTE', 'DRM', '1552', 'DC OUARZAZATE-ZAGORA', '2519', 'Défaut Transmission', 'ZTE', '1542'),
	('MHIn-Ca-Bricolage1-1', '33,38', '-7.692532', '2020-06-10 10:45:19', 'CI HS', 'MSAN-HW', 'DRC', '1550', 'DC HAY HASSANI BOUSKOURA', '1560', 'Défaut Equipement', 'HUAWEI', '1528'),
	('MZOu-Ra-Keni-OuledMBarek', '34,231119', '-6.622117', '2020-06-10 10:48:49', 'CI HS', 'MSAN-ZTE', 'DRR', '1555', 'DC KENITRA - SIDI KACEM', '2495', 'Défaut Environnement', 'ZTE', '1542');
/*!40000 ALTER TABLE `reqmsan` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req_stat_mbts
CREATE TABLE IF NOT EXISTS `req_stat_mbts` (
  `dr` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` mediumtext CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req_stat_mbts : 7 rows
/*!40000 ALTER TABLE `req_stat_mbts` DISABLE KEYS */;
INSERT INTO `req_stat_mbts` (`dr`, `nombre`) VALUES
	('DRC', '14'),
	('DRF', '3'),
	('DRM', '15'),
	('DRO', '2'),
	('DRR', '4'),
	('DRS', '7'),
	('DRT', '10');
/*!40000 ALTER TABLE `req_stat_mbts` ENABLE KEYS */;

-- Listage de la structure de la table dashboard_csn_db. req_stat_msan
CREATE TABLE IF NOT EXISTS `req_stat_msan` (
  `dr` mediumtext CHARACTER SET utf8 COLLATE utf8_bin,
  `nombre` mediumtext CHARACTER SET utf8 COLLATE utf8_bin
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Listage des données de la table dashboard_csn_db.req_stat_msan : 1 rows
/*!40000 ALTER TABLE `req_stat_msan` DISABLE KEYS */;
INSERT INTO `req_stat_msan` (`dr`, `nombre`) VALUES
	('DRM', '1');
/*!40000 ALTER TABLE `req_stat_msan` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
