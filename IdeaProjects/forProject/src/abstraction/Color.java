package abstraction;

public abstract class Color {
    public abstract void fill(); // Abstract Method

    public void brush() {   // Concrete Method
        System.out.println("Brushing the color");
    }
}
