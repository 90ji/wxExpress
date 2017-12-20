package com.qinxiaozhou.util.wxExpress.model;

import java.util.ArrayList;

/**
 * @Author MoonLion
 * @Date Create in 2017/12/20 0020
 * @Description
 */
public class Constant {
    public static ArrayList<UserInfo> userList = null;

    /***
     * '鲜显玮', '鲜显风', '张淑蒙','侯冰', '贾岩'
     */
    static {
        userList = new ArrayList<>();
        userList.add(new UserInfo("鲜显玮", "13037150353","0353"));
        userList.add(new UserInfo("鲜显风", "18284569259","9259"));
        userList.add(new UserInfo("张淑蒙", "17628043609","3609"));
        userList.add(new UserInfo("侯冰"  , "13666134514","4514"));
        userList.add(new UserInfo("贾岩"  , "17628097027","7027"));
        userList.add(new UserInfo("秦晓洲", "18512891248","1248"));
    }
}
