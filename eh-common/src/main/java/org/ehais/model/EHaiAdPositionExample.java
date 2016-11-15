package org.ehais.model;

import java.util.ArrayList;
import java.util.List;
import org.ehais.tools.CriteriaObject;

public class EHaiAdPositionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected Integer start;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected Integer len;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public EHaiAdPositionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void setStart(Integer start) {
        this.start=start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public Integer getStart() {
        return start;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void setLen(Integer len) {
        this.len=len;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public Integer getLen() {
        return len;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
    public void CriteriaStoreId(Criteria c, CriteriaObject co) {
        if(co == null || co.getOperator() == null)return ;
        if(co.getOperator().equals("eq")){
            c.andStoreIdEqualTo(co.getStoreId());
        }else if(co.getOperator().equals("in")){
            c.andStoreIdIn(co.getStoreList());
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
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

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Short value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Short value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Short value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Short value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Short value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Short value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Short> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Short> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Short value1, Short value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Short value1, Short value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNull() {
            addCriterion("position_code is null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIsNotNull() {
            addCriterion("position_code is not null");
            return (Criteria) this;
        }

        public Criteria andPositionCodeEqualTo(String value) {
            addCriterion("position_code =", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotEqualTo(String value) {
            addCriterion("position_code <>", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThan(String value) {
            addCriterion("position_code >", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("position_code >=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThan(String value) {
            addCriterion("position_code <", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("position_code <=", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeLike(String value) {
            addCriterion("position_code like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotLike(String value) {
            addCriterion("position_code not like", value, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeIn(List<String> values) {
            addCriterion("position_code in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotIn(List<String> values) {
            addCriterion("position_code not in", values, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeBetween(String value1, String value2) {
            addCriterion("position_code between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionCodeNotBetween(String value1, String value2) {
            addCriterion("position_code not between", value1, value2, "positionCode");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andAdWidthIsNull() {
            addCriterion("ad_width is null");
            return (Criteria) this;
        }

        public Criteria andAdWidthIsNotNull() {
            addCriterion("ad_width is not null");
            return (Criteria) this;
        }

        public Criteria andAdWidthEqualTo(Short value) {
            addCriterion("ad_width =", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthNotEqualTo(Short value) {
            addCriterion("ad_width <>", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthGreaterThan(Short value) {
            addCriterion("ad_width >", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthGreaterThanOrEqualTo(Short value) {
            addCriterion("ad_width >=", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthLessThan(Short value) {
            addCriterion("ad_width <", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthLessThanOrEqualTo(Short value) {
            addCriterion("ad_width <=", value, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthIn(List<Short> values) {
            addCriterion("ad_width in", values, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthNotIn(List<Short> values) {
            addCriterion("ad_width not in", values, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthBetween(Short value1, Short value2) {
            addCriterion("ad_width between", value1, value2, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdWidthNotBetween(Short value1, Short value2) {
            addCriterion("ad_width not between", value1, value2, "adWidth");
            return (Criteria) this;
        }

        public Criteria andAdHeightIsNull() {
            addCriterion("ad_height is null");
            return (Criteria) this;
        }

        public Criteria andAdHeightIsNotNull() {
            addCriterion("ad_height is not null");
            return (Criteria) this;
        }

        public Criteria andAdHeightEqualTo(Short value) {
            addCriterion("ad_height =", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightNotEqualTo(Short value) {
            addCriterion("ad_height <>", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightGreaterThan(Short value) {
            addCriterion("ad_height >", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightGreaterThanOrEqualTo(Short value) {
            addCriterion("ad_height >=", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightLessThan(Short value) {
            addCriterion("ad_height <", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightLessThanOrEqualTo(Short value) {
            addCriterion("ad_height <=", value, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightIn(List<Short> values) {
            addCriterion("ad_height in", values, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightNotIn(List<Short> values) {
            addCriterion("ad_height not in", values, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightBetween(Short value1, Short value2) {
            addCriterion("ad_height between", value1, value2, "adHeight");
            return (Criteria) this;
        }

        public Criteria andAdHeightNotBetween(Short value1, Short value2) {
            addCriterion("ad_height not between", value1, value2, "adHeight");
            return (Criteria) this;
        }

        public Criteria andPositionDescIsNull() {
            addCriterion("position_desc is null");
            return (Criteria) this;
        }

        public Criteria andPositionDescIsNotNull() {
            addCriterion("position_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDescEqualTo(String value) {
            addCriterion("position_desc =", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotEqualTo(String value) {
            addCriterion("position_desc <>", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescGreaterThan(String value) {
            addCriterion("position_desc >", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescGreaterThanOrEqualTo(String value) {
            addCriterion("position_desc >=", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLessThan(String value) {
            addCriterion("position_desc <", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLessThanOrEqualTo(String value) {
            addCriterion("position_desc <=", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescLike(String value) {
            addCriterion("position_desc like", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotLike(String value) {
            addCriterion("position_desc not like", value, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescIn(List<String> values) {
            addCriterion("position_desc in", values, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotIn(List<String> values) {
            addCriterion("position_desc not in", values, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescBetween(String value1, String value2) {
            addCriterion("position_desc between", value1, value2, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andPositionDescNotBetween(String value1, String value2) {
            addCriterion("position_desc not between", value1, value2, "positionDesc");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_ad_position
     *
     * @mbggenerated do_not_delete_during_merge Thu Apr 14 20:51:47 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andPositionCodeLikeInsensitive(String value) {
            addCriterion("upper(position_code) like", value.toUpperCase(), "positionCode");
            return this;
        }

        public Criteria andPositionNameLikeInsensitive(String value) {
            addCriterion("upper(position_name) like", value.toUpperCase(), "positionName");
            return this;
        }

        public Criteria andPositionDescLikeInsensitive(String value) {
            addCriterion("upper(position_desc) like", value.toUpperCase(), "positionDesc");
            return this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_ad_position
     *
     * @mbggenerated Thu Apr 14 20:51:47 CST 2016
     */
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