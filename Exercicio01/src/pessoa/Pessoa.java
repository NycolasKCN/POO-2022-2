package pessoa;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa() {
        this("", "", 0);
    }

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String seApresente() {
        return "Oi eu sou o " + this.nome;
    }

    public String digaSuaIdade() {
        return "Eu tenho " + this.idade + "anos";
    }
}