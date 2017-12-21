package com.qinxiaozhou.util.wxExpress.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.qinxiaozhou.util.wxExpress.service.SmsService;
import com.qinxiaozhou.util.wxExpress.util.Constant;
import com.qinxiaozhou.util.wxExpress.util.SmsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create by qxz on 2017/12/21
 * Description:
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Value(value = "${info.defaultTargetPhone}")
    public static String defaultTargetPhone;

    @Override
    public void normalSms(Map<String, String> map) {
        normalSmsToUser(map, null);
    }

    @Override
    public void normalSmsToUser(Map<String, String> map, String phone) {
        if (phone == null) {
            phone = defaultTargetPhone;
            if (phone == null){
                phone = Constant.DefaultPhone;
            }
        }
        /** ${name}的快递在${address},手机尾号为${number},请及时查收.*/
        try {
            SmsUtil.sendNormalSms(map, phone);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void jdSms(Map<String, String> map) {
        jdSmsToUser(map, null);
    }

    @Override
    public void jdSmsToUser(Map<String, String> map, String phone) {
        if (phone == null) {
            phone = defaultTargetPhone;
            if (phone == null){
                phone = Constant.DefaultPhone;
            }
        }
        /** ${name}的快递在${address},手机尾号为${number},取货码为${code},请及时查收.*/
        try {
            SmsUtil.sendJdSms(map, phone);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postSms(Map<String, String> map) {
        postSmsToUser(map, null);
    }

    @Override
    public void postSmsToUser(Map<String, String> map, String phone) {
        if (phone == null) {
            phone = defaultTargetPhone;
            if (phone == null){
                phone = Constant.DefaultPhone;
            }
        }
        /** ${name}的快递在${address},手机号为${phone},取货码为${code},请及时查收.*/
        try {
            SmsUtil.sendPostSms(map, phone);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
