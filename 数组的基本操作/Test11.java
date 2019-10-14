package cv.dm;

public class Test11 {


    public static  int sum (int[] temp){
        int a = 0;
        for (int i = 0; i <temp.length ; i++) {
            a = a + temp[i];

        }
        return a;

    }



    public  static  int  ave (int[] temp){
        int b = sum(temp);
        return b/temp.length;

    }



    public static void main(String[] args) {

        int [] data = new int[]{1,2,3,4,5,6,5};
        System.out.println("综合"+sum(data));
        System.out.println("平均值" + ave(data));



    }
}
