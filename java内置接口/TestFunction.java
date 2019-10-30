package com.bittech;
//这个包 就是提供给你的

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunction {
    public static int charsCountA(char[] chars){
        int i = 0;
        for (char c : chars){
            if (c =='A'){
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        //里面有函数包 不用写 function内定义 可以方法引用
        //后面是返回值
        Function<Integer,String> function = String::valueOf;
        //计算字符串的长度 引用成员方法
        Function<String,Integer> function1 =String::length;
        //计算char数组中A的个数 没有方法
        //所以自己写一个函数
        Function<char[], Integer> function2 = (chars )->{
            int i = 0;
            for (char c : chars){
                if (c =='A'){
                    i++;
                }
            }
            return i;
        } ;
        //如果自己写的方法 同样也可以方法引用
        //注意这儿 有一个改进的方法 直接没有泛型
        //更加便捷
        function2 = TestFunction::charsCountA;
        //供给型函数 只需要提供一个对象
        //希望提供一个字符串
        Supplier<String> supplier1 = () ->{
            return  "hello java";
        };
        System.out.println(supplier1.get());
        Supplier<Person2> supplier2=()-> {
            Person2 person2 = new Person2();
            person2.setAge(22);
            person2.setName("dads'");
            return person2;

        };
        System.out.println(supplier2.get());
        //这里面 写的是你要传的值 结果在方法后面
        //解决问题 就是 别人 还没有弄好
        //你就要赶紧把 计算最终结果的 代码写好
        //很便捷
        double price = compute(
                ()->{
                    //CODE
                    //这个d 可以没有
                    //掌握自己掌握的 透彻掌握
                    return 100.0D;
                },
                ()->{
                    //CODE
                    return 0.98D;
                }
        );
        System.out.println(price);
        //消费型
        //底下这个括号 可有可无
        Consumer<String[]> consumer = (strings->{
           for (String string : strings){
               System.out.println(string);
           }
        });
        //接收
        consumer.accept(new String[]{"JAVA","PYTHON","C++"});
        Consumer<String> consumer1 = (s -> {
            System.out.println(s);
        });
        //System 类名 out 是常量
        //out 静态属性 对象
        //类型是 printString
        //对象的成员方法引用
        //这个特殊 SYstem.out 就相当于一个对象
        Consumer<String> consumer2 =System.out::println;
        consumer2.accept("hello");

        //断言型
        //判断String 是否为null或者空
        Predicate<String> predicate =(s -> {
            //返回值boolean
            return s !=null && s.length() !=0;

        });
        System.out.println(predicate.test("sdad"));
        System.out.println(predicate.test(null));

        //做了两个判断
        Predicate<String> predicate1 =(s -> {
            return s!=null;
        });
        Predicate<String> predicate2 =(s -> {
            return s.length() !=0;
        });
        /*
        y= f(x)
        z = g(x)
        r = y&z 按位
        h = f(x)&&g(x) 按值
        r = h(x)
        想做一系列的操作可以追加
        利用lambda表达式 做出的一系列
         */
        Predicate<String> predicate3 = predicate1.and(predicate2);
            System.out.println(predicate3.test("hello"));
            System.out.println(predicate3.test(""));


    }
    //只关心最终结果 不关心代码怎么来 最后的值
    //get 获得的是 函数内的东西
    public static double compute(Supplier<Number> supplier1,
                                 Supplier<Double> supplier2){
        Number number =supplier1.get();
        Double discount = supplier2.get();
        //这个必须 有doublevalue 因为要返回 double的值
        // 你是number
        double price = number.doubleValue()*discount;
        System.out.println(price);

        return price;
    }
}
