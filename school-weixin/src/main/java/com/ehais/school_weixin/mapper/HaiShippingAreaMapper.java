package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiShippingArea;
import com.ehais.school_weixin.model.HaiShippingAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiShippingAreaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Short shipping_area_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiShippingArea record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiShippingArea record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiShippingArea> selectByExampleWithBLOBs(HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiShippingArea> selectByExample(HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiShippingArea selectByPrimaryKey(Short shipping_area_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiShippingArea record,
			@Param("example") HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiShippingArea record,
			@Param("example") HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiShippingArea record, @Param("example") HaiShippingAreaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiShippingArea record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiShippingArea record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_shipping_area
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiShippingArea record);
}