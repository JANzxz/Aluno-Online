package br.com.alunoonline.api.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //A anotação data faz todos os get sets sozinha


@Entity //Essa anotação serve para dizer para o spring que a classe aluno e uma entidade
public class Aluno implements Serializable {

    @Id //Essa anotação serve para que o spring identifique que aqui e um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Essa anotação faz uma geração de valores do tipo identidade

    private long id; //O long serve pra dizer que o id pode ser grande

    private String nome;

    private String email;

    private String cpf;

}