package com.qinxiaozhou.util.wxExpress.model;

import java.util.Date;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/20 0020
 * @Description
 */
public class ExpressModel {

//    {nameValue: 0, productAddress: "1", productType: "2", jdVerifyCode: "2345", postVerifyCode: "123"}

    private String id;
    /**
     * 姓名值
     */
    private String nameValue;

    public void setNameValue(String nameValue) {
        int index = Integer.parseInt(nameValue);
        UserInfo info = Constant.userList.get(index);
        this.name = info.getName();
        this.phone = info.getPhone();
        this.number = info.getNumber();
        this.nameValue = nameValue;
    }
    /**
     * 姓名值
     */
    private String name;
    /**
     * 地址
     * 1,壹家,2,邮政
     */
    private String productAddress;
    /**
     * 取货类型
     * 1,普通,2京东
     */
    private String productType;
    /**
     * 京东取货码
     */
    private String jdVerifyCode;
    /**
     * 邮政取货码
     */
    private String postVerifyCode;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 手机号后四位
     */
    private String number;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新日期
     */
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameValue() {
        return nameValue;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getJdVerifyCode() {
        return jdVerifyCode;
    }

    public void setJdVerifyCode(String jdVerifyCode) {
        this.jdVerifyCode = jdVerifyCode;
    }

    public String getPostVerifyCode() {
        return postVerifyCode;
    }

    public void setPostVerifyCode(String postVerifyCode) {
        this.postVerifyCode = postVerifyCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
