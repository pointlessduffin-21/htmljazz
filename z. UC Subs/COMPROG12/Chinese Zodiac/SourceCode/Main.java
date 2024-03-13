/* 
Chinese Zodiac assignment in COMPROG12 (Java)
by: Francis Roel L. Abarca (BSIT-SE 2)
Chinese Zodiac. User must Input Birthday, birth month, birth date , birth year with Error Trappings.

 i.e. Year of the Pig your lucky number is 69420, lucky color is Sky-Black or Black-Pink. You will meet your soulmate etc. 

Hint: Constructors, Inheritance/Interface , Try Catch exceptions

Added a bonus feature:
- Multi-Lingual support and easy* language switching and translation
- Menu for restarting the action or exiting the program
*/
package SourceCode;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    // Zodiac Entity responsible for interpreting user input and zodiac sign calculation
    public static class ZodiacEntity {
        private final String name;
        private final String luckyNumber;
        private final String luckyColor;
        private final String soulmate;
        private final String someQuote;

        public ZodiacEntity(String name, String luckyNumber, String luckyColor, String soulmate, String someQuote) {
            this.name = name;
            this.luckyNumber = luckyNumber;
            this.luckyColor = luckyColor;
            this.soulmate = soulmate;
            this.someQuote = someQuote;
        }

        public String getName() {
            return name;
        }

        public String getLuckyNumber() {
            return luckyNumber;
        }

        public String getLuckyColor() {
            return luckyColor;
        }

        public String getSoulmate() {
            return soulmate;
        }
        public String getSomeQuote() {
            return someQuote;
        }
    }

    // Zodiac Calculator responsible for calculating the zodiac sign based on the birth year
    public interface ZodiacCalculator {
        ZodiacEntity calculate(int birthYear);
    }

    // Logic for ZodiacCalc which implements ZodiacCalculator
    public static class ZodiacCalc implements ZodiacCalculator {
        private final ZodiacEntity[] zodiacEntity;

        public ZodiacCalc() {
            zodiacEntity = new ZodiacEntity[]{
                    new ZodiacEntity("Rat", "2", "Sky-Blue", "Dragon", "Rats are quick-witted, resourceful, and versatile. They're like the 'This is fine' meme, always adapting to chaos."),
                    new ZodiacEntity("Ox", "1", "Red-Pink", "Rat", "Oxen are known for diligence, dependability, strength, and determination. They're like the 'Doge' meme, always reliable."),
                    new ZodiacEntity("Tiger", "1", "Green-Maroon", "Horse", "Tigers are brave, competitive, unpredictable, and confident. They're like the 'Distracted Boyfriend' meme, always looking for the next challenge."),
                    new ZodiacEntity("Rabbit", "3", "Pink-Blue", "Goat", "Rabbits are gentle, quiet, elegant, and alert. They're like the 'Mocking SpongeBob' meme, always aware of their surroundings."),
                    new ZodiacEntity("Dragon", "1", "Gold-Yellow", "Rat", "Dragons are confident, intelligent, and enthusiastic. They're like the 'Expanding Brain' meme, always evolving and growing."),
                    new ZodiacEntity("Snake", "2", "Red-Orange", "Rooster", "Snakes are enigmatic, intelligent, and wise. They're like the 'Two Buttons' meme, always making calculated decisions."),
                    new ZodiacEntity("Horse", "2", "Brown-Red", "Tiger", "Horses are hardworking, intelligent, and friendly. They're like the 'Wholesome' meme, always spreading positivity."),
                    new ZodiacEntity("Goat", "3", "Green-Violet", "Rabbit", "Goats are calm, gentle, and sympathetic. They're like the 'Arthur Fist' meme, always keeping their cool."),
                    new ZodiacEntity("Monkey", "1", "White-Amber", "Rabbit", "Monkeys are sharp, smart, but naughty. They're like the 'Pepe the Frog' meme, always up to mischief."),
                    new ZodiacEntity("Rooster", "5", "Gold-Pink", "Rat", "Roosters are observant, hardworking, resourceful, courageous. They're like the 'Change My Mind' meme, always standing their ground."),
                    new ZodiacEntity("Dog", "3", "Green-Black", "Tiger", "Dogs are loyal, honest, but not good at communication. They're like the 'Doge' meme, always loyal but sometimes misunderstood."),
                    new ZodiacEntity("Pig", "2", "Yellow-White", "Rabbit", "Pigs are diligent, compassionate, and generous. They're like the 'Kermit Sipping Tea' meme, always minding their own business but still caring for others.")
            };
        }

        // Handle calculation of the zodiac sign based on the birth year
        @Override
        public ZodiacEntity calculate(int birthYear) {
            return zodiacEntity[(birthYear - 1900) % 12];
        }
    }

    // Title screen for the program
    public static void titleScreen(String language) {
        String title = "";
        String description = "";

        switch (language) {
            case "English":
                title = "Chinese Zodiac Identifier by yeems214";
                description = "Welcome to the Chinese Zodiac Identifier Software! \nThis program will tell you your Chinese Zodiac sign based on your birth year. It will also tell you your lucky number, lucky color, and your soulmate.";
                break;
            case "Filipino":
                title = "Chinese Zodiac Identifier ni yeems214";
                description = "Maligayang pagdating sa Chinese Zodiac Identifier Software! \nAng programang ito ay magpapakita sa iyo ng iyong Chinese Zodiac sign batay sa iyong taon ng kapanganakan. Ito rin ay magpapakita sa iyo ng iyong swerteng numero, swerteng kulay, at iyong soulmate.";
                break;
            case "Korean":
                title = "중국 동물 띠 식별기 by yeems214";
                description = "중국 동물 띠 식별기 소프트웨어에 오신 것을 환영합니다! \n이 프로그램은 당신의 출생 연도를 기반으로 중국 동물 띠를 알려줍니다. 또한 당신의 행운의 숫자, 행운의 색상, 그리고 당신의 소울메이트를 알려줍니다.";
                break;
            case "Spanish":
                title = "Identificador del Zodiaco Chino por yeems214";
                description = "¡Bienvenido al Software Identificador del Zodiaco Chino! \nEste programa te dirá tu signo del zodiaco chino basado en tu año de nacimiento. También te dirá tu número de la suerte, tu color de la suerte, y tu alma gemela.";
                break;
            default:
                description = "Language not supported.";
                break;
        }
        System.out.println(title);
        System.out.println(description);
    }

    // Handle user input for birth month and birth date
    public static void specificDate() {
        Scanner scan = new Scanner(System.in);
        int birthMonth;
        int birthDate;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("\nEnter your birth month (MM): ");
                birthMonth = scan.nextInt();
                if (birthMonth > 12 || birthMonth < 1) {
                    throw new IllegalArgumentException("Invalid month. Please enter a value between 1 and 12.");
                }

                System.out.println("\nEnter your birth date (DD): ");
                birthDate = scan.nextInt();
                if (birthMonth == 2 && birthDate > 29) {
                    throw new IllegalArgumentException("Invalid date. February only has 28 or 29 days.");
                } else if ((birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) && birthDate > 30) {
                    throw new IllegalArgumentException("Invalid date. April, June, September, and November only have 30 days.");
                } else if (birthDate > 31 || birthDate < 1) {
                    throw new IllegalArgumentException("Invalid date. Please enter a value between 1 and 31.");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter the appropriate input (MM/DD).");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Handle user input for birth years
    public static int userInput() {
        Scanner scan = new Scanner(System.in);
        int birthYear = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                specificDate();
                System.out.println("\nEnter your birth year (YYYY): ");
                birthYear = Integer.parseInt(scan.nextLine());
                if (birthYear < 1900 || birthYear > 9999) {
                    throw new IllegalArgumentException("You're too old! Enter a valid birth year (YYYY).");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Whoops! Please enter a valid year (YYYY).");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return birthYear;
    }

    public static void handleOutput(String language) {
        int birthYear = userInput();
        ZodiacCalculator zodiacCalc = new ZodiacCalc();
        ZodiacEntity zodiac = zodiacCalc.calculate(birthYear);
        switch (language) {
            case "English":
                System.out.println("\nYour Chinese Zodiac sign is: " + zodiac.getName());
                System.out.println("Your lucky number is: " + zodiac.getLuckyNumber());
                System.out.println("Your lucky color is: " + zodiac.getLuckyColor());
                System.out.println("You will meet your soulmate: " + zodiac.getSoulmate());
                System.out.println("Your Quote is: " + zodiac.getSomeQuote());
                break;
            case "Filipino":
                System.out.println("\nAng iyong Chinese Zodiac sign ay: " + zodiac.getName());
                System.out.println("Ang iyong swerteng numero ay: " + zodiac.getLuckyNumber());
                System.out.println("Ang iyong swerteng kulay ay: " + zodiac.getLuckyColor());
                System.out.println("Makikilala mo ang iyong soulmate: " + zodiac.getSoulmate());
                System.out.println("Ang iyong Quote ay: " + zodiac.getSomeQuote());
                break;
            case "Korean":
                System.out.println("\n당신의 중국 동물 띠는: " + zodiac.getName());
                System.out.println("당신의 행운의 숫자는: " + zodiac.getLuckyNumber());
                System.out.println("당신의 행운의 색상은: " + zodiac.getLuckyColor());
                System.out.println("당신은 당신의 소울메이트를 만날 것입니다: " + zodiac.getSoulmate());
                System.out.println("당신의 명언은: " + zodiac.getSomeQuote());
                break;
            case "Spanish":
                System.out.println("\nTu signo del zodiaco chino es: " + zodiac.getName());
                System.out.println("Tu número de la suerte es: " + zodiac.getLuckyNumber());
                System.out.println("Tu color de la suerte es: " + zodiac.getLuckyColor());
                System.out.println("Conocerás a tu alma gemela: " + zodiac.getSoulmate());
                System.out.println("Tu frase es: " + zodiac.getSomeQuote());
                break;
        }
    }

    public static void mainMenu() {
        int choice;
        handleOutput("English");
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nWhat do you want to do now? \n1. Run again \n2. Exit");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        mainMenu();
                        break;
                    case 2:
                        System.out.println("\nGoodbye!");
                        exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please try again.");
                scan.nextLine();
            }
        }
    }

    // Main function
    public static void main (String[]args){
        titleScreen("English");
        mainMenu();
    }
}
