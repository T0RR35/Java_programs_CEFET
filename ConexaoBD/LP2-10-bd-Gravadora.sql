-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11-Set-2014 às 22:31
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
Database: `discdb`
--
CREATE DATABASE IF NOT EXISTS `discdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `discdb`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `artista`
--

DROP TABLE IF EXISTS `artista`;
CREATE TABLE IF NOT EXISTS `artista` (
  `CodArt` int(1) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  PRIMARY KEY (`CodArt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `artista`
--

INSERT INTO `artista` (`CodArt`, `Nome`) VALUES
(1, 'MADONNA'),
(2, 'RICK ASTLEY'),
(3, 'A-HÁ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disco`
--

DROP TABLE IF EXISTS `disco`;
CREATE TABLE IF NOT EXISTS `disco` (
  `CodDisco` int(1) NOT NULL,
  `Titulo` varchar(40) NOT NULL,
  `Genero` varchar(40) NOT NULL,
  `CodArt` int(1) NOT NULL,
  `CodGrav` int(1) NOT NULL,
  PRIMARY KEY (`CodDisco`),
  KEY `CodArt` (`CodArt`),
  KEY `CodArt_2` (`CodArt`),
  KEY `CodArt_3` (`CodArt`),
  KEY `FK_disco_gravadora` (`CodGrav`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `disco`:
--   `CodArt`
--       `artista` -> `CodArt`
--   `CodGrav`
--       `gravadora` -> `CodGrav`
--

--
-- Extraindo dados da tabela `disco`
--

INSERT INTO `disco` (`CodDisco`, `Titulo`, `Genero`, `CodArt`, `CodGrav`) VALUES
(1, 'TRUE BLUE', 'POP', 1, 1),
(2, 'IMMACULATE COLLETION', 'ROCK', 1, 1),
(3, 'SCOUNDREL DAYS', 'ROCK', 3, 2),
(4, 'HOLD ME IN YOUR ARMS', 'POP', 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `faixa`
--

DROP TABLE IF EXISTS `faixa`;
CREATE TABLE IF NOT EXISTS `faixa` (
  `CodDisco` int(1) NOT NULL,
  `CodMus` int(1) NOT NULL,
  `Duracao` varchar(50) NOT NULL,
  PRIMARY KEY (`CodDisco`,`CodMus`),
  KEY `FK_faixa_musica` (`CodMus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `faixa`:
--   `CodDisco`
--       `disco` -> `CodDisco`
--   `CodMus`
--       `musica` -> `CodMus`
--

--
-- Extraindo dados da tabela `faixa`
--

INSERT INTO `faixa` (`CodDisco`, `CodMus`, `Duracao`) VALUES
(1, 1, '00:00:30'),
(1, 2, '00:00:30'),
(1, 3, '00:00:30'),
(1, 4, '00:00:30'),
(1, 5, '00:00:30'),
(1, 6, '00:00:30'),
(1, 7, '00:00:30'),
(1, 8, '00:00:30'),
(2, 1, '00:00:30'),
(2, 2, '00:00:30'),
(2, 7, '00:00:30'),
(2, 9, '00:00:30'),
(2, 10, '00:00:30'),
(2, 11, '00:00:30'),
(2, 12, '00:00:30'),
(2, 13, '00:00:30'),
(2, 14, '00:00:30'),
(2, 15, '00:00:30'),
(3, 16, '00:00:30'),
(3, 17, '00:00:30'),
(3, 18, '00:00:30'),
(3, 19, '00:00:30'),
(3, 20, '00:00:30'),
(3, 21, '00:00:30'),
(3, 22, '00:00:30'),
(3, 23, '00:00:30'),
(4, 24, '00:00:30'),
(4, 25, '00:00:30'),
(4, 26, '00:00:30'),
(4, 27, '00:00:30'),
(4, 28, '00:00:30'),
(4, 29, '00:00:30'),
(4, 30, '00:00:30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `gravadora`
--

DROP TABLE IF EXISTS `gravadora`;
CREATE TABLE IF NOT EXISTS `gravadora` (
  `CodGrav` int(1) NOT NULL,
  `Nome` varchar(40) NOT NULL,
  PRIMARY KEY (`CodGrav`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `gravadora`
--

INSERT INTO `gravadora` (`CodGrav`, `Nome`) VALUES
(1, 'BMG RECORDS'),
(2, 'WEA RECORDS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `musica`
--

DROP TABLE IF EXISTS `musica`;
CREATE TABLE IF NOT EXISTS `musica` (
  `CodMus` int(1) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  PRIMARY KEY (`CodMus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `musica`
--

INSERT INTO `musica` (`CodMus`, `Titulo`) VALUES
(1, 'PAPA DON''T PREACH'),
(2, 'OPEN YOUR HEART'),
(3, 'WHITE HEAT'),
(4, 'LIVE TO TELL'),
(5, 'WHERE''S THE PARTY'),
(6, 'TRUE BLUE'),
(7, 'LA ISLA BONITA'),
(8, 'JIMMY JIMMY'),
(9, 'HOLDAY'),
(10, 'BORDERLINE'),
(11, 'LIKE A VIRGIN'),
(12, 'LIKE A PRAYER'),
(13, 'EXPRESS YOURSELF'),
(14, 'VOGUE'),
(15, 'RECUE ME'),
(16, 'SCOUNDREL DAYS'),
(17, 'THE SWING OF THE THINGS'),
(18, 'I''VE BEEN LOSING YOU'),
(19, 'MANHATTAN SKYLINE'),
(20, 'CRY WOLF'),
(21, 'WE''RE LOOKING FOR THE WHALES'),
(22, 'MAYBE MAYBE'),
(23, 'SOFT APRIL OF APRIL'),
(24, 'SHE WANTS TO DANCE WITH ME'),
(25, 'TAKE ME TO YOUR HEART'),
(26, 'I DON''T WANT TO LOSE HER'),
(27, 'GIVING UP ON LOVE'),
(28, 'I''LL NEVER LET YOU DOWN'),
(29, 'I DONT WANT TO BE YOUR LOVER'),
(30, 'HOLD ME IN YOUR ARMY');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `disco`
--
ALTER TABLE `disco`
  ADD CONSTRAINT `FK_disco_artista` FOREIGN KEY (`CodArt`) REFERENCES `artista` (`CodArt`),
  ADD CONSTRAINT `FK_disco_gravadora` FOREIGN KEY (`CodGrav`) REFERENCES `gravadora` (`CodGrav`);

--
-- Limitadores para a tabela `faixa`
--
ALTER TABLE `faixa`
  ADD CONSTRAINT `FK_faixa_disco` FOREIGN KEY (`CodDisco`) REFERENCES `disco` (`CodDisco`),
  ADD CONSTRAINT `FK_faixa_musica` FOREIGN KEY (`CodMus`) REFERENCES `musica` (`CodMus`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
