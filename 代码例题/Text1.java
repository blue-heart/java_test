package zy.dm;
//setter 和getter 方法都可以 被外界调用
//setter 可以修改参数 getter 可以类外调用
//两个数据 共享 而且 传参数 用setter
// 用参数用getter

public class Text1 {
    public static void main(String[] args) {
       //Message message = new Message("MARY",false);
        Message message;
        if (args.length ==1&& args[0].equals("en")){
            message =new Message("mary",false);
        }else{
            message =new ChineseMessage("mary",false);
        }






        message.setAge(25);
        message.setAdress("afasfasfa");
        message.setPost("saras");
        message.setTel("462322232");
        message.printPersonInformation();




    }
}
        class  Message {
            private final String name;
            private final boolean gender;
            private String post;
            private int age;
            private String tel;
            private String adress;



            public  Message(String name, boolean gender) {//final修饰的属性
                // 必须初始化而且不能修改
                //这里通过构造方法传递参数
                this.name = name;
                this.gender = gender;
            }

            public void setPost(String post) {
                this.post = post;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public void setAdress(String adress) {
                this.adress = adress;
            }

            public String getPost() {
                return this.post;
            }

            public int getAge() {
                return this.age;
            }

            public String getTel() {
                return this.tel;
            }

            public String getAdress() {
                return this.adress;
            }

            public String getName() {
                return this.name;
            }

            public boolean isGender() {
                return this.gender;
            }

            public void printPersonInformation() {
                System.out.println("name" + this.name + "post" + this.post);
                System.out.println("sex" + (this.gender ? "female" : "male") + "age" + this.age);
                //三目运算符判断
                System.out.println("tel" + this.tel + "adress" + this.adress);
            }
        }

            //开闭原则 修改关闭 继承开放
            class ChineseMessage extends Message {
                public ChineseMessage(String name, boolean gender) {
                    super(name, gender);//没有修改的机会 只能 super
                }

                public void printPersonInformation() {
                    //此时get方法的作用就出来了 提供视野 本来找不到
                    //在类外可以看到
                    System.out.println("姓名" + this.getName() + "邮件" + this.getPost());
                    System.out.println("性别" + (this.isGender() ? "男" : "女") + "年龄" + this.getAge());
                    System.out.println("tel" + this.getTel() + "adress" + this.getAdress());
                }
            }





