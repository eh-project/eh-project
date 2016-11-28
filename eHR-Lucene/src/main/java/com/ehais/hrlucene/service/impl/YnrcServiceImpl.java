package com.ehais.hrlucene.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HrCompanyService;
import com.ehais.hrlucene.service.HrPositionService;
import com.ehais.hrlucene.service.YnrcService;

import net.sf.json.JSONObject;

@Service("ynrcService")
public class YnrcServiceImpl implements YnrcService {
	@Autowired
	private HrPositionService hrPositionService;

	@Autowired
	private HrCompanyService hrCompanyService;

	private String website = "http://www.ynhr.com/";

	// private String posList =
	// "http://www.ynhr.com/jobs/jobs-list.php?key=&jobcategory=&trade=&citycategory=&wage=&jobtag=&education=&experience=&settr=&nature=&scale=&sort=&page=";
	private String posList = "http://www.ynhr.com/jobs/jobs-list.php?key=&jobcategory=&trade=&citycategory=&wage=&jobtag=&education=&experience=&settr=&nature=&scale=&sort=&page=1";

	@Override
	public void loadYnrc() throws Exception {
		// TODO Auto-generated method stub
//		 String url = "http://www.ynhr.com/";
//		 String htmlContent = EHttpClientUtil.methodGet(url);
//		 String htmlContent = EHtmlUnit.httpUnitRequest(url);
//		
//		 Document doc = Jsoup.parse(htmlContent, "utf-8");
//		
//		 Elements clist = doc.getElementsByClass("clist");
//		 for (Element element : clist) {
//		 Elements a = element.getElementsByTag("a");
//		 for (Element element2 : a) {
//		 // 获取keyword的标签信息
//		 String href = url + element2.attr("href");
//		 positionList(href);// 获取此keyword的列表信息
//		 }
//		 }
//		 positionList(posList, 10);
		positionList(posList);
	}

	// private void positionList(String url, int i) throws Exception {
	private void positionList(String url) throws Exception {
		// TODO Auto-generated method stub

//		 System.out.println("请求:" + url + i);
		System.out.println("请求:" + url);
		String htmlContent = EHtmlUnit.httpUnitRequest(url);
		Document doc = Jsoup.parse(htmlContent, "utf-8");

		Elements info_list_wrap = doc.getElementsByClass("info-list-wrap");
		for (Element element : info_list_wrap) {
			Elements infolist_row = element.getElementsByClass("infolist-row");
			for (Element element1 : infolist_row) {
				Elements info_list_block = element1.getElementsByClass("info-list-block");
				for (Element element2 : info_list_block) {
					Elements item1 = element2.getElementsByClass("item1");
					for (Element element3 : item1) {
						Elements a = element3.getElementsByTag("a");
						if (a.size() > 0) {
							positionDetail(a.attr("href"));// 职位详情
						}
					}
				}
			}
		}

		// 下一页
//		 positionList(url, i++);
//		 Elements elements = doc.getElementsByTag("a");
//		 for (Element element : elements) {
//		 if (element.text().equals("下一页")) {
//		 positionDetail(element.attr("href"));
//		 break;
//		 }
//		 }

		Elements elements = doc.getElementsByClass("page").get(0).getElementsByTag("li");
//		System.out.println(elements.size());

		Element a = elements.get(11).getElementsByTag("a").get(0);
		if (a.hasAttr("href")) {
//			System.out.println(a.attr("href"));
			positionList(a.attr("href"));
		}

	}

	
	/**
	 * 获取值位详情
	 * 
	 * @param href
	 */
	private void positionDetail(String href) {
		// TODO Auto-generated method stub
		String htmlContent;
		try {

//			htmlContent = EHttpClientUtil.methodGet(href);
			htmlContent = EHtmlUnit.httpUnitRequest(href);
			Document doc = Jsoup.parse(htmlContent, "utf-8");

			Elements job_top = doc.getElementsByClass("job-top");
			if (job_top.size() == 0) {
				return;
			}

			Elements job_id_item = doc.getElementsByClass("job-id-item");

			Elements job_info_content = doc.getElementsByClass("job-info-content");

			String positionName = job_top.get(0).getElementsByClass("job-name").get(0).text();// 职位名
			String companyName = job_top.get(0).getElementsByClass("job-company").get(0).getElementsByTag("a").get(0)
					.text();// 公司名

			String hrSource = "云南人才网";// 来源

			String hrPositionUrl = href;// 网址

			String salary = job_id_item.get(0).getElementsByTag("span").get(0).text();// 薪水

			String fulltime = job_id_item.get(1).text().split("：")[1];// 工作性质

			String workages = job_id_item.get(2).text().split("：")[1];// 年龄

			String headcount = job_id_item.get(3).text().split("：")[1];// 人数

			String postCategory = job_id_item.get(4).text().split("：")[1];// 职位类别

			String gender = job_id_item.get(5).text().split("：")[1];// 性别

			String workcity = job_id_item.get(6).text().split("：")[1];// 工作地点

			String degreelevel = job_id_item.get(7).text().split("：")[1];// 学历要求

			String workyears = job_id_item.get(8).text().split("：")[1];// 工作经验

			String id = href.substring(href.indexOf("id=") + 3);
			String job_contact = website + "/plus/ajax_contact.php?id=" + id + "&act=jobs_contact&time="
					+ System.currentTimeMillis();
			htmlContent = EHttpClientUtil.methodGet(job_contact);

			String workIntro = new String(); // 工作概述
			Elements p = job_info_content.get(0).getElementsByTag("p");
			for (Element element : p) {
				workIntro += element.text();
			}

			Document doc2 = Jsoup.parse(htmlContent, "utf-8");
			Elements c_contact = doc2.getElementsByClass("c-contact");
//			 System.out.println(c_contact.size());

			Elements contact_item = c_contact.get(0).getElementsByClass("contact-item");

			String contactperson = contact_item.get(0).getElementsByClass("contact-content").get(0).text(); // 联系人

			String phone = contact_item.get(1).getElementsByClass("contact-content").get(0).getElementsByTag("span")
					.get(0).text();// 联系电话（手机号）

			String companyEmail = contact_item.get(2).getElementsByClass("contact-content").get(0)
					.getElementsByTag("span").get(0).text();// 邮箱

			String companyAddress = contact_item.get(3).getElementsByClass("contact-content").get(0).text();// 公司地址

			String href2 = null;
			Elements elements = doc.getElementsByClass("c-control-item");
			for (Element element : elements) {
				if (element.text().equals("公司介绍")) {
					href2 = element.attr("href");
					break;
				}
			}

			String companyDetails = null;
			String nature = null;// 性质
			String companyIndustry = null;// 所属行业
			String scale = null;// 规模
			String webUrl = null;// 网址

			Map<String, String> details = getCompanyDetails(href2);
//			System.out.println(details);

			companyDetails = details.get("details");
			nature = details.get("nature");
			companyIndustry = details.get("industry");
			scale = details.get("scale");
			webUrl = details.get("url");

			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
			HaiHrCompany com = new HaiHrCompany();

			position.setPositionName(positionName);
			position.setCompanyName(companyName);
			position.setHrSource(hrSource);
			position.setHrPositionUrl(hrPositionUrl);
			position.setSalary(salary);
			position.setFulltime(fulltime);
			position.setGender(gender);
			position.setWorkages(workages);
			position.setHeadcount(headcount);
			position.setPostCategory(postCategory);
			position.setWorkcity(workcity);
			position.setDegreelevel(degreelevel);
			position.setWorkyears(workyears);
			position.setWorkIntro(workIntro);
			position.setContactperson(contactperson);
			position.setPhone(phone);
			position.setCompanyEmail(companyEmail);
			position.setCompanyAddress(companyAddress);
			position.setCompanyDetail(companyDetails);
			position.setIndustry(companyIndustry);
			position.setCompanyScale(scale);
			position.setCompanyNature(nature);
			position.setCompanyWebsite(webUrl);

			com.setCompany_detail(companyDetails);
			com.setCompany_address(companyAddress);
			com.setCompany_detail(companyDetails);
			com.setCompany_email(companyEmail);
			com.setCompany_industry(companyIndustry);
			com.setCompany_name(companyName);
			com.setCompany_scale(scale);
			com.setCompany_website(webUrl);
			com.setCompany_nature(nature);
			com.setContactperson(contactperson);
			com.setPhone(phone);

			savePositionAndCompany(position, com);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<String, String> getCompanyDetails(String href) {
		String htmlContent;
		Map<String, String> comDetails = new HashMap<>();
		try {
			htmlContent = EHtmlUnit.httpUnitRequest(href);
//			htmlContent = EHttpClientUtil.methodGet(href);
			Document doc = Jsoup.parse(htmlContent, "utf-8");

			Elements elements = doc.getElementsByClass("company-info-wrap");
			Element element = elements.get(0).getElementsByTag("div").get(0);

			comDetails.put("details", element.text());

			elements = doc.getElementsByClass("company-info-list").get(0).getElementsByTag("li");

			comDetails.put("nature", elements.get(0).text());
			comDetails.put("industry", elements.get(1).text());
			comDetails.put("scale", elements.get(2).text());
			if (elements.size() > 4) {
				String url = elements.get(4).text();
				comDetails.put("url", url);

			}

//			System.out.println();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return comDetails;
	}

	public void savePositionAndCompany(HaiHrPositionWithBLOBs position, HaiHrCompany com) throws Exception {
		ReturnObject<HaiHrPosition> rm1 = hrPositionService.SaveHrPosition(position);

		ReturnObject<HaiHrCompany> rm2 = hrCompanyService.SaveHrCompany(com);

		JSONObject obj1 = JSONObject.fromObject(rm1);
		System.out.println(obj1.toString());

		JSONObject obj2 = JSONObject.fromObject(rm2);
		System.out.println(obj2.toString());
	}

}
