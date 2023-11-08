public class StringMethods {
    public static void String() {
        String original = "deez";
        for (int i = 0; i < original.length(); i++) {
            System.out.println("The character at index " + i + " is " + original.charAt(i));
        }

        System.out.println("The letter 'd' is at index " + original.indexOf('d'));
        System.out.println("The letter 'e' is at index " + original.indexOf('e'));
        System.out.println("The letter 'A' is at index " + original.indexOf('c')); // Doesn't exist

        original = original.toUpperCase();

        System.out.println(original);
        System.out.println("The letter 'd' is at index " + original.indexOf('d'));

    }

    public static void main(String[] args) {
        String();
    }
}
