package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.ThinkMenu;
import com.ehais.school_weixin.model.ThinkMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThinkMenuMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(ThinkMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(ThinkMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(ThinkMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(ThinkMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ThinkMenu> selectByExample(ThinkMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	ThinkMenu selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ThinkMenu record, @Param("example") ThinkMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") ThinkMenu record, @Param("example") ThinkMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(ThinkMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_menu
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(ThinkMenu record);
}