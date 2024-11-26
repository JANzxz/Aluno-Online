package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoResponse {
    private String nomeDisciplina;
    private String nomeProfessor;
    private Double nota1;
    private Double nota2;
    private Double media;

    public void setNomeAluno(String nome) {
    }

    public void setCpfAluno(String cpf) {
    }

    public void setEmailAluno(String email) {
    }

    public void setDisciplinas(List<DisciplinaAlunoResponse> disciplinaList) {
    }
}
