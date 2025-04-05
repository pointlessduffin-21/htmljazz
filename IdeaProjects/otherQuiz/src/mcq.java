import java.io.File;
import java.util.Scanner;

public class mcq extends welcome {


    public static void multipleChoice() {
        String userName = null;

        int score = 0;
        int totalScore = 10;
        Scanner input2 = new Scanner(System.in);

        try {
            System.out.println("Choose your Multiple Choice Question (MCQ) Set. The options include: ");
            System.out.println("1. HTML Basics");
            System.out.println("2. Java Basics");
            System.out.println("3. C++ Basics");
            int option = input2.nextInt();

            if (option == 1) {
                System.out.println("HTML Basics");
                File csv = new File("Questions/HTMLMCQ.csv");
                Scanner q1 = new Scanner(csv);
                while (q1.hasNextLine()) {
                    int percent = (100 * score) / totalScore;
                    String line = q1.nextLine();
                    String[] lineArray = line.split(",");
                    System.out.println(lineArray[0]);
                    System.out.println("a. " + lineArray[1]);
                    System.out.println("b. " + lineArray[2]);
                    System.out.println("c. " + lineArray[3]);
                    System.out.println("d. " + lineArray[4]);
                    String correctAnswer = lineArray[5];
                    Scanner userAns = new Scanner(System.in);
                    String userAnswer = userAns.next().toUpperCase();
                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        score++;
                        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
                    } else {
                        System.out.println("Wrong!");
                        System.out.println("The answer is: " + lineArray[5] + ". " + lineArray[6]);
                        System.out.println("Your score is " + score + " out of " + totalScore + "!");
                        System.out.println("Your score is: " + percent + "\n");

                    }
                }
            } else if (option == 2) {
                System.out.println("Java Basics");
                File csv = new File("Questions/JavaMCQ.csv");
                Scanner q2 = new Scanner(csv);

                while (q2.hasNextLine()) {
                    int percent = (100 * score) / totalScore;
                    String line = q2.nextLine();
                    String[] lineArray = line.split(",");
                    System.out.println(lineArray[0]);
                    System.out.println("a. " + lineArray[1]);
                    System.out.println("b. " + lineArray[2]);
                    System.out.println("c. " + lineArray[3]);
                    System.out.println("d. " + lineArray[4]);
                    String correctAnswer = lineArray[5].trim();
                    Scanner userAns = new Scanner(System.in);
                    String userAnswer = userAns.next().toUpperCase();
                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        score++;
                        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
                    } else {
                        System.out.println("Wrong!");
                        System.out.println("The answer is: " + lineArray[5] + ". " + lineArray[6]);
                        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
                    }
                }
            } else if (option == 3) {
                System.out.println("C++ Basics");
                File csv = new File("Questions/CppMCQ.csv");
                Scanner q2 = new Scanner(csv);

                while (q2.hasNextLine()) {
                    int percent = (100 * score) / totalScore;
                    String line = q2.nextLine();
                    String[] lineArray = line.split(",");
                    System.out.println(lineArray[0]);
                    System.out.println("a. " + lineArray[1]);
                    System.out.println("b. " + lineArray[2]);
                    System.out.println("c. " + lineArray[3]);
                    System.out.println("d. " + lineArray[4]);
                    String correctAnswer = lineArray[5].trim();
                    Scanner userAns = new Scanner(System.in);
                    String userAnswer = userAns.next().toUpperCase();
                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        score++;
                        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
                    } else {
                        System.out.println("Wrong!");
                        System.out.println("The answer is: " + lineArray[5] + ". " + lineArray[6]);
                        System.out.println("Your score is " + score + " out of " + totalScore + "\n");
                    }
                }
            } else {
            }

            int wrongAns = totalScore - score;
            int percent = (100 * score) / totalScore;

            if (percent == 100) {
                System.out.println("Congratulations, " + userName + "! You got a perfect score! " + score + " / " + totalScore);
                System.out.println("Your percentage is: " + percent + "% \n");
            } else if (percent == 60) {
                System.out.println("Not bad, " + userName + "! Your score is " + score + " out of " + totalScore);
                System.out.println("You have " + wrongAns + " mistakes.");
                System.out.println("Your percentage is: " + percent + "% \n");
            } else {
                System.out.println("Better luck next time, " + userName + "! Your score is " + score + " out of " + totalScore);
                System.out.println("You have " + wrongAns + " mistakes.");
                System.out.println("Your percentage is: " + percent + "% \n");
            }

            Scanner options = new Scanner(System.in);
            System.out.println("Wanna try again?");
            System.out.println("Press A to Try Again or Press S to Exit");
            String op = options.next();
            if (op.toUpperCase().equals("A")) {

            } else if (op.toUpperCase().equals("S")) {
                return;
            }


        } catch (Exception e) {
            System.out.println("Please enter a number! \n");
            new mcq();
        }
    }
}
