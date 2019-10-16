package cn.dm;

public class Test2{
    public static void main(String[] args){
        int n = 10;
        int result = mul(n);
        System.out.println("1+2+3+4+...."+n+"="+result);
		/*int n=100;
		int sum=sum(n);
		System.out.println("1+ 2 +3 + 4 +..." +n +"="+sum);*/
        //n =>1+ 2 +3 + 4 +... +n
        //n =>n + (n-1) +(n-2) +... +1


    }
    public static int mul(int n){
        if(n==1){
            return 1;
        }else{
            return n* mul(n-1);
        }
    }
	/*public static int sum(int n){
		if(n==1){
			return 1;
		}else{
			return n + sum(n-1);

		}*/
}

