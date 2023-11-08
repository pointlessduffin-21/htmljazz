public class TestShape2 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setLength(10f);
        r.setBreadth(20f);
        System.out.println(r.area());

        Cuboid c = new Cuboid();
        c.setLength(10f);
        c.setBreadth(20f);
        c.setHeight(20f);
        System.out.println(c.volume());

    }
}
