/*
 Navicat Premium Data Transfer

 Source Server         : Liu
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ry

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 03/03/2023 14:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_prob_star
-- ----------------------------
DROP TABLE IF EXISTS `bus_prob_star`;
CREATE TABLE `bus_prob_star`  (
  `prob_star_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '星级id',
  `prob_list_id` int(0) NULL DEFAULT NULL COMMENT '对应故障id',
  `prob_star` int(0) NULL DEFAULT NULL COMMENT '星级',
  `prob_star_basis` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '依据',
  `prob_star_time` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`prob_star_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
