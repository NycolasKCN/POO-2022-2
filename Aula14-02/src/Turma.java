import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Pessoa> alunos;

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    public List<Pessoa> getAlunos() {
        return alunos;
    }

    public void vincularAluno(Pessoa aluno) {
        alunos.add(aluno);
    }

    public void desvincularAluno(Pessoa aluno) {
        alunos.remove(aluno);
    }

    public Pessoa buscarAlunoPorNome(String nome) {
        for (Pessoa aluno : this.alunos) {
            if (aluno.getNome().equals(nome)) return aluno;
        }
        // Esperado uma exceção
        return null;
    }

    public Pessoa buscarAlunoPorCpf(String cpf) {
        for (Pessoa aluno : this.alunos) {
            if (aluno.getCpf().equals(cpf)) return aluno;
        }
        // Esperado uma exceção
        return null;
    }
}
