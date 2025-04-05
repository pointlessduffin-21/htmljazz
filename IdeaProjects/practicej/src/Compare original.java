import java.util.Scanner;
public class Compare {
    public static void main( String[] args) {

        // Adding Scanner to the line to grab input from the user
        Scanner input = new Scanner(System.in);
        int num1; //1st line to compare 
        int num2; //
        
        System.out.print("Input first integer: ");
        num1 = input.nextInt();

        System.out.println("Input second integer: ");
        num2 = input.nextInt();
        
        if (num1.greater (num2));
            System.out.printf(("%d > %d\n"), num1, num2);
        if ( num1.lesser(num2));
            System.out.printf(("%d > %d\n"), num1, num2);
        if (num1.(num2));
            System.out.printf(("%d = %d\n"), num1, num2);
    }
}