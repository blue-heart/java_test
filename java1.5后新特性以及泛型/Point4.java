package com.bittech;
//泛型方法并且带返回值，而且返回值类型
//是类型参数的类型

//泛型方法只针对自己的方法
//和别人都是T没关系 不用区分
//泛型类和泛型方法并存 T 也没有关系
//都是独立 因为方法独立

import org.omg.CORBA.PUBLIC_MEMBER;

public class Point4<T extends Number> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public <T> void print(T t){
        System.out.println(t);
    }
    public <T> T getInfo(T v){
        return v;
    }
    //也可以多写，返回那个写那个
    //java返回值只有一个，go语言
    //可以有多个
    //让泛型字母和方法不要一样 会混淆
    public <T,E> T getInfo(T t, E e){
        return t;
    }
}
