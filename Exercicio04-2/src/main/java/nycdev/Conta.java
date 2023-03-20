package nycdev;

public class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public boolean debitar(double valor) {
        if (valor > saldo || valor < 0) return false;
        this.saldo -= valor;
        return true;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
