<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String mensagemErro = (String) request.getAttribute("mensagemErro");
    String detalheErro = (String) request.getAttribute("detalheErro");

    if (mensagemErro == null) {
        mensagemErro = "Erro desconhecido.";
    }

    if (detalheErro == null) {
        detalheErro = "";
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Erro na Aplicação</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilo.css">
</head>
<body>

<div class="container">

    <div class="topo">
        <h1>Erro na Aplicação</h1>
        <p>
            Ocorreu um problema ao executar a operação.
        </p>
    </div>

    <div class="erro">
        <strong>Mensagem:</strong>
        <p><%= mensagemErro %></p>
    </div>

    <div class="card">
        <h2>Detalhe técnico</h2>

        <pre class="codigo-erro"><%= detalheErro %></pre>

        <div class="barra-acoes">
            <a class="btn btn-secundario" href="<%= request.getContextPath() %>/listar">
                Voltar para a lista
            </a>
        </div>
    </div>

</div>

</body>
</html>