package com.ehais.figoarticle.Service.Impl;

import com.ehais.figoarticle.mapper.HaiGoodsAttrMapper;
import com.ehais.figoarticle.mapper.HaiGoodsMapper;
import com.ehais.figoarticle.model.*;
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
    @Autowired
    private HaiGoodsMapper haiGoodsMapper;

    private List<CusHaiGoodsAttr> attrItemList = new ArrayList<>();




    @Override
    public void  transfer(){
        HaiGoodsAttrExample goodattrexample=new HaiGoodsAttrExample();
        //HaiGoodsAttrExample.Criteria c=goodattrexample.createCriteria();
        goodattrexample.setOrderByClause("goods_id desc,attr_type asc");
        List<HaiGoodsAttr> haigoodsattrList=haiGoodsAttrMapper.selectByExampleWithBLOBs(goodattrexample);

        CusHaiGoodsAttr cha = new CusHaiGoodsAttr();
        cha.goodsId=haigoodsattrList.get(0).getGoodsId();
        for(HaiGoodsAttr goodItem:haigoodsattrList){
            if(cha.goodsId.equals(goodItem.getGoodsId())){
            }
            else
            {
                //this.attrItemList.add(cha);
                this.update_haigood(cha);
                cha=null;
                cha=new CusHaiGoodsAttr();
                cha.goodsId=goodItem.getGoodsId();
            }
            try {
                switch (goodItem.getAttrType()) {
                    case "color": {
                        cha.colors.add(goodItem.getAttrValue());
                    }
                    break;

                    case "size": {
                        cha.sizes.add(goodItem.getAttrValue());
                    }
                    break;

                    default: {
                        System.out.println("unknow attr_type");
                    }
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void update_haigood(CusHaiGoodsAttr item){
        //prepare data
        String attrgroup="";
        attrgroup=attrgroup+"颜色:";
        for(int i=0;i<item.colors.size();i++){
            attrgroup+=item.colors.get(i);
            if(i!=item.colors.size()-1){
                attrgroup+=",";
            }
        }
        attrgroup=attrgroup+"|尺寸:";
        for(int j=0;j<item.sizes.size();j++){
            attrgroup+=item.sizes.get(j);
            if(j!=item.sizes.size()-1){
                attrgroup+=",";
            }
        }
        //To database
        HaiGoodsWithBLOBs haiGoodsWithBLOBs = new HaiGoodsWithBLOBs();
        HaiGoodsExample haiGoodsExample = new HaiGoodsExample();
        haiGoodsExample.createCriteria().andGoodsIdEqualTo(item.goodsId);
        haiGoodsWithBLOBs.setAttrGroup(attrgroup);
        haiGoodsMapper.updateByExampleSelective(haiGoodsWithBLOBs,haiGoodsExample);
    }
}
