package kt.dm;

import org.omg.CORBA.PUBLIC_MEMBER;
//静态内部类

public class TestInnerClass2 {
    public static void main(String[] args) {
        Puter.Inner inner = new Puter.Inner();
        inner.print();

    }
}
//外部类
class  Puter{
    private  static String message =  "outerde ";

    //静态内部类
    /*
    1.static修饰
    2.静态内部类不能访问外部类的非静态属性和方法,只能访问静态的属性
    3.静态内部类使用
    4.可以有静态属性和静态方法
    Puter.Inner inner = new Puter.Inner();

     */
    static  class Inner {
        public void print() {

            System.out.println("STATIC");

        }
        //静态方法
        public static  void  print(int a){
            System.out.println(a);
        }
    }
    //这个和非静态一样，两种方式
    public  void print(){
        Inner inner = new Inner();
    }




}
