package com.ehais.hrlucene.service.impl;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.service.ScrcService;



/**
 * @author stephen
 *
 */
@Service("ScrcService")
public class ScrcServiceImpl implements ScrcService {
	private String scURL="http://www.scrc168.com/PersonalJobs/jobsList.aspx?SearchPost=ContetAll&Keywords=";
	//private String scURL="http://www.baidu.com";
	
	public ReturnObject Loadrc() throws Exception{
		ReturnObject rm = new ReturnObject();
		String htmlContent=EHtmlUnit.httpUnitRequest(this.scURL);
		Document doc=Jsoup.parse(htmlContent);
		Elements JobListParentDivs=doc.getElementsByClass("job_left");
		Elements JobListDivs=JobListParentDivs.get(0).getElementsByTag("div");
		System.out.println("asdf");
		
		
		
		return rm;
	}
	public static void main(String [] argv) throws Exception{
		ScrcServiceImpl scrcServiceImpl=new ScrcServiceImpl();
		ReturnObject rm = scrcServiceImpl.Loadrc();
	}
}
