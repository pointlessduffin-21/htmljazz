import java.util.Scanner;
import java.util.Random;
public class HyperSleep {
    static String[] phrases = {"Sleep or no bitches for you %s", "Go to sleep %s", "You really should sleep %s", "You should sleep %s, so you can dream of E-Girls "};
    public static void main(String[] args){
        Scanner name = new Scanner(System.in);
        System.out.println("Enter name");
        String usersName = name.nextLine();
        Random rand = new Random();
        int m = rand.nextInt(4);
        System.out.println(String.format(phrases[m], usersName));
    }
}