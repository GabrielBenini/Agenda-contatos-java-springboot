
# 📚 Agenda de Contatos Simples – API REST

Este é um projeto Java com Spring Boot que simula um sistema básico de agenda de contatos. Ele permite o cadastro, listagem, atualização e remoção de contatos, com algumas regras de negócio aplicadas.

## 🚀 Tecnologias Utilizadas


- Java 17

- Spring Boot

- Spring Data JPA

- PostgreSQL

- Maven

- Lombok

- Postman (para testes)

- Docker (para banco local, opcional)

## 🏛️ Entidades

### 📘 Contatos

- id: Long

- nome: String

- email: String

- telefone: String

## 📂 Estrutura do Projeto

- model: Entidades JPA (Contatos)

- repository: Interfaces do Spring Data JPA

- service: Regras de negócio implementadas

- controller: Endpoints da API REST

- dto: Camada de transferência de dados (Request e Response)

## 🔄 Endpoints Principais

### Contatos
- POST /contatos: Cadastrar autor

- GET /contatos: Listar todos

- GET /contatos/{id}: Buscar por ID

- PUT /contatos/{id}: Atualizar

- DELETE /contatos/{id}: Remover


## 🧪 Testes

Os testes foram realizados via Postman, utilizando dados simulados.

## 🧾 Observações
- A API utiliza o padrão DTO para comunicação.

- Exceções são tratadas com mensagens claras de erro.

- Projeto com foco em boas práticas de arquitetura em camadas.

