package br.com.alunoonline.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DisciplinaAlunoResponse {
    private String nomeAluno;
    private String emailAluno;
    private String cpfAluno;
    private List<DisciplinaAlunoResponse> disciplinaAlunoResponse;// Com isso aqui modelado, não preciso ta chamando as outras classes direto
}
