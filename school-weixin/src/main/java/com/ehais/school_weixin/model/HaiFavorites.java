package com.ehais.school_weixin.model;

import java.util.Date;

public class HaiFavorites {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer user_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer goods_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.add_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date add_time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String sesskey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_favorites.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer store_id;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.id
	 * @return  the value of hai_favorites.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.id
	 * @param id  the value for hai_favorites.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.user_id
	 * @return  the value of hai_favorites.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.user_id
	 * @param user_id  the value for hai_favorites.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.goods_id
	 * @return  the value of hai_favorites.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getGoods_id() {
		return goods_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.goods_id
	 * @param goods_id  the value for hai_favorites.goods_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.add_time
	 * @return  the value of hai_favorites.add_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getAdd_time() {
		return add_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.add_time
	 * @param add_time  the value for hai_favorites.add_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.sesskey
	 * @return  the value of hai_favorites.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getSesskey() {
		return sesskey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.sesskey
	 * @param sesskey  the value for hai_favorites.sesskey
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setSesskey(String sesskey) {
		this.sesskey = sesskey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_favorites.store_id
	 * @return  the value of hai_favorites.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getStore_id() {
		return store_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_favorites.store_id
	 * @param store_id  the value for hai_favorites.store_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
}