package task2;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public static void main(String[] args) {
        //setez capacitatea bufferului cu 5 elemente
        Buffer buffer = new Buffer(5);
        //lista de produceri
        List<Thread> producers = new ArrayList<>();

        Thread consumer = new Thread(new Consumer(buffer), "Consumer");
        //setez numele producerilor si ii initializez
        for (int i = 0; i < 3; i++) {
            producers.add(new Thread(new Producer(buffer, 30), "Producer-" + i));
        }
        //start
        for(Thread prod : producers) {
            prod.start();
        }
        consumer.start();

    }
}
