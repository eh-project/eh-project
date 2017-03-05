package com.ehais.reptile;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.ehais.tools.ReturnObject;

import com.ehais.bean.Goods;
import com.ehais.http.HttpGoods;
import com.ehais.reptile.impl.MytheresaImpl;
import com.ehais.reptile.impl.ShopBopImpl;

public class ReptileThread extends Thread {

	private ShopBopImpl shopbop; 
	private MytheresaImpl mytheresa;
	private String url;
	private Integer type;
	private ReturnObject<Object> rm;
	private Text text_result;
	private Goods goods;
	private HttpGoods httpGoods;
	private String result;
	private Display display;
	
	public ReptileThread(Display display,Text text_result) {
		// TODO Auto-generated constructor stub
		shopbop = new ShopBopImpl();
		mytheresa = new MytheresaImpl();
		url = "";
		type = 0;
		rm = new ReturnObject<Object>();
		httpGoods = new HttpGoods();
		this.text_result = text_result; 
		this.display = display;
	}

	public void setUrl(String url){
		this.url = url;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public void run(){
		try{

			if(Thread.currentThread().getName().equals("shopbop")){
				if(type == 0){
					rm = shopbop.product_list(url);
				}else{
					rm = shopbop.product_info(url);
				}
			}else if(Thread.currentThread().getName().equals("mytheresa")){
				
			}
			
			if(rm!=null){
				if(type == 0){
					List<Object> list = rm.getRows();
					for (Object object : list) {
						Map<String,String> map = (Map<String, String>) object;
						text_result.setText(text_result.getText()+ "获取商品："+map.get("title")+"\r\n");
					}
				}else{
					goods = (Goods) rm.getModel();
					goods.setCategoryName("总分类");
					text_result.setText(text_result.getText()+ "名称："+goods.getGoodsName()+"\r\n");
					text_result.setText(text_result.getText()+ "价格："+goods.getPrice()+"\r\n");
					text_result.setText(text_result.getText()+ "品牌："+goods.getBrandName()+"\r\n");
					text_result.setText(text_result.getText()+ "颜色："+goods.getColorJson()+"\r\n");
					text_result.setText(text_result.getText()+ "尺寸："+goods.getSizeJson()+"\r\n");
					result = httpGoods.postGoods(goods);
					text_result.setText(text_result.getText()+ "提交结果："+result+"\r\n");
				}
			}
			
			display.asyncExec(this);
		}catch(Exception e){
			e.printStackTrace();
			//需要补充上传错误信息
			
			
			
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
