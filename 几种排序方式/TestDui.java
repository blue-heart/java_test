package py.dm;

import java.util.Arrays;
import java.util.Random;
/*
时间复杂度：
n/2 * log2n
nlog2n
第二部 也是 如此
为 2nlog2n
去掉2也是 nlog2n
空间复杂度：1
不稳定。、、；
topk问题 100个数据找10个最大
最小
 */
public class TestDui {
    //这个同样是在造树

    public static void adjust(int[] array, int start,
                              int end) {
        int tmp = array[start];
        //找左右孩子
        //start--后 这个i自动变
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            //判断是否有左右孩子
            //必须要判断 有有孩子 否则 没有右孩子
            // 就数组越界
            //如果走下面这句代码 数组不能越界
            if ((i < end) && array[i] < array[i + 1]) {
                i++;
                //最大值的下标
            }
            if (array[i] > tmp) {
                //走这步赋值后前面有值 后面没有
                //一直在和tmp做比较
                array[start] = array[i];
                //把start指向 下一个头
                //如果没有也无妨
                //如果进不来
                //start 不知道是什么 所以用i*2+1
                //再次找左右孩子
                start = i;
            } else if(array[i]<tmp){
                //直接放进来
                //array[start] = tmp;
                //跳出来 在最后一句语句放数
                //因为底下有序的
                //直接跳出就 有序
                break;
            }
        }
        //退出循环 就是数组》end
        // 那个if 都没有进 要把这个值放进来
        //因为tmp有个数
        //结束后只拿头说话0；
        //解决最后一句语句问题
        //这句语句 是 第一个if出来的最后判断语句
        //刚好else if break 后也是一样的效果
        //也可以出来用这个语句
        //不用写两遍
        //第一个 是处理最后一个节点
        //第二个 是跳出再给 共用一个代码
        //特殊性
        //*****
        //这一步保证了 最后那个空被tmp填满
        //同样 如果不能交换 则不移动 同样填入
        array[start] = tmp;
    }
        public static void heapSort( int[] array){
          //start 减小1
            //由子去推父
            for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
                adjust(array, i, array.length - 1);

            }
            //上面代码跑完，整棵树变为大根树
            //几个数交换 数-1次
            for (int j = 0; j <array.length-1 ; j++) {
                int tmp = array[0];
                array[0] = array[array.length-1-j];
                //这才是交换 不是空一个 就是赋值一次
                array[array.length-1-j] = tmp;
                //每次调整一次
                // 先交换 再调整 交换完成肯定少一个数据
                adjust(array,0,array.length-1-j-1);

            }
        }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000) + 1;
        }
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    }


