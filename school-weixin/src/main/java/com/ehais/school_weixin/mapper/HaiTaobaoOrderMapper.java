package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiTaobaoOrder;
import com.ehais.school_weixin.model.HaiTaobaoOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiTaobaoOrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiTaobaoOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiTaobaoOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer order_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiTaobaoOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiTaobaoOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiTaobaoOrder> selectByExample(HaiTaobaoOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiTaobaoOrder selectByPrimaryKey(Integer order_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiTaobaoOrder record,
			@Param("example") HaiTaobaoOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiTaobaoOrder record, @Param("example") HaiTaobaoOrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiTaobaoOrder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_taobao_order
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiTaobaoOrder record);
}