package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.MwLbs;
import com.ehais.school_weixin.model.MwLbsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MwLbsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(MwLbsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(MwLbsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Long mw_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(MwLbs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(MwLbs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<MwLbs> selectByExample(MwLbsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	MwLbs selectByPrimaryKey(Long mw_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") MwLbs record, @Param("example") MwLbsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") MwLbs record, @Param("example") MwLbsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(MwLbs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mw_lbs
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(MwLbs record);
}