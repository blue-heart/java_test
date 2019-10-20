package kt2.dm;





public class TestAbstract {
    public static void main(String[] args) {

        // Teacher teacher = new Ioooo();
        // System.out.println(teacher.getPersonInfo();
        Teacher teacher = new Teacher() {

            public String getPersonInfo(){
                return "匿名内部类实现的Student的抽象方法";
            }


        };
        String info = teacher.getPersonInfo();
        System.out.println(info);

    }

}
/*
抽象类
1.abstract关键字，修饰类 方法
2.抽象方法只声明，没有实现，abstract修饰
3.抽象类无法实例化对象，只能通过子类实现（非抽象类）
4.抽象类不一定有抽象方法
5.子类要继承抽象类，必须要覆写所有抽象类的抽象方法
否则子类必须定义为抽象类
6.抽象方法不能用私有修饰符修饰，
因为必须要覆写所有方法，private不能访问
abstract和private不能一起用
 */
 abstract class Teacher {

    private String name;
    private int age;

    public Teacher() {


    }


    public String getName() {

        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;

    }

    public void setAge(int age) {
        this.age = age;
    }
//抽象方法
    public abstract String getPersonInfo();
   // public  abstract  String print();
}
class Ioooo extends Teacher{
     public String getPersonInfo(){
         return "afakjf";

     }
   //  public  String  print(){
     //    return "afasf";
    // }

        }




















