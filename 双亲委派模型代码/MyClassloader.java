package com.classloader;

import com.sun.org.apache.regexp.internal.RE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassloader extends ClassLoader {
    public String classPath = "D:\\idea.dm2\\out\\production\\idea.dm2\\";

    public Class loadClassData(String className) {
        //className- class
        /*
        D:\idea.dm2\out\production\idea.dm2\com\classloader\Member.class
        classpath：D:\idea.dm2\out\production\idea.dm2\
         */
       byte[] data = loadData(className);
//自己本来要写一个双亲委派模型 但是有直接调用
        return super.defineClass(className,data,0,data.length);
    }

    private byte[] loadData(String className) {
        //转义字符
        //最后两个斜杠刚好 为一个点 和后面连接

        String classFile = classPath+className.replace
                (".", "\\") + ".class";
        try {
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 FileInputStream in = new FileInputStream(classFile);
            ) {
                byte[] buff = new byte[1024];
                int len = 1;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                out.flush();
                return out.toByteArray();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        throw new RuntimeException("xun xing shi bai");


    }
}
