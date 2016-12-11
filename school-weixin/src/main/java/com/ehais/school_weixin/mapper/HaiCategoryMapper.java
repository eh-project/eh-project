package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiCategory;
import com.ehais.school_weixin.model.HaiCategoryExample;
import com.ehais.school_weixin.model.HaiCategoryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiCategoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer cat_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiCategoryWithBLOBs> selectByExampleWithBLOBs(HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiCategory> selectByExample(HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiCategoryWithBLOBs selectByPrimaryKey(Integer cat_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiCategoryWithBLOBs record,
			@Param("example") HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiCategoryWithBLOBs record,
			@Param("example") HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiCategory record, @Param("example") HaiCategoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiCategoryWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_category
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiCategory record);
}