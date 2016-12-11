package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.ThinkTable;
import com.ehais.school_weixin.model.ThinkTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThinkTableMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(ThinkTableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(ThinkTableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(ThinkTable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(ThinkTable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<ThinkTable> selectByExample(ThinkTableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	ThinkTable selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") ThinkTable record, @Param("example") ThinkTableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") ThinkTable record, @Param("example") ThinkTableExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(ThinkTable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table think_table
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(ThinkTable record);
}