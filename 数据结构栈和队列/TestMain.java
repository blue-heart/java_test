package zd.dm;

public class TestMain {
    public static void main(String[] args) {
        MyQueneImpl myQuene = new MyQueneImpl();
        myQuene.add(10);
        myQuene.add(25);
        myQuene.add(35);
        System.out.println(myQuene.poll());
        System.out.println(myQuene.peek());
        System.out.println(myQuene.size());
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


    */}

