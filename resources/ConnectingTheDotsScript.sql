-- Schema connectingTheDots
DROP SCHEMA IF EXISTS `connectingTheDots`;
CREATE SCHEMA IF NOT EXISTS `connectingTheDots` DEFAULT CHARACTER SET utf8;
USE `connectingTheDots`;

-- Table `User`
DROP TABLE IF EXISTS `connectingTheDots`.`User`;

CREATE TABLE IF NOT EXISTS `connectingTheDots`.`User` (
`firstName` VARCHAR(45) NOT NULL,
`prefix` VARCHAR(10) NULL,
`lastName` VARCHAR(45) NOT NULL,
`emailaddress` VARCHAR(45) NOT NULL,
`role` VARCHAR(45) NOT NULL,
`userName` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
PRIMARY KEY (`userName`)
);
-- ENGINE = InnoDB;

-- Insert 'users' for admin into 'User' table
INSERT INTO `User` VALUES
("Liliane", null, "Top", "hallo@lilianetop.nl", "admin", "topxlili001", "1234");

-- Create DBaccess User
CREATE USER 'userConnectingTheDots'@'localhost' IDENTIFIED BY 'pwConnectingTheDots';
GRANT ALL PRIVILEGES ON connectingTheDots.* TO 'userConnectingTheDots'@'localhost';
