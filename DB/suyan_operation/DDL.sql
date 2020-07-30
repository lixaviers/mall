USE `suyan_operation`;
CREATE TABLE `tb_category`(
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` INT(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父类id',
  `category_name` VARCHAR(64) NOT NULL COMMENT '类目名称',
  `sort_number` INT(11) UNSIGNED NOT NULL DEFAULT 1 COMMENT '排序',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
COMMENT='类目表';
CREATE TABLE `tb_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) unsigned NOT NULL COMMENT '父类id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '名称',
  `order_num` int(11) unsigned NOT NULL COMMENT '排序',
  `address_level` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '层级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地址表';
CREATE TABLE `tb_shop` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '店铺id',
  `unique_user_id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `shop_name` varchar(128) NOT NULL DEFAULT '' COMMENT '店铺名称',
  `shop_logo_url` varchar(255) DEFAULT '' COMMENT '店铺logo地址',
  `shop_introduction` varchar(512) DEFAULT '' COMMENT '店铺简介',
  `province_id` int(11) unsigned NOT NULL COMMENT '省份id',
  `province_name` varchar(64) NOT NULL COMMENT '省份',
  `city_id` int(11) unsigned NOT NULL COMMENT '城市id',
  `city_name` varchar(64) NOT NULL COMMENT '城市',
  `area_id` int(11) unsigned NOT NULL COMMENT '区id',
  `area_name` varchar(64) NOT NULL COMMENT '区',
  `detail_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `common_status` tinyint(2) unsigned NOT NULL COMMENT '状态',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unique_user_id` (`unique_user_id`(32))
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COMMENT='店铺表';
CREATE TABLE `tb_system_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `unique_user_id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `user_name` varchar(32) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `shop_id` bigint(20) unsigned NOT NULL COMMENT '店铺id',
  `operate` varchar(64) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(1000) DEFAULT NULL COMMENT '请求参数',
  `execution_time` bigint(20) unsigned DEFAULT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(32) DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统日志表';
