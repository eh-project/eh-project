package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WyCustomer;
import com.ehais.school_weixin.model.WyCustomerExample;
import com.ehais.school_weixin.model.WyCustomerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyCustomerMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer customer_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WyCustomerWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WyCustomerWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCustomerWithBLOBs> selectByExampleWithBLOBs(WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCustomer> selectByExample(WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WyCustomerWithBLOBs selectByPrimaryKey(Integer customer_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WyCustomerWithBLOBs record,
			@Param("example") WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") WyCustomerWithBLOBs record,
			@Param("example") WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WyCustomer record, @Param("example") WyCustomerExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WyCustomerWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(WyCustomerWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_customer
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WyCustomer record);
}