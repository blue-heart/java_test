package cv.dm;

public class Test9 {
    public static void main(String[] args) {
        int[] data = init();
        bigger(data);
        printArray(data);
    }

    // 定义一个返回数组的方法
    public static int[] init() {
        return new int[]{1, 2, 3, 4, 5}; // 匿名数组
    }

    // 将数组中每个元素的值扩大5倍
    public static int[] bigger(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 5; // 每个元素扩大5倍
        }
       /* int[] intArray = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            intArray[i] = arr[i]*5;
        }
        arr = intArray;
        return arr;*/
        return  arr;
    }

    public static void printArray(int[] temp) {
        for (int i = 0 ; i<temp.length ; i++) {
            System.out.println(temp[i]) ;
        }
    }
}

