package com.example.designpattern.leetCode;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: DefangIPAddress
 * @Description: IP地址无效化
 * @Author: Grechur
 * @CreateDate: 2019/11/8 17:58
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/8 17:58
 */
public class DefangIPAddress {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println("result=" +defangIPaddr(address));
    }

    public static String defangIPaddr(String address) {
        int length = address.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            Character character = address.charAt(i);
            if(character=='.'){
                stringBuffer.append("[.]");
            }else{
                stringBuffer.append(character);
            }
        }
        return stringBuffer.toString();
    }
}
