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

@Service("hnrcService")
public class HnrcServiceImpl implements HnrcService {
	@Autowired
	private HrPositionService hrPositionService;

	private String website = "http://www.syrczpw.com/";  //三亚人才网址
//	@Override
	public void loadHnrc() throws Exception {
		
		
		
		String url = "http://www.syrczpw.com/";
		//String htmlContent = EHttpClientUtil.methodGet(url);
		String htmlContent = EHtmlUnit.httpUnitRequest(url);
		System.out.println(htmlContent);
		
		//将xml的字符串转化成html可读对象
		Document doc = Jsoup.parse(htmlContent,"utf-8");
	//	System.out.println("doc" + doc);
		
		//根据html的结构读取信息
		Elements job_type = doc.getElementsByClass("job_type");
		for (Element element : job_type) {
			Elements a = element.getElementsByTag("a");   //获得第一个页面的a链接
			for (Element element2 : a) {
				//System.out.println(element2);   输出测试是否抓取到
				//获取keyword的标签信息
				String href = url + element2.attr("href");  //合并新的链接
				System.out.println("第一个页面a链接： " + href);
				positionList(href);//获取此keyword的列表信息
			}
		}	
		
	}
	
	
	
	
	
	//第二个页面
	public void positionList(String url) throws Exception{
		System.out.println("请求第二个页面:" + url);  //输出前面抓取到的url
		
		String htmlContent = EHttpClientUtil.methodGet(url);
		
		//System.out.println(htmlContent);
		
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		Element threadlist = doc.getElementById("threadlist");
		//如果没有这个id结束函数
		if(threadlist == null) 
			return;
		
		Elements subject_t = threadlist.getElementsByClass("subject_t");
		
		String href = null;
			
		
		
		
		int cout=0;	
		for (Element a : subject_t) {
			if(cout>=3){
				
				href = website + "/" + a.attr("href");
				System.out.println(a.text() + "=="+href);//输出抓取到的url
				
				positionDetail(href);//职位详情
				
			}
			cout++;
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
			
			Elements td = doc.getElementsByTag("td");
			
			
			
			String positionName = td.get(2).text();//职位名称
			System.out.println("职位名称: " + positionName);
			String fulltime = td.get(5).text(); //全职工作
			System.out.println("工作性质: " + fulltime);
			String issueTime = td.get(7).text();//发布时间
			System.out.println("发布时间: " + issueTime);
			String degreelevel = td.get(12).text();//学历要求
			System.out.println("学历要求: " + degreelevel);
			String workyears = td.get(14).text();//工作经验要求
			System.out.println("工作经验要求: " + workyears);
			String salary = td.get(16).text();//薪水
			System.out.println("薪水: " + salary);
			String companyName ="还没写好"; 
			
			
			
			
			
			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
			
			position.setPositionName(positionName);
			//position.setHeadcount(headcount);
			//position.setDepartment(department);
			position.setDegreelevel(degreelevel);
			//position.setPostCategory(postcategory);
			//position.setIndustry(industry);
			position.setSalary(salary);
			position.setWorkyears(workyears);
			//position.setWorkcity(workcity);
			position.setFulltime(fulltime);
			position.setIssueTime(issueTime);
			position.setCompanyName(companyName);
			//position.setProfession(profession);
			
			//position.setWorkages(workages);
			//position.setCensus(census);
			
			//position.setDetailrequirement(detailrequirement);
			
			//position.setContactperson(contactperson);
			//position.setCompanyEmail(companyEmail);
			//position.setCompanyWebsite(companyWebsite);
			//position.setCompanyAddress(companyAddress);
			

			//position.setCompanyNature(companyNature);
			//position.setCompanyScale(companyScale);

			//position.setCompanyIndustry(companyIndustry);
					
			
			
		/*  position.setTechnicalpost(technicalpost);
			position.setLanguage(language);
			position.setGender(gender);
			position.setHeightbody(heightbody);
			position.setIssueTime(issueTime);
		
			position.setCompanyDetail(companyDetail);
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
