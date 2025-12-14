-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.35 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para bd_pessoal
DROP DATABASE IF EXISTS `bd_pessoal`;
CREATE DATABASE IF NOT EXISTS `bd_pessoal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_pessoal`;


-- Copiando estrutura para tabela bd_pessoal.pessoal
DROP TABLE IF EXISTS `pessoal`;
CREATE TABLE IF NOT EXISTS `pessoal` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `turma` varchar(50) NOT NULL,
  `setor` varchar(50) NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela bd_pessoal.pessoal: ~100 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoal` DISABLE KEYS */;
REPLACE INTO `pessoal` (`matricula`, `nome`, `email`, `senha`, `cargo`, `turma`, `setor`) VALUES
	(3079, 'Melody Pleaden', 'mpleaden1i@admin.ch', 'hGDbPGFLCKhS', 'Docente', '', ''),
	(3782, 'Danni Ethridge', 'dethridge1n@archive.org', 'IFdNcke16K', 'Discente', 'ELE2', ''),
	(4010, 'Halsy Doust', 'hdousti@usgs.gov', 'tFThgKmOPQ', 'Geral', '', 'Biblioteca'),
	(4879, 'Enriqueta Bryan', 'ebryan23@biblegateway.com', 'xTRygIG', 'Geral', '', 'Biblioteca'),
	(6100, 'Farlee Crayk', 'fcraykw@ifeng.com', 'DPaxFw', 'Geral', '', 'Secretaria'),
	(6294, 'Redford Fearenside', 'rfearensidec@vistaprint.com', '0s032BQ', 'Discente', 'CAM1', ''),
	(8038, 'Eddy Wadly', 'ewadlys@bigcartel.com', 'F00V4RxFI', 'Docente', '', ''),
	(8208, 'Odelle Beavors', 'obeavors2k@blogtalkradio.com', 'NZcOnxOP', 'Discente', 'ELE1', ''),
	(8691, 'Alain Lippingwell', 'alippingwell1t@jalbum.net', 'zBxn7xh', 'Geral', '', 'Biblioteca'),
	(9638, 'Quintilla Durran', 'qdurran1b@state.tx.us', 'DJpV6jlLRBf', 'Discente', 'ELE2', ''),
	(9968, 'Ulrikaumeko Aliberti', 'ualiberti28@cnbc.com', 'bpHyiq7', 'Docente', '', ''),
	(10394, 'Winthrop Colbourne', 'wcolbournex@storify.com', 'ud7djzNoyD', 'Discente', 'INF1', ''),
	(10954, 'Mirabel MacGahy', 'mmacgahyl@businesswire.com', 'VL6zPH', 'Geral', '', 'Biblioteca'),
	(11925, 'Karon Loalday', 'kloalday1p@utexas.edu', 'Fk3mpvZb', 'Geral', '', 'Estágio'),
	(12036, 'Dory Kenner', 'dkenner1r@posterous.com', 'Bv6gvknf3u', 'Geral', '', 'Estágio'),
	(13432, 'Rica Ashwood', 'rashwood0@unc.edu', 'Dm7f8sKVFd', 'Geral', '', 'Secretaria'),
	(13817, 'Dulcie Cumo', 'dcumou@booking.com', '9q6LD74kqo', 'Docente', '', ''),
	(14976, 'Didi Chalfain', 'dchalfain1s@google.es', 'otaZJZfc1', 'Docente', '', ''),
	(16054, 'Dix Ellam', 'dellamn@imdb.com', 'sMZB3KL', 'Docente', '', ''),
	(17333, 'Petunia Manske', 'pmanske1w@go.com', '2FAzJQ', 'Docente', '', ''),
	(18246, 'Adel Comberbach', 'acomberbach22@4shared.com', '5wCOkfmLr', 'Discente', 'CAM2', ''),
	(19013, 'Cristin Riddich', 'criddich19@abc.net.au', '9Bo5yQkW2', 'Geral', '', 'Biblioteca'),
	(19287, 'Cullin Attwooll', 'cattwooll10@aboutads.info', '06TqIM', 'Docente', '', ''),
	(19617, 'Penrod Goodhand', 'pgoodhandb@zimbio.com', '7qMw3JjCb', 'Geral', '', 'Secretaria'),
	(19943, 'Charmaine Calderon', 'ccalderon2m@netvibes.com', 'qF1KRo', 'Discente', 'INF3', ''),
	(19965, 'Andreana Leavy', 'aleavy15@huffingtonpost.com', '7z1kPg', 'Geral', '', 'Estágio'),
	(20824, 'Barbara-anne Hansana', 'bhansana1k@sphinn.com', 'DswyrxKpFad', 'Geral', '', 'Secretaria'),
	(23939, 'Caryl Ledes', 'cledes12@mapy.cz', '1kza95', 'Docente', '', ''),
	(26314, 'Jonell Zorro', 'jzorroy@blogtalkradio.com', 'Bspm9u', 'Discente', 'ELE3', ''),
	(27261, 'Jilli Morgan', 'jmorgan1j@prnewswire.com', 'EQtr3J', 'Discente', 'INF2', ''),
	(27343, 'Deedee Smythe', 'dsmythe16@msn.com', 'VxraUM', 'Docente', '', ''),
	(29195, 'Bibbye Goldbourn', 'bgoldbourn1v@lulu.com', 'mSMbUfK', 'Discente', 'ELE3', ''),
	(29574, 'Read Polkinghorne', 'rpolkinghorne1o@narod.ru', 'YCGOrAE', 'Docente', '', ''),
	(33499, 'Karlis Winterbourne', 'kwinterbourne1@unicef.org', 'j3sbil6l', 'Docente', '', ''),
	(33961, 'Ynes Commin', 'ycommint@a8.net', 'r5HRsWcAW8', 'Docente', '', ''),
	(35100, 'Lindie Fass', 'lfass1d@tripod.com', 'FMWXNRCieazb', 'Geral', '', 'Estágio'),
	(35694, 'Rosabelle Boldra', 'rboldra1l@blogtalkradio.com', 'eH0Rksqw', 'Docente', '', ''),
	(35981, 'Maddy Pacitti', 'mpacitti2p@noaa.gov', 'SJYSS0', 'Discente', 'CAM1', ''),
	(36115, 'Allys Barchrameev', 'abarchrameevv@vistaprint.com', 'soj54iXthjL2', 'Discente', 'ELE2', ''),
	(37083, 'Niko Beachem', 'nbeachem26@nature.com', 'S1BceuC', 'Discente', 'CAM2', ''),
	(37244, 'Gabie McEntagart', 'gmcentagart6@hc360.com', 'Xn8ufR', 'Docente', '', ''),
	(39432, 'Dominique Eldred', 'deldred1m@nyu.edu', '2mA9DjwYba', 'Geral', '', 'Estágio'),
	(40048, 'Leonhard Lurriman', 'llurriman2@utexas.edu', 'lHSyShJZTA', 'Discente', 'INF3', ''),
	(40295, 'Gaspar Fautley', 'gfautley2q@cbc.ca', '4Exz4e8B', 'Geral', '', 'Secretaria'),
	(40861, 'Rahel Abeles', 'rabeles2e@creativecommons.org', '2ZQK9w4evon', 'Discente', 'ELE3', ''),
	(42174, 'Kellie Armfield', 'karmfield1f@behance.net', '38e1LW', 'Discente', 'CAM1', ''),
	(42718, 'Jere Goodson', 'jgoodson1z@usnews.com', 'qk3Vxb', 'Discente', 'ELE3', ''),
	(42810, 'Gael Murrow', 'gmurrow24@flavors.me', 'z03Qrxwil', 'Docente', '', ''),
	(44318, 'Devland Battaille', 'dbattaille1x@shutterfly.com', 'ZSdJaVp', 'Discente', 'INF1', ''),
	(44767, 'Barbra Bruckenthal', 'bbruckenthalg@noaa.gov', 'JfiIl7rbfY', 'Geral', '', 'Estágio'),
	(48097, 'Chery Leaney', 'cleaney1y@statcounter.com', 'Fh0olJc', 'Discente', 'ELE2', ''),
	(48742, 'Ada Trayte', 'atrayte5@ox.ac.uk', 'BOGZLTh', 'Docente', '', ''),
	(50775, 'Corrine Kobera', 'ckobera2j@mac.com', 'y5fE8O', 'Geral', '', 'Biblioteca'),
	(50888, 'Gerik Breukelman', 'gbreukelman13@constantcontact.com', '7GZzigceWHEv', 'Discente', 'CAM1', ''),
	(51864, 'Tallie Wilshire', 'twilshire1u@blogtalkradio.com', 'PU5BRfIJq0', 'Discente', 'INF2', ''),
	(52969, 'Pansy Heino', 'pheino2n@naver.com', 'tXpKtq9NHpE', 'Discente', 'INF2', ''),
	(53648, 'Finley Ritelli', 'fritellif@yale.edu', 'AOP7rf', 'Docente', '', ''),
	(54477, 'Gil Bendix', 'gbendix18@umich.edu', '0KA1iPgKcjE', 'Geral', '', 'Estágio'),
	(54616, 'Ban Girardi', 'bgirardi11@mayoclinic.com', 'SmkwQQM5rbfr', 'Geral', '', 'Secretaria'),
	(56618, 'Darelle Gamlen', 'dgamlenr@dailymotion.com', 'xjDAjVGKb', 'Docente', '', ''),
	(58427, 'Romona Slite', 'rslitek@t.co', 'M0EVVUO3tI9E', 'Docente', '', ''),
	(58602, 'Walt O\'Luby', 'woluby27@flavors.me', 'UuQE5iQhuI', 'Docente', '', ''),
	(59539, 'Ulric Pomfret', 'upomfretm@odnoklassniki.ru', '3AiRaEg5nmm', 'Docente', '', ''),
	(60448, 'Franciskus Andriolli', 'fandriolli21@privacy.gov.au', 'O5cYmalbI8', 'Docente', '', ''),
	(64042, 'Christiano Hutchinson', 'chutchinson14@prnewswire.com', 'lsj7Ia', 'Discente', 'CAM2', ''),
	(65898, 'Vevay Mandy', 'vmandy1e@drupal.org', '1Yy7sh1', 'Geral', '', 'Biblioteca'),
	(67243, 'Joey Teanby', 'jteanby2i@huffingtonpost.com', 'SkoHEvWhiPC', 'Docente', '', ''),
	(68210, 'Dame Ammer', 'dammerd@nba.com', 'Pjnadsv', 'Discente', 'CAM1', ''),
	(68270, 'Cynthie Broxholme', 'cbroxholme2h@weibo.com', '1rCDqGVQb7W', 'Geral', '', 'Estágio'),
	(68698, 'Raddie Jurgensen', 'rjurgenseno@goo.gl', '6eUrnOfoT', 'Discente', 'CAM1', ''),
	(70552, 'Justen Tulk', 'jtulk17@abc.net.au', 'Oz282pNtu', 'Discente', 'CAM1', ''),
	(74533, 'Kristofer Erswell', 'kerswell20@twitpic.com', 'tLt0ZqAy6y0g', 'Discente', 'CAM2', ''),
	(74585, 'Patrice Dyball', 'pdyball2f@livejournal.com', 'A5Va3Ww5d', 'Geral', '', 'Secretaria'),
	(75033, 'Daune Siddle', 'dsiddlez@ustream.tv', 'Br1ab8', 'Geral', '', 'Estágio'),
	(75190, 'Lynette Marquet', 'lmarqueta@indiatimes.com', 'C04Y8V', 'Geral', '', 'Estágio'),
	(76871, 'Ruby Toomey', 'rtoomey2b@angelfire.com', 'f8US9ExmPU', 'Docente', '', ''),
	(79432, 'Isis Wiggin', 'iwigginh@ted.com', 'KcSgBJtbN', 'Docente', '', ''),
	(79490, 'Teirtza Hughman', 'thughman1c@phpbb.com', '6E4HqJJf', 'Docente', '', ''),
	(79609, 'Sloane Lissett', 'slissett25@hexun.com', 'GNeS4g46uC2', 'Discente', 'INF2', ''),
	(80068, 'Evita Breton', 'ebreton7@businessweek.com', 'ZxlLTDTwh6ng', 'Geral', '', 'Biblioteca'),
	(82912, 'Merilee Garth', 'mgarth2r@reference.com', '8vRov7mPsE', 'Discente', 'CAM1', ''),
	(83098, 'Elwin Erbain', 'eerbain2a@ox.ac.uk', '0cS8CAzpb', 'Discente', 'ELE1', ''),
	(83899, 'Daryl Frost', 'dfrost1g@google.com.br', 'dSU7GkXeqNY', 'Geral', '', 'Estágio'),
	(84445, 'Nataline Mulroy', 'nmulroy1q@army.mil', 'jhTCM1o2', 'Docente', '', ''),
	(84813, 'Rudolph Lacasa', 'rlacasa9@skyrock.com', '4sR26fBp9T', 'Docente', '', ''),
	(85306, 'Al Gross', 'agross8@tumblr.com', 'uP0f7qZ', 'Geral', '', 'Estágio'),
	(87156, 'Alanah Reuss', 'areuss3@sourceforge.net', 'LQ27EVRhSR4g', 'Docente', '', ''),
	(87422, 'Lyndsie Niesel', 'lniesele@sfgate.com', '8kvygux', 'Geral', '', 'Secretaria'),
	(87782, 'Sampson Colquyte', 'scolquytej@sfgate.com', 'D0xzJ7VDWS75', 'Geral', '', 'Biblioteca'),
	(88693, 'Addy Pandie', 'apandie2l@friendfeed.com', '0lMh6C7XNey', 'Geral', '', 'Estágio'),
	(91583, 'Tamarah Quinnette', 'tquinnette1a@bloglines.com', 'EeYwvu1a', 'Docente', '', ''),
	(93076, 'Florian Pendered', 'fpendered2g@mapquest.com', 'JKPPj5lQILwf', 'Geral', '', 'Biblioteca'),
	(94109, 'Aigneis Gillean', 'agilleanp@economist.com', '98cIcV', 'Discente', 'CAM2', ''),
	(94697, 'Daryle Buzza', 'dbuzza2c@chronoengine.com', 'lfYV0kFcDS', 'Docente', '', ''),
	(95187, 'Carlota McNevin', 'cmcnevin4@vk.com', '5ySSLEMF', 'Geral', '', 'Estágio'),
	(95816, 'Audrey Portail', 'aportailq@fda.gov', 'E4uxpZjLG7Gg', 'Docente', '', ''),
	(95969, 'Brande Heaphy', 'bheaphy2d@moonfruit.com', 'Vkw1Su4aY0h', 'Geral', '', 'Estágio'),
	(96888, 'Alyss Print', 'aprint29@clickbank.net', '7Q0VDsmDI', 'Discente', 'INF2', ''),
	(98130, 'Andreana Mugford', 'amugford1h@unicef.org', 'TgEf0oR', 'Geral', '', 'Biblioteca'),
	(99957, 'Amara Bax', 'abax2o@geocities.jp', 'iwU8XpcRW', 'Discente', 'CAM2', '');
/*!40000 ALTER TABLE `pessoal` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
