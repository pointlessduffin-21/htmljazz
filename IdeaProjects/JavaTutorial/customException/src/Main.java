import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // exception = an event after execution that disrupts the normal flow of the program
        // ex. ArithmeticException,ArrayIndexOutOfBoundsException,FileNotFoundException

        // User Defined Exceptions = custom exceptions
        // ex.DuplicateEmail, InvalidCreditException, AgeException (created by Bruh Code)

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scan.nextInt();

        try{
            checkAge(age);
        }
        catch(Exception e)
        {
            System.out.println("A problem occured: "+ e.toString());
        }
    }

    static void checkAge(int age)throws AgeException{

        if(age<18) {
            throw new AgeException("\n"+"You must be 18+ to sign up");
        }
        else {
            System.out.println("You are now signed up!");
        }
    }
}