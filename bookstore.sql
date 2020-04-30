/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.43 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `bookstore`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `balance` float DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;

/*Data for the table `account` */

insert  into `account`(`accountid`,`balance`) values (1,9740);

/*Table structure for table `deposit` */

DROP TABLE IF EXISTS `deposit`;

CREATE TABLE `deposit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `acount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `deposit` */

insert  into `deposit`(`id`,`username`,`password`,`acount`) values (1,'tom','123',9500),(2,'jerry','123',5500);

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `items` */

insert  into `items`(`id`,`name`,`city`,`price`,`number`,`picture`) values (1,'沃特篮球鞋','佛山',180,500,'001.jpg'),(2,'安踏运动鞋','福州',120,800,'002.jpg'),(3,'耐克运动鞋','广州',500,1000,'003.jpg'),(4,'阿迪达斯T血衫','上海',388,600,'004.jpg'),(5,'李宁文化衫','广州',180,900,'005.jpg'),(6,'小米3','北京',1999,3000,'006.jpg'),(7,'小米2S','北京',1299,1000,'007.jpg'),(8,'thinkpad笔记本','北京',6999,500,'008.jpg'),(9,'dell笔记本','北京',3999,500,'009.jpg'),(10,'ipad5','北京',5999,500,'010.jpg'),(11,'华为P30','深圳',4899,1000,'011.jpg'),(12,'格力空调','珠海',4899,100,'111.jpg'),(13,'美的空调','顺德',2899,200,'222.jpg'),(14,'美的空调','顺德',2899,200,'222.jpg');

/*Table structure for table `mybooks` */

DROP TABLE IF EXISTS `mybooks`;

CREATE TABLE `mybooks` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Author` varchar(30) NOT NULL,
  `Title` varchar(30) NOT NULL,
  `Price` float NOT NULL,
  `Publishingdate` date NOT NULL,
  `Salesamount` int(11) NOT NULL,
  `Storenumber` int(11) NOT NULL,
  `Remark` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gb2312;

/*Data for the table `mybooks` */

insert  into `mybooks`(`Id`,`Author`,`Title`,`Price`,`Publishingdate`,`Salesamount`,`Storenumber`,`Remark`) values (1,'Tom','Java 编程思想',50,'2009-06-22',17,83,'Good Java Book'),(2,'Jerry','Oracle DBA 教材',60,'2009-06-22',12,88,'Good Oracle Book'),(3,'Bob','Ruby',50,'2009-06-22',12,88,'Good 0'),(4,'Mike','Javascript',51,'2009-06-22',0,100,'Good 1'),(5,'Rose','Ajax',52,'2009-06-22',0,100,'Good 2'),(6,'Backham','Struts',53,'2009-06-22',0,100,'Good 3'),(7,'Zidon','Hibernate',54,'2009-06-22',2,12,'Good 4'),(8,'Ronaerdo','Spring',55,'2009-06-22',2,13,'Good 5'),(9,'Clinsman','Cvs',56,'2009-06-22',0,16,'Good 6'),(10,'Kaka','Seo',57,'2009-06-22',0,17,'Good 7'),(11,'Lauer','Lucence',58,'2009-06-22',0,18,'Good 8'),(12,'Kasi','Guice',59,'2009-06-22',0,19,'Good 9'),(13,'Prierlo','Mysql',60,'2009-06-22',6,14,'Good 10'),(14,'Haohaidong','DB2',61,'2009-06-22',9,12,'Good 11'),(15,'Feige','Sybase',62,'2009-06-22',8,14,'Good 12'),(16,'Tuoleisi','DBDesign',63,'2009-06-22',0,23,'Good 13'),(17,'Jielade','Eclipse',64,'2009-06-22',0,24,'Good 14'),(18,'Teli','Netbeans',65,'2009-06-22',0,25,'Good 15'),(19,'Lapade','C#',66,'2009-06-22',0,26,'Good 16'),(20,'Runi','JDBC',67,'2009-06-22',0,27,'Good 17'),(21,'JoeKeer','Php',68,'2009-06-22',0,28,'Good 18'),(22,'Jordan','MysqlFront',69,'2009-06-22',5,24,'Good 19'),(23,'Yaoming','NoteBook',70,'2009-06-22',5,25,'Good 20'),(24,'Yi','C',71,'2009-06-22',5,26,'Good 21'),(25,'Sun','Css',72,'2009-06-22',0,32,'Good 22'),(26,'Xuliang','JQuery',73,'2009-06-22',0,33,'Good 23'),(27,'Meixi','Ext',74,'2009-06-22',0,34,'Good 24'),(28,'Apple','iphone',75,'2009-06-22',0,35,'Good 25'),(29,'Aigo','dc',76,'2009-06-22',0,36,'Good 26'),(30,'Sony','psp',77,'2009-06-22',0,100,'Good 27'),(31,'IRiver','mp3',78,'2009-06-22',0,100,'Good 28'),(32,'Sansing','TV',79,'2009-06-22',0,100,'Good 29');

/*Table structure for table `trade` */

DROP TABLE IF EXISTS `trade`;

CREATE TABLE `trade` (
  `tradeid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `tradetime` datetime NOT NULL,
  PRIMARY KEY (`tradeid`),
  KEY `user_id_fk` (`userid`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gb2312;

/*Data for the table `trade` */

insert  into `trade`(`tradeid`,`userid`,`tradetime`) values (12,1,'2012-11-01 00:00:00'),(13,1,'2012-11-01 00:00:00'),(14,1,'2012-11-01 00:00:00'),(15,1,'2012-12-20 00:00:00'),(16,1,'2012-12-20 00:00:00');

/*Table structure for table `tradeitem` */

DROP TABLE IF EXISTS `tradeitem`;

CREATE TABLE `tradeitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `tradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `book_id_fk` (`bookid`),
  KEY `trade_id_fk` (`tradeid`),
  CONSTRAINT `book_id_fk` FOREIGN KEY (`bookid`) REFERENCES `mybooks` (`Id`),
  CONSTRAINT `trade_id_fk` FOREIGN KEY (`tradeid`) REFERENCES `trade` (`tradeid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=gb2312;

/*Data for the table `tradeitem` */

insert  into `tradeitem`(`itemid`,`bookid`,`quantity`,`tradeid`) values (22,1,10,12),(23,2,10,12),(24,3,10,12),(25,1,1,13),(26,13,2,13),(27,14,3,13),(28,15,4,13),(29,1,1,14),(30,13,2,14),(31,14,3,14),(32,15,4,14),(33,22,5,14),(34,23,5,14),(35,24,5,14),(36,2,1,15),(37,1,2,15),(38,3,1,15),(39,2,1,16),(40,1,3,16),(41,3,1,16);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'tom','123'),(2,'jerry','123'),(3,'rose','123'),(4,'jack','123'),(5,'pang','123');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `accountid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `account_id_fk` (`accountid`),
  CONSTRAINT `account_id_fk` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userid`,`username`,`accountid`) values (1,'Tom',1),(2,'AAA',1),(3,'BB',1),(4,'CC',1),(5,'DD',1),(6,'EE',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
