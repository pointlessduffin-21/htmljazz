import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input a value in Philippine Peso: ");
        double php = input.nextDouble();

        double usd =( 0.018 *(php));
        System.out.println(php + " pesos is equal to " + usd + " USD");
    }
}