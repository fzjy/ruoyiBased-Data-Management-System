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

 Date: 03/03/2023 14:11:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bus_prob_list
-- ----------------------------
DROP TABLE IF EXISTS `bus_prob_list`;
CREATE TABLE `bus_prob_list`  (
  `prob_list_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '故障id',
  `prob_list_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障编号',
  `prob_list_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障名称',
  `prob_iscompleted` int(0) NULL DEFAULT NULL COMMENT '是否完成 0未完成，1完成',
  `prob_list_descrip` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息描述',
  `prob_list_source` int(0) NULL DEFAULT NULL COMMENT '信息来源(字典)',
  `prob_list_start_time` datetime(0) NULL DEFAULT NULL COMMENT '提出时间',
  `prob_list_end_time` datetime(0) NULL DEFAULT NULL COMMENT '预计完成时间',
  `prob_list_ATA` int(0) NULL DEFAULT NULL COMMENT 'ATA',
  `dept_id` int(0) NULL DEFAULT NULL COMMENT '责任部门（部门表，字典）',
  `prob_list_actual_end_time` datetime(0) NULL DEFAULT NULL COMMENT '实际完成时间',
  `prob_list_head` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业负责人',
  `prob_list_our_head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门负责人',
  `prob_list_status` int(0) NULL DEFAULT NULL COMMENT '红黄灯状态(字典)',
  `prob_list_evaluation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影响评估，可能会有多个标签（字典）',
  `prob_star` int(0) NULL DEFAULT NULL COMMENT '星级',
  `prob_isoptimize` int(0) NULL DEFAULT NULL COMMENT '是否优化',
  `prob_list_clas` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不优化问题原因',
  `prob_list_tag` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签，可能会有多个标签（字典）',
  `prob_list_tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`prob_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bus_prob_list
-- ----------------------------
INSERT INTO `bus_prob_list` VALUES (1, '111', '测试1', 1, '1', 1, '2023-03-16 21:16:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
