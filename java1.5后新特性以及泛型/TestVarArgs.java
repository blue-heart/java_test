package com.bittech;
//return 跳出当前方法
//后面的不会执行

public class TestVarArgs {

    /*public static  int  sum(int[] value)  {


        if (value == null) {
            //非法参数异常
            throw new IllegalArgumentException("value must be not null");
        }
        int sum = 0;
        for (int i = 0; i <value.length ; i++) {
            sum+= value[i];

        }
        return sum;
    }*/
    /*
    新特性：方法可见参数
     1.将可变参数变成一个数组，通过数组访问可变 参数
     2.两个方法等价 是重名
     3.可变参数必须定义到参数列表最后
     4.可变参数必须定义到参数列表最后
     */
    //这个和上面的 方法名字相同 参数列表相同 是重名
    //都是数组类型 等价
    public static int sum(int ... values){
        int sum = 0;
        for (int i = 0; i <values.length ; i++) {
            sum += values[i];

        }
        return sum;



    }
//传一个数组 然后直接传数值 很灵活
    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1,2,3,4}));
        System.out.println(sum(new int[]{1,2,3,4}));
        //包装成一个数组 什么都不传 也不会错 是null；
       // System.out.println(sum());
        //greeting("欢迎");
       // greeting("欢迎",1);
       // greeting("hao",1,2,3);
        //增强的for循环
        int[] values = new int[]{1,2,3,45,6};
        //次数上时间复杂度一样
        //但实际上 上面简单 底下判断更多
        for (int value:values
             ) {
            //每循环一次value数组下表会加
            //但是不加
            //避免了数组下表越界问题
            System.out.println(value);
        }


    }
    //有了可变参数 只定义一个方法 不用重载
    // 不能把 电话号 年龄 放一起传
    //代码联系生活 同类型
    public  static  void  greeting(String message, int ... values){
       /* int san =0;
        for (int i = 0; i <values.length ; i++) {
            san+=values[i];
        }
        System.out.println(message + san);*/
       //底下直接调用上面方法 string得打印
        System.out.println(message + " "+sum(values));

    }


    /*
    新特性：方法可变参数
    1.将可变参数变成一个数组，通过数组访问可变参数
    2. int[] value   int...values 不是重载关系，等价的
    3.可变参数必须定义在参数列表最后
    4.可变参数在参数列表中只能有一个
    5.main 方法 因为出来早 不可能以为新特性修改
     */
}


