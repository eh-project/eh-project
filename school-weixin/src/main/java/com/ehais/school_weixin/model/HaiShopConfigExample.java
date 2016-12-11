package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiShopConfigExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiShopConfigExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shop_config
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_shop_config
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

		public Criteria andIdEqualTo(Short value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Short value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Short value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Short value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Short value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Short value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Short> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Short> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Short value1, Short value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Short value1, Short value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andParent_idIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParent_idIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParent_idEqualTo(Short value) {
			addCriterion("parent_id =", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotEqualTo(Short value) {
			addCriterion("parent_id <>", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idGreaterThan(Short value) {
			addCriterion("parent_id >", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idGreaterThanOrEqualTo(Short value) {
			addCriterion("parent_id >=", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idLessThan(Short value) {
			addCriterion("parent_id <", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idLessThanOrEqualTo(Short value) {
			addCriterion("parent_id <=", value, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idIn(List<Short> values) {
			addCriterion("parent_id in", values, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotIn(List<Short> values) {
			addCriterion("parent_id not in", values, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idBetween(Short value1, Short value2) {
			addCriterion("parent_id between", value1, value2, "parent_id");
			return (Criteria) this;
		}

		public Criteria andParent_idNotBetween(Short value1, Short value2) {
			addCriterion("parent_id not between", value1, value2, "parent_id");
			return (Criteria) this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("code is null");
			return (Criteria) this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("code is not null");
			return (Criteria) this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("code =", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("code <>", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("code >", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("code >=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("code <", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("code <=", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("code like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("code not like", value, "code");
			return (Criteria) this;
		}

		public Criteria andCodeIn(List<String> values) {
			addCriterion("code in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotIn(List<String> values) {
			addCriterion("code not in", values, "code");
			return (Criteria) this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("code between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("code not between", value1, value2, "code");
			return (Criteria) this;
		}

		public Criteria andCode_textIsNull() {
			addCriterion("code_text is null");
			return (Criteria) this;
		}

		public Criteria andCode_textIsNotNull() {
			addCriterion("code_text is not null");
			return (Criteria) this;
		}

		public Criteria andCode_textEqualTo(String value) {
			addCriterion("code_text =", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textNotEqualTo(String value) {
			addCriterion("code_text <>", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textGreaterThan(String value) {
			addCriterion("code_text >", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textGreaterThanOrEqualTo(String value) {
			addCriterion("code_text >=", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textLessThan(String value) {
			addCriterion("code_text <", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textLessThanOrEqualTo(String value) {
			addCriterion("code_text <=", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textLike(String value) {
			addCriterion("code_text like", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textNotLike(String value) {
			addCriterion("code_text not like", value, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textIn(List<String> values) {
			addCriterion("code_text in", values, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textNotIn(List<String> values) {
			addCriterion("code_text not in", values, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textBetween(String value1, String value2) {
			addCriterion("code_text between", value1, value2, "code_text");
			return (Criteria) this;
		}

		public Criteria andCode_textNotBetween(String value1, String value2) {
			addCriterion("code_text not between", value1, value2, "code_text");
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

		public Criteria andStore_rangeIsNull() {
			addCriterion("store_range is null");
			return (Criteria) this;
		}

		public Criteria andStore_rangeIsNotNull() {
			addCriterion("store_range is not null");
			return (Criteria) this;
		}

		public Criteria andStore_rangeEqualTo(String value) {
			addCriterion("store_range =", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeNotEqualTo(String value) {
			addCriterion("store_range <>", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeGreaterThan(String value) {
			addCriterion("store_range >", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeGreaterThanOrEqualTo(String value) {
			addCriterion("store_range >=", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeLessThan(String value) {
			addCriterion("store_range <", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeLessThanOrEqualTo(String value) {
			addCriterion("store_range <=", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeLike(String value) {
			addCriterion("store_range like", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeNotLike(String value) {
			addCriterion("store_range not like", value, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeIn(List<String> values) {
			addCriterion("store_range in", values, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeNotIn(List<String> values) {
			addCriterion("store_range not in", values, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeBetween(String value1, String value2) {
			addCriterion("store_range between", value1, value2, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_rangeNotBetween(String value1, String value2) {
			addCriterion("store_range not between", value1, value2, "store_range");
			return (Criteria) this;
		}

		public Criteria andStore_dirIsNull() {
			addCriterion("store_dir is null");
			return (Criteria) this;
		}

		public Criteria andStore_dirIsNotNull() {
			addCriterion("store_dir is not null");
			return (Criteria) this;
		}

		public Criteria andStore_dirEqualTo(String value) {
			addCriterion("store_dir =", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirNotEqualTo(String value) {
			addCriterion("store_dir <>", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirGreaterThan(String value) {
			addCriterion("store_dir >", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirGreaterThanOrEqualTo(String value) {
			addCriterion("store_dir >=", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirLessThan(String value) {
			addCriterion("store_dir <", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirLessThanOrEqualTo(String value) {
			addCriterion("store_dir <=", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirLike(String value) {
			addCriterion("store_dir like", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirNotLike(String value) {
			addCriterion("store_dir not like", value, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirIn(List<String> values) {
			addCriterion("store_dir in", values, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirNotIn(List<String> values) {
			addCriterion("store_dir not in", values, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirBetween(String value1, String value2) {
			addCriterion("store_dir between", value1, value2, "store_dir");
			return (Criteria) this;
		}

		public Criteria andStore_dirNotBetween(String value1, String value2) {
			addCriterion("store_dir not between", value1, value2, "store_dir");
			return (Criteria) this;
		}

		public Criteria andSort_orderIsNull() {
			addCriterion("sort_order is null");
			return (Criteria) this;
		}

		public Criteria andSort_orderIsNotNull() {
			addCriterion("sort_order is not null");
			return (Criteria) this;
		}

		public Criteria andSort_orderEqualTo(Byte value) {
			addCriterion("sort_order =", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderNotEqualTo(Byte value) {
			addCriterion("sort_order <>", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderGreaterThan(Byte value) {
			addCriterion("sort_order >", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderGreaterThanOrEqualTo(Byte value) {
			addCriterion("sort_order >=", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderLessThan(Byte value) {
			addCriterion("sort_order <", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderLessThanOrEqualTo(Byte value) {
			addCriterion("sort_order <=", value, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderIn(List<Byte> values) {
			addCriterion("sort_order in", values, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderNotIn(List<Byte> values) {
			addCriterion("sort_order not in", values, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderBetween(Byte value1, Byte value2) {
			addCriterion("sort_order between", value1, value2, "sort_order");
			return (Criteria) this;
		}

		public Criteria andSort_orderNotBetween(Byte value1, Byte value2) {
			addCriterion("sort_order not between", value1, value2, "sort_order");
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

		public Criteria andIsvoidIsNull() {
			addCriterion("isvoid is null");
			return (Criteria) this;
		}

		public Criteria andIsvoidIsNotNull() {
			addCriterion("isvoid is not null");
			return (Criteria) this;
		}

		public Criteria andIsvoidEqualTo(String value) {
			addCriterion("isvoid =", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidNotEqualTo(String value) {
			addCriterion("isvoid <>", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidGreaterThan(String value) {
			addCriterion("isvoid >", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidGreaterThanOrEqualTo(String value) {
			addCriterion("isvoid >=", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidLessThan(String value) {
			addCriterion("isvoid <", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidLessThanOrEqualTo(String value) {
			addCriterion("isvoid <=", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidLike(String value) {
			addCriterion("isvoid like", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidNotLike(String value) {
			addCriterion("isvoid not like", value, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidIn(List<String> values) {
			addCriterion("isvoid in", values, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidNotIn(List<String> values) {
			addCriterion("isvoid not in", values, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidBetween(String value1, String value2) {
			addCriterion("isvoid between", value1, value2, "isvoid");
			return (Criteria) this;
		}

		public Criteria andIsvoidNotBetween(String value1, String value2) {
			addCriterion("isvoid not between", value1, value2, "isvoid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_shop_config
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
     * This class corresponds to the database table hai_shop_config
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}