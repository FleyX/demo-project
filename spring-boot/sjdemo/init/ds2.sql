/*
 Navicat Premium Data Transfer

 Source Server         : 10.82.27.177_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 10.82.27.177:3306
 Source Schema         : ds2

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 26/03/2019 14:45:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for other_table
-- ----------------------------
DROP TABLE IF EXISTS `other_table`;
CREATE TABLE `other_table`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
