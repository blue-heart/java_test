package com.bittech;


import java.lang.reflect.Field;

public class TestPoint {
    public static  void main(String[] args) {
       /* Point point1= new Point();
        point1.setX(10);
        point1.setY("asafsfaf");

        Point point2 = new Point();
        point2.setX(10.2);
        point2.setY(20.1);

        Point point3 = new Point ();
        point3.setX("北纬20度");
        point3.setY("东经130度");

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);

        System.out.println("通过point的getter方法获取" +
                "属性的值");
        //Object x = point1.getX();
        //属性向下转型 多态
        //这儿还可以看到是int
        int x = (Integer) point1.getX();
        //如果 属性修改类型 不是继承关系 就出错
        //转型必须是继承 运行时错误
        //编译 会解决错误，现在用不上
        int y = (Integer) point1.getY();
        System.out.println(x+" "+y);
*/
      /* Point2<String> point2 = new Point2<>();
       //传10 就错误 编译时检查 解决了刚才的错误
       point2.setX("东经30度");
       point2.setY("北纬60度");
       String X = point2.getX();
       String Y = point2.getY();
        System.out.println(X + " "+ Y);
        Point2<Integer> point3 =new Point2<>();
        //基本数据类型不可以 只能用引用数据类型
        //所以包装类型就起作用了
        //基本类型 的引用类
       // Point2<int> point4 =new Point2<>();*/
    //  Point3<String,Integer>point3 = new Point3<>();
     // point3.setX("ssss");
     // point3.setY(25);
       // System.out.println(point3.getX()+point3.getY());

        Point4 point4 = new Point4();
        //类定义类型不能变
        //方法执行一次重置一次 不会错
        // sout 就重载了好多 因为出的早
        //这个不用重载
        //point4.print("hello word");//T=>
        // String
        //point4.print(22);//T=> Integer

       // System.out.println(point4.getInfo("hello"));
        //T =>String
       // System.out.println(point4.getInfo(new
        // Point()));
        //T = > point2
       // Point4<Integer> point41 =new Point4<>();
       // point41.setX(25);
        //写而不调 也对
       // point41.setY(32);
        //System.out.println(point41.getX());

        //point41.getInfo("asds");
       // point41.getInfo(52);

        //要么tostring 要么.getter setter
        //两种方式 获取数值
        Point4<Integer> point41 = new Point4<>();
        point41.setX(10);
        Point4<Double> point42 = new Point4<>();
        point42.setX(22.2);

        Point4 point43 = new Point4();
        //此时开了一个对象取默认值

      //  point43.setX(new Object());
        /*
        javac <Integer><String>
        java Object x
        Obiect.getclass
        返回实例化当前对象的类型
        用于验证类型是否被擦除
        都会变成Object类的对象
        Object的类型
         */
        System.out.println(point41.getClass());
        System.out.println(point42.getClass());
       // System.out.println(point43.getClass());

        //初步认识反射
        //获取 对象的所有类型属性
        //如果指定上限 类型擦除会变成上限类型
        //super 不在类上 所以 不存在
        //这儿有个导入包的问题
        /*Fipeld[] fields = (Fipeld[]) point41.getClass().
                getDeclaredFields();
        for (Field field:fields
             ) {
            System.out.println(field.getName+field.getType);*/

        }
    }


  class Point{

    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    private Object x;
    private  Object y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y; }
}


