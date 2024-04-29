<%@page pageEncoding="UTF-8" contentType="text/html" %>

<%@include file="WEB-INF/cabecalho.jsp"%>

<form action="salvar" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <label for="nome">Nome</label>
    <input type="text" name="nome" id="nome" placeholder="Nome" value="<%= request.getParameter("nome") %>">
    <label for="telefone">Telefone</label>
    <input type="text" name="telefone" id="telefone" placeholder="Telefone" value="<%= request.getParameter("telefone") %>">
    <label for="login">Login</label>
    <input type="text" name="login" id="login" placeholder="Login" value="<%= request.getParameter("login") %>" readonly>
    <label for="senha">Senha</label>
    <input type="password" name="senha" id="senha" placeholder="Senha" value="<%= request.getParameter("senha") %>" >
    <label for="admin">Admin</label>
    <input type="text" name="admin" id="admin" placeholder="Admin?" value="<%= request.getParameter("isAdmin") %>"></input>
    <input type="submit" value="Salvar">
</form>
