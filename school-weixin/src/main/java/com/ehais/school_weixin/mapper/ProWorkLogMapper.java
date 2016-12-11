package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.ProWorkLog;
import com.ehais.school_weixin.model.ProWorkLogExample;
import com.ehais.school_weixin.model.ProWorkLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProWorkLogMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer work_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(ProWorkLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(ProWorkLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ProWorkLogWithBLOBs> selectByExampleWithBLOBs(ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ProWorkLog> selectByExample(ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	ProWorkLogWithBLOBs selectByPrimaryKey(Integer work_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ProWorkLogWithBLOBs record,
			@Param("example") ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") ProWorkLogWithBLOBs record,
			@Param("example") ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") ProWorkLog record, @Param("example") ProWorkLogExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(ProWorkLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(ProWorkLogWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pro_work_log
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(ProWorkLog record);
}