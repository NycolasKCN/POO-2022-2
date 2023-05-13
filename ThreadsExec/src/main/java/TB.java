
public class TB extends Thread{
    private Contador cont;

    public TB(Contador cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
        System.out.println("TB: Vou decrementar contador...");
        cont.decrement();
        System.out.println("TB: Valor do contador: " + cont.getValue());
    }
}