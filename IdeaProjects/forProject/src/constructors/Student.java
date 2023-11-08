package constructors;

public class Student {
    int studentId;
    String studentName;

    public Student(int studentId, String studentName) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
    }
    public Student(String studentName) {
        super();
        this.studentName = studentName;
    }
    public Student() {
        super();
        System.out.println("Default constructor");
    }
}
