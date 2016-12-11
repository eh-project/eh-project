package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiUserRank;
import com.ehais.school_weixin.model.HaiUserRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiUserRankMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiUserRankExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiUserRankExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Byte rank_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiUserRank record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiUserRank record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiUserRank> selectByExample(HaiUserRankExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiUserRank selectByPrimaryKey(Byte rank_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiUserRank record, @Param("example") HaiUserRankExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiUserRank record, @Param("example") HaiUserRankExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiUserRank record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_user_rank
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiUserRank record);
}