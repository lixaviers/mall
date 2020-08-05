package com.suyan.mall.mmc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubPromotionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubPromotionExample() {
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

        public Criteria andSubPromotionNameIsNull() {
            addCriterion("sub_promotion_name is null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameIsNotNull() {
            addCriterion("sub_promotion_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameEqualTo(String value) {
            addCriterion("sub_promotion_name =", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameNotEqualTo(String value) {
            addCriterion("sub_promotion_name <>", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameGreaterThan(String value) {
            addCriterion("sub_promotion_name >", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_promotion_name >=", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameLessThan(String value) {
            addCriterion("sub_promotion_name <", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameLessThanOrEqualTo(String value) {
            addCriterion("sub_promotion_name <=", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameLike(String value) {
            addCriterion("sub_promotion_name like", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameNotLike(String value) {
            addCriterion("sub_promotion_name not like", value, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameIn(List<String> values) {
            addCriterion("sub_promotion_name in", values, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameNotIn(List<String> values) {
            addCriterion("sub_promotion_name not in", values, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameBetween(String value1, String value2) {
            addCriterion("sub_promotion_name between", value1, value2, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andSubPromotionNameNotBetween(String value1, String value2) {
            addCriterion("sub_promotion_name not between", value1, value2, "subPromotionName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeIsNull() {
            addCriterion("sub_promotion_type is null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeIsNotNull() {
            addCriterion("sub_promotion_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeEqualTo(Byte value) {
            addCriterion("sub_promotion_type =", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeNotEqualTo(Byte value) {
            addCriterion("sub_promotion_type <>", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeGreaterThan(Byte value) {
            addCriterion("sub_promotion_type >", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_type >=", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeLessThan(Byte value) {
            addCriterion("sub_promotion_type <", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_type <=", value, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeIn(List<Byte> values) {
            addCriterion("sub_promotion_type in", values, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeNotIn(List<Byte> values) {
            addCriterion("sub_promotion_type not in", values, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_type between", value1, value2, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andSubPromotionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_type not between", value1, value2, "subPromotionType");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNull() {
            addCriterion("promotion_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIsNotNull() {
            addCriterion("promotion_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_amount =", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <>", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_amount >", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount >=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThan(BigDecimal value) {
            addCriterion("promotion_amount <", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_amount <=", value, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_amount in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_amount not in", values, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_amount not between", value1, value2, "promotionAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIsNull() {
            addCriterion("order_full_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIsNotNull() {
            addCriterion("order_full_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountEqualTo(BigDecimal value) {
            addCriterion("order_full_amount =", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_full_amount <>", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountGreaterThan(BigDecimal value) {
            addCriterion("order_full_amount >", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_full_amount >=", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountLessThan(BigDecimal value) {
            addCriterion("order_full_amount <", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_full_amount <=", value, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountIn(List<BigDecimal> values) {
            addCriterion("order_full_amount in", values, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_full_amount not in", values, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_full_amount between", value1, value2, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andOrderFullAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_full_amount not between", value1, value2, "orderFullAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIsNull() {
            addCriterion("promotion_max_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIsNotNull() {
            addCriterion("promotion_max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount =", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount <>", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("promotion_max_amount >", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount >=", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountLessThan(BigDecimal value) {
            addCriterion("promotion_max_amount <", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max_amount <=", value, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountIn(List<BigDecimal> values) {
            addCriterion("promotion_max_amount in", values, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("promotion_max_amount not in", values, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max_amount between", value1, value2, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max_amount not between", value1, value2, "promotionMaxAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNull() {
            addCriterion("discount_amount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIsNotNull() {
            addCriterion("discount_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountEqualTo(BigDecimal value) {
            addCriterion("discount_amount =", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotEqualTo(BigDecimal value) {
            addCriterion("discount_amount <>", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThan(BigDecimal value) {
            addCriterion("discount_amount >", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount >=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThan(BigDecimal value) {
            addCriterion("discount_amount <", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_amount <=", value, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountIn(List<BigDecimal> values) {
            addCriterion("discount_amount in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotIn(List<BigDecimal> values) {
            addCriterion("discount_amount not in", values, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_amount not between", value1, value2, "discountAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountIsNull() {
            addCriterion("promotion_scope_amount is null");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountIsNotNull() {
            addCriterion("promotion_scope_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountEqualTo(String value) {
            addCriterion("promotion_scope_amount =", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountNotEqualTo(String value) {
            addCriterion("promotion_scope_amount <>", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountGreaterThan(String value) {
            addCriterion("promotion_scope_amount >", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_scope_amount >=", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountLessThan(String value) {
            addCriterion("promotion_scope_amount <", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountLessThanOrEqualTo(String value) {
            addCriterion("promotion_scope_amount <=", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountLike(String value) {
            addCriterion("promotion_scope_amount like", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountNotLike(String value) {
            addCriterion("promotion_scope_amount not like", value, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountIn(List<String> values) {
            addCriterion("promotion_scope_amount in", values, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountNotIn(List<String> values) {
            addCriterion("promotion_scope_amount not in", values, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountBetween(String value1, String value2) {
            addCriterion("promotion_scope_amount between", value1, value2, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andPromotionScopeAmountNotBetween(String value1, String value2) {
            addCriterion("promotion_scope_amount not between", value1, value2, "promotionScopeAmount");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeIsNull() {
            addCriterion("sub_promotion_scope is null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeIsNotNull() {
            addCriterion("sub_promotion_scope is not null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeEqualTo(Byte value) {
            addCriterion("sub_promotion_scope =", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeNotEqualTo(Byte value) {
            addCriterion("sub_promotion_scope <>", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeGreaterThan(Byte value) {
            addCriterion("sub_promotion_scope >", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeGreaterThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_scope >=", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeLessThan(Byte value) {
            addCriterion("sub_promotion_scope <", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeLessThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_scope <=", value, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeIn(List<Byte> values) {
            addCriterion("sub_promotion_scope in", values, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeNotIn(List<Byte> values) {
            addCriterion("sub_promotion_scope not in", values, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_scope between", value1, value2, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionScopeNotBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_scope not between", value1, value2, "subPromotionScope");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusIsNull() {
            addCriterion("sub_promotion_status is null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusIsNotNull() {
            addCriterion("sub_promotion_status is not null");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusEqualTo(Byte value) {
            addCriterion("sub_promotion_status =", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusNotEqualTo(Byte value) {
            addCriterion("sub_promotion_status <>", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusGreaterThan(Byte value) {
            addCriterion("sub_promotion_status >", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_status >=", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusLessThan(Byte value) {
            addCriterion("sub_promotion_status <", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusLessThanOrEqualTo(Byte value) {
            addCriterion("sub_promotion_status <=", value, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusIn(List<Byte> values) {
            addCriterion("sub_promotion_status in", values, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusNotIn(List<Byte> values) {
            addCriterion("sub_promotion_status not in", values, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_status between", value1, value2, "subPromotionStatus");
            return (Criteria) this;
        }

        public Criteria andSubPromotionStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("sub_promotion_status not between", value1, value2, "subPromotionStatus");
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