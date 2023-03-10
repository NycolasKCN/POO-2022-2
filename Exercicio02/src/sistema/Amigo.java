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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Amigo other = (Amigo) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }



}
