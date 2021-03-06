package org.ehais.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ehais.common.Constants;
import org.ehais.model.BootStrapModel;
import org.ehais.model.EHaiArticle;
import org.ehais.model.EHaiArticleCat;
import org.ehais.model.EHaiArticleCatExample;
import org.ehais.model.EHaiArticleExample;
import org.ehais.service.EArticleService;
import org.ehais.tools.CriteriaObject;
import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Service;

//model里面对应的日期添加的 @DateTimeFormat( pattern = "yyyy-MM-dd" )


@Service("eArticleService")
public class EArticleServiceImpl  extends EArticleCommonServiceImpl implements EArticleService{
	
	
	
	public ReturnObject<EHaiArticle> article_list(HttpServletRequest request) throws Exception{
		
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		
		rm.setCode(1);
		return rm;
	}
	
	public ReturnObject<EHaiArticle> article_list(HttpServletRequest request,Integer store_id,Integer cat_id,
			Integer page, Integer len) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> ro = new ReturnObject<EHaiArticle>();
		if(page <= 0) page = 1;
		Integer start = (page - 1 ) * len;
		List<EHaiArticle> list = eHaiArticleMapper.article_list(store_id , cat_id , start, len);
		EHaiArticleExample example = new EHaiArticleExample();
		EHaiArticleExample.Criteria c = example.createCriteria();
//		c.andStoreIdEqualTo(store_id);
		example.CriteriaStoreId(c, this.storeIdCriteriaObject(request));
		
		Integer total = eHaiArticleMapper.countByExample(example);
		ro.setCode(1);
		ro.setRows(list);
		ro.setTotal(total);
		
		Map<String, Object> map = new HashMap<String, Object>();
		EHaiArticleCatExample exampleCat = new EHaiArticleCatExample();
		EHaiArticleCatExample.Criteria cCat = exampleCat.createCriteria();
		cCat.andStoreIdEqualTo(store_id);
		List<EHaiArticleCat> cat_list = eHaiArticleCatMapper.selectByExample(exampleCat);
		map.put("cat_list", cat_list);
		
		ro.setMap(map);		
		return ro;
	}

	public ReturnObject<EHaiArticle> article_list_json(HttpServletRequest request,Integer store_id,boolean isCode,
			Integer page, Integer len) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		if(store_id == null) store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		Integer start = (page - 1 ) * len;
		
		EHaiArticleExample example = new EHaiArticleExample();
		CriteriaObject co = this.storeIdCriteriaObject(request);
//		example.CriteriaStoreId(c, this.storeIdCriteriaObject(request));
		example.setStart(start);
		example.setLen(len);
		if(isCode){//请求常量资讯
			EHaiArticleExample.Criteria c1 = example.or();
			c1.andCodeIsNotNull();
			c1.andCodeNotEqualTo("");
			c1.andCatIdIsNull();
			example.CriteriaStoreId(c1, co);
			
			EHaiArticleExample.Criteria c2 = example.or();
			c2.andCodeIsNotNull();
			c2.andCodeNotEqualTo("");
			c2.andCatIdEqualTo(0);
			example.CriteriaStoreId(c2, co);
			
		}else{
			
			EHaiArticleExample.Criteria c1 = example.or();
			c1.andCatIdIsNotNull();
			c1.andCatIdNotEqualTo(0);
			c1.andCodeIsNull();
			example.CriteriaStoreId(c1, co);
			
			EHaiArticleExample.Criteria c2 = example.or();
			c1.andCatIdIsNotNull();
			c1.andCatIdNotEqualTo(0);
			c2.andCodeEqualTo("");
			example.CriteriaStoreId(c2, co);
			
		}
		List<EHaiArticle> list = eHaiArticleMapper.hai_article_list_by_example(example);
		Integer total = eHaiArticleMapper.countByExample(example);
		
		

		
		Map<String, Object> map = new HashMap<String, Object>();
		EHaiArticleCatExample exampleCat = new EHaiArticleCatExample();
		EHaiArticleCatExample.Criteria cCat = exampleCat.createCriteria();
		cCat.andStoreIdEqualTo(store_id);
		List<EHaiArticleCat> cat_list = eHaiArticleCatMapper.selectByExample(exampleCat);
		map.put("cat_list", cat_list);
		
		rm.setMap(map);		
		
		rm.setCode(1);
		rm.setRows(list);
		rm.setTotal(total);
		return rm;
		
		
	}

	public ReturnObject<EHaiArticle> article_insert(HttpServletRequest request,Integer isCode)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();	
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiArticle model = new EHaiArticle();
		rm.setBootStrapList(this.formatBootStrapList(request,model,isCode));
		rm.setCode(1);
		return rm;
	}
	
	public ReturnObject<EHaiArticle> article_insert_submit(HttpServletRequest request,EHaiArticle model)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();

		if(model.getTitle() == null || model.getTitle().equals("")){
			rm.setMsg("必填项不能为空");
			return rm;
		}


		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		model.setStoreId(store_id);

		EHaiArticleExample example = new EHaiArticleExample();
		EHaiArticleExample.Criteria c = example.createCriteria();
		c.andTitleEqualTo(model.getTitle());
		c.andStoreIdEqualTo(store_id);
		int count = eHaiArticleMapper.countByExample(example);
		if(count > 0){
			rm.setMsg("存在相同的记录");
			return rm;
		}


		int code = eHaiArticleMapper.insertSelective(model);
		rm.setCode(code);
		rm.setMsg("添加成功");
		return rm;
	}

	public ReturnObject<EHaiArticle> article_update(HttpServletRequest request,Integer articleId,Integer isCode)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiArticle model = eHaiArticleMapper.selectByPrimaryKey(articleId);
		rm.setBootStrapList(this.formatBootStrapList(request,model,isCode));
		
		rm.setCode(1);
		rm.setModel(model);
		return rm;
	}
	
	public ReturnObject<EHaiArticle> article_update_submit(HttpServletRequest request,EHaiArticle model)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiArticleExample example = new EHaiArticleExample();
		EHaiArticleExample.Criteria c = example.createCriteria();
		
		example.CriteriaStoreId(c, this.storeIdCriteriaObject(request));
		c.andArticleIdEqualTo(model.getArticleId());
		c.andStoreIdEqualTo(store_id);

		int count = eHaiArticleMapper.countByExample(example);
		if(count == 0){
			rm.setMsg("记录不存在");
			return rm;
		}

		int code = eHaiArticleMapper.updateByExampleSelective(model, example);
		rm.setCode(code);
		rm.setMsg("编辑成功");
		return rm;
	}

	public ReturnObject<EHaiArticle> article_find(HttpServletRequest request,Integer articleId,Integer isCode)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		
		EHaiArticle model = eHaiArticleMapper.selectByPrimaryKey(articleId);
		rm.setBootStrapList(this.formatBootStrapList(request,model,isCode));
		
		rm.setCode(1);
		rm.setModel(model);
		return rm;
	}

	public ReturnObject<EHaiArticle> article_delete(HttpServletRequest request,Integer articleId)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiArticleExample example = new EHaiArticleExample();
		EHaiArticleExample.Criteria c = example.createCriteria();
		example.CriteriaStoreId(c, this.storeIdCriteriaObject(request));
		c.andArticleIdEqualTo(articleId);
		int code = eHaiArticleMapper.deleteByExample(example);
		rm.setCode(code);
		rm.setMsg("删除成功");
		return rm;
	}
	
	private List<BootStrapModel> formatBootStrapList(HttpServletRequest request,EHaiArticle model,Integer isCode) throws Exception{
		
		Map<String,Object> optionMap = new HashMap<String, Object>();
		optionMap.put("categoryTree", this.eTreeArticleCat(request));
		List<BootStrapModel> bootStrapList = this.BootStrapXml(request, "article.xml",model,"hai_article",optionMap);
		bootStrapList.add(new BootStrapModel("hidden", "isCode", "", isCode, "请输入", "", "", null, 0));
		
//		
//		List<BootStrapModel> bootStrapList = new ArrayList<BootStrapModel>();
//		
//
//		bootStrapList.add(new BootStrapModel("hidden", "articleId", "", model.getArticleId(), "请输入", "", "", null, 0));
//		bootStrapList.add(new BootStrapModel("text", "title", "标题", model.getTitle(), "请输入标题", "", "", null, 0));
//		if(isCode == 1)bootStrapList.add(new BootStrapModel("text", "code", "编码", model.getCode(), "用于识别文章唯一的编码", "", "", null, 0));
//		if(isCode == 0)bootStrapList.add(new BootStrapModel("select_tree", "catId", "分类", model.getCatId(), "请输入", "", "", null,eTreeArticleCat(request), 0));
//		bootStrapList.add(new BootStrapModel("text", "description", "摘要", model.getDescription(), "请输入摘要", "", "", null, 0));
//		bootStrapList.add(new BootStrapModel("textarea", "content", "内容", model.getContent(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("text", "author", "", model.getAuthor(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("text", "authorEmail", "", model.getAuthorEmail(), "请输入", "", "", null, 0));
//		bootStrapList.add(new BootStrapModel("text", "keywords", "关键字", model.getKeywords(), "请输入关键字", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "articleType", "", model.getArticleType(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "isOpen", "", model.getIsOpen(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "addTime", "", model.getAddTime(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("text", "fileUrl", "", model.getFileUrl(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "openType", "", model.getOpenType(), "请输入", "", "", null, 0));
//		bootStrapList.add(new BootStrapModel("text", "link", "链接", model.getLink(), "请输入链接", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "storeId", "", model.getStoreId(), "请输入", "", "", null, 0));
//		bootStrapList.add(new BootStrapModel("images", "articleImages", "图片", model.getArticleImages(), "图片尺寸200*200", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("text", "videoUrl", "", model.getVideoUrl(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "goodsId", "", model.getGoodsId(), "请输入", "", "", null, 0));
////		bootStrapList.add(new BootStrapModel("checkbox", "chaId", "", model.getChaId(), "请输入", "", "", null, 0));
//
//		
//		
		return bootStrapList;
	}
	
	
	public EHaiArticleCat article_cat(HttpServletRequest request,Integer key) throws Exception {
		// TODO Auto-generated method stub
		return eHaiArticleCatMapper.selectByPrimaryKey(key);
	}

	public EHaiArticle article(HttpServletRequest request,Integer key) throws Exception {
		// TODO Auto-generated method stub
		return eHaiArticleMapper.selectByPrimaryKey(key);
	}
	
	public EHaiArticle article_code(HttpServletRequest request,Integer store_id,String code) throws Exception {
		// TODO Auto-generated method stub
		return eHaiArticleMapper.article_code(store_id,code);
	}

	public ReturnObject<EHaiArticle> article_code_list(HttpServletRequest request,Integer store_id,
			Integer page, Integer len) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> ro = new ReturnObject<EHaiArticle>();
		Integer start = (page - 1 ) * len;
		List<EHaiArticle> list = eHaiArticleMapper.article_code_list(store_id , start, len);
		
		EHaiArticleExample example = new EHaiArticleExample();
		EHaiArticleExample.Criteria c = example.createCriteria();
		c.andStoreIdEqualTo(store_id);
		c.andCodeIsNotNull();
		Integer total = eHaiArticleMapper.countByExample(example);
		ro.setCode(1);
		ro.setRows(list);
		ro.setTotal(total);
		
			
		return ro;
	}
	
	
	
	

	public ReturnObject<EHaiArticle> article_insert_v2(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> rm = new ReturnObject<EHaiArticle>();	
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_WX_ID);
		EHaiArticle model = new EHaiArticle();
		rm.setBootStrapList(this.formatBootStrapList(request,model,1));
		rm.setCode(1);
		return rm;
	}

	public ReturnObject<EHaiArticle> article_update_v2(
			HttpServletRequest request, Integer key) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> ro = new ReturnObject<EHaiArticle>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_WX_ID);
		Map<String, Object> map = new HashMap<String, Object>();
		EHaiArticleCatExample exampleCat = new EHaiArticleCatExample();
		EHaiArticleCatExample.Criteria cCat = exampleCat.createCriteria();
		cCat.andStoreIdEqualTo(store_id);
		List<EHaiArticleCat> cat_list = eHaiArticleCatMapper.selectByExample(exampleCat);
		map.put("cat_list", cat_list);
		
		ro.setMap(map);	
		
		EHaiArticle model = eHaiArticleMapper.selectByPrimaryKey(key);
		ro.setBootStrapList(this.formatBootStrapList(request,model,0));
		ro.setCode(1);
		return ro;
	}

	public ReturnObject<EHaiArticle> article_list_by_catcode(HttpServletRequest request,Integer store_id,
			String code, Integer page, Integer len) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiArticle> ro = new ReturnObject<EHaiArticle>();
		Integer start = (page - 1 ) * len;
		List<EHaiArticle> list = eHaiArticleMapper.article_list_by_catcode(store_id , code , start, len);
		
		
		ro.setCode(1);
		ro.setRows(list);
		
			
		return ro;
	}

	
	
}











