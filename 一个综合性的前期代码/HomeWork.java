package zy.dm;

import sun.dc.pr.PRError;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class HomeWork {
    public static void main(String[] args) {
        // Coods coods = new Coods("APPLE",
             //   888.5,2);
       // System.out.println(coods);

        //1.订单
        Order order = new Order();
        //2.商品
        /*
        本来要数组拷贝 但是
        过于复杂 先定义3个
        直接构造方法new数组
        可以传3次
        定义容量
         */
        Coods[] goodsArray = new Coods[3];

        //相当于定义数组 然后传值
        //setter用于外界获取值 也可以 外界调用自己
        //修改
        //order.setGoodsArray(goodsArray);



/*
打印输入提示
scanner 输入
反复输入 用while 循环
次数已知 用for

给输入的加空格
静态初始化

 */
//这个scanner有且只有一个
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <goodsArray.length; i++) {
            System.out.println("请输入商品的信息格式如下");
            System.out.println("商品名称 商品价格 商品数量");
            //line 用空格结尾
            //nextline用回车结尾 注意开始别按回车
            String line = scanner.nextLine();
            String[] segments = line.split(" ");
           // System.out.println(segments.length+segments[0]);
            //这儿才给数组赋值 一共三次
            //这儿就是给构造方法 赋值3次
            //并且保存
            goodsArray[i] = new Coods(segments[0],
                    Double.parseDouble(segments[1]),
            Integer.parseInt(segments[2]))
            ;
            //默认调用 tostring方法
            System.out.println(goodsArray[i]);


        }
        //3.折扣
        System.out.println("请输入1-9的整数：");
        //读个内容
        String discountStr = scanner.nextLine();
        //这人因为生活需求才进行修改
        order.setDiscount(Integer.parseInt(discountStr));
        Double totalPrice = order.gerTotalPrice();
        System.out.println("总金额为："+totalPrice);
        System.out.println("请输入支付金额：");
        String paystr = scanner.nextLine();
        order.setPay(Double.parseDouble(paystr));

        //4.打印订单
        //默认调用tostring
        //而且代码块 两个都看不到彼此的tostring
        //而且都能调用共用方法
        //需要什么样的数值 调用什么样的方法
        //因为数值需要用户自定义
        //所以用setter 这就是面向对象
        //而前面的是用构造方法传递参数
        System.out.println(order);




    }
}
/*
抽象一个订单
里面充分体现代码块的作用
名字可以重复 属性方法
构造方法只是传递一个参数
如果不穿参数 可以仅仅提供set类修改
即可 new对象 和setter 普通类
也可以 setter只是为私有属性服务
 */
class Order{


    /*
    折扣
    支付
    商品信息
     */
    private Integer discount = 10;
    private  Double pay;
    //定义了一个类的数组类型
    //这儿可以修改 构造传递的参数
    //这人说明数组前面的类型必须是类
    //后面随便起名
    //而且会把 那3组数据
    //必须有这个属性 因为底下set的属性要声明
    //后面传递的是参数名字 随便写
    //属性要声明
    private Coods[] q;
//    要提供set方法进行修改
//
    public  void  setDiscount(Integer discount){
        this.discount = discount;
    }
    public void  setPay(Double pay){
        this.pay = pay;
    }
    //外界的数组定义的传进来
    //进行修改变量q
    //就是接受了一个数组
    //下面方法调用的q
    //这就是 用代码控制逻辑
  public  void setGoodsArray(Coods[] a){
     this.q = a;
 }
    //打折之后的总金额
    public Double gerTotalPrice(){
        Double total = 0.0;
        for (int i = 0; i <q.length ; i++) {
            total+= q[i].getToPrice();

        }
        return  total*this.discount*0.1D;
    }
    //找钱
    public Double getGiveChange(){
        return this.pay-this.gerTotalPrice();
    }
    public String toString(){
        //必须有个对象才能连接
        StringBuilder sb = new StringBuilder();
        sb.append("***********消费单***********")
                .append("\n")
                .append("名称\t单价\t数量\t金额")
        .append("\n");
        //this表示 order 也可以不写
        for (int i = 0; i <this.q.length; i++) {
            //这儿才是 调用哪个tostring
            //这儿有注意点 方法是tostring
            //调用tostring 是调外面的
            sb.append(this.q[i].toString())
            .append("\n");
        }
        sb.append("\n")
                .append("------------------------")
                .append("\n")
                .append("折扣 ：").append(this.discount)
                .append("折").append("消费总金额").
                append(this.gerTotalPrice())
                .append("\n")
                .append("实际消费金额").append(this.pay).append("找零")
                .append(this.getGiveChange()).append("本次消费积分")
                //intvalue 可以把double 变为int 去掉小数
                .append(this.gerTotalPrice().intValue());
        //这个return是 返回的 如果信息都不一样返回这个
        //如果 执行错误 才返回下面的return
        //return的一个作用
        return sb.toString();
    }
}
/*
bigdecimal 用于算钱 是double的方法
商品类 名称 价钱 个数
声明属性

构造传参 3个参数

提供一个 价钱数量的积方法

提供get方法 要访问 直接提供
tostring 拼接好返回 不用获得参数
再自己拼接 可以用stringbuilder直接
拼接
 */
class Coods{
    //同一个类内，可以使用私有属性
    private String name;
    private  Double price;
    private  Integer number;

    public Coods(String name,Double price,Integer number){
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public Double getToPrice(){
        return this.price*this.number;
    }
    public String toString(){
        //stringbuilder
        return this.name+"\t"+"$"+
                this.price+"\t"+this.number+"\t"
                +this.getToPrice();
    }
}
