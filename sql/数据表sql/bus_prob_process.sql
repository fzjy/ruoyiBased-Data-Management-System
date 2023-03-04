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

 Date: 03/03/2023 14:11:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_prob_process
-- ----------------------------
DROP TABLE IF EXISTS `bus_prob_process`;
CREATE TABLE `bus_prob_process`  (
  `prob_process_id` int(0) NOT NULL COMMENT '流程更新表主键',
  `prob_list_id` int(0) NULL DEFAULT NULL COMMENT '关联故障id',
  `prob_list_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联故障编号',
  `prob_list_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联故障名称',
  `prob_list_descrip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联故障描述',
  `prob_current_process` int(0) NULL DEFAULT NULL COMMENT '流程当前状态 1：已完成 2：编制中，3，4，5，6.。。。',
  `prob_process_num` int(0) NULL DEFAULT NULL COMMENT '当前故障流程更新次数',
  `prob_process_changer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前流程发起人',
  `prob_process_complete_time` datetime(0) NULL DEFAULT NULL COMMENT '当前流程完成时间',
  PRIMARY KEY (`prob_process_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
