package aula.cadastrarusuarioelogarmatutino.Controle;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/relatorio")
public class Relatorio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");
        //simulando buscar os dados em uma fonte de dados, por exemplo, um banco de dados.
        request.setAttribute("usuarios",usuarios);
        request.getRequestDispatcher("WEB-INF/relatorio.jsp").forward(request,response);
    }
}
