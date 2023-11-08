public class Main {
    public static void main(String[] args) {
        // Constructor = special method that is called when an object is instantiated (created)

        Human human1 = new Human("Bob", 65, 70);
        Human human2 = new Human("Ana", 18, 62);



        System.out.println(human1.name + " " +  human1.age + " " + human1.weight);
        System.out.println(human2.name);

        human2.eat();
        human1.drink();

    }
}