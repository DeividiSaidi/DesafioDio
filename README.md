## API de Registro de Notas Escolares
### Visão Geral
- A API de Registro de Notas Escolares foi desenvolvida para gerenciar alunos e suas notas em diferentes disciplinas. Ela permite cadastrar, atualizar, listar e excluir alunos e notas, garantindo que as informações sejam organizadas e acessíveis.
Essa API pode ser utilizada por escolas, professores e sistemas de gestão educacional, facilitando o acompanhamento do desempenho dos alunos de maneira eficiente.
## Principais Funcionalidades

### Gerenciamento de Alunos:

- Criar um novo aluno no sistema.
- Listar todos os alunos cadastrados.
- Buscar um aluno específico pelo seu ID.
- Atualizar as informações de um aluno.
- Excluir um aluno (desde que não possua notas vinculadas).

### Gerenciamento de Notas:
- Cadastrar uma nota para um aluno em uma disciplina.
- Listar todas as notas cadastradas.
- Buscar as notas de um aluno específico.
- Atualizar uma nota existente.
- Excluir uma nota.
## Estrutura do Projeto

```markdown
notasapi
│── src
│   ├── main
│   │   ├── java
│   │   │   └── me.desafio.notasapi
│   │   │       ├── config         # Configuração do banco e inicialização (DatabaseInitializer)
│   │   │       ├── controller     # Controladores da API (NotaController, AlunoController)
│   │   │       ├── dto            # Objetos de transferência de dados (NotaDTO, AlunoDTO)
│   │   │       ├── model          # Modelos de entidades (Nota, Aluno)
│   │   │       ├── repository     # Interfaces de acesso ao banco (AlunoRepository, NotaRepository)
│   │   │       ├── service        # Lógica de negócio (AlunoService, NotaService)
│   │   ├── resources
│   │   │   ├── application.properties    # Configuração do banco de dados
│   │   │   ├── schema.sql         # Script de criação do banco
│── pom.xml                         # Dependências do projeto
│── README.md                        # Documentação da API
```
## Endpoints Principais
### Alunos

- Criar um aluno
```http request
POST /alunos/create
 Corpo da requisição (JSON)
{
    "nome": "Teste3",
    "email": "teste3@gmail.com",
    "matricula": "2003"
}
```

- Listar todos os alunos
```http request
GET /alunos
```

- Buscar aluno por ID
```http request
GET /alunos/filter/{id}
```

- Atualizar aluno
```http request
PUT /alunos/update/{id}
 Corpo da requisição (JSON)
{
    "nome": "TesteFinall",
    "email": "TesteFinall@gmail.com",
    "matricula": "2002"
}
```

- Deletar aluno
```http request
DELETE /alunos/delete/{id}
```

### Notas

- Criar uma nota para um aluno
```http request
POST /notas/create/{idAluno}
 Corpo da requisição (JSON)
{
    "disciplina": "disciplina",
    "nota": 0.0
}
```

- Listar todas as notas
```http request
GET /notas
```

- Buscar notas de um aluno
```http request
GET /notas/filter/{idAluno}
```

- Atualizar nota
```http request
PUT /notas/update/{id}
 Corpo da requisição (JSON)
{
    "disciplina": "disciplina",
    "nota": 0.0
}
```

- Deletar nota
```http request
DELETE /notas/delete/{id}
```

## Tecnologias Utilizadas
- Java 17 + Spring Boot (Framework principal)
- Spring Data JPA (Interação com banco de dados)
- MySQL/PostgreSQL (Banco de dados relacional)
- Maven (Gerenciador de dependências)
- Lombok (Redução de código boilerplate)

# Como Rodar a API
- Configurar o banco de dados MySQL.
- Rodar o projeto no Spring Boot.
- Testar endpoints usando Postman(http://localhost:8080).
