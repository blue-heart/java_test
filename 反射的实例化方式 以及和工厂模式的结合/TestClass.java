package com.bittich2;

import java.util.Date;

public class TestClass {
    public static void main(String[] args) {
       /* Date date = new Date();
        //System.out.println(date.getClass());
        Class classz1 = date.getClass();
        Class classz2 = Date.class;
        //编译器无法知道字符串存在不存在
        //抛出异常 非受查异常 捕获
        //这是静态方法 必须写对才能找到
        //写其他字符串肯定必行 必须写Data类
        //class对象描述的student类的组成部分
        //class 如果不用全限定名 会出错
        try {Class classz3 = Class.forName("java.util.Date");
            System.out.println(classz1);
            System.out.println(classz2);
            System.out.println(classz3);
            System.out.println(classz1==classz2);
            System.out.println(classz2==classz3);
            Class classz4 = String.class;
            System.out.println(classz3==classz4);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }*/
       //只要获取到一个类的对象，就可以调取成员方法和属性
        //不获取class对象，可以通过class类中获取
        // 静态属性和方法 和普通类没差别
        //没发new 需要3中途径获取
        Class classz = Date.class;
        try {
            //第二种：new Instance
            //Thu Oct 31 11:33:03 CST 2019
            //通过一个类的class对象的newInstance方法
            //局限性 ：必须有无参数的构造方法
            //  实例化对象  class某种意义就是
            //该类 工厂只是包装了一下 还是第一种方式
            // 即是class对象 调用这个方法打印了Data的属性
            // 底下 右边 实例化了  data的对象
            //但是 调用这个方法 和构造方法一个道理
            //没有传参数
            Object object = classz.newInstance();
            Date date = (Date) object;
            System.out.println(object);


            //NoSuchMethodException:
            //Integer的无参构造方法没有
            Class classz1 = Integer.class;
           Integer integer= (Integer) classz1.newInstance();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }



    }
}
//这样就知道对象的类型和组成部分
//点开这个类就知道组成部分
//class类 描述类 返回一个对象
//class java.util.Date