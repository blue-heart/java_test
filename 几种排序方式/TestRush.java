package py.dm;

import java.util.Arrays;
import java.util.Random;
/*
时间复杂度
partion；o（n） 再+n*log2n（递归*partion）
就是nlog2n
空间复杂度：
递归一次存一个par
log2n
稳定：不稳定
时间复杂度：前面有乘个k 快排
的k小于堆排 速度更快
但是堆排的空间复杂度 少只有1
快排有栈溢出的风险

分为等长序列 效率会最高
（这就是选择基准）
还有随机选取基准法
 */
public class TestRush {
    //只是一趟快排
    public static int partion(int[] array,int low, int high){
        int tmp = array[low];
        while (low<high){
            //上面这个是大条件 维持一直走
            // 和底下判断不是一回事
            //不写这个low《high 最后一步 会越界
            //两个不是一个意思 上面只是进来的意思
            //这个也是一个if条件
            while ((low<high) && array[high]>=tmp){
                high--;
            }
            if (low==high){
                //array[low] = tmp;
                break;
            }else {
                //把小的值给 low
                array[low] = array[high];
            }
            while ((low<high) && array[low]<=tmp){
                low++;
            }
            if (low==high){
                //array[low] = tmp;
                break;
            }else {
                //能走到这儿说明 就有空位置
                array[high] = array[low];
            }
        }
        //这个和前面堆排序一个道理
        //总体写法
        array[low] = tmp;
        return low;
    }
    public static  void  quickSort(int[] array){
        //但是这两个一直在改变 所以有上面quick
        long start = System.nanoTime();
        quick(array,0,array.length-1);
        long end = System.nanoTime();
        System.out.println(end-start);
    }
    public static void swap(int[] array,int low, int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
    public static  void  takeThreeNumber(int[] array,int low, int high){
        int mid = (low+high)/2;
    }
    public  static  void  quick(int[] array,int low, int high){
        if (low == high){
            return;
        }
        int par = partion(array,low,high);
        //递归左边：保证有两个数据以上
        if (par>low+1){
            //没有修改的low 继续刚才的位置
            //保护当前线程
            //high改了
            //这步给par重新赋值
            //递归完成后会返回到原来的那个par
            //只有一边无法 递归时才会返回
            //所以可以继续遍历右边
            quick(array,low,par-1);
        }
        //递归右边：这个时候par变了 递归了一次 high没变
        //low 下面手动变 全靠递归出的par控制
        //就是修改引用可以用 但是最终还是变为最先的值
        //复习递归***
        if (par<high-1){
            quick(array,par+1,high);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000) + 1;
        }
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    }

