package com.bittech;


import static com.bittech.MyMath.*;
import static com.bittech.MyMath.AGE;

/*
静态导入类的静态方法
静态导入类的静态属性
静态批量导入通过类名.*
采用静态导入时，如果类中存在使用的静态属性
和方法，优先使用类中自己的（就近原则）
集成开发工具关于类的导入比较智能
通常不需要额外 导入 会自动找类名
除非 不同包 同类名 很智能 可以直接类名
点访问的方法或者属性 也不用这样 系统默认导入
直接一个age也ok

 */

public class TestImport {

    public  static  int add(int a , int b){

        System.out.println("这是test的add方法");
        return a+b;
    }
    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(MyMath.AGE);
    }

}
class MyMath{

    public static int AGE = 120;
    public static int add(int a , int b){
        return a+b;
    }
    public static int sub(int a , int b){
        return  a - b;
    }


}
