package polymorphism.overRiding;

public class ShapeDrawer {
    public static class Shape {
        public void draw() {
            System.out.println("Drawing a shape");
        }
    }
    public static class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a circle");
        }
    }
    public static class Rectangle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a rectangle");
        }
    }
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Shape();
        shapes[1] = new Circle();
        shapes[2] = new Rectangle();

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
