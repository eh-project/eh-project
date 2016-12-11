package com.ehais.hrlucene.mapper;

import com.ehais.hrlucene.model.HaiArticleCat;
import com.ehais.hrlucene.model.HaiArticleCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HaiArticleCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    long countByExample(HaiArticleCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int deleteByExample(HaiArticleCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int deleteByPrimaryKey(Short cat_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int insert(HaiArticleCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int insertSelective(HaiArticleCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    List<HaiArticleCat> selectByExample(HaiArticleCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    HaiArticleCat selectByPrimaryKey(Short cat_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int updateByExampleSelective(@Param("record") HaiArticleCat record, @Param("example") HaiArticleCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int updateByExample(@Param("record") HaiArticleCat record, @Param("example") HaiArticleCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int updateByPrimaryKeySelective(HaiArticleCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_article_cat
     *
     * @mbg.generated Wed Dec 07 15:37:16 CST 2016
     */
    int updateByPrimaryKey(HaiArticleCat record);
}