package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiAd;
import com.ehais.school_weixin.model.HaiAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiAdMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer ad_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiAd record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiAd record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAd> selectByExampleWithBLOBs(HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAd> selectByExample(HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiAd selectByPrimaryKey(Integer ad_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiAd record, @Param("example") HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiAd record, @Param("example") HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiAd record, @Param("example") HaiAdExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiAd record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiAd record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_ad
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiAd record);
}