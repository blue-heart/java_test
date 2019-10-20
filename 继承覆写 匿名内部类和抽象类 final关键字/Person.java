package kt2.dm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.text.DefaultStyledDocument;

public class Person {
    private String name;
    private  boolean gender;
    public String info = "PERSON info属性";
    {
        System.out.println("这是person的构造块");
    }

    /*public Person(){
        System.out.println("这是person的构造方法");


    }*/

    public  Person(String name,boolean gender){
        System.out.println("这是person的有参构造方法");
        this.name = name;
        this.gender = gender;



    }
    public String getName(){
        return this.name;

    }
    public  void  setName(String name){

        this.name = name;
    }

   public boolean isGender(){
        return this.gender;

    }
    public void info(){

        System.out.println("这是父类的info方法");

    }


        public  static void  print(Person person){
          person.info();
    }

    public static void main(String[] args) {

       /* Student student = new Student("张三",true );
       student.setName("张三");
        student.setSchool("西科大");
        student.setNumber("1234567");
        System.out.println("姓名："+student.getName()+"学号："+student.getNumber());
        student.info();
       Person person = new Person("张三",true);
        //System.out.println(person.info);
        System.out.println(student.info);*/
       //向上转型：这个是很合理的，向下参考这个
       //Person person = new Student("ZHANGSAN",true);
       //person.info();

        //向下转型
        //classcastexception问题(执行异常) 指的不是自己 转不了
       //Student student = (Student) new Person("ZHANGSAN", true);
       //student.info();
       // Person person  = new Student("DAAD",true);
        //Student student = (Student) person;//右边的类型必须是自己类型或者子类类型
        //没有（student）编译错误
        //否则强转 因为student真正指向 student

        /*Person person = new Person("SFAJF",true);
        print(person);
        Student student = new Student("ASFHA",false);
        print(student);*/
        //person对象是student实例化的ture
        //这个时候就不会抛异常
        //通过程序的方式杜绝了抛出异常
        //因为你根本不知道两个类是射门关系哦
        //这样就可以让程序编写的过程知道
        Person person = new Student("SHAJ",false);
        if(person instanceof Student){
            Student student = (Student) person;
            System.out.println("person对象可以转化为student对象");

        }else {
            System.out.println("person对象无法转化为student对象");
        }

    }
}
/*
继承
1.extends 继承关键字 exteds 父类名称
2.单继承 extends 只能有一个父类
3.如果父类无默认构造方法，子类必须提供有参构造方法，参数多或者参数一样
4.子类五参数构造方法调用，隐式调用了super；
5:super是调用父类的构造方法，super（参数列表），先调用父类，再子类；
父类：超类 子类：派生类
覆写
1.继承关系中
2.子类定义和父类相同的属性和方法
3.方法名，参数列表相同，子类访问权限大于父类
4.子类覆写父类方法，要保留功能用suoer'.方法名（参数列表）
5.属性覆写 用谁调谁 ，自用父 ，super
规避这种问题
 */
   class Student extends Person {


    {

        System.out.println("这是student的构造块");
    }


    public Student(String name, boolean gender) {
        //super();
        super(name, gender);
        System.out.println("这是syudent的有参构造方法");

    }


    private String number;

    public String info = "student info属性";





    public String getNumber() {

        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;

    }

    private String school;

    public String getSchool() {

        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /*public String toString() {
        子类要访问父类的的成员属性，需要具备访问权限
        getter setter
        私有属性 不能访问 但是公开的可以 而且 setter
        getter 可以 可以间接访问私有属性
        可以访问内部私有属性 直接 this.属性
        return   this.name;
    }*/

    public void info(){
        //super.info();//调用父类的info方法
        //因为父类方法不用了，要用就得这样

        System.out.println("这是子类的info方法");


    }




}

