package lb.dm.dao;

import lb.dm.Impl.CLinkList;

import java.util.Date;

public class CHeadSingLeListImpl implements CLinkList {

    class Node{
        private int data;
        private Node next;

        public Node(){
            this.data = -1;

        }
        public Node(int data){
            this.data = data;
        }
    }
    private Node head;

    public CHeadSingLeListImpl(){
        this.head = new Node();
        //只有一个头 自己指向自己本身
        //这是初始化 没有添加数据
        this.head.next = this.head;

    }

    @Override
    public void addFirst(int data) {
        //new一个数据 插入
        //先看后面 因为它可以决定后面
        //前面决定他 他不能决定前面
        //这个是删除数据
        //还有插入数据

        Node node =  new Node(data);
        //判断要用双等于 赋值才等于
        //这个同样满足循环
        //这就是比无头简单的地方
        node.next = this.head.next;
        this.head.next = node;

    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next==this.head){
           //注意先后再前
            node.next=this.head;
            cur.next = node;
        }
        cur = cur.next;


    }
    private void checkIndex(int index){
        //getlength 可以插 大于不可以
        if (index<0 || index>getLength()){
            throw new IndexOutOfBoundsException
                    ("下标不合法");
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node node =new Node(data);
        Node cur = this.head;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        //因为 头结点 自动适应这个方法 简单
        //因为数据保存在前驱 所以这样写
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    //前驱数据是-1 所以不需要从前驱开始找
    //从数据结点开始找就ok
    public boolean contains(int key) {
        Node cur = this.head.next;

        //这儿用到了data 找数据用
        while(cur!= this.head){
            if (cur.data==key){
                //这个出循环 找出
                return true;
            }
            cur = cur.next;
        }
        //没找出或者 就一个头 错误
         return  false;
    }
    private Node searchPre(int key){
        Node pre = this.head;
        //有可能 直接到尾巴 就是一个头
        //非出 是入 这个while 很实用
        while (pre.next!=this.head){
            if (pre.next.data == key){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        //找完前驱还要进一步判断
        if (pre == null) {
            throw new UnsupportedOperationException(
                    "key不存在"
            );
        }
            int oldData = 0;
            Node delNode = pre.next;
            //这一步删除
            oldData = delNode.data;
            pre.next = delNode.next;
            return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        //两个点一起走的原因就是
        // 有前驱可以删除
        Node pre = this.head;
        Node cur = this.head.next;
        //如果不这样判断 一个头就空指针异常
        //一个头判断
        while (cur!= this.head){
            if (cur.data==key){
                pre.next = cur.next;
                cur = cur.next;

            }else {
                pre = cur;
                cur =cur.next;
            }
        }

    }

    @Override
    public int getLength() {
        //头结点不算
        Node cur = this.head.next;
        int count = 0;
        while (cur!= this.head){
            //环形打印
            count++;
            cur =cur.next;

        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        //环形判断
        while (cur!= this.head){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();

    }

    @Override
    public void clear() {

        while (this.head.next!= this.head){
            Node cur = this.head.next;
            //这个head不动 因为head动了
            //下一个条件就无限循环
            //上一个一个一个删除 到最后
            //这个 利用第一个头（也是因为）
            //没有数据 但是是头 他吃掉所有数据
            //上一个 头不停的走 都是数据
            //这个 头不能走 而且 最后会循环
            //所以要这样
            //为什么改变 因为前驱不引用它了
            this.head.next =cur.next;
            //底下这部可有可无
            cur.next = null;
        }
        //头没有值 但有引用 所以的得置空
        this.head = null;
            //这个也是释放内存机制
        //个体为null 才是清空
        //前面是通过前驱控制后面
        //这个直接从前驱开始逐个删除
        //前面链表这里一直要看next 不能看node
        //是把next置空 从头开始
       //while (this.head!=this.head){
            //底下这个函数的缘故
            //cur 会自动 向前移动
            // head自行删除
           // Node cur =this.head.next;
           // this.head.next = null;
           // this.head =cur;
       // }

    }
}
