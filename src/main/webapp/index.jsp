<%@ page import="java.util.Set" %>
<%@page pageEncoding="UTF-8" contentType="text/html" %>

<%@include file="WEB-INF/cabecalho.jsp" %>

<form action="cadastrar" method="post">
    <label for="nome">Nome</label>
    <input type="text" name="nome" id="nome" placeholder="Nome">
    <label for="login">Login</label>
    <input type="text" name="login" id="login" placeholder="Login">
    <label for="senha">Senha</label>
    <input type="password" name="senha" id="senha" placeholder="Senha">
    <%
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioSessao");
        if (session.getAttribute("usuarioSessao") != null && usuarioLogado.isAdmin()) {
    %>
    <label for="admin">Admin</label>
    <input type="checkbox" name="admin" id="admin" placeholder="Admin?">
    <%
        }
    %>
    <input type="submit" value="Cadastrar">
</form>
<%
    if (session.getAttribute("usuarioSessao") == null) {
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

<%
//    Set<Usuario> usuarios = (Set<Usuario>) request.getAttribute("usuariosContextoApp");
//    for (Usuario u : usuarios) {
        if (session.getAttribute("usuarioSessao") != null) {
%>
<form action="cadastrarTelefone" method="post">
    <label for="numeroTelefone">Número de Telefone:</label>
    <input type="tel" id="numeroTelefone" name="numeroTelefone" required>

    <label for="tipo"> Tipo </label>
    <select name="tipo" id="tipo">
        <option value="">Selecione...</option>
        <option value="op">Celular</option>
        <option value="op">Residencial</option>
        <option value="op">Comercial</option>
    </select>
    <button type="submit">Cadastrar</button>
</form>
<%
//        }
    }
%>