package sistema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaFilmesMap implements SistemaFilmes {

    private final Map<String, Filme> filmes;

    public SistemaFilmesMap() {
        this.filmes = new HashMap<String, Filme>();
    }

    @Override
    public void cadastraFilme(Filme f) throws FilmeJaExisteException {
        if (this.filmes.containsKey(f.getCodigo())) {
            throw new FilmeJaExisteException("Já existe filme com este código");
        } else {
            this.filmes.put(f.getCodigo(), f);
        }
    }

    @Override
    public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException {
        return null;
    }

    @Override
    public List<Filme> pesquisaFilmesDaCategoria(CategoriaFilme categoria) {
        return this.filmes.values().stream()
                .filter(filme -> filme.ehDaCategoria(categoria))
                .collect(Collectors.toList());
    }

    @Override
    public int obterQuantidadeFilmesComAtor(String nomeAtor) {
        return 0;
    }

    @Override
    public void incluiAtorEmElencoDeFilme(String codigoFilme, String nomeAtor) throws FilmeNaoExisteException {

    }
}
