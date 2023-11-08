import java.util.Scanner;

public class nestedLoops {
    public static void whileLoops() {
        int i = 0;
        while (i < 5) {
            System.out.println("Hello there!");
            i++;
        }
    }

    public static void foreverLoop() {
        int i = 0;
        while (i < 5) {
            System.out.println("Loop!");
        }
    }

    public static void inputLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello!");
        String answer = input.next().toUpperCase();
        while (answer.equals("HELLO")) {
            System.out.println("Hello!");
            answer = input.next().toUpperCase();
        }
    }

    public static void examLoop() {
        String a = "";
        a += "0";
        if (a == "0") {
            System.out.println("a = 0");
        } else if (a == "1") {
            System.out.println("a is 1");
        } else if (a == "a") {
            System.out.println("a is a!");
        } else {
            System.out.println("a is something else!");
        }
    }

    public static void main(String[] args) {
        examLoop();
    }
}
