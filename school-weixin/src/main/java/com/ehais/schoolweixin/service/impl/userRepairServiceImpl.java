package com.ehais.schoolweixin.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.ehais.model.WxUsersExample;
import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ehais.schoolweixin.mapper.wxRepairMapper;
import com.ehais.schoolweixin.model.wxRepair;
import com.ehais.schoolweixin.model.wxRepairExample;
import com.ehais.schoolweixin.service.userRepairService;

@Service("userRepairService")
public class userRepairServiceImpl implements userRepairService {
	@Autowired
	private wxRepairMapper urmapper;
	
	/* (non-Javadoc)
	 * @see com.ehais.schoolweixin.serviceImpl.userRepairService#saveRepairList(com.ehais.school_weixin.model.userRepair)
	 */
	public ReturnObject<?> saveRepairList(wxRepair urmodel){
		ReturnObject<?> rm =new ReturnObject<>();
		rm.setCode(0);
		wxRepairExample ure=new wxRepairExample();
		ure.createCriteria().andRepairClassEqualTo(urmodel.getRepairClass()).andUserAddressEqualTo(urmodel.getUserAddress());
		int count=-1;
		try{
			count=urmapper.countByExample(ure);
		}catch(Exception e){
			//System.out.println("error occured when counting the example!");
			e.printStackTrace();
			rm.setCode(-1);
			rm.setMsg("下单失败<br>信息读取出错");
			return rm;
		}
		if(count!=0&&count!=-1){
			rm.setCode(-2);
			rm.setMsg("下单失败<br>订单宿舍号和类型已存在");
			return rm;
		}else{
			try{
				urmapper.insertSelective(urmodel);
				rm.setCode(1);
				rm.setMsg("下单成功");
			}catch(Exception e){
				//System.out.println("error occured when counting the example!");
				e.printStackTrace();
				rm.setCode(-3);
				rm.setMsg("下单失败<br>数据存储失败");
				return rm;
			}
		}
		return rm;
	}
	
	/* (non-Javadoc)
	 * @see com.ehais.schoolweixin.serviceImpl.userRepairService#getRepairList(java.lang.String)
	 */
	public ReturnObject<wxRepair> getRepairList(String wxid){
		ReturnObject<wxRepair> rm =new ReturnObject<wxRepair>();
		rm.setCode(0);
		wxRepairExample ure=new wxRepairExample();
		ure.setOrderByClause("submitDate desc");
		ure.createCriteria().andUserWxidEqualTo(wxid);
		List<wxRepair> ur=new ArrayList<wxRepair>();
		try{
			ur=urmapper.selectByExample(ure);
			rm.setRows(ur);
			//return rm;
		}catch(Exception e){
			e.printStackTrace();
			rm.setCode(-4);
			rm.setMsg("信息读取出错");
		}
		return rm;
	}
}