package com.ehais.hrlucene.service.impl;

import java.util.ArrayList;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.GzrcService;
import com.ehais.hrlucene.service.HrPositionService;

import net.sf.json.JSONObject;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

@Service("GzrcService")
public class GzrcServiceImpl implements GzrcService {
	
	@Autowired
	private HrPositionService hrPositionService;
	private String website = "http://www.gzrc.gov.cn/";
	/* (non-Javadoc)
	 * @see com.ehais.hrlucene.service.impl.GzrcService#loadGzrc()
	 */
	
	
	
	public void loadGzrc() throws Exception {
		
		// TODO Auto-generated method stub
		String htmlContent = EHtmlUnit.httpUnitRequest(this.website+"SearchResult.php");
		
		//将xml的字符串转化成html可读对象
		
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		
		//根据html的结构读取信息
		
		Element Ele = doc.getElementById("hoverZW");
		Elements Eletr = Ele.getElementsByTag("tr");
		int first =1;
		int line = 0;
		for (Element subtr : Eletr) {
			if (first == 1){
				first = 0;
				continue;	
			}
			line = line + 1;
			System.out.println(line);
			
			Elements Eletd = subtr.getElementsByTag("td");
			//性别
			String sex = "1";
			try{
				sex = Eletd.get(5).text();
			}catch(Exception e){
				break;
			}
			
			Elements subtd = Eletd.get(1).getElementsByTag("a");
			String href = website + subtd.attr("href");
			positionList(href,sex);
			
//			for(Element subtd : Eletd){
//				Elements Elea = subtd.getElementsByTag("a");
//				for(Element suba : Elea){
//					String href = website + Elea.attr("href");
//					positionList(href);
//		        }
//
//			}
			
		}
		
		Elements Page = doc.getElementsByClass("page_style");
		Elements subpage = Page.get(0).getElementsByTag("a");
		String nextpage = website + subpage.get(11).attr("href");
		loadGzrc(nextpage);
	}
	
	public void positionList(String urlhr,String a) throws Exception{
		
		System.out.println("请求：" + urlhr);
		String htmlContent = EHtmlUnit.httpUnitRequest(urlhr);
		Document doc = Jsoup.parse(htmlContent,"utf-8");
		
		Elements poslist = doc.getElementsByClass("tit-h2");
		String positionName = poslist.get(0).text();
		
		Elements subpos = doc.getElementsByClass("top-content");
		Elements posdl1 = subpos.get(0).getElementsByTag("p");
		String profession = posdl1.get(0).text();
		profession = profession.replace("专业要求：", "");
		String degreelevel = posdl1.get(1).text();
		degreelevel = degreelevel.replace("学历要求：", "");
		String workyears = posdl1.get(2).text();
		workyears = workyears.replace("工作经验：", "");
		String salary = posdl1.get(3).text();
		salary = salary.replace("薪资待遇：", "");
		String headcount = posdl1.get(4).text();
		headcount = headcount.replace("招聘人数：", "");
		
		Elements posdl2 = subpos.get(1).getElementsByTag("p");
		String issueTime = posdl2.get(0).text();
		issueTime = issueTime.replace("更新日期：", "");
		String workages = posdl2.get(2).text();
		workages = workages.replace("年龄要求：","");
		String language = posdl2.get(3).text();
		language = language.replace("外语要求：", "");
		String workcity = posdl2.get(5).text(); 
		workcity = workcity.replace("工作地点：", "");
		
		Elements PosIntro = doc.getElementsByClass("sesn-info");
		String workIntro = PosIntro.get(0).text();
		
		Elements CpyIntro = doc.getElementsByClass("job-company");
		String companyDetail = CpyIntro.get(0).text();
		
		Elements Cpyname = doc.getElementsByClass("comp-tit");
		String companyName = Cpyname.get(0).text();
		
		Elements Cpyscale = doc.getElementsByClass("s-comp-info");
		ArrayList<String> comp = new ArrayList<String>();
		for(Element subcpy : Cpyscale){
			Elements compscale = subcpy.getElementsByTag("span");
			if(compscale.size()==0){
				continue;
			}
			comp.add(compscale.get(0).text());
//			System.out.println("stop");			
		}
		
		String companyScale = "-";
		try{
			companyScale = comp.get(0);
		}catch(Exception e){
		
		}
		
		String companyNature = "-";	
		try{
			companyNature = comp.get(1);
		}catch(Exception e){
			
		}
		
		String companyIndustry = "-";
		try{
			companyIndustry = comp.get(2);
		}catch(Exception e){
					
				}
		String gender = a;
		
		HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();

		position.setPositionName(positionName);
		position.setHeadcount(headcount);
		position.setDegreelevel(degreelevel);
		position.setSalary(salary);
		position.setWorkyears(workyears);
		position.setWorkcity(workcity);
		position.setProfession(profession);
		position.setWorkages(workages);
		position.setGender(gender);
		position.setLanguage(language);
		position.setIssueTime(issueTime);
		position.setCompanyName(companyName);
		position.setCompanyNature(companyNature);
		position.setCompanyScale(companyScale);
		position.setCompanyIndustry(companyIndustry);
		position.setCompanyDetail(companyDetail);
		position.setWorkIntro(workIntro);
		

		position.setHrSource("贵州人才网");
		position.setHrPositionUrl(urlhr);
		
		ReturnObject<HaiHrPosition> rm = this.hrPositionService.SaveHrPosition(position);
		JSONObject obj = JSONObject.fromObject(rm);
		System.out.println(obj.toString());
		
	}	
	
	
	public void loadGzrc(String URLs) throws Exception{
		// TODO Auto-generated method stub
				String htmlContent = EHtmlUnit.httpUnitRequest(URLs);
				
				//将xml的字符串转化成html可读对象
				
				Document doc = Jsoup.parse(htmlContent,"utf-8");
				
				//根据html的结构读取信息
				
				Element Ele = doc.getElementById("hoverZW");
				Elements Eletr = Ele.getElementsByTag("tr");
				int first =1;
				int line = 0;
				for (Element subtr : Eletr) {
					if (first == 1){
						first=0;
						continue;
					}
					line = line + 1;
					System.out.println(line);
					Elements Eletd = subtr.getElementsByTag("td");
					//性别
					String sex = Eletd.get(5).text();
					
					Elements subtd = Eletd.get(1).getElementsByTag("a");
					String href = website + subtd.attr("href");
					positionList(href,sex);
					
				}
				
				Elements Page = doc.getElementsByClass("page_style mLink");
				Elements subpage = Page.get(0).getElementsByTag("a");
				String nextpage;
				try{
					nextpage = website + subpage.get(11).attr("href");
				}catch(Exception e){
					System.out.println("completed!");
					return ;
				}
				loadGzrc(nextpage);
	}
	
	public static void main(String[] args) throws Exception{
		GzrcService gzrc = new GzrcServiceImpl();
		gzrc.loadGzrc();
	}
}

