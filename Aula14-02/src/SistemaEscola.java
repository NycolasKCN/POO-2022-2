import java.util.ArrayList;

import exceptions.AlunoJaCadastradoException;
import turma.Turma;
import turma.Aluno;

public class SistemaEscola {
    private ArrayList<Aluno> alunos;
    private ArrayList<Turma> turmas;

    public SistemaEscola() {
        this.alunos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public boolean alunoEstaCadastrado(String cpf) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getCpf().equals(cpf)) return true;
        }
        return false;
    }

    public boolean turmaEstaCadastrada(String disciplina) {
        for (Turma turma : this.turmas) {
            if (turma.getDisciplina().equals(disciplina)) return true;
        }
        return false;
    }

    public void cadastrarAluno(String nome, String cpf, int idade) throws AlunoJaCadastradoException {
        if (alunoEstaCadastrado(cpf)) {
            throw new AlunoJaCadastradoException("Aluno já cadastrado");
        }
        Aluno aluno = new Aluno(nome, cpf, idade);
        this.alunos.add(aluno);
    }

    public void descadastrarAluno(String cpf) {
        Aluno alunoParaDescadastrar = null;
        for (Aluno aluno : this.alunos) {
            if (aluno.getCpf().equals(cpf)) {
                alunoParaDescadastrar = aluno;
                break;
            }
        }
        if (alunoParaDescadastrar == null) {
            System.out.println("Aluno não encontrado");
        } else {
            this.alunos.remove(alunoParaDescadastrar);
        }
    }

    public void cadastrarTurma(String disciplina) {
        Turma turma = new Turma(disciplina);
        this.turmas.add(turma);
    }

    public void descadastrarTurma(String disciplina) {
        Turma turmaParaDescadastrar = null;
        for (Turma turma : this.turmas) {
            if (turma.getDisciplina().equals(disciplina)) {
                turmaParaDescadastrar = turma;
                break;
            }
        }
        if (turmaParaDescadastrar == null) {
            System.out.println("Turma não encontrada");
        } else {
            this.turmas.remove(turmaParaDescadastrar);
        }
    }
}
