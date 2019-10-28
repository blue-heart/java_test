package com.bittech;
/*
lambda表达式/函数编程
1.函数接口：
专门为函数编程而生，有且只有一个抽象方法
采用@functionalInterface
2.（参数名列表）-》{实现体}
eg：无参数 （）-》{}
eg：实现体有且只有一条命令
{}可以省略
eg:实现体有且只有一条命令 并且作为
返回值。return 和大括号 都可以省略
3.lambda表达式中 参数名不要和变量名重名
 */

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.scenario.effect.impl.sw.sse.SSERendererDelegate;
import javafx.scene.control.cell.PropertyValueFactoryBuilder;

public class TestLambda {
    public static void code1() {

        //定义一个普通类，实现接口，实现抽象方法
        //通过匿名内部类，实现一个对象
        IMessage2 iMessage2 = new IMessage2() {
            @Override
            public void print() {
                System.out.println("IMessage2 print");

            }
        };

    }

    public static void main(String[] args) {
        //下面只是覆写方法 不调用
        //这个说明里面可以有语句
        //  IMessage2 iMessage2 = () -> System.out.println("Imessage print");
        //  iMessage2.print();
        /*IMessage3 iMessage3 =()->{
            String a = "HELLO";
            String b = "word";
            //因为是string的方法覆写 又返回值
            return a + b;
        };
        System.out.println(iMessage3.info());*/
        /*    IMessage3 iMessage3 =()->

             "hello" + "word";
        ;
        System.out.println(iMessage3.info());    */
        /*IMessage4 iMessage4 = new IMessage4() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }


            //静态内部类 有分号
        };
        int z = iMessage4.add(4,5);
        System.out.println(z);
        //函数编程
        //这个x，y可以写成a，b 参数名字随便起
        ///int x = 10;
        //参数名字报错
        int sum = 20;
        IMessage4 iMessage41 = (x,y)->{
            //可以写更多的代码
            //写你自己的计算逻辑
            //省略了那么多的方法步骤
            //实现体重使用的外部变量 隐式final修饰
            //只可以 用这个值 不可以改

            int c = sum+10;
            return x+y;

        };
        System.out.println(iMessage41.add(4,6));*/
        /*
        1.静态方法引用
        x->y 函数名 IUtil
        函数和面向对象有共性
        都能转化一个结果
        String.valueof（i）
        起一个别名
         */

        IUtil<Integer, String> integerStringIUtil = (i) -> {
            return String.valueOf(i);

            //这个分号应该和匿名内部类的一样
        };
        //只能这样传递参数 而且 不要和return在一个括号在后面
        // 执行不了
        System.out.println(integerStringIUtil.convert(30));
        //起一个别名
        //有一个静态方法
        //后面是string类的静态方法
        //因为有这个方法 可以直接用
        //更短的代码
        //打通了面向对象和函数的关系
        //引用静态方法
        IUtil<Integer, String> iUtil = String::valueOf;
        System.out.println(integerStringIUtil.convert(2));
        /*
        y=f（x）
        x=g（z）
        y=f（g（z））
        把函数当做参数传递
         */
        //利用这种方式定义 函数接口
        //才可以完成这种操作
        //java隶属于类和对象
        //函数就是一段表达式
        //这样就没有面向对象 有这样的结果、
        //指定了参数是x 变量名字 类型以已经确定
        //不用写 可以改
        //打死你hi要方法传递参数
            /* cnvert(
                (y)->{
                    return String.valueOf(y);
        }
        );
        cnvert(
                (x) ->{
                    System.out.println(x);
                    //这个就是 string的静态方法 可以这样用
                    //也是实现结果的关键之处
                    return String.valueOf(x);
                }
        );*/

      /*  IUtil2<String> iUtil2 = () -> {
            return "hello";
        };
//这句才能打印
        System.out.println(iUtil2.switchParam());
        //字符串都是string 的对象
        // "Hello".toUpperCase();
        //这样没意义
        System.out.println("Hello".toUpperCase());
        //引用对象方法
        IUtil2<String> iUtil21 = "Hello"::toUpperCase;
        System.out.println(iUtil21.switchParam());


        //这就是lambda的升级版
        public static void cnvert (IUtil < Integer, String > iUtil){
            //这个方法就是借口的方法
            System.out.println(iUtil.convert(20));
            IUtil3<String, Integer> iUtil3 = (p1, p2) -> {
                return p1.compareTo(p2);
            };
            int compareRs = iUtil3.compare("hello", "HELLO");
            System.out.println(compareRs);
            //类引用成员方法
            IUtil3<String, Integer> iUtil31 = String::compareTo;
            System.out.println(iUtil31.compare("hello", "HELLO"));
        }


fop :z = f（x，y）
oop：z =new z（x，y）
 */
//方法名字不重要 返回值 参数列表重要
        IUtil4<String, Integer, Person2> iUtil4 = (p1, p2) -> {
            return new Person2(p1, p2);
        };
        Person2 person2 = iUtil4.createObject("zhangsan", 25);
        System.out.println(person2);
        IUtil4<String, Integer, Person2> iUtil41 = Person2::new;
        IUtil5<Person2> iUtil5 = Person2::new;
        Person2 person21 = iUtil41.createObject("dad", 25);
        Person2 person22 = iUtil5.createObject();
        System.out.println(person21);
        System.out.println(person22);
    }



    //这样解决了静态问题
}
        //这种命名方式很吊 两种默认值
    //一个作为参数 一个作为返回值
    //自定义 这个拓展流弊
//名字不重要 只关心输入和输出
//5 和 2没什么区别
       interface   IUtil<P,R>{
        R convert(P p);
  }
  interface  IUtil2<R>{
        R switchParam();
  }
  interface  IUtil3<P,R>{
       R compare(P p1, P p2);
  }
  interface  IUtil4<P1,P2,R>{
  R createObject(P1 p1,P2 p2);}
  interface  IUtil5<R>{
    R createObject();
  }

    interface IMessage2 {
        void print();

    }
    interface  IMessage3{
        String info();
    }
    interface  IMessage4{
        int add(int x, int y);
    }
    class Person2 {
        private Integer age;

        private String name;

        public Person2() {

        }

        public Person2(String name, Integer age) {
            this.age = age;
            this.name = name;
        }


            public Integer getAge () {
                return age;
            }

            public void setAge (Integer age){
                this.age = age;
            }

            public String getName () {
                return name;
            }

            public void setName (String name){
                this.name = name;
            }

            @Override
            public String toString () {
                return "Person2{" +
                        "age=" + age +
                        ", name='" + name + '\'' +
                        '}';
            }


    }

