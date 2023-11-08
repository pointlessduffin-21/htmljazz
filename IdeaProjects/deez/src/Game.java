import java.util.Scanner;
import java.util.Random;


public class Game {
    int number;
    int inputNumber;
    int noOfGuesses=0;
    Game() {
        Random rand = new Random();
        this.number = rand.nextInt();
    }
    void grabUserInput() {
        System.out.println("Guess the number!");
        Scanner sc = new Scanner(System.in);
        this.inputNumber = sc.nextInt();
        noOfGuesses++;
    }
    boolean isCorrectNumber() {
        if(inputNumber == number) {
            System.out.println("Congratulations! You have successfully guessed the number in " + noOfGuesses + " guesses.");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Game g = new Game();
        boolean flag = false;
        while(flag) {
            g.grabUserInput();
            flag = g.isCorrectNumber();
        }
    }
}
