package py.dm;

import java.util.Arrays;
import java.util.Random;

/*
时间复杂度n*n-1
o（n^2）
空间复杂度o（1）
如果给定的数据是有序的数据，那么时间复杂度
就是o（n）
直接插入排序：越有序 越快
稳定性：因为break的缘故
是稳定性的排序
 */
public class TestCr {
    public static void insertSort(int[] array) {
        long start = System.currentTimeMillis();
        int tmp = 0;
        //这样就把j定义到了外面
        //为了公用
        int j;
        for (int i = 1; i <array.length ; i++) {
            tmp = array[i];
            for ( j = i-1; j >=0 ; j--) {
                if (array[j]>tmp){
                    //因为多个数一起挪
                    //不能用array【i】
                    //j一直在走
                    array[j+1] = array[j];
                    //有序就不走了
                }else {
                    break;
                }
            }
            //最后要把值再给j+1；
            //这句语句虽然赋值两次
            //但是为了 刚好拍完序那种情况 必须有
            //如果把array【i】的值拿出来
            // 放在外面 就是这种
            array[j+1] = tmp;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void main(String[] args) {
       int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i <array.length ; i++) {
            array[i] = random.nextInt(10000) + 1;
            //有序
            //array[i] = i+1;

        }
            insertSort(array);
            System.out.println(Arrays.toString(array));
        }

    }

