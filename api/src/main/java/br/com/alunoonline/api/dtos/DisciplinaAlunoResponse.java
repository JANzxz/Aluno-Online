package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.model.Professor;
import lombok.Data;

import java.util.List;

@Data
public class DisciplinaAlunoResponse {
    private String nomeAluno;
    private String emailAluno;
    private String cpfAluno;
    private List<DisciplinaAlunoResponse> disciplinaAlunoResponse;// Com isso aqui modelado, não preciso ta chamando as outras classes direto

    public void setNomeDisciplina(String nome) {
    }

    public void setNomeProfessor(Professor professor) {
    }

    public void setNota1(Double nota1) {
    }

    public void setNota2(Double nota2) {
    }
}
