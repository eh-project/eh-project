package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiVirtualCard;
import com.ehais.school_weixin.model.HaiVirtualCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiVirtualCardMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiVirtualCardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiVirtualCardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer card_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiVirtualCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiVirtualCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiVirtualCard> selectByExample(HaiVirtualCardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiVirtualCard selectByPrimaryKey(Integer card_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiVirtualCard record,
			@Param("example") HaiVirtualCardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiVirtualCard record, @Param("example") HaiVirtualCardExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiVirtualCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_virtual_card
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiVirtualCard record);
}