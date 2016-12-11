package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WxStudentSelectInfo;
import com.ehais.school_weixin.model.WxStudentSelectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxStudentSelectInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WxStudentSelectInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WxStudentSelectInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(String student_name);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WxStudentSelectInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WxStudentSelectInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WxStudentSelectInfo> selectByExample(WxStudentSelectInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WxStudentSelectInfo selectByPrimaryKey(String student_name);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WxStudentSelectInfo record,
			@Param("example") WxStudentSelectInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WxStudentSelectInfo record,
			@Param("example") WxStudentSelectInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WxStudentSelectInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_student_select_info
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WxStudentSelectInfo record);
}