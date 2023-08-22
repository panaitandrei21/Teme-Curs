import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataBase {

    private static StudentDataBase instance;

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
        ArrayList<Student> students = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

}
