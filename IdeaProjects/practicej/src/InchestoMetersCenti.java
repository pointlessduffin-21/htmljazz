import java.util.Scanner;

public class InchestoMetersCenti {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input a value in Inches: ");
        double inch = input.nextDouble();

        double meter =((inch) / 39.37);

        double centi = ((meter) * 100);

        System.out.println(String.format("%.2f", inch) + " inches is " + (String.format("%.2f", meter) + " meters and " + (String.format("%.2f", centi)) + " in centimeters"));
       
    }
}