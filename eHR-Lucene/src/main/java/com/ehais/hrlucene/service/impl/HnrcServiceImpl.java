package com.ehais.hrlucene.service.impl;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HnrcService;
import com.ehais.hrlucene.service.HrPositionService;

import net.sf.json.JSONObject;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

@Service("hnrcService")
public class HnrcServiceImpl implements HnrcService {
	@Autowired
	private HrPositionService hrPositionService;

	private String website = "http://www.syrczpw.com/gposinfo/webapp/";  //三亚人才网址
//	@Override
	public void loadHnrc() throws Exception {
		
		
		
		String url = "http://www.syrczpw.com/gposinfo/webapp/";
		String htmlContent = EHttpClientUtil.methodGet(url);
		//String htmlContent = EHtmlUnit.httpUnitRequest(url);
		System.out.println(htmlContent);
		
		
		
		//将xml的字符串转化成html可读对象
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		//System.out.println("doc" + doc);
		
		//根据html的结构读取信息
		
		Element HotKey = doc.getElementById("HotKey"); //获得第一个页面的页面 ID
		Elements li_1 = HotKey.getElementsByTag("li"); //获得li标签
		
		for (Element element : li_1) {
			Elements a = element.getElementsByTag("a");   //获得第一个页面的a链接
		
				String href = url + a.attr("href");  //合并新的链接
				System.out.println("第一个页面a链接： " + href);
				positionList(href);//获取此keyword的列表信息
			}	
		
	}
	
	
	
	
	
	//第二个页面
	public void positionList(String url) throws Exception{
		
		System.out.println("请求第二个页面:" + url);  //输出前面抓取到的url
		String htmlContent = EHttpClientUtil.methodGet(url);
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		Elements Triangle = doc.getElementsByClass("Triangle"); //获得第二个页面的目标class
		//如果没有这个id结束函数
		int size = doc.getElementsByTag("option").size();
		if(Triangle == null) 
			return;
		String href = null;
		Elements li_2 = Triangle.get(0).getElementsByTag("li");
	
		for (Element a : li_2) {
				
				a=a.getElementsByTag("a").get(0);
				System.out.println(a.attr("href"));
				String temp = a.attr("href").substring(3);
				
				href = website + temp ;
				System.out.println(href);//输出抓取到的url
				
				positionDetail(href);//职位详情
		}
		
		for(int i=2;i>size;i++)
		{	
			url = url + "&page="+String.valueOf(i);
			System.out.println(url);
			positionList(url);
		}
		
		
		
		
		/*
		//继续分析下一页
		Elements pagelinks = doc.getElementsByClass("pagelinks");
	//	System.out.println("pagelinks" + pagelinks);
		
		Element page  = pagelinks.first();
		Element yeshu = page.getElementsByTag("strong").first();
		System.out.println("页数：" + yeshu.text());
		Elements as = page.getElementsByTag("a");
//		System.out.println("as :" + as);
	
		if(as.last().text().equals("尾页") && 
				(as.get(as.size() - 2)).text().equals("下一页")) {	
			String next = as.get(as.size() - 2).attr("href");
		//	System.out.println("next: " + next);
			
			int index1  = next.indexOf(';');
		//	System.out.println(";" + index1);
			int index2 = next.indexOf('?');
		//	System.out.println("?:" + index2);
			String temp = next.substring(index1, index2);
			String newStr = "search-job!search.action";
			String aHref = next.replace(temp, newStr);
		//	System.out.println("aHref: " + aHref);
			positionList(aHref);
		}
		else {
			//positionDetail(next);
			System.out.println("最后一页了！");
		}
		*/
		
		
	 
	}
	
	public void positionDetail(String url) {
		try{
	//		System.out.println("detail!");
			String htmlContent = EHttpClientUtil.methodGet(url);
			Document doc = Jsoup.parse(htmlContent,"utf-8");
			
			
			
			Elements border_bottom = doc.getElementsByClass("border_bottom");   //获取class:postDesc
			
			
			
			
			
			
			
			
			
			String positionName = border_bottom.get(0).getElementsByTag("span").get(0).text();//职位名称
			System.out.println("职位名称: " + positionName);
			
			
			
	
			String issueTime = doc.getElementsByClass("zwxq").get(0).getElementsByTag("span").get(0).text();//发布时间
			issueTime = issueTime.substring(5);
			System.out.println("发布时间: " + issueTime);
			
			String workyears = doc.getElementsByClass("zwxq").get(0).getElementsByTag("span").get(1).text(); //工作经验要求
			workyears = workyears.substring(7);
			System.out.println("工作经验要求: " + workyears);
			
			String salary = doc.getElementsByClass("zwxq").get(0).getElementsByTag("span").get(2).text();//薪水
			salary = salary.substring(5);
			System.out.println("薪水: " + salary);
			
			String welfare = doc.getElementsByClass("zwxq").get(0).getElementsByTag("span").get(3).text(); //其它福利
			welfare = welfare.substring(7);
			System.out.println("其它福利: " + welfare);
			
			String degreelevel = doc.getElementById("degree").text();//学历要求
			degreelevel = degreelevel.substring(5);
			System.out.println("学历要求: " + degreelevel);
			
			String fulltime = doc.getElementById("nature").text(); //工作性质
			if(fulltime.length()>4)
				fulltime = fulltime.substring(4);
			System.out.println("工作性质: " + fulltime);
			
			String companyName = border_bottom.get(0).getElementsByTag("span").get(1).text();  //公司名称
			System.out.println("公司名称: " + companyName);
			
			String workcity = doc.getElementsByClass("zwxq").get(0).getElementsByTag("span").get(4).text();  //工作地点
			if(workcity.length()>5)
				workcity = workcity.substring(5);
			System.out.println("工作地点: " + workcity);
			
			String  companyWebsite = doc.getElementById("cSites").text(); //公司网站
			if(companyWebsite.length()>4)
				companyWebsite = companyWebsite.substring(4);
			System.out.println("公司网站: " + companyWebsite);
			
			String companyNature = doc.getElementById("cNature").text(); //公司性质
			if(companyNature.length()>4)
				companyNature = companyNature.substring(4);
			System.out.println("公司性质: " + companyNature);
			
			String companyAddress = doc.getElementsByClass("companyDesc").get(0).getElementsByTag("div").get(5).text();  //公司地址
			System.out.println("公司地址: " + companyAddress);
			
			
			String companyDetail = doc.getElementsByClass("zwxq").get(1).getElementsByTag("div").get(0).text();  //公司介绍
			if(companyDetail.length()>0)
				companyDetail = companyDetail.substring(0,companyDetail.indexOf("公司全部职位") ) ;
			System.out.println("公司介绍: " + companyDetail);

			
			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
			position.setWelfare(welfare);
			position.setPositionName(positionName);
			//position.setHeadcount(headcount);
			//position.setDepartment(department);
			position.setDegreelevel(degreelevel);
			//position.setPostCategory(postcategory);
			//position.setIndustry(industry);
			position.setSalary(salary);
			position.setWorkyears(workyears);
			position.setWorkcity(workcity);
			position.setFulltime(fulltime);
			position.setIssueTime(issueTime);
			position.setCompanyName(companyName);
			//position.setProfession(profession);
			
			//position.setWorkages(workages);
			//position.setCensus(census);
			
			//position.setDetailrequirement(detailrequirement);
			
			
			//position.setContactperson(contactperson);
			//position.setCompanyEmail(companyEmail);
			position.setCompanyWebsite(companyWebsite);
			position.setCompanyAddress(companyAddress);
			

			position.setCompanyNature(companyNature);
			//position.setCompanyScale(companyScale);

			//position.setCompanyIndustry(companyIndustry);
					
			position.setCompanyDetail(companyDetail);
			
		/*  position.setTechnicalpost(technicalpost);
			position.setLanguage(language);
			position.setGender(gender);
			position.setHeightbody(heightbody);
			position.setIssueTime(issueTime);
		
			
			position.setTel(tel);
		 */
			
			
			
			position.setHrSource("三亚人才网");
			position.setHrPositionUrl(url);
			
//			JSONObject obj = JSONObject.fromObject(position);
//			System.out.println(obj.toString());
			
			
			ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
			JSONObject obj = JSONObject.fromObject(rm);
			System.out.println(obj.toString());
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	

}
