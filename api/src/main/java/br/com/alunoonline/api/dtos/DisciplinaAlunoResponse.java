package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.Professor;
import lombok.Data;

import java.util.List;

@Data
public class DisciplinaAlunoResponse {
    private String nomeDisciplina;
    private String emailProfessor;
    private Double nota1;
    private Double nota2;
    private Double media;
    private MatriculaAlunoStatusEnum status;

    public void setNomeDisciplina(String nome) {
    }

    public void setNomeProfessor(Professor professor) {
    }

    public void setNota1(Double nota1) {
    }

    public void setNota2(Double nota2) {
    }

    public void setMedia(Object o) {
    }

    public void setStatus(MatriculaAlunoStatusEnum status) {
    }
}
