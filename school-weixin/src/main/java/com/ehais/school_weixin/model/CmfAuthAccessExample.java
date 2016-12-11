package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class CmfAuthAccessExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public CmfAuthAccessExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_auth_access
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_auth_access
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

		public Criteria andRole_idIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRole_idIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRole_idEqualTo(Integer value) {
			addCriterion("role_id =", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idNotEqualTo(Integer value) {
			addCriterion("role_id <>", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idGreaterThan(Integer value) {
			addCriterion("role_id >", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("role_id >=", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idLessThan(Integer value) {
			addCriterion("role_id <", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idLessThanOrEqualTo(Integer value) {
			addCriterion("role_id <=", value, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idIn(List<Integer> values) {
			addCriterion("role_id in", values, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idNotIn(List<Integer> values) {
			addCriterion("role_id not in", values, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idBetween(Integer value1, Integer value2) {
			addCriterion("role_id between", value1, value2, "role_id");
			return (Criteria) this;
		}

		public Criteria andRole_idNotBetween(Integer value1, Integer value2) {
			addCriterion("role_id not between", value1, value2, "role_id");
			return (Criteria) this;
		}

		public Criteria andRule_nameIsNull() {
			addCriterion("rule_name is null");
			return (Criteria) this;
		}

		public Criteria andRule_nameIsNotNull() {
			addCriterion("rule_name is not null");
			return (Criteria) this;
		}

		public Criteria andRule_nameEqualTo(String value) {
			addCriterion("rule_name =", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameNotEqualTo(String value) {
			addCriterion("rule_name <>", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameGreaterThan(String value) {
			addCriterion("rule_name >", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameGreaterThanOrEqualTo(String value) {
			addCriterion("rule_name >=", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameLessThan(String value) {
			addCriterion("rule_name <", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameLessThanOrEqualTo(String value) {
			addCriterion("rule_name <=", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameLike(String value) {
			addCriterion("rule_name like", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameNotLike(String value) {
			addCriterion("rule_name not like", value, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameIn(List<String> values) {
			addCriterion("rule_name in", values, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameNotIn(List<String> values) {
			addCriterion("rule_name not in", values, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameBetween(String value1, String value2) {
			addCriterion("rule_name between", value1, value2, "rule_name");
			return (Criteria) this;
		}

		public Criteria andRule_nameNotBetween(String value1, String value2) {
			addCriterion("rule_name not between", value1, value2, "rule_name");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_auth_access
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
     * This class corresponds to the database table cmf_auth_access
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}