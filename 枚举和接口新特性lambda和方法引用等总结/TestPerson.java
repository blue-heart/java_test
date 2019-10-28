package com.bittech;

public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("ddd");
        person1.setAge(28);
        //利用枚举 可以减少对象的创建
        person1.setGender(Gender.MALE);
        System.out.println(person1);
        switch (person1.getGender()){
            case MALE:
                System.out.println("nan");
                //break 结束下面语句
                break;
            case FEMALE:
                System.out.println("nv");
                break;
                default:
                    System.out.println("no");
        }

    }
}


class Person{
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    private String name;
    private  Integer age;
    //private  boolean gender;
    //这样用枚举更好
    private Gender gender;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
enum Gender{
  //因为 里面有一个构造传参
    //所以 常量要有对应的参数
    MALE("nan"), FEMALE("nv");
    private String mark;
    Gender(String mark){
        this.mark = mark;
    }
}