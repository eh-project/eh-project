package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WyCustomerLevel;
import com.ehais.school_weixin.model.WyCustomerLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyCustomerLevelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer customer_level_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WyCustomerLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WyCustomerLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCustomerLevel> selectByExampleWithBLOBs(WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCustomerLevel> selectByExample(WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WyCustomerLevel selectByPrimaryKey(Integer customer_level_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WyCustomerLevel record,
			@Param("example") WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") WyCustomerLevel record,
			@Param("example") WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WyCustomerLevel record, @Param("example") WyCustomerLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WyCustomerLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(WyCustomerLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WyCustomerLevel record);
}