public class Main {
    public static void main(String[] args) {
        Thread th1 = new MinhaThread("joãozinho");
        Thread th2 = new MinhaThread("mariazinha");
        Thread th3 = new MinhaThread("ricardão");

        th1.start();
        th2.start();
        th3.start();
    }
}