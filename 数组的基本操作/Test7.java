package cv.dm;

public class Test7{
    public static void main(String[] args) {
        int[] data = new int[] {1,2,3,4,5} ;
        printArray(data) ; // 其效果等价于 int[] temp = data ;
    }
    public static void printArray(int[] temp) {
        for (int i = 0 ; i<temp.length ; i++) {
            System.out.println(temp[i]) ;
        }
    }
}