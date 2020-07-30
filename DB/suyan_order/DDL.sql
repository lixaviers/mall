USE suyan_order;
CREATE TABLE `tb_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `unique_user_id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `shop_id` bigint(20) unsigned NOT NULL COMMENT '店铺id',
  `order_number` varchar(32) NOT NULL COMMENT '订单号',
  `consignee` varchar(64) NOT NULL DEFAULT '' COMMENT '收货人名称',
  `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '收货人手机号',
  `address` varchar(200) NOT NULL DEFAULT '' COMMENT '收货具体地址',
  `total_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '总金额',
  `real_pay_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '实付金额',
  `promotion_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '促销金额',
  `freight_amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '运费金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `is_need_logistics` tinyint(1) unsigned NOT NULL COMMENT '是否需要物流',
  `logistics_company` varchar(100) DEFAULT NULL COMMENT '物流公司',
  `logistics_single_number` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `order_status` tinyint(2) unsigned NOT NULL COMMENT '订单状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `confirm_goods_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `evaluation_time` datetime DEFAULT NULL COMMENT '评价时间',
  `initiate_refund_time` datetime DEFAULT NULL COMMENT '发起退款时间',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `end_time` datetime DEFAULT NULL COMMENT '完结时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_order_number` (`order_number`),
  KEY `idx_unique_user_id` (`unique_user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
CREATE TABLE `tb_order_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `unique_user_id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `shop_id` bigint(20) unsigned NOT NULL COMMENT '店铺id',
  `order_number` varchar(32) NOT NULL COMMENT '订单号',
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `goods_sku_code` varchar(32) NOT NULL COMMENT '商品编码',
  `spec_value` varchar(1000) DEFAULT NULL COMMENT '规格值',
  `goods_price` decimal(12,2) NOT NULL COMMENT '商品价格',
  `goods_number` int(11) unsigned NOT NULL COMMENT '商品数量',
  `total_amount` decimal(12,2) NOT NULL COMMENT '总金额',
  `real_pay_amount` decimal(12,2) NOT NULL COMMENT '实付金额',
  `promotion_amount` decimal(12,2) NOT NULL COMMENT '促销金额',
  `freight_amount` decimal(12,2) NOT NULL COMMENT '运费金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `common_status` tinyint(2) unsigned NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `confirm_goods_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `evaluation_time` datetime DEFAULT NULL COMMENT '评价时间',
  `initiate_refund_time` datetime DEFAULT NULL COMMENT '发起退款时间',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `end_time` datetime DEFAULT NULL COMMENT '完结时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
  PRIMARY KEY (`id`),
  KEY `idx_order_number` (`order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单商品表';