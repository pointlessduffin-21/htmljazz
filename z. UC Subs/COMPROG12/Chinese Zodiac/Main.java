/* 
Chinese Zodiac assignment in COMPROG12 (Java)
by: Francis Roel L. Abarca (BSIT-SE 2)
Chinese Zodiac. User must Input Birthday, birth month, birth date , birth year.

with Error Trappings.

 i.e. Year of the Pig your lucky number is 69420, lucky color is Sky-Black or Black-Pink. You will meet your soulmate etc. 

Hint: Constructors, Inheritance/Interface , Try Catch exceptions 
*/

import java.util.Scanner;

public class Main {
    public static void titleScreen() {
        String title = "Chinese Zodiac";
        String description = "Welcome to the Chinese Zodiac! This program will tell you your Chinese Zodiac sign based on your birth year. It will also tell you your lucky number, lucky color, and your soulmate.";

        System.out.println(title);
        System.out.println(description);
    }

    public static void userInput(String birthDay, String birthMonth, String birthYear) throws Exception {
        Scanner scan = new Scanner(System.in);
        
    }

    public static void main(String[] args) {
        titleScreen();
    }
}
