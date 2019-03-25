class Teacher extends People{
    String school;
    String subject;
    int seniority;
    int height;

    //覆盖People类中的say方法
    void say(){
        System.out.println("我叫"+name+",在"+school+"教"
        +subject+",有"+seniority+"年教龄");
    }

    void lecturing(){
        System.out.println("我已经"+age+"岁了，依然站在讲台上讲课");
        height = super.getVaule();
        super.say();
    }
}


public class InheritDemo {
    public static void main(String[] args){
        //调用People类
        People p = new People();
        p.name = "晓芳";
        p.age = 19;
        //p.height = 165;
        p.say();

        //调用Teacher类
        Teacher t = new Teacher();
        t.name = "小布";
        t.age = 70;
        t.school = "清华大学";
        t.subject = "Java";
        t.seniority = 50;
        t.say();
        t.lecturing();

    }
}



class People{
    String name;
    int age;
    private int height = 165;

    public int getVaule(){return height;}

    void say(){
        System.out.println("我的名字是："+name+",年龄是："+age+",身高是："
        + height);
    }
}

