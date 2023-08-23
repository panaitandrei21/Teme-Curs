package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataBase {
    //retine instanta
    private static StudentDataBase instance;

    //fac constructorul privat pentru a nu putea fii accesat (singleton)
    private StudentDataBase() { }

    public static StudentDataBase getDataBase() {
        if(instance == null) {
            instance = new StudentDataBase();
        }
        return instance;
    }

    public static void saveToBinaryFile(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> loadFromBinaryFile(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

}
