package com.example.designpattern.proxy;

/**
 * Created by Zc on 2018/3/1.
 * 这就是我们所要说的代理模式:
 为其他对象(小光)提供一个代理(大龙)以控制对这个对象的访问.
 二者虽然都会有代理类/装饰类实际调用被代理对象/被装饰对象的行为. 然而代理模式重在控制, 而装饰模式重在添加.
 */

public class DaLong implements Person{
    private Person person;

    public DaLong(Person person) {
        this.person = person;
    }
    @Override
    public void signing(int price) {
        System.out.println("对方报价:" + price);

        if (price < 100) {
            this.person.signing(price);
        }
        else {
            negotiate(price);
        }
    }

    private void negotiate(int price) {
        System.out.println("不接受, 要求降价" + (price - 80));
    }
}
