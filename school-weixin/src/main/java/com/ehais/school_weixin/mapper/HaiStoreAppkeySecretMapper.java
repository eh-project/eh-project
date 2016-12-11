package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.HaiStoreAppkeySecret;
import com.ehais.school_weixin.model.HaiStoreAppkeySecretExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiStoreAppkeySecretMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer app_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(HaiStoreAppkeySecret record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(HaiStoreAppkeySecret record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiStoreAppkeySecret> selectByExampleWithBLOBs(HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<HaiStoreAppkeySecret> selectByExample(HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	HaiStoreAppkeySecret selectByPrimaryKey(Integer app_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiStoreAppkeySecret record,
			@Param("example") HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiStoreAppkeySecret record,
			@Param("example") HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") HaiStoreAppkeySecret record,
			@Param("example") HaiStoreAppkeySecretExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiStoreAppkeySecret record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiStoreAppkeySecret record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_store_appkey_secret
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(HaiStoreAppkeySecret record);
}