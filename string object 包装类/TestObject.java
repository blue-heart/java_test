package kt3.dm;


//命名千万不要重复 否则会有很多麻烦
//代码的顺序性
//加号除了在字符串连接 其他都是运算符

import sun.dc.pr.PRError;

public class TestObject {
    public static void main(String[] args) {


        //Person6 p1 = new Person6("SDSA",23);
        // Person6 p2 = new Person6("SDSA",31);
        //System.out.println(p1==p2);//false
        // System.out.println(p1.equals(p2));
        //向上转型
        // Object object = new int[]{1, 2, 3};
        //向下转型
        //int[] intArray = (int[]) object;
        //for (int i = 0; i < intArray.length; i++) {
        //   System.out.println(intArray[i]);
        //  }
        //任意类型对象
        //又是无法静态引用
        // A c = new B();
        // Object obj = c;
        //Object obj = 15;
        // int a = (int)obj;
        //包装类
        //int b = 10;
        //包装了一下
        //包装 装箱
        // IntWapper intWapper =new IntWapper(b);
        // Object object =intWapper;
        //刚才说到的 方式 就这
        //IntWapper intWapper2 =(IntWapper) obj;
        //拆除包装 拆箱
        // int c =intWapper2.getValue();
        //可以给每一种数据类型提供一个包裹类
        //jdk提供好了 如下
        //装箱和 拆箱
        //属性的对象 也是属性的地址 这里
        //只要是new 就是地址 和 对象
        //integer.max_value 最大值
        /*Integer num = new Integer(25);
        int value = num.intValue();
        System.out.println(num);
        System.out.println(value);
    }*/
        //Integer a = 5;
        //自动装箱
        //自动拆箱
        //System.out.println(++a);
        /*
        1.eauals int value
        2.new Integer() 比较地址
        3.自动装箱 隐式new==比较地址
        4.valueof 15 true 666 false
        //默认情况下 int【-128，127】
        通过valueof 获取缓存对象 地址一样
        提前保存好的 超出范围 重新new对象
        为了提高效率 而缓存 也可以通过代码
        来优化 自己扩大范围 人家是自定义范围
         */
        Integer num1 = new Integer(10) ;
        Integer num2 = new Integer(10) ;
        Integer num3 = Integer.valueOf(15);
        Integer num4 = Integer.valueOf(15);
        Integer num5 = Integer.valueOf(666);
        Integer num6 = Integer.valueOf(666);
        Integer num7 = 666;
        Integer num8 = 666;
        System.out.println(num1 == num2);//false
        System.out.println(num1 == new Integer(10));
        System.out.println(num1.equals(new Integer(10)));
        System.out.println(num1==num3);
        System.out.println(num3==num4);
        System.out.println(num5==num6);
        System.out.println(num5==num7);
        System.out.println(num7==num8);
    }
}
    /*class IntWapper
    {
        private int value;
        //构造方法传参数
        public IntWapper(int value){
            this.value =value;
        }
        public int getValue(){
            return this.value;
        }

    }







        /*
        1.引用数据类型
        2.jdk 提供的string'(自带)
        3.car student person 用户自定义
        4.jdk object 所有类的父类


        String str = new String("hello word");
        //构造方法传值
        Person6 person6 = new Person6("zhangsan",22);
        Car car = new  Car();
        Student student = new Student("aaff",55);
        print(student);
        print(person6);
        //print(car);
        //print(str);
        */


   // public static void print(Object object) {
    //基本数据类型可以直接
        //这儿得有 这个方法 传递Object对象
    //这个不得不得有
        //引用类 都是对象接收


        //System.out.println(object);
        //string打印 tostring字符串
        //相当于string覆写了 object的string方法
        //其他打印哈希扣得

    //}

   /* interface A {

    }

    class B implements A {

    }*/
//}








/*class  Person6{
    private String num ;
    private  int age;
    //用于传值 对象
    public Person6(String num,int age){
        this.num = num;
         this.age =age;
    }

   // person继承了object 覆写tostring
   // 不覆写打印出哈希码
   // 字符串覆写过 返回this 打印自己
    //打印调用tostring子类

    //public String toString(){
       // return this.num+this.age;
    //}
    public String getNum(){
        return this.num;
    }
    public int getAge(){
        return this.age;
    }

   // equals 在字符串中比内容
    //person类中equals比名字


    //如果this=null 空指针 方法没人调
   // 如果没覆写 比较对象的属性（多个）
    //比较是不是同一个 地址
    //instanceof前面可以为null 是null就
     //return false
    public boolean equals(Object that){
        if (this==that){
            return  true;
        }
        if (that instanceof Person6){
            Person6 thatPerson = (Person6)that;
            //这儿用的是string的eequals
            //这个thstperson不是对象 所以要调用get
            //右边的类是自己的子类类型
            //向下转型 自己的覆写类
            //相当于 覆写自己 相当于继承 所以不可见
            //自己的方法 必须 直接向下转型
            //但是相当于还在类外
            //向下转型 一是统一客户端，二是如果
            //要调用父类的 属性 仍然要get set
            //因为只有一个this
            //重点：向上转型 因为子是父的衍生
            //而且都有独自的方法 要调用必须转型
           return this.num.equals(thatPerson.getNum());
                  // &&this.age==thatPerson.getAge();
        }
        //不用else
        return false;
    }

}
class  Car{

}
//class  Student extends Person6{
   // public  Student(String name,int age){
     //   super(name,age);
    //}
   // public String toString(){
    //    return "fafafafakl";
 //   }

//}*/

