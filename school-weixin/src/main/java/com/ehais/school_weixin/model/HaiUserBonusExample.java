package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiUserBonusExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiUserBonusExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_bonus
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_user_bonus
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

		public Criteria andBonus_idIsNull() {
			addCriterion("bonus_id is null");
			return (Criteria) this;
		}

		public Criteria andBonus_idIsNotNull() {
			addCriterion("bonus_id is not null");
			return (Criteria) this;
		}

		public Criteria andBonus_idEqualTo(Integer value) {
			addCriterion("bonus_id =", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idNotEqualTo(Integer value) {
			addCriterion("bonus_id <>", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idGreaterThan(Integer value) {
			addCriterion("bonus_id >", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("bonus_id >=", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idLessThan(Integer value) {
			addCriterion("bonus_id <", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idLessThanOrEqualTo(Integer value) {
			addCriterion("bonus_id <=", value, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idIn(List<Integer> values) {
			addCriterion("bonus_id in", values, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idNotIn(List<Integer> values) {
			addCriterion("bonus_id not in", values, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idBetween(Integer value1, Integer value2) {
			addCriterion("bonus_id between", value1, value2, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_idNotBetween(Integer value1, Integer value2) {
			addCriterion("bonus_id not between", value1, value2, "bonus_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idIsNull() {
			addCriterion("bonus_type_id is null");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idIsNotNull() {
			addCriterion("bonus_type_id is not null");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idEqualTo(Byte value) {
			addCriterion("bonus_type_id =", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idNotEqualTo(Byte value) {
			addCriterion("bonus_type_id <>", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idGreaterThan(Byte value) {
			addCriterion("bonus_type_id >", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("bonus_type_id >=", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idLessThan(Byte value) {
			addCriterion("bonus_type_id <", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idLessThanOrEqualTo(Byte value) {
			addCriterion("bonus_type_id <=", value, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idIn(List<Byte> values) {
			addCriterion("bonus_type_id in", values, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idNotIn(List<Byte> values) {
			addCriterion("bonus_type_id not in", values, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idBetween(Byte value1, Byte value2) {
			addCriterion("bonus_type_id between", value1, value2, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_type_idNotBetween(Byte value1, Byte value2) {
			addCriterion("bonus_type_id not between", value1, value2, "bonus_type_id");
			return (Criteria) this;
		}

		public Criteria andBonus_snIsNull() {
			addCriterion("bonus_sn is null");
			return (Criteria) this;
		}

		public Criteria andBonus_snIsNotNull() {
			addCriterion("bonus_sn is not null");
			return (Criteria) this;
		}

		public Criteria andBonus_snEqualTo(Long value) {
			addCriterion("bonus_sn =", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snNotEqualTo(Long value) {
			addCriterion("bonus_sn <>", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snGreaterThan(Long value) {
			addCriterion("bonus_sn >", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snGreaterThanOrEqualTo(Long value) {
			addCriterion("bonus_sn >=", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snLessThan(Long value) {
			addCriterion("bonus_sn <", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snLessThanOrEqualTo(Long value) {
			addCriterion("bonus_sn <=", value, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snIn(List<Long> values) {
			addCriterion("bonus_sn in", values, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snNotIn(List<Long> values) {
			addCriterion("bonus_sn not in", values, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snBetween(Long value1, Long value2) {
			addCriterion("bonus_sn between", value1, value2, "bonus_sn");
			return (Criteria) this;
		}

		public Criteria andBonus_snNotBetween(Long value1, Long value2) {
			addCriterion("bonus_sn not between", value1, value2, "bonus_sn");
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

		public Criteria andUsed_timeIsNull() {
			addCriterion("used_time is null");
			return (Criteria) this;
		}

		public Criteria andUsed_timeIsNotNull() {
			addCriterion("used_time is not null");
			return (Criteria) this;
		}

		public Criteria andUsed_timeEqualTo(Integer value) {
			addCriterion("used_time =", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeNotEqualTo(Integer value) {
			addCriterion("used_time <>", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeGreaterThan(Integer value) {
			addCriterion("used_time >", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeGreaterThanOrEqualTo(Integer value) {
			addCriterion("used_time >=", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeLessThan(Integer value) {
			addCriterion("used_time <", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeLessThanOrEqualTo(Integer value) {
			addCriterion("used_time <=", value, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeIn(List<Integer> values) {
			addCriterion("used_time in", values, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeNotIn(List<Integer> values) {
			addCriterion("used_time not in", values, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeBetween(Integer value1, Integer value2) {
			addCriterion("used_time between", value1, value2, "used_time");
			return (Criteria) this;
		}

		public Criteria andUsed_timeNotBetween(Integer value1, Integer value2) {
			addCriterion("used_time not between", value1, value2, "used_time");
			return (Criteria) this;
		}

		public Criteria andOrder_idIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrder_idIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrder_idEqualTo(Integer value) {
			addCriterion("order_id =", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idGreaterThan(Integer value) {
			addCriterion("order_id >", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idLessThan(Integer value) {
			addCriterion("order_id <", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idIn(List<Integer> values) {
			addCriterion("order_id in", values, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "order_id");
			return (Criteria) this;
		}

		public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "order_id");
			return (Criteria) this;
		}

		public Criteria andEmailedIsNull() {
			addCriterion("emailed is null");
			return (Criteria) this;
		}

		public Criteria andEmailedIsNotNull() {
			addCriterion("emailed is not null");
			return (Criteria) this;
		}

		public Criteria andEmailedEqualTo(Byte value) {
			addCriterion("emailed =", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedNotEqualTo(Byte value) {
			addCriterion("emailed <>", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedGreaterThan(Byte value) {
			addCriterion("emailed >", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedGreaterThanOrEqualTo(Byte value) {
			addCriterion("emailed >=", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedLessThan(Byte value) {
			addCriterion("emailed <", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedLessThanOrEqualTo(Byte value) {
			addCriterion("emailed <=", value, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedIn(List<Byte> values) {
			addCriterion("emailed in", values, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedNotIn(List<Byte> values) {
			addCriterion("emailed not in", values, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedBetween(Byte value1, Byte value2) {
			addCriterion("emailed between", value1, value2, "emailed");
			return (Criteria) this;
		}

		public Criteria andEmailedNotBetween(Byte value1, Byte value2) {
			addCriterion("emailed not between", value1, value2, "emailed");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_user_bonus
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
     * This class corresponds to the database table hai_user_bonus
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}