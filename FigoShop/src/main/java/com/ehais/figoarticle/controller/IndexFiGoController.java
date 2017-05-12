package com.ehais.figoarticle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.controller.CommonController;
import org.ehais.tools.ReturnObject;
import org.ehais.util.DateUtil;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.mapper.ArticleMapper;
import com.ehais.figoarticle.mapper.BrandMapper;
import com.ehais.figoarticle.mapper.ExcelMapper;
import com.ehais.figoarticle.model.Article;
import com.ehais.figoarticle.model.ArticleExample;
import com.ehais.figoarticle.model.Brand;
import com.ehais.figoarticle.model.Excel;
import com.ehais.figoarticle.model.ExcelExample;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/")
public class IndexFiGoController extends CommonController {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ExcelMapper excelMapper;
	@Autowired
	private BrandMapper brandMapper;

	@RequestMapping("/index.html")
	public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/index";
	}

	@ResponseBody
	@RequestMapping("/article.api")
	public String article(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "rows", required = true) Integer rows) {
		ReturnObject<Article> rm = new ReturnObject<Article>();
		try {
			ArticleExample example = new ArticleExample();
			example.setLimitStart((page - 1) * rows);
			example.setLimitEnd(rows);
			example.setOrderByClause("created desc");
			List<Article> list = articleMapper.selectByExample(example);
			Integer total = Long.valueOf(articleMapper.countByExample(example)).intValue();
			rm.setTotal(total);
			rm.setRows(list);
			return this.writeJson(rm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@ResponseBody
	@RequestMapping("/toutiaoApi")
	public String toutiaoApi(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "keyword", required = true) String keyword,
			@RequestParam(value = "count", required = true) Integer count,
			@RequestParam(value = "offset", required = true) Integer offset) {
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin","*"); // 允许任意域名发起的跨域请求  
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With,X_Requested_With");

		String url = "http://www.toutiao.com/search_content/?format=json&keyword="+keyword+"&count="+count+"&offset="+offset;
		System.out.println(url);
		String errobj = null;
		try {
			
			Map<String, Integer> brandMap = new HashMap<String, Integer>();
			List<Brand> brandList = brandMapper.selectByExample(null);
			for (Brand b : brandList) {
				brandMap.put(b.getName().trim(), b.getId());
			}
			String result = EHttpClientUtil.methodGet(url);
			JSONObject json = JSONObject.fromObject(result);
			JSONArray arr = json.getJSONArray("data");
			System.out.println(keyword+"返回"+json.getString("return_count"));
			for (Object object : arr) {
				errobj = object.toString();
				Article a = new Article();
				JSONObject o = (JSONObject)object;
				
				if(!o.has("id"))continue;	
//				System.out.println(o.getString("id"));
				a.setWid(o.getLong("id"));
				
				if(o.has("group_id"))a.setGid(o.getLong("group_id"));
				
				if(!o.has("title"))continue;
				a.setTitle(o.getString("title"));
				a.setSiteId(1L);
				
				if(o.has("abstract"))a.setAbstracts(o.getString("abstract"));
				if(o.has("source"))a.setAuthor(o.getString("source"));
				a.setReply(0);
				a.setPreReply(0);
		    	a.setSeplyStatus(0);
		    	a.setBrandId(brandMap.get(keyword.trim())==null?0:brandMap.get(keyword.trim()));
		    	a.setKeyword(o.getString("keywords"));
		    	a.setPositive(2);
		    	a.setStatus(0);
		    	if(o.has("url"))a.setUrl(o.getString("url"));
		    	if(o.has("share_url"))a.setShareUrl(o.getString("share_url"));
		    	if(o.has("datetime")){
		    		a.setReleaseTime(Long.valueOf(DateUtil.dateToStamp(o.getString("datetime")+":00") / 1000).intValue());
		    	}else{
		    		a.setReleaseTime(0);
		    	}
		    	a.setCreated(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
		    	a.setUpdated(0);
		    	a.setDeleted(0);
		    	
		    	
		    	ArticleExample example = new ArticleExample();
		    	example.createCriteria().andWidEqualTo(a.getWid());
		    	long c = articleMapper.countByExample(example);
		    	if(c == 0)articleMapper.insert(a);
			}
			
			return "{\"code\":1,\"message\":\"成功\"}";
//			return this.writeJsonObject(json);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(errobj);
		}
		return "{\"code\":2,\"message\":\"失败\"}";
	}

	
	@ResponseBody
	@RequestMapping("/baidu")
	public String baidu(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		
		try{
			ExcelExample example = new ExcelExample();
			example.createCriteria().andValidEqualTo(Integer.valueOf(1).shortValue());
			List<Excel> list = excelMapper.selectByExample(example);
			String url , result = null;
			Integer baidu_count , news_count = 0;
	
			for (Excel excel : list) {
				baidu_count  = 0 ; news_count = 0;
				url = "http://www.baidu.com/s?wd="+java.net.URLEncoder.encode(excel.getUrl(), "UTF-8");
				System.out.println(url);
				result = EHtmlUnit.httpUnitRequest(url);
				Document doc = Jsoup.parse(result);
				Element content_left = doc.getElementById("content_left");
				Elements container = content_left.getElementsByClass("c-container");
				baidu_count = container.size();
				
				url = "http://news.baidu.com/ns?tn=news&word="+java.net.URLEncoder.encode(excel.getUrl(), "UTF-8");
				System.out.println(url);
				result = EHtmlUnit.httpUnitRequest(url);
//				System.out.println(result);
				Document docx = Jsoup.parse(result,"UTF-8");
				Elements resultx = docx.getElementById("content_left").getElementsByClass("result");
				news_count = resultx.size();
				
				ExcelExample examplex = new ExcelExample();
				example.createCriteria().andIdEqualTo(excel.getId());
				excel.setValid(Integer.valueOf(-1).shortValue());
				excel.setBaiduCount(baidu_count);
				excel.setNewsCount(news_count);
				excelMapper.updateByExample(excel, examplex);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "{\"code\":1}";
		
	}
	

}
