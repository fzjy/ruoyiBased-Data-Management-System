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

 Date: 03/03/2023 14:10:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_prob_temp_solution
-- ----------------------------
DROP TABLE IF EXISTS `bus_prob_temp_solution`;
CREATE TABLE `bus_prob_temp_solution`  (
  `prob_temp_solution_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '临时措施id',
  `prob_process_id` int(0) NULL DEFAULT NULL COMMENT '对应流程更新表id',
  `prob_temp_solution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '临时措施内容',
  `prob_temp_cat` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '措施类别',
  `prob_temp_file_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件编号',
  `prob_temp_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`prob_temp_solution_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
