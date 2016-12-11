package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WxSchool;
import com.ehais.school_weixin.model.WxSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxSchoolMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WxSchoolExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WxSchoolExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WxSchool record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WxSchool record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WxSchool> selectByExample(WxSchoolExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WxSchool selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WxSchool record, @Param("example") WxSchoolExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WxSchool record, @Param("example") WxSchoolExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WxSchool record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_school
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WxSchool record);
}