package kt3.dm;

public class TestSingLetion {
    public static void main(String[] args) {
        //开栈并且 调用静态方法
        //而且静态方法中返回一个固定值
        //这样就是只有一个对象
        SingLeton singLeton1 = SingLeton.getInstance();
        SingLeton singLeton2 = SingLeton.getInstance();
        System.out.println(singLeton1==singLeton2);

    }
}
