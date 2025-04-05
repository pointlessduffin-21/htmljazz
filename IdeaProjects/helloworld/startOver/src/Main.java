import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        startOver();
    }

    public static void startOver() {
        Scanner startover = new Scanner(System.in);
        System.out.println("Do you wanna start again?");
        System.out.println();
        System.out.println("Type yes to continue...");
        System.out.println("Type no to quit the game.");
        String start = startover.next().toUpperCase();
        if (start.endsWith("S")) {
            System.out.println("**** Welcome to the Battleship game (Java Edition) ****");
            System.out.println("The ocean is empty rn\n");
        } else {
            System.exit(0);
        }
    }
}