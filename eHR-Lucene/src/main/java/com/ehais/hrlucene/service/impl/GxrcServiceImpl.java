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
import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.HrPositionService;

import net.sf.json.JSONObject;

@Service("gxrcService")
public class GxrcServiceImpl implements GxrcService {
	@Autowired
	private HrPositionService hrPositionService;

	private String website = "http://s.gxrc.com/";

	@Override
	public void loadGxrc() throws Exception {
		// TODO Auto-generated method stub
		String url = "http://s.gxrc.com/";
		String htmlContent = EHttpClientUtil.methodGet(url);
		// String htmlContent = EHtmlUnit.httpUnitRequest(url);
		// System.out.println(htmlContent);

		// 将xml的字符串转化成html可读对象
		Document doc = Jsoup.parse(htmlContent, "utf-8");

		// 根据html的结构读取信息
		Elements treatmentAdvantage = doc.getElementsByClass("treatmentAdvantage");
		for (Element element : treatmentAdvantage) {
			Elements a = element.getElementsByTag("a");
			for (Element element2 : a) {
				// 获取keyword的标签信息
				String href = url + element2.attr("href");
				positionList(href);// 获取此keyword的列表信息
			}
		}

	}

	public void positionList(String url) throws Exception {
		System.out.println("请求:" + url);
		String htmlContent = EHttpClientUtil.methodGet(url);
		// System.out.println(htmlContent);
		Document doc = Jsoup.parse(htmlContent, "utf-8");
		Element posList = doc.getElementById("posList");
		Elements rlOne = posList.getElementsByClass("rlOne");
		for (Element element : rlOne) {
			Elements a = element.getElementsByTag("a");
			if (a.size() > 0) {
				String href = a.first().attr("href");
				positionDetail(href);// 职位详情
			}
		}
		// 继续分析下一页
		Elements PagedList_skipToNext = doc.getElementsByClass("PagedList-skipToNext");
		if (PagedList_skipToNext != null && PagedList_skipToNext.size() > 0) {
			String href = website + "sjob" + PagedList_skipToNext.first().getElementsByTag("a").first().attr("href");
			positionList(href);
		}
	}

	public void positionDetail(String url) {
		try {

			String htmlContent = EHttpClientUtil.methodGet(url);
			Document doc = Jsoup.parse(htmlContent, "utf-8");
			Element positionNameEle = doc.getElementById("positionName");
			String positionName = positionNameEle.text();// 职位名称
			Element gs_zp_table = doc.getElementsByClass("gs_zp_table").first();
			Elements tr = gs_zp_table.getElementsByTag("tr");

			Elements td = tr.get(0).getElementsByTag("td");
			String headcount = td.get(0).text();
			String degreelevel = td.get(1).text();

			td = tr.get(1).getElementsByTag("td");
			String salary = td.get(0).text();
			String workyears = td.get(1).text();

			td = tr.get(2).getElementsByTag("td");
			String workcity = td.get(0).text();
			String fulltime = td.get(1).text();

			td = tr.get(3).getElementsByTag("td");
			String profession = td.get(0).text();
			String heightbody = td.get(1).text();

			td = tr.get(4).getElementsByTag("td");
			String workages = td.get(0).text();
			String census = td.get(1).text();

			td = tr.get(5).getElementsByTag("td");
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
			String companyAddress = td.get(0).text();

			HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();

			position.setPositionName(positionName);
			position.setHeadcount(headcount);
			position.setDegreelevel(degreelevel);
			position.setSalary(salary);
			position.setWorkyears(workyears);
			position.setWorkcity(workcity);
			position.setFulltime(fulltime);
			position.setProfession(profession);
			position.setHeightbody(heightbody);
			position.setWorkages(workages);
			position.setCensus(census);
			position.setGender(gender);
			position.setTechnicalpost(technicalpost);
			position.setLanguage(language);
			position.setIssueTime(issueTime);
			position.setDetailrequirement(detailrequirement);
			position.setCompanyName(companyName);
			position.setCompanyNature(companyNature);
			position.setCompanyScale(companyScale);
			position.setCompanyIndustry(companyIndustry);
			position.setCompanyDetail(companyDetail);
			position.setTel(tel);
			position.setContactperson(contactperson);
			position.setCompanyEmail(companyEmail);
			position.setCompanyWebsite(companyWebsite);
			position.setCompanyAddress(companyAddress);

			position.setHrSource("广西人才网");
			position.setHrPositionUrl(url);

			// JSONObject obj = JSONObject.fromObject(position);
			// System.out.println(obj.toString());

			ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
			JSONObject obj = JSONObject.fromObject(rm);
			System.out.println(obj.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		GxrcServiceImpl c = new GxrcServiceImpl();
		try {
			// c.loadGxrc();
			// c.positionList("http://s.gxrc.com/sjob?keyword=%E8%BD%AF%E4%BB%B6%E5%B7%A5%E7%A8%8B%E5%B8%88");
			c.positionDetail("http://www.gxrc.com/WebPage/JobDetail.aspx?EnterpriseID=1432258&PositionId=2425647");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
