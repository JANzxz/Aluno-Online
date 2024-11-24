package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //tem que informar pra o spring q aqui e uma repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
