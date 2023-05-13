public class TestConcorrencia {
    public static void main(String[] args) throws InterruptedException {
        Contador cont = new Contador();
        System.out.println("O valor 1 de cont é: " + cont.getValue());

        Thread t1 = new TA(cont);
        Thread t2 = new TB(cont);
        Thread t3 = new TB(cont);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("O valor 2 de cont é: " + cont.getValue());
        t1.join();
        t2.join();
        t3.join();
        System.out.println("O valor final de cont é: " + cont.getValue());
    }
}
