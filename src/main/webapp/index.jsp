<%@page pageEncoding="UTF-8" contentType="text/html" %>

<%@include file="WEB-INF/cabecalho.jsp"%>

    <form action="cadastrar" method="post">
        <label for="nome">Nome</label>
        <input type="text" name="nome" id="nome" placeholder="Nome">
        <label for="telefone">Telefone</label>
        <input type="text" name="telefone" id="telefone" placeholder="Telefone">
        <label for="login">Login</label>
        <input type="text" name="login" id="login" placeholder="Login">
        <label for="senha">Senha</label>
        <input type="password" name="senha" id="senha" placeholder="Senha">
        <label for="admin">Admin</label>
        <input type="checkbox" name="admin" id="admin" placeholder="Admin?">
        <input type="submit" value="Cadastrar">
    </form>
<%
    if(session.getAttribute("usuario")==null)
    {
%>
    <form action="logar" method="post">
        <label for="login2">Login</label>
        <input type="text" name="login" id="login2" placeholder="Login">
        <label for="senha2">Senha</label>
        <input type="password" name="senha" id="senha2" placeholder="Senha">
        <input type="submit" value="Logar">
    </form>
<%
    }
%>