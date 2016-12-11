package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiPack;
import com.ehais.school_weixin.model.HaiPackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiPackMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiPackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiPackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Byte pack_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiPack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiPack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiPack> selectByExample(HaiPackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiPack selectByPrimaryKey(Byte pack_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiPack record, @Param("example") HaiPackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiPack record, @Param("example") HaiPackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiPack record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_pack
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiPack record);
}