package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiEmailList;
import com.ehais.school_weixin.model.HaiEmailListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiEmailListMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiEmailListExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiEmailListExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiEmailList record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiEmailList record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiEmailList> selectByExample(HaiEmailListExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiEmailList selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiEmailList record, @Param("example") HaiEmailListExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiEmailList record, @Param("example") HaiEmailListExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiEmailList record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_email_list
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiEmailList record);
}