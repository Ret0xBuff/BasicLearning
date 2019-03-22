public class FunOverload {
    public String name;
    public int age;

    public FunOverload(){
        //this("晓明",16);
        this("晓明",16);
    }

    public FunOverload(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void say(){
        System.out.println("你的姓名是："+name+",年龄："+age);
    }

    //普通的方法，不带参数
    void test(){
        System.out.println("No parameters");
    }

    //带一个参数
    void test(int a){
        System.out.println(a);
    }

    //带2个参数
    void test(int a,int b){
        System.out.println(a + " , " + b);
    }

    //带一个双精度参数
    void test(double a){
        System.out.println(a);
    }


    public static void main(String[] args){
        FunOverload obj = new FunOverload();
        obj.say();

        obj.test();
        obj.test(1);
        obj.test(2,3);
        obj.test(5.0);
    }
}
