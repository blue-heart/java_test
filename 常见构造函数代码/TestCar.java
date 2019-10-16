package cn.dm;

public class TestCar{


    private boolean type;

    private int life;

    private String living;

    public TestCar(boolean type, int life, String living){

        this.type = type;
        this.life = life;
        this.living = living;

    }


    public static void main(String[] args){
        TestCar benchi = new TestCar(true, 50, "德国");
        TestCar aodi = new TestCar(false, 60, "美国");
        System.out.println(benchi.getLiving());
        benchi.color();
        benchi.height();

        System.out.println(aodi.getLiving());
        aodi.color();
        aodi.height();



    }
    public void color(){
        System.out.println("看，一个红色的车");
    }
    public void height(){
        System.out.println("奥，这么高的车");
    }
    public void setLife(){
        this.life = life;
    }
    public String getLiving(){
        return this.living;
    }

}

