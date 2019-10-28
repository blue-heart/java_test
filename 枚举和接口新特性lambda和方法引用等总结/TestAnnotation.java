package com.bittech;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/*

第三个：@SuppressWarnings
压制警告 提示警告不用管
主要是第一个
 */
public class TestAnnotation{
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son);
        son.printSum();
        son.printInfo();
    }
}

abstract class Father{
    @Override
    public String toString() {
        return "Father{}";
    }
    public void balance(){

    }


}
//方法名字错误 不会出错
//只会调用 父类方法
//继承的时候 方法覆写可以没有
//语法的bug很难的 编译很强
//override 可以检查 语法覆写是否正确
//这就是java代码的便捷性

class  Son extends Father{
    @Override
    public String toString(){
        return "sun";
    }
    public void balance(){

    }
    //v1.0
    // 一般会有
    // 建议使用 printSum替换他
    //方法看不见对象 对象在外面
    //对象可以看见方法
    @Deprecated
public void  printInfo(){
    System.out.println("faf");
}
//1.2
public void  printSum(){
    System.out.println("fasf");
}
























}