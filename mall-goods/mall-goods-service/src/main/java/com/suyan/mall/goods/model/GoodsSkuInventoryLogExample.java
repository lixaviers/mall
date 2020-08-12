package com.suyan.mall.goods.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GoodsSkuInventoryLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsSkuInventoryLogExample() {
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

        public Criteria andInventoryWayIsNull() {
            addCriterion("inventory_way is null");
            return (Criteria) this;
        }

        public Criteria andInventoryWayIsNotNull() {
            addCriterion("inventory_way is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryWayEqualTo(Byte value) {
            addCriterion("inventory_way =", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayNotEqualTo(Byte value) {
            addCriterion("inventory_way <>", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayGreaterThan(Byte value) {
            addCriterion("inventory_way >", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("inventory_way >=", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayLessThan(Byte value) {
            addCriterion("inventory_way <", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayLessThanOrEqualTo(Byte value) {
            addCriterion("inventory_way <=", value, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayIn(List<Byte> values) {
            addCriterion("inventory_way in", values, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayNotIn(List<Byte> values) {
            addCriterion("inventory_way not in", values, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayBetween(Byte value1, Byte value2) {
            addCriterion("inventory_way between", value1, value2, "inventoryWay");
            return (Criteria) this;
        }

        public Criteria andInventoryWayNotBetween(Byte value1, Byte value2) {
            addCriterion("inventory_way not between", value1, value2, "inventoryWay");
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

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Byte value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Byte value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Byte value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Byte value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Byte value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Byte> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Byte> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Byte value1, Byte value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIsNull() {
            addCriterion("associated_id is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIsNotNull() {
            addCriterion("associated_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdEqualTo(Long value) {
            addCriterion("associated_id =", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotEqualTo(Long value) {
            addCriterion("associated_id <>", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThan(Long value) {
            addCriterion("associated_id >", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("associated_id >=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThan(Long value) {
            addCriterion("associated_id <", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdLessThanOrEqualTo(Long value) {
            addCriterion("associated_id <=", value, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdIn(List<Long> values) {
            addCriterion("associated_id in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotIn(List<Long> values) {
            addCriterion("associated_id not in", values, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdBetween(Long value1, Long value2) {
            addCriterion("associated_id between", value1, value2, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedIdNotBetween(Long value1, Long value2) {
            addCriterion("associated_id not between", value1, value2, "associatedId");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescIsNull() {
            addCriterion("associated_desc is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescIsNotNull() {
            addCriterion("associated_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescEqualTo(String value) {
            addCriterion("associated_desc =", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescNotEqualTo(String value) {
            addCriterion("associated_desc <>", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescGreaterThan(String value) {
            addCriterion("associated_desc >", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescGreaterThanOrEqualTo(String value) {
            addCriterion("associated_desc >=", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescLessThan(String value) {
            addCriterion("associated_desc <", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescLessThanOrEqualTo(String value) {
            addCriterion("associated_desc <=", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescLike(String value) {
            addCriterion("associated_desc like", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescNotLike(String value) {
            addCriterion("associated_desc not like", value, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescIn(List<String> values) {
            addCriterion("associated_desc in", values, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescNotIn(List<String> values) {
            addCriterion("associated_desc not in", values, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescBetween(String value1, String value2) {
            addCriterion("associated_desc between", value1, value2, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andAssociatedDescNotBetween(String value1, String value2) {
            addCriterion("associated_desc not between", value1, value2, "associatedDesc");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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