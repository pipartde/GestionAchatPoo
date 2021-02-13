-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 13 fév. 2021 à 08:55
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionachat`
--

-- --------------------------------------------------------

--
-- Structure de la table `achats`
--

DROP TABLE IF EXISTS `achats`;
CREATE TABLE IF NOT EXISTS `achats` (
  `achId` int(11) NOT NULL AUTO_INCREMENT,
  `achMagId` int(11) NOT NULL,
  `achProId` int(11) NOT NULL,
  PRIMARY KEY (`achId`),
  KEY `fk_achats_achMagId` (`achMagId`),
  KEY `fk_achats_achProId` (`achProId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `catId` int(11) NOT NULL AUTO_INCREMENT,
  `catNom` varchar(60) NOT NULL,
  PRIMARY KEY (`catId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`catId`, `catNom`) VALUES
(1, 'Autre');

-- --------------------------------------------------------

--
-- Structure de la table `magasins`
--

DROP TABLE IF EXISTS `magasins`;
CREATE TABLE IF NOT EXISTS `magasins` (
  `magId` int(11) NOT NULL AUTO_INCREMENT,
  `magNom` varchar(60) NOT NULL,
  PRIMARY KEY (`magId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `mesures`
--

DROP TABLE IF EXISTS `mesures`;
CREATE TABLE IF NOT EXISTS `mesures` (
  `mesId` int(11) NOT NULL AUTO_INCREMENT,
  `mesNom` varchar(60) NOT NULL,
  PRIMARY KEY (`mesId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mesures`
--

INSERT INTO `mesures` (`mesId`, `mesNom`) VALUES
(1, 'Unité');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `proNom` varchar(60) NOT NULL,
  `proCatId` int(11) NOT NULL,
  `proMesId` int(11) NOT NULL,
  `proQtt` double NOT NULL,
  PRIMARY KEY (`proId`),
  KEY `fk_produits_proCatId` (`proCatId`),
  KEY `fk_produits_proMesId` (`proMesId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
