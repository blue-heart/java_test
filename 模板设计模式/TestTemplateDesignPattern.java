package kt2.dm;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.Callable;
//这是一个正常的方法 不是构造
//但是 方法块同样可以防止名字重复
//只要语法不错 不调用 多余的也没事代码中
//名字随便起
//先看左边的类 必须有这个方法 然后再调用子类覆写

public class TestTemplateDesignPattern {
    public static void main(String[] args) {
        //new对象 构造可以 普通类也可以
       /* Coffee coffee = new Coffee();
        coffee.prepare();
        Tea tea = new Tea();
        tea.preapre();*/
        Dink dink1 = new Coffee();
        //向上转型 的应用
        //因为 方法覆写 子类肯定有父类的方法
        //这时调用的是子类覆写的方法
        dink1.Preare();
        //2
        Dink dink2 = new Tea(false);
        //1找不到符号 父类没有，左边是父类 先执行
        //2可以用构造方法
        //1. dink2.setAddMinorMaterial(false);

        //上面用set传递参数
        //下面用构造传递参数
        dink2.Preare();

    }




}
/*
模板设计模式
1.子类和父类的继承关系
2.抽象类，定义每一步执行的方法
由实现类完成方法的实现（覆写）
 */
abstract class  Dink
     {

    //制作饮品的步骤
    public final void Preare(){
        //此处final防止覆写
        //因为这是大步骤 不能改
        //1.烧水
        boilWater();
        addMaterial();
        cup();
        //addMinorMaterial();
        if (this.isAddMinorMaerial()){
            //这里调用 就代表值是什么就是什么
            addMinorMaterial();
        }

    }
    //public abstract void boilWater();
         public  void  boilWater(){
             System.out.println("haode");

         }
    public abstract void addMaterial();
    public abstract void cup();
    public abstract void addMinorMaterial();

    public boolean isAddMinorMaerial(){
        return true;
        //这个方法是控制别的子类是否有修改
        //和if结合起来用
        //子类如果返回值不一样
        //可以当做条件来决定是否执行
        //这是一种改变条件的方式
        //通过方法 覆写 和if判断
    }










}
class Coffee extends Dink{
//class Coffee {
    /*
    制作算法
    定义了算法的执行步骤
     */

   /* public void prepare() {
        /*
        1.烧水boilwater（）；
        2.添加主料addMaterial（）；
        3.饮品倒入杯子cup（）；
        4.添加辅料addMinorMaterial（）；

        this.boilWater();//这儿体现出this可以不写的作用
        this.addMaterial();
        this.cup();
        this.addMinorMaterial();

    }*/

  public void boilWater()
   //本来要私有的仅仅给自己
    //但是抽象的继承要用public
    {
        super.boilWater();
        System.out.println("1:kaishuibenenghe");
    }

   public void addMaterial() {
        System.out.println("2:往水中添加咖啡粉");
    }

   public void cup() {
        System.out.println("3:加水");
    }

    public void addMinorMaterial() {
        System.out.println("4：加糖");
    }
}
class Tea extends Dink {
   /* public  void  preapre(){
        //这个就体现出方法块外不可见
        //还有new出的对象才能调用本类方法
        boilWater();
        addMaterial();
        cup();
        addMinorMaterial();
    }*/
   private boolean addMinorMaterial=true;
   public  Tea(){
       this.addMinorMaterial=addMinorMaterial;

    }
    public  Tea(boolean addMinorMaterial){
       this.addMinorMaterial=addMinorMaterial;

    }

    public void boilWater() {
        System.out.println("1:煮茶烧水");
    }

    public void addMaterial() {
        System.out.println("2:往水中添加茶叶");
    }

    public void cup() {
        System.out.println("3:加水");
    }

    public void addMinorMaterial() {
        System.out.println("4：加柠檬");
    }
   /* public void  setAddMinorMaterial(boolean addMinorMaterial){
       this.addMinorMaterial= addMinorMaterial;

    }*///父类没有 所以去掉
    public boolean isAddMinorMaerial(){
        //return  false;
        return this.addMinorMaterial;

    }
}
