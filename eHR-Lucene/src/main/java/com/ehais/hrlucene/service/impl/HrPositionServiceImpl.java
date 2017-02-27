package com.ehais.hrlucene.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiHrCompanyMapper;
import com.ehais.hrlucene.mapper.HaiHrPositionMapper;
import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrCompanyExample;
import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionExample;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HrPositionService;


@Service("hrPositionService")
public class HrPositionServiceImpl implements HrPositionService {

	@Autowired
	private HaiHrPositionMapper haiHrPositionMapper;
	@Autowired
	private HaiHrCompanyMapper haiHrCompanyMapper;
	
	public ReturnObject<HaiHrPosition> SaveHrPosition(HaiHrPositionWithBLOBs hrPosition) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<HaiHrPosition> rm = new ReturnObject<HaiHrPosition>();
		rm.setCode(0);
		rm.setModel(hrPosition);
		//判断必填项
		if(hrPosition.getPositionName() == null || hrPosition.getPositionName().equals("")){
			rm.setMsg("职位不能为空");return rm;
		}
		if(hrPosition.getCompanyName() == null || hrPosition.getCompanyName().equals("")){
			rm.setMsg("公司名称不能为空");return rm;
		}
		if(hrPosition.getHrSource() == null || hrPosition.getHrSource().equals("")){
			rm.setMsg("来源名称不能为空");return rm;
		}
		if(hrPosition.getHrPositionUrl() == null || hrPosition.getHrPositionUrl().equals("")){
			rm.setMsg("职位网址不能为空");return rm;
		}
		
		//抽取haihrposition数据模型的公司信息注入到haihrcompany数据模型里面
		
		HaiHrCompany hrCompany=new HaiHrCompany();
		hrCompany.setCompany_name(hrPosition.getCompanyName());
		hrCompany.setCompany_detail(hrPosition.getCompanyDetail());
		hrCompany.setCompany_website(hrPosition.getCompanyWebsite());
		hrCompany.setCompany_industry(hrPosition.getCompanyIndustry());
		hrCompany.setCompany_scale(hrPosition.getCompanyScale());
		hrCompany.setCompany_nature(hrPosition.getCompanyNature());
		hrCompany.setWelfare(hrPosition.getWelfare());
		hrCompany.setCompany_address(hrPosition.getCompanyAddress());
		hrCompany.setCompany_email(hrPosition.getCompanyEmail());
		hrCompany.setCompany_fax(hrPosition.getCompanyFax());
		hrCompany.setContactperson(hrPosition.getContactperson());
		hrCompany.setTel(hrPosition.getTel());
		hrCompany.setPhone(hrPosition.getPhone());
		
		
		
		
		//判断是否存在当前网址的职位
		HaiHrPositionExample example = new HaiHrPositionExample();
		example.createCriteria().andHrPositionUrlEqualTo(hrPosition.getHrPositionUrl());
		Integer count = haiHrPositionMapper.countByExample(example);
		if(count == 0){//不存在此记录，直接插入数据库
			haiHrPositionMapper.insertSelective(hrPosition);
			//haiHrCompanyMapper.insertSelective(hrCompany);
		}else{//存在当前记录，则更新
			haiHrPositionMapper.updateByExampleSelective(hrPosition, example);
		}
		
		//判断是否有相同的公司
		HaiHrCompanyExample companyExample=new HaiHrCompanyExample();
		companyExample.createCriteria().andCompany_nameEqualTo(hrCompany.getCompany_name());
		long countcompany=haiHrCompanyMapper.countByExample(companyExample);
		if(countcompany == 0){
			haiHrCompanyMapper.insertSelective(hrCompany);
		}else{
			haiHrCompanyMapper.updateByExampleSelective(hrCompany, companyExample);
		}
		
		
		rm.setCode(1);
		rm.setMsg("保存成功");
		return rm;
	}

	public ReturnObject<HaiHrPosition> ListHrPosition(
			HttpServletRequest request,
			EConditionObject param,
			String hr_source
			)
			throws Exception {
		ReturnObject<HaiHrPosition> rm = new ReturnObject<HaiHrPosition>();
		rm.setCode(0);
		// 按条件返回职位数据
		HaiHrPositionExample example = new HaiHrPositionExample();
		example.setStart((param.getPage() - 1 ) * param.getLen());
		example.setLen(param.getLen());
		HaiHrPositionExample.Criteria criteria = example.createCriteria();
		if(hr_source != null && !hr_source.equals("")) criteria.andHrSourceEqualTo(hr_source);
		
		List<HaiHrPosition> list = haiHrPositionMapper.hai_hr_position_list_by_example(example);
		Integer count = haiHrPositionMapper.countByExample(example);
		rm.setRows(list);
		rm.setTotal(count);
		rm.setCode(2);
		return rm;
	}

}
