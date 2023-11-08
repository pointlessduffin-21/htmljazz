import java.util.Scanner;

public class operators {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input the first number: ");
        int num1 = in.nextInt();

        System.out.println("Input the second number: ");
        int num2 = in.nextInt();

        String addition = (num1 + " + " + num2 + " = " + (num1 + num2));
        String subtraction = (num1 + " - " + num2 + " = " + (num1 - num2));
        String multiplication = (num1 + " + " + num2 + " = " + (num1 * num2));
        String division = (num1 + " / " + num2 + " = " + (num1 / num2));
        String mod = (num1 + " mod " + num2 + " = " + (num1 % num2));

        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
        System.out.println(mod);
    }
}
