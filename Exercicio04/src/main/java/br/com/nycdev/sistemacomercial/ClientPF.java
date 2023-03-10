package br.com.nycdev.sistemacomercial;

public class ClientPF extends Client {
    private String CPF;

    public ClientPF(String name, String address, String email, String CPF) {
        super(name, address, email);
        this.CPF = CPF;
    }

    @Override
    public String getId() {
        return this.CPF;
    }


}
