package kt2.dm;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestFinal {
    public static void main(String[] args) {

    }


}
/*
1.fainl 修饰类，不能被继承
2.final 修饰的方法，不能被覆写
3.final修饰的而变量，不能被再次赋值
4.static final 修饰的属性，常量，大写单词下划线分割
5.final修饰的属性，必须初始化
 声明并且赋值（静态 非静态 都可以）
 构造传参数（仅限于成员属性，非静态）
 代码块（构造快，成员属性，静态代码块,常量）
 因为static先执行 构造快还没有加载 所以错误
 */

class A{

   // private final  int age=10 ;
   /* private  final  int age;

    public A(int age){
       // this.age =age;
       不能再次赋值*/

   /*private  final  int age;
    {

        age = 10;
    }*/
   private  static  final  int A;
   static {

       A = 10;
   }



    }






