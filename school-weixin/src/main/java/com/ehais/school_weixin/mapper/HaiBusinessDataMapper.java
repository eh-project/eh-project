package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiBusinessData;
import com.ehais.school_weixin.model.HaiBusinessDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiBusinessDataMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiBusinessDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiBusinessDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer business_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiBusinessData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiBusinessData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiBusinessData> selectByExample(HaiBusinessDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiBusinessData selectByPrimaryKey(Integer business_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiBusinessData record,
			@Param("example") HaiBusinessDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiBusinessData record, @Param("example") HaiBusinessDataExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiBusinessData record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_business_data
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiBusinessData record);
}