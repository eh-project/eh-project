package com.ehais.school_weixin.model;

import java.math.BigDecimal;

public class HaiVolumePrice extends HaiVolumePriceKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_volume_price.volume_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private BigDecimal volume_price;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_volume_price.volume_price
	 * @return  the value of hai_volume_price.volume_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public BigDecimal getVolume_price() {
		return volume_price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_volume_price.volume_price
	 * @param volume_price  the value for hai_volume_price.volume_price
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setVolume_price(BigDecimal volume_price) {
		this.volume_price = volume_price;
	}
}