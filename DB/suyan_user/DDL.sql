USE suyan_user;
CREATE TABLE `tb_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `unique_user_id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `user_name` varchar(32) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(64) NOT NULL COMMENT '用户昵称',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱账号',
  `user_pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_source` tinyint(2) unsigned NOT NULL COMMENT '来源',
  `user_status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_user_name` varchar(64) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_unique_user_id` (`unique_user_id`) USING BTREE,
  KEY `idx_user_code` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';