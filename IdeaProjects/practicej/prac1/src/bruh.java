import java.util.Scanner;
import java.util.Random;
public class bruh {
    static void Rand1() {
        String words1;{"Guess", "Theory", "Hypothesis", "Surmise";};
        Scanner name = new Scanner(System.in);
        Random rand = new Random();
        int m = rand.nextInt(4);
        System.out.println(String.format(words1[m]));
    }
    public static void main(String[] args) {
        Rand1();
    }
}