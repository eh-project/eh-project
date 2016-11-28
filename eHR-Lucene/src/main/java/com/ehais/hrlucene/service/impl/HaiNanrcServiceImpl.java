package com.ehais.hrlucene.service.impl;
import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HaiNanrcService;
import com.ehais.hrlucene.service.HrPositionService;

import net.sf.json.JSONObject;
@Service("hainanrcService")
public class HaiNanrcServiceImpl implements HaiNanrcService{
	@Autowired
	private HrPositionService hrPositionService;

	//private String website = "http://s.gxrc.com/";
	private String website = "http://www.hnrczpw.com/";
	public void loadHaiNanrc() throws Exception{
		// TODO Auto-generated method stub
		String url = "http://www.hnrczpw.com";
		//String htmlContent = EHttpClientUtil.methodGet(url);
		String htmlContent = EHtmlUnit.httpUnitRequest(url);
        //System.out.println(htmlContent);
				
		//将xml的字符串转化成html可读对象
		Document doc = Jsoup.parse(htmlContent,"utf-8");
				
		//根据html的结构读取信息
		Elements treatmentAdvantage = doc.getElementsByClass("libg1");
		for (Element element : treatmentAdvantage) {
			Elements a = element.getElementsByTag("a");
			for (Element element2 : a) {
				//获取keyword的标签信息
				String href = url + element2.attr("href");
				//System.out.println(href);
				positionList(href);//获取此keyword的列表信息
			}
		}			
		
	}
	
	public void positionList(String url) throws Exception{
		//System.out.println("请求:"+url);
		String htmlContent = EHtmlUnit.httpUnitRequest(url);
//		System.out.println(htmlContent);
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		Element posList = doc.getElementById("threadlist");
		Elements rlOne = posList.getElementsByClass("subject_t");
		for (Element element : rlOne) {
			Elements a = element.getElementsByTag("a");
            if(a.size()>0&&(a.first().attr("href").equals("http://www.hnrczpw.com")==false)){
				String href = "http://www.hnrczpw.com" + a.first().attr("href");
				//String href = "asdasdas";
				
				//String href = a.attr("href");

				positionDetail(href);//职位详情
			}
		}
		//继续分析下一页
		Elements PagedList_skipToNext = doc.getElementsByClass("newpages");
		int i=1;
		if(PagedList_skipToNext != null && PagedList_skipToNext.size() > 0){
			i=i+1;
			String href =url+i;
			positionList(href);
		}
	}
	public void positionDetail(String url) {
		try{

			//从列表中取出一条URL
			String htmlContent = EHttpClientUtil.methodGet(url);
            //String htmlContent = EHtmlUnit.httpUnitRequest(url);
			Document doc = Jsoup.parse(htmlContent,"utf-8");
			
			//转换成手机版内容
			Elements WebAppLinkContent = doc.getElementsByTag("a");
			String WebAppLink = "http://www.hnrczpw.com"+WebAppLinkContent.attr("href");
			//String a = WebAppLink;
			
			String WebHtmlContent = EHttpClientUtil.methodGet(WebAppLink);
			Document WebDoc = Jsoup.parse(WebHtmlContent,"utf-8");
		    //Document b = WebDoc;
		    //以下是分别抓取数据
		    //人数   headcount 学历 degreelevel 全兼职 fulltime 
			Element ZpRequire = WebDoc.getElementsByClass("zpRequire").first();
		    Element HeadCountH5 = ZpRequire.getElementsByTag("h5").get(0);
		    String headcount = HeadCountH5.text();
		    Element DegreeLevelH5 = ZpRequire.getElementsByTag("h5").get(1);
		    String degreelevel = DegreeLevelH5.text();
		    Element FullTimeH5 = ZpRequire.getElementsByTag("h5").get(2);
		    String fulltime = FullTimeH5.text();
		    //companyName  positionName  workcity salary 
			Element Border_Buttom = WebDoc.getElementsByClass("border_bottom").first();
		    Element PositionName = Border_Buttom.getElementsByTag("span").get(0);
		    String positionName = PositionName.text();
		    Element CompanyName = Border_Buttom.getElementsByTag("span").get(1);
		    String companyName = CompanyName.text();
		    Element WorkCityandSalary = Border_Buttom.getElementsByTag("span").get(2);
		    Element WorkCity = WorkCityandSalary.getElementsByTag("b").first();
		    String workcity = WorkCity.text();
		    Element SalaryB = WorkCityandSalary.getElementsByTag("b").get(1);
		    Element Salary = SalaryB.getElementsByTag("b").get(1);
		    String salary = Salary.text();
		    //发布日期issueTime   工作经验要求  workyears 其他待遇说明 welfare
		    Element ZWXQ = WebDoc.getElementsByClass("zwxq").first();
	        Element IssueTime = ZWXQ.getElementsByTag("span").first();
	        String issueTimeBefore = IssueTime.text();
	        String issueTime = issueTimeBefore.substring(5);
	        Element WorkYears = ZWXQ.getElementsByTag("span").get(1);
	        String workyearsBefore = WorkYears.text();
	        String workyears = workyearsBefore.substring(7);
	        //String a = workyears;
	        Element Welfare = ZWXQ.getElementsByTag("span").get(3);
	        String welfareBefore = Welfare.text();
	        String welfare = welfareBefore.substring(7);
	       // String a = welfare;
	        //职位描述 detailrequirement
	        Element Requirement = ZWXQ.getElementsByTag("div").get(2);
	        String detailrequirementBefore = Requirement.text();
	        String detailrequirement = detailrequirementBefore.substring(5);
	        //String a = detailrequirement;
	        
	        //公司地址 company_address 公司介绍company_detail
	        Element CompanyDesc = WebDoc.getElementsByClass("companyDesc").first();
	        Element Company_Address = CompanyDesc.getElementsByTag("div").get(5);
	        String company_address = Company_Address.text();
	        Element Company_DetailDiv = CompanyDesc.getElementsByTag("div").get(7);
	        Element Company_Detail = Company_DetailDiv.getElementsByTag("span").first();
	        String company_detail = Company_Detail.text();
	        String a = company_detail;
	        
	        //以下是存入数据库
            HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
			
			position.setPositionName(positionName);
			position.setHeadcount(headcount);
			position.setDegreelevel(degreelevel);
			position.setSalary(salary);
			position.setWorkyears(workyears);
			position.setWorkcity(workcity);
			position.setFulltime(fulltime);

			position.setIssueTime(issueTime);
			position.setDetailrequirement(detailrequirement);
			position.setCompanyName(companyName);

			
			
			position.setHrSource("海南人才网");
			position.setHrPositionUrl(url);
			
			ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
			JSONObject obj = JSONObject.fromObject(rm);
			System.out.println(obj.toString());
		    
		    

		
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		HaiNanrcServiceImpl c = new HaiNanrcServiceImpl();
		try {
//			c.loadGxrc();
//			c.positionList("http://s.gxrc.com/sjob?keyword=%E8%BD%AF%E4%BB%B6%E5%B7%A5%E7%A8%8B%E5%B8%88");
			c.positionDetail("http://www.hnrczpw.com/gposinfos/g_pos/pos201243009.shtml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}