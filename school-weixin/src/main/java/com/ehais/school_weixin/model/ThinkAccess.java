package com.ehais.school_weixin.model;

public class ThinkAccess extends ThinkAccessKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column think_access.level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Boolean level;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column think_access.pid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Short pid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column think_access.module
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String module;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column think_access.level
	 * @return  the value of think_access.level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Boolean getLevel() {
		return level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column think_access.level
	 * @param level  the value for think_access.level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setLevel(Boolean level) {
		this.level = level;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column think_access.pid
	 * @return  the value of think_access.pid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Short getPid() {
		return pid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column think_access.pid
	 * @param pid  the value for think_access.pid
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPid(Short pid) {
		this.pid = pid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column think_access.module
	 * @return  the value of think_access.module
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getModule() {
		return module;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column think_access.module
	 * @param module  the value for think_access.module
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setModule(String module) {
		this.module = module;
	}
}