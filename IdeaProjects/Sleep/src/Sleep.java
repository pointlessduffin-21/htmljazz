import java.util.Scanner; //Preloading the Java Scanner Extension
class yeems214Sleep {

    public static void main(String[] args) {
        Scanner scanning = new Scanner(System.in); //Scanner Initialization

        System.out.println("Welcome to the Sleeping Program!"); //Welcome Message 1
        System.out.println("Hope you will enjoy your sleeping experience!"); //Welcome Message 2

        System.out.println();
        System.out.println("Input your name"); //Log-in 1
        String user = scanning.nextLine(); //Scanner reading the input from Log-in 1

        System.out.println();
        System.out.println("Input your partner's name"); //Log-in 2
        String egirl = scanning.nextLine(); //Scanner reading the input from Log-in 2

        System.out.println();
        System.out.println("Go to sleep " + user + "!"); //Message 1
        System.out.println("or else, you will date " + egirl + " for the rest of your life."); //Message 2
    }
}
