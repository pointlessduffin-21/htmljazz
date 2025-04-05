import java.util.Scanner;

public class Main {
    public static String Text = "Minatay jud ang Java pero okay ra na , laban lang gud, lavarnnn XD";
    public static void Deez() {             // Executes the command indefinitely until the loop is false.
        while (true) {
            System.out.println(Text);
        }
    }
    public static void Nutz() {             // Executes the command with only the amount of times you want
        int i = 0;
        int times = 200;
        for (i=0; i<times; i++) {
            System.out.println(Text);
        }
    }

    public static void Selector() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence!");
        String sentence = scanner.nextLine();
        System.out.println("How do you want the program to run?");
        System.out.println("Loop or Specific?");
        String choice = scanner.nextLine();

        if (choice.toUpperCase().equals("LOOP")) {
            Deez();
        } else if (choice.toUpperCase().equals("SPECIFIC")) {
            System.out.println("You have chosen Specific!");
            System.out.println("Please enter a specific amount you want the sentence to print!");
            int amount = scanner.nextInt();
            Deez();
        }
    }
    public static void main(String[] args) {
        Nutz();
    }
}