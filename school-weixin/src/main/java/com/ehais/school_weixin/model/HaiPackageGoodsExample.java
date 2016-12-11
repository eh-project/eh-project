package com.ehais.school_weixin.model;

import java.util.ArrayList;
import java.util.List;

public class HaiPackageGoodsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public HaiPackageGoodsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_package_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_package_goods
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

		public Criteria andPackage_idIsNull() {
			addCriterion("package_id is null");
			return (Criteria) this;
		}

		public Criteria andPackage_idIsNotNull() {
			addCriterion("package_id is not null");
			return (Criteria) this;
		}

		public Criteria andPackage_idEqualTo(Integer value) {
			addCriterion("package_id =", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idNotEqualTo(Integer value) {
			addCriterion("package_id <>", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idGreaterThan(Integer value) {
			addCriterion("package_id >", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("package_id >=", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idLessThan(Integer value) {
			addCriterion("package_id <", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idLessThanOrEqualTo(Integer value) {
			addCriterion("package_id <=", value, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idIn(List<Integer> values) {
			addCriterion("package_id in", values, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idNotIn(List<Integer> values) {
			addCriterion("package_id not in", values, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idBetween(Integer value1, Integer value2) {
			addCriterion("package_id between", value1, value2, "package_id");
			return (Criteria) this;
		}

		public Criteria andPackage_idNotBetween(Integer value1, Integer value2) {
			addCriterion("package_id not between", value1, value2, "package_id");
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

		public Criteria andGoods_idEqualTo(Integer value) {
			addCriterion("goods_id =", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotEqualTo(Integer value) {
			addCriterion("goods_id <>", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThan(Integer value) {
			addCriterion("goods_id >", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("goods_id >=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThan(Integer value) {
			addCriterion("goods_id <", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idLessThanOrEqualTo(Integer value) {
			addCriterion("goods_id <=", value, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idIn(List<Integer> values) {
			addCriterion("goods_id in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotIn(List<Integer> values) {
			addCriterion("goods_id not in", values, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idBetween(Integer value1, Integer value2) {
			addCriterion("goods_id between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andGoods_idNotBetween(Integer value1, Integer value2) {
			addCriterion("goods_id not between", value1, value2, "goods_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idIsNull() {
			addCriterion("admin_id is null");
			return (Criteria) this;
		}

		public Criteria andAdmin_idIsNotNull() {
			addCriterion("admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdmin_idEqualTo(Byte value) {
			addCriterion("admin_id =", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idNotEqualTo(Byte value) {
			addCriterion("admin_id <>", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idGreaterThan(Byte value) {
			addCriterion("admin_id >", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idGreaterThanOrEqualTo(Byte value) {
			addCriterion("admin_id >=", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idLessThan(Byte value) {
			addCriterion("admin_id <", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idLessThanOrEqualTo(Byte value) {
			addCriterion("admin_id <=", value, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idIn(List<Byte> values) {
			addCriterion("admin_id in", values, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idNotIn(List<Byte> values) {
			addCriterion("admin_id not in", values, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idBetween(Byte value1, Byte value2) {
			addCriterion("admin_id between", value1, value2, "admin_id");
			return (Criteria) this;
		}

		public Criteria andAdmin_idNotBetween(Byte value1, Byte value2) {
			addCriterion("admin_id not between", value1, value2, "admin_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idIsNull() {
			addCriterion("product_id is null");
			return (Criteria) this;
		}

		public Criteria andProduct_idIsNotNull() {
			addCriterion("product_id is not null");
			return (Criteria) this;
		}

		public Criteria andProduct_idEqualTo(Integer value) {
			addCriterion("product_id =", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idNotEqualTo(Integer value) {
			addCriterion("product_id <>", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idGreaterThan(Integer value) {
			addCriterion("product_id >", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
			addCriterion("product_id >=", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idLessThan(Integer value) {
			addCriterion("product_id <", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
			addCriterion("product_id <=", value, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idIn(List<Integer> values) {
			addCriterion("product_id in", values, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idNotIn(List<Integer> values) {
			addCriterion("product_id not in", values, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idBetween(Integer value1, Integer value2) {
			addCriterion("product_id between", value1, value2, "product_id");
			return (Criteria) this;
		}

		public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
			addCriterion("product_id not between", value1, value2, "product_id");
			return (Criteria) this;
		}

		public Criteria andGoods_numberIsNull() {
			addCriterion("goods_number is null");
			return (Criteria) this;
		}

		public Criteria andGoods_numberIsNotNull() {
			addCriterion("goods_number is not null");
			return (Criteria) this;
		}

		public Criteria andGoods_numberEqualTo(Short value) {
			addCriterion("goods_number =", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberNotEqualTo(Short value) {
			addCriterion("goods_number <>", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberGreaterThan(Short value) {
			addCriterion("goods_number >", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberGreaterThanOrEqualTo(Short value) {
			addCriterion("goods_number >=", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberLessThan(Short value) {
			addCriterion("goods_number <", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberLessThanOrEqualTo(Short value) {
			addCriterion("goods_number <=", value, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberIn(List<Short> values) {
			addCriterion("goods_number in", values, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberNotIn(List<Short> values) {
			addCriterion("goods_number not in", values, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberBetween(Short value1, Short value2) {
			addCriterion("goods_number between", value1, value2, "goods_number");
			return (Criteria) this;
		}

		public Criteria andGoods_numberNotBetween(Short value1, Short value2) {
			addCriterion("goods_number not between", value1, value2, "goods_number");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table hai_package_goods
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
     * This class corresponds to the database table hai_package_goods
     *
     * @mbg.generated do_not_delete_during_merge Mon Dec 05 15:49:07 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}