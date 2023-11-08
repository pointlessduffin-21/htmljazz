public class Main {
    public static void main(String[] args){

        //If statement = performs a block of code if its condition evaluates to be true

        int age = 13;

        if(age>=75) { //>= are comparison operators (using the = is an assignment operator so adding another equal will make it a comparison operator)
            System.out.println("Ok Boomer!");
        }
        else if(age>=18) {
            System.out.println("You are an adult");
        }
        else if(age>=13) {
            System.out.println("You are a teenager!");
        }
        else {
            System.out.println("You are not an adult");
        }
    }
}