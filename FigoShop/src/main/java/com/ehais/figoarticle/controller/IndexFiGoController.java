package com.ehais.figoarticle.controller;

import java.net.URLEncoder;
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
import org.ehais.util.HtmlRegexpUtil;
import org.ehais.util.PythonUtil;
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

import com.ehais.figoarticle.mapper.ArticleCommentMapper;
import com.ehais.figoarticle.mapper.ArticleMapper;
import com.ehais.figoarticle.mapper.BrandMapper;
import com.ehais.figoarticle.mapper.ExcelMapper;
import com.ehais.figoarticle.model.Article;
import com.ehais.figoarticle.model.ArticleComment;
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
	private ArticleCommentMapper articleCommentMapper;
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
	@RequestMapping("/toutiaoApiDB")
	public String toutiaoApiDB(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "keyword", required = true) String keyword,
			@RequestParam(value = "count", required = true) Integer count,
			@RequestParam(value = "offset", required = true) Integer offset) {
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Origin","*"); // 允许任意域名发起的跨域请求  
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With,X_Requested_With");

		String errobj = null;
		try {
			
			String url = "http://www.toutiao.com/search_content/?format=json&keyword="+URLEncoder.encode(keyword, "UTF-8")+"&count="+count+"&offset="+offset;
			System.out.println(url);
			
			
			Map<String, Integer> brandMap = new HashMap<String, Integer>();
			List<Brand> brandList = brandMapper.selectByExample(null);
			for (Brand b : brandList) {
				brandMap.put(b.getName().trim(), b.getId());
			}
//			String result = EHtmlUnit.getAjaxPage(url);//EHttpClientUtil.methodGet(url);
			String result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), url);
			
			System.out.println("result=========================");
			System.out.println(result);
			result = HtmlRegexpUtil.filterHtml(result);
			System.out.println(result);
			
			
			JSONObject json = JSONObject.fromObject(result);
			JSONArray arr = json.getJSONArray("data");
			System.out.println(keyword+"=="+json.getString("return_count"));
			for (Object object : arr) {
				errobj = object.toString();
				Article a = new Article();
				JSONObject o = (JSONObject)object;
				
				if(!o.has("id"))continue;	
//				System.out.println(o.getString("id"));
				a.setWid(o.getLong("id"));
				
				if(o.has("group_id"))a.setGid(o.getLong("group_id"));
				if(o.has("item_id"))a.setItemId(o.getLong("item_id"));
				
				if(!o.has("title"))continue;
				a.setTitle(o.getString("title"));
				a.setSiteId(1L);
				
				if(o.has("abstract"))a.setAbstracts(o.getString("abstract"));
				if(o.has("source"))a.setAuthor(o.getString("source"));
				a.setReply(o.getInt("comments_count"));
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
		    	a.setIsDanger(0);
		    	
		    	
		    	ArticleExample example = new ArticleExample();
		    	example.createCriteria().andWidEqualTo(a.getWid());
		    	long c = articleMapper.countByExample(example);
		    	if(c == 0){
		    		articleMapper.insert(a);
		    	}else{
		    		List<Article> list = articleMapper.selectByExample(example);
		    		Article article = list.get(0);
		    		article.setPreReply(article.getReply());
		    		article.setReply(a.getReply());
		    		articleMapper.updateByPrimaryKey(article);
		    	}
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
			

			String result = EHttpClientUtil.methodGet(url);
			
			return result;

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
	
	
	@ResponseBody
	@RequestMapping("/comment")
	public String comment(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "article_id", required = true) Long article_id) {


		try {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andIdEqualTo(article_id);
			List<Article> list = articleMapper.selectByExample(example);
			for (Article article : list) {
				String result = this.commentApi(article.getWid(), article.getItemId(), 0, 200);
				System.out.println(result);
				JSONObject json = JSONObject.fromObject(result);
				JSONObject jsonData = json.getJSONObject("data");
				JSONArray comments = jsonData.getJSONArray("comments");
				for (Object object : comments) {
					JSONObject o = (JSONObject)object;
					String text = removeFourChar(o.getString("text"));
					ArticleComment comment = new ArticleComment();
					comment.setArticleId(article.getId());
					comment.setCommentContent(text);
					comment.setStatus(1);
					comment.setSiteId(1);//头条
					comment.setDeleted(0);
					comment.setUrl(article.getUrl());
					Integer dateint = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
					comment.setUpdated(dateint);
					comment.setCreated(dateint);
					articleCommentMapper.insert(comment);
				}
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"code\":2,\"message\":\"失败\"}";
	}
	
	@ResponseBody
	@RequestMapping("/commentApi")
	public String commentApi(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "group_id", required = true) Long group_id,
			@RequestParam(value = "item_id", required = true) Long item_id,
			@RequestParam(value = "count", required = true) Integer count,
			@RequestParam(value = "offset", required = true) Integer offset) {
		response.setHeader("Access-Control-Allow-Origin","*"); // 允许任意域名发起的跨域请求  
		response.setHeader("Access-Control-Allow-Headers","X-Requested-With,X_Requested_With");

		String url = "http://www.toutiao.com/api/comment/list/?group_id="+group_id+"&item_id="+item_id+"&count="+count+"&offset="+offset;
		String result = null;
		String errobj = null;
		try {
			
			result = commentApi(group_id,item_id,offset,count);
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(errobj);
		}
		return "{\"code\":2,\"message\":\"失败\"}";
	}
	
	private String commentApi(Long group_id,Long item_id,Integer offset,Integer count) throws Exception{
		String url = "http://www.toutiao.com/api/comment/list/?group_id="+group_id.toString()+"&item_id="+item_id.toString()+"&count="+count.toString()+"&offset="+offset.toString();
		System.out.println(url);
		return EHttpClientUtil.methodGet(url);
	}
	
	 public String removeFourChar(String content) {
	        byte[] conbyte = content.getBytes();
	        for (int i = 0; i < conbyte.length; i++) {
	            if ((conbyte[i] & 0xF8) == 0xF0) {
	                for (int j = 0; j < 4; j++) {                          
	                    conbyte[i+j]=0x30;                     
	                }  
	                i += 3;
	            }
	        }
	        content = new String(conbyte);
	        return content.replaceAll("0000", "");
	    }

}
