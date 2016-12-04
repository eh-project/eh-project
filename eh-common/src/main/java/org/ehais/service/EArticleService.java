package org.ehais.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.model.EHaiArticle;
import org.ehais.model.EHaiArticleCat;
import org.ehais.tools.ReturnObject;



public interface EArticleService extends CommonService{
	public ReturnObject<EHaiArticle> article_list(HttpServletRequest request,Integer store_id,Integer cat_id,Integer page,Integer len) throws Exception;
	public ReturnObject<EHaiArticle> article_list(HttpServletRequest request) throws Exception;
	public ReturnObject<EHaiArticle> article_list_json(HttpServletRequest request,Integer store_id,boolean isCode,Integer page,Integer len) throws Exception;
	public ReturnObject<EHaiArticle> article_insert(HttpServletRequest request,Integer isCode) throws Exception;
	public ReturnObject<EHaiArticle> article_insert_submit(HttpServletRequest request,EHaiArticle model) throws Exception;
	public ReturnObject<EHaiArticle> article_update(HttpServletRequest request,Integer articleId,Integer isCode) throws Exception;
	public ReturnObject<EHaiArticle> article_update_submit(HttpServletRequest request,EHaiArticle model) throws Exception;
	public ReturnObject<EHaiArticle> article_find(HttpServletRequest request,Integer articleId,Integer isCode) throws Exception;
	public ReturnObject<EHaiArticle> article_delete(HttpServletRequest request,Integer articleId) throws Exception;
	
	
	public EHaiArticleCat article_cat(HttpServletRequest request,Integer key) throws Exception;
	public EHaiArticle article(HttpServletRequest request,Integer key) throws Exception;
	public EHaiArticle article_code(HttpServletRequest request,Integer store_id,String code) throws Exception;
	
	public ReturnObject<EHaiArticle> article_code_list(HttpServletRequest request,Integer store_id,Integer page,Integer len) throws Exception;
	
	public ReturnObject<EHaiArticle> article_list_by_catcode(HttpServletRequest request,Integer store_id,String code,Integer page,Integer len) throws Exception;
	
}

