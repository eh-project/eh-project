package com.ehais.figoarticle.Service.Impl;

import com.ehais.figoarticle.mapper.HaiGoodsAttrMapper;
import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsAttrExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 5/27/17.
 * Service for
 */
@Service("GoodiesAttr")
public class GoodiesAttrImpl implements com.ehais.figoarticle.Service.GoodiesAttr {
    @Autowired
    private HaiGoodsAttrMapper haiGoodsAttrMapper;

    private List<CusHaigoodiesAttr> attrItemList = new ArrayList<>();

    class CusHaigoodiesAttr{
        public Long goodsId;

        public List<String> colors;

        public List<String> sizes;

        public CusHaigoodiesAttr(){
            colors = new ArrayList<>();
            sizes = new ArrayList<>();
        }
    }

    @Override
    public void  transfer(){
        HaiGoodsAttrExample goodattrexample=new HaiGoodsAttrExample();
        //HaiGoodsAttrExample.Criteria c=goodattrexample.createCriteria();
        goodattrexample.setOrderByClause("goods_id desc,attr_type asc");
        List<HaiGoodsAttr> haigoodsattrList=haiGoodsAttrMapper.selectByExampleWithBLOBs(goodattrexample);

        CusHaigoodiesAttr cha = new CusHaigoodiesAttr();
        cha.goodsId=haigoodsattrList.get(0).getGoodsId();
        for(HaiGoodsAttr goodItem:haigoodsattrList){
            if(cha.goodsId!=goodItem.getGoodsId()){
                this.attrItemList.add(cha);
                cha=null;
                cha=new CusHaigoodiesAttr();
                cha.goodsId=goodItem.getGoodsId();
            }
            switch (goodItem.getAttrType()){
                case "color":{
                    cha.colors.add(goodItem.getAttrValue());
                }break;

                case "size":{
                    cha.sizes.add(goodItem.getAttrValue());
                }break;

                default:{
                    System.out.println("unknow attr_type");
                }break;
            }
        }

    }
}
