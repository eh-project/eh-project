package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.CmfSlideCat;
import com.ehais.school_weixin.model.CmfSlideCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmfSlideCatMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(CmfSlideCat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(CmfSlideCat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<CmfSlideCat> selectByExampleWithBLOBs(CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<CmfSlideCat> selectByExample(CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	CmfSlideCat selectByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") CmfSlideCat record, @Param("example") CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") CmfSlideCat record, @Param("example") CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") CmfSlideCat record, @Param("example") CmfSlideCatExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(CmfSlideCat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(CmfSlideCat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_slide_cat
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(CmfSlideCat record);
}