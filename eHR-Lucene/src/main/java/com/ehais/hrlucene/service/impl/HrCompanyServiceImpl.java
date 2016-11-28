package com.ehais.hrlucene.service.impl;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiHrCompanyMapper;
import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrCompanyExample;
import com.ehais.hrlucene.service.HrCompanyService;


@Service("hrCompanyService")
public class HrCompanyServiceImpl implements HrCompanyService {

	@Autowired
	private HaiHrCompanyMapper haiHrCompanyMapper;  
	
	@Override
	public ReturnObject<HaiHrCompany> SaveHrCompany(HaiHrCompany com) {
		ReturnObject<HaiHrCompany> rm = new ReturnObject<HaiHrCompany>();
		rm.setCode(0);
		rm.setModel(com);
		
		if (com.getCompany_name() == null || com.getCompany_name().equals("")) {
			rm.setMsg("公司名称不能为空");return rm;
		}
				
		//判断是否存在该公司
		HaiHrCompanyExample example = new HaiHrCompanyExample();
		example.createCriteria().andCompany_nameEqualTo(com.getCompany_name());
		Long count = haiHrCompanyMapper.countByExample(example);
		if (count == 0) {
			haiHrCompanyMapper.insertSelective(com);
		}
		else {
			haiHrCompanyMapper.updateByExampleSelective(com, example);
		}
		
		
		rm.setCode(1);
		rm.setMsg("保存成功");
		return rm;		
	}
}
