import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestColor2 {

//有些方法 是关键字自带方法 可以直接调用
    public static void main(String[] args) {
        //获取下标是按照你定义的顺序的 容易修改
        //不要作为参考对象
        int index = Color2.GREEN.ordinal();
        System.out.println(index);
        System.out.println(Color2.RED);
        System.out.println(Color2.BLUE);

        Color2 blue = Color2.BLUE;
        Color2 blue2 = Color2.BLUE;
        System.out.println(blue==blue2);
        Color2[] color2s = Color2.values();
        for (Color2 color2:color2s
             ) {
            System.out.println(color2.getTitle()+color2.toString()+
                    color2.name() +color2.ordinal());

        }
        Color2 blu = Color2.valueOf("BLUE");
        System.out.println(blu);
        //会提示运行错误
        //运行错误不会执行下面的语句
        Color2 B = Color2.valueOf("yfyf");
        System.out.println(B);
        //获取父类是谁
        System.out.println(Color2.class.getSuperclass());
        //这个继承 所以 实例化直接赋值
        //和之前的 实例化赋值一样
        IClor iClor = Color2.RED;
        //属性看左边的类型 参数在右边
        //子类直接赋值 父类强转
        //Color2 extends Enum implents IColor
        //所以只可调用 接口的方法
        //接口不可调用 Enum 没关系





    }
}
/*
枚举类：
1.枚举是特殊的类，使用enum关键字修饰
2.枚举类中定义常量，类型是枚举类的类型
,枚举常量，通过枚举类.常量名访问
3.枚举类不能通过new实例化对象
构造方法私有
5.任何地方使用同名的枚举常量时
他们是同一个对象（== 比较的是对象
，对于引用数据来说，串联起来了）
6.通过枚举类的values静态方法获取
所有的枚举常量
7.枚举常量 name（） 获取常量名
ordinal（）获得下标，开发不要依赖
这个值 容易修改 容易出错
除非你定义好红色 是1 黄色是2 再定义
就不能用这个数字
8.通过枚举类的  vlaueof 静态方法
参数传入枚举类常量的名称，获取枚举常量
（对象）如果不存在 抛出异常（运行时异常）
非法参数异常ILLIArgumenE
9.枚举类（隐式）继承 java.lang.Enum
抽象类，因此不会继承
其他类
10.枚举类可以实现接口
枚举也是一种可以继承的类型了
引用类
11.switch 支持枚举
jdk1.7 switich也支持String
*/
interface IClor {
        void printValue();



}


//是特殊类
//得满足类的基本要素
//成员信息
//如果接口在下面代码从前到后的
//顺序 会找不到
enum Color2 implements IClor {
    BLUE("蓝色"), GREEN("绿色"),
    RED("红色")//这儿可以随便添加属性
//比较方便 不用修改代码
//添加无害
//4.一旦定义了构造方法
//就要指定成员属性的值
//RED,GREEN,BLUE;
    ;

    private String title;
    //底下这些方法都是ok的

    public String getTitle() {
        return title;
    }


    public String toString() {
        return "Color2{" +
                "title='" + title + '\'' +
                '}';
    }

    Color2(String title) {

        this.title = title;
    }


    public void printValue() {

    }



    //虚拟机生成好的 在写就会错误
  /* public static Color2[] values(){
        return  new Color2[]{RED,GREEN,BLUE};
   }*/

}