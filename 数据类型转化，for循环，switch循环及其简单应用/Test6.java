package cv.dm;

public class Test6 {
//从大到小，递归
public static void main(String[] args) {
    System.out.println(sum(100));
}
    public static int sum(int num){
        if (num == 1) {
            return 1;
        }else {
            return num+sum(num-1);
        }
    }



}
