package com.ehais.figoarticle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 5/28/17.
 */
public class CusHaiGoodsAttr {
    public Long goodsId;

    public List<String> colors;

    public List<String> sizes;

    public CusHaiGoodsAttr() {
        colors = new ArrayList<>();
        sizes = new ArrayList<>();
    }
}
