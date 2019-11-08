-- username: root
-- password: And-trois-456

CREATE DATABASE IF NOT EXISTS `TSWproject`;
USE `TSWproject`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `passwordhash` char(40) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`),
  UNIQUE KEY (`email`)
);

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` longtext NOT NULL,
  `price` bigint(20) NOT NULL,
  `path` blob NOT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY (`name`,`description`)
);

CREATE TABLE `order`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`idproduct` int(11) NOT NULL,
`quantity` int(20) NOT NULL,
`price` bigint(20) NOT NULL,
PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`idproduct`) REFERENCES `product` (`id`)
);

CREATE TABLE `user_order`(
`idorder` int(11) NOT NULL,
`iduser` int(11) NOT NULL,
PRIMARY KEY (`idorder`,`iduser`),
  CONSTRAINT FOREIGN KEY (`idorder`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (`iduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `product_category` (
  `idproduct` int(11) NOT NULL,
  `idcategory` int(11) NOT NULL,
  PRIMARY KEY (`idproduct`,`idcategory`),
  CONSTRAINT FOREIGN KEY (`idproduct`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FOREIGN KEY (`idcategory`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'utente1',SHA1('password1'),'Utente 1','utente1@test.com',1),
						  (2,'utente2',SHA1('password2'),'Utente 2','utente2@test.com',0),
                          (3,'utente3',SHA1('password3'),'Utente 3','utente3@test.com',0);
UNLOCK TABLES;

