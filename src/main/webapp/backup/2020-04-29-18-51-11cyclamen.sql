-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jiudian
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE,
  KEY `menuId` (`menuId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=437 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (148,2,35),(149,2,36),(150,2,25),(151,2,1),(152,2,14),(153,2,15),(383,1,1),(384,1,5),(385,1,17),(386,1,18),(387,1,19),(388,1,20),(389,1,13),(390,1,21),(391,1,22),(392,1,23),(393,1,35),(394,1,36),(395,1,14),(396,1,15),(397,1,24),(398,1,25),(399,1,26),(400,1,31),(401,1,32),(402,1,33),(403,1,34),(404,1,37),(405,1,38),(406,1,39),(407,1,40),(408,1,41),(409,1,42),(410,1,43),(411,1,44),(412,1,45),(413,1,46),(414,1,47),(415,1,48),(416,1,49),(417,1,50),(418,1,51),(419,1,52),(420,1,53),(421,1,54),(422,1,55),(423,1,56),(424,1,57),(425,1,58),(426,1,59),(427,1,60),(428,1,61),(429,1,62),(430,1,63),(431,1,64),(432,1,65),(433,1,66),(434,1,67),(435,1,68),(436,1,69);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_order`
--

DROP TABLE IF EXISTS `book_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `roomTypeId` int(11) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `idCard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `arriveDate` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `leaveDate` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `accountId` (`accountId`) USING BTREE,
  KEY `roomTypeId` (`roomTypeId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_order`
--

LOCK TABLES `book_order` WRITE;
/*!40000 ALTER TABLE `book_order` DISABLE KEYS */;
INSERT INTO `book_order` VALUES (11,2,2,'张三五','622987745565656','13918655256',2,'2019-01-18','2019-01-19','','2019-01-18 23:57:11'),(13,3,1,'李四','6565656565656','13999999999',0,'2019-01-19','2019-01-20','预计晚上八点到。','2019-01-19 13:27:35'),(14,5,2,'小明','31012002522555','13545455454',2,'2019-01-19','2019-01-20','帮我留一个有窗户的靠南的！谢谢！','2019-01-19 23:02:16'),(15,5,6,'小明','31012002522555','13545455454',1,'2019-01-21','2019-01-22','我会尽快赶来！','2019-01-19 23:02:45'),(16,5,10,'??','31012002522555','13545455454',2,'2019-01-21','2019-01-23','?????','2019-01-19 23:03:25'),(17,6,3,'hehe','34433434343434434343','18253232323',0,'2019-06-03','2019-06-25','4334','2019-06-20 09:46:08'),(18,7,9,'yuh','4222','13557382054',1,'2019-11-15','2019-11-13','22222','2019-11-23 21:46:18'),(19,24,1,'yuh','2133','123456789',0,'2019-12-03','2019-12-04','sdaasd','2019-12-21 22:33:32');
/*!40000 ALTER TABLE `book_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c3p0testtable`
--

DROP TABLE IF EXISTS `c3p0testtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `c3p0testtable` (
  `a` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c3p0testtable`
--

LOCK TABLES `c3p0testtable` WRITE;
/*!40000 ALTER TABLE `c3p0testtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `c3p0testtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floor`
--

DROP TABLE IF EXISTS `floor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floor`
--

LOCK TABLES `floor` WRITE;
/*!40000 ALTER TABLE `floor` DISABLE KEYS */;
INSERT INTO `floor` VALUES (1,'1楼','一楼'),(2,'2楼','2楼的逃生通道有点阻塞。'),(3,'3楼','3楼'),(4,'4楼','4楼监控坏了。'),(5,'5楼',''),(6,'6楼','六楼正常'),(7,'7楼','正常'),(11,'8楼','正常');
/*!40000 ALTER TABLE `floor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (94,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-22 12:31:20'),(93,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-22 00:58:27'),(92,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-22 00:57:05'),(91,'�û���Ϊadmin���û���¼ʱ������֤�����!','2019-12-22 00:56:55'),(90,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-22 00:54:42'),(89,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-15 18:10:23'),(88,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-15 17:47:25'),(87,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-15 17:38:22'),(86,'�û���Ϊ{admin}����ɫΪ{超级管理员}���û���¼�ɹ�!','2019-12-01 14:56:46'),(85,'????{admin}????{?????}???????!','2019-11-23 21:50:06'),(84,'????{admin}????{?????}???????!','2019-11-23 21:47:44'),(83,'????admin?????????????!','2019-11-23 21:47:34'),(82,'????{admin}????{?????}???????!','2019-11-23 21:45:06');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL DEFAULT '-1',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,0,'系统设置','','icon-advancedsettings'),(5,1,'菜单管理','../admin/menu/list','icon-chart-organisation'),(13,1,'角色管理','../admin/role/list','icon-group-key'),(14,0,'用户管理','','icon-group-gear'),(15,14,'用户列表','../admin/user/list','icon-group'),(17,5,'添加','openAdd()','icon-add'),(18,5,'编辑','openEdit()','icon-bullet-edit'),(19,5,'删除','remove()','icon-cross'),(20,5,'添加按钮','openAddMenu()','icon-add'),(21,13,'添加','openAdd()','icon-add'),(22,13,'编辑','openEdit()','icon-bullet-edit'),(23,13,'删除','remove()','icon-cross'),(24,15,'添加','openAdd()','icon-add'),(25,15,'编辑','openEdit()','icon-bullet-edit'),(26,15,'删除','remove()','icon-cross'),(31,0,'系统日志','','icon-table-cell'),(32,31,'日志列表','../admin/log/list','icon-page-white-text'),(33,32,'添加日志','openAdd()','icon-add1'),(34,32,'删除','remove()','icon-cancel'),(35,1,'修改密码','edit_password','icon-lock-edit'),(36,35,'修改密码','openAdd()','icon-lock-edit'),(37,0,'楼层管理','','icon-house'),(38,37,'楼层列表','../admin/floor/list','icon-house-connect'),(39,38,'添加','openAdd()','icon-add'),(40,38,'编辑','openEdit()','icon-bullet-edit'),(41,38,'删除','remove()','icon-cancel'),(42,0,'房型管理','','icon-house-star'),(43,42,'房型列表','../admin/room_type/list','icon-house-key'),(44,43,'添加','openAdd()','icon-add'),(45,43,'编辑','openEdit()','icon-bullet-edit'),(46,43,'删除','remove()','icon-cancel'),(47,0,'房间管理','','icon-house-go'),(48,47,'房间列表','../admin/room/list','icon-house-key'),(49,48,'添加','openAdd()','icon-add'),(50,48,'编辑','openEdit()','icon-bullet-edit'),(51,48,'删除','remove()','icon-cancel'),(52,0,'客户管理','','icon-users'),(53,52,'客户列表','../admin/account/list','icon-user-business-boss'),(54,53,'添加','openAdd()','icon-add'),(55,53,'编辑','openEdit()','icon-bullet-edit'),(56,53,'删除','remove()','icon-cancel'),(57,0,'预定管理','','icon-time-green'),(58,57,'预定列表','../admin/book_order/list','icon-clock'),(59,58,'新增预定','openAdd()','icon-clock-add'),(60,58,'编辑预定','openEdit()','icon-clock-edit'),(61,0,'入住管理','','icon-heart-connect'),(62,61,'入住列表','../admin/checkin/list','icon-heart'),(63,62,'登记入住','openAdd()','icon-heart-add'),(64,62,'编辑入住','openEdit()','icon-heart-connect'),(65,62,'登记退房','openCheckOut()','icon-heart-delete'),(66,0,'营业统计','','icon-money-yen'),(67,66,'统计图表','../admin/stats/stats','icon-chart-curve'),(68,67,'按月统计','statsByMonth()','icon-chart-curve-add'),(69,67,'按日统计','statsByDay()','icon-chart-curve-edit');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员','超级管理员拥有一切权限！'),(2,'普通用户','普通用户，请自由授权！');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sn` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roomTypeId` int(11) NOT NULL,
  `floorId` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roomTypeId` (`roomTypeId`) USING BTREE,
  KEY `floorId` (`floorId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (2,'resources/upload/1547560664869.jpg','1001',1,1,1,'1001单人间、1楼。'),(3,'resources/upload/1547560745508.jpg','2001',2,2,2,'2楼普通大床房'),(4,'resources/upload/1547560846621.jpg','3001',3,3,2,'3001豪华大床房'),(5,'resources/upload/1547824761959.jpg','4001',4,4,0,'商务大床房'),(6,'resources/upload/1547910499411.jpg','5001',6,5,1,'豪华标准房');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` float(8,2) NOT NULL,
  `liveNum` int(2) NOT NULL,
  `bedNum` int(2) NOT NULL,
  `roomNum` int(5) NOT NULL,
  `avilableNum` int(5) NOT NULL,
  `bookNum` int(5) NOT NULL DEFAULT '0',
  `livedNum` int(5) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '1',
  `remark` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `record` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'单人间','resources/upload/1547863202049.jpg',168.00,1,1,12,9,2,1,1,'单人间只能入住一个人，大概15平米左右！',NULL),(2,'普通大床房','resources/upload/1547863299550.jpg',299.00,2,1,15,15,0,0,0,'普通大床房，面积25平左右！',NULL),(3,'豪华大床房','resources/upload/1547863308339.jpg',399.00,2,1,8,7,1,0,1,'豪华大床房，面积30平左右！',NULL),(4,'商务大床房','resources/upload/1547865202071.jpg',429.00,2,1,10,10,0,0,1,'商务大床房，面积40平左右！',NULL),(5,'普通标准间','resources/upload/1547863370413.jpg',199.00,2,2,11,11,0,0,1,'普通标准房，面积20平左右！',NULL),(6,'豪华标准房','resources/upload/1547863398297.jpg',199.00,2,2,10,9,1,1,1,'豪华标准房，面积30平左右！',NULL),(7,'商务标准间','resources/upload/1547863458969.jpg',299.00,2,2,10,10,0,0,1,'商务标准间，面积35平左右！',NULL),(8,'普通套房','resources/upload/1547863486075.jpg',699.00,2,2,6,6,0,0,1,'普通套房，面积50平左右！',NULL),(9,'豪华套房','resources/upload/1547863508790.jpg',899.00,2,2,5,4,1,0,1,'豪华套房，面积70平左右！',NULL),(10,'总统套房','resources/upload/1547863538884.jpg',1299.00,2,2,3,2,1,0,1,'总统套房，面积100平，超豪华！',NULL);
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleId` int(11) NOT NULL,
  `photo` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` int(1) NOT NULL DEFAULT '0',
  `age` int(3) NOT NULL DEFAULT '0',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin',1,'/HotelSSM/resources/upload/1547287973818.png',1,1,'上海市浦东新区');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29 18:51:13
