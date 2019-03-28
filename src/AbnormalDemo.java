
//MyException
class MyException extends Exception{
    private int detail;
    MyException(int a){
        detail = a;
    }

    public String toString(){
        return "MyException[" + detail + "]";
    }
}

public class AbnormalDemo {

    static void demoproc(){
        try{
            throw new NullPointerException("demo");
        }catch(NullPointerException e){
            System.out.println("Caught inside demoproc.");
            throw e;
        }
    }

    static void throwOne() throws IllegalAccessException{
        System.out.println("Inside throwOne.");
        throw new IllegalAccessException("demo");
    }

    //Custom Fun
    static void compute(int a ) throws MyException{
        System.out.println("Called compute(" + a + ")");
        if(a>10){
            throw new MyException(a);
        }
        System.out.println("Normal exit");

    }

    public static void main(String[] args){
        try{
            int a = args.length;
            System.out.println("a = " + a);
            int b = 42 /a;
            int c[] = {1};
            c[42] = 99;
        }catch(ArithmeticException e){
            System.out.println("Divide By 0:" + e);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index oob:" + e);
        }

        System.out.println("After try/catch blocks");

        //抛出异常演示
        System.out.println("\n\nthrow  Demo");
        try{
            demoproc();
        }catch(NullPointerException e){
            System.out.println("Recaught: " + e);
        }

        //throws演示
        try{
            throwOne();
        }catch(IllegalAccessException e){
            System.out.println("Caught " +e);
        }finally {
            System.out.println("HAHA");
        }

        //Custom Exception demo
        try{
            compute(1);
            compute(20);
        }catch (MyException e){
            System.out.println("Caught " + e);
        }

    }
}
