package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProWorkLogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public ProWorkLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table pro_work_log
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andWork_idIsNull() {
			addCriterion("work_id is null");
			return (Criteria) this;
		}

		public Criteria andWork_idIsNotNull() {
			addCriterion("work_id is not null");
			return (Criteria) this;
		}

		public Criteria andWork_idEqualTo(Integer value) {
			addCriterion("work_id =", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idNotEqualTo(Integer value) {
			addCriterion("work_id <>", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idGreaterThan(Integer value) {
			addCriterion("work_id >", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("work_id >=", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idLessThan(Integer value) {
			addCriterion("work_id <", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idLessThanOrEqualTo(Integer value) {
			addCriterion("work_id <=", value, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idIn(List<Integer> values) {
			addCriterion("work_id in", values, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idNotIn(List<Integer> values) {
			addCriterion("work_id not in", values, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idBetween(Integer value1, Integer value2) {
			addCriterion("work_id between", value1, value2, "work_id");
			return (Criteria) this;
		}

		public Criteria andWork_idNotBetween(Integer value1, Integer value2) {
			addCriterion("work_id not between", value1, value2, "work_id");
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

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Short value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Short value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Short value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Short value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Short value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Short value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Short> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Short> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Short value1, Short value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Short value1, Short value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andWork_dateIsNull() {
			addCriterion("work_date is null");
			return (Criteria) this;
		}

		public Criteria andWork_dateIsNotNull() {
			addCriterion("work_date is not null");
			return (Criteria) this;
		}

		public Criteria andWork_dateEqualTo(Date value) {
			addCriterionForJDBCDate("work_date =", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("work_date <>", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("work_date >", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("work_date >=", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateLessThan(Date value) {
			addCriterionForJDBCDate("work_date <", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("work_date <=", value, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateIn(List<Date> values) {
			addCriterionForJDBCDate("work_date in", values, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("work_date not in", values, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("work_date between", value1, value2, "work_date");
			return (Criteria) this;
		}

		public Criteria andWork_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("work_date not between", value1, value2, "work_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreate_dateEqualTo(Date value) {
			addCriterion("create_date =", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateGreaterThan(Date value) {
			addCriterion("create_date >", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateLessThan(Date value) {
			addCriterion("create_date <", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateIn(List<Date> values) {
			addCriterion("create_date in", values, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "create_date");
			return (Criteria) this;
		}

		public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "create_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateEqualTo(Date value) {
			addCriterion("update_date =", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotEqualTo(Date value) {
			addCriterion("update_date <>", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateGreaterThan(Date value) {
			addCriterion("update_date >", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("update_date >=", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateLessThan(Date value) {
			addCriterion("update_date <", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateLessThanOrEqualTo(Date value) {
			addCriterion("update_date <=", value, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateIn(List<Date> values) {
			addCriterion("update_date in", values, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotIn(List<Date> values) {
			addCriterion("update_date not in", values, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateBetween(Date value1, Date value2) {
			addCriterion("update_date between", value1, value2, "update_date");
			return (Criteria) this;
		}

		public Criteria andUpdate_dateNotBetween(Date value1, Date value2) {
			addCriterion("update_date not between", value1, value2, "update_date");
			return (Criteria) this;
		}

		public Criteria andPro_idIsNull() {
			addCriterion("pro_id is null");
			return (Criteria) this;
		}

		public Criteria andPro_idIsNotNull() {
			addCriterion("pro_id is not null");
			return (Criteria) this;
		}

		public Criteria andPro_idEqualTo(Integer value) {
			addCriterion("pro_id =", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idNotEqualTo(Integer value) {
			addCriterion("pro_id <>", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idGreaterThan(Integer value) {
			addCriterion("pro_id >", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("pro_id >=", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idLessThan(Integer value) {
			addCriterion("pro_id <", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idLessThanOrEqualTo(Integer value) {
			addCriterion("pro_id <=", value, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idIn(List<Integer> values) {
			addCriterion("pro_id in", values, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idNotIn(List<Integer> values) {
			addCriterion("pro_id not in", values, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idBetween(Integer value1, Integer value2) {
			addCriterion("pro_id between", value1, value2, "pro_id");
			return (Criteria) this;
		}

		public Criteria andPro_idNotBetween(Integer value1, Integer value2) {
			addCriterion("pro_id not between", value1, value2, "pro_id");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table pro_work_log
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
     * This class corresponds to the database table pro_work_log
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}