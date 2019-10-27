package com.bittech;

public class TestMessage {
    public static void main(String[] args) {
        Message<Object> message = new Message<>();
        message.setMessage("aas");
        ds(message);
        Message<Integer> message1 = new Message<>();
        message1.setMessage(25);
       // ds(message1);

    }
    //参数类型又多了一种 泛型
    //这样太局限 只有一种类型
   // public  static  void fun(Message<String> message){
     //   System.out.println(message.getMessage());
    //}
    //上限
   // public  static  void fun(Message<?extends Number> message){
        //通配符 不可以修改
      //  message.setMessage(11);
       // System.out.println(message.getMessage());
   // }
    //nember 是一个抽象类 无法实例化对象
    //只能往上走
    //这儿几种模式的道理就是 父类的方法比子类少的原因
    //super 方法可以修改 和 super类不可以 都是这
    public  static  void  ds(Message<?super Number> message){
        message.setMessage(new Integer(25));

        System.out.println(message.getMessage());
    }
}
