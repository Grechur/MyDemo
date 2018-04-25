package com.example.designpattern.superorextends;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zc on 2018/3/6.
 */

public class Test {
    public static void main(String[] args) {
        List<? extends Self> list = new ArrayList<>();//参数类型上界是Self
//        list.add(new Son());//error 不能放入任何类型，因为编译器只知道a中应该放入Self的某个子类，但具体放哪种子类它并不知道，因此，除了null以外，不能放入任何类型
//        list.add(new Self());
//        list.add(new Super());
        list.add(null);
        Self self = list.get(0);
        Super s = list.get(0);
//        Son son = list.get(0);//error:子类不能接收父类型参数
        List<? super Self> b = new ArrayList<>();//参数类型下界是Self
        b.add(new Son());//ok 只能放入T类型，且满足T类型的超类至少是Self，换句话说，就是只能放入Self的子类型
        b.add(new Self());//ok 本身类型也可以
//        b.add(new Super());// 超类不可以
        b.add(null);//ok
    }
}
