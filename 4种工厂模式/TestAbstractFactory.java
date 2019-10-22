package kt3.dm;

/*
优点，结合现实，各个相互组合

完全解耦 解决单一产品问题
满足ocp原则
而且 一个可以继承多个接口
更容易扩展
缺点：要在客户端修改
内容要修改
*/
public class  TestAbstractFactory {
    public static void main(String[] args) {
        //客户端代码 代码问题 现实问题
        Client2 client = new Client2();
        //只关心我要那个工厂 以下代码
        ComputerFactory2 factory = new MacProComputerFactory2();
        client.buyComputer(factory.createComputer(),factory.createComputerOS());



    }

}

class Client2 {
    public void buyComputer(Computer computer,OperationsOS os) {
        computer.printComputer();
        os.printOperations();
    }
}


interface ComputerFactory2{
   //计算机
    Computer createComputer();
    //操作系统
    OperationsOS createComputerOS();
}


interface Computer2 {

    void printComputer();

}
interface  OperationsOS{
    void  printOperations();
}
class Windows10 implements OperationsOS{
    public void printOperations(){
        System.out.println("windows 好垃圾");
    }
}

class MacOS implements OperationsOS{
    public  void  printOperations(){
        System.out.println("还不错");

    }
}

class MacProCmputer2 implements Computer2 {
    public void printComputer() {
        System.out.println("mac 漂亮 好");
    }
}
class MacProComputerFactory2 implements ComputerFactory2{
    public Computer createComputer(){
        return new MacProCmputer();
    }
    public OperationsOS createComputerOS(){
        return  new Windows10();
    }
}


class SurfaceBookComputer2 implements Computer2 {
    public void printComputer() {
        System.out.println("laji  菜");
    }
}
class surfaceBookComputerFcatory2 implements ComputerFactory2{
    public Computer createComputer(){
        return  new SurfaceBookComputer();
    }
    public OperationsOS createComputerOS(){
        return new MacOS();
    }
}

