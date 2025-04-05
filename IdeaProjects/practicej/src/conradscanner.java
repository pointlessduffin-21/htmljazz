import java.util.Scanner;

public class operators {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String first = "Input first integer: ";
        String second = "Input second integer: ";
        //String

        System.out.println(first);
        int num1 = in.nextInt();

        System.out.println(second);
        int num2 = in.nextInt();

        System.out.println(num1 + " >= " + num2 + (num1 > num2));
        System.out.println(num1 + " <= " + num2 + (num1 < num2));
        System.out.println(num1 + " ==  " + num2 + (num1 == num2));
    }
}