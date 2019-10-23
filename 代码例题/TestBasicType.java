package zy.dm;

public class TestBasicType {

    public  static  void  test(){
        byte b1 =1,b2=2,b3,b6,b8;
        final byte b4 = 4,b5=6,b7=9;

        b3=(byte) (b1+b2);//要强制转换int 到byte
        b6=b4+b5;//final修饰常量 就是byte类型
        b8=(byte) (b1+b4);
        //b7=(b2+b5);final不可以修改
        System.out.println(b3+b6);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = a>b?a:b;
       //如果没有返回值类型 必须新建一个数放进去
        // 和new一个道理
    }
}
/*
有double 和float 和整形 转为小数
float 和doub了转double
有long 转long 结果为long
（byte short int char ）两束相加 为int 结果为int
final修饰不会变
 */