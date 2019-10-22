package kt3.dm;

import java.util.Scanner;

public class  TestFactoryMethod {
    public static void main(String[] args) {
        Client client = new Client();
        ComputerFactory factory = new MacProComputerFactory();
        client.buyComputer(factory.createComputer());



    }

}

class Client {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }
}
/*
工厂方法模式
1.定义一个工厂接口
2.对指定类的创建一个对应的工厂类，实现工厂接口
优点：新增类型时，扩展工厂类，不需要修改工厂类
缺点：工厂选择逻辑移动到了客户端
模式没有绝对的好坏 对应不同场景
简单 无扩展使用 工厂则反
就是增加 用工厂模式更好的 不增加 用简单最好
就是oob违反最少
工厂横向扩展 加一个类 再加一个实现类
 */


interface ComputerFactory{
    //接口都是抽象方法
    //因为要子类实现
//这种定义方式 接口+方法名字
    //直接实例化好队像 就可以调用该接口的方法
    Computer createComputer();
}

interface Computer {
    /*
    打印具体的计算机信息
     */
    void printComputer();

}

class MacProCmputer implements Computer {
    public void printComputer() {
        System.out.println("mac 漂亮 好");
    }
}
class MacProComputerFactory implements ComputerFactory{
    public Computer createComputer(){
        //实际开发中 复杂业务逻辑
        //所以才这样用
          return new MacProCmputer();
          //return 没返回值也可以用
        //就像直接new一个匿名对象一样
    }
}


class SurfaceBookComputer implements Computer {
    public void printComputer() {
        System.out.println("laji  菜");
    }
}
class surfaceBookComputerFcatory implements ComputerFactory{
    public Computer createComputer(){
        return  new SurfaceBookComputer();
    }
}



