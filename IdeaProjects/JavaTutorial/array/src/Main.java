public class Main {
    public static void main(String[] args) {
        // array = used to store multiple values in a single variable
        array1();
        array2();
        array3();
    }

    public static void array1() {
        String[] cars = {"Camaro","Tesla","Corvette","BMW"};

        cars[0] = "Mustang";

        System.out.println(cars[3]);
    }

    public static void array2() {
        String[] cars = new String[4];

        cars[0] = "Camaro";
        cars[1] = "Corvette";
        cars[2] = "Tesla";
        cars[3] = "BMW";

        System.out.println(cars[1]);
    }

    public static void array3() {
        String[] cars = new String[4];

        cars[0] = "Camaro";
        cars[1] = "Corvette";
        cars[2] = "Tesla";
        cars[3] = "BMW";

        for(int i=0; i<cars.length; i++) {
            System.out.println(cars[i]);
        }
    }
}