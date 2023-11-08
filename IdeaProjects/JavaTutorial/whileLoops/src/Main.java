import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        // while loop = executes a block of code as long as its condition remains true

        Scanner scanner = new Scanner(System.in);
        String name = "";

        do{ //Do loop
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }while(name.isBlank()); //This runs a loop to check if the name is blank or not

            System.out.println("Hello "+name);

    }
}