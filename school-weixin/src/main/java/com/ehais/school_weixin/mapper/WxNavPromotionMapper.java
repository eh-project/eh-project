package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WxNavPromotion;
import com.ehais.school_weixin.model.WxNavPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxNavPromotionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WxNavPromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WxNavPromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WxNavPromotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WxNavPromotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WxNavPromotion> selectByExample(WxNavPromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WxNavPromotion selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WxNavPromotion record,
			@Param("example") WxNavPromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WxNavPromotion record, @Param("example") WxNavPromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WxNavPromotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wx_nav_promotion
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WxNavPromotion record);
}