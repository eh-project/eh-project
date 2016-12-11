package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.CmfRoute;
import com.ehais.school_weixin.model.CmfRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmfRouteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(CmfRouteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(CmfRouteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(CmfRoute record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(CmfRoute record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<CmfRoute> selectByExample(CmfRouteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	CmfRoute selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") CmfRoute record, @Param("example") CmfRouteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") CmfRoute record, @Param("example") CmfRouteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(CmfRoute record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_route
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(CmfRoute record);
}