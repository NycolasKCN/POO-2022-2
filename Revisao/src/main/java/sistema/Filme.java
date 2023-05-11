package sistema;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private final String codigo;
    private final String nome;
    private final List<CategoriaFilme> categorias;
    private final List<String> nomesAtores;

    public Filme(String codigo) {
        this(codigo, "", new ArrayList<>(), new ArrayList<>());
    }

    public Filme(String codigo, String nome, List<CategoriaFilme> categorias,
                 List<String> nomesAtores) {
        this.codigo = codigo;
        this.nome = nome;
        this.categorias = categorias;
        this.nomesAtores = nomesAtores;
    }

    public boolean ehDaCategoria(CategoriaFilme categoria) {
        for (CategoriaFilme cat : this.categorias) {
            if (cat == categoria) {
                return true;
            }
        }
        return false;
    }


}
