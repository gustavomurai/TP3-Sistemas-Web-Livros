<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.edu.ifsp.ads571.tp3livros.Livro" %>

<%
    Livro livro = (Livro) request.getAttribute("livro");

    boolean edicao = livro != null;

    String tituloPagina = edicao ? "Editar Livro" : "Cadastrar Novo Livro";

    String acaoFormulario = request.getContextPath() + (edicao ? "/atualizar" : "/inserir");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title><%= tituloPagina %></title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilo.css">
</head>
<body>

<div class="container">

    <div class="topo">
        <h1><%= tituloPagina %></h1>
        <p>
            Preencha os dados abaixo para salvar o livro no banco de dados.
        </p>
    </div>

    <div class="card">

        <form class="formulario" action="<%= acaoFormulario %>" method="post">

            <% if (edicao) { %>
                <input type="hidden" name="id" value="<%= livro.getId() %>">
            <% } %>

            <div class="campo">
                <label for="titulo">Título do Livro</label>
                <input
                    type="text"
                    id="titulo"
                    name="titulo"
                    maxlength="150"
                    required
                    value="<%= edicao ? livro.getTitulo() : "" %>">
            </div>

            <div class="campo">
                <label for="autor">Autor</label>
                <input
                    type="text"
                    id="autor"
                    name="autor"
                    maxlength="100"
                    required
                    value="<%= edicao ? livro.getAutor() : "" %>">
            </div>

            <div class="campo">
                <label for="preco">Preço</label>
                <input
                    type="number"
                    id="preco"
                    name="preco"
                    step="0.01"
                    min="0"
                    required
                    value="<%= edicao ? livro.getPreco() : "" %>">
            </div>

            <div class="rodape-formulario">
                <button class="btn btn-primario" type="submit">
                    Salvar
                </button>

                <a class="btn btn-secundario" href="<%= request.getContextPath() %>/listar">
                    Cancelar
                </a>
            </div>

        </form>

    </div>

</div>

</body>
</html>