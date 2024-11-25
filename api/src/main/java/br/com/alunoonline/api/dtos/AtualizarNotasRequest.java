package br.com.alunoonline.api.dtos;

import lombok.Data;

//DTO (Data Transfer Object) Serve pra transferir dados de um canto para outro
//No caso daqui ele ta transferindo somente o que interessa, que e a nota 1 e 2
@Data
public class AtualizarNotasRequest {

    private Double nota1;
    private Double nota2;
}
