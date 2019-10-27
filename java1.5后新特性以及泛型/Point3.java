package com.bittech;

public class Point3<T,E>{
    private T x;
    private  E y;

    public T getX() {
        return x;
    }
    //这个就不是泛型方法
    public void setX(T x) {
        this.x = x;
    }

    public E getY() {
        return y;
    }

    public void setY(E y) {
        this.y = y;
    }
}
