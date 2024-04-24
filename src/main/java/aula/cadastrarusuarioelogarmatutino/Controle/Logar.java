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

@WebServlet("/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        HttpSession sessao=request.getSession();
        if(sessao.getAttribute("usuario")==null) {
            if (login != null && senha != null && !login.isBlank() && !senha.isBlank()) {

                Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");
                boolean logou = false;
                for (Usuario u : usuarios) {
                    if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                        sessao.setAttribute("usuario", u);
                        response.sendRedirect("relatorio");
                        logou = true;
                        break;
                    }
                }
                if (!logou) {
                    response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Login ou senha incorretos"));
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Você precisa informar o login e a senha"));
            }
        }else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Já está logado"));
        }
    }
}
