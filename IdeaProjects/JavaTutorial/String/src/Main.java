import java.util.*;

public class Main {
    public static void main(String[] args) {
        // String = a reference data type that can store one or more characters
        //          refernce data types have access to useful methods
        string1();
        stringtoUpperCase();
        stringLength();
        charAt();
        indexOf();
        stringEmptyBoolean();
        toUpperCase();
        toLowerCase();
        trim();
        replace();
    }

    public static void string1() {
        String name = "Deez";

        boolean result = name.equals("Deez"); //equals = Compare 2 strings then turns it into a boolean value
        boolean ignore = name.equalsIgnoreCase("deez"); //equalsIgnoreCase

        System.out.println("Comparing 2 strings then turns it into a boolean value: " + name);
        System.out.println(result);
        System.out.println();
    }

    public static void stringtoUpperCase() {
        String name = "Deez".toUpperCase(); //toUpperCase makes the string name to have an uppercase letter for easy comparison and verification of any kinds of texts

        boolean result = name.equals("DEEZ"); //equals = Compare 2 strings then turns it into a boolean value
        boolean ignore = name.equalsIgnoreCase("deez"); //equalsIgnoreCase

        System.out.println("Uppercase String of: " + name);
        System.out.println(result);
        System.out.println();
    }

    public static void stringLength() {
        String name = "Deez";
        int result = name.length();

        System.out.println("String Length of: " + name);
        System.out.println(result);
        System.out.println();
    }

    public static void charAt() {
        String name = "Deez";

        char result = name.charAt(0);
        System.out.println("First letter of the name " + name + " is: " + result);
        System.out.println();
    }

    public static void indexOf() {
        String name = "Deez";

        int result = name.indexOf("D");

        System.out.println("indexOf returns the position of the letter in the String");
        System.out.println("Like for " + name + ". It's at position " + result + ".");
        System.out.println();
    }

    public static void stringEmptyBoolean() {
        String name = "Deez";

        boolean result = name.isEmpty();
        if (result == false) {
            System.out.println("The string is not empty.");
            System.out.println("The text inside the string is: " + name);
            System.out.println();
        } else {
            System.out.println("The string is empty");
            System.out.println();
        }
    }

    public static void toUpperCase() {
        String name = "Deez";
        String result = name.toUpperCase();

        System.out.println("The name " + name + " in Uppercase form is: " + result);
    }

    public static void toLowerCase() {
        String name = "Deez";
        String result = name.toLowerCase();

        System.out.println("The name " + name + " in Lowercase form is: " + result);
        System.out.println();
    }

    public static void trim() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";

        String name = "     Deez      ";
        String result = name.trim();

        System.out.println("Java Trim");
        System.out.println(ANSI_RED_BACKGROUND + name + ANSI_RESET);
        System.out.println("to");
        System.out.println(ANSI_RED_BACKGROUND + result + ANSI_RESET);
        System.out.println();
    }

    public static void replace() {
        String name = "Deez";

        String result = name.replace('e', 'a');

        System.out.println(".Replace changes the letters of a particular string with a different one");
        System.out.println("Like: " + name + " turns to "+ result);
    }
}