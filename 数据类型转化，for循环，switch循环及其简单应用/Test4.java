package cv.dm;

import java.io.IOException;

public class Test4 {

    public static void main(String[] args) throws IOException {


        System.out.println("请输入一个字符");

        char c = (char)System.in.read();
        //switch
        switch(c){
            case 's':{
                System.out.println("优秀员工");
                break;
            }
            case 'D':{
                System.out.println("劝退员工");
                break;
            }
            default : {System.out.println("。。。。");
            }


        }
    }
}



