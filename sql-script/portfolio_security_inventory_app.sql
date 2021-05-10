DROP DATABASE IF EXISTS `portfolio_security_inventory_app`;

CREATE DATABASE IF NOT EXISTS `portfolio_security_inventory_app`;
USE `portfolio_security_inventory_app`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`username` varchar(50) NOT NULL,
    `password` char(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Data for table `users`
--
-- NOTE : The passwords are encrypted using BCrypt
--
-- Default password here are: test123


INSERT INTO `users` VALUES 
	('admin','{bcrypt}$2a$10$At6jvShL1BeBPk09.4LW8.8nAzXo5OlQkq9F00Mo1ImmXTaVSFMzm', 1);
    
--
-- Table structure for table `authorities`
--
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`(
	`username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Data for table `authorities`
--

INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN');