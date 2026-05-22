# TP3 - Sistema Web de Livros

Projeto desenvolvido para a atividade TP3 da disciplina **CBTSWE - ADS 571**, do curso de **Análise e Desenvolvimento de Sistemas** do **Instituto Federal de Educação, Ciência e Tecnologia de São Paulo - Campus Cubatão**.

O sistema implementa um CRUD de livros utilizando Java Web, seguindo a proposta indicada pelo professor.

## Informações da atividade

- **Instituição:** Instituto Federal de Educação, Ciência e Tecnologia de São Paulo - Campus Cubatão
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Disciplina:** CBTSWE - ADS 571
- **Professor:** Wellington Tuler Moraes
- **Atividade:** TP3 - Sistema Web de Livros
- **Tema:** CRUD de livros com JSP, Servlet, JDBC e MySQL

## Integrantes da dupla

- Gustavo Murai
- Igor Murai

## Objetivo do projeto

O objetivo deste projeto é implementar uma aplicação web simples para gerenciamento de livros, permitindo realizar as operações básicas de um CRUD:

- Cadastrar livros
- Listar livros
- Editar livros
- Excluir livros
- Visualizar página de créditos da dupla

A aplicação utiliza banco de dados MySQL para armazenar as informações dos livros.

## Tecnologias utilizadas

- Java
- JSP
- Servlet
- JDBC
- MySQL
- Apache Tomcat 9
- Eclipse IDE
- Maven
- HTML
- CSS

## Funcionalidades implementadas

### Listagem de livros

A tela inicial exibe todos os livros cadastrados no banco de dados, mostrando:

- ID
- Título
- Autor
- Preço
- Ações de editar e excluir

### Cadastro de livro

O sistema permite cadastrar um novo livro informando:

- Título
- Autor
- Preço

Após o cadastro, o livro é salvo no banco de dados MySQL e exibido na listagem.

### Edição de livro

O sistema permite editar um livro existente. Ao clicar em **Editar**, o formulário é carregado com os dados atuais do livro selecionado.

Após salvar, as alterações são atualizadas no banco de dados.

### Exclusão de livro

O sistema permite excluir um livro cadastrado. Ao clicar em **Excluir**, o registro é removido do banco de dados.

### Página de créditos

Foi criada uma página específica de créditos da dupla, contendo informações sobre a atividade, integrantes e tecnologias utilizadas.

Essa página atende ao diferencial solicitado na atividade.

## Estrutura do projeto

```text
TP3_SistemasWeb1/
│
├── banco/
│   └── script_criacao_banco.sql
│
└── TP3Livros/
    │
    ├── pom.xml
    │
    └── src/
        └── main/
            ├── java/
            │   └── br/
            │       └── edu/
            │           └── ifsp/
            │               └── ads571/
            │                   └── tp3livros/
            │                       ├── Livro.java
            │                       ├── LivroDAO.java
            │                       └── LivroController.java
            │
            └── webapp/
                ├── css/
                │   └── estilo.css
                ├── index.jsp
                ├── livro-lista.jsp
                ├── livro-formulario.jsp
                ├── creditos.jsp
                ├── erro.jsp
                └── WEB-INF/
                    └── web.xml
