package com.ehais.school_weixin.model;

public class HaiGuestbookWithBLOBs extends HaiGuestbook {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_guestbook.content
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hai_guestbook.result_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	private String result_message;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_guestbook.content
	 * @return  the value of hai_guestbook.content
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_guestbook.content
	 * @param content  the value for hai_guestbook.content
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hai_guestbook.result_message
	 * @return  the value of hai_guestbook.result_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public String getResult_message() {
		return result_message;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hai_guestbook.result_message
	 * @param result_message  the value for hai_guestbook.result_message
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
}