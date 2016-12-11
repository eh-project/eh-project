package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiJobApply;
import com.ehais.school_weixin.model.HaiJobApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiJobApplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer mja_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiJobApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiJobApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiJobApply> selectByExampleWithBLOBs(HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiJobApply> selectByExample(HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiJobApply selectByPrimaryKey(Integer mja_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiJobApply record, @Param("example") HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiJobApply record, @Param("example") HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiJobApply record, @Param("example") HaiJobApplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiJobApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiJobApply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_job_apply
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiJobApply record);
}