DROP DATABASE IF EXISTS `portfolio_security_inventory_app`;

CREATE DATABASE IF NOT EXISTS `portfolio_security_inventory_app`;
USE `portfolio_security_inventory_app`;

--
-- Table structure for table `users`
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


--
-- Data for table `users`
--
-- NOTE : The passwords are encrypted using BCrypt
--
-- Default password here are: test123


    
--
-- Table structure for table `authorities`
--
-- DROP TABLE IF EXISTS `authorities`;
-- CREATE TABLE `authorities`(
-- 	`username` varchar(50) NOT NULL,
--     `authority` varchar(50) NOT NULL,
--     UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
--     CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
-- )ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --
-- -- Data for table `authorities`
-- --

-- INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN');


