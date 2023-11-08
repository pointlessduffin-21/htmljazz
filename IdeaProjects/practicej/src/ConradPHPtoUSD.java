import java.util.Scanner;
public class PHPtoUSD {

    public static void main(String[] Strings) {

        double dollar = 57.0;

        Scanner input = new Scanner(System.in);

        System.out.print("Input a value in Philippine Peso: ");

        double php = input.nextDouble();

        double dollars = php / dollar;
        System.out.println(php + " PHP is " + dollars + " USD");
    }
}