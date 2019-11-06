package lb.dm.dao;

import lb.dm.Impl.ISequence;

import java.util.Arrays;
//this 就是对本类对象的引用
//如果 局部变量 和成员变量不重名
//就是 不写也可以 this 就是给成员变量
//这样所有方法 形成共性

public class SequenceImpl implements ISequence {

    private Object[] eleData;
    private  int useSize;
    public static  final  int
            DEFAULT_CAPACITY = 10;
    /*
    1.getter stter
    2.构造器
    3.静态代码块或者实例化代码块
     */
    public SequenceImpl(){
        //可以传参数 也可以 直接初始化
        //数组的初始化就是有大小
        this.eleData = new Object[DEFAULT_CAPACITY];
        this.useSize = 0;
    }
    private boolean isFull(){
        return  this.useSize
                == this.eleData.length;
    }
    @Override

    public boolean add(int pos, Object data) {
        //pos是下标
        /*
        1.判断pos的合法性，放入数据是否会溢出
        2.挪数据
        3.放入数据usedsize++；
         */
        //底下写代码不能写 参数 要写 有的数据
        //因为参数一会主方法才给
       // System.arraycopy();底层代码c/c++写的 速度快
        //arrays.coppyof 底层调用上面 速率上面大于下面
       if (pos<0||pos>this.useSize){
           return false;
       }
       if (isFull()){
           //扩容
           //这个返回一个数组
           //上面没有返回值
           this.eleData = Arrays.copyOf
                   (this.eleData,
                           this.eleData.
                                   length*2);
       }
       //for循环移动数据
        //因为要结合下标 所以以pos为界限
        for (int i = this.useSize-1; i >=pos ; i--)
        {
            //一步一步放
            this.eleData[i+1] = this.eleData[i];

        }
        //放入数据
        this.eleData[pos] =data;
        this.useSize++;
        return true;
    }
    private boolean isEmpty(){
        return this.useSize == 0;
    }

    @Override
    //找到第一个要数字的下标
    public int search(Object key /*,int pos*/) {
        if (key==null){
            throw new UnsupportedOperationException
                    ("不可以传入参数");
        }
        if (isEmpty()){
            return  -1;
        }
        for (int i = 0/*int i = pos*/; i
                <this.useSize
                ; i++) {
            //引用数据类型 比较值 要用equals
            if (this.eleData[i].equals(key)){
                return i;
            }

        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if (key==null){
            throw new
                    UnsupportedOperationException
                    ("不可以传入参数");
        }
        if (isEmpty()){
            return false;
        }
        for (int i = 0; i <this.useSize ; i++) {
            //key是object类型 要比较用equals
            if (this.eleData[i].equals(key)){
                return true;
            }

        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if (pos<0|| pos>=this.useSize){
            return null;
        }

        return this.eleData[pos];
    }


    @Override
    public Object remove(Object key) {
        int index = search(key);
        if (index ==-1){
            return null;
        }
        Object oldData= this.eleData[index];
        //这个和插入原理一样
        int i = 0;
        for (i = index; i <useSize-1 ; i++) {
            this.eleData[i] = this.eleData[i+1];

        }
        /*
        1.int i=0 定义在外面 括号外可以引用
        这个是代码块的原因 范围变大了
        2.因为这个数据是object类型 当数据被换到
        、最后面
        还存在引用 必须变为null才可以 垃圾回收
         */
        this.eleData[i+1] = null;
        this.useSize--;

        return oldData;
    }
    public void removeAllKey(Object key){
        //把search放到一个循环里去找 找完就删除完
    }

    @Override
    public int size() {

        return this.useSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.useSize ; i++)
        {
            System.out.println(this.
                    eleData[i]+" ");

        }

    }

    @Override
    public void clear() {
        for (int i = 0; i < this.useSize; i++)
        {
            this.eleData[i] = null;

        }
        this.useSize = 0;


    }
}
