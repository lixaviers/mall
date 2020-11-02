/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MqMessageDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MqMessageDataExample() {
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

        public Criteria andMessageGroupIsNull() {
            addCriterion("message_group is null");
            return (Criteria) this;
        }

        public Criteria andMessageGroupIsNotNull() {
            addCriterion("message_group is not null");
            return (Criteria) this;
        }

        public Criteria andMessageGroupEqualTo(String value) {
            addCriterion("message_group =", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupNotEqualTo(String value) {
            addCriterion("message_group <>", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupGreaterThan(String value) {
            addCriterion("message_group >", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupGreaterThanOrEqualTo(String value) {
            addCriterion("message_group >=", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupLessThan(String value) {
            addCriterion("message_group <", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupLessThanOrEqualTo(String value) {
            addCriterion("message_group <=", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupLike(String value) {
            addCriterion("message_group like", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupNotLike(String value) {
            addCriterion("message_group not like", value, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupIn(List<String> values) {
            addCriterion("message_group in", values, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupNotIn(List<String> values) {
            addCriterion("message_group not in", values, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupBetween(String value1, String value2) {
            addCriterion("message_group between", value1, value2, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageGroupNotBetween(String value1, String value2) {
            addCriterion("message_group not between", value1, value2, "messageGroup");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIsNull() {
            addCriterion("message_key is null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIsNotNull() {
            addCriterion("message_key is not null");
            return (Criteria) this;
        }

        public Criteria andMessageKeyEqualTo(String value) {
            addCriterion("message_key =", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotEqualTo(String value) {
            addCriterion("message_key <>", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThan(String value) {
            addCriterion("message_key >", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyGreaterThanOrEqualTo(String value) {
            addCriterion("message_key >=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThan(String value) {
            addCriterion("message_key <", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLessThanOrEqualTo(String value) {
            addCriterion("message_key <=", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyLike(String value) {
            addCriterion("message_key like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotLike(String value) {
            addCriterion("message_key not like", value, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyIn(List<String> values) {
            addCriterion("message_key in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotIn(List<String> values) {
            addCriterion("message_key not in", values, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyBetween(String value1, String value2) {
            addCriterion("message_key between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageKeyNotBetween(String value1, String value2) {
            addCriterion("message_key not between", value1, value2, "messageKey");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIsNull() {
            addCriterion("message_topic is null");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIsNotNull() {
            addCriterion("message_topic is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTopicEqualTo(String value) {
            addCriterion("message_topic =", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotEqualTo(String value) {
            addCriterion("message_topic <>", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicGreaterThan(String value) {
            addCriterion("message_topic >", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicGreaterThanOrEqualTo(String value) {
            addCriterion("message_topic >=", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLessThan(String value) {
            addCriterion("message_topic <", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLessThanOrEqualTo(String value) {
            addCriterion("message_topic <=", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLike(String value) {
            addCriterion("message_topic like", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotLike(String value) {
            addCriterion("message_topic not like", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIn(List<String> values) {
            addCriterion("message_topic in", values, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotIn(List<String> values) {
            addCriterion("message_topic not in", values, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicBetween(String value1, String value2) {
            addCriterion("message_topic between", value1, value2, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotBetween(String value1, String value2) {
            addCriterion("message_topic not between", value1, value2, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTagIsNull() {
            addCriterion("message_tag is null");
            return (Criteria) this;
        }

        public Criteria andMessageTagIsNotNull() {
            addCriterion("message_tag is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTagEqualTo(String value) {
            addCriterion("message_tag =", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagNotEqualTo(String value) {
            addCriterion("message_tag <>", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagGreaterThan(String value) {
            addCriterion("message_tag >", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagGreaterThanOrEqualTo(String value) {
            addCriterion("message_tag >=", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagLessThan(String value) {
            addCriterion("message_tag <", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagLessThanOrEqualTo(String value) {
            addCriterion("message_tag <=", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagLike(String value) {
            addCriterion("message_tag like", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagNotLike(String value) {
            addCriterion("message_tag not like", value, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagIn(List<String> values) {
            addCriterion("message_tag in", values, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagNotIn(List<String> values) {
            addCriterion("message_tag not in", values, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagBetween(String value1, String value2) {
            addCriterion("message_tag between", value1, value2, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageTagNotBetween(String value1, String value2) {
            addCriterion("message_tag not between", value1, value2, "messageTag");
            return (Criteria) this;
        }

        public Criteria andMessageBodyIsNull() {
            addCriterion("message_body is null");
            return (Criteria) this;
        }

        public Criteria andMessageBodyIsNotNull() {
            addCriterion("message_body is not null");
            return (Criteria) this;
        }

        public Criteria andMessageBodyEqualTo(String value) {
            addCriterion("message_body =", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyNotEqualTo(String value) {
            addCriterion("message_body <>", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyGreaterThan(String value) {
            addCriterion("message_body >", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyGreaterThanOrEqualTo(String value) {
            addCriterion("message_body >=", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyLessThan(String value) {
            addCriterion("message_body <", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyLessThanOrEqualTo(String value) {
            addCriterion("message_body <=", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyLike(String value) {
            addCriterion("message_body like", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyNotLike(String value) {
            addCriterion("message_body not like", value, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyIn(List<String> values) {
            addCriterion("message_body in", values, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyNotIn(List<String> values) {
            addCriterion("message_body not in", values, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyBetween(String value1, String value2) {
            addCriterion("message_body between", value1, value2, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageBodyNotBetween(String value1, String value2) {
            addCriterion("message_body not between", value1, value2, "messageBody");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Byte value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Byte value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Byte value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Byte value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Byte value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Byte> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Byte> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Byte value1, Byte value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Byte value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Byte value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Byte value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Byte value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Byte> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Byte> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNull() {
            addCriterion("message_status is null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNotNull() {
            addCriterion("message_status is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusEqualTo(Byte value) {
            addCriterion("message_status =", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotEqualTo(Byte value) {
            addCriterion("message_status <>", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThan(Byte value) {
            addCriterion("message_status >", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_status >=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThan(Byte value) {
            addCriterion("message_status <", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThanOrEqualTo(Byte value) {
            addCriterion("message_status <=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIn(List<Byte> values) {
            addCriterion("message_status in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotIn(List<Byte> values) {
            addCriterion("message_status not in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusBetween(Byte value1, Byte value2) {
            addCriterion("message_status between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("message_status not between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andDelayLevelIsNull() {
            addCriterion("delay_level is null");
            return (Criteria) this;
        }

        public Criteria andDelayLevelIsNotNull() {
            addCriterion("delay_level is not null");
            return (Criteria) this;
        }

        public Criteria andDelayLevelEqualTo(Integer value) {
            addCriterion("delay_level =", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelNotEqualTo(Integer value) {
            addCriterion("delay_level <>", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelGreaterThan(Integer value) {
            addCriterion("delay_level >", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("delay_level >=", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelLessThan(Integer value) {
            addCriterion("delay_level <", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelLessThanOrEqualTo(Integer value) {
            addCriterion("delay_level <=", value, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelIn(List<Integer> values) {
            addCriterion("delay_level in", values, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelNotIn(List<Integer> values) {
            addCriterion("delay_level not in", values, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelBetween(Integer value1, Integer value2) {
            addCriterion("delay_level between", value1, value2, "delayLevel");
            return (Criteria) this;
        }

        public Criteria andDelayLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("delay_level not between", value1, value2, "delayLevel");
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