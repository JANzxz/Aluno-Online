# Aluno online

A API aluno online e um sistema que permite o gerenciamento de alunos, professores, disciplinas e matriculas. Permitindo também criação, atualização, listagem e exclusão de registros, além de cálculos como a média de notas.


## Como baixar as dependencias:

* Será nescessario acessar o site start.spring.io e baixar as seguintes dependências Spring Web, Spring Data JPA, PostgresSQL Driver, Lombok.
* Ápós baixa-las ultilize a IDE de sua preferencia e abra com ela a pasta api que foi baixada no site.
* Configure sua IDE.


## O programa possui 7 arquivos principais:

1. Controller: Lida com as requisições HTTP, como adicionar um aluno.
2. Model: Para modelar os atributos de aluno.
3. Repository: Para fazer a ponte entre java e o banco de dados.
4. Service: Cuida da regra de negócios, como regras para criar um aluno.
5. DTOs: Objetos para transferir dados entre as camadas.
6. Enums: Definições de constantes para facilitar o gerenciamento de status.
7. Config: Para configurar o Swagger.


## Explicando as anotações ultilizadas:

### Anotações usadas no Controller

- **`@RestController`**: Define a classe como um controlador RESTful, permitindo que responda a requisições HTTP e envie dados.
- **`@RequestMapping("/alunos")`**: Define o caminho base para todos os métodos na classe.
- **`@PostMapping`**: Mapeia o método para lidar com requisições HTTP POST.
- **`@ResponseStatus(HttpStatus.CREATED)`**: Define o código de status HTTP retornado quando o método é executado com sucesso.
- **`@RequestBody`**: Converte o corpo da requisição JSON em um objeto Java.
- **`@Autowired`**: Permite a injeção automática de dependências pelo Spring.eção automática de dependências pelo Spring.
- **`@GetMapping`**: Usada para mapear requisições HTTP GET.
- **`@DeleteMapping`**: Usada para mapear requisições HTTP DELETE.
- **`@PutMapping`**: Mapeia o método para lidar com requisições HTTP PUT.
- **`@PathVariable`**: Captura valores específicos da URL.
- **`@PatchMapping`**: Mapeia requisições HTTP do tipo PATCH.

### Anotações usadas no Model

- **`@Entity`**: Marca a classe como uma entidade JPA, representando uma tabela no banco de dados.
- **`@Id`**: Define o campo como a chave primária da entidade.
- **`@GeneratedValue(strategy = GenerationType.IDENTITY)`**: Configura a geração automática do valor da chave primária.
- **`@NoArgsConstructor`**: Gera um construtor sem argumentos.
- **`@AllArgsConstructor`**: Gera um construtor com todos os parâmetros.
- **`@Data`**: Gera métodos getters, setters, `equals`, `hashCode`, e `toString`.
- **`@ManyToOne`**: define um relacionamento entre duas entidades em que muitos registros de uma tabela se relacionam com um registro de outra tabela.
- **`@JoinColumn`**: Em um relacionamento de muitos-para-um (@ManyToOne) ou um-para-um (@OneToOne), se usa @JoinColumn para indicar a coluna que conecta as duas tabelas.
- **`@Enumerated`**: Usada para mapear um campo de uma entidade que contém um tipo enumerado (enum) para uma coluna no banco de dados.

### Anotações usadas no Repository

- **`@Repository`**: Marca a interface como um repositório de dados, facilitando a integração com o banco de dados.

### Anotações usadas no Service

- **`@Service`**: Marca a classe como um serviço Spring, contendo a lógica de negócios.
- **`@Autowired`**: Permite a injeção automática de dependências pelo Spring.eção automática de dependências pelo Spring.


## Funcionalidades Principais:

### Aluno
- Criar Aluno: Registra um novo aluno no sistema.
- Listar Alunos: Retorna todos os alunos cadastrados.
- Buscar Aluno por ID: Retorna os dados de um aluno específico.
- Atualizar Aluno: Permite alterar informações do aluno.
- Deletar Aluno: Remove um aluno do sistema.

### Professor
- Criar Professor: Adiciona um novo professor ao sistema.
- Listar Professores por Disciplina: Associa disciplinas aos professores.

### Matricula
- Criar Matrícula: Permite que um aluno seja matriculado em uma disciplina.
- Atualizar Notas: Modifica as notas de um aluno em uma disciplina.
- Calcular Média: Calcula a média das notas e define o status do aluno (Aprovado/Reprovado).
- Trancar Matrícula: Altera o status da matrícula para "Trancado".

### Disciplina
- Criar Disciplina: Adiciona uma disciplina ao sistema.
- Listar Disciplinas de um Professor: Filtra disciplinas por professor.


## Endpoints

### Aluno
- POST /alunos: Cria um novo aluno.
- GET /alunos: Retorna todos os alunos.
- GET /alunos/{id}: Retorna os dados de um aluno específico.
- DELETE /alunos/{id}: Remove um aluno.
- PUT /alunos/{id}: Atualiza as informações de um aluno.

### Professor
- POST /professores: Adiciona um novo professor.
- GET /disciplinas/{professorId}: Lista as disciplinas de um professor.

### Disciplina
- POST /disciplinas: Cria uma nova disciplina.

### Matricula
- POST /matriculas-alunos: Cria uma nova matrícula.
- PATCH /matriculas-alunos/trancar/{id}: Tranca uma matrícula.
- PATCH /matriculas-alunos/atualiza-notas/{id}: Atualiza as notas de um aluno.


## Swagger

O Swagger é uma ferramenta que facilita a documentação e o teste das APIs RESTful. Ele gera automaticamente uma interface gráfica que permite explorar os endpoints disponíveis, visualizar os modelos de dados e testar requisições diretamente no navegador.


## DTO

DTO significa Data Transfer Object (Objeto de Transferência de Dados). Ele é uma classe usada para transportar dados entre diferentes camadas ou partes de um sistema, geralmente entre o Controller e o Service de uma aplicação.