package com.qinxiaozhou.util.wxExpress.model;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/20 0020
 * @Description
 */
public class UserInfo {
    private String name;
    private String phone;
    private String number;

    public UserInfo(String name, String phone, String number) {
        this.name = name;
        this.phone = phone;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
