package kt.dm;

public class TestInnerClass4 {
    public static void main(String[] args) {
        //没有class 类名
        //没有构造方法，有默认的，但是自己不能写
        //不能有静态属性，方法，没有类名怎么访问
       /* Chat chat=new Chat(){
            public void  sendMessage(){
                System.out.println("匿名内部类方法执行");
            }
        };
        chat.sendMessage();*/
       int a =10;//final和方法内部类一样
       new Chat(){
           public void sendMessage(){
               System.out.println("oo");
           }
       }.sendMessage();
    }

}

/*
1.匿名内部类：除了方法内部类的特点外
2.必须继承一个抽象类或者一个接口；
3.没构造方法（连类名都没有，哪儿来的构造方法）
 */
interface Chat{
    //接口是public

    void sendMessage();
}
