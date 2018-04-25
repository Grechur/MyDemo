package com.example.designpattern.single;

/**
 * Created by Zc on 2018/3/1.
 */

public class Cousins {
    public Form submitReport(){
        // 从固定的接口取表格
        Form form = HungryForm.getInstance();
        form.write("光谷店数据");
        return form;
    }
}
