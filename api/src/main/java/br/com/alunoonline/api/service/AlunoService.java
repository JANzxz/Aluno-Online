package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {  //Como aluno e uma entidade ele ta vindo do model

        alunoRepository.save(aluno);

    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }
    public Optional<Aluno> buscarAlunoPorId(Long id){ //O optional e pq o aluno pode existir ou não no banco
        return alunoRepository.findById(id); //Como ja injetei o repository aqui no service e preciso agora de acesso ao BD vou usar um return
    }

    public void deleteAlunoPorId(long id) { // O void torna essa variavel vazia, logo ela nn precisa de return, até pq não tem pra que retornar algo deletado X_X
        alunoRepository.deleteById(id); //Tou chamando o repository aqui pois e ele q pode deletar os alunos, porconta do BD
    }

    public void atualizarAlunoPorId(long id, Aluno aluno) {
        alunoRepository.findById(id);
    }
}