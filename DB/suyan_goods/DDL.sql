USE suyan_goods;
CREATE TABLE `tb_goods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `shop_id` bigint(20) unsigned NOT NULL COMMENT '店铺id',
  `goods_name` varchar(64) NOT NULL COMMENT '商品名称',
  `goods_category_id` int(11) unsigned NOT NULL COMMENT '类目id',
  `is_more_spec` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否多规格',
  `spec_value` varchar(2000) DEFAULT NULL COMMENT '规格值json',
  `original_price` decimal(12,2) DEFAULT NULL COMMENT '原价',
  `list_price` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '列表价',
  `inventory` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `express_freight` decimal(12, 0) NOT NULL DEFAULT 0 COMMENT '快递运费',
  `sales` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '销量',
  `per_person_limit` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '限制每人可以购买数量 0.不限购',
  `view_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '浏览量',
  `goods_status` tinyint(2) unsigned NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品表';
CREATE TABLE `tb_goods_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) unsigned NOT NULL COMMENT '父类id',
  `category_name` varchar(32) NOT NULL COMMENT '类目名称',
  `is_enable` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品类目表';
CREATE TABLE `tb_goods_description` (
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `description` text COMMENT '描述',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品描述表';
CREATE TABLE `tb_goods_sku` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_code` varchar(32) NOT NULL COMMENT '商品编码',
  `shop_id` bigint(20) unsigned NOT NULL COMMENT '店铺id',
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `spec_value` varchar(1000) DEFAULT NULL COMMENT '规格值',
  `price` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '价格',
  `inventory` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `sales` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '销量',
  `common_status` tinyint(2) unsigned NOT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品规格表';
CREATE TABLE `tb_goods_specification_name` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `specification_name` varchar(32) NOT NULL COMMENT '规格名称',
  `goods_category_id` int(11) NOT NULL COMMENT '商品类目id',
  `is_color_attribute` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否颜色属性',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品规格名表';
CREATE TABLE `tb_goods_specification_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `specification_id` bigint(20) unsigned NOT NULL COMMENT '规格id',
  `specification_name` varchar(32) NOT NULL DEFAULT '' COMMENT '规格名',
  `specification_value` varchar(64) NOT NULL DEFAULT '' COMMENT '规格值',
  `sort_number` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除: 0.未删除 1.已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='商品规格值表';