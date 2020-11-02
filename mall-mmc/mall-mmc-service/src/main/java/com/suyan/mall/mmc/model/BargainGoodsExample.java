/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BargainGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BargainGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdIsNull() {
            addCriterion("bargain_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdIsNotNull() {
            addCriterion("bargain_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdEqualTo(Long value) {
            addCriterion("bargain_activity_id =", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdNotEqualTo(Long value) {
            addCriterion("bargain_activity_id <>", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdGreaterThan(Long value) {
            addCriterion("bargain_activity_id >", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bargain_activity_id >=", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdLessThan(Long value) {
            addCriterion("bargain_activity_id <", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("bargain_activity_id <=", value, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdIn(List<Long> values) {
            addCriterion("bargain_activity_id in", values, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdNotIn(List<Long> values) {
            addCriterion("bargain_activity_id not in", values, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdBetween(Long value1, Long value2) {
            addCriterion("bargain_activity_id between", value1, value2, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andBargainActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("bargain_activity_id not between", value1, value2, "bargainActivityId");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeIsNull() {
            addCriterion("validity_date_type is null");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeIsNotNull() {
            addCriterion("validity_date_type is not null");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeEqualTo(Byte value) {
            addCriterion("validity_date_type =", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeNotEqualTo(Byte value) {
            addCriterion("validity_date_type <>", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeGreaterThan(Byte value) {
            addCriterion("validity_date_type >", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("validity_date_type >=", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeLessThan(Byte value) {
            addCriterion("validity_date_type <", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("validity_date_type <=", value, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeIn(List<Byte> values) {
            addCriterion("validity_date_type in", values, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeNotIn(List<Byte> values) {
            addCriterion("validity_date_type not in", values, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeBetween(Byte value1, Byte value2) {
            addCriterion("validity_date_type between", value1, value2, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andValidityDateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("validity_date_type not between", value1, value2, "validityDateType");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeIsNull() {
            addCriterion("goods_sku_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeIsNotNull() {
            addCriterion("goods_sku_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeEqualTo(String value) {
            addCriterion("goods_sku_code =", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeNotEqualTo(String value) {
            addCriterion("goods_sku_code <>", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeGreaterThan(String value) {
            addCriterion("goods_sku_code >", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_sku_code >=", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeLessThan(String value) {
            addCriterion("goods_sku_code <", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_sku_code <=", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeLike(String value) {
            addCriterion("goods_sku_code like", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeNotLike(String value) {
            addCriterion("goods_sku_code not like", value, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeIn(List<String> values) {
            addCriterion("goods_sku_code in", values, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeNotIn(List<String> values) {
            addCriterion("goods_sku_code not in", values, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeBetween(String value1, String value2) {
            addCriterion("goods_sku_code between", value1, value2, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andGoodsSkuCodeNotBetween(String value1, String value2) {
            addCriterion("goods_sku_code not between", value1, value2, "goodsSkuCode");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Integer> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Integer> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}