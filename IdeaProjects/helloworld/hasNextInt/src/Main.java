
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            System.out.println("The number is an integer");
        } else {
            System.out.println("The number is not an integer.");

        }
    }
}