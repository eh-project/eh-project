package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WyCommunity;
import com.ehais.school_weixin.model.WyCommunityExample;
import com.ehais.school_weixin.model.WyCommunityWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WyCommunityMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer community_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WyCommunityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WyCommunityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCommunityWithBLOBs> selectByExampleWithBLOBs(WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WyCommunity> selectByExample(WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WyCommunityWithBLOBs selectByPrimaryKey(Integer community_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WyCommunityWithBLOBs record,
			@Param("example") WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") WyCommunityWithBLOBs record,
			@Param("example") WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WyCommunity record, @Param("example") WyCommunityExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WyCommunityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(WyCommunityWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_community
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WyCommunity record);
}