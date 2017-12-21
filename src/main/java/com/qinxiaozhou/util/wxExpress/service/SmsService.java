package com.qinxiaozhou.util.wxExpress.service;

import java.util.Map;

/**
 * Create by qxz on 2017/12/21
 * Description:
 */
public interface SmsService {
    /**
     * 普通快递
     * @param map
     */
    void normalSms(Map<String,String> map);
    void normalSmsToUser(Map<String,String> map,String Phone);
    /**
     * 京东快递
     * @param map
     */
    void jdSms(Map<String,String> map);
    void jdSmsToUser(Map<String,String> map,String Phone);
    /**
     * 邮政快递
     * @param map
     */
    void postSms(Map<String,String> map);
    void postSmsToUser(Map<String,String> map,String Phone);
}
