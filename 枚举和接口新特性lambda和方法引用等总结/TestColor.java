package com.bittech;
import com.sun.org.apache.regexp.internal.RE;
//开闭原则 就是避免引进更多的bug

//命名的方式规范才有 包包相连的行为
public class TestColor {
    public static void main(String[] args) {
        //int flag = 2;
        //类直接调用 静态方法
        //这个仅仅通过类名调用
        //也会默认调用tostring
        System.out.println(Color.getColorInstance(2));
        System.out.println(Color.getColorInstance(1));
        //永远返回静态常量 肯定相等
        System.out.println(Color.getColorInstance(3)
                ==Color.getColorInstance(3));
        //下面就是switch的 return的作用
        System.out.println(Color.getColorInstance(5));


    }
}

//多例 ：一个类的实例化对象的个数是可数的
class Color{
    private String title;
    //直接定义常量赋值 new 可以
    private static final Color RED = new Color("红色");
    private static final Color GREEN = new Color("绿色");
    private static final Color BLUE = new Color("蓝色");


//构造传参
    private Color(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }

    //返回一个color对象 这个就是典型的
    //返回引用收据类型 方法名字 因为方法传参数
    //所以可以返回这个类型 传参数
    //多例 不允许new对象 可以查找调用多个对象
    //用来使用
    public  static Color getColorInstance(int flag){
        switch (flag){
            case 1:
                return RED;
            case  2:
                return GREEN;
            case 3:
                return BLUE;
                default:
                    return null;
        }


    }

}