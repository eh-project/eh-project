package com.ehais.schoolweixin.model;

import java.util.Date;

public class activityname {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.id
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.activityName
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private String activityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.pCount
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private Integer pCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.starTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private Date starTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.endTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activityname.finalTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    private Date finalTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.id
     *
     * @return the value of activityname.id
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    
    public activityname() {
    	
    }
    public activityname(Integer id, String activityName, Integer pCount, Date starTime, Date endTime, Date finalTime) {
		super();
		this.id = id;
		this.activityName = activityName;
		this.pCount = pCount;
		this.starTime = starTime;
		this.endTime = endTime;
		this.finalTime = finalTime;
	}
    
    public Integer getId() {
        return id;
    }

   

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.id
     *
     * @param id the value for activityname.id
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.activityName
     *
     * @return the value of activityname.activityName
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.activityName
     *
     * @param activityName the value for activityname.activityName
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.pCount
     *
     * @return the value of activityname.pCount
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public Integer getpCount() {
        return pCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.pCount
     *
     * @param pCount the value for activityname.pCount
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setpCount(Integer pCount) {
        this.pCount = pCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.starTime
     *
     * @return the value of activityname.starTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public Date getStarTime() {
        return starTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.starTime
     *
     * @param starTime the value for activityname.starTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.endTime
     *
     * @return the value of activityname.endTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.endTime
     *
     * @param endTime the value for activityname.endTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activityname.finalTime
     *
     * @return the value of activityname.finalTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public Date getFinalTime() {
        return finalTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activityname.finalTime
     *
     * @param finalTime the value for activityname.finalTime
     *
     * @mbggenerated Sun Feb 26 23:05:24 CST 2017
     */
    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }
}