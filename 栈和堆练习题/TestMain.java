package zd.dm;

public class TestMain {
    public static void main(String[] args) {
      /*
      队列：
      MyQueneImpl myQuene = new MyQueneImpl();
        myQuene.add(10);
        myQuene.add(25);
        myQuene.add(35);
        System.out.println(myQuene.poll());
        System.out.println(myQuene.peek());
        System.out.println(myQuene.size());*/
/*
      //在类外 就可以调用
        //括号题
      Solution solution = new Solution();
      boolean flg1 = solution.isValid("{[]}");
        System.out.println(flg1);
     boolean flg2 =  solution.isValid("([)]");
        System.out.println(flg2);
        boolean flg3 = solution.isValid("[({}");
        System.out.println(flg3);
        //中缀表达式 转后缀表达式

        （2+3）*4-5；
        （（（2+3）*4）-5）
        23+4*5-  逆波兰式
        利用栈可以计算
        先放数据 碰到符号计算 在放入 以此类推
         */

/*//队列 实现栈
        TestMyStack testMyStack = new TestMyStack();
        testMyStack.push(10);
        testMyStack.push(20);
        testMyStack.push(30);
        System.out.println(testMyStack.pop());//30
        System.out.println(testMyStack.top());//20
        System.out.println(testMyStack.size());*/
/*

//栈实现队列：
        TestMyQueue testMyQueue = new TestMyQueue();
        testMyQueue.push(11);
        testMyQueue.push(12);
        testMyQueue.push(13);
        testMyQueue.push(14);
        System.out.println(testMyQueue.peek());//11
        testMyQueue.push(15);
        testMyQueue.pop();
        System.out.println(testMyQueue.peek());//15
        testMyQueue.pop();
        testMyQueue.pop();
        testMyQueue.pop();

        System.out.println(testMyQueue.peek());//15
        */
//最小栈
        /*
        MinStack minStack = new MinStack();
        minStack.push(91);
        minStack.push(11);
        minStack.push(5);
        minStack.push(-8);
        minStack.push(11);
        System.out.println(minStack.getMin());//-8
        minStack.pop();
        System.out.println(minStack.getMin());//5*/
        //循环队列
        MyCircularQueue myCircularQueue = new MyCircularQueue(10);
        myCircularQueue.enQueue(10);
        myCircularQueue.enQueue(20);
        myCircularQueue.enQueue(30);
        myCircularQueue.enQueue(40);
        myCircularQueue.deQueue();
        System.out.println(myCircularQueue.front());
        System.out.println(myCircularQueue.rear());


    }
}
    //找出正确的括号
    //栈的题 通过栈来做
    /*
    1.左括号入栈
    2.如果遇到右括号 判断栈顶元素是否为对应的左括号
     */
    class  Solution{


        public boolean isValid(String str){
            //这就是一个栈
            char[] stack = new char[str.length()];
            int top = 0;
            //直接从字符串中取字符
            //char ch = str.charAt(0);
            for (int i = 0; i <str.length() ; i++) {
                if (str.charAt(i)=='('||
                str.charAt(i)=='{'||
                str.charAt(i)=='['){
                    //先放数据 在自加
                    stack[top++] = str.charAt(i);
                }else {
                    //可能是右括号
                    //取出栈顶元素是否匹配
                    //一开始就给右括号 top=0；
                    if (top == 0){
                        System.out.println("右括号多"
                        );
                        return false;
                    }
                    //如果不是第一个 取出栈顶元素
                    //取出top-1的值
                    char ch = stack[top-1];
                    if (ch=='('&&str.charAt(i)==')'||
                            ch=='['&&str.charAt(i)==']'||
                            ch=='{'&&str.charAt(i)=='}'){
                        --top;
                    }else {
                        System.out.println("右括号匹配顺序不一致");
                        return false;
                    }

                }

            }
            //栈内数据永远是左括号
            if (top>0){
                System.out.println("左括号多于右括号");
                return false;
            }
            //所有走完说明匹配成功 和上面的if对应
            System.out.println("括号匹配成功");
            return true;
        }
    }




   /*
   栈：
   public static void main(String[] args) {
        MyStackImpl myStack = new MyStackImpl();
        myStack.push(10);
        myStack.push(99);
        myStack.push(21);
        myStack.push(77);
        //有返回值就要打印
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.size());


    */

