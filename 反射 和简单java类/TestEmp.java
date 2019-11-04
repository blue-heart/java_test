package com.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射 以及一种构造框架 来适合各种情况
//通过字符串输入 给属性赋值
//可以通过方法可以修改 通过Filed也可以修改
//而且再加入新元素只需要修改字符串即可
//不赋值就是null

public class TestEmp {
    public static void main(String[] args) {
        /*
       需求：将一个字符串的内容 赋值给emp对象
       的属性
       描述：
       比如 name：张三 job：softdeveloper
       name emp对象的name属性 就是张三
       job emp对象的job属性就是softdeveloper
       实现：
       1.拆分 字符串 先| 在：
       2.实例化赋值
       如果再加一个值 就得继续赋值
         */
        String value = "name:张三|job:softDeveloper|skill:c++";
        String[] attributeNameAndValues = value.split("\\|");
        //注意 for这句后面不能有分号
       // for (String attributeNameAndValue : attributeNameAndValues)
           // System.out.println(attributeNameAndValue);

        Emp emp = new Emp();
        //传统方式通过对象.setter修改
        //setter-> 如果属性好多个 通过属性名字构造方法名字
        for (String nameAndValue:attributeNameAndValues
             ) {
            String[] nv = nameAndValue.split(":");
            //setXxx(emp,nv[0],nv[1]);
            //下面就是一个工具类
            BeanUtils.setXxx(emp,nv[0],nv[1]);


        }
        System.out.println(emp);
    }

    public static void setXxx(Object object, String name, String value) {
        Class classz = object.getClass();
        //底下的右边内容必须放到一个左边的容器里 因为不是一般无用语句
        //做了判断和改变
        String setMethodName = "set" + name.substring(0, 1).toUpperCase()
                + (name.length() > 1 ? name.substring(1) : " ");

            //有可能找不到
        try {
            Method setMethod = classz.getMethod(setMethodName,name.getClass());
            //这个把自己和父类的方法都取出来
            //那个d 取自己的
            try {
                setMethod.invoke(object, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //set都是共有的 不用要那个ture


        }
    }


