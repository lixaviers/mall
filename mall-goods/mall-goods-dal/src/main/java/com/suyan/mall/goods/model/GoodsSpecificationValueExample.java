/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsSpecificationValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsSpecificationValueExample() {
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

        public Criteria andSpecificationIdIsNull() {
            addCriterion("specification_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdIsNotNull() {
            addCriterion("specification_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdEqualTo(Long value) {
            addCriterion("specification_id =", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotEqualTo(Long value) {
            addCriterion("specification_id <>", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdGreaterThan(Long value) {
            addCriterion("specification_id >", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("specification_id >=", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdLessThan(Long value) {
            addCriterion("specification_id <", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdLessThanOrEqualTo(Long value) {
            addCriterion("specification_id <=", value, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdIn(List<Long> values) {
            addCriterion("specification_id in", values, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotIn(List<Long> values) {
            addCriterion("specification_id not in", values, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdBetween(Long value1, Long value2) {
            addCriterion("specification_id between", value1, value2, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationIdNotBetween(Long value1, Long value2) {
            addCriterion("specification_id not between", value1, value2, "specificationId");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameIsNull() {
            addCriterion("specification_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameIsNotNull() {
            addCriterion("specification_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameEqualTo(String value) {
            addCriterion("specification_name =", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameNotEqualTo(String value) {
            addCriterion("specification_name <>", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameGreaterThan(String value) {
            addCriterion("specification_name >", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameGreaterThanOrEqualTo(String value) {
            addCriterion("specification_name >=", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameLessThan(String value) {
            addCriterion("specification_name <", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameLessThanOrEqualTo(String value) {
            addCriterion("specification_name <=", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameLike(String value) {
            addCriterion("specification_name like", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameNotLike(String value) {
            addCriterion("specification_name not like", value, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameIn(List<String> values) {
            addCriterion("specification_name in", values, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameNotIn(List<String> values) {
            addCriterion("specification_name not in", values, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameBetween(String value1, String value2) {
            addCriterion("specification_name between", value1, value2, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationNameNotBetween(String value1, String value2) {
            addCriterion("specification_name not between", value1, value2, "specificationName");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueIsNull() {
            addCriterion("specification_value is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueIsNotNull() {
            addCriterion("specification_value is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueEqualTo(String value) {
            addCriterion("specification_value =", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueNotEqualTo(String value) {
            addCriterion("specification_value <>", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueGreaterThan(String value) {
            addCriterion("specification_value >", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueGreaterThanOrEqualTo(String value) {
            addCriterion("specification_value >=", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueLessThan(String value) {
            addCriterion("specification_value <", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueLessThanOrEqualTo(String value) {
            addCriterion("specification_value <=", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueLike(String value) {
            addCriterion("specification_value like", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueNotLike(String value) {
            addCriterion("specification_value not like", value, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueIn(List<String> values) {
            addCriterion("specification_value in", values, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueNotIn(List<String> values) {
            addCriterion("specification_value not in", values, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueBetween(String value1, String value2) {
            addCriterion("specification_value between", value1, value2, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSpecificationValueNotBetween(String value1, String value2) {
            addCriterion("specification_value not between", value1, value2, "specificationValue");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNull() {
            addCriterion("sort_number is null");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNotNull() {
            addCriterion("sort_number is not null");
            return (Criteria) this;
        }

        public Criteria andSortNumberEqualTo(Integer value) {
            addCriterion("sort_number =", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotEqualTo(Integer value) {
            addCriterion("sort_number <>", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThan(Integer value) {
            addCriterion("sort_number >", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_number >=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThan(Integer value) {
            addCriterion("sort_number <", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sort_number <=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberIn(List<Integer> values) {
            addCriterion("sort_number in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotIn(List<Integer> values) {
            addCriterion("sort_number not in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberBetween(Integer value1, Integer value2) {
            addCriterion("sort_number between", value1, value2, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_number not between", value1, value2, "sortNumber");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
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