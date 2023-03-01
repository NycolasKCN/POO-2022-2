package turma;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private String disciplina;

    public Turma(String disciplina) {
        this.alunos = new ArrayList<>();
        this.disciplina = disciplina;
    }

    public void vincularAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void desvincularAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public Pessoa buscarAlunoPorNome(String nome) {
        for (Pessoa aluno : this.alunos) {
            if (aluno.getNome().equals(nome))
                return aluno;
        }
        // Esperado uma exceção
        return null;
    }

    public Pessoa buscarAlunoPorCpf(String cpf) {
        for (Pessoa aluno : this.alunos) {
            if (aluno.getCpf().equals(cpf))
                return aluno;
        }
        // Esperado uma exceção
        return null;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
