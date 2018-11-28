package com.example.designpattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式类
 */
public class RegularUtils {
    //验证手机号的正则
    public static final String REG_PHONE = "^[1][0-9]{10}$";
    //验证验证码的正则
    public static final String REG_VERC = "^[0-9]{6}$";
    //图形验证验证码的正则
    public static final String REG_IMG_VERC = "^[0-9]{6}$";
    //银行卡
    public static final String ACCOUNT_NUMBER_PATTERN = "^[0-9]{16,21}$";
    //正则表达式:验证身份证
    public static final String REGEX_ID_CARD = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";

    /**
     * 验证银卡卡号
     *
     * @param cardNo
     * @return
     */
    public static boolean isBankCard(String cardNo) {
        Pattern pattern = Pattern.compile(ACCOUNT_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(cardNo);
        return matcher.matches();
    }

    /**
     * 验证手机号码
     * @param phoneNo
     * @return
     */
    public static boolean isPhoneNo(String phoneNo) {
        Pattern pattern = Pattern.compile(REG_PHONE);
        Matcher matcher = pattern.matcher(phoneNo);
        return matcher.matches();
    }

    /**
     * 验证码校验
     * @param ver
     * @return
     */
    public static boolean isVer(String ver) {
        Pattern pattern = Pattern.compile(REG_VERC);
        Matcher matcher = pattern.matcher(ver);
        return matcher.matches();
    }

    /**
     * 图片验证码校验
     * @param ver
     * @return
     */
    public static boolean isImgVer(String ver) {
        Pattern pattern = Pattern.compile(REG_IMG_VERC);
        Matcher matcher = pattern.matcher(ver);
        return matcher.matches();
    }

    /**
     * 身份证校验
     * @param card
     * @return
     */
    public static boolean isIdCard(String card) {
        Pattern pattern = Pattern.compile(REGEX_ID_CARD);
        Matcher matcher = pattern.matcher(card);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String card = "66666666666666666";
        System.out.println(isBankCard(card));
        String phone="11111111111";
        System.out.println(isPhoneNo(phone));
        String idcard = "430181199104172250";
        System.out.println(isIdCard(idcard));
        String ver = "435433";
        System.out.println(isVer(ver));
    }
}
