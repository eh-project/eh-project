package com.ehais.hrlucene.service;

import org.ehais.tools.ReturnObject;

import com.ehais.hrlucene.model.HaiArticle;
import com.ehais.hrlucene.model.HaiArticleCat;


/**
 * @author stephen
 *
 */
public interface HaiArticleService {

	public ReturnObject<HaiArticle> Save_Article(HaiArticle haiArticle) throws Exception;
	public ReturnObject<HaiArticleCat> save_cat(HaiArticleCat haiArticleCat);
}