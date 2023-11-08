public class Array {
    // Example of an ArrayIndexOutOfBoundsException error kek
    public static void main(String[] args) {
        int[] array = new int[5];
        try {
            System.out.println(array[6]);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println("Reason: " + e.toString());
        }
        finally {
            System.out.println("Mama just killed a man!");
        }
    }
}
