package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiAdminMessageExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiAdminMessageExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_admin_message
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

		public Criteria andMessage_idIsNull() {
			addCriterion("message_id is null");
			return (Criteria) this;
		}

		public Criteria andMessage_idIsNotNull() {
			addCriterion("message_id is not null");
			return (Criteria) this;
		}

		public Criteria andMessage_idEqualTo(Short value) {
			addCriterion("message_id =", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idNotEqualTo(Short value) {
			addCriterion("message_id <>", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idGreaterThan(Short value) {
			addCriterion("message_id >", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idGreaterThanOrEqualTo(Short value) {
			addCriterion("message_id >=", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idLessThan(Short value) {
			addCriterion("message_id <", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idLessThanOrEqualTo(Short value) {
			addCriterion("message_id <=", value, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idIn(List<Short> values) {
			addCriterion("message_id in", values, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idNotIn(List<Short> values) {
			addCriterion("message_id not in", values, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idBetween(Short value1, Short value2) {
			addCriterion("message_id between", value1, value2, "message_id");
			return (Criteria) this;
		}

		public Criteria andMessage_idNotBetween(Short value1, Short value2) {
			addCriterion("message_id not between", value1, value2, "message_id");
			return (Criteria) this;
		}

		public Criteria andSender_idIsNull() {
			addCriterion("sender_id is null");
			return (Criteria) this;
		}

		public Criteria andSender_idIsNotNull() {
			addCriterion("sender_id is not null");
			return (Criteria) this;
		}

		public Criteria andSender_idEqualTo(Byte value) {
			addCriterion("sender_id =", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idNotEqualTo(Byte value) {
			addCriterion("sender_id <>", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idGreaterThan(Byte value) {
			addCriterion("sender_id >", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("sender_id >=", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idLessThan(Byte value) {
			addCriterion("sender_id <", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idLessThanOrEqualTo(Byte value) {
			addCriterion("sender_id <=", value, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idIn(List<Byte> values) {
			addCriterion("sender_id in", values, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idNotIn(List<Byte> values) {
			addCriterion("sender_id not in", values, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idBetween(Byte value1, Byte value2) {
			addCriterion("sender_id between", value1, value2, "sender_id");
			return (Criteria) this;
		}

		public Criteria andSender_idNotBetween(Byte value1, Byte value2) {
			addCriterion("sender_id not between", value1, value2, "sender_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idIsNull() {
			addCriterion("receiver_id is null");
			return (Criteria) this;
		}

		public Criteria andReceiver_idIsNotNull() {
			addCriterion("receiver_id is not null");
			return (Criteria) this;
		}

		public Criteria andReceiver_idEqualTo(Byte value) {
			addCriterion("receiver_id =", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idNotEqualTo(Byte value) {
			addCriterion("receiver_id <>", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idGreaterThan(Byte value) {
			addCriterion("receiver_id >", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("receiver_id >=", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idLessThan(Byte value) {
			addCriterion("receiver_id <", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idLessThanOrEqualTo(Byte value) {
			addCriterion("receiver_id <=", value, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idIn(List<Byte> values) {
			addCriterion("receiver_id in", values, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idNotIn(List<Byte> values) {
			addCriterion("receiver_id not in", values, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idBetween(Byte value1, Byte value2) {
			addCriterion("receiver_id between", value1, value2, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andReceiver_idNotBetween(Byte value1, Byte value2) {
			addCriterion("receiver_id not between", value1, value2, "receiver_id");
			return (Criteria) this;
		}

		public Criteria andSent_timeIsNull() {
			addCriterion("sent_time is null");
			return (Criteria) this;
		}

		public Criteria andSent_timeIsNotNull() {
			addCriterion("sent_time is not null");
			return (Criteria) this;
		}

		public Criteria andSent_timeEqualTo(Integer value) {
			addCriterion("sent_time =", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeNotEqualTo(Integer value) {
			addCriterion("sent_time <>", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeGreaterThan(Integer value) {
			addCriterion("sent_time >", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeGreaterThanOrEqualTo(Integer value) {
			addCriterion("sent_time >=", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeLessThan(Integer value) {
			addCriterion("sent_time <", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeLessThanOrEqualTo(Integer value) {
			addCriterion("sent_time <=", value, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeIn(List<Integer> values) {
			addCriterion("sent_time in", values, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeNotIn(List<Integer> values) {
			addCriterion("sent_time not in", values, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeBetween(Integer value1, Integer value2) {
			addCriterion("sent_time between", value1, value2, "sent_time");
			return (Criteria) this;
		}

		public Criteria andSent_timeNotBetween(Integer value1, Integer value2) {
			addCriterion("sent_time not between", value1, value2, "sent_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeIsNull() {
			addCriterion("read_time is null");
			return (Criteria) this;
		}

		public Criteria andRead_timeIsNotNull() {
			addCriterion("read_time is not null");
			return (Criteria) this;
		}

		public Criteria andRead_timeEqualTo(Integer value) {
			addCriterion("read_time =", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeNotEqualTo(Integer value) {
			addCriterion("read_time <>", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeGreaterThan(Integer value) {
			addCriterion("read_time >", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeGreaterThanOrEqualTo(Integer value) {
			addCriterion("read_time >=", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeLessThan(Integer value) {
			addCriterion("read_time <", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeLessThanOrEqualTo(Integer value) {
			addCriterion("read_time <=", value, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeIn(List<Integer> values) {
			addCriterion("read_time in", values, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeNotIn(List<Integer> values) {
			addCriterion("read_time not in", values, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeBetween(Integer value1, Integer value2) {
			addCriterion("read_time between", value1, value2, "read_time");
			return (Criteria) this;
		}

		public Criteria andRead_timeNotBetween(Integer value1, Integer value2) {
			addCriterion("read_time not between", value1, value2, "read_time");
			return (Criteria) this;
		}

		public Criteria andReadedIsNull() {
			addCriterion("readed is null");
			return (Criteria) this;
		}

		public Criteria andReadedIsNotNull() {
			addCriterion("readed is not null");
			return (Criteria) this;
		}

		public Criteria andReadedEqualTo(Boolean value) {
			addCriterion("readed =", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedNotEqualTo(Boolean value) {
			addCriterion("readed <>", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedGreaterThan(Boolean value) {
			addCriterion("readed >", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("readed >=", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedLessThan(Boolean value) {
			addCriterion("readed <", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedLessThanOrEqualTo(Boolean value) {
			addCriterion("readed <=", value, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedIn(List<Boolean> values) {
			addCriterion("readed in", values, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedNotIn(List<Boolean> values) {
			addCriterion("readed not in", values, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedBetween(Boolean value1, Boolean value2) {
			addCriterion("readed between", value1, value2, "readed");
			return (Criteria) this;
		}

		public Criteria andReadedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("readed not between", value1, value2, "readed");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNull() {
			addCriterion("deleted is null");
			return (Criteria) this;
		}

		public Criteria andDeletedIsNotNull() {
			addCriterion("deleted is not null");
			return (Criteria) this;
		}

		public Criteria andDeletedEqualTo(Boolean value) {
			addCriterion("deleted =", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotEqualTo(Boolean value) {
			addCriterion("deleted <>", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThan(Boolean value) {
			addCriterion("deleted >", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("deleted >=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThan(Boolean value) {
			addCriterion("deleted <", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
			addCriterion("deleted <=", value, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedIn(List<Boolean> values) {
			addCriterion("deleted in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotIn(List<Boolean> values) {
			addCriterion("deleted not in", values, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
			addCriterion("deleted between", value1, value2, "deleted");
			return (Criteria) this;
		}

		public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("deleted not between", value1, value2, "deleted");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_admin_message
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
     * This class corresponds to the database table hai_admin_message
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}