package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.ProIdea;
import com.ehais.school_weixin.model.ProIdeaExample;
import com.ehais.school_weixin.model.ProIdeaWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProIdeaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer idea_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(ProIdeaWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(ProIdeaWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ProIdeaWithBLOBs> selectByExampleWithBLOBs(ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ProIdea> selectByExample(ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	ProIdeaWithBLOBs selectByPrimaryKey(Integer idea_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ProIdeaWithBLOBs record, @Param("example") ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") ProIdeaWithBLOBs record, @Param("example") ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") ProIdea record, @Param("example") ProIdeaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(ProIdeaWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(ProIdeaWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_idea
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(ProIdea record);
}