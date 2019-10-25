package kt3.dm;
//多例 =》枚举
//1. 构造方法私有化。
//2. 类内部一定会提供一个static方法用于
// 取得实例化对象
public class Sex {
    private String desc;

    private static final Sex MALE
            = new Sex("男");
    private  static  final  Sex FEMALE
            = new Sex("女");

    public  static  Sex getInstance
            (String desc) {
        switch (desc){
            case"男":
                return MALE;
            case "女":
                return FEMALE;
                default:
                    return null;//异常体系

        }
    }
    private Sex(String desc){
        this.desc = desc;
    }
    public  String  toString(){
        return this.desc;
    }
}

