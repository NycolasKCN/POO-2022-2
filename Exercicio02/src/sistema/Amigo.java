package sistema;
public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSecreto;

    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.emailAmigoSecreto = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSecreto() {
        return emailAmigoSecreto;
    }

    public void setAmigoSecreto(String emailAmigoSecreto) {
        this.emailAmigoSecreto = emailAmigoSecreto;
    }

}
