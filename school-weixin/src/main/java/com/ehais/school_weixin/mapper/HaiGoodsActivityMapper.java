package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiGoodsActivity;
import com.ehais.school_weixin.model.HaiGoodsActivityExample;
import com.ehais.school_weixin.model.HaiGoodsActivityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiGoodsActivityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer act_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiGoodsActivityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiGoodsActivityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiGoodsActivityWithBLOBs> selectByExampleWithBLOBs(HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiGoodsActivity> selectByExample(HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiGoodsActivityWithBLOBs selectByPrimaryKey(Integer act_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiGoodsActivityWithBLOBs record,
			@Param("example") HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiGoodsActivityWithBLOBs record,
			@Param("example") HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiGoodsActivity record, @Param("example") HaiGoodsActivityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiGoodsActivityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiGoodsActivityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_goods_activity
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiGoodsActivity record);
}