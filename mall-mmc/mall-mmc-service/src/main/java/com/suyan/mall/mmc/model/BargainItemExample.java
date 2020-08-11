package com.suyan.mall.mmc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BargainItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BargainItemExample() {
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

        public Criteria andBargainIdIsNull() {
            addCriterion("bargain_id is null");
            return (Criteria) this;
        }

        public Criteria andBargainIdIsNotNull() {
            addCriterion("bargain_id is not null");
            return (Criteria) this;
        }

        public Criteria andBargainIdEqualTo(Long value) {
            addCriterion("bargain_id =", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotEqualTo(Long value) {
            addCriterion("bargain_id <>", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdGreaterThan(Long value) {
            addCriterion("bargain_id >", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bargain_id >=", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdLessThan(Long value) {
            addCriterion("bargain_id <", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdLessThanOrEqualTo(Long value) {
            addCriterion("bargain_id <=", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdIn(List<Long> values) {
            addCriterion("bargain_id in", values, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotIn(List<Long> values) {
            addCriterion("bargain_id not in", values, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdBetween(Long value1, Long value2) {
            addCriterion("bargain_id between", value1, value2, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotBetween(Long value1, Long value2) {
            addCriterion("bargain_id not between", value1, value2, "bargainId");
            return (Criteria) this;
        }

        public Criteria andNumberMinIsNull() {
            addCriterion("number_min is null");
            return (Criteria) this;
        }

        public Criteria andNumberMinIsNotNull() {
            addCriterion("number_min is not null");
            return (Criteria) this;
        }

        public Criteria andNumberMinEqualTo(Integer value) {
            addCriterion("number_min =", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinNotEqualTo(Integer value) {
            addCriterion("number_min <>", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinGreaterThan(Integer value) {
            addCriterion("number_min >", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_min >=", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinLessThan(Integer value) {
            addCriterion("number_min <", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinLessThanOrEqualTo(Integer value) {
            addCriterion("number_min <=", value, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinIn(List<Integer> values) {
            addCriterion("number_min in", values, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinNotIn(List<Integer> values) {
            addCriterion("number_min not in", values, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinBetween(Integer value1, Integer value2) {
            addCriterion("number_min between", value1, value2, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMinNotBetween(Integer value1, Integer value2) {
            addCriterion("number_min not between", value1, value2, "numberMin");
            return (Criteria) this;
        }

        public Criteria andNumberMaxIsNull() {
            addCriterion("number_max is null");
            return (Criteria) this;
        }

        public Criteria andNumberMaxIsNotNull() {
            addCriterion("number_max is not null");
            return (Criteria) this;
        }

        public Criteria andNumberMaxEqualTo(Integer value) {
            addCriterion("number_max =", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxNotEqualTo(Integer value) {
            addCriterion("number_max <>", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxGreaterThan(Integer value) {
            addCriterion("number_max >", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_max >=", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxLessThan(Integer value) {
            addCriterion("number_max <", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxLessThanOrEqualTo(Integer value) {
            addCriterion("number_max <=", value, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxIn(List<Integer> values) {
            addCriterion("number_max in", values, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxNotIn(List<Integer> values) {
            addCriterion("number_max not in", values, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxBetween(Integer value1, Integer value2) {
            addCriterion("number_max between", value1, value2, "numberMax");
            return (Criteria) this;
        }

        public Criteria andNumberMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("number_max not between", value1, value2, "numberMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMinIsNull() {
            addCriterion("promotion_min is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMinIsNotNull() {
            addCriterion("promotion_min is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMinEqualTo(BigDecimal value) {
            addCriterion("promotion_min =", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinNotEqualTo(BigDecimal value) {
            addCriterion("promotion_min <>", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinGreaterThan(BigDecimal value) {
            addCriterion("promotion_min >", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_min >=", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinLessThan(BigDecimal value) {
            addCriterion("promotion_min <", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_min <=", value, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinIn(List<BigDecimal> values) {
            addCriterion("promotion_min in", values, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinNotIn(List<BigDecimal> values) {
            addCriterion("promotion_min not in", values, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_min between", value1, value2, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_min not between", value1, value2, "promotionMin");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxIsNull() {
            addCriterion("promotion_max is null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxIsNotNull() {
            addCriterion("promotion_max is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxEqualTo(BigDecimal value) {
            addCriterion("promotion_max =", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxNotEqualTo(BigDecimal value) {
            addCriterion("promotion_max <>", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxGreaterThan(BigDecimal value) {
            addCriterion("promotion_max >", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max >=", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxLessThan(BigDecimal value) {
            addCriterion("promotion_max <", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_max <=", value, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxIn(List<BigDecimal> values) {
            addCriterion("promotion_max in", values, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxNotIn(List<BigDecimal> values) {
            addCriterion("promotion_max not in", values, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max between", value1, value2, "promotionMax");
            return (Criteria) this;
        }

        public Criteria andPromotionMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_max not between", value1, value2, "promotionMax");
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