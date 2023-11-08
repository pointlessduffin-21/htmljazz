package destructor;

public class Student {
    String studentName;

    public static void main(String[] args) {
        Student student = new Student();
        student.studentName = "John";
        System.out.println(student.studentName);

        student = null;
        System.gc();
    }
}
