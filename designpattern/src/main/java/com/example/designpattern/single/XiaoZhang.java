package com.example.designpattern.single;

/**
 * Created by Zc on 2018/3/1.
 */

public class XiaoZhang {
    public Form submitReport(){
        // 从固定的接口取表格
        Form form = HungryForm.getInstance();
        form.write("花山店数据");
        return form;
    }
}
