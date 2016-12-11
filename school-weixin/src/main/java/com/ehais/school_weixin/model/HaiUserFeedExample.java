package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiUserFeedExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiUserFeedExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
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

		public Criteria andFeed_idIsNull() {
			addCriterion("feed_id is null");
			return (Criteria) this;
		}

		public Criteria andFeed_idIsNotNull() {
			addCriterion("feed_id is not null");
			return (Criteria) this;
		}

		public Criteria andFeed_idEqualTo(Integer value) {
			addCriterion("feed_id =", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idNotEqualTo(Integer value) {
			addCriterion("feed_id <>", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idGreaterThan(Integer value) {
			addCriterion("feed_id >", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("feed_id >=", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idLessThan(Integer value) {
			addCriterion("feed_id <", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idLessThanOrEqualTo(Integer value) {
			addCriterion("feed_id <=", value, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idIn(List<Integer> values) {
			addCriterion("feed_id in", values, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idNotIn(List<Integer> values) {
			addCriterion("feed_id not in", values, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idBetween(Integer value1, Integer value2) {
			addCriterion("feed_id between", value1, value2, "feed_id");
			return (Criteria) this;
		}

		public Criteria andFeed_idNotBetween(Integer value1, Integer value2) {
			addCriterion("feed_id not between", value1, value2, "feed_id");
			return (Criteria) this;
		}

		public Criteria andUser_idIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUser_idIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUser_idEqualTo(Integer value) {
			addCriterion("user_id =", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThan(Integer value) {
			addCriterion("user_id >", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThan(Integer value) {
			addCriterion("user_id <", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idIn(List<Integer> values) {
			addCriterion("user_id in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andValue_idIsNull() {
			addCriterion("value_id is null");
			return (Criteria) this;
		}

		public Criteria andValue_idIsNotNull() {
			addCriterion("value_id is not null");
			return (Criteria) this;
		}

		public Criteria andValue_idEqualTo(Integer value) {
			addCriterion("value_id =", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idNotEqualTo(Integer value) {
			addCriterion("value_id <>", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idGreaterThan(Integer value) {
			addCriterion("value_id >", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("value_id >=", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idLessThan(Integer value) {
			addCriterion("value_id <", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idLessThanOrEqualTo(Integer value) {
			addCriterion("value_id <=", value, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idIn(List<Integer> values) {
			addCriterion("value_id in", values, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idNotIn(List<Integer> values) {
			addCriterion("value_id not in", values, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idBetween(Integer value1, Integer value2) {
			addCriterion("value_id between", value1, value2, "value_id");
			return (Criteria) this;
		}

		public Criteria andValue_idNotBetween(Integer value1, Integer value2) {
			addCriterion("value_id not between", value1, value2, "value_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoods_idIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoods_idEqualTo(Integer value) {
			addCriterion("goods_id =", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotEqualTo(Integer value) {
			addCriterion("goods_id <>", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThan(Integer value) {
			addCriterion("goods_id >", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_id >=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThan(Integer value) {
			addCriterion("goods_id <", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThanOrEqualTo(Integer value) {
			addCriterion("goods_id <=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idIn(List<Integer> values) {
			addCriterion("goods_id in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotIn(List<Integer> values) {
			addCriterion("goods_id not in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idBetween(Integer value1, Integer value2) {
			addCriterion("goods_id between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_id not between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andFeed_typeIsNull() {
			addCriterion("feed_type is null");
			return (Criteria) this;
		}

		public Criteria andFeed_typeIsNotNull() {
			addCriterion("feed_type is not null");
			return (Criteria) this;
		}

		public Criteria andFeed_typeEqualTo(Boolean value) {
			addCriterion("feed_type =", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeNotEqualTo(Boolean value) {
			addCriterion("feed_type <>", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeGreaterThan(Boolean value) {
			addCriterion("feed_type >", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("feed_type >=", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeLessThan(Boolean value) {
			addCriterion("feed_type <", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeLessThanOrEqualTo(Boolean value) {
			addCriterion("feed_type <=", value, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeIn(List<Boolean> values) {
			addCriterion("feed_type in", values, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeNotIn(List<Boolean> values) {
			addCriterion("feed_type not in", values, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeBetween(Boolean value1, Boolean value2) {
			addCriterion("feed_type between", value1, value2, "feed_type");
			return (Criteria) this;
		}

		public Criteria andFeed_typeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("feed_type not between", value1, value2, "feed_type");
			return (Criteria) this;
		}

		public Criteria andIs_feedIsNull() {
			addCriterion("is_feed is null");
			return (Criteria) this;
		}

		public Criteria andIs_feedIsNotNull() {
			addCriterion("is_feed is not null");
			return (Criteria) this;
		}

		public Criteria andIs_feedEqualTo(Boolean value) {
			addCriterion("is_feed =", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedNotEqualTo(Boolean value) {
			addCriterion("is_feed <>", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedGreaterThan(Boolean value) {
			addCriterion("is_feed >", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_feed >=", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedLessThan(Boolean value) {
			addCriterion("is_feed <", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_feed <=", value, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedIn(List<Boolean> values) {
			addCriterion("is_feed in", values, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedNotIn(List<Boolean> values) {
			addCriterion("is_feed not in", values, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_feed between", value1, value2, "is_feed");
			return (Criteria) this;
		}

		public Criteria andIs_feedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_feed not between", value1, value2, "is_feed");
			return (Criteria) this;
		}

		public Criteria andStore_idIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStore_idIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStore_idEqualTo(Integer value) {
			addCriterion("store_id =", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idNotEqualTo(Integer value) {
			addCriterion("store_id <>", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idGreaterThan(Integer value) {
			addCriterion("store_id >", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("store_id >=", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idLessThan(Integer value) {
			addCriterion("store_id <", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idLessThanOrEqualTo(Integer value) {
			addCriterion("store_id <=", value, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idIn(List<Integer> values) {
			addCriterion("store_id in", values, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idNotIn(List<Integer> values) {
			addCriterion("store_id not in", values, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idBetween(Integer value1, Integer value2) {
			addCriterion("store_id between", value1, value2, "store_id");
			return (Criteria) this;
		}

		public Criteria andStore_idNotBetween(Integer value1, Integer value2) {
			addCriterion("store_id not between", value1, value2, "store_id");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_user_feed
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_user_feed
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}