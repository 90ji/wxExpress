package com.qinxiaozhou.util.wxExpress.util;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by qxz on 2017/12/21
 * Description:
 */
public class SmsUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    private static IAcsClient acsClient = null;

    private static final String accessKeyId = PropertyUtil.getValue("sms.accessKeyId");
    private static final String accessKeySecret = PropertyUtil.getValue("sms.accessKeySecret");
    private static final String SignName = PropertyUtil.getValue("sms.signName");
    private static final String normalTemplateCode = PropertyUtil.getValue("sms.normalTemplateCode");
    private static final String jdTemplateCode = PropertyUtil.getValue("sms.jdTemplateCode");
    private static final String postTemplateCode = PropertyUtil.getValue("sms.postTemplateCode");

    static {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        acsClient = new DefaultAcsClient(profile);
        System.out.println("accessKeyId:"+accessKeyId);
        System.out.println("accessKeySecret:"+accessKeySecret);
        System.out.println("SignName:"+SignName);
        System.out.println("normalTemplateCode:"+normalTemplateCode);
        System.out.println("jdTemplateCode:"+jdTemplateCode);
        System.out.println("postTemplateCode:"+postTemplateCode);
    }

    /**
     * ${name}的快递在${address},手机尾号为${number},请及时查收.
     *
     * @param messageInfo
     * @param targetPhone
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendNormalSms(Map<String, String> messageInfo, String targetPhone) throws ClientException {

        //组装请求
        SendSmsRequest request = getSendSmsRequest(messageInfo, normalTemplateCode, targetPhone);
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    /**
     * ${name}的快递在${address},手机尾号为${number},取货码为${code},请及时查收.
     *
     * @param messageInfo
     * @param targetPhone
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendJdSms(Map<String, String> messageInfo, String targetPhone) throws ClientException {
        //组装请求
        SendSmsRequest request = getSendSmsRequest(messageInfo, jdTemplateCode, targetPhone);
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    /**
     * ${name}的快递在${address},手机号为${phone},取货码为${code},请及时查收.
     *
     * @param messageInfo
     * @param targetPhone
     * @return
     * @throws ClientException
     */
    public static SendSmsResponse sendPostSms(Map<String, String> messageInfo, String targetPhone) throws ClientException {
        //组装请求
        SendSmsRequest request = getSendSmsRequest(messageInfo, postTemplateCode, targetPhone);
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    private static SendSmsRequest getSendSmsRequest(Map<String, String> messageInfo, String normalTemplateCode, String targetPhone) {
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(targetPhone);
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SignName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(normalTemplateCode);

        String messageInfoJson = JSON.toJSONString(messageInfo);
        System.out.println(messageInfoJson);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        /**
         * ${name}的快递在${address},手机尾号为${number},取货码为${code},请及时查收.
         * */
        request.setTemplateParam(messageInfoJson);
        return request;
    }

    public static void main(String[] args) throws ClientException {
        String name = "鲜显玮";
        String number = "0353";
        String phone = "13037150353";
        String jdVerifyCode = "147258";
        String postVerifyCode = "369258";

        String targetPhone = "18512891248";
        /*******************************************************************/
        //普通快递
//        HashMap<String, String> normalMap = new HashMap<>();
//        normalMap.put("name",name);
//        normalMap.put("address","壹家");
//        normalMap.put("number",number);
//        SendSmsResponse normalResponse = sendNormalSms(normalMap,targetPhone);
//        System.out.println(JSON.toJSONString(normalResponse));
        /*******************************************************************/
        //京东快递
//        HashMap<String, String> jdMap = new HashMap<>();
//        jdMap.put("name",name);
//        jdMap.put("address","京东");
//        jdMap.put("number",number);
//        jdMap.put("code",jdVerifyCode);
//        SendSmsResponse jdResponse = sendJdSms(jdMap,targetPhone);
//        System.out.println(JSON.toJSONString(jdResponse));
        /*******************************************************************/
//        //邮政快递
        HashMap<String, String> postMap = new HashMap<>();
        postMap.put("name",name);
        postMap.put("address","邮政");
        postMap.put("phone",phone);
        postMap.put("code",postVerifyCode);
        SendSmsResponse postResponse = sendPostSms(postMap,targetPhone);
        System.out.println(JSON.toJSONString(postResponse));
    }
}
