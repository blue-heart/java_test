package kt3.dm;

import java.io.IOException;

/*
注意： catch 里的return 是不会执行下面的程序
因为没有返回值 所以 终止程序
异常也是一个代码块 如果里面有声明外部
不可见 要在外面可见位置声明
finally 只能有一个
 */
public class TestException {
    //抛出给虚拟机 虚拟机不工作底下代码不能执行
    public static void main(String[] args) {
        try {
            add();
        } catch (AddException e) {
            e.printStackTrace();

        }
        //add();


        //很灵活 方法有返回值 直接这样
        int result = testFinally();
        System.out.println(result);

        int num = 30;
        //断言就是32 不开就是30
        //如果断言不开 就可能出现错误
        assert (num = num + 2) == 32 : "num 数据异常";
        System.out.println(num);
        // throws IOException
        // {
        //  System.out.println("开始");
//try {
        //int ppt = System.in.read();

//}catch (IOException e){
        // System.out.println("sss");
//}


        // int value = Integer.parseInt(args[0]);
        int value = 1;
        /*
        除法运算 分母不为0
        arithmeticexception 运行时异常 非受查
        bug 异常是中断指令流
         */
        //if (value == 0){
        System.out.println("分母不能为0");
        //}
        // else{
        //本来虚拟机处理 直接终止
        //但是这个 会继续执行
        //而且异常处理会兼容处理正确的代码

        try {
            System.out.println(10 / value);
            //e为当前 处理的异常对象

        } catch (ArithmeticException e) {
            //处理语句
            //下面是异常内容描述
            e.printStackTrace();
            System.out.println("抛出异常");
        } finally {
            System.out.println("finally 块" +
                    "无论异常是否处理都会执行");
        }
        // }
        System.out.println("结束");
    }

    public static int testFinally() {
        //注意定义在外面
        //声明变量
        /*
        finally：
        1.如果finally 有return
        覆盖掉try
        2.在try前有return
        后面语句不会执行
        3.但是只有finally可以
        因为它必须执行（大多数情况）
        System.exit
       （0）外界因素导致jvm退出
        4.finally 有return
        后面的语句也不会执行
        return后的值 不可以在赋值
        因为程序不能执行
        有了return 后面语句就不会执行
        一旦exit 所有的代码都不会执行
        包括主程序的代码

        finally在try之前执行 只一次
         */

        int a = 0;
        //return a;
        try {
            a = 10;
            System.out.println("try块");
            // System.exit(0);
            return a;

        } catch (Exception E) {
            System.out.println("catch块");
        } finally {
            a = a + 1;
            System.out.println("finally 块");
            return a;
        }
    }

    class AddException extends Exception {
        public AddException(String message) {
            super(message);
        }

        class AddException2 extends RuntimeException {
            public AddException2(String message) {
                super(message);
            }
        }

    }

    public static int add() throws AddException {
        int num1 = 10;
        int num2 = 20;
        int rs = num1 + num2;
        if (rs > 20) {
            //throw new AddException("相加后不能大于20");
        }
        return rs;


    }
}


/*
静态问题 ？
public static int arrayMaxElement(int[] data)throws Exception{
        if (data == null || data.length==0){
            throw new IllegalAccessException("not null and empty");
        }
        throw 是手工抛出异常用于提示或者
        手工进入 异常程序
        有了异常提示 就要处理异常
        throws 为处理异常 可以不处理
        会提示有可能有异常 特别是主函数
        会用虚拟机处理 直接终止程序
        也可以try catch 处理异常
        用于提示和处理
        并且throw 还可以跳入异常程序

 */
