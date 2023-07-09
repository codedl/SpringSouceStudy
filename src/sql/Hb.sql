/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.50.2
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 192.168.50.2:3306
 Source Schema         : Hb

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/07/2023 21:51:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for EVENTS
-- ----------------------------
DROP TABLE IF EXISTS `EVENTS`;
CREATE TABLE `EVENTS`  (
  `EVENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` datetime NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of EVENTS
-- ----------------------------
INSERT INTO `EVENTS` VALUES (1, '2023-07-09 20:39:13', 'cat');
INSERT INTO `EVENTS` VALUES (2, '2023-07-09 20:44:17', 'cat');
INSERT INTO `EVENTS` VALUES (3, '2023-07-09 20:44:54', 'cat');
INSERT INTO `EVENTS` VALUES (4, '2023-07-09 20:44:58', 'cat');
INSERT INTO `EVENTS` VALUES (5, '2023-07-09 20:45:00', 'cat');
INSERT INTO `EVENTS` VALUES (6, '2023-07-09 20:45:01', 'cat');
INSERT INTO `EVENTS` VALUES (7, '2023-07-09 20:45:03', 'cat');
INSERT INTO `EVENTS` VALUES (8, '2023-07-09 20:45:03', 'cat');
INSERT INTO `EVENTS` VALUES (9, '2023-07-09 20:45:03', 'cat');
INSERT INTO `EVENTS` VALUES (10, '2023-07-09 21:43:28', 'cat');
INSERT INTO `EVENTS` VALUES (11, '2023-07-09 21:47:25', 'dog');
INSERT INTO `EVENTS` VALUES (12, '2023-07-09 21:49:27', 'dog');
INSERT INTO `EVENTS` VALUES (13, '2023-07-09 21:50:40', 'dog');

-- ----------------------------
-- Table structure for PERSON
-- ----------------------------
DROP TABLE IF EXISTS `PERSON`;
CREATE TABLE `PERSON`  (
  `PERSON_ID` int(11) NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of PERSON
-- ----------------------------
INSERT INTO `PERSON` VALUES (1, 30, 'ding', 'le');

-- ----------------------------
-- Table structure for PERSON_EMAIL_ADDR
-- ----------------------------
DROP TABLE IF EXISTS `PERSON_EMAIL_ADDR`;
CREATE TABLE `PERSON_EMAIL_ADDR`  (
  `PERSON_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL_ADDR` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PERSON_EMAIL_ADDR
-- ----------------------------
INSERT INTO `PERSON_EMAIL_ADDR` VALUES (1, '704490514@qq.com');

-- ----------------------------
-- Table structure for PERSON_EVENT
-- ----------------------------
DROP TABLE IF EXISTS `PERSON_EVENT`;
CREATE TABLE `PERSON_EVENT`  (
  `PERSON_ID` int(11) NOT NULL,
  `EVENT_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of PERSON_EVENT
-- ----------------------------
INSERT INTO `PERSON_EVENT` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
