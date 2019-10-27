package com.bittech;

//这两个T一样
//这是借口和方法的区别
public interface IMessage<T> {
    void print(T t);

    public static void main(String[] args) {
        IMessage<Integer> qqMessage = new QQMessage<>();
        qqMessage.print(10);

        //实例化好了 所以不用有参数
        //两种 都是以实例化对象为准

        IMessage msnmessage = new MsnMessage();
        msnmessage.print("dad");

        MsnMessage msnMessage1 = new MsnMessage();
        msnMessage1.print("dasda");

    }


}


class  QQMessage<T> implements IMessage<T>{
    public  void  print(T t){

    }

}
class MsnMessage implements  IMessage<String>{
    public  void print(String a){

    }
}
