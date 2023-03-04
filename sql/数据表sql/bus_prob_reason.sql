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

 Date: 03/03/2023 14:11:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_prob_reason
-- ----------------------------
DROP TABLE IF EXISTS `bus_prob_reason`;
CREATE TABLE `bus_prob_reason`  (
  `prob_reason_id` int(0) NOT NULL COMMENT '故障原因id',
  `prob_process_id` int(0) NOT NULL COMMENT '关联流程id',
  `prob_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '故障原因内容',
  PRIMARY KEY (`prob_reason_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_prob_reason
-- ----------------------------
INSERT INTO `bus_prob_reason` VALUES (1, 1, '1111');

SET FOREIGN_KEY_CHECKS = 1;
