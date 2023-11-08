import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // exception = is an event that occurs during the execution of a program that disrupts the normal flow of instructions
        // Exception Handling = the process of giving out an error message or an execution done when an exception error occurs
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a whole number to divide");
            int x = scanner.nextInt();

            System.out.println("Enter a whole number to divide by");
            int y = scanner.nextInt();

            int z = x / y;

            System.out.println("Result: " + z);
        } catch(ArithmeticException e) {
            System.out.println("Can't Divide by Zero!");
        } catch(InputMismatchException e) {
            System.out.println("Please enter a number!");
        } catch (Exception e) {  // REMOVE THIS DURING DEBUGGING!!!!!
            System.out.println("Something went wrong!");
            System.out.println("Reason: " + e.toString() ); // or just add this!
        }

        finally {    //Executes no matter if there's an error or not!!!
            scanner.close();  //Mainly used to close Scanner
        }

    }
}