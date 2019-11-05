package com.classloader;
/*
classloader
自定义的在最前面 有图
1.appclassloader 用来加载应用程序中类
（用户自定义类）（classpath）
自定义classpath
自己写一个 加载文件 比如从数据库加载文件
以你自己的方式（高级特性）
2.extclassloader 用来拓展
（jre lib ext /java.ext.dirs.xxx 你自己加的目录）
lib 是库的意思
BootStrap classloader 加载启动jvm的类
lib rt
注意 要是名字修改不会加载

字节码文件-byte流 -类加载器 有图
出去后 字节码 到机器码 到native c/c++实现
所以boot出不来 上面的是java语言开发 就是java的类

类加载器源码不公开 api里面 反编译文件 容易改变 不开放
（兼容性问题）
之前的源码在 文件里

out文件里面放的是你的类文件classpath文件 用户定义的类

3.类加载器的双亲委派模型
处理顶层类加载器没有父类加载器 其他的类都有父加载器
类加载流程：加载一个类 都要经过顶层的类加载器，
如果顶层的类加载器 在他所在的范围中找不到该类
在自己的文件夹找
就会反馈到子类加载器 以此类推
失败了 就是找不到符号
OSGI 会破坏双亲委派模型
4.同一个类加载器中加载一个类只有一个对应的class
对象，不同的类加载器加载同一个类 对应的class对象
不同（不相等）两个没有关系

 */



import java.util.Arrays;

public class TestClassloader {
    public static void main(String[] args) {
      /*  //class这个类 不能new 构造私有
        //不能反射获取属性 因为这是规定 特例
        Class classz = TestClassloader.class;
        ClassLoader classLoader =
                classz.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().
        getParent());
        //就是没有东西可以加载了 在加载就空指针异常了
        //再 .就不可以了 空指针异常 已经是null 了*/
      /*
        Object o = new Object();
        System.out.println(o.getClass());
        //因为是一个数组methods 所以打印数组
        //这个obiect就是jdk里的
        // 用自己的类 编译
        // 都不会通过 如果编译jdk但是运行时会找到你自己
        //写的 以为你自己写的就是
        System.out.println(Arrays.toString(o.getClass().
        getMethods()));*/
       /* try {
            //项目所有代码都要编译 有引用关系 所以不会通过
            Class aClass = Class.forName("java.lang.
            Object");

            //如果返回是app 是 自己的
            // 因为第一次执行
            // 因为执行过 是bo 是顶层文件
            //parent是null 就是bootostrap
            System.out.println(aClass.getClassLoader());
            //这个由于要删除文件 不写了
            //结果是null 因为双亲委派模型
            //所以会优先加载jdk内部的 因为运行过
            //所以直接调用 比较安全
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
       Class memberClass1 = Member.class;
       Class memberClass2 = new MyClassloader().
               loadClassData("com.classloader." +
                       "Member");
        System.out.println(memberClass1.getClassLoader());
        System.out.println(memberClass2.getClassLoader());
        System.out.println(memberClass1==memberClass2);
    }
}
