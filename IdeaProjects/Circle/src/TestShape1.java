public class TestShape1 {
    public static void main(String[] args) {
        Circle c = new Circle(20.0);
        System.out.println(c.area());
        Cylinder cl = new Cylinder(10, 20);
        System.out.println(cl.volume());
    }
}
