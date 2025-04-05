package polymorphism.overLoad;

public class PolyCalc {
        public static void main(String[] args) {
            PolyCalc calc = new PolyCalc();
            System.out.println("Add 2 Integers = " + calc.add(1, 2));
            System.out.println("Add 3 Integers = " + calc.add(1, 2, 3));
            System.out.println("Add 2 doubles = " + calc.add(1.0, 2.0));
            System.out.println("Add 3 doubles = " + calc.add(1.0, 2.0, 3.0));
        }

        public int add(int a, int b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b + c;
        }

        public double add(double a, double b) {
            return a + b;
        }

        public double add(double a, double b, double c) {
            return a + b + c;
        }
}
