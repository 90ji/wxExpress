package com.qinxiaozhou.util.wxExpress.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Create by qxz on 2017/12/21
 * Description:
 */
public class PropertyUtil {
    private static String proFileName = "/application.properties";//正确的
    private static Properties pro;

    static{
        try {
            pro = new Properties();
            InputStream in = ClassLoader.class.getResourceAsStream(proFileName);
//            pro.load(in,"UTF-8");
            pro.load(new InputStreamReader(ClassLoader.class.getResourceAsStream(proFileName), "UTF-8"));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        String value = pro.getProperty(key);
        return value;
    }
    public static Properties getProperty(){
        return pro;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(PropertyUtil.getProperty()));
    }
}
