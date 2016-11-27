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
import com.ehais.hrlucene.service.HrPositionService;
import com.ehais.hrlucene.service.YnrcService;

import net.sf.json.JSONObject;

@Service("ynrcService")
public class YnrcServiceImpl implements YnrcService {
	@Autowired
	private HrPositionService hrPositionService;

	private String website = "http://www.ynhr.com/";

	private String posList = "http://www.ynhr.com/jobs/jobs-list.php?"
			+ "key=&jobcategory=&trade=&citycategory=&wage=&jobtag=&education=&experience=&settr=&nature=&scale=&sort=&page=";

	@Override
	public void loadGxrc() throws Exception {
		// TODO Auto-generated method stub
		// String url = "http://www.ynhr.com/";
		// String htmlContent = EHttpClientUtil.methodGet(url);
		// String htmlContent = EHtmlUnit.httpUnitRequest(url);
		//
		// Document doc = Jsoup.parse(htmlContent, "utf-8");
		//
		// Elements clist = doc.getElementsByClass("clist");
		// for (Element element : clist) {
		// Elements a = element.getElementsByTag("a");
		// for (Element element2 : a) {
		// // 获取keyword的标签信息
		// String href = url + element2.attr("href");
		// positionList(href);// 获取此keyword的列表信息
		// }
		// }
		positionList(posList, 1);
	}

	private void positionList(String url, int i) throws Exception {
		// TODO Auto-generated method stub
		url = url + i;
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
							String href = a.attr("href");
							// System.out.println(href);
							positionDetail(href);// 职位详情
						}
					}
				}
			}
		}

		// 下一页
		positionList(url, i++);
	}

	private void positionDetail(String href) {
		// TODO Auto-generated method stub
		String htmlContent;
		try {

			// htmlContent = EHtmlUnit.httpUnitRequest(href);
			htmlContent = EHttpClientUtil.methodGet(href);
			Document doc = Jsoup.parse(htmlContent, "utf-8");

			Elements job_top = doc.getElementsByClass("job-top");

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

			Document doc2 = Jsoup.parse(htmlContent, "utf-8");
			Elements c_contact = doc2.getElementsByClass("c-contact");
			// System.out.println(c_contact.size());

			Elements contact_item = c_contact.get(0).getElementsByClass("contact-item");
			String workIntro = new String(); // 工作概述
			Elements p = job_info_content.get(0).getElementsByTag("p");
			for (Element element : p) {
				workIntro += element.text();
			}

			String contactperson = contact_item.get(0).getElementsByClass("contact-content").get(0).text(); // 联系人

			String phone = contact_item.get(1).getElementsByClass("contact-content").get(0).getElementsByTag("span")
					.get(0).text();// 联系电话（手机号）

			String companyEmail = contact_item.get(2).getElementsByClass("contact-content").get(0)
					.getElementsByTag("span").get(0).text();// 邮箱

			String companyAddress = contact_item.get(3).getElementsByClass("contact-content").get(0).text();// 公司地址

			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();

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

			ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);

			JSONObject obj = JSONObject.fromObject(rm);
			System.out.println(obj.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
