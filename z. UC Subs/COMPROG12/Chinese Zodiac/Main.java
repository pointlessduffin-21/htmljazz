/* 
Chinese Zodiac assignment in COMPROG12 (Java)
by: Francis Roel L. Abarca (BSIT-SE 2)
Chinese Zodiac. User must Input Birthday, birth month, birth date , birth year with Error Trappings.

 i.e. Year of the Pig your lucky number is 69420, lucky color is Sky-Black or Black-Pink. You will meet your soulmate etc. 

Hint: Constructors, Inheritance/Interface , Try Catch exceptions 
*/

import java.util.Scanner;

public class Main {
    // Zodiac Entity responsible for interpreting user input and zodiac sign calculation
    public static class ZodiacEntity {
        private final String name;
        private final String luckyNumber;
        private final String luckyColor;
        private final String soulmate;

        public ZodiacEntity(String name, String luckyNumber, String luckyColor, String soulmate) {
            this.name = name;
            this.luckyNumber = luckyNumber;
            this.luckyColor = luckyColor;
            this.soulmate = soulmate;
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
                    new ZodiacEntity("Rat", "2, 3", "Blue, Gold, Green", "Dragon, Monkey, Ox"),
                    new ZodiacEntity("Ox", "1, 4", "Red, Blue, Purple", "Rat, Snake, Rooster"),
                    new ZodiacEntity("Tiger", "1, 3, 4", "Green, Orange, White", "Horse, Dog, Pig"),
                    new ZodiacEntity("Rabbit", "3, 4, 6", "Pink, Purple, Blue", "Goat, Dog, Pig"),
                    new ZodiacEntity("Dragon", "1, 6, 7", "Gold, Silver, Gray", "Rat, Monkey, Rooster"),
                    new ZodiacEntity("Snake", "2, 8, 9", "Red, Yellow, Black", "Rooster, Ox, Snake"),
                    new ZodiacEntity("Horse", "2, 7, 9", "Brown, Yellow, Purple", "Tiger, Dog, Goat"),
                    new ZodiacEntity("Goat", "3, 4, 9", "Green, Red, Purple", "Rabbit, Horse, Pig"),
                    new ZodiacEntity("Monkey", "1, 7, 8", "White, Gold, Blue", "Rabbit, Horse, Pig"),
                    new ZodiacEntity("Rooster", "5, 7, 8", "Gold, Brown, Yellow", "Rat, Snake, Rooster"),
                    new ZodiacEntity("Dog", "3, 4, 9", "Green, Red, Purple", "Tiger, Horse, Dog"),
                    new ZodiacEntity("Pig", "2, 5, 8", "Yellow, Gray, Brown", "Rabbit, Goat, Tiger")
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
                description = "Welcome to the Chinese Zodiac Identifier Software! \nThis program will tell you your Chinese Zodiac sign based on your birth year. It will also tell you your lucky number, lucky color, and your soulmate. \n";
                break;
            case "Filipino":
                title = "Chinese Zodiac Identifier ni yeems214";
                description = "Maligayang pagdating sa Chinese Zodiac Identifier Software! \nAng programang ito ay magpapakita sa iyo ng iyong Chinese Zodiac sign batay sa iyong taon ng kapanganakan. Ito rin ay magpapakita sa iyo ng iyong swerteng numero, swerteng kulay, at iyong soulmate. \n";
                break;
            case "Korean":
                title = "중국 동물 띠 식별기 by yeems214";
                description = "중국 동물 띠 식별기 소프트웨어에 오신 것을 환영합니다! \n이 프로그램은 당신의 출생 연도를 기반으로 중국 동물 띠를 알려줍니다. 또한 당신의 행운의 숫자, 행운의 색상, 그리고 당신의 소울메이트를 알려줍니다. \n";
                break;
            case "Spanish":
                title = "Identificador del Zodiaco Chino por yeems214";
                description = "¡Bienvenido al Software Identificador del Zodiaco Chino! \nEste programa te dirá tu signo del zodiaco chino basado en tu año de nacimiento. También te dirá tu número de la suerte, tu color de la suerte, y tu alma gemela. \n";
                break;
            default:
                description = "Language not supported.";
                break;
        }
        System.out.println(title);
        System.out.println(description);
    }

    // Handle user input for birth years
    public static int userInput() {
        Scanner scan = new Scanner(System.in);
        int birthYear = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter your birth year: ");
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
                break;
            case "Filipino":
                System.out.println("\nAng iyong Chinese Zodiac sign ay: " + zodiac.getName());
                System.out.println("Ang iyong swerteng numero ay: " + zodiac.getLuckyNumber());
                System.out.println("Ang iyong swerteng kulay ay: " + zodiac.getLuckyColor());
                System.out.println("Makikilala mo ang iyong soulmate: " + zodiac.getSoulmate());
                break;
            case "Korean":
                System.out.println("\n당신의 중국 동물 띠는: " + zodiac.getName());
                System.out.println("당신의 행운의 숫자는: " + zodiac.getLuckyNumber());
                System.out.println("당신의 행운의 색상은: " + zodiac.getLuckyColor());
                System.out.println("당신은 당신의 소울메이트를 만날 것입니다: " + zodiac.getSoulmate());
                break;
            case "Spanish":
                System.out.println("\nTu signo del zodiaco chino es: " + zodiac.getName());
                System.out.println("Tu número de la suerte es: " + zodiac.getLuckyNumber());
                System.out.println("Tu color de la suerte es: " + zodiac.getLuckyColor());
                System.out.println("Conocerás a tu alma gemela: " + zodiac.getSoulmate());
                break;
        }
    }

    // Main function
    public static void main (String[]args){
        titleScreen("English");
        handleOutput("English");
    }
}
