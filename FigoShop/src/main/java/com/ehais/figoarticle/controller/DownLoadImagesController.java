package com.ehais.figoarticle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.common.EConstants;
import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.model.HaiGoods;
import com.ehais.figoarticle.model.HaiGoodsExample;

@Controller
@RequestMapping("/down")
public class DownLoadImagesController extends FigoCommonController {
	
	@RequestMapping("/html")
	public String html(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "/downhtml";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public String goods(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows){
		
		ReturnObject<HaiGoods> rm = new ReturnObject<HaiGoods>();
		Integer store_id = (Integer)request.getSession().getAttribute(EConstants.SESSION_STORE_ID);
		Integer start = (page - 1 ) * rows;
		
		HaiGoodsExample example = new HaiGoodsExample();
		HaiGoodsExample.Criteria c = example.createCriteria();
		c.andLocalThumbIsNull();
		example.setLimitStart(start);
		example.setLimitEnd(rows);
		
		List<HaiGoods> list = haiGoodsMapper.selectByExample(example);
		Long total = haiGoodsMapper.countByExample(example);
		rm.setCode(1);
		rm.setRows(list);
		rm.setTotal(total);
		
		return this.writeJson(rm);
	}
	
	
	@ResponseBody
	@RequestMapping("/load")
	public String load(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response){
		
		this.loadpic(request);
		
		ReturnObject<HaiGoods> rm = new ReturnObject<HaiGoods>();
		rm.setCode(1);
		rm.setMsg("成功");
		return this.writeJson(rm);
	}
	
	
	private void loadpic(HttpServletRequest request){
		HaiGoodsExample example = new HaiGoodsExample();
		HaiGoodsExample.Criteria c = example.createCriteria();
		c.andLocalThumbIsNull();
		example.setLimitStart(1);
		example.setLimitEnd(1);
		example.setOrderByClause("goods_id asc");
		List<HaiGoods> list = haiGoodsMapper.selectByExample(example);
		if(list!=null && list.size() > 0){
			String name = list.get(0).getGoodsThumb().substring(list.get(0).getGoodsThumb().lastIndexOf("/")+1);
			String path = request.getRealPath("/uploads/");
			String thumb = list.get(0).getGoodsThumb();
			if(thumb.indexOf("http")<0)thumb="http:"+thumb;
			System.out.println(thumb);
			boolean b = this.download(thumb , name , path );
			if(b){
				HaiGoods goods = list.get(0);
				goods.setLocalThumb(request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getLocalPort()+"/uploads/"+name);
				haiGoodsMapper.updateByPrimaryKey(goods);
				
				Long total = haiGoodsMapper.countByExample(example);
				if(total > 0){
					this.loadpic(request);
				}
			}
		}
	}
	

}
