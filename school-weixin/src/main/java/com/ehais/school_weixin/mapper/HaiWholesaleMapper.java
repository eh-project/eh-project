package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiWholesale;
import com.ehais.school_weixin.model.HaiWholesaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiWholesaleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer act_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiWholesale record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiWholesale record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiWholesale> selectByExampleWithBLOBs(HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiWholesale> selectByExample(HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiWholesale selectByPrimaryKey(Integer act_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiWholesale record, @Param("example") HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiWholesale record, @Param("example") HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiWholesale record, @Param("example") HaiWholesaleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiWholesale record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiWholesale record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_wholesale
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiWholesale record);
}