package lb.dm.dao;

import lb.dm.Impl.ILinked;
//画图解决 比较简单

public class MySingleListImpl implements
        ILinked {
    //成员内部类 实例内部类
    //直接访问外部
    private static int a = 10;
   public class Node{
        private int data;
        public Node next;

       public Node getNext() {
           return next;
       }

       private  static final int a =20;

       public int getData() {
           return data;
       }

       public void setData(int data) {
           this.data = data;
       }

       //实例内部类 可以定义静态的 必须在编译期间确定
        //就是加final
        //如果内部有相同字母 会运行内部的
        //Node类要产生对象要用构造函数
        public Node(int data){
            this.data = data;
            this.next =null;

        }
        public void fun(){
            System.out.println(a);
            //拥有外部类的this引用 有额外的开销
            System.out.println(MySingleListImpl.this.a);
        }
    }

    public Node getHead() {
        return head;
    }

    //定义头小块
    private Node head;
    public MySingleListImpl(){
        this.head = null;
    }
    @Override
    public void addFirst(int data) {
        //这个对象就是一个链表的 小块
        //也象征着一个地址
        //模拟图像里的内容
        Node node = new Node(data);
        if (this.head ==null){
         this.head = node;
        }else{
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
        if (cur == null){
            this.head = node;
        }else{
            //判断条件 cur.next是否为空
            while (cur.next !=null){
                cur = cur.next;
            }
            cur.next=node;

        }

    }
    //以下两个是找节点并且 合法性判断
    //找到index-1的节点
    private Node searchIndex(int index){
        //判断是不是乱插
        checkIndex(index);
        //头结点没有前驱
        if (index == 0){
            return  null;
        }
        //下面都是自己定义 凑够逻辑即可
        int count = 0;//记录走的步数
        Node cur = this.head;
        //并且&&
        while(cur.next !=null && count<index-1){
            cur = cur.next;
            count++;
        }
        //此时cur就是index-1的位置
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
    public boolean addindex(int index, int data)
    {
        //添加到index这个位置
        //data 参数作用出来了
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null){
            node.next = this.head;
            this.head = node;

        }else {
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
        while (cur!=null){
            //共有属性都可以用
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }

        return false;
    }
    private Node searchPre(int key){
        /*
        因为要找前驱 所以 第一个是特殊情况
        为什么 找前驱 因为前驱 存储后面的数据
        1.是不是第一个节点
        2.if（cur.next.data==key）
         */
        Node cur= this.head;
        if (cur.data==key){
            return this.head;
            //return null;
        }
        while (cur.next!=null){
            if (cur.next.data==key){
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
        int oldData=  0;

        Node pre = searchPre(key);
        if(pre == null){
            //单链表可以放-1
            throw new UnsupportedOperationException
                    ("没有key的前驱");
        }
        if (pre==this.head&& pre.data ==key){
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

        while (cur!= null){
            //这个就是两个 条件赋值
            //和之前的while一样
            if (cur.data == key) {
                //删除了
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        if (this.head.data ==key){
            this.head=this.head.next;

        }

    }

    @Override
    public int getLength() {
        //节点的个数
        int count = 0;
        Node cur = this.head;
        while (cur!= null){
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
        while(cur!=null){
            System.out.print(cur.data+" ");
            //也就是 手动 向后走的条件
            //这个next指的是 下一个 小块
            cur = cur.next;
        }
        System.out.println();

    }

    @Override
    public void clear() {
        while (this.head!=null){
            Node cur = this.head.next;
            //前驱没有引用 又是前面的 就清除了
            this.head.next = null;
            //这个就是while 在走
            this.head = cur;
        }

    }
    //找中间的节点
    //让cur走length/2的路
    //偶数走这么多 奇数也一样
    public Node middleNode(){
        Node cur = this.head;
        int len = getLength()/2;
        for (int i = 0; i <len; i++) {
            cur = cur.next;

        }
        //中间的节点两个返回右边那个
        return cur;
    }
    //找倒数第k个节点
    public  Node findKthToTail(int k){
        //k = -1, k>length 都不可以
        Node fast = this.head;
        Node slow = this.head;
        //不能越界
        if (fast == null|| k<=0||k>getLength()){
            return null;
        }
        /*
        fast先走k-1步
         */
        while (k-1 >0){
            fast = fast.next;
            k--;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //给定一个数据 把链表分为 左边小
    // 右边大两部分
    public  Node partition(int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while (pHead!= null) {
            //换前驱 删除法
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if (pHead.data < x) {
                //第一次插入beforestart
                //又是一个新链表
                if (beforeStart == null) {
                    //这儿初始化 了新链表的头和尾巴
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                    //装了数据了
                } else {
                    //串起来
                    beforeEnd.next = pHead;
                    beforeEnd = beforeEnd.next;

                }
                //注意 最后一个括号前面写返回条件
            } else {
                if (afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = pHead;
                    afterEnd = afterStart.next;
                }
            }
            //while条件在走
           // pHead = pHead.next;
            //这样既走了 还置空了前面
            //这儿就是内存泄露 就是不用的要为null
            pHead = pHeadNext;
        }
        //这儿写while出来执行语句
        //单链表所有数据比x大
        if (beforeStart == null){
            return afterStart;
        }
        //因为空的不能连接 但是后面是空可以
        //因为 空.next会出错
        beforeEnd.next = afterStart;

        return beforeStart;
        //上面的display 没有参数 只有
        //head 没法打印 head 都没了
    }
    public  void  show(Node newHead){
        //这就是面试的遍历 和
        //通用的遍历法则
        Node cur = newHead;
        while (cur!= null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //单链表的头插法逆置
    // 反转
    //第一个简单
    //单链表的反转
    //单链表只保存后驱信息
    //所以后面的信息
    // 要通过前驱查看
    //这儿充分说明数据的引用问题
    //反转就是引用反转
    public Node reverList(){
        Node reverseHead = null;
        Node prev  =  null;
        Node cur = this.head;
        while (cur!=null){
            Node curNext = cur.next;
            //找到新头
            if (curNext == null){
                reverseHead  = cur;
            }
            //这步置空头部而且适应后面
            cur.next = prev;
            prev =  cur;
            cur = cur.next;
        }
        return reverseHead;
    }
    //重新 组成部分 取部分链表并且返回
    // 一般创建一个新的链表
    //有序的单链表找重复的节点
    public Node deleteDuplication(){
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmpHead = newHead;
        //判断cur 空
        //如有next 因为不带头结点 可能头为空
        //这个都判断了

        //不带头结点 可能为空 头结点
        //这是 无头链表 都要考虑这种情况
        while (cur!= null){
            //条件 可能为空
            if (cur.next!= null&& cur.data
            ==cur.next.data)
            {
                //判断多个节点重复 遍历也
                // cur.next有可能也为空
                while (cur.next!=null&&cur.data
            ==cur.next.data){
                    //next不为空才能走啊
                    cur = cur.next;
                }
                //除了while循环 还要走一步
                //因为cur还在重复点上
                //这一步保证了 连续重复数字不受影响
                //而且移动会在 另一个移动 所以
                //不会把连续重复的交叉值放在里面
                //本来这儿保存的交叉点的指针但是new不会动
                // 一直会把不同的指针保存到
                //才会移动 所以指针一直都是正确的
                cur = cur.next;
                //这是要改变new的引用
                newHead.next = cur;
            }else {
                newHead.next = cur;
                //这儿只是new 在cur的位置
                //和cur一个道理
                //两个都是引用 不会带走节点
                //因为cur一直走 让new 指向cur 保存下一个
                //节点的前驱
                newHead = cur;
                cur = cur.next;
            }

        }
        //newhead只是一个cur一样的东西
        //一直在改变链表的引用值
        //因为打印从头打印 所以 要从第一个
        // newhead.next开始打印
        return tmpHead.next;

    }

    //链表的回文结构
    //正着念 和倒着念一样
    //如何解决单链表从后往前走
    public boolean chkPalindrome(){
        //莫得节点
        if (this.head ==null){
            return false;
            //一个节点
        }else if(this.head.next ==null){
            return true;

        }
        Node fast = this.head;
        Node slow = this.head;
        //奇数和偶数两种情况
        while (fast!=null&& fast.next!=null){
            //如果 写两个next 一个为空
            // 再next空指针异常
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node p1 = p.next;
        while (p!=null){
            p.next = slow;
            slow = p;
            p = p1;
            if (p1 !=null){
                p1 = p1.next;
            }
        }
        //相遇条件
        while (slow!= this.head){
            //不等就返回错误
            if (slow.data!=this.head.data){
                return false;
            }
            //这个是偶数个节点防止出错给出的条件
            if (this.head.next ==slow){
                return true;
            }
            //相等就回文
            this.head = this.head.next;
            slow = slow.next;

        }
        return true;
    }
    //创建一个环
    //自己创建环 和面试的有区别
    public void createCycle(){
        Node cur = this.head;
        while (cur.next!=null){
            cur = cur.next;
        }
        //创建了一个环 随便创
        cur.next = this.head.next;
    }
    //判断单链表是否有环
    //定义两个引用 一个走两步 一个走一步
    //相遇 就有环
    /*
    问题：快的走3步 和走两步的区别
     */
    public  boolean hasCycle(){
        Node fast = this.head;
        Node slow = this.head;
        //条件还是一样 防止空指针
        //这个 条件是无环快速走完 防止空指针
        while (fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //每一次发生变化 都要进行判断
            if (fast == slow){
                //退出循环
                //这儿跳出 防止有两个都是空的情况
                //下面进行条件严密的判断
                break;
            }
        }
        //判断两个都不为空
        if (fast!=null&& slow!=null &&fast == slow){
            return true;
        }
        return false;
    }
    //找环的入口
    public Node detectCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while (fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast!=null||fast.next ==null){
            return null;
        }
        //这个就是两个不为空 的执行语句
        //这个 也是因为两个 如果相遇
        // 推导出 剩余路程 就等于head到节点的位置
        // 他们也不懂 这公式里就有为什么相遇
        // 跑二倍是表面 相遇才是关键
        //那么为什么相遇呢？
        slow = this.head;
        while (slow!= fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //找出两个单链表相交的节点
    //先求得两个单链表的差值
    // 相遇之前

    }


