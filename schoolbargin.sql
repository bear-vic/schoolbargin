/*
Navicat MySQL Data Transfer

Source Server         : hxg_mysql
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : schoolbargin

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2016-09-05 08:32:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_user` int(11) NOT NULL,
  `c_goods` int(11) NOT NULL,
  `c_comments` text NOT NULL,
  `c_date` datetime NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `c_user` (`c_user`),
  KEY `c_goods` (`c_goods`),
  CONSTRAINT `tb_comments_ibfk_1` FOREIGN KEY (`c_user`) REFERENCES `tb_user` (`u_id`),
  CONSTRAINT `tb_comments_ibfk_2` FOREIGN KEY (`c_goods`) REFERENCES `tb_goods` (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comments
-- ----------------------------
INSERT INTO `tb_comments` VALUES ('1', '1', '9', '还不错', '2016-08-26 14:19:50');
INSERT INTO `tb_comments` VALUES ('2', '2', '9', '便宜点', '2016-08-02 14:59:22');
INSERT INTO `tb_comments` VALUES ('7', '1', '9', '当面交易 ', '2016-08-26 18:15:49');
INSERT INTO `tb_comments` VALUES ('8', '1', '9', 'zxxx', '2016-08-26 18:19:31');
INSERT INTO `tb_comments` VALUES ('9', '1', '9', 'xxx', '2016-08-26 18:21:59');
INSERT INTO `tb_comments` VALUES ('11', '2', '9', '现在能发送吗', '2016-08-27 09:37:02');
INSERT INTO `tb_comments` VALUES ('12', '2', '24', '很形象', '2016-08-29 09:31:31');
INSERT INTO `tb_comments` VALUES ('13', '10', '10', 'hello', '2016-08-29 10:54:50');
INSERT INTO `tb_comments` VALUES ('14', '10', '10', 'hello', '2016-08-29 10:56:19');
INSERT INTO `tb_comments` VALUES ('15', '10', '10', 'hello', '2016-08-29 10:57:38');
INSERT INTO `tb_comments` VALUES ('16', '10', '10', 'ee', '2016-08-29 10:57:40');
INSERT INTO `tb_comments` VALUES ('17', '10', '10', 'ee', '2016-08-29 10:57:51');
INSERT INTO `tb_comments` VALUES ('18', '10', '10', 'ee', '2016-08-29 11:01:29');
INSERT INTO `tb_comments` VALUES ('19', '10', '10', 'tttt', '2016-08-29 11:01:33');
INSERT INTO `tb_comments` VALUES ('20', '10', '10', 'ee', '2016-08-29 11:01:48');
INSERT INTO `tb_comments` VALUES ('21', '10', '10', 'ee', '2016-08-29 11:01:50');
INSERT INTO `tb_comments` VALUES ('22', '10', '10', 'ee', '2016-08-29 11:02:15');
INSERT INTO `tb_comments` VALUES ('23', '10', '10', 'ee', '2016-08-29 11:03:36');
INSERT INTO `tb_comments` VALUES ('24', '10', '10', 'e444', '2016-08-29 11:04:19');
INSERT INTO `tb_comments` VALUES ('25', '10', '10', 'e444e', '2016-08-29 11:05:45');
INSERT INTO `tb_comments` VALUES ('26', '10', '10', 'e444e', '2016-08-29 11:05:50');
INSERT INTO `tb_comments` VALUES ('27', '10', '10', 'e444eeee', '2016-08-29 11:06:16');
INSERT INTO `tb_comments` VALUES ('28', '10', '10', 'e444eeee', '2016-08-29 11:07:09');
INSERT INTO `tb_comments` VALUES ('29', '10', '10', 'e444eeeeeeee', '2016-08-29 11:08:32');
INSERT INTO `tb_comments` VALUES ('30', '10', '10', 'e444eeeeeeee', '2016-08-29 11:09:49');
INSERT INTO `tb_comments` VALUES ('31', '10', '10', 'e444eeeeeeee', '2016-08-29 11:10:26');
INSERT INTO `tb_comments` VALUES ('32', '10', '10', 'e444eeeeeeee', '2016-08-29 11:10:27');
INSERT INTO `tb_comments` VALUES ('33', '10', '10', 'e444eeeeeeee', '2016-08-29 11:10:28');
INSERT INTO `tb_comments` VALUES ('34', '18', '12', '晕', '2016-08-29 14:42:19');
INSERT INTO `tb_comments` VALUES ('35', '18', '12', '6', '2016-08-29 14:42:33');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_title` varchar(255) DEFAULT NULL,
  `g_descrption` text,
  `g_uid` int(11) DEFAULT NULL,
  `g_price` decimal(10,2) NOT NULL,
  `g_name` varchar(255) NOT NULL,
  `g_pic` varchar(255) DEFAULT NULL,
  `g_date` datetime DEFAULT NULL,
  PRIMARY KEY (`g_id`),
  KEY `tb_goods_ibfk_1` (`g_uid`),
  CONSTRAINT `tb_goods_ibfk_1` FOREIGN KEY (`g_uid`) REFERENCES `tb_user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('9', '便宜甩', '没钱吃饭了', '1', '10.00', '订书机', 'pic/2016_8/dcce96db-980d-4fbb-b8ed-205c1cf3a63e.jpg', '2016-08-21 17:36:25');
INSERT INTO `tb_goods` VALUES ('10', '带你装逼带你飞飞飞飞', '风一般的男子', '1', '8.00', '亚索', 'pic/2016_8/9d022bd1-7854-49ee-9470-6cefe8683387.jpg', '2016-08-21 17:39:26');
INSERT INTO `tb_goods` VALUES ('12', '黑夜', '不错的事事顺心找到好工作', '1', '88.00', '星星', 'pic/2016_8/4639f7d5-7399-416e-8200-0a3996dc8a40.jpg', '2016-08-21 17:51:54');
INSERT INTO `tb_goods` VALUES ('14', '呵呵', '骰雷克通', '1', '5.00', 'xx', 'pic/2016_8/8682682d-17b1-4acd-9cd4-1779d311b191.gif', '2016-08-22 10:42:00');
INSERT INTO `tb_goods` VALUES ('16', 'ffff', 'ddd', '2', '6.00', 'go', 'pic/2016_8/3f581c82-dd15-45da-bb4c-2839327c636e.jpg', '2016-08-22 19:08:36');
INSERT INTO `tb_goods` VALUES ('17', '装逼如风，常伴吾身', '要装逼的来', '10', '6.00', '亚索', 'pic/2016_8/15073738-46f5-4d84-8a7a-bc8680d8fa72.jpg', '2016-08-24 09:07:01');
INSERT INTO `tb_goods` VALUES ('18', '不错', 'ee', '10', '6.00', '亚索', 'pic/2016_8/33209e69-a1da-4d73-bc13-522c4e8f7008.jpeg', '2016-08-24 09:29:01');
INSERT INTO `tb_goods` VALUES ('19', '可以骑', 'xx', '10', '66.00', '自行车', 'pic/2016_8/9791e18f-85b7-42fd-ab75-4fa02378e796.gif', '2016-08-24 09:34:02');
INSERT INTO `tb_goods` VALUES ('20', 'en', 'sssss', '1', '8.00', '百度', 'pic/2016_8/b0f2d1e2-7de2-4607-b548-61fff68fe44d.gif', '2016-08-25 14:42:26');
INSERT INTO `tb_goods` VALUES ('21', '冬天的松树', '呵呵', '1', '99.00', '雪松', 'pic/2016_8/6d68b8fc-b3e2-4167-bf22-281979bc7f01.jpg', '2016-08-25 17:50:10');
INSERT INTO `tb_goods` VALUES ('22', '美景', '恩', '1', '8.00', '冬', 'pic/2016_8/d8939f91-af95-4124-9c45-6b8fad590485.jpg', '2016-08-25 23:39:15');
INSERT INTO `tb_goods` VALUES ('23', '恩', 'xxxxxx', '1', '66.00', '无语', 'pic/2016_8/7c15d53a-d10e-4cce-984d-35c3724a77c5.jpg', '2016-08-26 22:31:58');
INSERT INTO `tb_goods` VALUES ('24', '攻城狮', 'O(∩_∩)O哈哈~', '1', '66.00', '程序员', 'pic/2016_8/96d1adfa-226a-442e-bb84-957e2fc537b9.jpg', '2016-08-27 13:14:15');
INSERT INTO `tb_goods` VALUES ('25', '招聘', '恐怖', '1', '88.00', 'ios', 'pic/2016_8/a880d566-a026-439a-b179-37005cc41961.jpg', '2016-08-27 13:15:17');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_telephone` varchar(255) DEFAULT NULL,
  `u_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_userName` (`u_name`),
  UNIQUE KEY `u_email` (`u_email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'hxg', '123', '835260672@@qq.com', '5555', '南昌');
INSERT INTO `tb_user` VALUES ('2', '流星', '123', '888@qq.com', '8899', null);
INSERT INTO `tb_user` VALUES ('10', '项羽', '123', '756286@wqq.com', '181447', null);
INSERT INTO `tb_user` VALUES ('18', 'zs', '123', '', '', null);
