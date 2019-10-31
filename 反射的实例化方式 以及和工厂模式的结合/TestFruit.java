package com.Factory;

public class TestFruit {
    //简单工厂模式用反射

    public static void main(String[] args) {
        //这个前面学过
        Fruit fruit = FruitFactory.getFruit("com.Factory.Orange");
        if (fruit != null) {
            fruit.eat();
        }else {
            System.out.println("FruitFactory 创建Fruit对象失败");
        }
    }
}
