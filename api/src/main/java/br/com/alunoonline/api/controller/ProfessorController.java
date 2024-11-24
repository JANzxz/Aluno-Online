package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // Para a conexão com o front
@RequestMapping ("/professores") // Para mapear as requisições
public class ProfessorController {

    @Autowired // Injetando Service
    ProfessorService ProfessorService;
    @ResponseStatus(HttpStatus.CREATED) // Response status servem pra mostrar aqueles numeros tipo o erro 404, mas nesse caso se der tudo certo ele vai retornar o 201
    @PostMapping // Pra dizer que aqui e um post para criar professor
    public void criarProfessor(@RequestBody Professor professor) { // O REquestBody tá transformando professor de Jason em Java
        ProfessorService.CriarProfessor(professor);
    }
}

