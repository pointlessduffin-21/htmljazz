import java.util.Scanner;

public class welcome {
    public static String userName;

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String toString() {

        return "Author[name=" + userName + "]";

    }

    public static String questionnaire() {
        String userName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the MCQ Test System!");
        System.out.println("Please enter your name!");
        userName = scanner.nextLine();
        System.out.println("Welcome " + userName + "! \n");
        return userName;
    }
}
