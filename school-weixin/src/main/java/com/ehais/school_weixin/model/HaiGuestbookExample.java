package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HaiGuestbookExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiGuestbookExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_guestbook
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_guestbook
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

		public Criteria andGuestbook_idIsNull() {
			addCriterion("guestbook_id is null");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idIsNotNull() {
			addCriterion("guestbook_id is not null");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idEqualTo(Integer value) {
			addCriterion("guestbook_id =", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idNotEqualTo(Integer value) {
			addCriterion("guestbook_id <>", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idGreaterThan(Integer value) {
			addCriterion("guestbook_id >", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("guestbook_id >=", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idLessThan(Integer value) {
			addCriterion("guestbook_id <", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idLessThanOrEqualTo(Integer value) {
			addCriterion("guestbook_id <=", value, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idIn(List<Integer> values) {
			addCriterion("guestbook_id in", values, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idNotIn(List<Integer> values) {
			addCriterion("guestbook_id not in", values, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idBetween(Integer value1, Integer value2) {
			addCriterion("guestbook_id between", value1, value2, "guestbook_id");
			return (Criteria) this;
		}

		public Criteria andGuestbook_idNotBetween(Integer value1, Integer value2) {
			addCriterion("guestbook_id not between", value1, value2, "guestbook_id");
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

		public Criteria andGuestIsNull() {
			addCriterion("guest is null");
			return (Criteria) this;
		}

		public Criteria andGuestIsNotNull() {
			addCriterion("guest is not null");
			return (Criteria) this;
		}

		public Criteria andGuestEqualTo(String value) {
			addCriterion("guest =", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestNotEqualTo(String value) {
			addCriterion("guest <>", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestGreaterThan(String value) {
			addCriterion("guest >", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestGreaterThanOrEqualTo(String value) {
			addCriterion("guest >=", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestLessThan(String value) {
			addCriterion("guest <", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestLessThanOrEqualTo(String value) {
			addCriterion("guest <=", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestLike(String value) {
			addCriterion("guest like", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestNotLike(String value) {
			addCriterion("guest not like", value, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestIn(List<String> values) {
			addCriterion("guest in", values, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestNotIn(List<String> values) {
			addCriterion("guest not in", values, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestBetween(String value1, String value2) {
			addCriterion("guest between", value1, value2, "guest");
			return (Criteria) this;
		}

		public Criteria andGuestNotBetween(String value1, String value2) {
			addCriterion("guest not between", value1, value2, "guest");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Short value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Short value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Short value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Short value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Short value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Short value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Short> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Short> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Short value1, Short value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Short value1, Short value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNull() {
			addCriterion("company is null");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNotNull() {
			addCriterion("company is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyEqualTo(String value) {
			addCriterion("company =", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotEqualTo(String value) {
			addCriterion("company <>", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThan(String value) {
			addCriterion("company >", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("company >=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThan(String value) {
			addCriterion("company <", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThanOrEqualTo(String value) {
			addCriterion("company <=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLike(String value) {
			addCriterion("company like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotLike(String value) {
			addCriterion("company not like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyIn(List<String> values) {
			addCriterion("company in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotIn(List<String> values) {
			addCriterion("company not in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyBetween(String value1, String value2) {
			addCriterion("company between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotBetween(String value1, String value2) {
			addCriterion("company not between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andPostcodeIsNull() {
			addCriterion("postcode is null");
			return (Criteria) this;
		}

		public Criteria andPostcodeIsNotNull() {
			addCriterion("postcode is not null");
			return (Criteria) this;
		}

		public Criteria andPostcodeEqualTo(String value) {
			addCriterion("postcode =", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotEqualTo(String value) {
			addCriterion("postcode <>", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeGreaterThan(String value) {
			addCriterion("postcode >", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
			addCriterion("postcode >=", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLessThan(String value) {
			addCriterion("postcode <", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLessThanOrEqualTo(String value) {
			addCriterion("postcode <=", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLike(String value) {
			addCriterion("postcode like", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotLike(String value) {
			addCriterion("postcode not like", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeIn(List<String> values) {
			addCriterion("postcode in", values, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotIn(List<String> values) {
			addCriterion("postcode not in", values, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeBetween(String value1, String value2) {
			addCriterion("postcode between", value1, value2, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotBetween(String value1, String value2) {
			addCriterion("postcode not between", value1, value2, "postcode");
			return (Criteria) this;
		}

		public Criteria andTelphoneIsNull() {
			addCriterion("telphone is null");
			return (Criteria) this;
		}

		public Criteria andTelphoneIsNotNull() {
			addCriterion("telphone is not null");
			return (Criteria) this;
		}

		public Criteria andTelphoneEqualTo(String value) {
			addCriterion("telphone =", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotEqualTo(String value) {
			addCriterion("telphone <>", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneGreaterThan(String value) {
			addCriterion("telphone >", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
			addCriterion("telphone >=", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLessThan(String value) {
			addCriterion("telphone <", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLessThanOrEqualTo(String value) {
			addCriterion("telphone <=", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLike(String value) {
			addCriterion("telphone like", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotLike(String value) {
			addCriterion("telphone not like", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneIn(List<String> values) {
			addCriterion("telphone in", values, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotIn(List<String> values) {
			addCriterion("telphone not in", values, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneBetween(String value1, String value2) {
			addCriterion("telphone between", value1, value2, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotBetween(String value1, String value2) {
			addCriterion("telphone not between", value1, value2, "telphone");
			return (Criteria) this;
		}

		public Criteria andFaxIsNull() {
			addCriterion("fax is null");
			return (Criteria) this;
		}

		public Criteria andFaxIsNotNull() {
			addCriterion("fax is not null");
			return (Criteria) this;
		}

		public Criteria andFaxEqualTo(String value) {
			addCriterion("fax =", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxNotEqualTo(String value) {
			addCriterion("fax <>", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxGreaterThan(String value) {
			addCriterion("fax >", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxGreaterThanOrEqualTo(String value) {
			addCriterion("fax >=", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxLessThan(String value) {
			addCriterion("fax <", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxLessThanOrEqualTo(String value) {
			addCriterion("fax <=", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxLike(String value) {
			addCriterion("fax like", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxNotLike(String value) {
			addCriterion("fax not like", value, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxIn(List<String> values) {
			addCriterion("fax in", values, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxNotIn(List<String> values) {
			addCriterion("fax not in", values, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxBetween(String value1, String value2) {
			addCriterion("fax between", value1, value2, "fax");
			return (Criteria) this;
		}

		public Criteria andFaxNotBetween(String value1, String value2) {
			addCriterion("fax not between", value1, value2, "fax");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_guestbook
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
     * This class corresponds to the database table hai_guestbook
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}