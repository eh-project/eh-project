package com.ehais.figoarticle.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsAttrExample;

public interface HaiGoodsAttrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    long countByExample(HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int deleteByExample(HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int deleteByPrimaryKey(Integer goodsAttrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int insert(HaiGoodsAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int insertSelective(HaiGoodsAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    List<HaiGoodsAttr> selectByExampleWithBLOBs(HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    List<HaiGoodsAttr> selectByExample(HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    HaiGoodsAttr selectByPrimaryKey(Integer goodsAttrId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByExampleSelective(@Param("record") HaiGoodsAttr record, @Param("example") HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") HaiGoodsAttr record, @Param("example") HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByExample(@Param("record") HaiGoodsAttr record, @Param("example") HaiGoodsAttrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByPrimaryKeySelective(HaiGoodsAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(HaiGoodsAttr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods_attr
     *
     * @mbg.generated Sun Apr 16 21:31:22 CST 2017
     */
    int updateByPrimaryKey(HaiGoodsAttr record);
}