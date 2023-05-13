public class TA extends Thread{
    private Contador cont;

    public TA(Contador cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
        System.out.println("TA: Vou incrementar contador...");
        cont.increment();
        System.out.println("TA: Valor do contador: " + cont.getValue());
    }
}
