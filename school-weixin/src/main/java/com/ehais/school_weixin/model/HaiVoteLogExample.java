package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiVoteLogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiVoteLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_vote_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_vote_log
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

		public Criteria andLog_idIsNull() {
			addCriterion("log_id is null");
			return (Criteria) this;
		}

		public Criteria andLog_idIsNotNull() {
			addCriterion("log_id is not null");
			return (Criteria) this;
		}

		public Criteria andLog_idEqualTo(Integer value) {
			addCriterion("log_id =", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idNotEqualTo(Integer value) {
			addCriterion("log_id <>", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idGreaterThan(Integer value) {
			addCriterion("log_id >", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("log_id >=", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idLessThan(Integer value) {
			addCriterion("log_id <", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idLessThanOrEqualTo(Integer value) {
			addCriterion("log_id <=", value, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idIn(List<Integer> values) {
			addCriterion("log_id in", values, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idNotIn(List<Integer> values) {
			addCriterion("log_id not in", values, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idBetween(Integer value1, Integer value2) {
			addCriterion("log_id between", value1, value2, "log_id");
			return (Criteria) this;
		}

		public Criteria andLog_idNotBetween(Integer value1, Integer value2) {
			addCriterion("log_id not between", value1, value2, "log_id");
			return (Criteria) this;
		}

		public Criteria andVote_idIsNull() {
			addCriterion("vote_id is null");
			return (Criteria) this;
		}

		public Criteria andVote_idIsNotNull() {
			addCriterion("vote_id is not null");
			return (Criteria) this;
		}

		public Criteria andVote_idEqualTo(Short value) {
			addCriterion("vote_id =", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idNotEqualTo(Short value) {
			addCriterion("vote_id <>", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idGreaterThan(Short value) {
			addCriterion("vote_id >", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idGreaterThanOrEqualTo(Short value) {
			addCriterion("vote_id >=", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idLessThan(Short value) {
			addCriterion("vote_id <", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idLessThanOrEqualTo(Short value) {
			addCriterion("vote_id <=", value, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idIn(List<Short> values) {
			addCriterion("vote_id in", values, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idNotIn(List<Short> values) {
			addCriterion("vote_id not in", values, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idBetween(Short value1, Short value2) {
			addCriterion("vote_id between", value1, value2, "vote_id");
			return (Criteria) this;
		}

		public Criteria andVote_idNotBetween(Short value1, Short value2) {
			addCriterion("vote_id not between", value1, value2, "vote_id");
			return (Criteria) this;
		}

		public Criteria andIp_addressIsNull() {
			addCriterion("ip_address is null");
			return (Criteria) this;
		}

		public Criteria andIp_addressIsNotNull() {
			addCriterion("ip_address is not null");
			return (Criteria) this;
		}

		public Criteria andIp_addressEqualTo(String value) {
			addCriterion("ip_address =", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressNotEqualTo(String value) {
			addCriterion("ip_address <>", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressGreaterThan(String value) {
			addCriterion("ip_address >", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressGreaterThanOrEqualTo(String value) {
			addCriterion("ip_address >=", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressLessThan(String value) {
			addCriterion("ip_address <", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressLessThanOrEqualTo(String value) {
			addCriterion("ip_address <=", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressLike(String value) {
			addCriterion("ip_address like", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressNotLike(String value) {
			addCriterion("ip_address not like", value, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressIn(List<String> values) {
			addCriterion("ip_address in", values, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressNotIn(List<String> values) {
			addCriterion("ip_address not in", values, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressBetween(String value1, String value2) {
			addCriterion("ip_address between", value1, value2, "ip_address");
			return (Criteria) this;
		}

		public Criteria andIp_addressNotBetween(String value1, String value2) {
			addCriterion("ip_address not between", value1, value2, "ip_address");
			return (Criteria) this;
		}

		public Criteria andVote_timeIsNull() {
			addCriterion("vote_time is null");
			return (Criteria) this;
		}

		public Criteria andVote_timeIsNotNull() {
			addCriterion("vote_time is not null");
			return (Criteria) this;
		}

		public Criteria andVote_timeEqualTo(Integer value) {
			addCriterion("vote_time =", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeNotEqualTo(Integer value) {
			addCriterion("vote_time <>", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeGreaterThan(Integer value) {
			addCriterion("vote_time >", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeGreaterThanOrEqualTo(Integer value) {
			addCriterion("vote_time >=", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeLessThan(Integer value) {
			addCriterion("vote_time <", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeLessThanOrEqualTo(Integer value) {
			addCriterion("vote_time <=", value, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeIn(List<Integer> values) {
			addCriterion("vote_time in", values, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeNotIn(List<Integer> values) {
			addCriterion("vote_time not in", values, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeBetween(Integer value1, Integer value2) {
			addCriterion("vote_time between", value1, value2, "vote_time");
			return (Criteria) this;
		}

		public Criteria andVote_timeNotBetween(Integer value1, Integer value2) {
			addCriterion("vote_time not between", value1, value2, "vote_time");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_vote_log
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
     * This class corresponds to the database table hai_vote_log
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}