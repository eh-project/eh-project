package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiBonusType;
import com.ehais.school_weixin.model.HaiBonusTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiBonusTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiBonusTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiBonusTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Short type_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiBonusType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiBonusType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiBonusType> selectByExample(HaiBonusTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiBonusType selectByPrimaryKey(Short type_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiBonusType record, @Param("example") HaiBonusTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiBonusType record, @Param("example") HaiBonusTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiBonusType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_bonus_type
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiBonusType record);
}