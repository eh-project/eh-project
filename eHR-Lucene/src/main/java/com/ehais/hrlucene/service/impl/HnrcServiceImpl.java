package com.ehais.hrlucene.service.impl;

import org.ehais.tools.ReturnObject;
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

	private String website = "http://www.hnrcsc.com";
//	@Override
	public void loadHnrc() throws Exception {
		// TODO Auto-generated method stub
		String url = "http://www.hnrcsc.com";
		
		String htmlContent = EHttpClientUtil.methodGet(url);
//		String htmlContent = EHtmlUnit.httpUnitRequest(url);
		System.out.println(htmlContent);
		
		//将xml的字符串转化成html可读对象
		Document doc = Jsoup.parse(htmlContent,"utf-8");
	//	System.out.println("doc" + doc);
		
		//根据html的结构读取信息
		Elements cata_content = doc.getElementsByClass("cata-content");
		for (Element element : cata_content) {
			Elements a = element.getElementsByTag("a");
			
			for (Element element2 : a) {
			//	System.out.println(element2);
				//获取keyword的标签信息
				String href = url + element2.attr("href");
				System.out.println("模块页： " + href);
				positionList(href);//获取此keyword的列表信息
			}
		}	
		
	}
	
	public void positionList(String url) throws Exception{
		System.out.println("请求:" + url);
		String htmlContent = EHttpClientUtil.methodGet(url);
	//	System.out.println(htmlContent);
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		Element posList = doc.getElementById("vacancy");
		if(posList == null) 
			return;
		Elements tables_a = posList.getElementsByTag("a");
		String href = null;
		for (Element a : tables_a) {
			if(a.hasAttr("href") && a.attr("href").indexOf("view-recruit") > 0){
				href = website + "/" + a.attr("href");
				System.out.println(a.text() + "=="+href);
				positionDetail(href);//职位详情
			}
		}
		/**
		Elements tbodys = posList.getElementsByTag("tbody");
		Element tbody = tbodys.get(1);
		//System.out.println("tbody" + tbody);
		//System.out.println("tbody: " + tbody);
		
		Elements tables = tbody.getElementsByTag("table");
		
	//	System.out.println("tables: " + tables);
		for (Element element : tables) {
			Elements tds = element.getElementsByTag("td");
			if(tds.size() > 0){
				Element td = tds.first();
	//			System.out.println("test td :" + td);
				String href = website + td.getElementsByTag("a").first().attr("href");
				System.out.println("href:" + href);
				positionDetail(href);//职位详情
			}
		}
		**/
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
		
		
		/*for(Element a : as){
		System.out.println("a.text: " + a.text());
		if(as.last().text().equals("尾页")) {
			System.out.println("next");
			 String href =  a.attr("href");
			 System.out.println("href :" + href);
			 positionList(href);
		}
		else {
			System.out.println("没有下一页了！");
			continue;
		}			
	}*/
	 
	}
	
	public void positionDetail(String url) {
		try{
	//		System.out.println("detail!");
			String htmlContent = EHttpClientUtil.methodGet(url);
			Document doc = Jsoup.parse(htmlContent,"utf-8");
			
			Element positionNameEle = doc.getElementsByClass("blue").first();
			String positionName = positionNameEle.text();//职位名称
			System.out.println("positionNameEle: " + positionName);
			
			//获取信息的主块
			Element div = doc.getElementById("col-main-wrapper");
			Elements tables = div.getElementsByTag("table");
		//	System.out.println("tables: " + tables);
			//第一个表格的获取项
			Element table = tables.first();
		//	System.out.println("table" + table);
			Elements tr = table.getElementsByTag("tr");
			
			Elements td = tr.get(1).getElementsByTag("td");
	//		System.out.println("td :" + td);
			String fulltime = td.get(1).text();
			String department = td.get(3).text();
			
			td = tr.get(2).getElementsByTag("td");
			String postcategory = td.get(1).text();
			String workcity = td.get(3).text();
			
			td = tr.get(3).getElementsByTag("td");
			String headcount = td.get(1).text();
			String salary = td.get(3).text();
			
			td = tr.get(4).getElementsByTag("td");
			String workyears = td.get(1).text();
			String workages = td.get(3).text();
			
			td = tr.get(5).getElementsByTag("td");
			String degreelevel = td.get(1).text();
			String profession = td.get(3).text();
			
			td = tr.get(6).getElementsByTag("td");
			String industry = td.get(1).text();
			String census = td.get(3).text();
			
			//具体要求
			Element divs = doc.getElementsByClass("col-main").first();
		
			String detailrequirement = divs.getElementsByClass("mb10").get(1).text();
			System.out.println("detailrequirement" + detailrequirement);
			
			//公司联系信息
			Element comcontact = tables.get(1);
		//	System.out.println("com: " + comcontact);
			Elements contacttr = comcontact.getElementsByTag("tr");
			
			Elements contacttd = contacttr.get(0).getElementsByTag("td");
			String companyAddress = contacttd.get(1).text();
			
			contacttd = contacttr.get(2).getElementsByTag("td");
			String companyEmail = contacttd.get(1).text();
			
			contacttd = contacttr.get(3).getElementsByTag("td");
			String contactperson = contacttd.get(1).text();
			
			//得到公司名字与概况的信息
			Element companyintro = doc.getElementById("j-col-sub");
			Element introtable = companyintro.getElementsByTag("table").first();
			
			Elements introtr = introtable.getElementsByTag("tr");
		//	System.out.println("tr ==>" + introtr);
			
			Elements introtd = introtr.get(0).getElementsByTag("td");
			String companyWebsite = introtd.get(1).text();
			
			introtd = introtr.get(1).getElementsByTag("td");
			String companyIndustry = introtd.get(1).text();
			
			String companyScale = null;
			String companyNature = null;
			if (introtr.size() > 2) {
				introtd = introtr.get(2).getElementsByTag("td");
				companyScale = introtd.get(1).text();
				
				introtd = introtr.get(3).getElementsByTag("td");
				 companyNature = introtd.get(1).text();
			}
			
		
			Element companynamea = companyintro.getElementsByTag("a").first();
//			String companyName = companynamea.attr("href");
			String companyName = companynamea.text();//这里换成text()
			
			
			/*td = tr.get(5).getElementsByTag("td");
			String gender = td.get(0).text();
			String technicalpost = td.get(1).text();
			
			td = tr.get(6).getElementsByTag("td");
			String language = td.get(0).text();
			String issueTime = td.get(1).text();
			
			
			Elements xingzhiUL = doc.getElementsByClass("xingzhiUL");
			Elements li = xingzhiUL.first().getElementsByTag("li");
			String companyNature = li.get(0).text().replace("性质：", "");
			String companyScale = li.get(1).text().replace("规模：", "");
			String companyIndustry = li.get(2).text().replace("行业：", "");
			
			
			Elements gz_info_top2 = doc.getElementsByClass("gz_info_top2");
			String companyName = gz_info_top2.first().getElementsByTag("h4").text();
			
			
			Elements gz_info = doc.getElementsByClass("gz_info");

			String companyDetail = gz_info.get(1).getElementsByTag("p").html();
			
			
			Elements gz_info_txt = doc.getElementsByClass("gz_info_txt");
			String detailrequirement = gz_info_txt.html(); 
			
			Element table_add = doc.getElementById("table_add");
			tr = table_add.getElementsByTag("tr");
			td = tr.get(0).getElementsByTag("td");
			String tel = td.get(0).text();
			td = tr.get(1).getElementsByTag("td");
			String contactperson = td.get(0).text();
			td = tr.get(2).getElementsByTag("td");
			String companyEmail = td.get(0).text();
			td = tr.get(3).getElementsByTag("td");
			String companyWebsite = td.get(0).text();
			td = tr.get(4).getElementsByTag("td");
			String companyAddress = td.get(0).text(); */
			
			
			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
			
			position.setPositionName(positionName);
			position.setHeadcount(headcount);
			position.setDepartment(department);
			position.setDegreelevel(degreelevel);
			position.setPostCategory(postcategory);
			position.setIndustry(industry);
			position.setSalary(salary);
			position.setWorkyears(workyears);
			position.setWorkcity(workcity);
			position.setFulltime(fulltime);
			position.setProfession(profession);
			
			position.setWorkages(workages);
			position.setCensus(census);
			
			position.setDetailrequirement(detailrequirement);
			
			position.setContactperson(contactperson);
			position.setCompanyEmail(companyEmail);
			position.setCompanyWebsite(companyWebsite);
			position.setCompanyAddress(companyAddress);
			

			position.setCompanyNature(companyNature);
			position.setCompanyScale(companyScale);

			position.setCompanyIndustry(companyIndustry);
					
			position.setCompanyName(companyName);
			
/*			position.setTechnicalpost(technicalpost);
			position.setLanguage(language);
			position.setGender(gender);
			position.setHeightbody(heightbody);
			position.setIssueTime(issueTime);
		
			position.setCompanyDetail(companyDetail);
			position.setTel(tel);
		 */
			
			
			
			position.setHrSource("湖南人才网");
			position.setHrPositionUrl(url);
			
//			JSONObject obj = JSONObject.fromObject(position);
//			System.out.println(obj.toString());
			
			System.out.println(postcategory);
			ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
			JSONObject obj = JSONObject.fromObject(rm);
			System.out.println(obj.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		HnrcServiceImpl c = new HnrcServiceImpl();
		try {
//			c.loadGxrc();
//			c.positionList("http://www.hnrcsc.com/web/seekjob/search-job!search.action?m=search&n=ts&filter.positionCode=01");
			c.positionDetail("http://www.hnrcsc.com//web/view/view-recruit/id/01775F96D64FACBE.html;jsessionid=37CD1DB5206E59C6429B8CE99433E56A-n1.tomcat2?r=2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
