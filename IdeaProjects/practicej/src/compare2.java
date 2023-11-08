import java.util.Scanner;
public class Compare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String input1 = "Input the first number: ";
        String input2 = "Input the second number: ";
        
        System.out.println(input1);
        int num1 = in.nextInt(); 

        System.out.println (input2);
        int num2 = in.nextInt();

        System.out.println(num1 + " + " + num2 + (" = ") + (num1 + num2));
        }
}