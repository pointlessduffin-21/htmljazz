import java.util.Scanner;

public class Main {
    public class Score() {
        int playerScore = 0;
        int aiScore = 0;
        if (playerScore < 10) {

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Player 1! \n");
        System.out.println("Rock, Paper or Scissors?");
        String playerOne = input.next().toUpperCase();
        System.out.println("Player 2! \n");
        System.out.println("Rock, Paper or Scissors?");
        String playerTwo = input.next().toUpperCase();

        if(playerOne.equals("ROCK")){
            if (playerTwo.equals("PAPER")){
                System.out.println("Player Two wins!");
            } else if (playerTwo.equals("SCISSORS")) {
                System.out.println("Player One wins!");
            } else {
                System.out.println("Tie!");
            }
        }

        if(playerOne.equals("PAPER")) {
            if (playerTwo.equals("SCISSORS")) {
                System.out.println("Player 2 wins!");
            } else if (playerTwo.equals("ROCK")) {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Tie");
            }
        }

        if (playerOne.equals("SCISSORS")) {
            if (playerTwo.equals("ROCK")) {
                System.out.println("Player Two wins!");
            } else if (playerTwo.equals("PAPER")) {
                System.out.println("Player One wins!");
            } else {
                System.out.println("Tie!");
            }
        }
    }
}