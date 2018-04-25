package com.example.designpattern.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Zc on 2018/4/23.
 */

public class TestAnnotation {
    public static void main(String[] args) {
        Parent p = new Child();
        List<SortableField> list = p.init();//获取泛型中类里面的注解
        //输出结果
        for(SortableField l : list){
            System.out.println("字段名称："+l.getName()+"\t字段类型："+l.getType()+
                    "\t注解名称："+l.getMeta().name()+"\t注解描述："+l.getMeta().description());
        }

        try {
            Class clazz = Class.forName("com.example.designpattern.annotation.Anno");
            Method method = clazz.getMethod("desc",null);
            Annotation[] fList = method.getDeclaredAnnotations();
            for (Annotation a:fList
                 ) {
                System.out.println(a);
                if(a instanceof FieldMeta){
                    FieldMeta meta = (FieldMeta) a;
                    System.out.println(meta.name()+meta.summary()+meta.description());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
