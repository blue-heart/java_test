public class Car{
	
	//属性
	private String engineNumber;
	
	//品牌
	private String brand;
	
	//颜色
	private String color;
	
	//ture 自动挡 false 手动挡
	private boolean  autoType;
	
	//构造方法
	//方法的参数名：符合标识符的命名规范 简明思议
	public Car(String engineNumber){
		this.engineNumber = engineNumber;
	}
	//getter setter
	public String getEngineNumber(){
		return this.engineNumber;
	}
	
	public String getBrand(){
		return this.brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
		
	}
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public boolean isAutoType(){
		return this.autoType;
	}
	public void setAutoType(boolean autType){
		this.autoType = autType;
	}
	public String getCarDescription(){
		return "发动机编号："+this.getEngineNumber()+"\n"
		+"品牌："+this.brand+"\n"
		+"颜色："+this.color+"\n"
		+"是否自动挡："+this.isAutoType();
	}
	
	//行为功能
	public void drive(){
		System.out.println("向前开 喝酒不开车，开车不喝酒");
		//结合方法使用
		if(this.isAutoType()){
			System.out.println("自动挡，好开");
			
		}else{
			System.out.println("手动挡，手疼");
		}
	}

	//修改后的
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		Car wlhg = new Car("wl0010");
		wlhg.drive();
		wlhg.setAutoType(true);
		wlhg.drive();
		wlhg.setColor("白色");
		wlhg.setBrand("五菱宏光");
		
		String desc = wlhg.getCarDescription();
		System.out.println(desc);
	}
	}
	//数组
	//1.静态初始化
	//2.动态初始化
	Car[] cars = new Car[]{
		new Car("wl00110");
		new Car("hx00110");
	};
	cars[0].setBrand(""); //数组赋值 比单一的更快；
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
