package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiCatRecommendExample;
import com.ehais.school_weixin.model.HaiCatRecommendKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiCatRecommendMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiCatRecommendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiCatRecommendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(HaiCatRecommendKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiCatRecommendKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiCatRecommendKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiCatRecommendKey> selectByExample(HaiCatRecommendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiCatRecommendKey record,
			@Param("example") HaiCatRecommendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_cat_recommend
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiCatRecommendKey record, @Param("example") HaiCatRecommendExample example);
}