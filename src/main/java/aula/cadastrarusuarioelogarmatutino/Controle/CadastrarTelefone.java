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

@WebServlet("/cadastrarTelefone")
public class CadastrarTelefone extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String nome = request.getParameter("numero");
//        String telefone = request.getParameter("tipo");
//        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
//
//        if(nome!=null && telefone!=null && login!=null && senha!=null &&
//                !nome.isBlank() && !telefone.isBlank()&& !login.isBlank() && !senha.isBlank()) {
//
//            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuarios");
//            boolean existe = false;
//            for (Usuario usuario : usuarios) {
//                if (usuario.getLogin().equals(login) && usuario.isAdmin()) {
//                    existe = true;
//                    break;
//                }
//            }
//            if (!existe) {
//                Usuario u = new Usuario(pegaNovoId(), nome, login, senha, isAdmin);
//                usuarios.add(u);
//                response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Cadastrado com sucesso"));
//            } else
//                response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Erro. Já existe um usuário com este login"));
//        }
//        else {
//            response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Você precisa informar todos os dados do usuário"));
//        }
//    }
//    private int pegaNovoId()
//    {
//        int serial=(Integer) getServletContext().getAttribute("serial");
//        serial++;
//        getServletContext().setAttribute("serial",serial);
//        return serial;
    }
}
