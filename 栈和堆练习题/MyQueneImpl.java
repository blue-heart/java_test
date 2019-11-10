package zd.dm;

import sun.dc.pr.PRError;

public class MyQueneImpl implements IMyQueue {
    class Node{
        private int data;
        private  Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private  Node front;//头
    private  Node rear;//尾巴
    private  int usedSize;
    public MyQueneImpl(){
        this.rear = null;
        this.front = null;
        this.usedSize = 0;
    }
    @Override
    public boolean empty() {
        return this.usedSize==0;
    }

    @Override
    public int peek() {
        if (empty()){
         throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
//删除头
    @Override
    public int poll() {
        if (empty()){
            throw  new UnsupportedOperationException("队列为空");
        }
        int data = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return data;

    }
//判断是否为空
    @Override
    public void add(int item) {
        if (empty()){
            //这个new写在外面也可以
            // 这样更简单
            //给尾巴和头赋值
            this.front = new Node(item);
            this.rear = this.front;
        }else{
            this.rear.next = new Node(item);
            this.rear = this.rear.next;
        }
        this.usedSize++;


    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
