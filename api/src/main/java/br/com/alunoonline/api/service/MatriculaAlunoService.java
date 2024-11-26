package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.DisciplinaAlunoResponse;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaAlunoService {

    public static final double MEDIA_PARA_APROVACAO = 7.0;

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

    public void atualizarNotas(Long matriculaAlunoId, AtualizarNotasRequest atualizarNotasRequest) {
        // Busca a matrícula do aluno pelo ID
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(matriculaAlunoId)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matrícula de Aluno não encontrada"));

        // Verifica se o front está enviando a nota 1 e atualiza
        if (atualizarNotasRequest.getNota1() != null) {
            matriculaAluno.setNota1(atualizarNotasRequest.getNota1()); // Atualiza a nota1 no objeto
        }
        // Verifica se o front está enviando a nota 2 e atualiza
        if (atualizarNotasRequest.getNota2() != null) {
            matriculaAluno.setNota2(atualizarNotasRequest.getNota2()); // Atualiza a nota2 no objeto
        }
        // Salva as alterações no banco de dados
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void calcularMedia(MatriculaAluno matriculaAluno) {
        Double nota1 = matriculaAluno.getNota1();
        Double nota2 = matriculaAluno.getNota2();

        if(nota1 != null && nota2 != null){
            Double media = (nota1 + nota2) / 2;

            //Importante pra apresentação
            matriculaAluno.setStatus(media >= MEDIA_PARA_APROVACAO ? MatriculaAlunoStatusEnum.MATRICULADO : MatriculaAlunoStatusEnum.REPROVADO);
        }
    }
    public HistoricoAlunoResponse emitirHistorico(Long alunoId) {
        List<MatriculaAluno> matriculasDoAluno = matriculaAlunoRepository.findByAlunoId(alunoId);

        if (matriculasDoAluno.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Esse aluno não possui matrículas");
        }

        // Criar o objeto de resposta para o histórico do aluno
        HistoricoAlunoResponse historicoAluno = new HistoricoAlunoResponse();
        historicoAluno.setNomeAluno(matriculasDoAluno.get(0).getAluno().getNome());
        historicoAluno.setCpfAluno(matriculasDoAluno.get(0).getAluno().getCpf());
        historicoAluno.setEmailAluno(matriculasDoAluno.get(0).getAluno().getEmail());

        // Criar a lista para armazenar as disciplinas do aluno
        List<DisciplinaAlunoResponse> disciplinaList = new ArrayList<>();

        // Iterar pelas matrículas e adicionar as disciplinas na lista
        for (MatriculaAluno matriculaAluno : matriculasDoAluno) {
            DisciplinaAlunoResponse disciplinaAlunoResponses = new DisciplinaAlunoResponse();
            disciplinaAlunoResponses.setNomeDisciplina(matriculaAluno.getDisciplina().getNome());
            disciplinaAlunoResponses.setNomeProfessor(matriculaAluno.getDisciplina().getProfessor());
            disciplinaAlunoResponses.setNota1(matriculaAluno.getNota1());
            disciplinaAlunoResponses.setNota2(matriculaAluno.getNota2());

            // Adicionar o objeto à lista
            disciplinaList.add(disciplinaAlunoResponses);
        }

        // Configurar a lista de disciplinas no histórico
        historicoAluno.setDisciplinas(disciplinaList);

        // Retornar o histórico preenchido
        return historicoAluno;
    }
}