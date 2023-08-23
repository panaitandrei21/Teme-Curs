package task2;

import java.util.LinkedList;

public class Buffer {
    private LinkedList<Document> queue;
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    //Pentru produce folosesc syncrronized pentru a ma asigura ca doar un thread baga documente in lista la un moment de timp
    //daca capacitatea este maxima atunci dam wait pentru a lasa consumatorii sa consume din produse (pentru a lasa sa printam)
    public synchronized void produce(Document doc) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(doc);
        System.out.println("Producer "+ doc.getProducerName() +" produced document " + doc.getId());
        notifyAll();
    }
    //la fel metoda este syncronized pentru a nu lasa mai multi consumatori daca este cazul sa consume in acelasi timp din buffer
    //daca coada este goala inseamna ca trb sa dam semnal catre produceri sa produca
    public synchronized Document consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        Document doc = queue.removeFirst();
        System.out.println("Consumed document " + doc.getId());
        notifyAll();
        return doc;
    }
}
