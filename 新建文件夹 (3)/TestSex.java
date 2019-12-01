package kt3.dm;

import java.util.Scanner;

public class TestSex {
    public static void main(String[] args) {
       //通过 输入传参数
        // Sex sex = Sex.getInstance(args[0]);
        Sex sex = Sex.getInstance("男");


        System.out.println(sex);
    }
}
