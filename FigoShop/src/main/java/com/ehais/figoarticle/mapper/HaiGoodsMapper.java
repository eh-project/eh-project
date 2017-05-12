package com.ehais.figoarticle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ehais.figoarticle.model.HaiGoods;
import com.ehais.figoarticle.model.HaiGoodsExample;
import com.ehais.figoarticle.model.HaiGoodsWithBLOBs;

public interface HaiGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    long countByExample(HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int deleteByExample(HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int deleteByPrimaryKey(Long goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int insert(HaiGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int insertSelective(HaiGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    List<HaiGoodsWithBLOBs> selectByExampleWithBLOBs(HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    List<HaiGoods> selectByExample(HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    HaiGoodsWithBLOBs selectByPrimaryKey(Long goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByExampleSelective(@Param("record") HaiGoodsWithBLOBs record, @Param("example") HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") HaiGoodsWithBLOBs record, @Param("example") HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByExample(@Param("record") HaiGoods record, @Param("example") HaiGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByPrimaryKeySelective(HaiGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(HaiGoodsWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_goods
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    int updateByPrimaryKey(HaiGoods record);
}