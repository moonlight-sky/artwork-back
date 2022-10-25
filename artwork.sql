/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : artwork

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 19/04/2022 18:30:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for art
-- ----------------------------
DROP TABLE IF EXISTS `art`;
CREATE TABLE `art`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `cat_id` int(12) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(255) NULL DEFAULT NULL,
  `add_time` datetime NULL DEFAULT NULL,
  `zan` int(12) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cat_id`(`cat_id`) USING BTREE,
  CONSTRAINT `cat_id` FOREIGN KEY (`cat_id`) REFERENCES `cat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of art
-- ----------------------------
INSERT INTO `art` VALUES (1, 9, '哈利波特手办', '迷你哈利波特手办', 1, '2022-03-24 00:07:53', 1, 'http://localhost:9000/downloadFile/%E5%93%88%E5%88%A9%E6%B3%A2%E7%89%B9%E6%89%8B%E5%8A%9E.jpg');
INSERT INTO `art` VALUES (2, 11, '手工流苏织布', '手工流苏 流苏织布 挂饰 织布 流苏 手工作品 墙饰 流苏挂饰', 1, '2022-03-24 19:14:26', 2, 'http://localhost:9000/downloadFile/%E6%89%8B%E5%B7%A5%E6%B5%81%E8%8B%8F%E7%BB%87%E5%B8%83.jpg');
INSERT INTO `art` VALUES (3, 12, '手工编织南瓜', '手工作品 南瓜 麻绳编织品', 1, '2022-03-24 19:18:14', 15, 'http://localhost:9000/downloadFile/%E6%89%8B%E5%B7%A5%E7%BC%96%E7%BB%87%E5%8D%97%E7%93%9C.jpg');
INSERT INTO `art` VALUES (4, 10, '竹篮', '竹编工艺品', 1, '2022-03-24 19:58:06', 5, 'http://localhost:9000/downloadFile/%E7%AB%B9%E7%AF%AE.jpg');
INSERT INTO `art` VALUES (5, 10, '小花竹篮', '竹子工艺品', 1, '2022-03-24 20:01:23', 1, 'http://localhost:9000/downloadFile/%E5%B0%8F%E8%8A%B1%E7%AB%B9%E7%AF%AE.jpg');
INSERT INTO `art` VALUES (6, 10, '折扇', '扇子 折扇', 1, '2022-03-24 20:08:38', 0, 'http://localhost:9000/downloadFile/%E6%89%8B%E5%B7%A5%E6%8A%98%E6%89%87.jpg');

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cat
-- ----------------------------
INSERT INTO `cat` VALUES (4, '金属', 1);
INSERT INTO `cat` VALUES (5, '水晶', 1);
INSERT INTO `cat` VALUES (6, '玻璃', 1);
INSERT INTO `cat` VALUES (7, '陶瓷', 1);
INSERT INTO `cat` VALUES (8, '石料', 1);
INSERT INTO `cat` VALUES (9, '塑料/树脂', 1);
INSERT INTO `cat` VALUES (10, '竹木', 1);
INSERT INTO `cat` VALUES (11, '手工挂饰', 1);
INSERT INTO `cat` VALUES (12, '手工编织', 1);

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(12) UNSIGNED NOT NULL AUTO_INCREMENT,
  `person_id` int(12) NOT NULL,
  `art_id` int(12) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `person_id`(`person_id`) USING BTREE,
  INDEX `art_id`(`art_id`) USING BTREE,
  CONSTRAINT `art_id` FOREIGN KEY (`art_id`) REFERENCES `art` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES (32, 2, 3);
INSERT INTO `collection` VALUES (33, 2, 4);
INSERT INTO `collection` VALUES (34, 2, 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `aid` int(12) NOT NULL,
  `pid` int(12) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `aid`(`aid`) USING BTREE,
  CONSTRAINT `aid` FOREIGN KEY (`aid`) REFERENCES `art` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 1, 1, 'good', '2022-03-28 13:32:14');
INSERT INTO `comment` VALUES (3, 2, 1, 'good', '2022-03-28 13:32:14');
INSERT INTO `comment` VALUES (6, 3, 2, 'da', '2022-03-28 13:32:14');
INSERT INTO `comment` VALUES (11, 4, 2, 'fasd', NULL);
INSERT INTO `comment` VALUES (12, 3, 2, '可以', NULL);
INSERT INTO `comment` VALUES (13, 3, 2, 'nice', NULL);

-- ----------------------------
-- Table structure for mainmenu
-- ----------------------------
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu`  (
  `id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES (100, '权限管理', '/admin');
INSERT INTO `mainmenu` VALUES (200, '工艺品管理', '/artwork');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `add_time` datetime NULL DEFAULT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '12213', '1321@qq.com', '123456', '2022-02-08 02:13:57', 0);
INSERT INTO `person` VALUES (2, 'qwer', '231324@qq.com', '123456', '2022-02-08 05:23:19', 1);
INSERT INTO `person` VALUES (4, 'eee', '131313@qq.com', '1111111', '2022-02-25 10:50:45', 1);

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 302 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES (101, '管理员列表', '/user', 100);
INSERT INTO `submenu` VALUES (201, '分类列表', '/cat', 200);
INSERT INTO `submenu` VALUES (202, '详情列表', '/goods', 200);
INSERT INTO `submenu` VALUES (203, '评论管理', '/comment', 200);
INSERT INTO `submenu` VALUES (102, '用户列表', '/person', 100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '1123@qq.com', 1);
INSERT INTO `user` VALUES (2, 'xiao', '888888', '41@qq.com', 1);
INSERT INTO `user` VALUES (3, 'dong', '111', '123@qq.com', 1);
INSERT INTO `user` VALUES (4, 'lan', '123456', '243@qq.com', 0);
INSERT INTO `user` VALUES (8, 'fsfs', '1413443', '11111111113412@163.com', 0);
INSERT INTO `user` VALUES (7, 'bei', '147weq', '1231@qq.com', 0);
INSERT INTO `user` VALUES (10, 'saq', '12331234', 'weqeqe@qq.com', 1);
INSERT INTO `user` VALUES (12, 'eqeq', '123144444', '1231211312@qq.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
