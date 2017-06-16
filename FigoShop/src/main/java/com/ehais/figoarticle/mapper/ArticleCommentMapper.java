package com.ehais.figoarticle.mapper;

import com.ehais.figoarticle.model.ArticleComment;
import com.ehais.figoarticle.model.ArticleCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface ArticleCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    @Select("select count(*) from article_comment where #{field} = #{value} ")
    int unique(@Param("field") String field, @Param("value") String value);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    @Select("select count(*) from article_comment where #{field} = #{value} and store_id = #{store_id}")
    int uniqueStore(@Param("field") String field, @Param("value") String value, @Param("store_id") Integer store_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    long countByExample(ArticleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int deleteByExample(ArticleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int insert(ArticleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int insertSelective(ArticleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    List<ArticleComment> selectByExample(ArticleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    ArticleComment selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int updateByExampleSelective(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int updateByExample(@Param("record") ArticleComment record, @Param("example") ArticleCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int updateByPrimaryKeySelective(ArticleComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_comment
     *
     * @mbg.generated Sat Jun 10 10:48:39 CST 2017
     */
    int updateByPrimaryKey(ArticleComment record);
}