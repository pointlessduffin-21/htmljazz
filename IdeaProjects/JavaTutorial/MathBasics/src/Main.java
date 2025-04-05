public class Main {
    public static void main(String[] args) {
        double x = 3.14;
        double y = 10;

        double max = Math.max(x, y); //Math.max will find the highest digit on the interpreted variables
        double min = Math.min(x, y); //Math.min will find the lowest digit on the interpreted variables
        double absolute = Math.abs(y); // Absolute
        double sqrt = Math.sqrt(y); // Square Root
        double round = Math.round(x); //Round numbers
        double ceil = Math.ceil(x); //Round numbers up (Keyword is Ceil!)
        double floor = Math.floor(x); //Round numbers down (Keyword is Floor!)

        System.out.println(floor);
    }
}