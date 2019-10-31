package com.bittich2;



/*
获取class对象的3种方式
1.通过类的实例化对象getclass获取
2.通过类名.class获取
前两个 会做编译时检查 错了就是错了
第三个 不会 会在运行时加载指定的类 必须异常处理

类没有被使用 静态块不会被加载
第二个区别
第二个首次使用 会加载类的class文件到java虚拟机
并且执行静态代码块
3.通过class的静态方法forname(类的全限定名)获取

2.类的实例化对象方法
1.通过构造
2.1 通过类的class对象的newinstance方法
实例化对象 局限
2.2通过类的class对象获取constructor对象
constructor的newinstance（有参数）
 有对象就能传递参数实例化对象
 3.序列化 和反序列化
 */