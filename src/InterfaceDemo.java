import static java.lang.System.*;

public class InterfaceDemo {
    public static void main(String[] args){
        SataHdd sh1 = new SeagateHdd(); //初始化希捷硬盘
        SataHdd sh2 = new SamsungHdd(); //初始化三星硬盘
        //SataHdd sh3 = new XXHdd(); //不能实例化抽象类
        sh1.readData();
        sh2.writeData("6666");
    }
}

//串行硬盘接口
interface SataHdd{
    //连接线的数量
    public static final int CONNECT_LINE = 4;
    //写数据
    public void writeData(String data);
    //读数据
    public String readData();
}

//维修硬盘接口
interface fixHdd{
    //维修地址
    String address = "北京海淀区";
    //开始维修
    boolean doFix();
}

//希捷硬盘
class SeagateHdd implements SataHdd,fixHdd{
    //希捷硬盘读取数据
    public String readData(){
        return "数据";
    }
    //希捷硬盘写入数据
    public void writeData(String data){
        out.println("写入成功");
    }
    //维修希捷硬盘
    public boolean doFix(){
        return true;
    }
}

//三星硬盘
class SamsungHdd implements SataHdd{
    //三星硬盘读取数据
    public String readData(){
        return "三星的数据";
    }
    //三星硬盘写入数据
    public void writeData(String data){
        out.println("写入成功");
    }
}

//某劣质硬盘，不能写数据
abstract class XXHdd implements SataHdd{
    //只能读取数据
    public String readData(){
        return "劣质的数据";
    }
}