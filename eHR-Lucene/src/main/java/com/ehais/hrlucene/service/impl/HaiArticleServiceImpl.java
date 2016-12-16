package com.ehais.hrlucene.service.impl;

import java.util.List;

import javax.enterprise.inject.New;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiArticleCatMapper;
import com.ehais.hrlucene.mapper.HaiArticleMapper;
import com.ehais.hrlucene.model.HaiArticle;
import com.ehais.hrlucene.model.HaiArticleCat;
import com.ehais.hrlucene.model.HaiArticleCatExample;
import com.ehais.hrlucene.model.HaiArticleExample;
import com.ehais.hrlucene.service.HaiArticleService;



/**
 * @author stephen
 *
 */
@Service("HaiArticleService")
public class HaiArticleServiceImpl implements HaiArticleService {
	@Autowired
	private HaiArticleMapper haiArticleMapper;
	@Autowired
	private HaiArticleCatMapper haiArticleCatMapper;
	
	/* (non-Javadoc)
	 * @see com.ehais.hrlucene.service.impl.HaiArticleService#Save_Article(com.ehais.hrlucene.model.HaiArticle)
	 */
	public ReturnObject<HaiArticle> Save_Article(HaiArticle haiArticle) throws Exception{
		ReturnObject<HaiArticle> rm =new ReturnObject<HaiArticle>();
		
		if(haiArticle.getTitle().equals("")||haiArticle.getTitle()==null){
			rm.setCode(-1);
			rm.setMsg("标题不能为空");
			return rm;
		}
		if(haiArticle.getContent().equals("")||haiArticle.getContent()==null){
			rm.setCode(-2);
			rm.setMsg("内容不能为空");
			return rm;
		}
		if(haiArticle.getLink().equals("")||haiArticle.getLink()==null){
			rm.setCode(-3);
			rm.setMsg("文章链接不能为空");
			return rm;
		}
		
		HaiArticleExample haiArticleExample=new HaiArticleExample();
		haiArticleExample.createCriteria().andLinkEqualTo(haiArticle.getLink());
		try{
			long CountLink=haiArticleMapper.countByExample(haiArticleExample);
			if(CountLink == 0){
				haiArticleMapper.insertSelective(haiArticle);
			}else{
				haiArticleMapper.updateByExampleSelective(haiArticle, haiArticleExample);
			}
		}catch (Exception e) {
			// TODO: handle exception
			rm.setCode(-4);
			rm.setMsg("数据库操作失败。。");
			return rm;
		}
		rm.setCode(0);
		rm.setMsg("保存成功");
		return rm;
	}
	
	public ReturnObject<HaiArticleCat> save_cat(HaiArticleCat haiArticleCat){
		ReturnObject<HaiArticleCat> rm = new ReturnObject<HaiArticleCat>();
		
		if(haiArticleCat.getCat_name().equals("")||haiArticleCat.getCat_name()==null){
			rm.setMsg("分类名字不能为空");
			rm.setCode(-1);
			return rm;
		}
		
		HaiArticleCatExample haiArticleCatExample = new HaiArticleCatExample();
		haiArticleCatExample.createCriteria().andCat_nameEqualTo(haiArticleCat.getCat_name());
		try{
			long countCate=haiArticleCatMapper.countByExample(haiArticleCatExample);
			if(countCate == 0){
				haiArticleCatMapper.insertSelective(haiArticleCat);
			}
			else{
				haiArticleCatMapper.updateByExampleSelective(haiArticleCat, haiArticleCatExample);
			}
			List<HaiArticleCat> tmpList=haiArticleCatMapper.selectByExample(haiArticleCatExample);
			rm.setRows(tmpList);
		}catch (Exception e) {
			// TODO: handle exception
			rm.setCode(-2);
			rm.setMsg("数据库操作失败。。");
			return rm;
		}
		
		rm.setCode(0);
		rm.setMsg("保存成功");
		return rm;
	}
}
