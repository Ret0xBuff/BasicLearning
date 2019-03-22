import java.util.Scanner;

public class InputValue {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入： ");
        String info = scanner.nextLine();
        System.out.println("你输入的信息为： " + info);
    }
}
