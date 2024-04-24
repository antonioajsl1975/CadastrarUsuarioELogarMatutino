package aula.cadastrarusuarioelogarmatutino.Controle;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/salvar")
public class Salvar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebendo parâmetros do formulário
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String admin = request.getParameter("admin");

        // Verificando se o ID é fornecido
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);

            // Obtendo o conjunto de usuários do contexto do servlet
            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");
            HttpSession sessao = request.getSession();
            Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuario");

            // Procurando pelo usuário com o ID correspondente
            Usuario usuarioModificado = null;
            for (Usuario u : usuarios) {
                if (u.getId() == id) {
                    usuarioModificado = u;
                    break;
                }
            }

            // Se o usuário for encontrado
            if (usuarioModificado != null && usuarioLogado.isAdmin()) {
                // Atualizando os dados do usuário
                usuarioModificado.setNome(nome);
                usuarioModificado.setTelefone(telefone);
                usuarioModificado.setSenha(senha);
                usuarioModificado.setAdmin(Boolean.parseBoolean(admin));

                // Redirecionando com mensagem de sucesso
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("Usuário atualizado com sucesso"));
            } else if (usuarioModificado != null && !usuarioLogado.isAdmin()) {
                usuarioLogado.setNome(nome);
                usuarioLogado.setTelefone(telefone);
                usuarioLogado.setSenha(senha);
                usuarioLogado.setAdmin(Boolean.parseBoolean(admin));

                // Redirecionando com mensagem de sucesso
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("Usuário atualizado com sucesso"));
                // Redirecionando com mensagem de erro se o usuário não for encontrado
            } else {
                response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("Usuário não encontrado"));
            }
        } else {
            // Redirecionando com mensagem de erro se o ID não for fornecido
            response.sendRedirect("relatorio?mensagem=" + URLEncoder.encode("ID do usuário não fornecido"));
        }
    }
}
