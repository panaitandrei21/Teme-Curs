package task1;

import task1.Student;
import task1.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //initializez studentii
        Student s1 = new Student("Andrei", 90);
        Student s2 = new Student("Vasile", 85);
        Student s3 = new Student("Gheorghe", 92);
        //initializez baza de date
        StudentDataBase dataBase = StudentDataBase.getDataBase();
        //creez lista de studenti
        List<Student> studentList = new ArrayList<>(Arrays.asList(s1, s2, s3));

        //salvez in fisier prin intermediul bazei de date
        dataBase.saveToBinaryFile(studentList, "students.txt");

        //citesc din fisier si printez
        ArrayList<Student> loadedStudents = dataBase.loadFromBinaryFile("students.txt");
        for (Student student : loadedStudents) {
            System.out.println(student);
        }




    }
}