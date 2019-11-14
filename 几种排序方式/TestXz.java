package py.dm;
import java.util.Arrays;
import java.util.Random;
/*
选择排序速度大于直接插入排序
时间复杂度
平方
空间 1；
不稳定：
有跳跃式的交换
不稳定的排序
 */
public class TestXz {
    public static void selectSort(int[] array) {
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //纳秒
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000) + 1;
        }
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}

