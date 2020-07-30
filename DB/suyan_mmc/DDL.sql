USE `suyan_mmc`;
CREATE TABLE `tb_coupon` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `coupon_name` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '优惠券名称',
  `coupon_package_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '券包id',
  `use_type` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '使用类型 1.免费 2.付费',
  `price` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `person_limit` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '每人可领张数 0.不限制/券包包含数量',
  `order_limit` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '订单可以使用张数 0.不限制',
  `start_time` datetime NOT NULL COMMENT '生效时间',
  `end_time` datetime NOT NULL COMMENT '失效时间',
  `pending_time` datetime DEFAULT NULL COMMENT '预热时间',
  `inventory` int(11) unsigned NOT NULL COMMENT '库存',
  `coupon_type` tinyint(2) unsigned NOT NULL COMMENT '优惠券类型',
  `promotion_amount` decimal(12,2) DEFAULT NULL COMMENT '促销金额',
  `order_full_amount` decimal(12,2) DEFAULT NULL COMMENT '订单满金额',
  `promotion_max_amount` decimal(12,2) DEFAULT NULL COMMENT '促销封顶金额',
  `discount_amount` decimal(4,2) DEFAULT NULL COMMENT '折扣金额',
  `promotion_scope_amount` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单金额范围及促销金额json',
  `coupon_status` tinyint(2) unsigned NOT NULL COMMENT '优惠券状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_estonian_ci COMMENT='优惠券表';
CREATE TABLE `tb_coupon_channel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint(20) unsigned NOT NULL COMMENT '优惠券id',
  `channel_id` tinyint(2) unsigned NOT NULL COMMENT '渠道id',
  `inventory` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `is_issue_time` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有发放时间',
  `issue_start_time` datetime DEFAULT NULL COMMENT '发放起始时间',
  `issue_end_time` datetime DEFAULT NULL COMMENT '发放截止时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_coupon_id` (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='优惠券渠道表';