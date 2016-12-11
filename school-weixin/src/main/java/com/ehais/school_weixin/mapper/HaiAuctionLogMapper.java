package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiAuctionLog;
import com.ehais.school_weixin.model.HaiAuctionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiAuctionLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiAuctionLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiAuctionLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer log_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiAuctionLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiAuctionLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAuctionLog> selectByExample(HaiAuctionLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiAuctionLog selectByPrimaryKey(Integer log_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiAuctionLog record, @Param("example") HaiAuctionLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiAuctionLog record, @Param("example") HaiAuctionLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiAuctionLog record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_auction_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiAuctionLog record);
}