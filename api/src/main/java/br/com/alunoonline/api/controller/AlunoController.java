// O aluno controller vai conter as coisas do front

package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //aqui e a conexão com o front
@RequestMapping("/alunos") // Aqui e o mapeamento de aluno, tipo um caminho como o do uol noticias que o caminho e /noticias
public class AlunoController {

    @Autowired // Essa anotação e muito importante pois ela serve para fazer a injeção de dependencias, por exemplo injetar tudo que esta em repository em service, assim o service consegue ate mesmo acesso ao banco de dados
    AlunoService alunoService;

    // Abaixo estão os coisinhas do insomnia (explicar melhor dps)

    @PostMapping // Post para criar aluno
    @ResponseStatus(HttpStatus.CREATED) // O responsestatus e para
    public void criarAluno(@RequestBody Aluno aluno) { // O spring vai converter o json em java, já RequestBody ta mandando o json pra o corpo da rquisição

        alunoService.criarAluno(aluno);
    }

    @GetMapping // Get para buscar alunos
    @ResponseStatus(HttpStatus.OK) // Aqui ta mapeando as respostas como um get bem sucedido
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}") // Isso aqui e pra transformar o id em uma URL
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable long id) {
        alunoService.deleteAlunoPorId(id); // Aqui so e possivel por conta da injeção do service la encima
    }

    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAlunoPorId(@PathVariable long id, Aluno aluno) {
        alunoService.atualizarAlunoPorId(id, aluno);
    }
}