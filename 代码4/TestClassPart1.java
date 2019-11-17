package com.bittich2;






import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestClassPart1 {
    public static void main(String[] args)   {
        /*
        获取父类信息
         */
        /*Class classz = Message.class;
        //获取类的包名
        Package pg = classz.getPackage();
        //获取包名
        System.out.println(pg.getName());
TestClassPart1
main(String[]): void
IMessage
OperatorSystem
A
Message
Object
Message()
Message(String, Integer)
Message(Integer, String)
name: String
age: Integer
Person2
Object
Person2()
Person2(String, Integer)
greetInfo(): String
        //打印 包+包名
        System.out.println(pg.toString());
        //获取类的名称
        System.out.println(classz.getName());
        //包名+类名 = 类的全限定名

        //类名
        System.out.println(classz.getSimpleName());
        //父类
        //返回一个 单继承
        //这个类型要和后面一样 前面也为class类
       Class superClass = classz.getSuperclass();
       //如果有直接继承 返回直接继承类
        //否则返回object类
       //父类名字
        System.out.println(superClass.getName());
        //父类包名
        System.out.println(superClass.getPackage().getName());
        //接口
        //两个接口 所以 用数组
        Class[] interfacesClass = classz.getInterfaces();
        for (Class cls:interfacesClass
             ) {
            System.out.println(cls.getName());

        }*/


       /* //实例化对象
        //但是 是用classz 表示message
        Class classz = Message.class;
        //获取classz的所有构造方法
        Constructor[] constructors = classz.getConstructors();
        for (Constructor constructer: constructors
             ) {
           // System.out.println(constructer.getName()+
                    //数组没有覆写tostring 打印哈希码
                    // 打印哈希码 变成tostring没有用  是地址码
                    //constructer.getParameterTypes());

            1.遍历数组 通过stringbuilder拼接
            2.Arrays


            //为什么按顺序打印 因为foreach
           Class[] parmenterTypes = constructer.getParameterTypes();
            String parameters  = Arrays.toString(parmenterTypes);
           System.out.println(constructer.getName()+
                    parameters);

    }
        //获取指定的构造方法
        //编译时不知道 你有没有这个
        //可能会找不到 因为这是你自定义的
        //凡是自定义的 有可能找不到 要抛出异常
        //看下面 因为要一个构造方法 所以左边是 构造方法类型
        //记住代码块外除了类内new对象 其他创建的属性
        //外面看不到 比如constructor 最下面就看不到
       /* try {
            Constructor constructor =  classz.getConstructor(String.class,Integer.class);
            System.out.println(constructor);
            //通过构造方法对象 实例化对象
            //底下就是message的对象 用classz 打印 的是
            //message类的对象
           Object object =  constructor.newInstance("fafs",25);
           Message message = (Message)object;
            System.out.println(object.getClass());
            System.out.println(message);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

       //通过class对象获取方法
     /*   Class classz = Person2.class;
        Method[] methods =classz.getMethods();
        for (Method meyhod:methods
             ) {
            //打印方法 object的方法也打印
            System.out.println(meyhod.getName()
                    +Arrays.toString(meyhod.getParameterTypes()));
            //抛出异常 有可能找不到 自定义错误


        }

            try {
              //接收类型 要是这样
                //返回值是void 就返回null
               Method method= classz.getMethod("setName", String.class);
                Person2 person2 = new Person2("ASD",25);
                //要对象才能调用
                //两个异常
                //通过反射的方式调用方法
                Object returnValue = method.invoke(person2,"tom");
                System.out.println(returnValue);
                //上面这个不能调用tostring 所以要下面 替身
                System.out.println(person2);


            }catch (NoSuchMethodException e){
                e.printStackTrace();
                //调用目标有问题
            } catch (IllegalAccessException e) {
                e.printStackTrace();
             //非法访问
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }*/
     //获取属性
            //属性赋值
        //直接赋值 构造块 构造方法
        //有final 赋值完不能修改
        Student student = new Student();
        student.setName("jack");
        student.setAge(25);
        student.setSkill("chifan");
        Class studentClass = student.getClass();
        //获取父类的属性（字段）
       /* Field[]  fields = studentClass.getFields();
        for (Field filed:fields
             ) {
            //获取父类公开的
            System.out.println(filed.getName()+filed.getType());

        }
        //找不到 自定义
       try{  Field nameFiled = studentClass.getField("age")  ;
            System.out.println(nameFiled.getName()+nameFiled.getType());
}catch (NoSuchFieldException e){
            e.printStackTrace();
        }*/
        //java.lang.NoSuchFieldException: age 私有属性获取不到 就会异常

       //获取当前类
        //不管公开还是私有都可以获取到
        Field[] field = studentClass.getDeclaredFields();
        for (Field filed:field
             ) {
            System.out.println(filed.getName()+
                    filed.getType());

        }
        try {
            Field  fileds1 = studentClass.getDeclaredField("skill");
            System.out.println(fileds1.getName()+fileds1.getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //获取student对象的skill属性


    }



    }

interface IMessage{

}
interface  OperatorSystem{

}
class A{

}
class Message extends A implements IMessage, OperatorSystem{
    private String name;
    private  Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Message(){

    }
    public Message(String name,Integer age){
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //参数顺序不同
    public Message(Integer age,String name){
        //调了个顺序
        this(name,age);

    }

}
class Person2 {
    private String name;
    private Integer age;

    public Person2() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String  greetInfo(){
        return this.getName();
    }
    public void printPersonInfo(){
        System.out.println(this.toString());
    }
}
 class Student extends Person2{
private String skill;
private  String mobilePhone;
public  Boolean gender;

     public String getSkill() {
         return skill;
     }

     public void setSkill(String skill) {
         this.skill = skill;
     }

     @Override
     public String toString() {
         return "Student{" +
                 "skill='" + skill + '\'' +
                 '}';
     }
 }
