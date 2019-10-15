package kt.dm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestObjectArray {

    public static void main(String[] args) {
        //动态初始化
       // Person[] persons = new Person[3];

        Person zhangsan = new Person();
        zhangsan.setAge(18);
        zhangsan.setName("张三");
      //  persons[0] = zhangsan;

        Person wangwu = new Person();
        wangwu.setAge(17);
        wangwu.setName("王五");
     //   persons[1] = wangwu;

        Person lisi = new Person();
        lisi.setAge(116);
        lisi.setName("李四");
       // persons[2] = lisi;

        //静态初始化
        Person[] persons  = new Person[]{
                zhangsan,
                lisi,
                wangwu
        };

        for (int i = 0; i <persons.length ; i++) {
            Person P = persons[i];
            String  c = P.toString();
            System.out.println(c);


        }





    }
    static class Person{

        private String name;
        private int age;

        public  int getAge(){

            return  this.age;
        }
        public  void setAge(int age){

            this.age = age;
        }
        public String  getName(){
            return  this.name;
        }
        public  void  setName(String name){
            this.name = name;
        }

        public  String toString(){
            return  "姓名"+this.name+"年龄"+this.age;
        }
    }









}
