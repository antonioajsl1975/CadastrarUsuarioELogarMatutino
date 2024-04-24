<%@ page import="java.util.Set" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="cabecalho.jsp" %>

<div class="container">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Login</th>
            <th>Admin</th>
            <th>Senha</th>
            <th>Deletar</th>
            <th>Editar</th>
            <th>Editar com JavaScript</th>
        </tr>
        </thead>
        <tbody>
        <% Set<Usuario> usuarios = (Set<Usuario>) request.getAttribute("usuarios");
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            for (Usuario u : usuarios) { %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getNome() %></td>
            <td><%= u.getTelefone() %></td>
            <td><%= u.getLogin() %></td>
            <td><%= u.isAdmin() %></td>
            <td>
                <% if (usuarioLogado != null && usuarioLogado.isAdmin() || (usuarioLogado != null && usuarioLogado.equals(u) && !usuarioLogado.isAdmin())) { %>
                <%= u.getSenha() %>
                <% } else { %>
                ****
                <% } %>
            </td>
            <td>
                <% if (usuarioLogado != null && usuarioLogado.isAdmin() || (usuarioLogado != null && usuarioLogado.equals(u) && !usuarioLogado.isAdmin())) { %>
                <a href="deletar?id=<%= u.getId() %>" class="btn btn-danger">Deletar</a>
                <% } else { %>
                Deletar
                <% } %>
            </td>
            <td>
                <% if (usuarioLogado != null && usuarioLogado.isAdmin() || (usuarioLogado != null && usuarioLogado.equals(u))) { %>
                <form action="editar.jsp" method="post">
                    <input type="hidden" name="id" value="<%= u.getId() %>">
                    <input type="hidden" name="nome" value="<%= u.getNome() %>">
                    <input type="hidden" name="telefone" value="<%= u.getTelefone() %>">
                    <input type="hidden" name="login" value="<%= u.getLogin() %>">
                    <input type="hidden" name="senha" value="<%= u.getSenha() %>">
                    <input type="hidden" name="admin" value="<%= u.isAdmin() %>">
                    <button type="submit" class="btn btn-primary">Editar</button>
                </form>
                <% } else { %>
                <a href="#" class="btn btn-primary disabled">Editar</a>
                <% } %>
            </td>
            <td>
                <a href="#" class="mostrarformulario btn btn-secondary">Editar com JavaScript</a>
                <form action="salvar" method="post" class="oculto">
                    <input type="hidden" name="id" value="<%= u.getId() %>">
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" class="form-control" placeholder="Nome" value="<%= u.getNome() %>">
                    <label for="telefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" class="form-control" placeholder="Telefone" value="<%= u.getTelefone() %>">
                    <label for="login">Login</label>
                    <input type="text" name="login" id="login" class="form-control" placeholder="Login" value="<%= u.getLogin() %>" readonly>
                    <label for="senha">Senha</label>
                    <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" value="<%= u.getSenha() %>">
                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<script src="codigo.js"></script>
