package aula.cadastrarusuarioelogarmatutino.Controle;

import aula.cadastrarusuarioelogarmatutino.Modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession sessao=request.getSession();
       if(sessao.getAttribute("usuario")!=null)
       {
           sessao.invalidate();
           response.sendRedirect("index.jsp");
       }
       else {
           response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Você nem estava logado!"));
       }
    }
}
