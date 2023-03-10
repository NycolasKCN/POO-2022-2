package br.com.nycdev.sistemacomercial;

public class ClientPJ extends Client {
    private String CNPJ;

    public ClientPJ(String name, String address, String email, String CNPJ) {
        super(name, address, email);
        this.CNPJ = CNPJ;
    }

    @Override
    public String getId() {
        return this.CNPJ;
    }


}