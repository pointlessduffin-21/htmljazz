import javax.swing.JOptionPane; //Simple Graphical User Interface

public class Main {
    public static void main(String[] args) {

        String name = JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null, "Hello "+name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); //Integer.parseInt will convert the integer to a string
        JOptionPane.showMessageDialog(null, "You are "+age+" years old");

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your Height")); //Double.parseDouble will convert the double to a string
        JOptionPane.showMessageDialog(null, "You are "+height+" cm tall");
    }
}