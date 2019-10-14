package cv.dm;

import java.util.Arrays;

public class Test10{


    public static void main(String[] args) {
        int[] dataA = new int[]{1,2,3,4,5,6,7,8,9} ;
       int[] dataB = new int[]{11,22,33,44,55,66,77,88,99} ;
        System.arraycopy(dataB,4,dataA,1,3) ;
        printArray(dataA) ;
        System.out.println();
        int[] result = Arrays.copyOf(dataA,dataA.length*2);
        printArray(result);
        System.out.println();
       dataA = Arrays.copyOf(dataA,dataA.length*2);
       printArray(dataA);
    }
    public static void printArray(int[] temp) {
        for (int i = 0 ; i<temp.length ; i++) {
            System.out.print(temp[i]) ;
            if (i<temp.length);
            System.out.print(',');
        }
        System.out.println() ;
    }
}
