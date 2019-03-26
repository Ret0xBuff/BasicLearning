public final class AbstractClassDemo {
    public static void main(String[] args){
        Teacher0 t = new Teacher0();
        t.setName("王明");
        t.work();

        Driver d = new Driver();
        d.setName("小陈");
        d.work();
    }
}


//定义一个抽象类
abstract class People0{
    private String name;    //实例变量

    //共有的setter和getter方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    //抽象方法
    public abstract void work();
}

class Teacher0 extends People0{
    //必须实现该方法
    public void work(){
        System.out.println("我的名字叫"+this.getName()+"，我正在讲课，请大家不要东张西望...");
    }
}

class Driver extends People0{
    public void work(){
        System.out.println("我的名字叫"+this.getName()+"，我正在开车，不能接听电话...");
    }
}