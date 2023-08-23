package task2;

public class Document {
    private static int idCounter = 0;
    private int id;
    private String producerName;

    public String getProducerName() {
        return producerName;
    }

    public Document(String producerName) {
        this.id = ++idCounter;
        this.producerName = producerName;
    }

    public int getId() {
        return id;
    }
}
