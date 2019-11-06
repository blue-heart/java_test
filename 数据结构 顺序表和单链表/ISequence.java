package lb.dm.Impl;

public interface ISequence {
    //在pos位置插入data
    boolean add(int pos,Object data);
    //查找关键字key 找到返回key的下标，没有返回-1;
    int search(Object key/*int pos*/);
    //查找是否包含关键字key是否在顺序表当中(这个
    // 和search有点冲突)
    boolean contains(Object key);
    //得到pos位置的值
    Object getPos(int pos);
    //删除第一次出现的关键字key
    Object remove(Object key);
    //得到顺序表的长度
    int size();
    //打印顺序表
    void display();
    //object 是引用类型 会引用其他数据
    //内容被引用着 不会回收 内存泄漏
    //清空顺序表以防内存泄漏
    void clear();
}
