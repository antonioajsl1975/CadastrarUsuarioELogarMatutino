package aula.cadastrarusuarioelogarmatutino.Controle;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

        if(nome!=null && login!=null && senha!=null &&
                !nome.isBlank() && !login.isBlank() && !senha.isBlank()) {

            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuariosContextoApp");
            boolean existe = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getLogin().equals(login)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                Usuario u = new Usuario(pegaNovoId(), nome, login, senha, isAdmin);
                usuarios.add(u);
                response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Cadastrado com sucesso"));
            } else
                response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Erro. Já existe um usuário com este login"));
        }
        else {
            response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Você precisa informar todos os dados do usuário"));
        }
    }
    private int pegaNovoId()
    {
        int serial=(Integer) getServletContext().getAttribute("serial");
        serial++;
        getServletContext().setAttribute("serial",serial);
        return serial;
    }
}
