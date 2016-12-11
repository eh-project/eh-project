package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiAffiliateLog;
import com.ehais.school_weixin.model.HaiAffiliateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiAffiliateLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiAffiliateLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiAffiliateLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer log_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiAffiliateLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiAffiliateLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAffiliateLog> selectByExample(HaiAffiliateLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiAffiliateLog selectByPrimaryKey(Integer log_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiAffiliateLog record,
			@Param("example") HaiAffiliateLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiAffiliateLog record, @Param("example") HaiAffiliateLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiAffiliateLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_affiliate_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiAffiliateLog record);
}