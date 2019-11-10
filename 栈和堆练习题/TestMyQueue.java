package zd.dm;

public class TestMyQueue {
    //栈变队列
    private  MyStackImpl myStack1;
    private  MyStackImpl myStack2;
    public  TestMyQueue(){
        myStack1 = new MyStackImpl();
        myStack2 = new MyStackImpl();
    }
    //入队放到第一个栈里面
    public void push(int x){
        myStack1.push(x);

    }
    //取出元素一个
    public  int pop(){
        if (myStack2.empty()){
            //把s1里面的数据全部放入s2
            while (!myStack1.empty()){
                myStack2.push(myStack1.pop());
            }
        }
        int tmp = -1;
        if(!myStack2.empty()){
            //直接弹出s2栈顶元素
            //这个 只是取一个数字
            tmp = myStack2.pop();
        }
        //如果返回-1 说明为空
        return tmp;

    }
    //得到队列头部元素
    //障眼法
    public int peek(){
       /* while (!myStack1.empty()){
            myStack2.push(myStack1.pop());
        }
        int data = myStack2.peek();
        return data;*/
       //下面这步就是处理了放数据的情况
        //因为上面的代码没有考虑中间放入数据的情况
        //就会不遵循规律 必须拍好顺序 才可以
        int data = 0;
        if (myStack2.empty()) {
            //把s1里面的数据全部放入s2
            while (!myStack1.empty()) {
                myStack2.push(myStack1.pop());
            }
        }
        data = myStack2.peek();

        return data;

    }
    public boolean empty(){
        if (myStack1.empty()&&myStack2.empty()){
            return true;
        }
        return false;
    }
}
