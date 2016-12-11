package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProWbsWorkExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public ProWbsWorkExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_wbs_work
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table pro_wbs_work
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

		public Criteria andWbs_idIsNull() {
			addCriterion("wbs_id is null");
			return (Criteria) this;
		}

		public Criteria andWbs_idIsNotNull() {
			addCriterion("wbs_id is not null");
			return (Criteria) this;
		}

		public Criteria andWbs_idEqualTo(Integer value) {
			addCriterion("wbs_id =", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idNotEqualTo(Integer value) {
			addCriterion("wbs_id <>", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idGreaterThan(Integer value) {
			addCriterion("wbs_id >", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("wbs_id >=", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idLessThan(Integer value) {
			addCriterion("wbs_id <", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idLessThanOrEqualTo(Integer value) {
			addCriterion("wbs_id <=", value, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idIn(List<Integer> values) {
			addCriterion("wbs_id in", values, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idNotIn(List<Integer> values) {
			addCriterion("wbs_id not in", values, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idBetween(Integer value1, Integer value2) {
			addCriterion("wbs_id between", value1, value2, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_idNotBetween(Integer value1, Integer value2) {
			addCriterion("wbs_id not between", value1, value2, "wbs_id");
			return (Criteria) this;
		}

		public Criteria andWbs_nameIsNull() {
			addCriterion("wbs_name is null");
			return (Criteria) this;
		}

		public Criteria andWbs_nameIsNotNull() {
			addCriterion("wbs_name is not null");
			return (Criteria) this;
		}

		public Criteria andWbs_nameEqualTo(String value) {
			addCriterion("wbs_name =", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameNotEqualTo(String value) {
			addCriterion("wbs_name <>", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameGreaterThan(String value) {
			addCriterion("wbs_name >", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameGreaterThanOrEqualTo(String value) {
			addCriterion("wbs_name >=", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameLessThan(String value) {
			addCriterion("wbs_name <", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameLessThanOrEqualTo(String value) {
			addCriterion("wbs_name <=", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameLike(String value) {
			addCriterion("wbs_name like", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameNotLike(String value) {
			addCriterion("wbs_name not like", value, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameIn(List<String> values) {
			addCriterion("wbs_name in", values, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameNotIn(List<String> values) {
			addCriterion("wbs_name not in", values, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameBetween(String value1, String value2) {
			addCriterion("wbs_name between", value1, value2, "wbs_name");
			return (Criteria) this;
		}

		public Criteria andWbs_nameNotBetween(String value1, String value2) {
			addCriterion("wbs_name not between", value1, value2, "wbs_name");
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

		public Criteria andWbs_parent_idIsNull() {
			addCriterion("wbs_parent_id is null");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idIsNotNull() {
			addCriterion("wbs_parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idEqualTo(Integer value) {
			addCriterion("wbs_parent_id =", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idNotEqualTo(Integer value) {
			addCriterion("wbs_parent_id <>", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idGreaterThan(Integer value) {
			addCriterion("wbs_parent_id >", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("wbs_parent_id >=", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idLessThan(Integer value) {
			addCriterion("wbs_parent_id <", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idLessThanOrEqualTo(Integer value) {
			addCriterion("wbs_parent_id <=", value, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idIn(List<Integer> values) {
			addCriterion("wbs_parent_id in", values, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idNotIn(List<Integer> values) {
			addCriterion("wbs_parent_id not in", values, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idBetween(Integer value1, Integer value2) {
			addCriterion("wbs_parent_id between", value1, value2, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andWbs_parent_idNotBetween(Integer value1, Integer value2) {
			addCriterion("wbs_parent_id not between", value1, value2, "wbs_parent_id");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateIsNull() {
			addCriterion("plan_start_date is null");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateIsNotNull() {
			addCriterion("plan_start_date is not null");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateEqualTo(Date value) {
			addCriterionForJDBCDate("plan_start_date =", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("plan_start_date <>", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("plan_start_date >", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("plan_start_date >=", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateLessThan(Date value) {
			addCriterionForJDBCDate("plan_start_date <", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("plan_start_date <=", value, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateIn(List<Date> values) {
			addCriterionForJDBCDate("plan_start_date in", values, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("plan_start_date not in", values, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("plan_start_date between", value1, value2, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_start_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("plan_start_date not between", value1, value2, "plan_start_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateIsNull() {
			addCriterion("plan_end_date is null");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateIsNotNull() {
			addCriterion("plan_end_date is not null");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateEqualTo(Date value) {
			addCriterionForJDBCDate("plan_end_date =", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("plan_end_date <>", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("plan_end_date >", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("plan_end_date >=", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateLessThan(Date value) {
			addCriterionForJDBCDate("plan_end_date <", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("plan_end_date <=", value, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateIn(List<Date> values) {
			addCriterionForJDBCDate("plan_end_date in", values, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("plan_end_date not in", values, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("plan_end_date between", value1, value2, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andPlan_end_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("plan_end_date not between", value1, value2, "plan_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateIsNull() {
			addCriterion("truth_start_date is null");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateIsNotNull() {
			addCriterion("truth_start_date is not null");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateEqualTo(Date value) {
			addCriterionForJDBCDate("truth_start_date =", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("truth_start_date <>", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("truth_start_date >", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("truth_start_date >=", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateLessThan(Date value) {
			addCriterionForJDBCDate("truth_start_date <", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("truth_start_date <=", value, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateIn(List<Date> values) {
			addCriterionForJDBCDate("truth_start_date in", values, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("truth_start_date not in", values, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("truth_start_date between", value1, value2, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_start_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("truth_start_date not between", value1, value2, "truth_start_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateIsNull() {
			addCriterion("truth_end_date is null");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateIsNotNull() {
			addCriterion("truth_end_date is not null");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateEqualTo(Date value) {
			addCriterionForJDBCDate("truth_end_date =", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("truth_end_date <>", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("truth_end_date >", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("truth_end_date >=", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateLessThan(Date value) {
			addCriterionForJDBCDate("truth_end_date <", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("truth_end_date <=", value, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateIn(List<Date> values) {
			addCriterionForJDBCDate("truth_end_date in", values, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("truth_end_date not in", values, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("truth_end_date between", value1, value2, "truth_end_date");
			return (Criteria) this;
		}

		public Criteria andTruth_end_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("truth_end_date not between", value1, value2, "truth_end_date");
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

		public Criteria andProgressIsNull() {
			addCriterion("progress is null");
			return (Criteria) this;
		}

		public Criteria andProgressIsNotNull() {
			addCriterion("progress is not null");
			return (Criteria) this;
		}

		public Criteria andProgressEqualTo(Integer value) {
			addCriterion("progress =", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressNotEqualTo(Integer value) {
			addCriterion("progress <>", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressGreaterThan(Integer value) {
			addCriterion("progress >", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressGreaterThanOrEqualTo(Integer value) {
			addCriterion("progress >=", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressLessThan(Integer value) {
			addCriterion("progress <", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressLessThanOrEqualTo(Integer value) {
			addCriterion("progress <=", value, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressIn(List<Integer> values) {
			addCriterion("progress in", values, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressNotIn(List<Integer> values) {
			addCriterion("progress not in", values, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressBetween(Integer value1, Integer value2) {
			addCriterion("progress between", value1, value2, "progress");
			return (Criteria) this;
		}

		public Criteria andProgressNotBetween(Integer value1, Integer value2) {
			addCriterion("progress not between", value1, value2, "progress");
			return (Criteria) this;
		}

		public Criteria andSortIsNull() {
			addCriterion("sort is null");
			return (Criteria) this;
		}

		public Criteria andSortIsNotNull() {
			addCriterion("sort is not null");
			return (Criteria) this;
		}

		public Criteria andSortEqualTo(Integer value) {
			addCriterion("sort =", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotEqualTo(Integer value) {
			addCriterion("sort <>", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortGreaterThan(Integer value) {
			addCriterion("sort >", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("sort >=", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortLessThan(Integer value) {
			addCriterion("sort <", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortLessThanOrEqualTo(Integer value) {
			addCriterion("sort <=", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortIn(List<Integer> values) {
			addCriterion("sort in", values, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotIn(List<Integer> values) {
			addCriterion("sort not in", values, "sort");
			return (Criteria) this;
		}

		public Criteria andSortBetween(Integer value1, Integer value2) {
			addCriterion("sort between", value1, value2, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotBetween(Integer value1, Integer value2) {
			addCriterion("sort not between", value1, value2, "sort");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table pro_wbs_work
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
     * This class corresponds to the database table pro_wbs_work
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}