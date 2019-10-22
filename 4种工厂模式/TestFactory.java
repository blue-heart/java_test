package kt2.dm;
//传递参数和返回值没有关系

import java.util.Scanner;

public class  TestFactory {
    public static void main(String[] args) {

        //定义客户端
        Client client = new Client();
        //Computer computer = new MacProCmputer();
        //这儿又有个问题 无法静态引用？
       // Computer.printComputer();
        //里面传的是对象 必须把类实例化对象
        //因为是接口，所以直接computer
        //调用一个类的方法 就要new这个类的对象
        //或者有继承关系的队形 转型
        //client.buyComputer(computer);
        System.out.println("请输入您购买的计算机类型 ：mac surface a");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        //下面这个步骤
        /*
        因为静态方法 只要有类名就可以访问 所以可以调用
        如果你new一个对象 后面跟着一串对象实现代码
        逻辑也没有问题 可以实现 而且类内方法可以直接点
        访问  很灵活
         */
        Computer computer = ComputerFactory.createComputer(type);
        if (computer == null) {
            System.out.println("工厂没有计算机" + type);
        } else {
            client.buyComputer(computer);
        }

    }
    /*
    简单工厂模式
    1.客户端创建对象的逻辑，放到了一个静态方法中
    简单工厂类
    2.缺点：新增类型 需要修改 工程类的判断逻辑
    ocp违反 修改开启 也没办法
    3：优点：客户端和具体的接口实现类的实例独享解耦
    就是把之前一直要new对象 放到一个工厂 操作简单
     */
}

    class Client {
        public void buyComputer(Computer computer) {
            computer.printComputer();
        }
    }


    class ComputerFactory {
        //静态方法 只要用类名就可以访问
        public static Computer createComputer(String type) {
            switch (type) {
                case "mac": {
                    return new MacProCmputer();
                }
                case "surface": {
                    return new SurfaceBookComputer();
                }
                case "a": {
                    return new A();
                }
                //这儿是底下两个都得有 这是switch
                default:
                    return null;

            }

        }
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

    class SurfaceBookComputer implements Computer {
        public void printComputer() {
            System.out.println("laji  菜");
        }
    }

    class A implements Computer {
        public void printComputer() {
            System.out.println("pianyi");
        }
    }

