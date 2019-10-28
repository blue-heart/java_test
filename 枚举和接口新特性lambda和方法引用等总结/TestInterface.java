package com.bittech;
//万物都是类
//只要是引用对象都可以new 也是类
/*
接口
1：interface
2.定义常量 抽象方法，
默认的普通方法 静态方法
3接口可以实现多个接口
4.子类可以实现多个接口
5接口是面向对象3打特性多态的体现
1.默认的普通方法
2.静态方法
 */

public class TestInterface {
    public static void main (String[] args) {
        IMessage qq = new QQMessage();
        qq.print();
        //没有覆写也能调用 是子类 有继承
        //打印父类 覆写 就是调用自己
        //以前学过
        qq.fun();
        IMessage.message();
    }
}
interface IMessage{
    //子类随意 可以选择覆写
    default void fun(){
        System.out.println("聊天工具");
    }
    static void message(){
        System.out.println("这是静态方法");
    }
    //抽象方法不要方法体
   void print();


}
class QQMessage implements IMessage{
    public void print(){
        System.out.println("这是qq的聊天工具");
    }
    public void fun(){
        System.out.println("广告多一点");
    }
}
class  MsnMessage implements IMessage{
    public  void  print(){
        System.out.println("这是msn的聊天工具");
    }
}
