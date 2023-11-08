public class MathClass {
    public static void Math() {
        int a = 5;
        int b = 10;

        double aSq = Math.pow(a, 2);
        double bSq = Math.pow(b, 2);
        double c = Math.sqrt(aSq + bSq);
        System.out.println("c = " + c);
    }

    public static void main(String[] args) {
        Math();
    }
}