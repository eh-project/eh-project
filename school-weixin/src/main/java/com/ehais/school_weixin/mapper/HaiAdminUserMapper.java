package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiAdminUser;
import com.ehais.school_weixin.model.HaiAdminUserExample;
import com.ehais.school_weixin.model.HaiAdminUserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiAdminUserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Short admin_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiAdminUserWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiAdminUserWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAdminUserWithBLOBs> selectByExampleWithBLOBs(HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiAdminUser> selectByExample(HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiAdminUserWithBLOBs selectByPrimaryKey(Short admin_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiAdminUserWithBLOBs record,
			@Param("example") HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiAdminUserWithBLOBs record,
			@Param("example") HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiAdminUser record, @Param("example") HaiAdminUserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiAdminUserWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiAdminUserWithBLOBs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_admin_user
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiAdminUser record);
}