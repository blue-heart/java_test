///7.数组反转
    /*// 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        //TODO
    }*/
	public class ArrayUtils{
		public static void main(String [] args){
			int[] array = null;
			System.out.println("数组反转之前：");
			printArray(array);
			printReversal(array);
			System.out.println("数组反转之后：");
			printArray(array);
		}
	public static void printReversal(int[] data){
		if(data == null){
		return;
		}
		int mid = data.length/2;
	for(int i =0; i<mid; i++){
		int temp = data[i];
		data[i] = data[data.length-1-i];
		data[data.length-1-i] = temp;
	}
	}
	
	
	
	
    //6.数组打印  4,3,2,1
    /*public static void printArray(int[] data){
        //TODO
    }*/
	public  static void printArray(int[] data){
		for( int i=0; i< data.length; i++){
			System.out.print(data[i]);
			if(i<data.length-1){
				System.out.print(",");
			}
		}System.out.println();
	}
	}
	
	
	//最大值算法；
	/*public static void main(String[] args){
		int max = args[0];
		for(int i=1; i<args.length; i++){
			if(args[i]>max){
				max = args[i];
			}
		}return max;
	}
	
	
	
	
	}*/