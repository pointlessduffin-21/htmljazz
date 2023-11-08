import java.util.Scanner;

public class division {
    class Person {

    }
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(25);
        change(p);
        System.out.println(p.getAge());
    }
    static void change(Person p) {
        p.setAge(10);
    }
}

