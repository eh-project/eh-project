package com.ehais.school_weixin.model;

import java.util.Date;

public class ProTask {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.task_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer task_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.task_title
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String task_title;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.pro_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer pro_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.plan_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date plan_start_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.plan_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date plan_end_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.truth_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date truth_start_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.truth_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date truth_end_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer user_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.dispatch_user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer dispatch_user_id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.progress
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Integer progress;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.create_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date create_date;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column pro_task.update_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private Date update_date;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.task_id
	 * @return  the value of pro_task.task_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getTask_id() {
		return task_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.task_id
	 * @param task_id  the value for pro_task.task_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.task_title
	 * @return  the value of pro_task.task_title
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getTask_title() {
		return task_title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.task_title
	 * @param task_title  the value for pro_task.task_title
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.pro_id
	 * @return  the value of pro_task.pro_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getPro_id() {
		return pro_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.pro_id
	 * @param pro_id  the value for pro_task.pro_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.plan_start_date
	 * @return  the value of pro_task.plan_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getPlan_start_date() {
		return plan_start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.plan_start_date
	 * @param plan_start_date  the value for pro_task.plan_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPlan_start_date(Date plan_start_date) {
		this.plan_start_date = plan_start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.plan_end_date
	 * @return  the value of pro_task.plan_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getPlan_end_date() {
		return plan_end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.plan_end_date
	 * @param plan_end_date  the value for pro_task.plan_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setPlan_end_date(Date plan_end_date) {
		this.plan_end_date = plan_end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.truth_start_date
	 * @return  the value of pro_task.truth_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getTruth_start_date() {
		return truth_start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.truth_start_date
	 * @param truth_start_date  the value for pro_task.truth_start_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setTruth_start_date(Date truth_start_date) {
		this.truth_start_date = truth_start_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.truth_end_date
	 * @return  the value of pro_task.truth_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getTruth_end_date() {
		return truth_end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.truth_end_date
	 * @param truth_end_date  the value for pro_task.truth_end_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setTruth_end_date(Date truth_end_date) {
		this.truth_end_date = truth_end_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.user_id
	 * @return  the value of pro_task.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.user_id
	 * @param user_id  the value for pro_task.user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.dispatch_user_id
	 * @return  the value of pro_task.dispatch_user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getDispatch_user_id() {
		return dispatch_user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.dispatch_user_id
	 * @param dispatch_user_id  the value for pro_task.dispatch_user_id
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setDispatch_user_id(Integer dispatch_user_id) {
		this.dispatch_user_id = dispatch_user_id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.progress
	 * @return  the value of pro_task.progress
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Integer getProgress() {
		return progress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.progress
	 * @param progress  the value for pro_task.progress
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.create_date
	 * @return  the value of pro_task.create_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getCreate_date() {
		return create_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.create_date
	 * @param create_date  the value for pro_task.create_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column pro_task.update_date
	 * @return  the value of pro_task.update_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public Date getUpdate_date() {
		return update_date;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column pro_task.update_date
	 * @param update_date  the value for pro_task.update_date
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
}