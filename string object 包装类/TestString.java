package kt3.dm;

//不能有两个*/ 否则错误

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TestString {
    public static void printStringArray(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

        }
    }

    //这样才能有返回值
   /* public static String toCap(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return str;
        }
        //这是字符 没有【】
        //但是要定义part名字
        String part1 = str.substring(0, 1).toUpperCase();
        String part2 = " ";
        if (str.length() > 1) {
            part2 = str.substring(1);
        }
        return part1 + part2;
    }*/

    public static void main(String[] args) {
        //可变字符序列
        //stringbuffer
        //stringbuilder
       /* StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = sb.append(1);
        //1.append 返回的stringbuffer是不是当前
        //调用方法的对象 是的
        //2.append 链式访问
        //java的潮流 把写代码变的和说话一样
       // System.out.println(sb==sb1);
        sb1.append("Hello").append("word")
                .append("!!");
        //toString可以不用 默认调用
        System.out.println(sb.toString());

        链式访问
        以前调一下赋值一次
        现在先用对象调用 方法
        最后再返回一个值
        编程的新的发展
        object.a（）
        .b（）.c（）
        .....
         */
       //tostring 是把这个对象编程字符串
        //会默认调用
      // StringBuffer sb =new StringBuffer("HELLO WORD");
      //  System.out.println(sb.reverse());//这是反转
        //这个stringbuffer 使用后会进行更改
        //下面用方法是 用更改后的
        //string 不会
        //prinln打印对象会调用tostring
        //插入
      //  System.out.println(sb.delete(1,5));
        //看api文档 底下就是例子，看后面数据类型
       // System.out.println(sb.insert(1,"uuu"));
        //字符串数组拼接乘字符串，每个元素用逗号分割
        //【“a”，“b”“c”“d”】-a，b，c
        //可以变为字符串截取
        //也可以直接截取
        String[] str = new String[]{
                "ASD",
                "'ADS",
                "SAF",
                "ASF"
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <str.length ; i++) {
            sb.append(str[i]).append(",");

        }
        //这儿也是人工的方式 用减少长度的方式
        //减少了一个多余的字符
        //同样说明减少长度等于删除字符
        //设置字符序列长度
        //长度自然可以加减 属性
        sb.setLength(sb.length()-1);
        System.out.println(sb);
















        //特别注意字符 和字符数组
       /* String []strs = new String[]{
                null,
                //空字符和空字符串
                "",
                "  ",
                "Hello",
                "word",
                "H",
                "w"
        };
        for (int i = 0; i <strs.length ; i++) {
            //String item = strs[i];
            //String cap = toCap(item);
            //System.out.println("["+item+"] tocape ["+cap+"]");
            System.out.println(strs[i]+toCap(strs[i]));
            //定义一个变量和直接打一样的效果
            //要注意字符和字符串

        }



        }*/


    }
}



       /* //字符串替换
        //手机号码替换
        System.out.println("hello word".
                replaceAll("l","_"));
        System.out.println("hello word".
                replaceFirst("l","_"));

        //字符串拆分
        {
            String str1 = "hello word java is best";
            String[] segments = str1.split("");
            printStringArray(segments);
            String[] segments2 = str1.split("", 2);
            printStringArray(segments2);


            //ip地址拆分
            System.out.println("ip");
            String ip = "192.168.1.110";
            //ipv4 x.x.x.x 0-255
            //以下 就不能return 只能定义
            //就好比 数组必须用for来找
            String[] ipsegments = ip.split("\\.");
            printStringArray(ipsegments);
            //第一个表示转义 第二个\.表示 点 不是正则
            // .表示正则表达式的任意
            String line = "zhangsan:22|lisi:18|wangwu:23";
            //底下要有【】
            //字符串用字符数组接受
            String[] values = line.split("\\|");
            printStringArray(values);
            for (int i = 0; i < values.length; i++) {
                String[] kv = values[i].split(":");
                String name = kv[0];
                String age = kv[1];//String - int
                System.out.println("姓名" + name + "年龄" + age);

            }
            System.out.println("----substring------");
            System.out.println("hello word".substring(4, 7));
            //越界【0-length-1）
            //System.out.println("hello word".substring(11,12));
            //如果上面代码不去掉 底下也出不来
            System.out.println("hello word".substring(0, 1));
        }
        //代码块作用 表示后面的看不到他
        //他可以看到前面的代码
        {
            //去掉空格 前后的
            System.out.println("String");
            String str1 = " hello word ";
            System.out.println(str1);
            System.out.println(str1.trim());
        }
        {
            System.out.println("大小写转换");
            String str1 = "i老虎 u";
            //只转字母，其他没有大小写区分
            System.out.println(str1.toUpperCase());
            System.out.println(str1.toLowerCase());
        }
        {
            //false 判断的是长度是否0
            System.out.println("hello".isEmpty());
            System.out.println("".isEmpty());
            System.out.println(" ".isEmpty());
        }
        */


      /* //字符串查找
        System.out.println("hello word".contains("word"));
        //true
        System.out.println("hello word".contains("k"));
        //false
        String filename = "张三的简历.pdf";
        int index = filename.lastIndexOf(".");
        if (index == -1){
            System.out.println("未找到dot.");
        }else {
            //如果没有就什么都不打印
            //字符串截取
            System.out.println(filename.substring(index));
            System.out.println(filename.substring(index+1));

            System.out.println("找到dot.");
        }
        System.out.println(filename.endsWith(".pdf"));
        //true*/



        //字符串比较 string类的成员方法
        //字符串比较的方法
       /* System.out.println("a".equals("a"));//true
        System.out.println("A".equals("a"));//true
        //邮箱不区分大小写
        //这个方法返回一个boolean类型的
        System.out.println("A".equalsIgnoreCase
                ("a"));//true
        System.out.println("A".compareTo("a"));//<0
        System.out.println("a".compareTo("A"));//>0
        System.out.println("a".compareTo("a"));//0
        System.out.println("张".compareTo("李"));
        //unicode编码值比较 、u4e000
        //这个没有意义*/

  //  }

//}

       /* int x = 10;
        int y =10;
        System.out.println(x==y);//true
        //直接赋值法
        String a ="hello java";
        String b = "hello java";
        System.out.println(a==b);//true
        //类 接口 字符串引用都可以new

        //构造方法
        String  c = new String("bit");
        String  d = new String("BIT");
        System.out.println(c==d);//false
        String e = new String("HELLO JAVA");
        System.out.println(a==e);//false
        /*
        1. 数值比较 基本数据类型数值（栈上）
        引用数据类型（地址）
        2.字符串内容比较 equals
        如果要看a和 张三一样不一样
        这样写 可以运行
        技巧 ‘zhangsan’.equals（a）
        如下
        ==比较字符串地址 equals比较数值
        "abc"这是一个匿名字符串对象
        除了基本数据类型其他的类型都可以new
        都有对象 给个String 才是一个实例化的
        就是本来在堆上 然后 有一个堆名称指向他

        String 有一个常量池（直接赋值法-采用共享模式
        ，减少内存使用）
        拿到匿名对象在堆空间找，有去指向没有再创建
        字符串对象修改就会创建一个新的字符串对象

        所有的字符串是String的匿名对象
        就是只要 有一个字符串 刚一出来 就默认为
        匿名对象 先放堆内存  然后构造一个 就会再创建一个
        之前那个 就会被回收 原因就是 所有字符串都是
        String匿名对象
        构造创建 先有一个匿名对象，再创一个新的对象
        然后之前的那个 被回收
         ）
        //e=null;
       // System.out.println(a.equals(e));//false
        //构造类入池（字符串入池）
        String  g = "JAVA IS BEST";
        //这个入池操作 之前先创池 有池进池
        //就是把构造变成直接赋值的方式
        String f = new String("JAVA IS BEST").intern();
        //String  g = "JAVA IS BEST";//这儿注意
        //要有大小写一直 字符串内比较
        System.out.println(f==g);//true
    }
}
/*
1. 直接赋值：只会开辟一块堆内存空间，并且
该字符串对象可以自动保存在对象池中以供下次使用。
2. 构造方法：会开辟两块堆内存空间，其中一块
成为垃圾空间，不会自动保存在对象池中，可以使用
intern()方法手工入池。
*优先采用直接赋值法*
 */
