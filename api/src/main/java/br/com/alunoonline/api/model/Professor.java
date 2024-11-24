package br.com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor // Esses dois são os construtores e são necessarios nessa classe
@AllArgsConstructor
@Data // Vem do lombok e serve para fazer todos os get e sets
@Entity // Assim como em aluno, tem que definir ao spring que professor e uma entidade

public class Professor implements Serializable { // A implementação do serializable e importante pois toda entidade que vai virar uma tabela no banco de dados deve ter

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;

    private String cpf;

    private String email;
}