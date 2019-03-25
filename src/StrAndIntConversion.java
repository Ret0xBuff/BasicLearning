public class StrAndIntConversion {

    public void StringToInt(){
        String str[] = {"123","123abc","abc123","zbc"};

        for (String str1 : str){
            try{
                int m = Integer.parseInt(str1,10);
                System.out.println(str1 + "可以转换为整数 " + m);
            }catch(Exception e){
                System.out.println(str1 + " 无法转换为整数");
            }
        }
    }

    public void IntToString(){
        int m = 500;
        String s = Integer.toString(m);
        System.out.println("m = " + m);
        System.out.printf("s = %s，数据类型为：%s\n",s,s.getClass().getName());
    }

    public static void main(String[] args){
        StrAndIntConversion Test1 = new StrAndIntConversion();
        //字符串转整数
        Test1.StringToInt();
        //整数转字符串
        Test1.IntToString();
    }
}
