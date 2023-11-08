public class Main {
    public static void main(String[] args) {
        // Switch = statement that allows a variable to be tested for equality against a list of variables

        String day = "Pizza";

        switch(day) {  //We are going to compare the day String against each cases inside this switch
            case "Sunday": System.out.println("It is Sunday!");
            break;
            case "Monday": System.out.println("It is Monday!");
            break;
            case "Tuesday": System.out.println("It is Tuesday!");
            break;
            case "Wednesday": System.out.println("It is Wednesday my dudes!");
            break;
            case "Thursday": System.out.println("It is Thursday");
            break;
            case "Friday": System.out.println("It is Friday");
            break;
            case "Saturday": System.out.println("It is Saturday");
            break;
            default: System.out.println("That is not a day!"); //This is what executes when its on by default!
        }

    }
}