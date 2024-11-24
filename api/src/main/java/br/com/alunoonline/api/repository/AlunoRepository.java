//Essa classe e uma interface para poder implementar os contratos
package br.com.alunoonline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.alunoonline.api.model.Aluno;

@Repository //Indica que aqui e o repositorio
public interface AlunoRepository extends JpaRepository<Aluno,Long>{ //herdando o spring data porque tanto o spring data quanto o repository fazem a ponte entre o aluno java e o aluno banco de dados

}