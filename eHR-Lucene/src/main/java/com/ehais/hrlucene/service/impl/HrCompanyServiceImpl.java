package com.ehais.hrlucene.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiHrCompanyMapper;
import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrCompanyExample;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HrCompanyService;

@Service("hrCompanyService")
public class HrCompanyServiceImpl implements HrCompanyService {

	@Autowired
	private HaiHrCompanyMapper haiHrCompanyMapper;
	
	public ReturnObject<HaiHrCompany> SaveHrCompany(HaiHrCompany hrCompany) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<HaiHrCompany> rm = new ReturnObject<HaiHrCompany>();
		rm.setCode(0);
		rm.setModel(hrCompany);
		//判断必填项
		if(hrCompany.getCompany_name() == null || hrCompany.getCompany_name().equals("")){
			rm.setMsg("公司名称不能为空");return rm;
		}
		
		//抽取hrCompany数据模型的公司信息注入到haiHrcompany数据模型里面
		
		HaiHrCompany haiHrCompany = new HaiHrCompany();
		haiHrCompany.setCompany_name(hrCompany.getCompany_name());
		haiHrCompany.setCompany_detail(hrCompany.getCompany_detail());
		haiHrCompany.setCompany_website(hrCompany.getCompany_website());
		haiHrCompany.setCompany_industry(hrCompany.getCompany_industry());
		haiHrCompany.setCompany_scale(hrCompany.getCompany_scale());
		haiHrCompany.setCompany_nature(hrCompany.getCompany_nature());
		haiHrCompany.setWelfare(hrCompany.getWelfare());
		haiHrCompany.setCompany_address(hrCompany.getCompany_address());
		haiHrCompany.setCompany_email(hrCompany.getCompany_email());
		haiHrCompany.setCompany_fax(hrCompany.getCompany_fax());
		haiHrCompany.setContactperson(hrCompany.getContactperson());
		haiHrCompany.setTel(hrCompany.getTel());
		haiHrCompany.setPhone(hrCompany.getPhone());
		
		//判断是否有相同的公司
		HaiHrCompanyExample companyExample=new HaiHrCompanyExample();
		companyExample.createCriteria().andCompany_nameEqualTo(haiHrCompany.getCompany_name());
		long countcompany=haiHrCompanyMapper.countByExample(companyExample);
		if(countcompany == 0){
			haiHrCompanyMapper.insertSelective(haiHrCompany);
		}else{
			haiHrCompanyMapper.updateByExampleSelective(haiHrCompany, companyExample);
		}
		
		
		rm.setCode(1);
		rm.setMsg("保存成功");
		return rm;
	}

	public ReturnObject<HaiHrCompany> ListHrCompany(
			HttpServletRequest request,
			EConditionObject param,
			String companyName
			)
			throws Exception {
		ReturnObject<HaiHrCompany> rm = new ReturnObject<HaiHrCompany>();
		rm.setCode(0);
		// 按条件返回职位数据
		HaiHrCompanyExample example = new HaiHrCompanyExample();
//		example.setStart((param.getPage() - 1 ) * param.getLen());
//		example.setLen(param.getLen());
		HaiHrCompanyExample.Criteria criteria = example.createCriteria();
		if(companyName != null && !companyName.equals("")) criteria.andCompany_nameEqualTo(companyName);
		
		List<HaiHrCompany> list = haiHrCompanyMapper.selectByExample(example);
		Integer count = haiHrCompanyMapper.countByExample(example);
		rm.setRows(list);
		rm.setTotal(count);
		rm.setCode(1);
		return rm;
	}

	public ReturnObject<HaiHrCompany> SaveHrCompany(HaiHrPositionWithBLOBs hrPosition) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}