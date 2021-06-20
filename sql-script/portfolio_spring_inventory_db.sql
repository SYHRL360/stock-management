DROP DATABASE IF EXISTS `portfolio_spring_inventory_db`;

CREATE DATABASE IF NOT EXISTS `portfolio_spring_inventory_db`;
USE `portfolio_spring_inventory_db`;

--
-- Table strurcture for table `product` 
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) NOT NULL,
    `password` char(80) NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `last_name` varchar(50) NOT NULL,
    `email` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `product_name` varchar(45) DEFAULT NULL,
    `price` int(15) NOT NULL,
    `quantity` int(10) NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `product`
--

-- INSERT INTO `product` VALUES 
-- 	(1, 'Car', 200000000, 1),
--     (2, 'Motor Cycle', 18000000, 2),
--     (3, 'PC Gaming', 11000000, 1);
    
--
-- Table structure for table `product in`
--

DROP TABLE IF EXISTS `product_in`;

CREATE TABLE `product_in` (
	`id` int(10) NOT NULL AUTO_INCREMENT,
    `id_product` int(10) NOT NULL,
	`tanggal` DATE NOT NULL,
    `quantity` int(10) NOT NULL,
    
	PRIMARY KEY(`id`),
    
    KEY `FK_PRODUCT_IN_idx` (`id_product`),
    
    CONSTRAINT `FK_PRODUCT_IN` FOREIGN KEY (`id_product`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;


--
-- Table structure for table `product out`
--

DROP TABLE IF EXISTS `product_out`;

CREATE TABLE `product_out`(
	`id` int(10) NOT NULL AUTO_INCREMENT,
	`id_product` int(10) NOT NULL,
	`tanggal` DATE NOT NULL,
    `quantity` int(10) NOT NULL,
    
    PRIMARY KEY(`id`),
    
    KEY `FK_PRODUCT_OUT_idx` (`id_product`),
    
    CONSTRAINT `FK_PRODUCT_OUT` FOREIGN KEY (`id_product`)
	REFERENCES `product` (`id`)
	ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;












