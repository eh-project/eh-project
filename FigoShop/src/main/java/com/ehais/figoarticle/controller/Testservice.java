package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.Service.GoodiesAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stephen on 5/27/17.
 */
@Controller
public class Testservice {
    @Autowired
    private GoodiesAttr goodiesAttr;

    @RequestMapping("/testservice")
    @ResponseBody
    public void test(){
        goodiesAttr.transfer();
    }

}
