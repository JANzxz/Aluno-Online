package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

// E aqui que o aluno vai se matricular

    public void criarMatricula(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

// E aqui que o aluno vai trancar a matricula

    public void trancarMatricula(Long matriculaAlunoId) {
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matrícula de Aluno não encontrada")); // Esse e complicado mas entendi que tudo isso e para caso procure uma matricula que nao existe ai da o erro 404

        if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())) { // Verificar se o status da matrícula é "MATRICULADO"
            // Lançar erro se o status não for "MATRICULADO"
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só é possível trancar uma matrícula com o status MATRICULADO");
        }

        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.TRANCADO); // Aqui estamos setando o status como "TRANCADO"
        matriculaAlunoRepository.save(matriculaAluno); // Aqui salvamos a mudança no banco de dados
    }

    // Aqui e as notas
    public void atualizarNotas(Long matriculaAlunoAtualizarNotasRequest, AtualizarNotasRequest, atualizarNotasRequest){
        AtualizarNotasRequest atualizarNotasRequest =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matrícula de Aluno não encontrada"));

    //Verifica se o front ta mandando a nota 1
    //atualizarNotasRequest.getNota1(): traz a nota que vem do front
    }
}