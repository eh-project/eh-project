package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class WyMemberLevelExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public WyMemberLevelExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wy_member_level
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

		public Criteria andMember_level_idIsNull() {
			addCriterion("member_level_id is null");
			return (Criteria) this;
		}

		public Criteria andMember_level_idIsNotNull() {
			addCriterion("member_level_id is not null");
			return (Criteria) this;
		}

		public Criteria andMember_level_idEqualTo(Integer value) {
			addCriterion("member_level_id =", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idNotEqualTo(Integer value) {
			addCriterion("member_level_id <>", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idGreaterThan(Integer value) {
			addCriterion("member_level_id >", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_level_id >=", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idLessThan(Integer value) {
			addCriterion("member_level_id <", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idLessThanOrEqualTo(Integer value) {
			addCriterion("member_level_id <=", value, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idIn(List<Integer> values) {
			addCriterion("member_level_id in", values, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idNotIn(List<Integer> values) {
			addCriterion("member_level_id not in", values, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idBetween(Integer value1, Integer value2) {
			addCriterion("member_level_id between", value1, value2, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_idNotBetween(Integer value1, Integer value2) {
			addCriterion("member_level_id not between", value1, value2, "member_level_id");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeIsNull() {
			addCriterion("member_level_code is null");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeIsNotNull() {
			addCriterion("member_level_code is not null");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeEqualTo(String value) {
			addCriterion("member_level_code =", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeNotEqualTo(String value) {
			addCriterion("member_level_code <>", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeGreaterThan(String value) {
			addCriterion("member_level_code >", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeGreaterThanOrEqualTo(String value) {
			addCriterion("member_level_code >=", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeLessThan(String value) {
			addCriterion("member_level_code <", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeLessThanOrEqualTo(String value) {
			addCriterion("member_level_code <=", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeLike(String value) {
			addCriterion("member_level_code like", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeNotLike(String value) {
			addCriterion("member_level_code not like", value, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeIn(List<String> values) {
			addCriterion("member_level_code in", values, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeNotIn(List<String> values) {
			addCriterion("member_level_code not in", values, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeBetween(String value1, String value2) {
			addCriterion("member_level_code between", value1, value2, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_codeNotBetween(String value1, String value2) {
			addCriterion("member_level_code not between", value1, value2, "member_level_code");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameIsNull() {
			addCriterion("member_level_name is null");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameIsNotNull() {
			addCriterion("member_level_name is not null");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameEqualTo(String value) {
			addCriterion("member_level_name =", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameNotEqualTo(String value) {
			addCriterion("member_level_name <>", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameGreaterThan(String value) {
			addCriterion("member_level_name >", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameGreaterThanOrEqualTo(String value) {
			addCriterion("member_level_name >=", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameLessThan(String value) {
			addCriterion("member_level_name <", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameLessThanOrEqualTo(String value) {
			addCriterion("member_level_name <=", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameLike(String value) {
			addCriterion("member_level_name like", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameNotLike(String value) {
			addCriterion("member_level_name not like", value, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameIn(List<String> values) {
			addCriterion("member_level_name in", values, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameNotIn(List<String> values) {
			addCriterion("member_level_name not in", values, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameBetween(String value1, String value2) {
			addCriterion("member_level_name between", value1, value2, "member_level_name");
			return (Criteria) this;
		}

		public Criteria andMember_level_nameNotBetween(String value1, String value2) {
			addCriterion("member_level_name not between", value1, value2, "member_level_name");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wy_member_level
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
     * This class corresponds to the database table wy_member_level
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}