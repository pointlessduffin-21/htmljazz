public class answers {
    public static int score = 0; // Starts the count of the score to 0
    public static int totalScore = 10; // Starts the count of the totalScore to 10 according to the available questions
    public static void correct() {
        System.out.println("Correct!");
        answers.score++;
        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
    }

    public static void wrong() {
        System.out.println("Your score is " + score + " out of " + totalScore + "!");
        if (totalScore != 0) {
            int percent = (100 * score) / 10;
            System.out.println("Your score is: " + percent + "\n");
        }

    }
}
