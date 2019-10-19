package kt.dm;

public class TestInnerClass3 {
    public static void main(String[] args) {
        Outter out = new Outter();
        out.display(20);
    }
    static class Outter {
        private int num;//加static也可以访问
        public void display(int test) {
            //方法内部类-局部内部类
            // （在方法里面，所以只能作用到方法，不用修饰）
            //jdk8之前，final int a=10 之后直接a=10 只要访问 隐式添加final
            int a=10;
            //如果要修改final的a
            // （此时b成final，a就不是了）
            // (编译可以通过)(这是一种方法，编译器推导出来的)
            int b = a;

            class Inner {
                private void fun() {
                    num++;
                    System.out.println("outer的成员方法"+num);
                    System.out.println(test);
                    System.out.println(b);
                }
            }
            a=100;
            System.out.println(a);
            new Inner().fun();//（在类内，隐式有个this）
        }
    }



}

