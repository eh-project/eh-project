package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiRegFields;
import com.ehais.school_weixin.model.HaiRegFieldsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiRegFieldsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiRegFieldsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiRegFieldsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiRegFields record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiRegFields record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiRegFields> selectByExample(HaiRegFieldsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiRegFields selectByPrimaryKey(Byte id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiRegFields record, @Param("example") HaiRegFieldsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiRegFields record, @Param("example") HaiRegFieldsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiRegFields record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_reg_fields
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiRegFields record);
}