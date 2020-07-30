ALTER TABLE `suyan_goods`.`tb_goods`
ADD COLUMN `express_freight` decimal(12, 0) NOT NULL DEFAULT 0 COMMENT '快递运费' AFTER `inventory`;
ALTER TABLE `suyan_goods`.`tb_goods`
MODIFY COLUMN `per_person_limit` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '限制每人可以购买数量 0.不限购' AFTER `sales`;