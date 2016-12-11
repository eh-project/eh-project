package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class CmfSlideExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public CmfSlideExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_slide
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

		public Criteria andSlide_idIsNull() {
			addCriterion("slide_id is null");
			return (Criteria) this;
		}

		public Criteria andSlide_idIsNotNull() {
			addCriterion("slide_id is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_idEqualTo(Long value) {
			addCriterion("slide_id =", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idNotEqualTo(Long value) {
			addCriterion("slide_id <>", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idGreaterThan(Long value) {
			addCriterion("slide_id >", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idGreaterThanOrEqualTo(Long value) {
			addCriterion("slide_id >=", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idLessThan(Long value) {
			addCriterion("slide_id <", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idLessThanOrEqualTo(Long value) {
			addCriterion("slide_id <=", value, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idIn(List<Long> values) {
			addCriterion("slide_id in", values, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idNotIn(List<Long> values) {
			addCriterion("slide_id not in", values, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idBetween(Long value1, Long value2) {
			addCriterion("slide_id between", value1, value2, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_idNotBetween(Long value1, Long value2) {
			addCriterion("slide_id not between", value1, value2, "slide_id");
			return (Criteria) this;
		}

		public Criteria andSlide_cidIsNull() {
			addCriterion("slide_cid is null");
			return (Criteria) this;
		}

		public Criteria andSlide_cidIsNotNull() {
			addCriterion("slide_cid is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_cidEqualTo(Integer value) {
			addCriterion("slide_cid =", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidNotEqualTo(Integer value) {
			addCriterion("slide_cid <>", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidGreaterThan(Integer value) {
			addCriterion("slide_cid >", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidGreaterThanOrEqualTo(Integer value) {
			addCriterion("slide_cid >=", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidLessThan(Integer value) {
			addCriterion("slide_cid <", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidLessThanOrEqualTo(Integer value) {
			addCriterion("slide_cid <=", value, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidIn(List<Integer> values) {
			addCriterion("slide_cid in", values, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidNotIn(List<Integer> values) {
			addCriterion("slide_cid not in", values, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidBetween(Integer value1, Integer value2) {
			addCriterion("slide_cid between", value1, value2, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_cidNotBetween(Integer value1, Integer value2) {
			addCriterion("slide_cid not between", value1, value2, "slide_cid");
			return (Criteria) this;
		}

		public Criteria andSlide_nameIsNull() {
			addCriterion("slide_name is null");
			return (Criteria) this;
		}

		public Criteria andSlide_nameIsNotNull() {
			addCriterion("slide_name is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_nameEqualTo(String value) {
			addCriterion("slide_name =", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameNotEqualTo(String value) {
			addCriterion("slide_name <>", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameGreaterThan(String value) {
			addCriterion("slide_name >", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameGreaterThanOrEqualTo(String value) {
			addCriterion("slide_name >=", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameLessThan(String value) {
			addCriterion("slide_name <", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameLessThanOrEqualTo(String value) {
			addCriterion("slide_name <=", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameLike(String value) {
			addCriterion("slide_name like", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameNotLike(String value) {
			addCriterion("slide_name not like", value, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameIn(List<String> values) {
			addCriterion("slide_name in", values, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameNotIn(List<String> values) {
			addCriterion("slide_name not in", values, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameBetween(String value1, String value2) {
			addCriterion("slide_name between", value1, value2, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_nameNotBetween(String value1, String value2) {
			addCriterion("slide_name not between", value1, value2, "slide_name");
			return (Criteria) this;
		}

		public Criteria andSlide_picIsNull() {
			addCriterion("slide_pic is null");
			return (Criteria) this;
		}

		public Criteria andSlide_picIsNotNull() {
			addCriterion("slide_pic is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_picEqualTo(String value) {
			addCriterion("slide_pic =", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picNotEqualTo(String value) {
			addCriterion("slide_pic <>", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picGreaterThan(String value) {
			addCriterion("slide_pic >", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picGreaterThanOrEqualTo(String value) {
			addCriterion("slide_pic >=", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picLessThan(String value) {
			addCriterion("slide_pic <", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picLessThanOrEqualTo(String value) {
			addCriterion("slide_pic <=", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picLike(String value) {
			addCriterion("slide_pic like", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picNotLike(String value) {
			addCriterion("slide_pic not like", value, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picIn(List<String> values) {
			addCriterion("slide_pic in", values, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picNotIn(List<String> values) {
			addCriterion("slide_pic not in", values, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picBetween(String value1, String value2) {
			addCriterion("slide_pic between", value1, value2, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_picNotBetween(String value1, String value2) {
			addCriterion("slide_pic not between", value1, value2, "slide_pic");
			return (Criteria) this;
		}

		public Criteria andSlide_urlIsNull() {
			addCriterion("slide_url is null");
			return (Criteria) this;
		}

		public Criteria andSlide_urlIsNotNull() {
			addCriterion("slide_url is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_urlEqualTo(String value) {
			addCriterion("slide_url =", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlNotEqualTo(String value) {
			addCriterion("slide_url <>", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlGreaterThan(String value) {
			addCriterion("slide_url >", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlGreaterThanOrEqualTo(String value) {
			addCriterion("slide_url >=", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlLessThan(String value) {
			addCriterion("slide_url <", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlLessThanOrEqualTo(String value) {
			addCriterion("slide_url <=", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlLike(String value) {
			addCriterion("slide_url like", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlNotLike(String value) {
			addCriterion("slide_url not like", value, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlIn(List<String> values) {
			addCriterion("slide_url in", values, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlNotIn(List<String> values) {
			addCriterion("slide_url not in", values, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlBetween(String value1, String value2) {
			addCriterion("slide_url between", value1, value2, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_urlNotBetween(String value1, String value2) {
			addCriterion("slide_url not between", value1, value2, "slide_url");
			return (Criteria) this;
		}

		public Criteria andSlide_desIsNull() {
			addCriterion("slide_des is null");
			return (Criteria) this;
		}

		public Criteria andSlide_desIsNotNull() {
			addCriterion("slide_des is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_desEqualTo(String value) {
			addCriterion("slide_des =", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desNotEqualTo(String value) {
			addCriterion("slide_des <>", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desGreaterThan(String value) {
			addCriterion("slide_des >", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desGreaterThanOrEqualTo(String value) {
			addCriterion("slide_des >=", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desLessThan(String value) {
			addCriterion("slide_des <", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desLessThanOrEqualTo(String value) {
			addCriterion("slide_des <=", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desLike(String value) {
			addCriterion("slide_des like", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desNotLike(String value) {
			addCriterion("slide_des not like", value, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desIn(List<String> values) {
			addCriterion("slide_des in", values, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desNotIn(List<String> values) {
			addCriterion("slide_des not in", values, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desBetween(String value1, String value2) {
			addCriterion("slide_des between", value1, value2, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_desNotBetween(String value1, String value2) {
			addCriterion("slide_des not between", value1, value2, "slide_des");
			return (Criteria) this;
		}

		public Criteria andSlide_statusIsNull() {
			addCriterion("slide_status is null");
			return (Criteria) this;
		}

		public Criteria andSlide_statusIsNotNull() {
			addCriterion("slide_status is not null");
			return (Criteria) this;
		}

		public Criteria andSlide_statusEqualTo(Integer value) {
			addCriterion("slide_status =", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusNotEqualTo(Integer value) {
			addCriterion("slide_status <>", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusGreaterThan(Integer value) {
			addCriterion("slide_status >", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusGreaterThanOrEqualTo(Integer value) {
			addCriterion("slide_status >=", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusLessThan(Integer value) {
			addCriterion("slide_status <", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusLessThanOrEqualTo(Integer value) {
			addCriterion("slide_status <=", value, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusIn(List<Integer> values) {
			addCriterion("slide_status in", values, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusNotIn(List<Integer> values) {
			addCriterion("slide_status not in", values, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusBetween(Integer value1, Integer value2) {
			addCriterion("slide_status between", value1, value2, "slide_status");
			return (Criteria) this;
		}

		public Criteria andSlide_statusNotBetween(Integer value1, Integer value2) {
			addCriterion("slide_status not between", value1, value2, "slide_status");
			return (Criteria) this;
		}

		public Criteria andListorderIsNull() {
			addCriterion("listorder is null");
			return (Criteria) this;
		}

		public Criteria andListorderIsNotNull() {
			addCriterion("listorder is not null");
			return (Criteria) this;
		}

		public Criteria andListorderEqualTo(Integer value) {
			addCriterion("listorder =", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderNotEqualTo(Integer value) {
			addCriterion("listorder <>", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderGreaterThan(Integer value) {
			addCriterion("listorder >", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderGreaterThanOrEqualTo(Integer value) {
			addCriterion("listorder >=", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderLessThan(Integer value) {
			addCriterion("listorder <", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderLessThanOrEqualTo(Integer value) {
			addCriterion("listorder <=", value, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderIn(List<Integer> values) {
			addCriterion("listorder in", values, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderNotIn(List<Integer> values) {
			addCriterion("listorder not in", values, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderBetween(Integer value1, Integer value2) {
			addCriterion("listorder between", value1, value2, "listorder");
			return (Criteria) this;
		}

		public Criteria andListorderNotBetween(Integer value1, Integer value2) {
			addCriterion("listorder not between", value1, value2, "listorder");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cmf_slide
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
     * This class corresponds to the database table cmf_slide
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}