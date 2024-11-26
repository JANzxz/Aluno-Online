package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoResponse {
    private String nomeAluno;
    private String emailAluno;
    private String cpfAluno;
    private List<DisciplinaAlunoResponse> disciplinasAlunoResponses; // Com isso aqui modelado, não preciso ta chamando as outras classes direto

    public void setNomeAluno(String nome) {
    }

    public void setCpfAluno(String cpf) {
    }

    public void setEmailAluno(String email) {
    }

    public void setDisciplinas(List<DisciplinaAlunoResponse> disciplinaList) {
    }
}
