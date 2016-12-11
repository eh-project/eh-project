package com.ehais.school_weixin.model;

import java.util.Date;

public class WyExpense {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.expense_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer expense_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.charge_method_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer charge_method_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.homeowner_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer homeowner_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.homeowner_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String homeowner_name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.community_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer community_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.house_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer house_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.building_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer building_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date start_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date end_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.previous_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Double previous_degree;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.now_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Double now_degree;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wy_expense.remark
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String remark;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.expense_id
	 * @return  the value of wy_expense.expense_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getExpense_id() {
		return expense_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.expense_id
	 * @param expense_id  the value for wy_expense.expense_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setExpense_id(Integer expense_id) {
		this.expense_id = expense_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.charge_method_id
	 * @return  the value of wy_expense.charge_method_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getCharge_method_id() {
		return charge_method_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.charge_method_id
	 * @param charge_method_id  the value for wy_expense.charge_method_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCharge_method_id(Integer charge_method_id) {
		this.charge_method_id = charge_method_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.homeowner_id
	 * @return  the value of wy_expense.homeowner_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getHomeowner_id() {
		return homeowner_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.homeowner_id
	 * @param homeowner_id  the value for wy_expense.homeowner_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setHomeowner_id(Integer homeowner_id) {
		this.homeowner_id = homeowner_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.homeowner_name
	 * @return  the value of wy_expense.homeowner_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getHomeowner_name() {
		return homeowner_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.homeowner_name
	 * @param homeowner_name  the value for wy_expense.homeowner_name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setHomeowner_name(String homeowner_name) {
		this.homeowner_name = homeowner_name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.community_id
	 * @return  the value of wy_expense.community_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getCommunity_id() {
		return community_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.community_id
	 * @param community_id  the value for wy_expense.community_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCommunity_id(Integer community_id) {
		this.community_id = community_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.house_id
	 * @return  the value of wy_expense.house_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getHouse_id() {
		return house_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.house_id
	 * @param house_id  the value for wy_expense.house_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.building_id
	 * @return  the value of wy_expense.building_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getBuilding_id() {
		return building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.building_id
	 * @param building_id  the value for wy_expense.building_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setBuilding_id(Integer building_id) {
		this.building_id = building_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.start_date
	 * @return  the value of wy_expense.start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.start_date
	 * @param start_date  the value for wy_expense.start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.end_date
	 * @return  the value of wy_expense.end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.end_date
	 * @param end_date  the value for wy_expense.end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.previous_degree
	 * @return  the value of wy_expense.previous_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Double getPrevious_degree() {
		return previous_degree;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.previous_degree
	 * @param previous_degree  the value for wy_expense.previous_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPrevious_degree(Double previous_degree) {
		this.previous_degree = previous_degree;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.now_degree
	 * @return  the value of wy_expense.now_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Double getNow_degree() {
		return now_degree;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.now_degree
	 * @param now_degree  the value for wy_expense.now_degree
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setNow_degree(Double now_degree) {
		this.now_degree = now_degree;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wy_expense.remark
	 * @return  the value of wy_expense.remark
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wy_expense.remark
	 * @param remark  the value for wy_expense.remark
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}