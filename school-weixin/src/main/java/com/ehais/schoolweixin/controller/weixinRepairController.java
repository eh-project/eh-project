/**
 * 
 */
package com.ehais.schoolweixin.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.ehais.common.Constants;
import org.ehais.tools.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ehais.schoolweixin.model.wxRepair;
import com.ehais.schoolweixin.service.userRepairService;

 
/**
 * @author stephen
 *
 */
@Controller 
@RequestMapping("/Repair")
public class weixinRepairController {
	private static Logger log = LoggerFactory.getLogger(weixinRepairController.class);
	@Autowired
	private userRepairService urs;
	
	@RequestMapping("/MainPage")
	public String repairMainPage(){
		return "repair/repairInput";
	}
	
	@RequestMapping("/Submit")
	public String repairSubmit(HttpServletRequest request,@RequestParam("user_sendPicture")MultipartFile file,ModelMap modelmap) throws Exception{
		String userAddress=request.getParameter("user_address");
		String userContact=request.getParameter("user_contact");
		String submitDateStr=request.getParameter("user_date");
		String userDetail=request.getParameter("user_detail");
		String userPictureName=file.getOriginalFilename();
		ReturnObject<?> rm = fileHandler(userPictureName, file);
		System.out.println(rm.getMsg());
		String userClass=null;
		userClass=request.getParameter("user_class");
		DateFormat formateDate=new SimpleDateFormat("yyyy-MM-dd");
		Date submitDate=formateDate.parse(submitDateStr);
		HttpSession websiteSession=request.getSession();
		String userId=(String)websiteSession.getAttribute(Constants.SESSION_OPEN_ID);
		log.info("userId===>"+userId);
		wxRepair urmodel=new wxRepair();
		urmodel.setDetail(userDetail);
		urmodel.setImageName(userPictureName);
		urmodel.setRepairClass(userClass);
		//urmodel.setSubmitDate(submitDate);
		urmodel.setUserAddress(userAddress);
		urmodel.setUserContact(userContact);
		urmodel.setSubmitDate(submitDate);
		urmodel.setUserWxid(userId);
		rm=urs.saveRepairList(urmodel);
		log.info("returnMsg==>"+rm.getMsg());
		modelmap.addAttribute("Info", rm.getMsg());
		if(rm.getCode()==1){
			modelmap.addAttribute("imgLocation","../../../img/sign-check-icon.png");
		}
		else{
			modelmap.addAttribute("imgLocation","../../../img/wrong.png");
		}
		return "/repair/orderSucceed";
	}
	
	private ReturnObject<?> fileHandler(String fileName,MultipartFile file) throws Exception{
		ReturnObject<?> rm=new ReturnObject<>();
		rm.setCode(0);
		if(!file.isEmpty()){
			try{
				byte[] filebyte=file.getBytes();
				//create file directory
				String rootPath="/Users/stephen/Documents/HaiSoftware/fileUploadFolder";
				File dir=new File(rootPath + File.separator+"tmpFile");
				if(!dir.exists())dir.mkdirs();
				//create file
				File savefile=new File(dir.getAbsolutePath()+File.separator+fileName);
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(savefile));
				bos.write(filebyte);
				bos.close();
				rm.setCode(1);
				rm.setMsg("File upload successed!");
			}catch(Exception e){
				e.printStackTrace();
				rm.setCode(-1);
				rm.setMsg("file upload failed");
			}
		}
		return rm;
	}
	
	@RequestMapping("/summaryMainPage")
	public String summaryMainPage(){
		return "/repair/repairList";
	}
	
	@RequestMapping("/querySummary")
	@ResponseBody
	public List<wxRepair> querySummary(HttpServletRequest request){
		List<wxRepair> returnList=new ArrayList<wxRepair>();
		HttpSession session=request.getSession();
		//long wxid=(long)session.getAttribute(Constants.SESSION_USER_ID);
		long wxid=10;
		returnList=urs.getRepairList(String.valueOf(wxid)).getRows();
		return returnList;
	}
	
	@RequestMapping("/getDetail/{id}")
	public String getDetail(ModelMap model,@PathVariable("id") String id){
		
		return "";
	}
}
