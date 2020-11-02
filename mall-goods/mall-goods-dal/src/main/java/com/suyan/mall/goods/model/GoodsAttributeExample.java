/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GoodsAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsAttributeExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdIsNull() {
            addCriterion("goods_category_attribute_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdIsNotNull() {
            addCriterion("goods_category_attribute_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdEqualTo(Long value) {
            addCriterion("goods_category_attribute_id =", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdNotEqualTo(Long value) {
            addCriterion("goods_category_attribute_id <>", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdGreaterThan(Long value) {
            addCriterion("goods_category_attribute_id >", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_category_attribute_id >=", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdLessThan(Long value) {
            addCriterion("goods_category_attribute_id <", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_category_attribute_id <=", value, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdIn(List<Long> values) {
            addCriterion("goods_category_attribute_id in", values, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdNotIn(List<Long> values) {
            addCriterion("goods_category_attribute_id not in", values, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdBetween(Long value1, Long value2) {
            addCriterion("goods_category_attribute_id between", value1, value2, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_category_attribute_id not between", value1, value2, "goodsCategoryAttributeId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameIsNull() {
            addCriterion("goods_category_attribute_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameIsNotNull() {
            addCriterion("goods_category_attribute_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameEqualTo(String value) {
            addCriterion("goods_category_attribute_name =", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameNotEqualTo(String value) {
            addCriterion("goods_category_attribute_name <>", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameGreaterThan(String value) {
            addCriterion("goods_category_attribute_name >", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_category_attribute_name >=", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameLessThan(String value) {
            addCriterion("goods_category_attribute_name <", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameLessThanOrEqualTo(String value) {
            addCriterion("goods_category_attribute_name <=", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameLike(String value) {
            addCriterion("goods_category_attribute_name like", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameNotLike(String value) {
            addCriterion("goods_category_attribute_name not like", value, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameIn(List<String> values) {
            addCriterion("goods_category_attribute_name in", values, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameNotIn(List<String> values) {
            addCriterion("goods_category_attribute_name not in", values, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameBetween(String value1, String value2) {
            addCriterion("goods_category_attribute_name between", value1, value2, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeNameNotBetween(String value1, String value2) {
            addCriterion("goods_category_attribute_name not between", value1, value2, "goodsCategoryAttributeName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdIsNull() {
            addCriterion("goods_category_attribute_value_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdIsNotNull() {
            addCriterion("goods_category_attribute_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdEqualTo(Long value) {
            addCriterion("goods_category_attribute_value_id =", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdNotEqualTo(Long value) {
            addCriterion("goods_category_attribute_value_id <>", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdGreaterThan(Long value) {
            addCriterion("goods_category_attribute_value_id >", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_category_attribute_value_id >=", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdLessThan(Long value) {
            addCriterion("goods_category_attribute_value_id <", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_category_attribute_value_id <=", value, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdIn(List<Long> values) {
            addCriterion("goods_category_attribute_value_id in", values, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdNotIn(List<Long> values) {
            addCriterion("goods_category_attribute_value_id not in", values, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdBetween(Long value1, Long value2) {
            addCriterion("goods_category_attribute_value_id between", value1, value2, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_category_attribute_value_id not between", value1, value2, "goodsCategoryAttributeValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameIsNull() {
            addCriterion("goods_category_attribute_value_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameIsNotNull() {
            addCriterion("goods_category_attribute_value_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameEqualTo(String value) {
            addCriterion("goods_category_attribute_value_name =", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameNotEqualTo(String value) {
            addCriterion("goods_category_attribute_value_name <>", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameGreaterThan(String value) {
            addCriterion("goods_category_attribute_value_name >", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_category_attribute_value_name >=", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameLessThan(String value) {
            addCriterion("goods_category_attribute_value_name <", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameLessThanOrEqualTo(String value) {
            addCriterion("goods_category_attribute_value_name <=", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameLike(String value) {
            addCriterion("goods_category_attribute_value_name like", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameNotLike(String value) {
            addCriterion("goods_category_attribute_value_name not like", value, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameIn(List<String> values) {
            addCriterion("goods_category_attribute_value_name in", values, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameNotIn(List<String> values) {
            addCriterion("goods_category_attribute_value_name not in", values, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameBetween(String value1, String value2) {
            addCriterion("goods_category_attribute_value_name between", value1, value2, "goodsCategoryAttributeValueName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryAttributeValueNameNotBetween(String value1, String value2) {
            addCriterion("goods_category_attribute_value_name not between", value1, value2, "goodsCategoryAttributeValueName");
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