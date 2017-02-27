package com.ehais.junit;

import java.util.HashMap;
import java.util.Map;

import org.ehais.util.EHttpClientUtil;
import org.ehais.util.SignUtil;
import org.ehais.util.httpPostAndGet;
import org.junit.Test;

import junit.framework.TestCase;

public class HrApiJunit{
	private String web_url = "http://localhost:8080/api/";
	private String timestamp = String.valueOf(System.currentTimeMillis());
	private String appkey = "swetXsdfWEertr";
	private String secret = "SDfs1224WEdsdf";

	
	@Test
	public void position(){
		try{
			Map<String, String> paramsMap = new HashMap<String, String>();
			paramsMap.put("appkey", appkey);
	    	paramsMap.put("version", "v1.0");
	    	paramsMap.put("timestamp", timestamp);
	    	
	    	paramsMap.put("page", "1");
	    	paramsMap.put("len", "10");
	    	paramsMap.put("store_id", "1");
	    	
	    	String sign = SignUtil.getSignWS(paramsMap,secret);
	    	paramsMap.put("sign", sign);
			String req = EHttpClientUtil.httpPost(web_url+"/position", paramsMap);
			
			System.out.println("请求返回："+req);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void verifycode(){
		try{
			Map<String, String> paramsMap = new HashMap<String, String>();
			paramsMap.put("appkey", appkey);
	    	paramsMap.put("version", "v1.0");
	    	paramsMap.put("timestamp", timestamp);
	    	
	    	paramsMap.put("page", "1");
	    	paramsMap.put("len", "10");
	    	paramsMap.put("store_id", "1");
	    	
	    	String sign = SignUtil.getSignWS(paramsMap,secret);
	    	paramsMap.put("sign", sign);
	    	httpPostAndGet hpg=new httpPostAndGet();
			
			
			System.out.println("请求返回：");
			hpg.sendGet(web_url+"/getVerifyCode");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
