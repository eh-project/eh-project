package com.ehais.school_weixin.model;

public class HaiVolumePriceKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_volume_price.price_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Boolean price_type;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_volume_price.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer goods_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_volume_price.volume_number
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Short volume_number;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_volume_price.price_type
	 * @return  the value of hai_volume_price.price_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Boolean getPrice_type() {
		return price_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_volume_price.price_type
	 * @param price_type  the value for hai_volume_price.price_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPrice_type(Boolean price_type) {
		this.price_type = price_type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_volume_price.goods_id
	 * @return  the value of hai_volume_price.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getGoods_id() {
		return goods_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_volume_price.goods_id
	 * @param goods_id  the value for hai_volume_price.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_volume_price.volume_number
	 * @return  the value of hai_volume_price.volume_number
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Short getVolume_number() {
		return volume_number;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_volume_price.volume_number
	 * @param volume_number  the value for hai_volume_price.volume_number
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setVolume_number(Short volume_number) {
		this.volume_number = volume_number;
	}
}