package kt3.dm;
//这里又说到了构造方法传递参数的
//重要性

public class TestProxy {
    public static void main(String[] args) {
        //面向接口编程
        //为什么写的这么复杂
        //1.面向对象 2.企业级开发地位很重要
        //这个就是客户端操作简单一个值的处理
        //盖楼 写软件（不可见，代码太多，所以就有一个
        // 统一的入口）（a分析 d设计 p编码）
        //底下 继承类名字改变 也没事
        //主类控制 这也是多态
        Subject realsubject = new RealSubject();
        System.out.println("扩展之前的业务");
        realsubject.buyComputer();
        System.out.println("扩展之后的业务");
        //有构造方法 所以要传参数
        //1.构造可以传参
        //2.*有了构造必须传参数*
        //不用修改代码 就是扩展了一下
        //bug率会减少
        //要传一个subject的的对象
        Subject proxySubject  = new ProxySubject(realsubject);
        proxySubject.buyComputer();
        //需求：1.调研，听取客服的讲解
        //2.买还是不买
        //3.售后
        //如果你此时人家提个需求 你就要改代码
        //但是通过这种方式 就不用修改 逻辑很严密
        //这就是逻辑的严密性 设计
        //不需要修改 时间一到 自动修改
    }
}
/*
代理设计模式（补救模式）
比如买电脑要多少时间 本来要新建
代理类 可以做到 就是拓展
1.提供一个接口，定义业务功能
2.真正的业务类，实现接口
3.扩展真正的业务类，提供一个
代理类，实现接口 具有一个接口
类型的成员属性（真正业务的实例化对象）
在业务功能中调用正在的业务类的方法或者增加
业务逻辑
4.1.创建真正的业务类
 2.创建代理类的对象，构造方法传入业务类的
 对象
 3.使用代理类的对象，调用业务功能
 5.举例
 Subject 代理接口
 RealSubject 业务类 业务对象 被代理对象
 ProxySubject 代理类 代理对象

 */
interface  Subject{
    /*
    买电脑
     */
    void  buyComputer();

}
class RealSubject implements Subject{
    public  void buyComputer(){
        System.out.println("购买电脑");
    }
}
//代码尽量不要拷贝 要复用ooa
class ProxySubject implements  Subject{
    //定义一个接口对象
    //只要对象由subject定义的 就调用
    //声明对象是subject接口
    //private Subject target;
    //构造方法传一个对象
    //这儿要声明一个 对象，不然找不到Subject
    // 的属性target
    private Subject target;
    public ProxySubject(Subject subject){
        //右边只是参数，左边是属性要声明
        this.target = subject;
    }
    public void buyComputer(){
        System.out.println("调研，听客服的简介");
        //原有的业务
        //这儿就是this强调属性
        this.target.buyComputer();
        System.out.println("享受售后服务");
    }
}
