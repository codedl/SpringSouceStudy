/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 09/07/2023 15:20:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PERSON_EVENT
-- ----------------------------
DROP TABLE IF EXISTS `PERSON_EVENT`;
CREATE TABLE `PERSON_EVENT`  (
  `PERSON_ID` int(11) NOT NULL,
  `EVENT_ID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
