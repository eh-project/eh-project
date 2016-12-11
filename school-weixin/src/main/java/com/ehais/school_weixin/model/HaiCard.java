package com.ehais.school_weixin.model;

import java.math.BigDecimal;

public class HaiCard {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.card_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Byte card_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.card_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String card_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.card_img
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String card_img;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.card_fee
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private BigDecimal card_fee;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.free_money
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private BigDecimal free_money;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.card_desc
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String card_desc;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_card.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer store_id;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.card_id
	 * @return  the value of hai_card.card_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Byte getCard_id() {
		return card_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.card_id
	 * @param card_id  the value for hai_card.card_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCard_id(Byte card_id) {
		this.card_id = card_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.card_name
	 * @return  the value of hai_card.card_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getCard_name() {
		return card_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.card_name
	 * @param card_name  the value for hai_card.card_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.card_img
	 * @return  the value of hai_card.card_img
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getCard_img() {
		return card_img;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.card_img
	 * @param card_img  the value for hai_card.card_img
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCard_img(String card_img) {
		this.card_img = card_img;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.card_fee
	 * @return  the value of hai_card.card_fee
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public BigDecimal getCard_fee() {
		return card_fee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.card_fee
	 * @param card_fee  the value for hai_card.card_fee
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCard_fee(BigDecimal card_fee) {
		this.card_fee = card_fee;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.free_money
	 * @return  the value of hai_card.free_money
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public BigDecimal getFree_money() {
		return free_money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.free_money
	 * @param free_money  the value for hai_card.free_money
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setFree_money(BigDecimal free_money) {
		this.free_money = free_money;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.card_desc
	 * @return  the value of hai_card.card_desc
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getCard_desc() {
		return card_desc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.card_desc
	 * @param card_desc  the value for hai_card.card_desc
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCard_desc(String card_desc) {
		this.card_desc = card_desc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_card.store_id
	 * @return  the value of hai_card.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getStore_id() {
		return store_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_card.store_id
	 * @param store_id  the value for hai_card.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
}