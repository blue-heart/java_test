package com.Factory;

public interface Fruit {
    void eat();
}
//扩展 没有修改

class Orange implements Fruit{


    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}
class Apple implements  Fruit{


    @Override
    public void eat() {
        System.out.println("吃苹果");

    }
}
class FruitFactory{
   private FruitFactory(){

        }
        public static Fruit getFruit(String className) {
            try {
                //这儿多了一种方式获取类名
                //这是自己的方法 get是object的方法
                //下面是class实例的是object的对象
                //但是实际是实例的类的 要转型
                //转型在这儿可以用到
                Class classz = Class.forName(className);
                //返回的是objec 要水果类型
                return (Fruit) classz.newInstance();
                //异常可以直接加
                //也可以一个括号写多个
                //也可以throws
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }

        }
