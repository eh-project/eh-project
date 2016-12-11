package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiDeliveryOrder;
import com.ehais.school_weixin.model.HaiDeliveryOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiDeliveryOrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiDeliveryOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiDeliveryOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer delivery_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiDeliveryOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiDeliveryOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiDeliveryOrder> selectByExample(HaiDeliveryOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiDeliveryOrder selectByPrimaryKey(Integer delivery_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiDeliveryOrder record,
			@Param("example") HaiDeliveryOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiDeliveryOrder record, @Param("example") HaiDeliveryOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiDeliveryOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_delivery_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiDeliveryOrder record);
}