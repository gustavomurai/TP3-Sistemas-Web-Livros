<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Créditos da Dupla</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilo.css">
</head>
<body>

<div class="container">

    <div class="topo">
        <h1>Créditos da Dupla</h1>
        <p>
            Página criada como diferencial da atividade TP3 de Sistemas Web 1.
        </p>
    </div>

    <div class="card">
        <h2>Informações do Trabalho</h2>

        <ul class="creditos-lista">
            <li><strong>Instituição:</strong> Instituto Federal de São Paulo - Campus Cubatão</li>
            <li><strong>Curso:</strong> Análise e Desenvolvimento de Sistemas</li>
            <li><strong>Matéria:</strong> CBTSWE - ADS 571</li>
            <li><strong>Professor:</strong> Wellington Tuler Moraes</li>
            <li><strong>Atividade:</strong> TP3 - Sistema Web de Livros com CRUD</li>
        </ul>

        <h2>Integrantes</h2>

        <ul class="creditos-lista">
            <li><strong>Integrante 1:</strong> Gustavo Murai</li>
            <li><strong>Integrante 2:</strong> Igor Murai</li>
        </ul>

        <h2>Tecnologias Utilizadas</h2>

        <ul class="creditos-lista">
            <li>Java</li>
            <li>JSP</li>
            <li>Servlet</li>
            <li>JDBC</li>
            <li>MySQL</li>
            <li>Apache Tomcat 9</li>
            <li>Eclipse IDE</li>
        </ul>

        <div class="barra-acoes">
            <a class="btn btn-secundario" href="<%= request.getContextPath() %>/listar">
                Voltar para a lista
            </a>
        </div>
    </div>

</div>

</body>
</html>