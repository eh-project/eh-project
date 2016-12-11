package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiAdminActionExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiAdminActionExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_action
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_admin_action
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

		public Criteria andAction_idIsNull() {
			addCriterion("action_id is null");
			return (Criteria) this;
		}

		public Criteria andAction_idIsNotNull() {
			addCriterion("action_id is not null");
			return (Criteria) this;
		}

		public Criteria andAction_idEqualTo(Byte value) {
			addCriterion("action_id =", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idNotEqualTo(Byte value) {
			addCriterion("action_id <>", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idGreaterThan(Byte value) {
			addCriterion("action_id >", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("action_id >=", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idLessThan(Byte value) {
			addCriterion("action_id <", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idLessThanOrEqualTo(Byte value) {
			addCriterion("action_id <=", value, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idIn(List<Byte> values) {
			addCriterion("action_id in", values, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idNotIn(List<Byte> values) {
			addCriterion("action_id not in", values, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idBetween(Byte value1, Byte value2) {
			addCriterion("action_id between", value1, value2, "action_id");
			return (Criteria) this;
		}

		public Criteria andAction_idNotBetween(Byte value1, Byte value2) {
			addCriterion("action_id not between", value1, value2, "action_id");
			return (Criteria) this;
		}

		public Criteria andParent_idIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParent_idIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParent_idEqualTo(Byte value) {
			addCriterion("parent_id =", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotEqualTo(Byte value) {
			addCriterion("parent_id <>", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idGreaterThan(Byte value) {
			addCriterion("parent_id >", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("parent_id >=", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idLessThan(Byte value) {
			addCriterion("parent_id <", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idLessThanOrEqualTo(Byte value) {
			addCriterion("parent_id <=", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idIn(List<Byte> values) {
			addCriterion("parent_id in", values, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotIn(List<Byte> values) {
			addCriterion("parent_id not in", values, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idBetween(Byte value1, Byte value2) {
			addCriterion("parent_id between", value1, value2, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotBetween(Byte value1, Byte value2) {
			addCriterion("parent_id not between", value1, value2, "parent_id");
			return (Criteria) this;
		}

		public Criteria andAction_codeIsNull() {
			addCriterion("action_code is null");
			return (Criteria) this;
		}

		public Criteria andAction_codeIsNotNull() {
			addCriterion("action_code is not null");
			return (Criteria) this;
		}

		public Criteria andAction_codeEqualTo(String value) {
			addCriterion("action_code =", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeNotEqualTo(String value) {
			addCriterion("action_code <>", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeGreaterThan(String value) {
			addCriterion("action_code >", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeGreaterThanOrEqualTo(String value) {
			addCriterion("action_code >=", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeLessThan(String value) {
			addCriterion("action_code <", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeLessThanOrEqualTo(String value) {
			addCriterion("action_code <=", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeLike(String value) {
			addCriterion("action_code like", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeNotLike(String value) {
			addCriterion("action_code not like", value, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeIn(List<String> values) {
			addCriterion("action_code in", values, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeNotIn(List<String> values) {
			addCriterion("action_code not in", values, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeBetween(String value1, String value2) {
			addCriterion("action_code between", value1, value2, "action_code");
			return (Criteria) this;
		}

		public Criteria andAction_codeNotBetween(String value1, String value2) {
			addCriterion("action_code not between", value1, value2, "action_code");
			return (Criteria) this;
		}

		public Criteria andRelevanceIsNull() {
			addCriterion("relevance is null");
			return (Criteria) this;
		}

		public Criteria andRelevanceIsNotNull() {
			addCriterion("relevance is not null");
			return (Criteria) this;
		}

		public Criteria andRelevanceEqualTo(String value) {
			addCriterion("relevance =", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceNotEqualTo(String value) {
			addCriterion("relevance <>", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceGreaterThan(String value) {
			addCriterion("relevance >", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceGreaterThanOrEqualTo(String value) {
			addCriterion("relevance >=", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceLessThan(String value) {
			addCriterion("relevance <", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceLessThanOrEqualTo(String value) {
			addCriterion("relevance <=", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceLike(String value) {
			addCriterion("relevance like", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceNotLike(String value) {
			addCriterion("relevance not like", value, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceIn(List<String> values) {
			addCriterion("relevance in", values, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceNotIn(List<String> values) {
			addCriterion("relevance not in", values, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceBetween(String value1, String value2) {
			addCriterion("relevance between", value1, value2, "relevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceNotBetween(String value1, String value2) {
			addCriterion("relevance not between", value1, value2, "relevance");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_admin_action
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
     * This class corresponds to the database table hai_admin_action
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}