package com.example.designpattern.single;

import java.util.ArrayList;

/**
 * Created by Zc on 2018/3/1.
 */

public class Form {
    private ArrayList<String> mFormData = new ArrayList<>();

    public void write(String data) {
        mFormData.add(data);
    }

    @Override
    public String toString() {
        return "表格:" + this.hashCode() + ", 数据:" + mFormData;
    }
}

