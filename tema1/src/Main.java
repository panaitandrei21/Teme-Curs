import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 90);
        Student s2 = new Student("Bob", 85);
        Student s3 = new Student("Charlie", 92);
        StudentDataBase dataBase = StudentDataBase.getDataBase();
        // Save them to a binary file
        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(s1, s2, s3));
        dataBase.saveToBinaryFile(studentList, "students.dat");

        // Load them from the binary file
        ArrayList<Student> loadedStudents = dataBase.loadFromBinaryFile("students.dat");
        for (Student student : loadedStudents) {
            System.out.println(student);
        }
    }
}