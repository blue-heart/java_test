package lb.dm.main;
//大类 主函数用
//小类 new 数据用
//而且 小类刚好把 骨架设计好 大类也一样
//导入类名
//不带头的单链表
import lb.dm.dao.CHeadSingLeListImpl;
import lb.dm.dao.MySingleListImpl;
import lb.dm.dao.SequenceImpl;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.plaf.PanelUI;

/*
1.用一个数据抽象一个小块；
2.小类装 块里面的属性
大类 装块的属性
3.调用肯定大类 包含所有方法
小类只是 包含小块属性的作用
 */
//接触不带头节点一定考虑第一个点
//头也是自己定义的
public class TesyMain {
    //内部类 传两个 Node单链表的方法
    //找出两个单链表的相交的节点

    //创建两个相交的 单链表 还要另起炉灶
    //不能用以前的node 插入 因为是两个参数
    //说了 这个方法必须是静态的 要复习这个问题
    //静态 和内部类那儿的 细节要搞清楚
    public static  void  createCut(
            MySingleListImpl.Node headA,
            MySingleListImpl.Node headB){

        //这儿 java里面 函数有返回值 必须有参数接收到
        //这个 getnext（）没有接收 所以出错
        //headA.getNext().getNext()
        // = headB.getNext().getNext().getNext();
        //所以把next 改成公有的
        headA.next.next = headB.next.next.next;
        //相交在第一个单链表的第三个节点处

    }
    public static MySingleListImpl.Node getInersectionNode(
            MySingleListImpl.Node headA,
            MySingleListImpl.Node headB
    ){
        if (headA==null || headB==null){
            return null;
        }
        //网页上写 要自己实现 不要调用
        int headALength = 0;
        int headBLength = 0;
        //永远指向最长的单链表
        MySingleListImpl.Node pL = headA;
        //永远指向最短的单链表
        MySingleListImpl.Node pS = headB;
        //确定那个单链表 是长的单链表
        //确定好后让长的单链表走长度的差值getter方法
        //提供 next的 这儿也要这样用
        while (pL!=null){
            headALength++;
            pL = pL.getNext();
        }
        while (pS!= null){
            headBLength++;
            pS = pS.getNext();
        }
        //如果 前面长后面短
        //上面出来就是空 所以 要恢复；
        pL = headA;
        pS = headB;
        int myLen = headALength-headBLength;
        //这步保证了长的永远是pL
        if (myLen<0){
            pL = headB;
            pS = headA;
            myLen = headBLength-headALength;
        }
        //让长的单链表走长度的差值
        for (int i = 0; i <myLen ; i++) {
            //这步 走差值 先走
            //有get 是内部类的方法 获取私有属性
            pL = pL.getNext();
        }
        //一人一步走
        //要判断没有相交的条件
        while (pL!=null && pS!=null && pL!=pS){
            pL = pL.getNext();
            pS = pS.getNext();
        }
        //一个不对就出来 这是while的体系
        //所以3不对 1 和 2 可能有 出来还要判断
        if (pL!=null && pS!=null && pL==pS){
            return pL;
        }
        return null;
    }
    //合并两个有序的单链表
    public static MySingleListImpl.Node mergeTwoL(
            MySingleListImpl.Node headA,
            MySingleListImpl.Node headB
    ){
        //实例内部类相当于 类内的方法 外部访问 要有对象
        //而后面实例的对象相当于 对象调用 前面也要带类名
        MySingleListImpl mySingleList = new MySingleListImpl();
        MySingleListImpl.Node node = mySingleList.new Node(-1);
        MySingleListImpl.Node tmpNode = node;
        //while 循环 有一个不成立 就会向下执行
        while (headA!=null&&headB!=null){
            if (headA.getData() > headB.getData()){
                tmpNode.next = headB;
                headB = headB.next;
                tmpNode = tmpNode.next;
            }else{
                tmpNode.next = headA;
                headA = headA.next;
                tmpNode = tmpNode.next;
            }
        }
        if (headA!=null){
            tmpNode.next = headA;
            //不能else 因为不成立 a为空 也是else
        }
        if (headB!=null){
            tmpNode.next = headB;
        }
        return  node.next;

    }
    public static void main(String[] args) {


       //相交点
        MySingleListImpl mySingleList =
                new MySingleListImpl();
        mySingleList.addLast(25);
        /*
        .
        .
        .
        .
        .
        .
         */
        MySingleListImpl mySingleList1 =
                new MySingleListImpl();
        /*
        .
        .
        .
        .
         */
        //1.也要有 get方法
        // 2.只是传两个参数 很灵活 不难
        createCut(mySingleList.getHead(),
                mySingleList1.getHead());
        //这个左边必须定义一个同样类型的接收
        //就这样 同一个东西肯定要这样
        MySingleListImpl.Node cur = getInersectionNode
                (mySingleList.getHead(),
                mySingleList1.getHead());

        System.out.println(cur.getData());
        //合并有序

        MySingleListImpl.Node ppt = mergeTwoL(mySingleList.getHead(),
                mySingleList1.getHead());
        mySingleList.show(ppt);



       /* CHeadSingLeListImpl cHeadSingLeList = new CHeadSingLeListImpl();
        MySingleListImpl mySingleList = new MySingleListImpl();
        //通过外内部类对象 和getter调用方法 获得get值
        MySingleListImpl.Node cur = mySingleList.middleNode();
        //获取cur的data属性
        //之前是放值 和删除值 现在是 获得一个值打印出来 就要这样
        System.out.println(cur.getData());
        //反转打印
        //写法很灵活
        mySingleList.show(mySingleList.reverList());
        MySingleListImpl.Node ad = mySingleList.detectCycle();
        //这儿有个问题 就是 后面的参数不传 就是创造一个环
        // 但是一般 要知道头结点
        System.out.println(ad.getData());*/


   /* public static void main(String[] args) throws InterruptedException {

        MySingleListImpl mySingleList = new MySingleListImpl();
        mySingleList.addFirst(18);
        mySingleList.addFirst(18);
        mySingleList.addFirst(99);
        mySingleList.display();// 99 78  18
        mySingleList.addindex(0,18);
        mySingleList.addLast(100);
        mySingleList.display();// 99 88 78 18 100
        System.out.println(mySingleList.contains(78));
        System.out.println(mySingleList.contains(188));
        mySingleList.removeAllKey(18);
        mySingleList.display();

       // Thread.sleep(1000);
        //System.out.println("睡醒了");

        /*mySingleList.remove(99);
        mySingleList.display();
        mySingleList.remove(78);
        mySingleList.display();
        mySingleList.remove(100);
        mySingleList.display();
        System.out.println(mySingleList.getLength());*/


    }
   /* public static void main(String[] args) {
        //访问一个类方法要对象
        SequenceImpl sequence = new SequenceImpl();
        for (int i = 0; i <10 ; i++) {
            sequence.add(i,i);

        }
        //object 可以放所以数据类型
        sequence.display();
        sequence.add(10,"bit");
        sequence.display();

        //放不进去
        sequence.add(13,"java");
        sequence.display();

        sequence.remove("bit");
        sequence.display();
        System.out.println("==========");

        sequence.clear();
        sequence.display();
    }
*/

}
