public class AssertExample {
    public static void main(String[] args){
        int x = 10;
        if(args.length > 0){
            try{
                x = Integer.parseInt(args[0]);
                //x = 8;
            }catch(NumberFormatException e){
                System.out.println("有问题");
            }
            System.out.println("完成");
        }
        System.out.println("Testing assertion that x == 10");
        assert x == 10 : "Our assertion faild";
        System.out.println("Test passed");
    }
}
