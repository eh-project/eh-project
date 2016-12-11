package com.ehais.school_weixin.mapper;

import com.ehais.school_weixin.model.WySettingChargeMethod;
import com.ehais.school_weixin.model.WySettingChargeMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WySettingChargeMethodMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	long countByExample(WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByExample(WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int deleteByPrimaryKey(Integer setting_charge_method_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insert(WySettingChargeMethod record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int insertSelective(WySettingChargeMethod record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WySettingChargeMethod> selectByExampleWithBLOBs(WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	List<WySettingChargeMethod> selectByExample(WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	WySettingChargeMethod selectByPrimaryKey(Integer setting_charge_method_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleSelective(@Param("record") WySettingChargeMethod record,
			@Param("example") WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") WySettingChargeMethod record,
			@Param("example") WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByExample(@Param("record") WySettingChargeMethod record,
			@Param("example") WySettingChargeMethodExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeySelective(WySettingChargeMethod record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(WySettingChargeMethod record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table wy_setting_charge_method
	 * @mbg.generated  Mon Dec 05 15:58:20 CST 2016
	 */
	int updateByPrimaryKey(WySettingChargeMethod record);
}