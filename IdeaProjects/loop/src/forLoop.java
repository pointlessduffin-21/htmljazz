public class forLoop {
    public static void countUp() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("The current value of i++: " + i);
        }
    }

    public static void countDown() {
        for (int i = 10; i >= 0; i--) {
            System.out.println("The current value of i-- is: " + i);
        }
    }

    public static void main(String[] args) {
        countUp();
        System.out.println("");
        countDown();
    }
}
