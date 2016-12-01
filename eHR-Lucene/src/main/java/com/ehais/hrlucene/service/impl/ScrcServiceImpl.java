package com.ehais.hrlucene.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HrPositionService;
import com.ehais.hrlucene.service.ScrcService;

import net.sf.json.JSONObject;






/**
 * @author stephen
 *
 */
@Service("ScrcService")
public class ScrcServiceImpl implements ScrcService {
	@Autowired
	private HrPositionService hrPositionService;
	private String scURL="http://www.scrc168.com";
	private int count=1;
	//private String scURL="http://www.baidu.com";
	public ReturnObject rm = new ReturnObject();
	
	
	
	public void Loadrc(String positionURL) throws Exception{
		
		Document doc=null;
		try{
			System.out.println("executing Loadrc...");
			
			List<String> hrefList=new ArrayList<String>();
			
			System.out.println("Requesting html string....");
			String htmlContent=null;
			if(positionURL==null){
				htmlContent=EHtmlUnit.httpUnitRequest(this.scURL+"/PersonalJobs/jobsList.aspx?SearchPost=ContetAll&Keywords=");
			}else{
				htmlContent=EHtmlUnit.httpUnitRequest(positionURL);
			}
			
			
			System.out.println("Got the HTML String,parsing....");
			doc=Jsoup.parse(htmlContent);
			
		}catch(Exception e){
			System.out.println("Exception Occured");
			this.rm.setCode(-1);
			this.rm.setMsg("Exception Occured when getting the html content.\n"+e.getStackTrace());
			return ;
		}
		
		Element JobListDiv;
		try{
			System.out.println("Parsing Completed.Finding the target....");
			Elements JobListParentDivs=doc.getElementsByClass("job_left");
			JobListDiv=(Element)JobListParentDivs.get(0).childNodes().get(3); //target reach
			System.out.println("Target Reached");
		}catch(Exception e){
			System.out.println("Exception Occured");
			this.rm.setCode(-2);
			this.rm.setMsg("Exception Occured when finding the target\nExcetion: ."+e.getStackTrace());
			return ;
		}
		
		int first = 1;
		int childnodesnum=JobListDiv.childNodeSize();
		
		for(Node tmp:JobListDiv.childNodes()){
			
			Element JobDiv;
			try{
				JobDiv=(Element)tmp;
			}catch(Exception e){
				continue;
			}
			
			if (first == 1){
				first = 0;
				continue;
			}
			String DivClass=JobDiv.attr("class");
			if(DivClass.indexOf("job_box3") !=-1 || DivClass.indexOf("pagination")!=-1){
				break;
			}
			
			Elements t=JobDiv.getElementsByTag("li");
			t=t.get(0).getElementsByTag("a");
			String hrefs=t.get(0).attr("href");
			hrefs=this.scURL + hrefs;
			getPositionDetail(hrefs);
			System.out.println("Got "+count+"!!!!!!!!!!!!!");
			count++;
		}
		
		Elements buttons=doc.getElementsByClass("page-bottom");
		Elements aTaginbutton=buttons.get(0).getElementsByTag("a");
		for(Element aTag:aTaginbutton){
			if(aTag.text().equals("下一页")){
				String nextPagehref=aTag.attr("href");
				Loadrc(this.scURL+nextPagehref);
			}
		}
		
	}
		
	
	
	
	
	public void getPositionDetail(String subURL) throws Exception{
		
		//Getting the Html content
		String htmlContent=null;
		try{
			htmlContent=EHtmlUnit.httpUnitRequest(subURL);
			
		}catch(Exception e){
			System.out.println("(positionDetail)Exception Occured");
			this.rm.setCode(-1);
			this.rm.setMsg("Exception Occured when getting the html content.\n"+e.getStackTrace());
			return ;
		}
		
		Document doc=null;
		Element JobDetailDiv;
		try{
			doc=Jsoup.parse(htmlContent);
			Elements JobDetailDivs=doc.getElementsByClass("wrap");
			JobDetailDiv=JobDetailDivs.get(2);
		}catch(Exception e){
			System.out.println("(positionDetail)Exception Occured");
			this.rm.setCode(-2);
			this.rm.setMsg("Exception Occured when finding the target\nExcetion: "+e.getStackTrace());
			return ;
		}
		
		String companyName=null;
		String companyIndustry=null;
		String companyNature=null;
		String companyScale=null;
		try{
			Elements allLi=JobDetailDiv.getElementsByTag("li");
			companyName=allLi.get(0).text();
			companyIndustry=allLi.get(5).text();
			companyNature=allLi.get(4).text();
			companyScale=allLi.get(3).text();
		}catch(Exception e){
			this.rm.setCode(-3);
			this.rm.setMsg("Exception Occured when getting the infomation\nExcetion: "+e.getStackTrace());
			return ;
		}
		
		String start_date = null;
		String end_date = null;
		String headcount = null;
		String profession = null;
		String degreelevel = null;
		String workcity = null;
		String salary = null;
		String fulltime = null;
		String heightbody = null;
		String workyears = null;
		String gender = null;
		String workages = null;
		String technicalpost = null;
		String language = null;
		String positionName = null;
		String detailrequirement = null;
		String issueTime = null;
		try{
			
			Elements JobDivs=doc.getElementsByClass("job_detailed");
			Elements PositionNameh1s=JobDivs.get(0).getElementsByTag("h1");
			positionName = PositionNameh1s.get(0).text();
			detailrequirement=JobDivs.get(0).text();
			int startpoint=detailrequirement.indexOf("职位描述");
			detailrequirement=detailrequirement.substring(startpoint+4);
			Elements PositionDetailLis=doc.getElementsByClass("infor_bg2");
			int choice=1;
			for(Element Li:PositionDetailLis){
				switch(choice){
					case 1:{
						System.out.println("enter case 1");
						start_date=Li.text();
						choice ++;
					}break;
					
					case 2:{
						System.out.println("enter case 2");
						degreelevel=Li.text();
						choice ++;
					}break;
					
					case 3:{
						System.out.println("enter case 3");
						workyears=Li.text();
						choice ++;
					}break;
					
					case 4:{
						System.out.println("enter case 4");
						end_date=Li.text();
						choice ++;
					}break;
					
					case 5:{
						System.out.println("enter case 5");
						workcity=Li.text();
						choice ++;
					}break;
					
					case 6:{
						System.out.println("enter case 6");
						gender=Li.text();
						choice ++;
					}break;
					
					case 7:{
						System.out.println("enter case 7");
						headcount=Li.text();
						choice ++;
					}break;
					
					case 8:{
						System.out.println("enter case 8");
						salary=Li.text();
						choice ++;
					}break;
					
					case 9:{
						System.out.println("enter case 9");
						workages=Li.text();
						choice ++;
					}break;
					
					case 10:{
						System.out.println("enter case 10");
						profession=Li.text();
						choice ++;
					}break;
					
					case 11:{
						System.out.println("enter case 11");
						fulltime=Li.text();
						choice ++;
					}break;
					
					case 12:{
						System.out.println("enter case 12");
						technicalpost=Li.text();
						choice ++;
					}break;
					case 13:{
						System.out.println("enter case 13");
						choice ++;
					}break;
					case 14:{
						System.out.println("enter case 14");
						heightbody=Li.text();
						choice ++;
					}break;
					
					case 15:{
						System.out.println("enter case 15");
						language=Li.text();
						choice ++;
					}break;
					
					default:{
						System.out.println("enter the default case..");
					}break;
					
				}
			}
			
		}catch(Exception e){
			this.rm.setCode(-4);
			this.rm.setMsg("Exception Occured when getting the position detail\nExcetion: "+e.getStackTrace());
			return ;
		}
		
		String CompanyDetailhref=null;
		String companyDetail = null;
		String companyWebsite = null;
		String contactperson = null;
		String tel=null;
		String companyAddress = null;
		String companyEmail = null;
		String companyZip = null;
		try{
			Elements hrefUL=doc.getElementsByClass("view_box1");
			Elements allATaginhrefUL=hrefUL.get(0).getElementsByTag("a");
			String Companyhref=allATaginhrefUL.get(0).attr("href");
			
			String Companyhtml=EHtmlUnit.httpUnitRequest(this.scURL+"/PersonalJobs/"+Companyhref);
			Document CompanyDoc=Jsoup.parse(Companyhtml);
			
			Elements CompanyDetailDivs=CompanyDoc.getElementsByClass("job_detailed");
			companyDetail=CompanyDetailDivs.get(0).text();
			
			Elements ComypanyContact_table=CompanyDoc.getElementsByTag("table");
			Elements CompanyContact_trs=ComypanyContact_table.get(0).getElementsByTag("tr");
			for(Element tr:CompanyContact_trs){
				String tdtitle=tr.getElementsByTag("td").get(0).text();
				if(tdtitle.indexOf("联系人")!=-1){
					contactperson=tr.getElementsByTag("td").get(1).text();
				}
				else if(tdtitle.indexOf("联系电话")!=-1){
					tel=tr.getElementsByTag("td").get(1).text();
				}
				else if(tdtitle.indexOf("电子邮箱")!=-1){
					companyEmail=tr.getElementsByTag("td").get(1).text();
				}
				else if(tdtitle.indexOf("单位网址")!=-1){
					companyWebsite=tr.getElementsByTag("td").get(1).text();
				}
				else if(tdtitle.indexOf("单位地址")!=-1){
					companyAddress=tr.getElementsByTag("td").get(1).text();
				}
				else if(tdtitle.indexOf("邮政编码")!=-1){
					companyZip=tr.getElementsByTag("td").get(1).text();
				}
			}
			
			
		}catch(Exception e){
			this.rm.setCode(-5);
			this.rm.setMsg("Exception Occured when getting the company detail\nExcetion: "+e.getStackTrace());
			return ;
		}
		
		HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
		
		position.setPositionName(positionName);  
		position.setHeadcount(headcount);   //招聘人数
		position.setDegreelevel(degreelevel);   //学位要求
		position.setSalary(salary);       //工资
		position.setWorkyears(workyears);     //工作经验
		position.setWorkcity(workcity);     //工作地点
		position.setFulltime(fulltime);      //全职
		position.setProfession(profession);   //专长
		position.setHeightbody(heightbody);   //身高
		position.setWorkages(workages);       //工作年龄
		//position.setCensus(census);       //户籍
		position.setGender(gender);			//性别
		position.setTechnicalpost(technicalpost);    //职称
		position.setLanguage(language);  	//语言
		position.setIssueTime(issueTime);    		//招聘起止时间
		position.setDetailrequirement(detailrequirement);	//要求详情
		position.setCompanyName(companyName);			//公司名称
		position.setCompanyNature(companyNature);		//公司性质
		position.setCompanyScale(companyScale);			//公司规模
		position.setCompanyIndustry(companyIndustry);	//公司行业
		position.setCompanyDetail(companyDetail);		//公司详情
		position.setTel(tel);								//电话
		position.setContactperson(contactperson);			//联系人
		position.setCompanyEmail(companyEmail);				//公司邮箱
		position.setCompanyWebsite(companyWebsite);			//公司网站
		position.setCompanyAddress(companyAddress);			//公司地址

		position.setHrSource("四川人才网");
		position.setHrPositionUrl(subURL);
		
		// to database.
		//HrPositionService hrPositionService = new ;
		ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
		JSONObject obj = JSONObject.fromObject(rm);
		System.out.println(obj.toString());
		
		
		
	}
	
	
	
	public static void main(String [] argv) throws Exception{
		ScrcServiceImpl scrcServiceImpl=new ScrcServiceImpl();
		scrcServiceImpl.Loadrc(null);
	}
}
