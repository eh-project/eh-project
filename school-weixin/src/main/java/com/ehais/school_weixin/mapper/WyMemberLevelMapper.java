package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WyMemberLevel;
import com.ehais.school_weixin.model.WyMemberLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyMemberLevelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer member_level_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WyMemberLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WyMemberLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyMemberLevel> selectByExampleWithBLOBs(WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyMemberLevel> selectByExample(WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WyMemberLevel selectByPrimaryKey(Integer member_level_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WyMemberLevel record, @Param("example") WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") WyMemberLevel record, @Param("example") WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WyMemberLevel record, @Param("example") WyMemberLevelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WyMemberLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(WyMemberLevel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_member_level
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WyMemberLevel record);
}