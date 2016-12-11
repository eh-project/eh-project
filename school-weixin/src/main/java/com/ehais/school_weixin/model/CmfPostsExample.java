package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmfPostsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public CmfPostsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_posts
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_posts
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andPost_authorIsNull() {
			addCriterion("post_author is null");
			return (Criteria) this;
		}

		public Criteria andPost_authorIsNotNull() {
			addCriterion("post_author is not null");
			return (Criteria) this;
		}

		public Criteria andPost_authorEqualTo(Long value) {
			addCriterion("post_author =", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorNotEqualTo(Long value) {
			addCriterion("post_author <>", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorGreaterThan(Long value) {
			addCriterion("post_author >", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorGreaterThanOrEqualTo(Long value) {
			addCriterion("post_author >=", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorLessThan(Long value) {
			addCriterion("post_author <", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorLessThanOrEqualTo(Long value) {
			addCriterion("post_author <=", value, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorIn(List<Long> values) {
			addCriterion("post_author in", values, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorNotIn(List<Long> values) {
			addCriterion("post_author not in", values, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorBetween(Long value1, Long value2) {
			addCriterion("post_author between", value1, value2, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_authorNotBetween(Long value1, Long value2) {
			addCriterion("post_author not between", value1, value2, "post_author");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsIsNull() {
			addCriterion("post_keywords is null");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsIsNotNull() {
			addCriterion("post_keywords is not null");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsEqualTo(String value) {
			addCriterion("post_keywords =", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsNotEqualTo(String value) {
			addCriterion("post_keywords <>", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsGreaterThan(String value) {
			addCriterion("post_keywords >", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsGreaterThanOrEqualTo(String value) {
			addCriterion("post_keywords >=", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsLessThan(String value) {
			addCriterion("post_keywords <", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsLessThanOrEqualTo(String value) {
			addCriterion("post_keywords <=", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsLike(String value) {
			addCriterion("post_keywords like", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsNotLike(String value) {
			addCriterion("post_keywords not like", value, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsIn(List<String> values) {
			addCriterion("post_keywords in", values, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsNotIn(List<String> values) {
			addCriterion("post_keywords not in", values, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsBetween(String value1, String value2) {
			addCriterion("post_keywords between", value1, value2, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_keywordsNotBetween(String value1, String value2) {
			addCriterion("post_keywords not between", value1, value2, "post_keywords");
			return (Criteria) this;
		}

		public Criteria andPost_sourceIsNull() {
			addCriterion("post_source is null");
			return (Criteria) this;
		}

		public Criteria andPost_sourceIsNotNull() {
			addCriterion("post_source is not null");
			return (Criteria) this;
		}

		public Criteria andPost_sourceEqualTo(String value) {
			addCriterion("post_source =", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceNotEqualTo(String value) {
			addCriterion("post_source <>", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceGreaterThan(String value) {
			addCriterion("post_source >", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceGreaterThanOrEqualTo(String value) {
			addCriterion("post_source >=", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceLessThan(String value) {
			addCriterion("post_source <", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceLessThanOrEqualTo(String value) {
			addCriterion("post_source <=", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceLike(String value) {
			addCriterion("post_source like", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceNotLike(String value) {
			addCriterion("post_source not like", value, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceIn(List<String> values) {
			addCriterion("post_source in", values, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceNotIn(List<String> values) {
			addCriterion("post_source not in", values, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceBetween(String value1, String value2) {
			addCriterion("post_source between", value1, value2, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_sourceNotBetween(String value1, String value2) {
			addCriterion("post_source not between", value1, value2, "post_source");
			return (Criteria) this;
		}

		public Criteria andPost_dateIsNull() {
			addCriterion("post_date is null");
			return (Criteria) this;
		}

		public Criteria andPost_dateIsNotNull() {
			addCriterion("post_date is not null");
			return (Criteria) this;
		}

		public Criteria andPost_dateEqualTo(Date value) {
			addCriterion("post_date =", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateNotEqualTo(Date value) {
			addCriterion("post_date <>", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateGreaterThan(Date value) {
			addCriterion("post_date >", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateGreaterThanOrEqualTo(Date value) {
			addCriterion("post_date >=", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateLessThan(Date value) {
			addCriterion("post_date <", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateLessThanOrEqualTo(Date value) {
			addCriterion("post_date <=", value, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateIn(List<Date> values) {
			addCriterion("post_date in", values, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateNotIn(List<Date> values) {
			addCriterion("post_date not in", values, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateBetween(Date value1, Date value2) {
			addCriterion("post_date between", value1, value2, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_dateNotBetween(Date value1, Date value2) {
			addCriterion("post_date not between", value1, value2, "post_date");
			return (Criteria) this;
		}

		public Criteria andPost_statusIsNull() {
			addCriterion("post_status is null");
			return (Criteria) this;
		}

		public Criteria andPost_statusIsNotNull() {
			addCriterion("post_status is not null");
			return (Criteria) this;
		}

		public Criteria andPost_statusEqualTo(Integer value) {
			addCriterion("post_status =", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusNotEqualTo(Integer value) {
			addCriterion("post_status <>", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusGreaterThan(Integer value) {
			addCriterion("post_status >", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_status >=", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusLessThan(Integer value) {
			addCriterion("post_status <", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusLessThanOrEqualTo(Integer value) {
			addCriterion("post_status <=", value, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusIn(List<Integer> values) {
			addCriterion("post_status in", values, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusNotIn(List<Integer> values) {
			addCriterion("post_status not in", values, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusBetween(Integer value1, Integer value2) {
			addCriterion("post_status between", value1, value2, "post_status");
			return (Criteria) this;
		}

		public Criteria andPost_statusNotBetween(Integer value1, Integer value2) {
			addCriterion("post_status not between", value1, value2, "post_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusIsNull() {
			addCriterion("comment_status is null");
			return (Criteria) this;
		}

		public Criteria andComment_statusIsNotNull() {
			addCriterion("comment_status is not null");
			return (Criteria) this;
		}

		public Criteria andComment_statusEqualTo(Integer value) {
			addCriterion("comment_status =", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusNotEqualTo(Integer value) {
			addCriterion("comment_status <>", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusGreaterThan(Integer value) {
			addCriterion("comment_status >", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusGreaterThanOrEqualTo(Integer value) {
			addCriterion("comment_status >=", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusLessThan(Integer value) {
			addCriterion("comment_status <", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusLessThanOrEqualTo(Integer value) {
			addCriterion("comment_status <=", value, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusIn(List<Integer> values) {
			addCriterion("comment_status in", values, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusNotIn(List<Integer> values) {
			addCriterion("comment_status not in", values, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusBetween(Integer value1, Integer value2) {
			addCriterion("comment_status between", value1, value2, "comment_status");
			return (Criteria) this;
		}

		public Criteria andComment_statusNotBetween(Integer value1, Integer value2) {
			addCriterion("comment_status not between", value1, value2, "comment_status");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedIsNull() {
			addCriterion("post_modified is null");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedIsNotNull() {
			addCriterion("post_modified is not null");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedEqualTo(Date value) {
			addCriterion("post_modified =", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedNotEqualTo(Date value) {
			addCriterion("post_modified <>", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedGreaterThan(Date value) {
			addCriterion("post_modified >", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedGreaterThanOrEqualTo(Date value) {
			addCriterion("post_modified >=", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedLessThan(Date value) {
			addCriterion("post_modified <", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedLessThanOrEqualTo(Date value) {
			addCriterion("post_modified <=", value, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedIn(List<Date> values) {
			addCriterion("post_modified in", values, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedNotIn(List<Date> values) {
			addCriterion("post_modified not in", values, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedBetween(Date value1, Date value2) {
			addCriterion("post_modified between", value1, value2, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_modifiedNotBetween(Date value1, Date value2) {
			addCriterion("post_modified not between", value1, value2, "post_modified");
			return (Criteria) this;
		}

		public Criteria andPost_parentIsNull() {
			addCriterion("post_parent is null");
			return (Criteria) this;
		}

		public Criteria andPost_parentIsNotNull() {
			addCriterion("post_parent is not null");
			return (Criteria) this;
		}

		public Criteria andPost_parentEqualTo(Long value) {
			addCriterion("post_parent =", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentNotEqualTo(Long value) {
			addCriterion("post_parent <>", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentGreaterThan(Long value) {
			addCriterion("post_parent >", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentGreaterThanOrEqualTo(Long value) {
			addCriterion("post_parent >=", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentLessThan(Long value) {
			addCriterion("post_parent <", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentLessThanOrEqualTo(Long value) {
			addCriterion("post_parent <=", value, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentIn(List<Long> values) {
			addCriterion("post_parent in", values, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentNotIn(List<Long> values) {
			addCriterion("post_parent not in", values, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentBetween(Long value1, Long value2) {
			addCriterion("post_parent between", value1, value2, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_parentNotBetween(Long value1, Long value2) {
			addCriterion("post_parent not between", value1, value2, "post_parent");
			return (Criteria) this;
		}

		public Criteria andPost_typeIsNull() {
			addCriterion("post_type is null");
			return (Criteria) this;
		}

		public Criteria andPost_typeIsNotNull() {
			addCriterion("post_type is not null");
			return (Criteria) this;
		}

		public Criteria andPost_typeEqualTo(Integer value) {
			addCriterion("post_type =", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeNotEqualTo(Integer value) {
			addCriterion("post_type <>", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeGreaterThan(Integer value) {
			addCriterion("post_type >", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_type >=", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeLessThan(Integer value) {
			addCriterion("post_type <", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeLessThanOrEqualTo(Integer value) {
			addCriterion("post_type <=", value, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeIn(List<Integer> values) {
			addCriterion("post_type in", values, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeNotIn(List<Integer> values) {
			addCriterion("post_type not in", values, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeBetween(Integer value1, Integer value2) {
			addCriterion("post_type between", value1, value2, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_typeNotBetween(Integer value1, Integer value2) {
			addCriterion("post_type not between", value1, value2, "post_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeIsNull() {
			addCriterion("post_mime_type is null");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeIsNotNull() {
			addCriterion("post_mime_type is not null");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeEqualTo(String value) {
			addCriterion("post_mime_type =", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeNotEqualTo(String value) {
			addCriterion("post_mime_type <>", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeGreaterThan(String value) {
			addCriterion("post_mime_type >", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeGreaterThanOrEqualTo(String value) {
			addCriterion("post_mime_type >=", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeLessThan(String value) {
			addCriterion("post_mime_type <", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeLessThanOrEqualTo(String value) {
			addCriterion("post_mime_type <=", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeLike(String value) {
			addCriterion("post_mime_type like", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeNotLike(String value) {
			addCriterion("post_mime_type not like", value, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeIn(List<String> values) {
			addCriterion("post_mime_type in", values, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeNotIn(List<String> values) {
			addCriterion("post_mime_type not in", values, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeBetween(String value1, String value2) {
			addCriterion("post_mime_type between", value1, value2, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andPost_mime_typeNotBetween(String value1, String value2) {
			addCriterion("post_mime_type not between", value1, value2, "post_mime_type");
			return (Criteria) this;
		}

		public Criteria andComment_countIsNull() {
			addCriterion("comment_count is null");
			return (Criteria) this;
		}

		public Criteria andComment_countIsNotNull() {
			addCriterion("comment_count is not null");
			return (Criteria) this;
		}

		public Criteria andComment_countEqualTo(Long value) {
			addCriterion("comment_count =", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countNotEqualTo(Long value) {
			addCriterion("comment_count <>", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countGreaterThan(Long value) {
			addCriterion("comment_count >", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countGreaterThanOrEqualTo(Long value) {
			addCriterion("comment_count >=", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countLessThan(Long value) {
			addCriterion("comment_count <", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countLessThanOrEqualTo(Long value) {
			addCriterion("comment_count <=", value, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countIn(List<Long> values) {
			addCriterion("comment_count in", values, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countNotIn(List<Long> values) {
			addCriterion("comment_count not in", values, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countBetween(Long value1, Long value2) {
			addCriterion("comment_count between", value1, value2, "comment_count");
			return (Criteria) this;
		}

		public Criteria andComment_countNotBetween(Long value1, Long value2) {
			addCriterion("comment_count not between", value1, value2, "comment_count");
			return (Criteria) this;
		}

		public Criteria andPost_hitsIsNull() {
			addCriterion("post_hits is null");
			return (Criteria) this;
		}

		public Criteria andPost_hitsIsNotNull() {
			addCriterion("post_hits is not null");
			return (Criteria) this;
		}

		public Criteria andPost_hitsEqualTo(Integer value) {
			addCriterion("post_hits =", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsNotEqualTo(Integer value) {
			addCriterion("post_hits <>", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsGreaterThan(Integer value) {
			addCriterion("post_hits >", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_hits >=", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsLessThan(Integer value) {
			addCriterion("post_hits <", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsLessThanOrEqualTo(Integer value) {
			addCriterion("post_hits <=", value, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsIn(List<Integer> values) {
			addCriterion("post_hits in", values, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsNotIn(List<Integer> values) {
			addCriterion("post_hits not in", values, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsBetween(Integer value1, Integer value2) {
			addCriterion("post_hits between", value1, value2, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_hitsNotBetween(Integer value1, Integer value2) {
			addCriterion("post_hits not between", value1, value2, "post_hits");
			return (Criteria) this;
		}

		public Criteria andPost_likeIsNull() {
			addCriterion("post_like is null");
			return (Criteria) this;
		}

		public Criteria andPost_likeIsNotNull() {
			addCriterion("post_like is not null");
			return (Criteria) this;
		}

		public Criteria andPost_likeEqualTo(Integer value) {
			addCriterion("post_like =", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeNotEqualTo(Integer value) {
			addCriterion("post_like <>", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeGreaterThan(Integer value) {
			addCriterion("post_like >", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeGreaterThanOrEqualTo(Integer value) {
			addCriterion("post_like >=", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeLessThan(Integer value) {
			addCriterion("post_like <", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeLessThanOrEqualTo(Integer value) {
			addCriterion("post_like <=", value, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeIn(List<Integer> values) {
			addCriterion("post_like in", values, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeNotIn(List<Integer> values) {
			addCriterion("post_like not in", values, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeBetween(Integer value1, Integer value2) {
			addCriterion("post_like between", value1, value2, "post_like");
			return (Criteria) this;
		}

		public Criteria andPost_likeNotBetween(Integer value1, Integer value2) {
			addCriterion("post_like not between", value1, value2, "post_like");
			return (Criteria) this;
		}

		public Criteria andIstopIsNull() {
			addCriterion("istop is null");
			return (Criteria) this;
		}

		public Criteria andIstopIsNotNull() {
			addCriterion("istop is not null");
			return (Criteria) this;
		}

		public Criteria andIstopEqualTo(Boolean value) {
			addCriterion("istop =", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopNotEqualTo(Boolean value) {
			addCriterion("istop <>", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopGreaterThan(Boolean value) {
			addCriterion("istop >", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopGreaterThanOrEqualTo(Boolean value) {
			addCriterion("istop >=", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopLessThan(Boolean value) {
			addCriterion("istop <", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopLessThanOrEqualTo(Boolean value) {
			addCriterion("istop <=", value, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopIn(List<Boolean> values) {
			addCriterion("istop in", values, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopNotIn(List<Boolean> values) {
			addCriterion("istop not in", values, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopBetween(Boolean value1, Boolean value2) {
			addCriterion("istop between", value1, value2, "istop");
			return (Criteria) this;
		}

		public Criteria andIstopNotBetween(Boolean value1, Boolean value2) {
			addCriterion("istop not between", value1, value2, "istop");
			return (Criteria) this;
		}

		public Criteria andRecommendedIsNull() {
			addCriterion("recommended is null");
			return (Criteria) this;
		}

		public Criteria andRecommendedIsNotNull() {
			addCriterion("recommended is not null");
			return (Criteria) this;
		}

		public Criteria andRecommendedEqualTo(Boolean value) {
			addCriterion("recommended =", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedNotEqualTo(Boolean value) {
			addCriterion("recommended <>", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedGreaterThan(Boolean value) {
			addCriterion("recommended >", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("recommended >=", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedLessThan(Boolean value) {
			addCriterion("recommended <", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedLessThanOrEqualTo(Boolean value) {
			addCriterion("recommended <=", value, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedIn(List<Boolean> values) {
			addCriterion("recommended in", values, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedNotIn(List<Boolean> values) {
			addCriterion("recommended not in", values, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedBetween(Boolean value1, Boolean value2) {
			addCriterion("recommended between", value1, value2, "recommended");
			return (Criteria) this;
		}

		public Criteria andRecommendedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("recommended not between", value1, value2, "recommended");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_posts
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
     * This class corresponds to the database table cmf_posts
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}