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

public class GoodsSpecificationNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsSpecificationNameExample() {
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

        public Criteria andGoodsCategoryIdIsNull() {
            addCriterion("goods_category_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdIsNotNull() {
            addCriterion("goods_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdEqualTo(Integer value) {
            addCriterion("goods_category_id =", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotEqualTo(Integer value) {
            addCriterion("goods_category_id <>", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdGreaterThan(Integer value) {
            addCriterion("goods_category_id >", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_category_id >=", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdLessThan(Integer value) {
            addCriterion("goods_category_id <", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_category_id <=", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdIn(List<Integer> values) {
            addCriterion("goods_category_id in", values, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotIn(List<Integer> values) {
            addCriterion("goods_category_id not in", values, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_id between", value1, value2, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_id not between", value1, value2, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIsNull() {
            addCriterion("is_color_attribute is null");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIsNotNull() {
            addCriterion("is_color_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeEqualTo(Boolean value) {
            addCriterion("is_color_attribute =", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotEqualTo(Boolean value) {
            addCriterion("is_color_attribute <>", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeGreaterThan(Boolean value) {
            addCriterion("is_color_attribute >", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_color_attribute >=", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeLessThan(Boolean value) {
            addCriterion("is_color_attribute <", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_color_attribute <=", value, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeIn(List<Boolean> values) {
            addCriterion("is_color_attribute in", values, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotIn(List<Boolean> values) {
            addCriterion("is_color_attribute not in", values, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_color_attribute between", value1, value2, "isColorAttribute");
            return (Criteria) this;
        }

        public Criteria andIsColorAttributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_color_attribute not between", value1, value2, "isColorAttribute");
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