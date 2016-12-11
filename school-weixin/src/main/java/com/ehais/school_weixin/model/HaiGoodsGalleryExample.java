package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiGoodsGalleryExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiGoodsGalleryExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_gallery
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_goods_gallery
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

		public Criteria andImg_idIsNull() {
			addCriterion("img_id is null");
			return (Criteria) this;
		}

		public Criteria andImg_idIsNotNull() {
			addCriterion("img_id is not null");
			return (Criteria) this;
		}

		public Criteria andImg_idEqualTo(Long value) {
			addCriterion("img_id =", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idNotEqualTo(Long value) {
			addCriterion("img_id <>", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idGreaterThan(Long value) {
			addCriterion("img_id >", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idGreaterThanOrEqualTo(Long value) {
			addCriterion("img_id >=", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idLessThan(Long value) {
			addCriterion("img_id <", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idLessThanOrEqualTo(Long value) {
			addCriterion("img_id <=", value, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idIn(List<Long> values) {
			addCriterion("img_id in", values, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idNotIn(List<Long> values) {
			addCriterion("img_id not in", values, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idBetween(Long value1, Long value2) {
			addCriterion("img_id between", value1, value2, "img_id");
			return (Criteria) this;
		}

		public Criteria andImg_idNotBetween(Long value1, Long value2) {
			addCriterion("img_id not between", value1, value2, "img_id");
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

		public Criteria andUser_idEqualTo(Long value) {
			addCriterion("user_id =", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThan(Long value) {
			addCriterion("user_id >", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThan(Long value) {
			addCriterion("user_id <", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idIn(List<Long> values) {
			addCriterion("user_id in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andUser_idNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "user_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idIsNull() {
			addCriterion("goods_id is null");
			return (Criteria) this;
		}

		public Criteria andGoods_idIsNotNull() {
			addCriterion("goods_id is not null");
			return (Criteria) this;
		}

		public Criteria andGoods_idEqualTo(Long value) {
			addCriterion("goods_id =", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotEqualTo(Long value) {
			addCriterion("goods_id <>", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThan(Long value) {
			addCriterion("goods_id >", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_id >=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThan(Long value) {
			addCriterion("goods_id <", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThanOrEqualTo(Long value) {
			addCriterion("goods_id <=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idIn(List<Long> values) {
			addCriterion("goods_id in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotIn(List<Long> values) {
			addCriterion("goods_id not in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idBetween(Long value1, Long value2) {
			addCriterion("goods_id between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotBetween(Long value1, Long value2) {
			addCriterion("goods_id not between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andTable_nameIsNull() {
			addCriterion("table_name is null");
			return (Criteria) this;
		}

		public Criteria andTable_nameIsNotNull() {
			addCriterion("table_name is not null");
			return (Criteria) this;
		}

		public Criteria andTable_nameEqualTo(String value) {
			addCriterion("table_name =", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameNotEqualTo(String value) {
			addCriterion("table_name <>", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameGreaterThan(String value) {
			addCriterion("table_name >", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameGreaterThanOrEqualTo(String value) {
			addCriterion("table_name >=", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameLessThan(String value) {
			addCriterion("table_name <", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameLessThanOrEqualTo(String value) {
			addCriterion("table_name <=", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameLike(String value) {
			addCriterion("table_name like", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameNotLike(String value) {
			addCriterion("table_name not like", value, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameIn(List<String> values) {
			addCriterion("table_name in", values, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameNotIn(List<String> values) {
			addCriterion("table_name not in", values, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameBetween(String value1, String value2) {
			addCriterion("table_name between", value1, value2, "table_name");
			return (Criteria) this;
		}

		public Criteria andTable_nameNotBetween(String value1, String value2) {
			addCriterion("table_name not between", value1, value2, "table_name");
			return (Criteria) this;
		}

		public Criteria andImg_urlIsNull() {
			addCriterion("img_url is null");
			return (Criteria) this;
		}

		public Criteria andImg_urlIsNotNull() {
			addCriterion("img_url is not null");
			return (Criteria) this;
		}

		public Criteria andImg_urlEqualTo(String value) {
			addCriterion("img_url =", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlNotEqualTo(String value) {
			addCriterion("img_url <>", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlGreaterThan(String value) {
			addCriterion("img_url >", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlGreaterThanOrEqualTo(String value) {
			addCriterion("img_url >=", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlLessThan(String value) {
			addCriterion("img_url <", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlLessThanOrEqualTo(String value) {
			addCriterion("img_url <=", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlLike(String value) {
			addCriterion("img_url like", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlNotLike(String value) {
			addCriterion("img_url not like", value, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlIn(List<String> values) {
			addCriterion("img_url in", values, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlNotIn(List<String> values) {
			addCriterion("img_url not in", values, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlBetween(String value1, String value2) {
			addCriterion("img_url between", value1, value2, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_urlNotBetween(String value1, String value2) {
			addCriterion("img_url not between", value1, value2, "img_url");
			return (Criteria) this;
		}

		public Criteria andImg_descIsNull() {
			addCriterion("img_desc is null");
			return (Criteria) this;
		}

		public Criteria andImg_descIsNotNull() {
			addCriterion("img_desc is not null");
			return (Criteria) this;
		}

		public Criteria andImg_descEqualTo(String value) {
			addCriterion("img_desc =", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descNotEqualTo(String value) {
			addCriterion("img_desc <>", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descGreaterThan(String value) {
			addCriterion("img_desc >", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descGreaterThanOrEqualTo(String value) {
			addCriterion("img_desc >=", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descLessThan(String value) {
			addCriterion("img_desc <", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descLessThanOrEqualTo(String value) {
			addCriterion("img_desc <=", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descLike(String value) {
			addCriterion("img_desc like", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descNotLike(String value) {
			addCriterion("img_desc not like", value, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descIn(List<String> values) {
			addCriterion("img_desc in", values, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descNotIn(List<String> values) {
			addCriterion("img_desc not in", values, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descBetween(String value1, String value2) {
			addCriterion("img_desc between", value1, value2, "img_desc");
			return (Criteria) this;
		}

		public Criteria andImg_descNotBetween(String value1, String value2) {
			addCriterion("img_desc not between", value1, value2, "img_desc");
			return (Criteria) this;
		}

		public Criteria andThumb_urlIsNull() {
			addCriterion("thumb_url is null");
			return (Criteria) this;
		}

		public Criteria andThumb_urlIsNotNull() {
			addCriterion("thumb_url is not null");
			return (Criteria) this;
		}

		public Criteria andThumb_urlEqualTo(String value) {
			addCriterion("thumb_url =", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlNotEqualTo(String value) {
			addCriterion("thumb_url <>", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlGreaterThan(String value) {
			addCriterion("thumb_url >", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlGreaterThanOrEqualTo(String value) {
			addCriterion("thumb_url >=", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlLessThan(String value) {
			addCriterion("thumb_url <", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlLessThanOrEqualTo(String value) {
			addCriterion("thumb_url <=", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlLike(String value) {
			addCriterion("thumb_url like", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlNotLike(String value) {
			addCriterion("thumb_url not like", value, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlIn(List<String> values) {
			addCriterion("thumb_url in", values, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlNotIn(List<String> values) {
			addCriterion("thumb_url not in", values, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlBetween(String value1, String value2) {
			addCriterion("thumb_url between", value1, value2, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andThumb_urlNotBetween(String value1, String value2) {
			addCriterion("thumb_url not between", value1, value2, "thumb_url");
			return (Criteria) this;
		}

		public Criteria andImg_originalIsNull() {
			addCriterion("img_original is null");
			return (Criteria) this;
		}

		public Criteria andImg_originalIsNotNull() {
			addCriterion("img_original is not null");
			return (Criteria) this;
		}

		public Criteria andImg_originalEqualTo(String value) {
			addCriterion("img_original =", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalNotEqualTo(String value) {
			addCriterion("img_original <>", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalGreaterThan(String value) {
			addCriterion("img_original >", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalGreaterThanOrEqualTo(String value) {
			addCriterion("img_original >=", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalLessThan(String value) {
			addCriterion("img_original <", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalLessThanOrEqualTo(String value) {
			addCriterion("img_original <=", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalLike(String value) {
			addCriterion("img_original like", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalNotLike(String value) {
			addCriterion("img_original not like", value, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalIn(List<String> values) {
			addCriterion("img_original in", values, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalNotIn(List<String> values) {
			addCriterion("img_original not in", values, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalBetween(String value1, String value2) {
			addCriterion("img_original between", value1, value2, "img_original");
			return (Criteria) this;
		}

		public Criteria andImg_originalNotBetween(String value1, String value2) {
			addCriterion("img_original not between", value1, value2, "img_original");
			return (Criteria) this;
		}

		public Criteria andGallery_typeIsNull() {
			addCriterion("gallery_type is null");
			return (Criteria) this;
		}

		public Criteria andGallery_typeIsNotNull() {
			addCriterion("gallery_type is not null");
			return (Criteria) this;
		}

		public Criteria andGallery_typeEqualTo(Short value) {
			addCriterion("gallery_type =", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeNotEqualTo(Short value) {
			addCriterion("gallery_type <>", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeGreaterThan(Short value) {
			addCriterion("gallery_type >", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeGreaterThanOrEqualTo(Short value) {
			addCriterion("gallery_type >=", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeLessThan(Short value) {
			addCriterion("gallery_type <", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeLessThanOrEqualTo(Short value) {
			addCriterion("gallery_type <=", value, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeIn(List<Short> values) {
			addCriterion("gallery_type in", values, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeNotIn(List<Short> values) {
			addCriterion("gallery_type not in", values, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeBetween(Short value1, Short value2) {
			addCriterion("gallery_type between", value1, value2, "gallery_type");
			return (Criteria) this;
		}

		public Criteria andGallery_typeNotBetween(Short value1, Short value2) {
			addCriterion("gallery_type not between", value1, value2, "gallery_type");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_goods_gallery
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
     * This class corresponds to the database table hai_goods_gallery
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}