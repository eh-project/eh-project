package com.ehais.school_weixin.model;

public class HaiSessionsData {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_sessions_data.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String sesskey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_sessions_data.expiry
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer expiry;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_sessions_data.data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String data;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_sessions_data.sesskey
	 * @return  the value of hai_sessions_data.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getSesskey() {
		return sesskey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_sessions_data.sesskey
	 * @param sesskey  the value for hai_sessions_data.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setSesskey(String sesskey) {
		this.sesskey = sesskey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_sessions_data.expiry
	 * @return  the value of hai_sessions_data.expiry
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getExpiry() {
		return expiry;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_sessions_data.expiry
	 * @param expiry  the value for hai_sessions_data.expiry
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setExpiry(Integer expiry) {
		this.expiry = expiry;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_sessions_data.data
	 * @return  the value of hai_sessions_data.data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getData() {
		return data;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_sessions_data.data
	 * @param data  the value for hai_sessions_data.data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setData(String data) {
		this.data = data;
	}
}