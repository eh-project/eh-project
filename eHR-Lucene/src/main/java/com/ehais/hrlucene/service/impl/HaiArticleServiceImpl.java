package com.ehais.hrlucene.service.impl;

import javax.enterprise.inject.New;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiArticleMapper;
import com.ehais.hrlucene.model.HaiArticle;
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
		long CountLink=haiArticleMapper.countByExample(haiArticleExample);
		if(CountLink == 0){
			haiArticleMapper.insertSelective(haiArticle);
		}else{
			haiArticleMapper.updateByExampleSelective(haiArticle, haiArticleExample);
		}
		rm.setCode(0);
		rm.setMsg("保存成功");
		return rm;
	}
}
