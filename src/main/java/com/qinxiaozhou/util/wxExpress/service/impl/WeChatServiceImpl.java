package com.qinxiaozhou.util.wxExpress.service.impl;

import com.qinxiaozhou.util.wxExpress.model.ExpressModel;
import com.qinxiaozhou.util.wxExpress.service.WeChatService;
import org.springframework.stereotype.Service;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/21 0021
 * @Description
 */
@Service
public class WeChatServiceImpl implements WeChatService {

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
                System.out.println(result);
            }
            /**京东*/
            if (productType.equals("2")) {
                String jdVerifyCode = model.getJdVerifyCode();
                result = name + "-京东-" + number + "-" + jdVerifyCode;
                System.out.println(result);
            }
        }
        /**邮政*/
        if (productAddress.equals("2")) {
            String phone = model.getPhone();
            String postVerifyCode = model.getPostVerifyCode();
            result = name + "-邮政-" + phone + "-" + postVerifyCode;
            System.out.println(result);
        }
        return result;
    }
}
