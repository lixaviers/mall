/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : suyan_message

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/08/2020 19:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sms_channel
-- ----------------------------
DROP TABLE IF EXISTS `sms_channel`;
CREATE TABLE `sms_channel`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `channel_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '渠道编码',
  `channel_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '渠道名称',
  `contact_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '联系人',
  `secret_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '安全秘钥key',
  `support_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支持类型',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除：0.未删除，1.已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniq_channel_code`(`channel_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信渠道表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_channel
-- ----------------------------
INSERT INTO `sms_channel` VALUES (1, 'operationb', '运营平台b端', '素焉', '8e8618b39dfbb0c298425e42f479b3dd', 'verify', NULL, '2020-07-27 14:32:42', NULL, NULL, '2020-07-27 14:33:16', 0);

-- ----------------------------
-- Table structure for sms_message_record
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record`;
CREATE TABLE `sms_message_record`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_message_record
-- ----------------------------
INSERT INTO `sms_message_record` VALUES (605045125058957312, NULL, '13112341234', 1, 'test', NULL, 1, 0, NULL, '【素焉商城】您的验证码为：000000，请于15分钟内输入验证，请勿向他人泄露。若非本人操作，请忽略！', NULL, NULL, NULL, '2020-07-27 14:33:19');
INSERT INTO `sms_message_record` VALUES (605048316454539264, NULL, '13112341233', 1, 'test', NULL, 1, 0, NULL, '【素焉商城】您的验证码为：000000，请于15分钟内输入验证，请勿向他人泄露。若非本人操作，请忽略！', NULL, NULL, NULL, '2020-07-27 14:45:59');

-- ----------------------------
-- Table structure for sms_message_record_0
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_0`;
CREATE TABLE `sms_message_record_0`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_1
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_1`;
CREATE TABLE `sms_message_record_1`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_2
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_2`;
CREATE TABLE `sms_message_record_2`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_3
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_3`;
CREATE TABLE `sms_message_record_3`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_4
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_4`;
CREATE TABLE `sms_message_record_4`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_5
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_5`;
CREATE TABLE `sms_message_record_5`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_6
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_6`;
CREATE TABLE `sms_message_record_6`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_7
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_7`;
CREATE TABLE `sms_message_record_7`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_8
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_8`;
CREATE TABLE `sms_message_record_8`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_message_record_9
-- ----------------------------
DROP TABLE IF EXISTS `sms_message_record_9`;
CREATE TABLE `sms_message_record_9`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `batch_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '批次编码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `channel_id` int(11) NOT NULL COMMENT '渠道id',
  `send_provider` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '发送供应商',
  `template_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模版编码',
  `send_type` tinyint(2) UNSIGNED NOT NULL COMMENT '发送类型：1.验证码类 2.营销类',
  `send_status` tinyint(2) UNSIGNED NOT NULL COMMENT '发送状态 0.失败 1.成功 2.未知',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msg_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信消息ID',
  `msg_result` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回短信错误信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '短信消息记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
