public class MinhaThread extends Thread {
    private String nome;

    public MinhaThread(String nome) {
        this.nome = nome;
    }

    public void run() {
        dizOiAoInfinit();
    }

    public void dizOiAoInfinit() {
        try {
            for(int i = 0; i < 10000; i++) {
                System.out.println(dizOiThread());
                sleep(1);
            }
        } catch (InterruptedException e) {
            throw  new RuntimeException("Bugou");
        }
    }

    public String dizOiThread() {
        return "Oi, sou a thread " + nome + "!";
    }
}
