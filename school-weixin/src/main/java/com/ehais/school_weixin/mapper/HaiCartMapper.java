package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiCart;
import com.ehais.school_weixin.model.HaiCartExample;
import com.ehais.school_weixin.model.HaiCartWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiCartMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer rec_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiCartWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiCartWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiCartWithBLOBs> selectByExampleWithBLOBs(HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiCart> selectByExample(HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiCartWithBLOBs selectByPrimaryKey(Integer rec_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiCartWithBLOBs record, @Param("example") HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiCartWithBLOBs record, @Param("example") HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiCart record, @Param("example") HaiCartExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiCartWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiCartWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cart
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiCart record);
}