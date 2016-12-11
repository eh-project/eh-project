package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HaiTimeAxisnExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiTimeAxisnExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_time_axisn
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

		public Criteria andTime_idIsNull() {
			addCriterion("time_id is null");
			return (Criteria) this;
		}

		public Criteria andTime_idIsNotNull() {
			addCriterion("time_id is not null");
			return (Criteria) this;
		}

		public Criteria andTime_idEqualTo(Integer value) {
			addCriterion("time_id =", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idNotEqualTo(Integer value) {
			addCriterion("time_id <>", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idGreaterThan(Integer value) {
			addCriterion("time_id >", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("time_id >=", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idLessThan(Integer value) {
			addCriterion("time_id <", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idLessThanOrEqualTo(Integer value) {
			addCriterion("time_id <=", value, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idIn(List<Integer> values) {
			addCriterion("time_id in", values, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idNotIn(List<Integer> values) {
			addCriterion("time_id not in", values, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idBetween(Integer value1, Integer value2) {
			addCriterion("time_id between", value1, value2, "time_id");
			return (Criteria) this;
		}

		public Criteria andTime_idNotBetween(Integer value1, Integer value2) {
			addCriterion("time_id not between", value1, value2, "time_id");
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

		public Criteria andSummaryIsNull() {
			addCriterion("summary is null");
			return (Criteria) this;
		}

		public Criteria andSummaryIsNotNull() {
			addCriterion("summary is not null");
			return (Criteria) this;
		}

		public Criteria andSummaryEqualTo(String value) {
			addCriterion("summary =", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotEqualTo(String value) {
			addCriterion("summary <>", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryGreaterThan(String value) {
			addCriterion("summary >", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryGreaterThanOrEqualTo(String value) {
			addCriterion("summary >=", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLessThan(String value) {
			addCriterion("summary <", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLessThanOrEqualTo(String value) {
			addCriterion("summary <=", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryLike(String value) {
			addCriterion("summary like", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotLike(String value) {
			addCriterion("summary not like", value, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryIn(List<String> values) {
			addCriterion("summary in", values, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotIn(List<String> values) {
			addCriterion("summary not in", values, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryBetween(String value1, String value2) {
			addCriterion("summary between", value1, value2, "summary");
			return (Criteria) this;
		}

		public Criteria andSummaryNotBetween(String value1, String value2) {
			addCriterion("summary not between", value1, value2, "summary");
			return (Criteria) this;
		}

		public Criteria andHis_dateIsNull() {
			addCriterion("his_date is null");
			return (Criteria) this;
		}

		public Criteria andHis_dateIsNotNull() {
			addCriterion("his_date is not null");
			return (Criteria) this;
		}

		public Criteria andHis_dateEqualTo(Date value) {
			addCriterionForJDBCDate("his_date =", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("his_date <>", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("his_date >", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("his_date >=", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateLessThan(Date value) {
			addCriterionForJDBCDate("his_date <", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("his_date <=", value, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateIn(List<Date> values) {
			addCriterionForJDBCDate("his_date in", values, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("his_date not in", values, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("his_date between", value1, value2, "his_date");
			return (Criteria) this;
		}

		public Criteria andHis_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("his_date not between", value1, value2, "his_date");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_time_axisn
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
     * This class corresponds to the database table hai_time_axisn
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}