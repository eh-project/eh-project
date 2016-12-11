package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiFavorites;
import com.ehais.school_weixin.model.HaiFavoritesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiFavoritesMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiFavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiFavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiFavorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiFavorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiFavorites> selectByExample(HaiFavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiFavorites selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiFavorites record, @Param("example") HaiFavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiFavorites record, @Param("example") HaiFavoritesExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiFavorites record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_favorites
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiFavorites record);
}