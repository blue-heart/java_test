package cv.dm;


import java.util.Arrays;


public class  Test{



    public static void bubbleSort(int[] array){
        long start = System.currentTimeMillis();
        //趟数
        for (int i = 0; i < array.length-1 ; i++) {
            //boolean swap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //swap = true;


                }

            }
            //if(!swap){
            //break;
        //}

        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    public static void main(String[] args){
        //int[] array = {12,4,7,2,1,9};
        int[] array = new int[10000];
        for (int i = 0; i <array.length ; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));


    }




}