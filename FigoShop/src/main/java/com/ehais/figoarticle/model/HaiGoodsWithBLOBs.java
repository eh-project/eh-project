package com.ehais.figoarticle.model;

public class HaiGoodsWithBLOBs extends HaiGoods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods.goods_brief
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String goodsBrief;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hai_goods.goods_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    private String goodsDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods.goods_brief
     *
     * @return the value of hai_goods.goods_brief
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getGoodsBrief() {
        return goodsBrief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods.goods_brief
     *
     * @param goodsBrief the value for hai_goods.goods_brief
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hai_goods.goods_desc
     *
     * @return the value of hai_goods.goods_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hai_goods.goods_desc
     *
     * @param goodsDesc the value for hai_goods.goods_desc
     *
     * @mbg.generated Fri Apr 14 21:52:06 CST 2017
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
}