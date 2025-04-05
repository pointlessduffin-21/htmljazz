public class Main{
    public static void main(String[] args){
        //for loop = executes a block of code at a limited amount of times

        // Count Up
        /*
        for(int i = 0; i<=10; i++) {  // (int i = 0;) declare an index or counter, (i<=10) condition as, (i++) increment the counter i by one
            System.out.println(i);
        }
         */

        // Count down

        /*
        for(int i = 10; i>=0; i--) { //Count down (decremented i--)
            System.out.println(i);
        }
         */

        // Increments/Decrements by multiples (i+=2 or i-=2) = It skips counting by 2
        /*
        for(int i = 10; i>=0; i-=2) {
            System.out.println(i);
        }
         */

        // You can put them at the end of the line
        for(int i = 10; i>=0;) {
            System.out.println(i);
            i-=2;
        }
        System.out.println("Happy New Year!");
    }
}