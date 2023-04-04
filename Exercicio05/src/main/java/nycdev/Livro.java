package nycdev;

import java.io.Serializable;

public class Livro implements Serializable {
    private String titulo;
    private String autor;
    private int numPag;

    public Livro(String titulo, String autor, int numPag) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Livro(String titulo) {
        this.titulo = titulo;
    }

    protected Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numPag=" + numPag +
                '}';
    }
}
