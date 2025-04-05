// How to swap outputs in Java

public class Main {
    public static void main(String[] args) {
        String x = "water";
        String y = "Kool-Aid";
        String temp;  //temporary store a blank value

        temp = x; //Swap
        x = y;
        y = temp;

        System.out.println("x: "+x);
        System.out.println("y: "+y);
    }
}