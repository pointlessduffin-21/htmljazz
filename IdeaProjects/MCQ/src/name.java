import java.util.Scanner;

public class name {
    public static String userName;
    public static void Enter() {
        Scanner scanner = new Scanner(System.in);    //Scanner import

        System.out.println("Please enter your name!");
        userName = scanner.nextLine();     // Scanner reading the user's input
        System.out.println("Welcome " + userName + "! \n");
    }
}
