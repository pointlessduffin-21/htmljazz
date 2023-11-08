public class Human {
    // Encapsulation Example
    private String name;
    private String type;
    private int age;

    public Human(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
        Human h1 = new Human("Allan", "Homo Sapiens", 25);

        System.out.println("Name: " + h1.getName());
        System.out.println("Type of Human: " + h1.getType());
        System.out.println("Age: " + h1.getAge());
    }
}
