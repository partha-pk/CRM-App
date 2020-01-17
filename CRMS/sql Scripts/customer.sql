
CREATE DATABASE IF NOT EXISTS`customer_directory`;

USE `customer_directory`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` INT(15) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(40) DEFAULT NULL,
  `last_name` VARCHAR(40) DEFAULT NULL,
  `email` VARCHAR(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

INSERT  INTO `customer`(`id`,`first_name`,`last_name`,`email`) VALUES 
(2,'Phill','clark','clark@gmail.com'),
(3,'Savitri','Gupta','savi@gmail.com'),
(4,'Yuvi','raju','yuvi@gmail.com'),
(6,'Parth','K','parth@gmail.com'),
(8,'Alok','Nath','Alok@gmail.com'),
(9,'rahul','raj','raj@gmail.com'),
(10,'ram','kumar','ram@gmail.com'),
(11,'ajit','Aj','aj@gmail.com'),
(13,'vishal','rj','vishal@gmail.com'),
(14,'jayam','km','jaz@gmail.com'),
(16,'chandler','bing','bing@gmail.com'),
(17,'vinay','kumar','vinay@gmail.com');

