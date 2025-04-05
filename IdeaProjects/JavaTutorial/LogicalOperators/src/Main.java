import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        /* logical operators = used to connect two or more expressions
            && = (AND) both conditions must be true
            || = (OR) either condition must be true
            ! = (NOT) reverses boolean value of condition

            >= - means Greater than or Equal to
            <= - means Less than or Equal to

         */

        // && = AND

        /*
        int temp = 40;

        if(temp>30) {
            System.out.println("It it hot outside!");
        }
        else if(temp>=20 && temp<=30) {
            System.out.println("It is warm outside");
        }
        else {
            System.out.println("It is cold outside");
        }
        */

        // || = OR
        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("You are playing a game! Press q or Q or no to quit");
        String response = scanner.next();

        if(response.equals("q") || response.equals("Q") || response.equals("no")) {
            System.out.println("You quit the game!");
        }
        else {
            System.out.println("You are still playing the game!");
        }
        */

        //! = NOT

        Scanner scanner = new Scanner(System.in);

        System.out.println("You are playing a game! Press q or Q or no to quit");
        String response = scanner.next();

        if(!response.equals("q") && !response.equals("Q") && !response.equals("no")) {
            System.out.println("You are still playing the game!");
        }
        else {
            System.out.println("You quit the game");
        }

    }
}