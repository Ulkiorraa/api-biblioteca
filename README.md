# API de Biblioteca

Esta API fornece um sistema de gerenciamento para uma biblioteca, permitindo operações CRUD (Criar, Ler, Atualizar, Deletar) em livros e autores.

## Estrutura

A API segue a estrutura típica de um projeto Spring Boot, organizada da seguinte forma:

- `src/main/java`
    - `com.suaempresa.api`
        - `controller` - Contém os controladores REST.
        - `dto` - Data Transfer Objects para transferir dados entre sub-sistemas.
        - `entity` - Entidades JPA representando tabelas do banco de dados.
        - `mapper` - Mappers para converter entidades em DTOs e vice-versa.
        - `repository` - Repositórios JPA para operações de banco de dados.
        - `service` - Serviços que contêm lógica de negócios.
- `src/main/resources`
    - `application.properties` - Configurações da aplicação.

## Tecnologias Usadas

- **Spring Boot** - Framework para facilitar a configuração e o deployment de aplicações baseadas em Spring.
- **Spring Data JPA** - Facilita a implementação de repositórios baseados em JPA.
- **H2 Database** - Banco de dados em memória para testes e desenvolvimento.
- **Lombok** - Biblioteca para reduzir código boilerplate em Java (Getters, Setters, Constructors).

## Como Usar

Para utilizar esta API, siga os passos abaixo:

1. Clone o repositório:
    ```bash
    git clone https://github.com/Ulkiorraa/api-biblioteca.git
    ``` 
2. Navegue até a pasta do projeto e execute:
    ```bash
    mvn spring-boot:run
    ```
3. A API estará disponível em `http://localhost:8080`.

## Endpoints

A API define endpoints para operações CRUD nos recursos `Livro` e `Autor`.

### Livros

- **Criar Livro [POST `/livros`]**
    - Endpoint: `/livros`
    - Método: POST
    - Corpo da requisição: JSON com `titulo`, `isbn` e `autorId`
    - Exemplo:
      ```json
      {
        "titulo": "O Nome do Vento",
        "isbn": "123456789",
        "autorId": 1
      }
      ```

- **Listar Livros [GET `/livros`]**
    - Endpoint: `/livros`
    - Método: GET

- **Buscar Livro por ID [GET `/livros/{id}`]**
    - Endpoint: `/livros/{id}`
    - Método: GET
    - Substitua `{id}` pelo ID do livro desejado.

- **Atualizar Livro [PUT `/livros/{id}`]**
    - Endpoint: `/livros/{id}`
    - Método: PUT
    - Substitua `{id}` pelo ID do livro.
    - Corpo da requisição: JSON com `titulo`, `isbn` e `autorId`
    - Exemplo:
      ```json
      {
        "titulo": "O Temor do Sábio",
        "isbn": "987654321",
        "autorId": 1
      }
      ```

- **Deletar Livro [DELETE `/livros/{id}`]**
    - Endpoint: `/livros/{id}`
    - Método: DELETE
    - Substitua `{id}` pelo ID do livro.

### Autores

- **Criar Autor [POST `/autores`]**
    - Endpoint: `/autores`
    - Método: POST
    - Corpo da requisição: JSON com `nome`
    - Exemplo:
      ```json
      {
        "nome": "Patrick Rothfuss"
      }
      ```

- **Listar Autores [GET `/autores`]**
    - Endpoint: `/autores`
    - Método: GET

- **Buscar Autor por ID [GET `/autores/{id}`]**
    - Endpoint: `/autores/{id}`
    - Método: GET
    - Substitua `{id}` pelo ID do autor.

- **Atualizar Autor [PUT `/autores/{id}`]**
    - Endpoint: `/autores/{id}`
    - Método: PUT
    - Substitua `{id}` pelo ID do autor.
    - Corpo da requisição: JSON com `nome`
    - Exemplo:
      ```json
      {
        "nome": "Patrick Rothfuss"
      }
      ```

- **Deletar Autor [DELETE `/autores/{id}`]**
    - Endpoint: `/autores/{id}`
    - Método: DELETE
    - Substitua `{id}` pelo ID do autor.

Para mais detalhes, consulte a documentação da API ou os controladores no código-fonte.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
