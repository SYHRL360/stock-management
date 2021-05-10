DROP DATABASE IF EXISTS `portfolio_spring_inventory_db`;

CREATE DATABASE IF NOT EXISTS `portfolio_spring_inventory_db`;
USE `portfolio_spring_inventory_db`;

--
-- Table strurcture for table `product` 
--

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `product_name` varchar(45) DEFAULT NULL,
    `price` int(15) NOT NULL,
    `quantity` int(10) UNSIGNED NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `product`
--

INSERT INTO `product` VALUES 
	(1, 'Car', 200000000, 1),
    (2, 'Motor Cycle', 18000000, 2),
    (3, 'PC Gaming', 11000000, 1);













