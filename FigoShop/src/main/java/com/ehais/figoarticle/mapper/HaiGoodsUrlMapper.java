package com.ehais.figoarticle.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.ehais.figoarticle.model.HaiGoodsUrl;
import com.ehais.figoarticle.model.HaiGoodsUrlExample;
import com.ehais.figoarticle.model.WebSiteCount;

public interface HaiGoodsUrlMapper {
	
	@Select("select count(*) as count ,c.website_id from hai_goods_url g left join hai_category c on g.cat_id = c.cat_id GROUP BY c.website_id")
	@Results(value = {  
            @Result(id = true, property = "count", column = "count", javaType = Integer.class, jdbcType = JdbcType.INTEGER),  
            @Result(property = "websiteId", column = "website_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER) })
	public List<WebSiteCount> groupWebSite();
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    long countByExample(HaiGoodsUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int deleteByExample(HaiGoodsUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int deleteByPrimaryKey(Integer goodsUrlId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int insert(HaiGoodsUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int insertSelective(HaiGoodsUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    List<HaiGoodsUrl> selectByExample(HaiGoodsUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    HaiGoodsUrl selectByPrimaryKey(Integer goodsUrlId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int updateByExampleSelective(@Param("record") HaiGoodsUrl record, @Param("example") HaiGoodsUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int updateByExample(@Param("record") HaiGoodsUrl record, @Param("example") HaiGoodsUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int updateByPrimaryKeySelective(HaiGoodsUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_url
     *
     * @mbg.generated Sat Apr 15 20:05:57 CST 2017
     */
    int updateByPrimaryKey(HaiGoodsUrl record);
}