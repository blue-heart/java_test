package zd.dm;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestMyStack {
    //用队列实现栈
    /*
    栈先进后出
    队列先进先出

    出栈：出的不为空的队列
    就是只有一个元素
    （因为有一个空队列准备着）
    入栈：放到不为空的队列里面
     */
    private MyQueneImpl myQuene1;
    private MyQueneImpl myQuene2;
    private int useSize;
    //上面是两个属性
    //没有初始化 通过构造函数
    public  TestMyStack(){
        //这是属性赋值 只不过调用了那个 类
        //左右一致
        //可以构造传参 也可以直接赋值
        //这个是给了一个对象作为属性
        //如果再oj里面 不能这样找不到类
        //把给的队列 赋值进来就ok；
        myQuene1 = new MyQueneImpl();
        myQuene2 = new MyQueneImpl();
        this.useSize = 0;
    }
    //刚开始两个队列都为空 随便入一个
    public void push(int x){
        if (!myQuene1.empty()){
            myQuene1.add(x);
        }else if(!myQuene2.empty()){
            myQuene2.add(x);
        }else{
            myQuene1.add(x);
        }
        this.useSize++;
    }
    //出队列 并且出去到data
    public int pop(){
        if (empty()) {
            throw new UnsupportedOperationException(
                    "栈为空"
            );
        }
            //出栈的元素保存到data里
            int data = 0;
            if (!myQuene2.empty()){
                for (int i = 0; i <this.useSize-1 ; i++) {
                    myQuene1.add(myQuene2.poll());
                }
                data = myQuene2.poll();
                this.useSize--;
                return data;
            }else{
                for (int i = 0; i <this.useSize-1 ; i++) {
                    myQuene2.add(myQuene1.poll());
                }
                data = myQuene1.poll();
                this.useSize--;
                return  data;
            }
    }
    //得到栈顶元素
    public  int top(){
        if (empty()) {
            throw new UnsupportedOperationException(
                    "栈为空"
            );
        }
        int data = 0;
        if (!myQuene2.empty()){
            for (int i = 0; i <this.useSize; i++) {
                data = myQuene2.poll();
                myQuene1.add(data);
            }
            //数据没有出去 真实存在 大小不减
            return data;
        }else{
            for (int i = 0; i <this.useSize; i++) {
                data = myQuene1.poll();
                myQuene2.add(data);
            }
            //最后的数据也就是栈顶的数据就保存好
            return  data;
        }


    }
    public boolean empty(){
        return this.useSize==0;

    }
    public int size(){
        return this.useSize;
    }
}
