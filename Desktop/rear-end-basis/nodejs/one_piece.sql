# Host: localhost  (Version: 5.5.53)
# Date: 2020-06-05 21:19:59
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "character"
#

DROP TABLE IF EXISTS `character`;
CREATE TABLE `character` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `fruit` varchar(10) NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "character"
#

/*!40000 ALTER TABLE `character` DISABLE KEYS */;
INSERT INTO `character` VALUES (1,'白胡子','地震果实','/img/1.jpeg'),(2,'罗宾好美','花花果实1','/img/3.jpg'),(3,'乔巴好帅','人猿果实','/img/乔巴.jpeg'),(4,'路飞','橡胶果实好好吃','/img/7.jpg'),(5,'艾斯!!!!!','火焰果实huoyan','/img/5.jpeg'),(6,'罗','空间果实','/img/4.jpg'),(7,'波雅','甜甜果实','/img/2.jpeg'),(9,'索罗','三刀流','/img/6.jpg'),(10,'白胡子','重力果实','/img/1.jpeg');
/*!40000 ALTER TABLE `character` ENABLE KEYS */;
