package com.ehais.school_weixin.model;

public class WxDepartment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wx_department.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wx_department.name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wx_department.school_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer school_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column wx_department.create_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String create_time;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wx_department.id
	 * @return  the value of wx_department.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wx_department.id
	 * @param id  the value for wx_department.id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wx_department.name
	 * @return  the value of wx_department.name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wx_department.name
	 * @param name  the value for wx_department.name
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wx_department.school_id
	 * @return  the value of wx_department.school_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getSchool_id() {
		return school_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wx_department.school_id
	 * @param school_id  the value for wx_department.school_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column wx_department.create_time
	 * @return  the value of wx_department.create_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getCreate_time() {
		return create_time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column wx_department.create_time
	 * @param create_time  the value for wx_department.create_time
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}