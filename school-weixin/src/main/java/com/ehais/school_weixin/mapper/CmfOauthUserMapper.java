package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.CmfOauthUser;
import com.ehais.school_weixin.model.CmfOauthUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmfOauthUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(CmfOauthUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(CmfOauthUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(CmfOauthUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(CmfOauthUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<CmfOauthUser> selectByExample(CmfOauthUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	CmfOauthUser selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") CmfOauthUser record, @Param("example") CmfOauthUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") CmfOauthUser record, @Param("example") CmfOauthUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(CmfOauthUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cmf_oauth_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(CmfOauthUser record);
}