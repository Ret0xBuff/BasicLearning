public class StringTest {
    public static void main(String[] args){
        String fragment = "abcdefghijklmnopqqrstuvwxyz";
        int times = 100000;

        //通过String对象
        long timeStart1 = System.currentTimeMillis();
        String str1 = "";
        for(int i=0;i<times;i++)
        {
            str1 += fragment;
        }
        long timeEnd1=System.currentTimeMillis();
        System.out.println("String: " + (timeEnd1 - timeStart1) + "ms");

        //通过StringBuffer
        long timeStart2 = System.currentTimeMillis();
        StringBuffer str2= new StringBuffer();
        for(int i=0;i<times;i++){
            str2.append(fragment);
        }
        long timeEnd2 = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (timeEnd2-timeStart2) +"ms");

    }

}
