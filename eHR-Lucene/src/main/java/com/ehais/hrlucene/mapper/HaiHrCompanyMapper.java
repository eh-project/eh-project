package com.ehais.hrlucene.mapper;

import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiHrCompanyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	long countByExample(HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int deleteByExample(HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int deleteByPrimaryKey(Long company_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int insert(HaiHrCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int insertSelective(HaiHrCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	List<HaiHrCompany> selectByExampleWithBLOBs(HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	List<HaiHrCompany> selectByExample(HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	HaiHrCompany selectByPrimaryKey(Long company_id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByExampleSelective(@Param("record") HaiHrCompany record, @Param("example") HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByExampleWithBLOBs(@Param("record") HaiHrCompany record, @Param("example") HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByExample(@Param("record") HaiHrCompany record, @Param("example") HaiHrCompanyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByPrimaryKeySelective(HaiHrCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByPrimaryKeyWithBLOBs(HaiHrCompany record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hai_hr_company
	 * @mbg.generated  Sun Nov 27 14:14:10 CST 2016
	 */
	int updateByPrimaryKey(HaiHrCompany record);
}