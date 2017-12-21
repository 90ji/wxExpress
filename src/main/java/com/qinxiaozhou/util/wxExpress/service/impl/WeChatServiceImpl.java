package com.qinxiaozhou.util.wxExpress.service.impl;

import com.qinxiaozhou.util.wxExpress.model.ExpressModel;
import com.qinxiaozhou.util.wxExpress.service.SmsService;
import com.qinxiaozhou.util.wxExpress.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/21 0021
 * @Description
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private SmsService smsService;

    @Override
    public String generateInfo(ExpressModel model) {
        String name = model.getName();
        String productAddress = model.getProductAddress();
        String result = "";
        /**壹家*/
        if (productAddress.equals("1")) {
            /**手机号后四位*/
            String number = model.getNumber();
            String productType = model.getProductType();
            /**普通*/
            if (productType.equals("1")) {
                result = name + "-壹家-" + number;
                HashMap<String, String> map = new HashMap<>();
                map.put("name",name);
                map.put("address","壹家");
                map.put("number",number);
                System.out.println(result);
                smsService.normalSms(map);
            }
            /**京东*/
            if (productType.equals("2")) {
                String jdVerifyCode = model.getJdVerifyCode();
                result = name + "-京东-" + number + "-" + jdVerifyCode;
                HashMap<String, String> map = new HashMap<>();
                map.put("name",name);
                map.put("address","京东");
                map.put("number",number);
                map.put("code",jdVerifyCode);
                System.out.println(result);
                smsService.jdSms(map);
            }
        }
        /**邮政*/
        if (productAddress.equals("2")) {
            String phone = model.getPhone();
            String postVerifyCode = model.getPostVerifyCode();
            result = name + "-邮政-" + phone + "-" + postVerifyCode;
            HashMap<String, String> map = new HashMap<>();
            map.put("name",name);
            map.put("address","邮政");
            map.put("phone",phone);
            map.put("code",postVerifyCode);
            System.out.println(result);
            smsService.postSms(map);
        }
        return result;
    }
}
