package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiOrderGoods;
import com.ehais.school_weixin.model.HaiOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiOrderGoodsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer rec_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiOrderGoods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiOrderGoods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiOrderGoods> selectByExampleWithBLOBs(HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiOrderGoods> selectByExample(HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiOrderGoods selectByPrimaryKey(Integer rec_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiOrderGoods record, @Param("example") HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiOrderGoods record, @Param("example") HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiOrderGoods record, @Param("example") HaiOrderGoodsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiOrderGoods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiOrderGoods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_order_goods
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiOrderGoods record);
}