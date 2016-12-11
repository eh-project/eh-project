package com.ehais.school_weixin.model;

import java.math.BigDecimal;

public class HaiPayLog {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_pay_log.log_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer log_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_pay_log.order_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer order_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_pay_log.order_amount
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private BigDecimal order_amount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_pay_log.order_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Boolean order_type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_pay_log.is_paid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Boolean is_paid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_pay_log.log_id
	 * @return  the value of hai_pay_log.log_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getLog_id() {
		return log_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_pay_log.log_id
	 * @param log_id  the value for hai_pay_log.log_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_pay_log.order_id
	 * @return  the value of hai_pay_log.order_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getOrder_id() {
		return order_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_pay_log.order_id
	 * @param order_id  the value for hai_pay_log.order_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_pay_log.order_amount
	 * @return  the value of hai_pay_log.order_amount
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public BigDecimal getOrder_amount() {
		return order_amount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_pay_log.order_amount
	 * @param order_amount  the value for hai_pay_log.order_amount
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrder_amount(BigDecimal order_amount) {
		this.order_amount = order_amount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_pay_log.order_type
	 * @return  the value of hai_pay_log.order_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Boolean getOrder_type() {
		return order_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_pay_log.order_type
	 * @param order_type  the value for hai_pay_log.order_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setOrder_type(Boolean order_type) {
		this.order_type = order_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_pay_log.is_paid
	 * @return  the value of hai_pay_log.is_paid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Boolean getIs_paid() {
		return is_paid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_pay_log.is_paid
	 * @param is_paid  the value for hai_pay_log.is_paid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setIs_paid(Boolean is_paid) {
		this.is_paid = is_paid;
	}
}