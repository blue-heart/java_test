package lb.dm.dao;

import lb.dm.Impl.ILinked;
//画图解决 比较简单

public class MySingleListImpl implements
        ILinked {
    //成员内部类 实例内部类
    //直接访问外部
    private static int a = 10;

    class Node {
        private int data;
        private Node next;
        private static final int a = 20;

        //实例内部类 可以定义静态的 必须在编译期间确定
        //就是加final
        //如果内部有相同字母 会运行内部的
        //Node类要产生对象要用构造函数
        public Node(int data) {
            this.data = data;
            this.next = null;

        }

        public void fun() {
            System.out.println(a);
            //拥有外部类的this引用 有额外的开销
            System.out.println(MySingleListImpl.this.a);
        }
    }

    //定义头小块
    private Node head;

    public MySingleListImpl() {
        this.head = null;
    }

    @Override
    public void addFirst(int data) {
        //这个对象就是一个链表的 小块
        //也象征着一个地址
        //模拟图像里的内容
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            //这一步就是 先赋值 在把值给头
            //因为还要用头 就是语言的执行顺序
            //的技巧
            node.next = this.head;
            //这个头虽然改变了 最后只是改变了
            // 指向而已
            this.head = node;
        }

    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        //第一次插入
        if (cur == null) {
            this.head = node;
        } else {
            //判断条件 cur.next是否为空
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;

        }

    }

    //以下两个是找节点并且 合法性判断
    //找到index-1的节点
    private Node searchIndex(int index) {
        //判断是不是乱插
        checkIndex(index);
        //头结点没有前驱
        if (index == 0) {
            return null;
        }
        //下面都是自己定义 凑够逻辑即可
        int count = 0;//记录走的步数
        Node cur = this.head;
        //并且&&
        while (cur.next != null && count < index - 1) {
            cur = cur.next;
            count++;
        }
        //此时cur就是index-1的位置
        return cur;
    }

    private void checkIndex(int index) {
        //getlength 可以插 大于不可以
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException
                    ("下标不合法");
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        //添加到index这个位置
        //data 参数作用出来了
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null) {
            node.next = this.head;
            this.head = node;

        } else {
            //先绑定后面再绑定前面
            //如果不这样 先绑前面
            // cur.next = node；
            //然后 node.next=谁？
            //那个值没法表示了 被替换了 没有
            //那个值了
            node.next = cur.next;
            cur.next = node;

        }
        return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            //共有属性都可以用
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    private Node searchPre(int key) {
        /*
        因为要找前驱 所以 第一个是特殊情况
        为什么 找前驱 因为前驱 存储后面的数据
        1.是不是第一个节点
        2.if（cur.next.data==key）
         */
        Node cur = this.head;
        if (cur.data == key) {
            return this.head;
            //return null;
        }
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;

            }
            //while 在走
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        //也可以这样写
        //if(head.data == key)
        int oldData = 0;

        Node pre = searchPre(key);
        if (pre == null) {
            //单链表可以放-1
            throw new UnsupportedOperationException
                    ("没有key的前驱");
        }
        if (pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        //这儿也说明前驱唯一存储数据
        Node delNode = pre.next;
        pre.next = delNode.next;
        return oldData;
    }

    @Override
    // key 和 data 意义一样的 灵活用
    public void removeAllKey(int key) {

        Node pre = this.head;
        Node cur = this.head.next;

        while (cur != null) {
            //这个就是两个 条件赋值
            //和之前的while一样
            if (cur.data == key) {
                //删除了
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;

        }

    }

    @Override
    public int getLength() {
        //节点的个数
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        //如果用this.head 头就会改变
        //用cur 就不会 只是复制了个这样的属性
        //进行判断使用
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            //也就是 手动 向后走的条件
            //这个next指的是 下一个 小块
            cur = cur.next;
        }
        System.out.println();

    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            //前驱没有引用 又是前面的 就清除了
            this.head.next = null;
            //这个就是while 在走
            this.head = cur;
        }

    }
}

