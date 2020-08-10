/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : suyan_mmc

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 10/08/2020 19:20:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_bargain_activity
-- ----------------------------
DROP TABLE IF EXISTS `tb_bargain_activity`;
CREATE TABLE `tb_bargain_activity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_id` bigint(20) UNSIGNED NOT NULL COMMENT '店铺id',
  `activity_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '活动名称',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `activity_rule` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动规则',
  `activity_status` tinyint(2) UNSIGNED NOT NULL COMMENT '活动状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '砍价活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_bargain_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_bargain_goods`;
CREATE TABLE `tb_bargain_goods`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bargain_activity_id` bigint(20) UNSIGNED NOT NULL COMMENT '砍价活动id',
  `validity_date_type` tinyint(2) UNSIGNED NOT NULL COMMENT '有效期类型 1.24h 2.48h 3.72h',
  `goods_sku_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编码',
  `price` decimal(12, 2) NOT NULL COMMENT '价格',
  `inventory` int(11) UNSIGNED NOT NULL COMMENT '库存',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_bargain_activity_id`(`bargain_activity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '砍价商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_bargain_goods_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_bargain_goods_item`;
CREATE TABLE `tb_bargain_goods_item`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bargain_goods_id` bigint(20) NOT NULL COMMENT '砍价商品id',
  `number_min` int(11) UNSIGNED NOT NULL COMMENT '最小人数',
  `number_max` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '最大人数',
  `promotion_min` decimal(10, 4) NULL DEFAULT NULL COMMENT '最小比例',
  `promotion_max` decimal(10, 4) NULL DEFAULT NULL COMMENT '最大比例',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_bargain_goods_id`(`bargain_goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '砍价商品阶段表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_coupon
-- ----------------------------
DROP TABLE IF EXISTS `tb_coupon`;
CREATE TABLE `tb_coupon`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `shop_id` bigint(20) UNSIGNED NOT NULL COMMENT '店铺id',
  `coupon_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '优惠券名称',
  `coupon_package_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '券包id',
  `use_type` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '使用类型 1.免费 2.付费',
  `price` decimal(12, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `person_limit` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '每人可领张数 0.不限制/券包包含数量',
  `order_limit` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单可以使用张数 0.不限制',
  `start_time` datetime(0) NOT NULL COMMENT '生效时间',
  `end_time` datetime(0) NOT NULL COMMENT '失效时间',
  `pending_time` datetime(0) NULL DEFAULT NULL COMMENT '预热时间',
  `inventory` int(11) UNSIGNED NOT NULL COMMENT '库存',
  `coupon_type` tinyint(2) UNSIGNED NOT NULL COMMENT '优惠券类型',
  `promotion_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '促销金额',
  `order_full_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '订单满金额',
  `promotion_max_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '促销封顶金额',
  `discount_amount` decimal(4, 2) NULL DEFAULT NULL COMMENT '折扣金额',
  `promotion_scope_amount` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单金额范围及促销金额json',
  `coupon_scope` tinyint(2) NOT NULL COMMENT '使用范围',
  `coupon_status` tinyint(2) UNSIGNED NOT NULL COMMENT '优惠券状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_estonian_ci COMMENT = '优惠券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_coupon
-- ----------------------------
INSERT INTO `tb_coupon` VALUES (1, 1002, '111111111', 0, 1, 0.00, 0, 0, '2020-08-06 11:42:13', '2020-08-13 11:42:13', NULL, 34, 1, 0.01, NULL, NULL, NULL, NULL, 1, 1, '2020-08-06 11:42:16', '2020-08-06 11:47:48', 0);

-- ----------------------------
-- Table structure for tb_coupon_channel
-- ----------------------------
DROP TABLE IF EXISTS `tb_coupon_channel`;
CREATE TABLE `tb_coupon_channel`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint(20) UNSIGNED NOT NULL COMMENT '优惠券id',
  `channel_id` tinyint(2) UNSIGNED NOT NULL COMMENT '渠道id',
  `inventory` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '库存',
  `is_issue_time` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否有发放时间',
  `issue_start_time` datetime(0) NULL DEFAULT NULL COMMENT '发放起始时间',
  `issue_end_time` datetime(0) NULL DEFAULT NULL COMMENT '发放截止时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_coupon_id`(`coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '优惠券渠道表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_coupon_channel
-- ----------------------------
INSERT INTO `tb_coupon_channel` VALUES (1, 5, 2, 7, 0, NULL, NULL, '2020-08-05 17:22:09', '2020-08-05 18:02:38');
INSERT INTO `tb_coupon_channel` VALUES (2, 5, 1, 1, 0, NULL, NULL, '2020-08-05 18:03:05', '2020-08-05 18:03:05');
INSERT INTO `tb_coupon_channel` VALUES (3, 1, 1, 9, 0, NULL, NULL, '2020-08-06 11:42:16', '2020-08-06 11:42:16');
INSERT INTO `tb_coupon_channel` VALUES (4, 1, 2, 25, 0, NULL, NULL, '2020-08-06 11:47:29', '2020-08-06 11:47:48');

-- ----------------------------
-- Table structure for tb_promotion_scope
-- ----------------------------
DROP TABLE IF EXISTS `tb_promotion_scope`;
CREATE TABLE `tb_promotion_scope`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `promotion_type` tinyint(2) UNSIGNED NOT NULL COMMENT '促销类型 1.优惠券 2.订单促销',
  `promotion_id` bigint(20) UNSIGNED NOT NULL COMMENT '促销id',
  `goods_category_id` int(11) UNSIGNED NOT NULL COMMENT '商品类目id',
  `goods_category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品类目名称',
  `goods_sku_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品sku编码',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '促销适用范围表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sub_promotion
-- ----------------------------
DROP TABLE IF EXISTS `tb_sub_promotion`;
CREATE TABLE `tb_sub_promotion`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺id',
  `sub_promotion_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单促销名称',
  `start_time` datetime(0) NOT NULL COMMENT '生效时间',
  `end_time` datetime(0) NOT NULL COMMENT '失效时间',
  `sub_promotion_type` tinyint(2) UNSIGNED NOT NULL COMMENT '订单促销类型',
  `promotion_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '促销金额',
  `order_full_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '订单满金额',
  `promotion_max_amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '促销封顶金额',
  `discount_amount` decimal(4, 2) NULL DEFAULT NULL COMMENT '折扣金额',
  `promotion_scope_amount` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单金额范围及促销金额json',
  `sub_promotion_scope` tinyint(2) UNSIGNED NOT NULL COMMENT '使用范围',
  `sub_promotion_status` tinyint(2) UNSIGNED NOT NULL COMMENT '订单促销状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单促销表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_sub_promotion
-- ----------------------------
INSERT INTO `tb_sub_promotion` VALUES (1, 1002, '123123', '2020-08-06 11:48:20', '2020-08-13 11:48:20', 21, 0.01, 3.01, NULL, NULL, NULL, 1, 1, '2020-08-06 11:48:22', '2020-08-06 11:48:22', 0);

-- ----------------------------
-- Table structure for tb_user_bargain
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_bargain`;
CREATE TABLE `tb_user_bargain`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺id',
  `bargain_activity_id` bigint(20) UNSIGNED NOT NULL COMMENT '砍价活动id',
  `bargain_goods_id` bigint(20) UNSIGNED NOT NULL COMMENT '砍价商品id',
  `bargain_type` tinyint(2) UNSIGNED NOT NULL COMMENT '类型 1.发起 2.参与 3.分享',
  `parent_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父id',
  `amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '金额',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `bargain_copy` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '砍价文案',
  `common_status` tinyint(2) UNSIGNED NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户砍价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user_bargain_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_bargain_item`;
CREATE TABLE `tb_user_bargain_item`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'id',
  `user_bargain_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户砍价id',
  `bargain_goods_item_id` bigint(20) UNSIGNED NOT NULL COMMENT '砍价商品阶段id',
  `item_type` tinyint(2) UNSIGNED NOT NULL COMMENT '类型 1.首次 2.砍价阶梯 3.分享',
  `item_number` int(11) UNSIGNED NOT NULL COMMENT '人数',
  `promotion` decimal(10, 4) NOT NULL COMMENT '比例',
  `amount` decimal(12, 2) NULL DEFAULT NULL COMMENT '金额',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户砍价阶段表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_coupon`;
CREATE TABLE `tb_user_coupon`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `coupon_id` bigint(20) UNSIGNED NOT NULL COMMENT '优惠券id',
  `coupon_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '券码',
  `user_open_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户openId',
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `coupon_status` tinyint(4) UNSIGNED NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新人',
  `update_user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_coupon_code`(`coupon_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户优惠券表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
