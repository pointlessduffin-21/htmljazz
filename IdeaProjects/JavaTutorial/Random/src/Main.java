//Random Number Generator for Java
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int x = random.nextInt(6); //Generates a random integer number
        int addOne = random.nextInt(6)+1; //Adding a +1 here would prevent the integer from counting to 0
        double Double = random.nextDouble(); //Generates a random double number
        boolean Boolean = random.nextBoolean(); //Generates a random true or false boolean

        System.out.println(Boolean);

    }
}