package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiTimeAxisn;
import com.ehais.school_weixin.model.HaiTimeAxisnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiTimeAxisnMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer time_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiTimeAxisn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiTimeAxisn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiTimeAxisn> selectByExampleWithBLOBs(HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiTimeAxisn> selectByExample(HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiTimeAxisn selectByPrimaryKey(Integer time_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiTimeAxisn record, @Param("example") HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiTimeAxisn record, @Param("example") HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiTimeAxisn record, @Param("example") HaiTimeAxisnExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiTimeAxisn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiTimeAxisn record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_time_axisn
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiTimeAxisn record);
}