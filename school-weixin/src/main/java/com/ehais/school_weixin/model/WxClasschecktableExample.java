package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class WxClasschecktableExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public WxClasschecktableExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_classchecktable
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wx_classchecktable
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

		public Criteria andStudent_IdIsNull() {
			addCriterion("Student_Id is null");
			return (Criteria) this;
		}

		public Criteria andStudent_IdIsNotNull() {
			addCriterion("Student_Id is not null");
			return (Criteria) this;
		}

		public Criteria andStudent_IdEqualTo(Integer value) {
			addCriterion("Student_Id =", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdNotEqualTo(Integer value) {
			addCriterion("Student_Id <>", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdGreaterThan(Integer value) {
			addCriterion("Student_Id >", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdGreaterThanOrEqualTo(Integer value) {
			addCriterion("Student_Id >=", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdLessThan(Integer value) {
			addCriterion("Student_Id <", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdLessThanOrEqualTo(Integer value) {
			addCriterion("Student_Id <=", value, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdIn(List<Integer> values) {
			addCriterion("Student_Id in", values, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdNotIn(List<Integer> values) {
			addCriterion("Student_Id not in", values, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdBetween(Integer value1, Integer value2) {
			addCriterion("Student_Id between", value1, value2, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_IdNotBetween(Integer value1, Integer value2) {
			addCriterion("Student_Id not between", value1, value2, "student_Id");
			return (Criteria) this;
		}

		public Criteria andStudent_NameIsNull() {
			addCriterion("Student_Name is null");
			return (Criteria) this;
		}

		public Criteria andStudent_NameIsNotNull() {
			addCriterion("Student_Name is not null");
			return (Criteria) this;
		}

		public Criteria andStudent_NameEqualTo(String value) {
			addCriterion("Student_Name =", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameNotEqualTo(String value) {
			addCriterion("Student_Name <>", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameGreaterThan(String value) {
			addCriterion("Student_Name >", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameGreaterThanOrEqualTo(String value) {
			addCriterion("Student_Name >=", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameLessThan(String value) {
			addCriterion("Student_Name <", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameLessThanOrEqualTo(String value) {
			addCriterion("Student_Name <=", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameLike(String value) {
			addCriterion("Student_Name like", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameNotLike(String value) {
			addCriterion("Student_Name not like", value, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameIn(List<String> values) {
			addCriterion("Student_Name in", values, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameNotIn(List<String> values) {
			addCriterion("Student_Name not in", values, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameBetween(String value1, String value2) {
			addCriterion("Student_Name between", value1, value2, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_NameNotBetween(String value1, String value2) {
			addCriterion("Student_Name not between", value1, value2, "student_Name");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckIsNull() {
			addCriterion("Student_ClassCheck is null");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckIsNotNull() {
			addCriterion("Student_ClassCheck is not null");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckEqualTo(Integer value) {
			addCriterion("Student_ClassCheck =", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckNotEqualTo(Integer value) {
			addCriterion("Student_ClassCheck <>", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckGreaterThan(Integer value) {
			addCriterion("Student_ClassCheck >", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckGreaterThanOrEqualTo(Integer value) {
			addCriterion("Student_ClassCheck >=", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckLessThan(Integer value) {
			addCriterion("Student_ClassCheck <", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckLessThanOrEqualTo(Integer value) {
			addCriterion("Student_ClassCheck <=", value, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckIn(List<Integer> values) {
			addCriterion("Student_ClassCheck in", values, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckNotIn(List<Integer> values) {
			addCriterion("Student_ClassCheck not in", values, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckBetween(Integer value1, Integer value2) {
			addCriterion("Student_ClassCheck between", value1, value2, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheckNotBetween(Integer value1, Integer value2) {
			addCriterion("Student_ClassCheck not between", value1, value2, "student_ClassCheck");
			return (Criteria) this;
		}

		public Criteria andCourse_NameIsNull() {
			addCriterion("Course_Name is null");
			return (Criteria) this;
		}

		public Criteria andCourse_NameIsNotNull() {
			addCriterion("Course_Name is not null");
			return (Criteria) this;
		}

		public Criteria andCourse_NameEqualTo(String value) {
			addCriterion("Course_Name =", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameNotEqualTo(String value) {
			addCriterion("Course_Name <>", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameGreaterThan(String value) {
			addCriterion("Course_Name >", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameGreaterThanOrEqualTo(String value) {
			addCriterion("Course_Name >=", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameLessThan(String value) {
			addCriterion("Course_Name <", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameLessThanOrEqualTo(String value) {
			addCriterion("Course_Name <=", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameLike(String value) {
			addCriterion("Course_Name like", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameNotLike(String value) {
			addCriterion("Course_Name not like", value, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameIn(List<String> values) {
			addCriterion("Course_Name in", values, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameNotIn(List<String> values) {
			addCriterion("Course_Name not in", values, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameBetween(String value1, String value2) {
			addCriterion("Course_Name between", value1, value2, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_NameNotBetween(String value1, String value2) {
			addCriterion("Course_Name not between", value1, value2, "course_Name");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherIsNull() {
			addCriterion("Course_Teacher is null");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherIsNotNull() {
			addCriterion("Course_Teacher is not null");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherEqualTo(String value) {
			addCriterion("Course_Teacher =", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherNotEqualTo(String value) {
			addCriterion("Course_Teacher <>", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherGreaterThan(String value) {
			addCriterion("Course_Teacher >", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherGreaterThanOrEqualTo(String value) {
			addCriterion("Course_Teacher >=", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherLessThan(String value) {
			addCriterion("Course_Teacher <", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherLessThanOrEqualTo(String value) {
			addCriterion("Course_Teacher <=", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherLike(String value) {
			addCriterion("Course_Teacher like", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherNotLike(String value) {
			addCriterion("Course_Teacher not like", value, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherIn(List<String> values) {
			addCriterion("Course_Teacher in", values, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherNotIn(List<String> values) {
			addCriterion("Course_Teacher not in", values, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherBetween(String value1, String value2) {
			addCriterion("Course_Teacher between", value1, value2, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_TeacherNotBetween(String value1, String value2) {
			addCriterion("Course_Teacher not between", value1, value2, "course_Teacher");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberIsNull() {
			addCriterion("Course_Number is null");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberIsNotNull() {
			addCriterion("Course_Number is not null");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberEqualTo(Integer value) {
			addCriterion("Course_Number =", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberNotEqualTo(Integer value) {
			addCriterion("Course_Number <>", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberGreaterThan(Integer value) {
			addCriterion("Course_Number >", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("Course_Number >=", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberLessThan(Integer value) {
			addCriterion("Course_Number <", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberLessThanOrEqualTo(Integer value) {
			addCriterion("Course_Number <=", value, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberIn(List<Integer> values) {
			addCriterion("Course_Number in", values, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberNotIn(List<Integer> values) {
			addCriterion("Course_Number not in", values, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberBetween(Integer value1, Integer value2) {
			addCriterion("Course_Number between", value1, value2, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_NumberNotBetween(Integer value1, Integer value2) {
			addCriterion("Course_Number not between", value1, value2, "course_Number");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeIsNull() {
			addCriterion("Course_Type is null");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeIsNotNull() {
			addCriterion("Course_Type is not null");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeEqualTo(Integer value) {
			addCriterion("Course_Type =", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeNotEqualTo(Integer value) {
			addCriterion("Course_Type <>", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeGreaterThan(Integer value) {
			addCriterion("Course_Type >", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("Course_Type >=", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeLessThan(Integer value) {
			addCriterion("Course_Type <", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeLessThanOrEqualTo(Integer value) {
			addCriterion("Course_Type <=", value, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeIn(List<Integer> values) {
			addCriterion("Course_Type in", values, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeNotIn(List<Integer> values) {
			addCriterion("Course_Type not in", values, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeBetween(Integer value1, Integer value2) {
			addCriterion("Course_Type between", value1, value2, "course_Type");
			return (Criteria) this;
		}

		public Criteria andCourse_TypeNotBetween(Integer value1, Integer value2) {
			addCriterion("Course_Type not between", value1, value2, "course_Type");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeIsNull() {
			addCriterion("ClassCheck_Code is null");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeIsNotNull() {
			addCriterion("ClassCheck_Code is not null");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeEqualTo(String value) {
			addCriterion("ClassCheck_Code =", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeNotEqualTo(String value) {
			addCriterion("ClassCheck_Code <>", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeGreaterThan(String value) {
			addCriterion("ClassCheck_Code >", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeGreaterThanOrEqualTo(String value) {
			addCriterion("ClassCheck_Code >=", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeLessThan(String value) {
			addCriterion("ClassCheck_Code <", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeLessThanOrEqualTo(String value) {
			addCriterion("ClassCheck_Code <=", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeLike(String value) {
			addCriterion("ClassCheck_Code like", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeNotLike(String value) {
			addCriterion("ClassCheck_Code not like", value, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeIn(List<String> values) {
			addCriterion("ClassCheck_Code in", values, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeNotIn(List<String> values) {
			addCriterion("ClassCheck_Code not in", values, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeBetween(String value1, String value2) {
			addCriterion("ClassCheck_Code between", value1, value2, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andClassCheck_CodeNotBetween(String value1, String value2) {
			addCriterion("ClassCheck_Code not between", value1, value2, "classCheck_Code");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksIsNull() {
			addCriterion("Student_ClassCheck_remarks is null");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksIsNotNull() {
			addCriterion("Student_ClassCheck_remarks is not null");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksEqualTo(String value) {
			addCriterion("Student_ClassCheck_remarks =", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksNotEqualTo(String value) {
			addCriterion("Student_ClassCheck_remarks <>", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksGreaterThan(String value) {
			addCriterion("Student_ClassCheck_remarks >", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksGreaterThanOrEqualTo(String value) {
			addCriterion("Student_ClassCheck_remarks >=", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksLessThan(String value) {
			addCriterion("Student_ClassCheck_remarks <", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksLessThanOrEqualTo(String value) {
			addCriterion("Student_ClassCheck_remarks <=", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksLike(String value) {
			addCriterion("Student_ClassCheck_remarks like", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksNotLike(String value) {
			addCriterion("Student_ClassCheck_remarks not like", value, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksIn(List<String> values) {
			addCriterion("Student_ClassCheck_remarks in", values, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksNotIn(List<String> values) {
			addCriterion("Student_ClassCheck_remarks not in", values, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksBetween(String value1, String value2) {
			addCriterion("Student_ClassCheck_remarks between", value1, value2, "student_ClassCheck_remarks");
			return (Criteria) this;
		}

		public Criteria andStudent_ClassCheck_remarksNotBetween(String value1, String value2) {
			addCriterion("Student_ClassCheck_remarks not between", value1, value2, "student_ClassCheck_remarks");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wx_classchecktable
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
     * This class corresponds to the database table wx_classchecktable
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}