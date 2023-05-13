public class Contador {
    private int c;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
         c--;
    }

    public synchronized int getValue() {
        return c;
    }
}
