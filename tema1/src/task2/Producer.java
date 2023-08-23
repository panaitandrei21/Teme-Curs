package task2;

import java.util.Random;

public class Producer implements Runnable{
    private Buffer buffer;
    private int documentCount;
    private Random random = new Random();

    public Producer(Buffer buffer, int documentCount) {
        this.buffer = buffer;
        this.documentCount = documentCount;
    }
    //fiecare producer face documentCount documente
    @Override
    public void run() {
        for (int i = 0; i < documentCount; i++) {
            try {
                //adaug fisierul in buffer si il generez pasand numele threadului.
                buffer.produce(new Document(Thread.currentThread().getName()));
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
