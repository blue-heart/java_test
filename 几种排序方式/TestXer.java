package py.dm;

import java.util.Arrays;
import java.util.Random;

/*
时间复杂度：
1.3 - 1.5
不稳定：因为 他前面的排序 就会
打乱 相同数字的顺序 这里作为
稳定性的对比
组数尽量给素数 最后一组为1
 遍历
shell排序
希尔排序
插入排序的优化
采用分组 优化
hash（）
0-99 100-199
大数据处理方法
时间复杂度 还要加这个遍历
只不过省略
//就是最后尽量变为有序的
 */
public class TestXer {
    //直接插入排序 多了一个组而已
    public static void shell(int[] array, int gap){
        int tmp = 0;
        int j;
        //i++也是一直走的原因 一遍排玩
        for (int i = gap; i <array.length ; i++) {
            tmp = array[i];
            for ( j = i-gap; j >=0 ; j=j-gap) {
                if (array[j]>tmp){
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }



    }
    public static void shellSort(int[] array){
        int[] drr = {5,3,1,};
        for (int i = 0; i <drr.length ; i++) {
            //这个通过验证 组数就是数的下标
            shell(array,drr[i]);
        }

    }

    public static void main(String[] args) {
       /* int[] array = new int[10000];
        Random random = new Random();
        for (int i = 0; i <array.length ; i++) {
            //从0-9999 到 1-10000；
            //array[i] = random.nextInt(10000)+1;
            //array[i] = i+1;
            //无构造 对象不能调用 方法
            // TestDemo1 testDemo1 = new TestDemo1();

        }*/
       int []array = {11,4,5,6,2,9,10,98,32,7};
       shellSort(array);
       System.out.println(Arrays.toString(array));
    }
}
