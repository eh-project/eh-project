package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiTemplate;
import com.ehais.school_weixin.model.HaiTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiTemplateMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiTemplateExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiTemplateExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiTemplate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiTemplate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiTemplate> selectByExample(HaiTemplateExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiTemplate record, @Param("example") HaiTemplateExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_template
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiTemplate record, @Param("example") HaiTemplateExample example);
}