package interface1;

public class Rectangle implements Shape, Color {
    @Override
    public void shape() {
        System.out.println("Rectangle is a shape");
    }

    @Override
    public void color() {
        System.out.println("Red is it's color");
    }
}

