package com.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    public static void setXxx(Object object, String attributeName, Object attributeValue) {
        Class classz = object.getClass();

        String setMethodName = "set" + attributeName.substring(0, 1).toUpperCase()
                + (attributeName.length() > 1 ? attributeName.substring(1) : " ");


        try {
            Method setMethod = classz.getMethod(setMethodName,attributeValue.getClass());

            try {
                setMethod.invoke(object, attributeValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }




    }

    /**
     * 对象的属性值拷贝
     *将source对象中的属性值赋值到target对象中的属性，属性名一样
     * example
     *
     * source
     * String name
     * String address
     * Integer age
     * Data birthday
     *
     * target
     * String name
     * String addres
     * String email
     * 都有才赋值 原对象-现对象
     * 结果： source name，address-》target name address
     *

     * @param source
     * @param target
     */

    public static void copy(Object source,Object target){
        //TODO
    }
}


