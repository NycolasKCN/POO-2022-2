package sistema;

public class FilmeNaoExisteException extends Exception {
    public FilmeNaoExisteException(String message) {
        super(message);
    }
}
