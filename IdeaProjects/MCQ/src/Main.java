import java.util.Scanner;

public class Main {
    private static void gameOver() { // Executes a game over screen
        Scanner input3 = new Scanner(System.in);
        System.out.println("Game over!");
        System.out.println("Press Y to restart the game or any key to Exit");
        String options = input3.next();  // Scanner reads the letter input
        if (options.toUpperCase().equals("Y")) {
            MCQ();
        } else {
            return;
        }
    }
    private static void MCQ() { // Executes the whole program by list
        answers.score = 0;
        welcome.screen();
        name.Enter();
        listQuestions.csv();
        scoreboard.mcq();
        gameOver();
    }

    public static void main(String[] args) { // Executes the main program in 1 line
        MCQ();
    }
}