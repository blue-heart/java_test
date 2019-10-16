package cn.dm;

public class Person{
    //false:女 true：男
    private boolean gender;

    private String name;

    private int age;
    //身高
    private int height;
    //构造方法
    public Person(boolean gender , String name){
        this.gender = gender;
        this.name = name;

    }

    //main方法进行测试
    public static void main(String[] args){
        Person zhangsan = new Person(true,"张三");

        Person lisi = new Person(false,"李四");

        System.out.println(zhangsan.getName());
        zhangsan.eat();
        zhangsan.think();

        System.out.println(lisi.getName());
        lisi.eat();
        lisi.think();




    }



    //行为
    public void eat(){
        System.out.println("吃 食物链顶端");
    }

    public void think(){
        System.out.println("人。是有思考力的");
    }
    //访问的属性
    public String getName(){
        return this.name;
    }

    public void setHeight(){
        this.height = height;

    }

    public void setAge(){
        this.age = age;

    }


}



