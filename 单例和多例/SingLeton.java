package kt3.dm;

import java.lang.ref.PhantomReference;

public class SingLeton {
    /*
    单例设计模式
    1.一个类只能实例化一个对象
    写法:
    1.构造方法私有
    2.公开的静态方法提供实例化对象
    3.私有的静态属性 是单例类型
    方式：
    1.饿汉式
    2.懒汉式
     */
    //属性的类型是 singleton
   // private  static  SingLeton instance ;
    //小细节 加个final 不可修改 这样更加保险
    private final  static  SingLeton instance
            =new SingLeton();
    //懒汉式
    // = new SingLeton();
    //外部访问不到 构造方法
    //所以得提供公开的静态方法实例化对象
    private SingLeton(){


    }
    public static SingLeton getInstance(){
        //每次访问都会新建一个 也不可以
        //要有一个私有的属性静态
        //return  new SingLeton();
      //  if (instance==null){
          //  instance = new SingLeton();
       // }

        //return  instance;
        return  instance;
    }
}
