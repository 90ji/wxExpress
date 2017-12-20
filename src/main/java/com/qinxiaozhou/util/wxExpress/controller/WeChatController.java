package com.qinxiaozhou.util.wxExpress.controller;

import com.alibaba.fastjson.JSON;
import com.qinxiaozhou.util.wxExpress.model.ExpressModel;
import com.qinxiaozhou.util.wxExpress.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/19 0019
 * @Description
 */
@RestController
public class WeChatController {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private WeChatService weChatService;

    @RequestMapping("/")
    public String test() {
        return "hello world:" + sdf.format(new Date());
    }

    @RequestMapping("/testRequest")
    public String testRequest(String expressModel) {

        ExpressModel model = JSON.parseObject(expressModel, ExpressModel.class);
        model.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        model.setCreateDate(new Date());

        String info = weChatService.generateInfo(model);
        return info;
    }
}
