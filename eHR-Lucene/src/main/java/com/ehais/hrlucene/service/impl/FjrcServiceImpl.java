package com.ehais.hrlucene.service.impl;

import com.ehais.hrlucene.service.FjrcService;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import org.apache.xmlbeans.impl.jam.JSourcePosition;
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
import net.sf.json.JSONObject;
import com.ehais.hrlucene.service.impl.HrPositionServiceImpl;
import com.ehais.hrlucene.service.HrPositionService;

@Service("FjrcService")
public class FjrcServiceImpl implements FjrcService {
	
	private String URL_str="http://www.hxrc.com";
	//private HaiHrPosition haiHrPostion;
	
	@Autowired
	private HrPositionService hrPositionService;
	 
	

	public void LoadFjrc() throws Exception {
		// TODO Auto-generated method stub
		
		List<String> hrefLists = new ArrayList<String>();
		
		//getting html content
		String htmlContent = EHtmlUnit.httpUnitRequest(this.URL_str+"/JobListByJobClass.htm");
		//Parsing html
		Document rootdoc=Jsoup.parse(htmlContent,"utf-8");
		
		//find the Require list
		Elements SortLists=rootdoc.getElementsByClass("jobsort-3");
		for(Element SortList:SortLists){
			Elements SubLists=SortList.getElementsByClass("li-4");
			
			//find the correspond jobsort-3 and get All <a>
			if (SubLists.size()==0){
				System.out.println("SubList is null.Ignored.");
				continue;
			}
			else{
				for(Element SubList:SubLists){
					Elements aTags=SubList.getElementsByTag("a");
					if(aTags.size()!=0){
						for(Element a:aTags){
							String href=a.attr("href");
							hrefLists.add(this.URL_str+"/"+href);
						}
						this.grepEachPosition(hrefLists);
					}
				}
			}
			
		}
		System.out.println("All data has Scraped and transfered to the database,Program Closing!");
	}
	
	public void grepEachPosition(List<String> hrefLists) throws Exception{
		for(String hrefList:hrefLists){
			
			//just like above
			String htmlContent = EHtmlUnit.httpUnitRequest(hrefList);
			Document doc=Jsoup.parse(htmlContent,"utf-8");
			
			Element PageNumdiv=doc.getElementById("AspNetPager1");
			int PageNum=1;
			if(PageNumdiv!=null){
				Elements PageNumSubdiv=PageNumdiv.getElementsByTag("div");
				Element Subdiv=PageNumSubdiv.get(0);
				Elements aTags=Subdiv.getElementsByTag("a");
				PageNum=-1;
				int TmpNum = -1;
				for (Element a:aTags){
					try{
						 TmpNum=Integer.parseInt(a.text());
					}catch (NumberFormatException e){
						System.out.println("Is not a integer String.Ignore");
						continue;
					}
					if(TmpNum>PageNum){
						PageNum=TmpNum;
					}
				}
			}
			
			for(int i=1;i<=PageNum;i++){
				if (i!=1){
					//httpRequest postRequest=new httpRequest();
					//String PageResult=postRequest.sendPost(hrefList, "__EVENTTARGET=AspNetPager1&__EVENTARGUMENT="+i);
					String PageResult=EHtmlUnit.changePage(hrefList, String.valueOf(i));
					doc=Jsoup.parse(PageResult,"utf-8");
				}
				Elements Table=doc.getElementsByClass("mygrid");
				Elements Alltr=null;
				try{
					Alltr=Table.get(0).getElementsByTag("tr");
				}catch(Exception e){
					System.out.println("There is no jobs in this Sort...Ignore");
					continue;
				}
				
				int first=1;
				String positionName = "-1";
				for(Element tr:Alltr){
					if(first == 1){
						first=0;
						continue;
					}
					Elements Alltd=tr.getElementsByTag("td");
					 positionName= Alltd.get(0).getElementsByTag("a").get(0).text();
					positionName.replace(" ", "");
					String nextUrl=Alltd.get(0).getElementsByTag("a").get(0).attr("href");
					String companyName=Alltd.get(1).text();
					String salary=Alltd.get(2).getElementsByTag("span").get(0).text();
					String workcity=Alltd.get(3).getElementsByTag("span").get(0).text();
					String issueTimestart=Alltd.get(4).getElementsByTag("span").get(0).text();
					ArrayList<String> infoList=new ArrayList<String>();
					infoList.add(companyName);
					infoList.add(salary);
					infoList.add(workcity);
					infoList.add(issueTimestart);
					infoList.add(positionName);
					System.out.println("Getting the Position Detail.");
					this.GettingDetail(nextUrl,infoList);
				}
				System.out.println("page "+String.valueOf(i)+" completed.");
			}
//			Elements Table=doc.getElementsByClass("mygrid");
//			Elements Alltr=Table.get(0).getElementsByTag("tr");
//			int first=1;
//			for(Element tr:Alltr){
//				if(first == 1){
//					first=0;
//					continue;
//				}
//				Elements Alltd=tr.getElementsByTag("td");
//				String positionName = Alltd.get(0).getElementsByTag("a").get(0).text();
//				positionName=positionName.replace(" ", "");
//				String nextUrl=Alltd.get(0).getElementsByTag("a").get(0).attr("href");
//				String companyName=Alltd.get(1).text();
//				String salary=Alltd.get(2).getElementsByTag("span").get(0).text();
//				String workcity=Alltd.get(3).getElementsByTag("span").get(0).text();
//				String issueTimestart=Alltd.get(4).getElementsByTag("span").get(0).text();
//				ArrayList<String> infoList=new ArrayList<String>();
//				infoList.add(companyName);
//				infoList.add(salary);
//				infoList.add(workcity);
//				infoList.add(issueTimestart);
//				infoList.add(positionName);
//				System.out.println("Getting the Position Detail.");
//				this.GettingDetail(nextUrl,infoList);
//			}
		}
		 
	}
	public void GettingDetail(String url,ArrayList<String> infoList) throws Exception{
		//getting website data.
		String htmlContent=EHttpClientUtil.methodGet(url);
		Document doc=Jsoup.parse(htmlContent);
		
		//Scraping information
		Elements bigdiv=doc.getElementsByClass("n7");
		Elements divsWithClassb7=bigdiv.get(0).getElementsByClass("b7");
		Elements Alluls=bigdiv.get(0).getElementsByTag("ul");
		String headcount=divsWithClassb7.get(1).text();
		headcount=headcount.replace("[招聘人数：", "");
		headcount=headcount.replace(" ", "");
		headcount=headcount.replace("]", "");
		
		Elements lisContainDetail=doc.getElementsByClass("b10");
		String fulltime=null;
		try{
			fulltime=lisContainDetail.get(0).getElementsByTag("p").get(1).text();
		}catch(Exception e){
		
		}
		fulltime=fulltime.replace("工作时间要求：", "");
		fulltime=fulltime.replace(" ", "");
		String degreelevel=lisContainDetail.get(0).getElementsByTag("p").get(2).text();
		degreelevel=degreelevel.replace("学历要求：", "");
		degreelevel=degreelevel.replace(" ", "");
		String gender=lisContainDetail.get(0).getElementsByTag("p").get(3).text();
		gender=gender.replace("性别要求：", "");
		gender=gender.replace(" ", "");
		String technicalpost=lisContainDetail.get(0).getElementsByTag("p").get(4).text();
		technicalpost=technicalpost.replace("职称要求：", "");
		technicalpost=technicalpost.replace(" ", "");
		String workages=lisContainDetail.get(0).getElementsByTag("p").get(5).text();
		workages=workages.replace("年龄要求：", "");
		workages=workages.replace(" ", "");
		String detailrequirement=lisContainDetail.get(1).getElementsByTag("p").get(0).text();
		detailrequirement=detailrequirement.replace("<br>", "\n");
		//String issusTimend=lisContainDetail.get(4).getElementsByTag("p").get(0).text();
		String b8_str=Alluls.get(3).getElementsByTag("li").get(0).text();
		String issusTimend="--";
		if(b8_str.equals("招聘期限:")){
			issusTimend=lisContainDetail.get(3).getElementsByTag("p").get(0).text();
		}
		else{
			issusTimend=lisContainDetail.get(4).getElementsByTag("p").get(0).text();
			detailrequirement=detailrequirement+"\n其他要求：\n"+lisContainDetail.get(2).getElementsByTag("p").get(0).text();
		}
		//int endnum=issusTimend.indexOf("<");
		//issusTimend=issusTimend.substring(endnum);
		String companyAddress="--";
		try{
			companyAddress=doc.getElementById("lbl_OrganAddress").text();
			companyAddress=companyAddress.replace("\n", "");
			companyAddress=companyAddress.replace("联系地址：", "");
		}catch(Exception e){
			
		}
		
		//String tel="-1"
		String tel="--";
		try{
			tel=doc.getElementById("lbl_OrganMobile").text();
			tel=tel.replace("移动电话：", "");
			tel=tel.replace("\n", "");
			if(tel.equals("")){
				tel=doc.getElementById("lbl_OrganLinkPhone").text();
				tel=tel.replace("联系电话：", "");
				tel=tel.replace("\n", "");
			}
		}catch(Exception e){
			
		}
		
		String contactperson="--";
		try{
			contactperson=doc.getElementById("lbl_OrganLinkMan").text();
			contactperson=contactperson.replace("联 系 人：", "");
			contactperson=contactperson.replace("\n", "");
		}catch(Exception e){
			
		}
		
		String companyEmail="";
		try{
			Element tmp=doc.getElementById("lbl_OrganEmail");
			Elements tmp2=tmp.getElementsByTag("a");
			
			if(tmp2.size()>0){
				companyEmail=tmp2.get(0).text();
			}
		}catch(Exception e){
			
		}
		
		
		//String companyEmail=doc.getElementById("lbl_OrganEmail").getElementsByTag("a").get(0).text();
		String companyWebsite="--";
		try{
			companyAddress=doc.getElementById("lbl_OrganWebSite").text();
			companyWebsite=companyWebsite.replace("机构网址：", "");
			companyWebsite=companyWebsite.replace("\n", "");
		}catch(Exception e){
			
		}
		
		
		String companyName=infoList.get(0);
		String salary=infoList.get(1);
		String workcity=infoList.get(2);
		String issueTimestart=infoList.get(3);
		String positionName=infoList.get(4);
		String  issueTime=issueTimestart+" - "+issusTimend;
		
		HaiHrPositionWithBLOBs position = new HaiHrPositionWithBLOBs();
		
		position.setPositionName(positionName);  
		position.setHeadcount(headcount);   //招聘人数
		position.setDegreelevel(degreelevel);   //学位要求
		position.setSalary(salary);       //工资
		//position.setWorkyears(workyears);     //工作经验
		position.setWorkcity(workcity);     //工作地点
		position.setFulltime(fulltime);      //全职
		//position.setProfession(profession);   //专长
		//position.setHeightbody(heightbody);   //身高
		position.setWorkages(workages);       //工作年龄
		//position.setCensus(census);       //户籍
		position.setGender(gender);			//性别
		position.setTechnicalpost(technicalpost);    //职称
		//position.setLanguage(language);  	//语言
		position.setIssueTime(issueTime);    		//招聘起止时间
		position.setDetailrequirement(detailrequirement);	//要求详情
		position.setCompanyName(companyName);			//公司名称
		//position.setCompanyNature(companyNature);		//公司性质
		//position.setCompanyScale(companyScale);			//公司规模
		//position.setCompanyIndustry(companyIndustry);	//公司行业
		//position.setCompanyDetail(companyDetail);		//公司详情
		position.setTel(tel);								//电话
		position.setContactperson(contactperson);			//联系人
		position.setCompanyEmail(companyEmail);				//公司邮箱
		position.setCompanyWebsite(companyWebsite);			//公司网站
		position.setCompanyAddress(companyAddress);			//公司地址

		position.setHrSource("海峡人才网");
		position.setHrPositionUrl(url);
		
		// to database.
		//HrPositionService hrPositionService = new ;
		ReturnObject<HaiHrPosition> rm = hrPositionService.SaveHrPosition(position);
		JSONObject obj = JSONObject.fromObject(rm);
		System.out.println(obj.toString());
		
	}

	
//	public static void main(String [] argv) throws Exception{
//		FjrcServiceImpl fj=new FjrcServiceImpl();
//		fj.LoadFjrc();
//
//	}


}
