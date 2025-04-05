public class scoreboard extends answers {
    public static int percent = (100 * score) / totalScore;
    public static int wrongAns = totalScore - score;
    public static void mcq() {
        if (percent == 100) {
            System.out.println("Congratulations, " + name.userName + "! You got a perfect score! "+ score + " / " + totalScore);
            System.out.println("Your percentage is: " + percent + "% \n");
        } else if (percent >= 60) {
            System.out.println("Not bad, " + name.userName + "! Your score is " + score + " out of " + totalScore);
            System.out.println("You have " + wrongAns + " mistakes.");
            System.out.println("Your percentage is: " + percent + "% \n");
        } else {
            System.out.println("Better luck next time. " + name.userName + "! Your score is " + score + " out of " + totalScore);
            System.out.println("You have " + wrongAns + " mistakes.");
            System.out.println("Your percentage is: " + percent + "% \n");
        }
    }
}
