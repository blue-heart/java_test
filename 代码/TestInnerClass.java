public class TestInnerClass{
	public static void main (String[] args){
		Outer outer = new Outer();
		outer.print();
		//如何创建Inner对象
		
		 Outer.Inner inner = outer.new Inner();
		 outer.riint();
	}
	
	//Inner 类 ：内部类
	//Outer 类 ：外部类
	
	
	class Outer{
		
		
		private String message = "outer的消息";
		/*
		外部类：访问内部类
		1.在外部类的内部实例化内部类的对象
		2.通过外部类的构造方法或者方法（和方法同等对待）传入内部类的对象
		
		
		*/
		
		class Inner{
			//成员方法
			
	public void print(){
		/*1普通内部类： 可以直接访问外部类的成员属性
		Outer.this.外部类的成员属性
		2.内部类实例化： 准备外部类的对象 
		内部类 对象名称 = 外部类对象.new 内部类（）；
		Outer outer = new Outer();
		Outer.Inner inner = outer。new Inner（）；
		
		
		
		*/
		System.out.println("Inner print:"+ message);
	}
		}
		public void print(){
			
			System.out.println("Outer print:");
			Inner inner = new Inner();
			inner.print();
		}
		public void print(Inner inner){
			
			System.out.println("Outer print:");
			inner.print();
		}
	}
}