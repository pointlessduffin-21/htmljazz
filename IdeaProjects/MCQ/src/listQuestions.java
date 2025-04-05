import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class listQuestions {
    public static String directory = "Questions/"; // Directory where the .csv files are stored

    public static void csv() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your Multiple Choice Question (MCQ) Set: ");
        File dir = new File(listQuestions.directory);  // Grabs all the files inside the directory
        String[] files = dir.list();
        System.out.println("The options include: ");
        try {
            for (String file : files) {
                if (file.endsWith(".csv")) {
                    System.out.println(file.replace(".csv", ""));
                }
            }
            System.out.println("Enter the questionnaire name you want: ");
            String fileName = sc.nextLine();
            File csv = new File(listQuestions.directory + "/" + fileName + ".csv");  // Prints all the files in the directory
            Scanner q1 = new Scanner(csv);
            while (q1.hasNextLine()) {     // While loop for the actual questions
                String line = q1.nextLine();
                String[] lineArray = line.split(",");
                System.out.println(lineArray[0]);
                System.out.println("a. " + lineArray[1]);
                System.out.println("b. " + lineArray[2]);
                System.out.println("c. " + lineArray[3]);
                System.out.println("d. " + lineArray[4]);
                String correctLetter = lineArray[5]; // Reads correct letter from the CSV file
                String correctAnswer = lineArray[6]; // Reads correct answer from the CSV file
                Scanner userAns = new Scanner(System.in);
                String userAnswer = "";
                do {
                    System.out.println("Enter your answer (A, B, C, D): ");
                    userAnswer = userAns.next().toUpperCase();
                    if (userAnswer.equals(correctLetter)) {  // If correct letter
                        answers.correct();
                        break;
                    } else if (userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D")) {  // Else if wrong letter
                        System.out.println("Wrong!");
                        System.out.println("The correct answer is: " + correctLetter + " " + correctAnswer);
                        answers.wrong();
                        break;
                    } else {  // Else wrong character
                        System.out.println("Please enter a valid letter!");
                    }
                } while (true);
            }
        } catch (FileNotFoundException e) {  // Catches when file entered isnt available
            System.out.println("The exam you are trying to look for is not available.");
            csv();
        }
    }
}

