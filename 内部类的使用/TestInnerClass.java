package kt.dm;


//成员内部类

public class TestInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();

        //如何创建Inner对象
        Outer.Inner inner = outer.new Inner();
        outer.print();
    }






}
/*
Inner 类 内部类
Outer 类 外部类
 */

class  Outer{
    private String message;


    /*
    外部类访问内部类
    1.在外部类实例化内部类的对象
    2.通过外部类的构造方法传一个内部类的对象
     */
//在内部类中用外部类.this 就是外部类的对象
    class  Inner{
        private  String message = "inner";
        private  static  final int VALUE =2;
        //成员方法
        public  void  print(){
            /*
            1.成员内部类（再次封装）：可以直接访问外部类的成员属性（隐式有一个外部类对象，静态内部类没有)
            2:内部类实例化Outer.this.外部类的成员属性（可以防止外内部同时有这个属性产生访问冲突）
            内部类实例化：
             Outer outer = new Outer();
             Outer.Inner inner = outer.new Inner();
             3.成员内部类（非静态内部类）不能有静态属性和方法
             4.static final 属性 常量可以修饰

             */

            System.out.println("内部"+message);

        }


    }
    public  void  print(){

        System.out.println("外部");
        //外部访问内部类的方法必须new内部类的对象
       Inner inner = new Inner();
         inner.print();
    }
    public  void  print(Inner inner){

        System.out.println("外部");
        //外部访问内部类的方法必须new内部类的对象

        inner.print();
    }




}
