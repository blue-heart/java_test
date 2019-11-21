package zd.dm;
/*
循环队列 和单链表不同就是 头尾相接 哪个是独立的
 */
    public class MyCircularQueue {
        private int front;//队头的下标
        private int rear;//队尾的下标
        private int[]elem;//数组
        private int useSize;//有效数据的个数

        public MyCircularQueue(int k){
            //为了判断满 会空出一个格子
            //要不然 判断时候下标越界
            //oj里面会放完所有的格子
            //这里 会空一格 要保证 无差异
            // 就要给k+1自动扩容一个单位
            this.elem = new int[k];
            this.front = 0;
            this.rear = 0;
            this.useSize = 0;
        }
        //入队
        public boolean enQueue(int value){
            if (isFull()){
                return false;
            }
            this.elem[this.rear] = value;
            //实现7-1 而不是7-8
            this.rear = (this.rear+1)%this.elem.length;
            this.useSize++;
            return true;

        }
        //出队
        public boolean deQueue(){
            if (isEmpty()){
                return false;
            }
            //移动了头部 就没有了这个元素
            this.front = (this.front+1)%
                    this.elem.length;
            this.useSize--;
            return true;
        }
        //得到队头的元素
        public int front(){
            if (isEmpty()){
                return -1;
            }
            return this.elem[this.front];

        }
        public int rear(){
            if (isEmpty()){
                return -1;
            }
            //也可以循环找尾巴
            //这样简单 但是这样有下标为0的特殊情况
            //就是不能为-1
            int index = this.rear == 0?
                    //防止在0号下标
                    this.elem.length-1:
                    this.rear-1;
            return this.elem[index];

        }
        public  boolean isEmpty(){
            //两种
            return this.front == this.rear;
           // return this.useSize = 0;
        }
        public boolean isFull(){
            //通用判断是否环为满
            if ((this.rear+1)%this
                    .elem.length==this.front){
                return true;
            }
            return false;
        }
}

