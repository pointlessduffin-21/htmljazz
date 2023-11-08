package constructors;

public class StudentMain {
    public static void main(String[] args) {
        Student student1 = new Student(1, "John");
        Student student2 = new Student("John");
        Student student3 = new Student();

        System.out.println(student1.studentId + " " + student1.studentName);
        System.out.println(student2.studentId + " " + student2.studentName);
        System.out.println(student3.studentId + " " + student3.studentName);
    }
}
