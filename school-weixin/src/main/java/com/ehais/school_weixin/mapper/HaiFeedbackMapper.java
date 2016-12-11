package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiFeedback;
import com.ehais.school_weixin.model.HaiFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiFeedbackMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer msg_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiFeedback record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiFeedback record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiFeedback> selectByExampleWithBLOBs(HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiFeedback> selectByExample(HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiFeedback selectByPrimaryKey(Integer msg_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiFeedback record, @Param("example") HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiFeedback record, @Param("example") HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiFeedback record, @Param("example") HaiFeedbackExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiFeedback record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiFeedback record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_feedback
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiFeedback record);
}