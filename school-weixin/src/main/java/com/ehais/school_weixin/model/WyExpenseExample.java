package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WyExpenseExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public WyExpenseExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_expense
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wy_expense
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

		public Criteria andExpense_idIsNull() {
			addCriterion("expense_id is null");
			return (Criteria) this;
		}

		public Criteria andExpense_idIsNotNull() {
			addCriterion("expense_id is not null");
			return (Criteria) this;
		}

		public Criteria andExpense_idEqualTo(Integer value) {
			addCriterion("expense_id =", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idNotEqualTo(Integer value) {
			addCriterion("expense_id <>", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idGreaterThan(Integer value) {
			addCriterion("expense_id >", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("expense_id >=", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idLessThan(Integer value) {
			addCriterion("expense_id <", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idLessThanOrEqualTo(Integer value) {
			addCriterion("expense_id <=", value, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idIn(List<Integer> values) {
			addCriterion("expense_id in", values, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idNotIn(List<Integer> values) {
			addCriterion("expense_id not in", values, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idBetween(Integer value1, Integer value2) {
			addCriterion("expense_id between", value1, value2, "expense_id");
			return (Criteria) this;
		}

		public Criteria andExpense_idNotBetween(Integer value1, Integer value2) {
			addCriterion("expense_id not between", value1, value2, "expense_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idIsNull() {
			addCriterion("charge_method_id is null");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idIsNotNull() {
			addCriterion("charge_method_id is not null");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idEqualTo(Integer value) {
			addCriterion("charge_method_id =", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idNotEqualTo(Integer value) {
			addCriterion("charge_method_id <>", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idGreaterThan(Integer value) {
			addCriterion("charge_method_id >", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("charge_method_id >=", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idLessThan(Integer value) {
			addCriterion("charge_method_id <", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idLessThanOrEqualTo(Integer value) {
			addCriterion("charge_method_id <=", value, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idIn(List<Integer> values) {
			addCriterion("charge_method_id in", values, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idNotIn(List<Integer> values) {
			addCriterion("charge_method_id not in", values, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idBetween(Integer value1, Integer value2) {
			addCriterion("charge_method_id between", value1, value2, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andCharge_method_idNotBetween(Integer value1, Integer value2) {
			addCriterion("charge_method_id not between", value1, value2, "charge_method_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idIsNull() {
			addCriterion("homeowner_id is null");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idIsNotNull() {
			addCriterion("homeowner_id is not null");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idEqualTo(Integer value) {
			addCriterion("homeowner_id =", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idNotEqualTo(Integer value) {
			addCriterion("homeowner_id <>", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idGreaterThan(Integer value) {
			addCriterion("homeowner_id >", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("homeowner_id >=", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idLessThan(Integer value) {
			addCriterion("homeowner_id <", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idLessThanOrEqualTo(Integer value) {
			addCriterion("homeowner_id <=", value, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idIn(List<Integer> values) {
			addCriterion("homeowner_id in", values, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idNotIn(List<Integer> values) {
			addCriterion("homeowner_id not in", values, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idBetween(Integer value1, Integer value2) {
			addCriterion("homeowner_id between", value1, value2, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_idNotBetween(Integer value1, Integer value2) {
			addCriterion("homeowner_id not between", value1, value2, "homeowner_id");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameIsNull() {
			addCriterion("homeowner_name is null");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameIsNotNull() {
			addCriterion("homeowner_name is not null");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameEqualTo(String value) {
			addCriterion("homeowner_name =", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameNotEqualTo(String value) {
			addCriterion("homeowner_name <>", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameGreaterThan(String value) {
			addCriterion("homeowner_name >", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameGreaterThanOrEqualTo(String value) {
			addCriterion("homeowner_name >=", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameLessThan(String value) {
			addCriterion("homeowner_name <", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameLessThanOrEqualTo(String value) {
			addCriterion("homeowner_name <=", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameLike(String value) {
			addCriterion("homeowner_name like", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameNotLike(String value) {
			addCriterion("homeowner_name not like", value, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameIn(List<String> values) {
			addCriterion("homeowner_name in", values, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameNotIn(List<String> values) {
			addCriterion("homeowner_name not in", values, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameBetween(String value1, String value2) {
			addCriterion("homeowner_name between", value1, value2, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andHomeowner_nameNotBetween(String value1, String value2) {
			addCriterion("homeowner_name not between", value1, value2, "homeowner_name");
			return (Criteria) this;
		}

		public Criteria andCommunity_idIsNull() {
			addCriterion("community_id is null");
			return (Criteria) this;
		}

		public Criteria andCommunity_idIsNotNull() {
			addCriterion("community_id is not null");
			return (Criteria) this;
		}

		public Criteria andCommunity_idEqualTo(Integer value) {
			addCriterion("community_id =", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idNotEqualTo(Integer value) {
			addCriterion("community_id <>", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idGreaterThan(Integer value) {
			addCriterion("community_id >", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("community_id >=", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idLessThan(Integer value) {
			addCriterion("community_id <", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idLessThanOrEqualTo(Integer value) {
			addCriterion("community_id <=", value, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idIn(List<Integer> values) {
			addCriterion("community_id in", values, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idNotIn(List<Integer> values) {
			addCriterion("community_id not in", values, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idBetween(Integer value1, Integer value2) {
			addCriterion("community_id between", value1, value2, "community_id");
			return (Criteria) this;
		}

		public Criteria andCommunity_idNotBetween(Integer value1, Integer value2) {
			addCriterion("community_id not between", value1, value2, "community_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idIsNull() {
			addCriterion("house_id is null");
			return (Criteria) this;
		}

		public Criteria andHouse_idIsNotNull() {
			addCriterion("house_id is not null");
			return (Criteria) this;
		}

		public Criteria andHouse_idEqualTo(Integer value) {
			addCriterion("house_id =", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idNotEqualTo(Integer value) {
			addCriterion("house_id <>", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idGreaterThan(Integer value) {
			addCriterion("house_id >", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("house_id >=", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idLessThan(Integer value) {
			addCriterion("house_id <", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idLessThanOrEqualTo(Integer value) {
			addCriterion("house_id <=", value, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idIn(List<Integer> values) {
			addCriterion("house_id in", values, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idNotIn(List<Integer> values) {
			addCriterion("house_id not in", values, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idBetween(Integer value1, Integer value2) {
			addCriterion("house_id between", value1, value2, "house_id");
			return (Criteria) this;
		}

		public Criteria andHouse_idNotBetween(Integer value1, Integer value2) {
			addCriterion("house_id not between", value1, value2, "house_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idIsNull() {
			addCriterion("building_id is null");
			return (Criteria) this;
		}

		public Criteria andBuilding_idIsNotNull() {
			addCriterion("building_id is not null");
			return (Criteria) this;
		}

		public Criteria andBuilding_idEqualTo(Integer value) {
			addCriterion("building_id =", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idNotEqualTo(Integer value) {
			addCriterion("building_id <>", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idGreaterThan(Integer value) {
			addCriterion("building_id >", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("building_id >=", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idLessThan(Integer value) {
			addCriterion("building_id <", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idLessThanOrEqualTo(Integer value) {
			addCriterion("building_id <=", value, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idIn(List<Integer> values) {
			addCriterion("building_id in", values, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idNotIn(List<Integer> values) {
			addCriterion("building_id not in", values, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idBetween(Integer value1, Integer value2) {
			addCriterion("building_id between", value1, value2, "building_id");
			return (Criteria) this;
		}

		public Criteria andBuilding_idNotBetween(Integer value1, Integer value2) {
			addCriterion("building_id not between", value1, value2, "building_id");
			return (Criteria) this;
		}

		public Criteria andStart_dateIsNull() {
			addCriterion("start_date is null");
			return (Criteria) this;
		}

		public Criteria andStart_dateIsNotNull() {
			addCriterion("start_date is not null");
			return (Criteria) this;
		}

		public Criteria andStart_dateEqualTo(Date value) {
			addCriterionForJDBCDate("start_date =", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("start_date <>", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("start_date >", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_date >=", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateLessThan(Date value) {
			addCriterionForJDBCDate("start_date <", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("start_date <=", value, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateIn(List<Date> values) {
			addCriterionForJDBCDate("start_date in", values, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("start_date not in", values, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_date between", value1, value2, "start_date");
			return (Criteria) this;
		}

		public Criteria andStart_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("start_date not between", value1, value2, "start_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateIsNull() {
			addCriterion("end_date is null");
			return (Criteria) this;
		}

		public Criteria andEnd_dateIsNotNull() {
			addCriterion("end_date is not null");
			return (Criteria) this;
		}

		public Criteria andEnd_dateEqualTo(Date value) {
			addCriterionForJDBCDate("end_date =", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateNotEqualTo(Date value) {
			addCriterionForJDBCDate("end_date <>", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateGreaterThan(Date value) {
			addCriterionForJDBCDate("end_date >", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_date >=", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateLessThan(Date value) {
			addCriterionForJDBCDate("end_date <", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("end_date <=", value, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateIn(List<Date> values) {
			addCriterionForJDBCDate("end_date in", values, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateNotIn(List<Date> values) {
			addCriterionForJDBCDate("end_date not in", values, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_date between", value1, value2, "end_date");
			return (Criteria) this;
		}

		public Criteria andEnd_dateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("end_date not between", value1, value2, "end_date");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeIsNull() {
			addCriterion("previous_degree is null");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeIsNotNull() {
			addCriterion("previous_degree is not null");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeEqualTo(Double value) {
			addCriterion("previous_degree =", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeNotEqualTo(Double value) {
			addCriterion("previous_degree <>", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeGreaterThan(Double value) {
			addCriterion("previous_degree >", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeGreaterThanOrEqualTo(Double value) {
			addCriterion("previous_degree >=", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeLessThan(Double value) {
			addCriterion("previous_degree <", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeLessThanOrEqualTo(Double value) {
			addCriterion("previous_degree <=", value, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeIn(List<Double> values) {
			addCriterion("previous_degree in", values, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeNotIn(List<Double> values) {
			addCriterion("previous_degree not in", values, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeBetween(Double value1, Double value2) {
			addCriterion("previous_degree between", value1, value2, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andPrevious_degreeNotBetween(Double value1, Double value2) {
			addCriterion("previous_degree not between", value1, value2, "previous_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeIsNull() {
			addCriterion("now_degree is null");
			return (Criteria) this;
		}

		public Criteria andNow_degreeIsNotNull() {
			addCriterion("now_degree is not null");
			return (Criteria) this;
		}

		public Criteria andNow_degreeEqualTo(Double value) {
			addCriterion("now_degree =", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeNotEqualTo(Double value) {
			addCriterion("now_degree <>", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeGreaterThan(Double value) {
			addCriterion("now_degree >", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeGreaterThanOrEqualTo(Double value) {
			addCriterion("now_degree >=", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeLessThan(Double value) {
			addCriterion("now_degree <", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeLessThanOrEqualTo(Double value) {
			addCriterion("now_degree <=", value, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeIn(List<Double> values) {
			addCriterion("now_degree in", values, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeNotIn(List<Double> values) {
			addCriterion("now_degree not in", values, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeBetween(Double value1, Double value2) {
			addCriterion("now_degree between", value1, value2, "now_degree");
			return (Criteria) this;
		}

		public Criteria andNow_degreeNotBetween(Double value1, Double value2) {
			addCriterion("now_degree not between", value1, value2, "now_degree");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wy_expense
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
     * This class corresponds to the database table wy_expense
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}