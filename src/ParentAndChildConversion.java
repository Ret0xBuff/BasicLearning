public class ParentAndChildConversion {
    public static void main(String[] args){
        SuperClass superObj = new SuperClass();
        SonClass sonObj = new SonClass();

        //直接转换（父类转子类，即向下转型）编译可以通过，但运行会报错
        //SonClass sonObj0 = (SonClass) superObj;

        //父类不是子类的实例
        if(superObj instanceof SonClass){
            SonClass sonObj1 = (SonClass)superObj;
        }else{
            System.out.println("不能转换");
        }

        //先向上转型，在向下转型
        superObj = sonObj;
        //父类是子类的实例
        if(superObj instanceof SonClass){
            SonClass sonObj2 = (SonClass)superObj;
            System.out.println("转换完成");
        }else{
            System.out.println("不能转换");
        }
    }
}


class SuperClass{}
class SonClass extends SuperClass{}
