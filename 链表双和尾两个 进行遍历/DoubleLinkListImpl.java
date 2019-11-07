package lb.dm.dao;

import lb.dm.Impl.IDoubleLinked;
import sun.dc.pr.PRError;
//插入先绑定后面
//头插也一样 因为一切看前驱
//无头的 加入要考虑头 删除要考虑尾巴
//多了一个免费前驱 和last
public class DoubleLinkListImpl implements IDoubleLinked {
    class  Node{
        private int data;//数据
        private  Node prev;//前驱
        private Node next;//后继
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }
    private Node head;
    //尾插 要找尾巴 有了last 不用找
    //记住 一定要 理解前驱的意义
    private Node last;//标志尾巴
    public DoubleLinkListImpl(){
        this.head = null;
        this.last = last;
    }

    @Override
    public void addFirst(int data) {
        //第一次插入
        //刚来第一个节点
        Node node = new Node(data);
        //全部东西都是自己构造
        if (head== null){
            //这个就是为以后再插服务
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            //双链表 要设置前置点 这是多出的地方
            node.next.prev = node;
            this.head = node;
        }

    }

    @Override
    public void addLast(int data) {
        //不需要遍历 找尾巴 有last
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.last = node;
        }else{
            //充分体现用谁先写谁
            //先前面 要不然没法表示
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }

    }
    //有个找长度问题 check
    private  Node searchIndex(int index){
        checkIndex(index);
        Node cur = this.head;
        //定义计数器
        int count = 0;
        while (count<index){
            cur = cur.next;
            count++;
        }
        //cur所指的位置 就是index的位置
        return cur;

    }
    private void checkIndex(int index){
        //getlength 可以插 大于不可以
        if (index<0 || index>getLength()){
            throw new IndexOutOfBoundsException
                    ("下标不合法");
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        //自带前驱信息
        //不需要 再找前驱
        if (index == 0){
            addFirst(data);
            return true;
        }
        //这个是因为 cur 指的是本身
        //前面是-1，所以有这种情况
        if (index == getLength()){
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur;
        //这样保存值 要不然一会没法表示
        //从前驱开始
        cur.prev.next = node;
        node.prev = cur.prev;
        //最后一步才还原 不然没法表示
        cur.prev = node;
        return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        //不用找前驱
        // 可以直接有
        Node cur = this.head;
        while (cur!=null){
            if(cur.data ==key){
                int oldData = cur.data;
                //删除的节点是头节点
                if (cur==this.head){
                    this.head = this.head.next;
                    //改变前驱 并且删除
                    this.head.prev=null;
                }else {
                    //删除中间值 先弄前面 在弄后面
                    cur.prev.next = cur.next;
                    if(cur.next!=null)
                    { cur.next.prev = cur.prev;}
                    //这句代码 取巧的加了一个条件
                    //一个语句
                    //就是利用if else 和while
                    // 大判断一个道理
                    else {
                //删除最后一个节点 last 指回来
                        this.last = cur.prev;
                    }
                    //有个问题 当是最后一个节点
                    //因为有自带前驱 所以会标空指针
                }
                //这个是结束函数 删除完成的标志
                //return 就是出函数
                return oldData;
            }
            //这个是while 循环控制出来执行的语句 大while
            cur = cur.next;

        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        //这个不return 就走完删除完 漂亮
        Node cur = this.head;
        while (cur!=null){
            if(cur.data ==key){
                if (cur==this.head){
                    this.head = this.head.next;
                    this.head.prev=null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next!=null)
                    { cur.next.prev = cur.prev;}
                    else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
        }


    }

    @Override
    public void clear() {
        while (this.head!=null){
            //这个判断可以
            Node cur = this.head.next;
            head.next = null;
            //前驱也要为空 没有任何引用菜可以
            head.prev = null;
            head = cur;
        }
        //两个引用 用头判断 但是还要有尾巴
         this.last = null;

    }
}
