package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class WxNavExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public WxNavExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wx_nav
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCtypeIsNull() {
			addCriterion("ctype is null");
			return (Criteria) this;
		}

		public Criteria andCtypeIsNotNull() {
			addCriterion("ctype is not null");
			return (Criteria) this;
		}

		public Criteria andCtypeEqualTo(String value) {
			addCriterion("ctype =", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeNotEqualTo(String value) {
			addCriterion("ctype <>", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeGreaterThan(String value) {
			addCriterion("ctype >", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeGreaterThanOrEqualTo(String value) {
			addCriterion("ctype >=", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeLessThan(String value) {
			addCriterion("ctype <", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeLessThanOrEqualTo(String value) {
			addCriterion("ctype <=", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeLike(String value) {
			addCriterion("ctype like", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeNotLike(String value) {
			addCriterion("ctype not like", value, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeIn(List<String> values) {
			addCriterion("ctype in", values, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeNotIn(List<String> values) {
			addCriterion("ctype not in", values, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeBetween(String value1, String value2) {
			addCriterion("ctype between", value1, value2, "ctype");
			return (Criteria) this;
		}

		public Criteria andCtypeNotBetween(String value1, String value2) {
			addCriterion("ctype not between", value1, value2, "ctype");
			return (Criteria) this;
		}

		public Criteria andCidIsNull() {
			addCriterion("cid is null");
			return (Criteria) this;
		}

		public Criteria andCidIsNotNull() {
			addCriterion("cid is not null");
			return (Criteria) this;
		}

		public Criteria andCidEqualTo(Short value) {
			addCriterion("cid =", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotEqualTo(Short value) {
			addCriterion("cid <>", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThan(Short value) {
			addCriterion("cid >", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThanOrEqualTo(Short value) {
			addCriterion("cid >=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThan(Short value) {
			addCriterion("cid <", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThanOrEqualTo(Short value) {
			addCriterion("cid <=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidIn(List<Short> values) {
			addCriterion("cid in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotIn(List<Short> values) {
			addCriterion("cid not in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidBetween(Short value1, Short value2) {
			addCriterion("cid between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotBetween(Short value1, Short value2) {
			addCriterion("cid not between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andIfshowIsNull() {
			addCriterion("ifshow is null");
			return (Criteria) this;
		}

		public Criteria andIfshowIsNotNull() {
			addCriterion("ifshow is not null");
			return (Criteria) this;
		}

		public Criteria andIfshowEqualTo(Short value) {
			addCriterion("ifshow =", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowNotEqualTo(Short value) {
			addCriterion("ifshow <>", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowGreaterThan(Short value) {
			addCriterion("ifshow >", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowGreaterThanOrEqualTo(Short value) {
			addCriterion("ifshow >=", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowLessThan(Short value) {
			addCriterion("ifshow <", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowLessThanOrEqualTo(Short value) {
			addCriterion("ifshow <=", value, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowIn(List<Short> values) {
			addCriterion("ifshow in", values, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowNotIn(List<Short> values) {
			addCriterion("ifshow not in", values, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowBetween(Short value1, Short value2) {
			addCriterion("ifshow between", value1, value2, "ifshow");
			return (Criteria) this;
		}

		public Criteria andIfshowNotBetween(Short value1, Short value2) {
			addCriterion("ifshow not between", value1, value2, "ifshow");
			return (Criteria) this;
		}

		public Criteria andVieworderIsNull() {
			addCriterion("vieworder is null");
			return (Criteria) this;
		}

		public Criteria andVieworderIsNotNull() {
			addCriterion("vieworder is not null");
			return (Criteria) this;
		}

		public Criteria andVieworderEqualTo(Short value) {
			addCriterion("vieworder =", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderNotEqualTo(Short value) {
			addCriterion("vieworder <>", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderGreaterThan(Short value) {
			addCriterion("vieworder >", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderGreaterThanOrEqualTo(Short value) {
			addCriterion("vieworder >=", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderLessThan(Short value) {
			addCriterion("vieworder <", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderLessThanOrEqualTo(Short value) {
			addCriterion("vieworder <=", value, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderIn(List<Short> values) {
			addCriterion("vieworder in", values, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderNotIn(List<Short> values) {
			addCriterion("vieworder not in", values, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderBetween(Short value1, Short value2) {
			addCriterion("vieworder between", value1, value2, "vieworder");
			return (Criteria) this;
		}

		public Criteria andVieworderNotBetween(Short value1, Short value2) {
			addCriterion("vieworder not between", value1, value2, "vieworder");
			return (Criteria) this;
		}

		public Criteria andOpennewIsNull() {
			addCriterion("opennew is null");
			return (Criteria) this;
		}

		public Criteria andOpennewIsNotNull() {
			addCriterion("opennew is not null");
			return (Criteria) this;
		}

		public Criteria andOpennewEqualTo(Short value) {
			addCriterion("opennew =", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewNotEqualTo(Short value) {
			addCriterion("opennew <>", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewGreaterThan(Short value) {
			addCriterion("opennew >", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewGreaterThanOrEqualTo(Short value) {
			addCriterion("opennew >=", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewLessThan(Short value) {
			addCriterion("opennew <", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewLessThanOrEqualTo(Short value) {
			addCriterion("opennew <=", value, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewIn(List<Short> values) {
			addCriterion("opennew in", values, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewNotIn(List<Short> values) {
			addCriterion("opennew not in", values, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewBetween(Short value1, Short value2) {
			addCriterion("opennew between", value1, value2, "opennew");
			return (Criteria) this;
		}

		public Criteria andOpennewNotBetween(Short value1, Short value2) {
			addCriterion("opennew not between", value1, value2, "opennew");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
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

		public Criteria andClassNameIsNull() {
			addCriterion("className is null");
			return (Criteria) this;
		}

		public Criteria andClassNameIsNotNull() {
			addCriterion("className is not null");
			return (Criteria) this;
		}

		public Criteria andClassNameEqualTo(String value) {
			addCriterion("className =", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotEqualTo(String value) {
			addCriterion("className <>", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThan(String value) {
			addCriterion("className >", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameGreaterThanOrEqualTo(String value) {
			addCriterion("className >=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThan(String value) {
			addCriterion("className <", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLessThanOrEqualTo(String value) {
			addCriterion("className <=", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameLike(String value) {
			addCriterion("className like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotLike(String value) {
			addCriterion("className not like", value, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameIn(List<String> values) {
			addCriterion("className in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotIn(List<String> values) {
			addCriterion("className not in", values, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameBetween(String value1, String value2) {
			addCriterion("className between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andClassNameNotBetween(String value1, String value2) {
			addCriterion("className not between", value1, value2, "className");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idIsNull() {
			addCriterion("parent_nav_id is null");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idIsNotNull() {
			addCriterion("parent_nav_id is not null");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idEqualTo(Integer value) {
			addCriterion("parent_nav_id =", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idNotEqualTo(Integer value) {
			addCriterion("parent_nav_id <>", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idGreaterThan(Integer value) {
			addCriterion("parent_nav_id >", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("parent_nav_id >=", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idLessThan(Integer value) {
			addCriterion("parent_nav_id <", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idLessThanOrEqualTo(Integer value) {
			addCriterion("parent_nav_id <=", value, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idIn(List<Integer> values) {
			addCriterion("parent_nav_id in", values, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idNotIn(List<Integer> values) {
			addCriterion("parent_nav_id not in", values, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idBetween(Integer value1, Integer value2) {
			addCriterion("parent_nav_id between", value1, value2, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andParent_nav_idNotBetween(Integer value1, Integer value2) {
			addCriterion("parent_nav_id not between", value1, value2, "parent_nav_id");
			return (Criteria) this;
		}

		public Criteria andThumbIsNull() {
			addCriterion("thumb is null");
			return (Criteria) this;
		}

		public Criteria andThumbIsNotNull() {
			addCriterion("thumb is not null");
			return (Criteria) this;
		}

		public Criteria andThumbEqualTo(String value) {
			addCriterion("thumb =", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbNotEqualTo(String value) {
			addCriterion("thumb <>", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbGreaterThan(String value) {
			addCriterion("thumb >", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbGreaterThanOrEqualTo(String value) {
			addCriterion("thumb >=", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbLessThan(String value) {
			addCriterion("thumb <", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbLessThanOrEqualTo(String value) {
			addCriterion("thumb <=", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbLike(String value) {
			addCriterion("thumb like", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbNotLike(String value) {
			addCriterion("thumb not like", value, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbIn(List<String> values) {
			addCriterion("thumb in", values, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbNotIn(List<String> values) {
			addCriterion("thumb not in", values, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbBetween(String value1, String value2) {
			addCriterion("thumb between", value1, value2, "thumb");
			return (Criteria) this;
		}

		public Criteria andThumbNotBetween(String value1, String value2) {
			addCriterion("thumb not between", value1, value2, "thumb");
			return (Criteria) this;
		}

		public Criteria andImageIsNull() {
			addCriterion("image is null");
			return (Criteria) this;
		}

		public Criteria andImageIsNotNull() {
			addCriterion("image is not null");
			return (Criteria) this;
		}

		public Criteria andImageEqualTo(String value) {
			addCriterion("image =", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageNotEqualTo(String value) {
			addCriterion("image <>", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageGreaterThan(String value) {
			addCriterion("image >", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageGreaterThanOrEqualTo(String value) {
			addCriterion("image >=", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageLessThan(String value) {
			addCriterion("image <", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageLessThanOrEqualTo(String value) {
			addCriterion("image <=", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageLike(String value) {
			addCriterion("image like", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageNotLike(String value) {
			addCriterion("image not like", value, "image");
			return (Criteria) this;
		}

		public Criteria andImageIn(List<String> values) {
			addCriterion("image in", values, "image");
			return (Criteria) this;
		}

		public Criteria andImageNotIn(List<String> values) {
			addCriterion("image not in", values, "image");
			return (Criteria) this;
		}

		public Criteria andImageBetween(String value1, String value2) {
			addCriterion("image between", value1, value2, "image");
			return (Criteria) this;
		}

		public Criteria andImageNotBetween(String value1, String value2) {
			addCriterion("image not between", value1, value2, "image");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table wx_nav
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
     * This class corresponds to the database table wx_nav
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}