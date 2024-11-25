package br.com.alunoonline.api.dtos;

import lombok.Data;

@Data
public class HistoricoAlunoResponse {
    private String nomeDisciplina;
    private String nomeProfessor;
    private Double nota1;
    private Double nota2;
    private Double media;
}
