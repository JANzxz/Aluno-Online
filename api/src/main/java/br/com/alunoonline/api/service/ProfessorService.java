package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Tambem tenho que dizer que aqui e um service
public class ProfessorService {

    @Autowired // Injetando o repository pra ter acesso a o Banco de dados
    ProfessorRepository ProfessorRepository;

    public void CriarProfessor (Professor professor){
        ProfessorRepository.save(professor); // O .save serve pra salvar a entidade professor

    }
}