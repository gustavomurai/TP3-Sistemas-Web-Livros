<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifsp.ads571.tp3livros.Livro" %>

<%
    List<Livro> listaLivros = (List<Livro>) request.getAttribute("listaLivros");

    if (listaLivros == null) {
        listaLivros = new java.util.ArrayList<Livro>();
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>TP3 - Sistema de Livros</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilo.css">
</head>
<body>

<div class="container">

    <div class="topo">
        <h1>Sistema de Livros - TP3</h1>
        <p>
            Aplicação web desenvolvida em Java Web utilizando JSP, Servlet, JDBC, MySQL e Apache Tomcat 9.
        </p>
    </div>

    <div class="barra-acoes">
        <a class="btn btn-primario" href="<%= request.getContextPath() %>/novo">
            + Novo Livro
        </a>

        <a class="btn btn-secundario" href="<%= request.getContextPath() %>/creditos">
            Créditos da Dupla
        </a>
    </div>

    <div class="card">
        <table class="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
            </thead>

            <tbody>
                <% if (listaLivros.isEmpty()) { %>

                    <tr>
                        <td colspan="5">
                            Nenhum livro cadastrado ainda.
                        </td>
                    </tr>

                <% } else { %>

                    <% for (Livro livro : listaLivros) { %>
                        <tr>
                            <td><%= livro.getId() %></td>
                            <td><%= livro.getTitulo() %></td>
                            <td><%= livro.getAutor() %></td>
                            <td>R$ <%= livro.getPreco() %></td>
                            <td>
                                <a class="btn btn-secundario btn-pequeno"
                                   href="<%= request.getContextPath() %>/editar?id=<%= livro.getId() %>">
                                    Editar
                                </a>

                                <a class="btn btn-perigo btn-pequeno"
                                   href="<%= request.getContextPath() %>/excluir?id=<%= livro.getId() %>"
                                   onclick="return confirm('Tem certeza que deseja excluir este livro?');">
                                    Excluir
                                </a>
                            </td>
                        </tr>
                    <% } %>

                <% } %>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>