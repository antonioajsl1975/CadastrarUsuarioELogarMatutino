<%@ page import="aula.cadastrarusuarioelogarmatutino.Modelo.Usuario" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Login</title>
    <link rel="stylesheet" href="estilo.css">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("mensagem")!=null)
        {
    %>
        <div class="mensagem">
            <%= request.getParameter("mensagem")%>
        </div>
    <%
        }
    %>
    <header>
        <h1>Sistema de Login</h1>
        <%
            if(session.getAttribute("usuarioSessao")!=null)
            {
        %>
            <h2>Seja bem-vindo, <%= ((Usuario)session.getAttribute("usuarioSessao")).getNome()
            %></h2>

        <%
            }
        %>
    </header>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="relatorio">Relatorio</a>
        <%
            if(session.getAttribute("usuarioSessao")!=null)
            {
        %>
            <a href="sair">Sair</a>
        <%
            }
        %>
    </nav>
